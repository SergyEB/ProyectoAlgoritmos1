/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoalgoritmos;

import java.io.IOException;

/**
 *
 * @author nicos
 */
public class Main {

    public static void main(String[] args) throws IOException {

        Archive archive = new Archive();

        CircularList methodList = archive.readJavaClass();

        //methodList.printBody();
        
        MethodsFrame methodsFrame = new MethodsFrame(methodList);
        
        methodsFrame.setVisible(true);
        
    }
}
