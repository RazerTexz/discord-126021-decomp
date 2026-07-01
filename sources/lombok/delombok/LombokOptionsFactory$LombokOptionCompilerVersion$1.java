package lombok.delombok;

import com.sun.tools.javac.util.Context;
import lombok.javac.Javac6BasedLombokOptions;
import lombok.javac.LombokOptions;

/* JADX INFO: loaded from: app.apk:lombok/delombok/LombokOptionsFactory$LombokOptionCompilerVersion$1.SCL.lombok */
enum LombokOptionsFactory$LombokOptionCompilerVersion$1 extends LombokOptionsFactory$LombokOptionCompilerVersion {
    LombokOptionsFactory$LombokOptionCompilerVersion$1(String str, int i) {
        super(str, i, null);
    }

    @Override // lombok.delombok.LombokOptionsFactory$LombokOptionCompilerVersion
    LombokOptions createAndRegisterOptions(Context context) {
        return Javac6BasedLombokOptions.replaceWithDelombokOptions(context);
    }
}
