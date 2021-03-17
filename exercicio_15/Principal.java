package exercicio_15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        int op=0;
        boolean verify = true;
        int n;
        int vetor[];
        Scanner ler = new Scanner(System.in);
        do{
            System.out.println("Escolha uma abordagem: ");
            System.out.println("1: " + string_abordagem(1));
            System.out.println("2: " + string_abordagem(2));
            System.out.print("Opção: ");
            op = ler.nextInt();
            if(op==1)
                verify = false;
            if(op==2)
                verify = false;
            System.out.println("Abordagem Escolhida: "+ string_abordagem(op));
        }while (verify);
        verify=true;
        do{
            System.out.println("Tamanho do Vetor: ");
            n = ler.nextInt();
            if(n>=2 && n<=999999999){
                verify=false;
                System.out.println("Tamanho Escolhido : Válido = "+n);
            }
            else{
                System.out.println("Escolha um tamanho de vetor válido. (Entre 2 e 999999999");
            }
        }while (verify);
        vetor = cria_vetor(n);
        executar(vetor,op);

    }
    public static void executar(int vetor[], int abordagem){
        int fim_maior = vetor.length-1; // posicao final do vetor
        for(int i=0; i<vetor.length; i++){ //imprimir vetor
            System.out.print(vetor[i]+"  ");
        }
        System.out.println("");
        int resultado;
        switch (abordagem){
            case 1:
                resultado = alg1(vetor,0,fim_maior);
                break;
            case 2:
                resultado = alg2(vetor, 0, fim_maior);
                break;
            default:
                resultado = -1;
                break;
        }
        System.out.println("A posição do maior número ("+ fim_maior +") é: "+ resultado);
    }
    public static int[] cria_vetor(int n){
        int v[] = new int[n]; // vetor de retorno
        ArrayList<Integer> vetor = new ArrayList<Integer>(); // arraylist para embaralhamento
        for(int i=0; i<n; i++){ //criando arraylist de elementos
            vetor.add(i);
        }
        Collections.shuffle(vetor); // aleatoriazando os elementos
        for(int i=0; i<n; i++){
            v[i] = vetor.get(i); // passando pro vetor de retorno
        }
        return v;
    }
    public static int alg2(int vetor[], int inicio, int fim){ // segunda abordagem
        int tam = fim-inicio+1; //tamanho do vetor
        int posicao=fim; // inicializando variavel da posicao
        int pivo = (fim-inicio)/2; // pivo da segunda abordagem, ultimo elemento do primeiro subvetor
        if (tam<=2){
            if(vetor[fim]>=vetor[inicio])
                posicao = fim;
            else
                posicao = inicio;
        }
        if(tam>2){
            int posicao1 = alg1(vetor,inicio,pivo);
            int posicao2 = alg1(vetor,pivo+1,fim);
            if(vetor[posicao2]>=vetor[posicao1])
                posicao = posicao2;
            else
                posicao = posicao1;
        }
        //
        return posicao;
    }
    public static int alg1(int vetor[], int inicio, int fim){ // primeira abordagem
        int tam = fim-inicio+1; //tamanho do vetor
        int posicao=-1; // inicializando variavel da posicao
        if (tam<=2){
            if(vetor[fim]>vetor[inicio])
                posicao = fim;
            else
                posicao = inicio;
        }
        int pivo = fim-1; // pivo da primeira abordagem
        if(tam>2){
            int posicao1 = alg1(vetor,inicio,pivo);
            int posicao2 = alg1(vetor,pivo+1,fim);
            if(vetor[posicao2]>=vetor[posicao1])
                posicao = posicao2;
            else
                posicao = posicao1;
        }
        //
        return posicao;
    }
    public static String string_abordagem(int op){
        switch (op){
            case 1:
                return "Abordagem 1 (tamanho n-1)";
            case 2:
                return "Abordagem 2 (tamanho n/2)";
            default:
                return "Nenhuma opção válida escolhida! Por favor, escolha entre as opções válidas.";
        }
    }
}
