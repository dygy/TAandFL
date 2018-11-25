package lab1;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
class Lexer {

    static void goJS() throws FileNotFoundException, ScriptException, NoSuchMethodException {

        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new

                FileReader("C:\\Users\\yukim\\IdeaProjects\\TAandFL\\src\\lab1\\js.js"));

        Invocable invocable = (Invocable) engine;

        Object result = invocable.invokeFunction("fun", Main.string);
       // System.out.println(result);
    }
}