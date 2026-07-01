package lombok.delombok;

import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.Options;
import lombok.javac.Javac;
import lombok.javac.LombokOptions;

/* JADX INFO: loaded from: app.apk:lombok/delombok/LombokOptionsFactory.SCL.lombok */
public class LombokOptionsFactory {
    public static LombokOptions getDelombokOptions(Context context) {
        LombokOptions options;
        Options rawOptions = Options.instance(context);
        if (rawOptions instanceof LombokOptions) {
            return (LombokOptions) rawOptions;
        }
        if (Javac.getJavaCompilerVersion() < 8) {
            options = LombokOptionsFactory$LombokOptionCompilerVersion.JDK7_AND_LOWER.createAndRegisterOptions(context);
        } else if (Javac.getJavaCompilerVersion() == 8) {
            options = LombokOptionsFactory$LombokOptionCompilerVersion.JDK8.createAndRegisterOptions(context);
        } else {
            options = LombokOptionsFactory$LombokOptionCompilerVersion.JDK9.createAndRegisterOptions(context);
        }
        return options;
    }
}
