/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizadores;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import jflex.exceptions.SilentExit;

/**
 *
 * @author willi
 */
public class Generador {
    public static void main(String[] args) throws IOException, SilentExit, Exception{
        generar();
    }
    
    public static void generar() throws UnsupportedEncodingException, SilentExit, IOException, Exception {
        String path2 = System.getProperty("user.dir");
        String decodedPath = URLDecoder.decode(path2, "UTF-8");
        String[] rutaS = {"-parser", "Parser","-symbols", "sym", decodedPath + "/src/Analizadores/parser.cup"};
        String[] rutaS2 = {decodedPath + "/src/Analizadores/Lexer.flex"};
        jflex.Main.generate(rutaS2);
        java_cup.Main.main(rutaS);

        String dP = URLDecoder.decode(path2, "UTF-8");

        Path rutaSym = Paths.get(dP + "/src/Analizadores/sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get(dP + "/sym.java"),
                Paths.get(dP + "/src/Analizadores/sym.java")
        );
        Path rutaSin = Paths.get(dP + "/src/Analizadores/Parser.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get(dP + "/Parser.java"),
                Paths.get(dP + "/src/Analizadores/Parser.java")
        );
    }
}
