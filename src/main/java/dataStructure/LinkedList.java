package dataStructure;

public class LinkedList {

  private Node head;
  private Node tail;
  private int length;

  class Node {

    String data; // Valor do nó
    Node next; // Referencia o próximo nó

    Node(String data) {  // Construtor - todo nó tem que obrigatoriamente ter um valor
      this.data = data;
    }

  }

  public LinkedList(String data) { // Construtor da lista ligada
    length = 1;
    Node newNode = new Node(data);
    head = newNode;
    tail = newNode;
  }

  public void getHead() {
    if (this.head == null) {
      System.out.println("Lista vazia");
    } else {
      System.out.println("Head: " + this.head.data);
    }
  }

  public void getTail() {
    if (this.tail == null) {
      System.out.println("Lista vazia");
    } else {
      System.out.println("Tail: " + this.tail.data);
    }
  }

  public void getLength() {
    System.out.println("Length: " + this.length);
  }

  public void makeEmpty() {
    head = null;
    tail = null;
    length = 0;
  }

  public void print() {
    System.out.println("#######################");
    Node temp = this.head;

    while (temp != null) {
      System.out.println(temp.data);
      temp = temp.next;
    }
    System.out.println("#######################");
  }

  
  public void append(String data) { // Inserir no Final da Lista
    Node newNode = new Node(data);
    if (length == 0) {
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode;
    }
    length++;
  }

  public Node removeLast() {
    if(length == 0) return null;
    Node pre = head;
    Node temp = null;

    while(pre.next != tail) {
      pre = pre.next;
    }

    temp = tail; // Salvo apenas para retornar-lo no final.

    tail = pre;
    tail.next = null;

    length--;
    if (length == 0) { // Se agora a lista ficou zerada, zerar a lista.
      head = null;
      tail = null;
    }
    
    return temp;

  }

  public void prepend(String data) { // Insere no começo da lista
    Node newNode = new Node(data);
    if (length == 0) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.next = head;
      head = newNode;
    }
    length++;
  }

  public Node removeFirst() {
    if (length == 0) return null;
    Node temp = head;
    head = head.next; // Efetivamente remove a referência ao primeiro nó da lista.
    temp.next = null; // Garantia que o nó removido não tenha nenhuma conexão com a lista.

    length--;
    if (length == 0) { // Caso a lista fique vazia após a remoção, zerar a lista.
      head = null;
      tail = null;
    }
    
    return temp;
  }

  public Node get(int index) {
    if (index < 0 || index >= length) return null;
    Node temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.next;
    }

    return temp;
  }

  public boolean set(int index, String data) {
    Node temp = get(index);
    if (temp != null) {
      temp.data = data;
      return true;
    }
    return false;
  }


  public boolean insert(int index, String data) {
    if (index < 0 || index >= length) return false;
     if (index == 0) {
      prepend(data);
      return true;
     }
     if(index == length) {
      append(data);
      return true;
     }

     Node newNode = new Node(data);
     Node temp = get(index - 1);
     newNode.next = temp.next;
     temp.next = newNode;
     length++;

     return true;
  }

  public Node remove(int index) {
    if (index < 0 || index >= length) return null;
    if (index == 0) return removeFirst();
    if (index == length  - 1) return removeLast();

    Node prev = get(index - 1); // Anterior ao que vai ser removido
    Node temp = prev.next; // O nó a ser removido. É o próximo do anterior marcado

    prev.next = temp.next; // O próximo do anterior vai ser o próximo do que vai ser removido. 
    temp.next = null;
    length--;

    return temp;
  }
}
