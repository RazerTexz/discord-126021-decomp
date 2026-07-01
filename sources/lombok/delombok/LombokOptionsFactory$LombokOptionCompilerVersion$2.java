package lombok.delombok;

import com.sun.tools.javac.util.Context;
import lombok.javac.Javac8BasedLombokOptions;
import lombok.javac.LombokOptions;

/* JADX INFO: loaded from: app.apk:lombok/delombok/LombokOptionsFactory$LombokOptionCompilerVersion$2.SCL.lombok */
enum LombokOptionsFactory$LombokOptionCompilerVersion$2 extends LombokOptionsFactory$LombokOptionCompilerVersion {
    LombokOptionsFactory$LombokOptionCompilerVersion$2(String str, int i) {
        super(str, i, null);
    }

    @Override // lombok.delombok.LombokOptionsFactory$LombokOptionCompilerVersion
    LombokOptions createAndRegisterOptions(Context context) {
        return Javac8BasedLombokOptions.replaceWithDelombokOptions(context);
    }
}
