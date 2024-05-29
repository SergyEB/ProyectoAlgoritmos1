/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoalgoritmos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

public class Archive {

    private static final String javaClass = "D://SERGIO//OneDrive//Documentos//"
            + "NetBeansProjects//Algorithms-project//ProyectoAlgoritmos//src//"
            + "proyectoalgoritmos//Calculator.java";

    private static final Pattern METHOD_PATTERN = Pattern.compile(
            "(public|protected|private|static|\\s) +[\\w\\<>\\[\\]]+ +\\w+ *\\([^\\)]*\\) *(\\{?|[^;])"
    );

    public List<String> body;
    public CircularList circularList = new CircularList();
    public String methodName;
    public String complexity;

    public CircularList readJavaClass() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(javaClass));

        String line;

        int c = 0;
        while ((line = br.readLine()) != null) {

            line = line.trim();

            if (isMethod(line) || (c != 0)) {

                if (c == 0) {
                    this.methodName = line;
                    this.body = new ArrayList<String>();
                }

                if (line.contains("{")) {
                    c++;
                } 
                if (line.contains("}")) {
                    c--;
                }

                buildBody(line, c);
            }
        }
        return this.circularList;
    }

    public static boolean isMethod(String line) {
        Matcher matcher = METHOD_PATTERN.matcher(line);
        return matcher.find();
    }

    private void buildBody(String line, int c) {
        this.body.add(line);

        if (c == 0) {
            this.complexity = calComplexity(this.body);
            this.circularList.addMethod(this.methodName, this.body, this.complexity);
        }
    }

    private String calComplexity(List<String> body) {
        int level = 0;
        int maxLevel = 0;
        for (String line : body) {
            if (line.contains("for") || line.contains("while")) {
                level++;
                if (level > maxLevel) {
                    maxLevel = level;
                }
            } else if (line.contains("if") || line.contains("switch")) {
                level++;
            } else if (line.contains("}")) {
                level--;
            }
        }

        if (maxLevel == 0) {
            return "O(1)";
        } else if (maxLevel == 1) {
            return "O(n)";
        } else if (maxLevel == 2) {
            return "O(n^2)";
        } else {
            return "O(n^" + maxLevel + ")";
        }
    }
}