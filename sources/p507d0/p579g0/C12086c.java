package p507d0.p579g0;

import com.adjust.sdk.Constants;
import java.nio.charset.Charset;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.g0.c */
/* JADX INFO: compiled from: Charsets.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12086c {

    /* JADX INFO: renamed from: a */
    public static final Charset f25136a;

    /* JADX INFO: renamed from: b */
    public static Charset f25137b;

    /* JADX INFO: renamed from: c */
    public static Charset f25138c;

    /* JADX INFO: renamed from: d */
    public static final C12086c f25139d = new C12086c();

    static {
        Charset charsetForName = Charset.forName(Constants.ENCODING);
        C12238m.checkNotNullExpressionValue(charsetForName, "Charset.forName(\"UTF-8\")");
        f25136a = charsetForName;
        C12238m.checkNotNullExpressionValue(Charset.forName("UTF-16"), "Charset.forName(\"UTF-16\")");
        C12238m.checkNotNullExpressionValue(Charset.forName("UTF-16BE"), "Charset.forName(\"UTF-16BE\")");
        C12238m.checkNotNullExpressionValue(Charset.forName("UTF-16LE"), "Charset.forName(\"UTF-16LE\")");
        C12238m.checkNotNullExpressionValue(Charset.forName("US-ASCII"), "Charset.forName(\"US-ASCII\")");
        C12238m.checkNotNullExpressionValue(Charset.forName("ISO-8859-1"), "Charset.forName(\"ISO-8859-1\")");
    }

    public final Charset UTF32_BE() {
        Charset charset = f25138c;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32BE");
        C12238m.checkNotNullExpressionValue(charsetForName, "Charset.forName(\"UTF-32BE\")");
        f25138c = charsetForName;
        return charsetForName;
    }

    public final Charset UTF32_LE() {
        Charset charset = f25137b;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32LE");
        C12238m.checkNotNullExpressionValue(charsetForName, "Charset.forName(\"UTF-32LE\")");
        f25137b = charsetForName;
        return charsetForName;
    }
}
