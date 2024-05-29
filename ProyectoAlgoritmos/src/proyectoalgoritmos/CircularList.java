/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoalgoritmos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 *
 * @author nicos
 */
class CircularList {

    private Node head;
    private Node tail;

    public CircularList() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void addMethod(String methodName, List<String> methodBody, String complexity) {
        Method newMethod = new Method(methodName, methodBody, complexity);
        Node newNode = new Node(newMethod);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            tail.setNext(head);
        } else {
            tail.setNext(newNode);
            newNode.setNext(head);
            tail = newNode;
        }
    }

    public void printBody() {
        if (isEmpty()) {
            System.out.println("La lista está vacía");
            return;
        }

        Node current = head;
        do {
            List<String> bodyParts = current.getMethod().getMethodBody();
            for (String bodyPart : bodyParts) {
                System.out.println(bodyPart);
            }
            current = current.getNext();
        } while (current != head);
    }

    public ListModel<String> getMethodsNamesList() {
        DefaultListModel<String> methodsNames = new DefaultListModel<>();
        if (isEmpty()) {
            System.out.println("La lista está vacía");
            return methodsNames;
        }

        Node current = head;
        do {
            methodsNames.addElement(current.getMethod().getMethodName());
            current = current.getNext();
        } while (current != head);
        return methodsNames;
    }

    public Node findNode(String selectedMethod) {
        if (isEmpty()) {
            System.out.println("La lista está vacía");
            return null;
        }

        Node current = head;
        do {
            if (selectedMethod.equalsIgnoreCase(current.getMethod().getMethodName())) {
                return current;
            }
            current = current.getNext();
        } while (current != head);

        return null;
    }

    public void getBodyMethods() {
        if (isEmpty()) {
            System.out.println("La lista está vacía");
            return;
        }

        Node current = head;
        do {
            for (String bodyParts : current.getMethod().getMethodBody()) {
                System.out.println(bodyParts);
            }
            current = current.getNext();
        } while (current != head);
    }

    public Node findNodo(String selectedMethod) {
    if (isEmpty()) {
        System.out.println("La lista está vacía");
        return null;
    }

    Node current = head;
    do {
        if (selectedMethod.equalsIgnoreCase(current.getMethod().getMethodName())) {
            return current;
        }
        current = current.getNext();
    } while (current != head);

    return null;
}

}
