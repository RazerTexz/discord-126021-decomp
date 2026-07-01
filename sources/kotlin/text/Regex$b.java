package kotlin.text;

import d0.z.d.m;
import java.io.Serializable;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Regex$b implements Serializable {
    private static final long serialVersionUID = 0;
    private final int flags;
    private final String pattern;

    static {
        new Regex$b$a(null);
    }

    public Regex$b(String str, int i) {
        m.checkNotNullParameter(str, "pattern");
        this.pattern = str;
        this.flags = i;
    }

    private final Object readResolve() {
        Pattern patternCompile = Pattern.compile(this.pattern, this.flags);
        m.checkNotNullExpressionValue(patternCompile, "Pattern.compile(pattern, flags)");
        return new Regex(patternCompile);
    }
}
