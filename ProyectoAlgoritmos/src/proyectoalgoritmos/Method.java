/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoalgoritmos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sergi
 */
class Method {
    private String methodName;
    private List<String> methodBody;
    private String complexity;

    public Method(String methodName, List<String> methodBody, String complexity) {
        this.methodName = methodName;
        this.methodBody = methodBody;
        this.complexity = complexity;
    }

    public String getMethodName() {
        return methodName;
    }

    public List<String> getMethodBody() {
        return methodBody;
    }

    public String getComplexity() {
        return complexity;
    }
}