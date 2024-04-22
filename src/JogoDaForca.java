import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JogoDaForca {
    
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        List<String> palavras = new ArrayList<>();
        palavras.add("Banana");
        palavras.add("Chocolate");
        palavras.add("Mandioca");
        palavras.add("Limao");
        palavras.add("Feijao");
        palavras.add("Linguica");
        palavras.add("Abobora");
        palavras.add("Salsicha");
        palavras.add("Hamburguer");
        palavras.add("Arooz");
        palavras.add("Batata");
        palavras.add("Pizza");
        palavras.add("Salame");
        palavras.add("Panetone");

        int indiceAleatorio = random.nextInt(palavras.size());
        String palavraSecreta = palavras.get(indiceAleatorio).toLowerCase();

        char[] palavrasComEspacos = new char[palavraSecreta.length()];
        for (int i = 0; i < palavrasComEspacos.length; i++) {
            palavrasComEspacos[i] = '_';
        }

        List<Character> letrasChutadas = new ArrayList<>();

        int tentativasRestantes = 5;

        boolean jogadorGanhou = false;

        while (tentativasRestantes > 0 && !jogadorGanhou) {
            System.out.print("Palavra: ");
            System.out.print(Character.toUpperCase(palavrasComEspacos[0])); 
                for (int i = 1; i < palavrasComEspacos.length; i++) {
            System.out.print(palavrasComEspacos[i]);
            }
            System.out.println("\nLetras chutadas:" + letrasChutadas);
            System.out.println("Tentativas restantes: " + tentativasRestantes);

            System.out.println("Chute uma letra: ");
            char chute = scanner.next().toLowerCase().charAt(0);

            if (letrasChutadas.contains(chute)) {
                System.out.println("Você ja chutou essa letra, tente novamente.");
                continue;
            }

            letrasChutadas.add(chute);

            boolean acertou = false;
                for (int i = 0; i < palavraSecreta.length(); i++) {
                    if (palavraSecreta.charAt(i) == chute) {
                        palavrasComEspacos[i] = chute;
                        acertou = true;
                    }
                }

            if (!acertou) {
                tentativasRestantes--;
                System.out.println("Letra errada.");
                System.out.println("Tentativas restantes: " + tentativasRestantes);
            }

            // Verificar se o jogador ganhou
            jogadorGanhou = true;
            for (char c : palavrasComEspacos) {
                if (c == '_') {
                    jogadorGanhou = false;
                    break;
                }
            }

            if (jogadorGanhou) {
                System.out.println("Parabéns! Você ganhou!");
                break; 
            } else {
                System.out.println("Você perdeu, a palavra era: " + palavraSecreta);
            }
        }
    }
}
