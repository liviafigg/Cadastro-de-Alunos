import java.io.*; // Necessário para manipular arquivos

public class CadastroAlunos {
    private IArmazenador arm; 
    private int limite;

    /**
     * Atualizado: Agora recebe o tipo de estrutura de dados que o usuário deseja usar.
     * 1 = Vetor Customizado, 2 = ArrayList (Java nativo)
     */
    public CadastroAlunos(int qtde, int tipoED) {
        if (tipoED == 2) {
            this.arm = new Lista(); // Usa a Lista com ArrayList
        } else {
            this.arm = new Vetor(); // Usa o Vetor manual
        }
        this.limite = qtde;
    }
    
    // ==========================================
    // NOVOS MÉTODOS DE PERSISTÊNCIA EM ARQUIVO
    // ==========================================

    public void salvarArquivo(String caminhoArquivo) throws Exception {
        // Cria o fluxo de saída para gravar o objeto IArmazenador inteiro no arquivo
        FileOutputStream fos = new FileOutputStream(caminhoArquivo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        oos.writeObject(this.arm);
        
        oos.close();
        fos.close();
    }

    public void lerArquivo(String caminhoArquivo) throws Exception {
        // Cria o fluxo de entrada para ler o arquivo e reconstruir a estrutura de dados
        FileInputStream fis = new FileInputStream(caminhoArquivo);
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        // Substitui a estrutura de dados atual pela que estava salva no arquivo
        this.arm = (IArmazenador) ois.readObject();
        
        ois.close();
        fis.close();
    }

    // ==========================================
    // MÉTODOS EXISTENTES MANTIDOS
    // ==========================================

    public void inserirA(String nome, int idade, String ra, String curso, int semestre) 
           throws IdadeInvalidaException, ArrayIndexOutOfBoundsException, Exception {
               
        if (arm.getQtd() >= limite) throw new ArrayIndexOutOfBoundsException("Capacidade máxima atingida!");
        if (buscarIndicePorRa(ra) != -1) throw new Exception("O RA " + ra + " já está cadastrado!");
        if (idade < 17 || idade > 100) throw new IdadeInvalidaException("Idade fora do intervalo permitido (17 a 100 anos).");

        Aluno novo = new Aluno(nome, idade, ra, curso, semestre);
        arm.adicionar(novo);
    }

    public void removerA(String ra) throws Exception {
        int idx = buscarIndicePorRa(ra);
        if (idx == -1) throw new Exception("Aluno com RA " + ra + " não encontrado!");
        arm.remover(idx);
    }

    public String listarA(boolean bibliografico) throws Exception {
        if (arm.estaVazia()) throw new Exception("O cadastro está vazio.");
        
        String lista = "=== Lista de Alunos ===\n";
        for (int i = 0; i < arm.getQtd(); i++) {
            Aluno a = (Aluno) arm.buscar(i);
            if (bibliografico) {
                lista += a.getNomeBiblio() + " (RA: " + a.getRa() + ")\n";
            } else {
                lista += a.toString() + "\n----------------\n";
            }
        }
        return lista;
    }

    public void atualizarAlunoA(String ra, int opcao, String novoValor) throws IdadeInvalidaException, NumberFormatException, Exception {
        int idx = buscarIndicePorRa(ra);
        if (idx == -1) throw new Exception("Aluno com RA " + ra + " não encontrado!");
        
        Aluno a = (Aluno) arm.buscar(idx);
        
        switch (opcao) {
            case 1: a.setNome(novoValor); break;
            case 2: 
                int novaIdade = Integer.parseInt(novoValor);
                if (novaIdade < 17 || novaIdade > 100) throw new IdadeInvalidaException("Idade inválida.");
                a.setIdade(novaIdade); break;
            case 3: 
                if (buscarIndicePorRa(novoValor) != -1) throw new Exception("RA já existe!");
                a.setRa(novoValor); break;
            case 4: a.setCurso(novoValor); break;
            case 5: a.setSemestre(Integer.parseInt(novoValor)); break;
            default: throw new Exception("Opção inválida!");
        }
    }

    public boolean existeAluno(String ra) {
        return buscarIndicePorRa(ra) != -1;
    }

    private int buscarIndicePorRa(String ra){
        if (ra == null) return -1;
        for (int i = 0; i < arm.getQtd(); i++) {
            Aluno a = (Aluno) arm.buscar(i);
            if (a != null && a.getRa().equals(ra)) return i;
        }
        return -1;
    }
}