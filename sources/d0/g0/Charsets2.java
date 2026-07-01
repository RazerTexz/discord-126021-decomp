package d0.g0;

import com.adjust.sdk.Constants;
import d0.z.d.Intrinsics3;
import java.nio.charset.Charset;

/* JADX INFO: renamed from: d0.g0.c, reason: use source file name */
/* JADX INFO: compiled from: Charsets.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Charsets2 {
    public static final Charset a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Charset f3579b;
    public static Charset c;
    public static final Charsets2 d = new Charsets2();

    static {
        Charset charsetForName = Charset.forName(Constants.ENCODING);
        Intrinsics3.checkNotNullExpressionValue(charsetForName, "Charset.forName(\"UTF-8\")");
        a = charsetForName;
        Intrinsics3.checkNotNullExpressionValue(Charset.forName("UTF-16"), "Charset.forName(\"UTF-16\")");
        Intrinsics3.checkNotNullExpressionValue(Charset.forName("UTF-16BE"), "Charset.forName(\"UTF-16BE\")");
        Intrinsics3.checkNotNullExpressionValue(Charset.forName("UTF-16LE"), "Charset.forName(\"UTF-16LE\")");
        Intrinsics3.checkNotNullExpressionValue(Charset.forName("US-ASCII"), "Charset.forName(\"US-ASCII\")");
        Intrinsics3.checkNotNullExpressionValue(Charset.forName("ISO-8859-1"), "Charset.forName(\"ISO-8859-1\")");
    }

    public final Charset UTF32_BE() {
        Charset charset = c;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32BE");
        Intrinsics3.checkNotNullExpressionValue(charsetForName, "Charset.forName(\"UTF-32BE\")");
        c = charsetForName;
        return charsetForName;
    }

    public final Charset UTF32_LE() {
        Charset charset = f3579b;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32LE");
        Intrinsics3.checkNotNullExpressionValue(charsetForName, "Charset.forName(\"UTF-32LE\")");
        f3579b = charsetForName;
        return charsetForName;
    }
}
