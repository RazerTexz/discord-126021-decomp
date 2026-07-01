package lombok.delombok;

import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.Options;
import lombok.javac.Javac;
import lombok.javac.Javac6BasedLombokOptions;
import lombok.javac.Javac8BasedLombokOptions;
import lombok.javac.Javac9BasedLombokOptions;
import lombok.javac.LombokOptions;

/* JADX INFO: loaded from: app.apk:lombok/delombok/LombokOptionsFactory.SCL.lombok */
public class LombokOptionsFactory {

    /* JADX INFO: loaded from: app.apk:lombok/delombok/LombokOptionsFactory$LombokOptionCompilerVersion.SCL.lombok */
    enum LombokOptionCompilerVersion {
        JDK7_AND_LOWER { // from class: lombok.delombok.LombokOptionsFactory.LombokOptionCompilerVersion.1
            @Override // lombok.delombok.LombokOptionsFactory.LombokOptionCompilerVersion
            LombokOptions createAndRegisterOptions(Context context) {
                return Javac6BasedLombokOptions.replaceWithDelombokOptions(context);
            }
        },
        JDK8 { // from class: lombok.delombok.LombokOptionsFactory.LombokOptionCompilerVersion.2
            @Override // lombok.delombok.LombokOptionsFactory.LombokOptionCompilerVersion
            LombokOptions createAndRegisterOptions(Context context) {
                return Javac8BasedLombokOptions.replaceWithDelombokOptions(context);
            }
        },
        JDK9 { // from class: lombok.delombok.LombokOptionsFactory.LombokOptionCompilerVersion.3
            @Override // lombok.delombok.LombokOptionsFactory.LombokOptionCompilerVersion
            LombokOptions createAndRegisterOptions(Context context) {
                return Javac9BasedLombokOptions.replaceWithDelombokOptions(context);
            }
        };

        abstract LombokOptions createAndRegisterOptions(Context context);

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static LombokOptionCompilerVersion[] valuesCustom() {
            LombokOptionCompilerVersion[] lombokOptionCompilerVersionArrValuesCustom = values();
            int length = lombokOptionCompilerVersionArrValuesCustom.length;
            LombokOptionCompilerVersion[] lombokOptionCompilerVersionArr = new LombokOptionCompilerVersion[length];
            System.arraycopy(lombokOptionCompilerVersionArrValuesCustom, 0, lombokOptionCompilerVersionArr, 0, length);
            return lombokOptionCompilerVersionArr;
        }

        /* synthetic */ LombokOptionCompilerVersion(LombokOptionCompilerVersion lombokOptionCompilerVersion) {
            this();
        }
    }

    public static LombokOptions getDelombokOptions(Context context) {
        LombokOptions options;
        Options rawOptions = Options.instance(context);
        if (rawOptions instanceof LombokOptions) {
            return (LombokOptions) rawOptions;
        }
        if (Javac.getJavaCompilerVersion() < 8) {
            options = LombokOptionCompilerVersion.JDK7_AND_LOWER.createAndRegisterOptions(context);
        } else if (Javac.getJavaCompilerVersion() == 8) {
            options = LombokOptionCompilerVersion.JDK8.createAndRegisterOptions(context);
        } else {
            options = LombokOptionCompilerVersion.JDK9.createAndRegisterOptions(context);
        }
        return options;
    }
}
