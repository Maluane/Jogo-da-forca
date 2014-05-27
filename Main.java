package testearraylist;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Contato> contatos = new ArrayList();
        
        // Criar objeto contato
        Contato c = new Contato("Contato 1", "contato1@gmail.com");
        
        contatos.add(new Contato("ss", "dd"));
        
        // adicionar objeto ao arraylist
        contatos.add(c);
        
        Contato c2 = new Contato("Contato 2", "contato2@gmail.com");
        contatos.add(c2);
        
        //contatos.add("dd");
        
        //mostrar quantidade de elementos
        System.out.println("Contatos contém " + contatos.size() + " elementos");
        
        // buscar objeto na posição
        Contato contatoDoArray = contatos.get(1);
        System.out.println(contatoDoArray.getNome());
        
        
        //remover um elemento na posição 0
        contatos.remove(0);
        
        System.out.println("Contatos contém " + contatos.size() + " elementos");
    }

}
