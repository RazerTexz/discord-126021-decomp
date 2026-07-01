package d0.g0;

import com.adjust.sdk.Constants;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: Charsets.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final Charset a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Charset f3579b;
    public static Charset c;
    public static final c d = new c();

    static {
        Charset charsetForName = Charset.forName(Constants.ENCODING);
        d0.z.d.m.checkNotNullExpressionValue(charsetForName, "Charset.forName(\"UTF-8\")");
        a = charsetForName;
        d0.z.d.m.checkNotNullExpressionValue(Charset.forName("UTF-16"), "Charset.forName(\"UTF-16\")");
        d0.z.d.m.checkNotNullExpressionValue(Charset.forName("UTF-16BE"), "Charset.forName(\"UTF-16BE\")");
        d0.z.d.m.checkNotNullExpressionValue(Charset.forName("UTF-16LE"), "Charset.forName(\"UTF-16LE\")");
        d0.z.d.m.checkNotNullExpressionValue(Charset.forName("US-ASCII"), "Charset.forName(\"US-ASCII\")");
        d0.z.d.m.checkNotNullExpressionValue(Charset.forName("ISO-8859-1"), "Charset.forName(\"ISO-8859-1\")");
    }

    public final Charset UTF32_BE() {
        Charset charset = c;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32BE");
        d0.z.d.m.checkNotNullExpressionValue(charsetForName, "Charset.forName(\"UTF-32BE\")");
        c = charsetForName;
        return charsetForName;
    }

    public final Charset UTF32_LE() {
        Charset charset = f3579b;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32LE");
        d0.z.d.m.checkNotNullExpressionValue(charsetForName, "Charset.forName(\"UTF-32LE\")");
        f3579b = charsetForName;
        return charsetForName;
    }
}
