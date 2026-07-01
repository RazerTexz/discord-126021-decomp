package kotlin.text;

import d0.z.d.m;
import java.util.Objects;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Regex$a {
    public Regex$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public static final int access$ensureUnicodeCase(Regex$a regex$a, int i) {
        Objects.requireNonNull(regex$a);
        return (i & 2) != 0 ? i | 64 : i;
    }

    public final String escape(String str) {
        m.checkNotNullParameter(str, "literal");
        String strQuote = Pattern.quote(str);
        m.checkNotNullExpressionValue(strQuote, "Pattern.quote(literal)");
        return strQuote;
    }
}
