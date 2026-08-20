package lombok.javac;

import com.sun.tools.javac.main.Option;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.Options;

/* JADX INFO: loaded from: discord-126021.apk:lombok/javac/Javac9BasedLombokOptions.SCL.lombok */
public class Javac9BasedLombokOptions extends LombokOptions {
    public static Javac9BasedLombokOptions replaceWithDelombokOptions(Context context) {
        Options options = Options.instance(context);
        context.put(optionsKey, (Object) null);
        Javac9BasedLombokOptions result = new Javac9BasedLombokOptions(context);
        result.putAll(options);
        return result;
    }

    private Javac9BasedLombokOptions(Context context) {
        super(context);
    }

    @Override // lombok.javac.LombokOptions
    public void putJavacOption(String optionName, String value) {
        if (optionName.equals("CLASSPATH")) {
            optionName = "CLASS_PATH";
        }
        if (optionName.equals("SOURCEPATH")) {
            optionName = "SOURCE_PATH";
        }
        if (optionName.equals("BOOTCLASSPATH")) {
            optionName = "BOOT_CLASS_PATH";
        }
        String optionText = Option.valueOf(optionName).primaryName;
        put(optionText, value);
    }
}
