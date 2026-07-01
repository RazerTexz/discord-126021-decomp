package b.i.e.n;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: StringUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public static final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f1839b;

    static {
        String strName = Charset.defaultCharset().name();
        a = strName;
        f1839b = "SJIS".equalsIgnoreCase(strName) || "EUC_JP".equalsIgnoreCase(strName);
    }
}
