package p007b.p225i.p355b.p356a;

import com.adjust.sdk.Constants;
import java.nio.charset.Charset;

/* JADX INFO: renamed from: b.i.b.a.c */
/* JADX INFO: compiled from: Charsets.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4483c {

    /* JADX INFO: renamed from: a */
    public static final Charset f11943a = Charset.forName("US-ASCII");

    /* JADX INFO: renamed from: b */
    public static final Charset f11944b = Charset.forName("ISO-8859-1");

    /* JADX INFO: renamed from: c */
    public static final Charset f11945c = Charset.forName(Constants.ENCODING);

    /* JADX INFO: renamed from: d */
    public static final Charset f11946d;

    /* JADX INFO: renamed from: e */
    public static final Charset f11947e;

    static {
        Charset.forName("UTF-16BE");
        f11946d = Charset.forName("UTF-16LE");
        f11947e = Charset.forName("UTF-16");
    }
}
