import javax.swing.JOptionPane;

public class Main {
  public static void main(String[] args) {
    Vetor vetor = new Vetor();
    int escolha = -1;
    StringBuilder menu = new StringBuilder();
    menu.append("O que você deseja fazer?");
    menu.append("\n\n[1]  Inserir objeto");
    menu.append("\n[2]  Inserir em posição x");
    menu.append("\n[3]  Remover na posição x");
    menu.append("\n[4]  Obter objeto por posição");
    menu.append("\n[5]  Contém objeto?");
    menu.append("\n[6]  Tamanho da lista");
    menu.append("\n[7]  Remover objeto");
    menu.append("\n[8]  Limpar lista");
    menu.append("\n[9]  Primeira ocorrência de x");
    menu.append("\n[10] Última ocorrência de x");
    menu.append("\n[11] Listar elementos");
    menu.append("\n[0]  Sair");
    menu.append("\n\nOpção");
    while (escolha != 0) {
      escolha = Integer.valueOf(JOptionPane.showInputDialog(menu));
      String objeto;
      int posicao = -1;

      switch (escolha) {
        case 1:
          objeto = JOptionPane.showInputDialog("Objeto");
          vetor.inserir(objeto);
          break;
        case 2:
          objeto = JOptionPane.showInputDialog("Objeto");
          posicao = Integer.valueOf(JOptionPane.showInputDialog("Posicao"));
          vetor.inserir(objeto, posicao);
          break;
        case 3:
          posicao = Integer.valueOf(JOptionPane.showInputDialog("Posicao"));
          vetor.remover(posicao);
          break;
        case 4:
          posicao = Integer.valueOf(JOptionPane.showInputDialog("Posicao"));
          JOptionPane.showMessageDialog(null, vetor.obtem(posicao));
          break;
        case 5:
          objeto = JOptionPane.showInputDialog("Objeto");
          JOptionPane.showMessageDialog(null, vetor.contem(objeto));
          break;
        case 6:
          JOptionPane.showMessageDialog(null, vetor.tamanho());
          break;
        case 7:
          objeto = JOptionPane.showInputDialog("Objeto");
          vetor.remove(objeto);
          break;
        case 8:
          vetor.clear();
          JOptionPane.showMessageDialog(null, "Lista limpa com sucesso");
          break;
        case 9:
          objeto = JOptionPane.showInputDialog("Objeto");
          JOptionPane.showMessageDialog(null, vetor.indexOf(objeto));
          break;
        case 10:
          objeto = JOptionPane.showInputDialog("Objeto");
          JOptionPane.showMessageDialog(null, vetor.lastIndexOf(objeto));
          break;
        case 11:
          StringBuilder lista = new StringBuilder();
          for (int i = 0; i < vetor.tamanho(); i++) {
            lista.append("\n" + vetor.obtem(i));
          }
          JOptionPane.showMessageDialog(null, lista);
          break;
        case 0:
          JOptionPane.showMessageDialog(null, "FIM DO PROGRAMA");
          break;
        default:
          JOptionPane.showMessageDialog(null, "Opção inválida");
          break;
      }
    }
  }
}
