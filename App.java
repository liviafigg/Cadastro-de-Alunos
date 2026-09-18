import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.io.File;
import menu.*;
import IO.*;

public class App {
    public static void main(String args[]) {
        
        // =========================================================
        // Mude para 'false' para texto puro ou 'true' para janelas
        // =========================================================
        boolean usarModoGrafico = true; 

        IEntradaSaida io = usarModoGrafico ? new IOGrafico() : new IOTexto();
        IMenu mn = usarModoGrafico ? new MenuGrafico() : new MenuTexto();
        String inputAux = null;

        try {
            inputAux = io.lerString("Capacidade do cadastro: ");
            if (inputAux == null) return;
            int qtde = Integer.parseInt(inputAux);
            
            // CORREÇÃO: Agora usa o IO padronizado para escolher a Estrutura de Dados
            String menuED = "Qual Estrutura de Dados deseja utilizar?\n" +
                            "1 - Vetor Customizado\n" +
                            "2 - ArrayList (Lista Java)\n" +
                            "Opção: ";
                            
            inputAux = io.lerString(menuED);
            if (inputAux == null) return; 
            int tipoED = Integer.parseInt(inputAux);
            if (tipoED < 1 || tipoED > 2) throw new Exception("Opção de Estrutura de Dados inválida.");
            
            // Instancia o Cadastro passando o limite e a escolha
            CadastroAlunos ca = new CadastroAlunos(qtde, tipoED);
            
            String [] itensMenu = {"1 - Inserir", "2 - Remover", "3 - Listar", "4 - Atualizar", "5 - Salvar Arquivo", "6 - Ler Arquivo", "7 - Sair"};

            int opcao = 0;
            do {
                try {
                    opcao = mn.criarMenu(itensMenu);
                    
                    switch(opcao){
                        case 1:
                            String nome = io.lerString("Nome: "); if (nome == null) break;
                            inputAux = io.lerString("Idade: "); if (inputAux == null) break;
                            int idade = Integer.parseInt(inputAux);
                            String ra = io.lerString("RA: "); if (ra == null) break;
                            String curso = io.lerString("Curso: "); if (curso == null) break;
                            inputAux = io.lerString("Semestre: "); if (inputAux == null) break;
                            int sem = Integer.parseInt(inputAux);
                            
                            ca.inserirA(nome, idade, ra, curso, sem);
                            io.mostrarMensagem("Aluno inserido com sucesso!");
                            break;
                            
                        case 2:
                            String raRem = io.lerString("RA para remover: ");
                            if (raRem != null) {
                                ca.removerA(raRem);
                                io.mostrarMensagem("Aluno removido com sucesso!");
                            }
                            break;
                            
                        case 3:
                            String resp = io.lerString("Usar formato bibliográfico? (S/N): ");
                            if (resp == null) break;
                            io.mostrarMensagem(ca.listarA(resp.trim().equalsIgnoreCase("S")));
                            break;
                            
                        case 4:
                            String raAtu = io.lerString("Digite o RA do aluno que deseja atualizar: ");
                            if (raAtu == null) break;
                            if (!ca.existeAluno(raAtu)) {
                                io.mostrarMensagem("Erro: Aluno não encontrado!"); break; 
                            }
                            
                            String menuAtu = "O que deseja alterar?\n1 - Nome\n2 - Idade\n3 - RA\n4 - Curso\n5 - Semestre\nOpção: ";
                            inputAux = io.lerString(menuAtu); if (inputAux == null) break;
                            int opcAtu = Integer.parseInt(inputAux);
                            
                            String novoValor = io.lerString("Digite o novo valor: "); if (novoValor == null) break;
                            ca.atualizarAlunoA(raAtu, opcAtu, novoValor);
                            io.mostrarMensagem("Dados atualizados!");
                            break;
                            
                        case 5: // SALVAR ARQUIVO (Com correção de Modo Texto vs Gráfico)
                            String caminhoSalvar;
                            if (usarModoGrafico) {
                                JFileChooser saveChooser = new JFileChooser();
                                saveChooser.setDialogTitle("Salvar Cadastro de Alunos");
                                if (saveChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                                    caminhoSalvar = saveChooser.getSelectedFile().getAbsolutePath();
                                } else {
                                    break; // cancelou a janela
                                }
                            } else {
                                caminhoSalvar = io.lerString("Digite o nome do arquivo para salvar (ex: alunos.dat): ");
                                if (caminhoSalvar == null || caminhoSalvar.trim().isEmpty()) break;
                            }
                            
                            ca.salvarArquivo(caminhoSalvar);
                            io.mostrarMensagem("Cadastro salvo com sucesso em: " + caminhoSalvar);
                            break;

                        case 6: // LER ARQUIVO (Com correção de Modo Texto vs Gráfico)
                            String caminhoAbrir;
                            if (usarModoGrafico) {
                                JFileChooser openChooser = new JFileChooser();
                                openChooser.setDialogTitle("Abrir Cadastro de Alunos");
                                if (openChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                                    caminhoAbrir = openChooser.getSelectedFile().getAbsolutePath();
                                } else {
                                    break; // cancelou a janela
                                }
                            } else {
                                caminhoAbrir = io.lerString("Digite o nome do arquivo que deseja abrir (ex: alunos.dat): ");
                                if (caminhoAbrir == null || caminhoAbrir.trim().isEmpty()) break;
                            }
                            
                            ca.lerArquivo(caminhoAbrir);
                            io.mostrarMensagem("Cadastro carregado com sucesso!");
                            break;

                        case 7:
                            io.mostrarMensagem("Encerrando o sistema...");
                            break;
                            
                        default:
                            io.mostrarMensagem("Opção inválida.");
                    }
                    
                } catch (NumberFormatException e) {
                    io.mostrarMensagem("Erro de formato: Digite apenas números válidos.");
                } catch (Exception e) {
                    io.mostrarMensagem("Atenção: " + e.getMessage());
                }
                
            } while(opcao != 7);
            
        } catch (Exception e) {
            io.mostrarMensagem("Erro crítico: " + e.getMessage());
        }
    }
}