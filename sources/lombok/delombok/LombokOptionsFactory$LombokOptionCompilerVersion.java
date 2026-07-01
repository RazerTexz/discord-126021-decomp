package lombok.delombok;

import com.sun.tools.javac.util.Context;
import lombok.javac.LombokOptions;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: app.apk:lombok/delombok/LombokOptionsFactory$LombokOptionCompilerVersion.SCL.lombok */
abstract class LombokOptionsFactory$LombokOptionCompilerVersion {
    public static final LombokOptionsFactory$LombokOptionCompilerVersion JDK7_AND_LOWER = new LombokOptionsFactory$LombokOptionCompilerVersion$1("JDK7_AND_LOWER", 0);
    public static final LombokOptionsFactory$LombokOptionCompilerVersion JDK8 = new LombokOptionsFactory$LombokOptionCompilerVersion$2("JDK8", 1);
    public static final LombokOptionsFactory$LombokOptionCompilerVersion JDK9 = new LombokOptionsFactory$LombokOptionCompilerVersion$3("JDK9", 2);
    private static final /* synthetic */ LombokOptionsFactory$LombokOptionCompilerVersion[] ENUM$VALUES = {JDK7_AND_LOWER, JDK8, JDK9};

    abstract LombokOptions createAndRegisterOptions(Context context);

    public static LombokOptionsFactory$LombokOptionCompilerVersion[] values() {
        LombokOptionsFactory$LombokOptionCompilerVersion[] lombokOptionsFactory$LombokOptionCompilerVersionArr = ENUM$VALUES;
        int length = lombokOptionsFactory$LombokOptionCompilerVersionArr.length;
        LombokOptionsFactory$LombokOptionCompilerVersion[] lombokOptionsFactory$LombokOptionCompilerVersionArr2 = new LombokOptionsFactory$LombokOptionCompilerVersion[length];
        System.arraycopy(lombokOptionsFactory$LombokOptionCompilerVersionArr, 0, lombokOptionsFactory$LombokOptionCompilerVersionArr2, 0, length);
        return lombokOptionsFactory$LombokOptionCompilerVersionArr2;
    }

    public static LombokOptionsFactory$LombokOptionCompilerVersion valueOf(String str) {
        return (LombokOptionsFactory$LombokOptionCompilerVersion) Enum.valueOf(LombokOptionsFactory$LombokOptionCompilerVersion.class, str);
    }

    private LombokOptionsFactory$LombokOptionCompilerVersion(String str, int i) {
        super(str, i);
    }

    /* synthetic */ LombokOptionsFactory$LombokOptionCompilerVersion(String str, int i, LombokOptionsFactory$LombokOptionCompilerVersion lombokOptionsFactory$LombokOptionCompilerVersion) {
        this(str, i);
    }
}
