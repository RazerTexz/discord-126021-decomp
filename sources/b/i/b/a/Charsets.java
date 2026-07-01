package b.i.b.a;

import com.adjust.sdk.Constants;
import java.nio.charset.Charset;

/* JADX INFO: renamed from: b.i.b.a.c, reason: use source file name */
/* JADX INFO: compiled from: Charsets.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Charsets {
    public static final Charset a = Charset.forName("US-ASCII");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f1642b = Charset.forName("ISO-8859-1");
    public static final Charset c = Charset.forName(Constants.ENCODING);
    public static final Charset d;
    public static final Charset e;

    static {
        Charset.forName("UTF-16BE");
        d = Charset.forName("UTF-16LE");
        e = Charset.forName("UTF-16");
    }
}
