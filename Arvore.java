package arvore;

import java.util.Stack;

/**
 *
 * @author jlean
 */
public class Arvore {

    int id;
    Arvore[] filhos;
    
    //Stack<Integer> pilhaNodos = new Stack<>();

    Arvore(int id, Arvore[] filhos) {
        this.id = id;
        this.filhos = filhos;

    }
    
    
    private static Arvore makeTree(){
        
        //root = new Arvore(1,new Arvore[]{new Arvore(4, new Arvore[]{new Arvore(10, new Arvore[]{new Arvore(8)}),new Arvore(2, new Arvore[]{new Arvore(12, new Arvore[]{new Arvore(13, new Arvore[]{new Arvore(9)})})})}), new Arvore(7, new Arvore[]{new Arvore(3), new Arvore(11, new Arvore[]{new Arvore(6), new Arvore(5)})})});
        Arvore no9 = new Arvore(9, new Arvore[]{null, null});
        Arvore no13 = new Arvore(13,new Arvore[]{no9,null}); 
        //System.out.printf("O filho da direita %d\n",no13.filhos[0].id);
        Arvore no12 = new Arvore(12, new Arvore[]{no13, null}); 
        Arvore no2 = new Arvore(2, new Arvore[]{no12, null}); 
        //System.out.printf("O filho da direita %d\n",no2.filhos[0].id);
        Arvore no8 = new Arvore(8, new Arvore[]{null, null});
        Arvore no10 = new Arvore(10, new Arvore[]{no8, null}); 
        Arvore no4 = new Arvore(4, new Arvore[]{no10, no2}); 
        //System.out.printf("O filho da direita %d e %d\n",no4.filhos[0].id, no4.filhos[1].id);
        Arvore no3 = new Arvore(3, new Arvore[]{null, null}); 
        Arvore no5 = new Arvore(5, new Arvore[]{null, null}); 
        Arvore no6 = new Arvore(6, new Arvore[]{null, null}); 
        Arvore no11 = new Arvore(11, new Arvore[]{no6, no5}); 
        Arvore no7 = new Arvore(7, new Arvore[]{no3, no11}); 
        Arvore no1 = new Arvore(1, new Arvore[]{no4, no7}); 
       
        return no1;
    }
    
    public static void buscaElemento(Arvore a, int n, Stack pilhaNodos) {
        pilhaNodos.push(a.id);
        //System.out.printf("Nodo adicionado %d\n",a.id);
        if (a.id == n || (Integer) pilhaNodos.peek() == n) {
            return;
        } else {
            if (a.filhos[0] != null) {
                if ((Integer) pilhaNodos.peek() != n) 
                    buscaElemento(a.filhos[0], n, pilhaNodos);   
            }
            if (a.filhos[1] != null) {
                if ((Integer) pilhaNodos.peek() != n){
                    buscaElemento(a.filhos[1], n, pilhaNodos);
                    if((Integer) pilhaNodos.peek()==a.id){
                        pilhaNodos.pop();
                    }      
                }
                
            } else {
                if ((Integer) pilhaNodos.peek() != n) {
                    pilhaNodos.pop();
                    //System.out.printf("Nodo removido %d\n", a.id);
                    return;
                }
            }
        }
    }
    
    public static int[] caminho_Arvore(Arvore a, int n) {
        
    
        Stack<Integer> pilhaNodos = new Stack<>();
        buscaElemento(a, n, pilhaNodos);
        int[] vetor = new int[pilhaNodos.size()];
        int i = pilhaNodos.size()-1;
        while(!pilhaNodos.empty()){
            vetor[i] = pilhaNodos.pop();
            i--;
        }

   
        return vetor;
    }
    
    public static void main(String[] args) {
        int[] a = caminho_Arvore(makeTree(), 6);
        System.out.printf("[");
        for(int i: a){
            System.out.printf(" %d ", i);
        }
        System.out.printf("]");
    }
} 