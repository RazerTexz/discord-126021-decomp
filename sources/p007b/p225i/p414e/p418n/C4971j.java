package p007b.p225i.p414e.p418n;

import java.nio.charset.Charset;

/* JADX INFO: renamed from: b.i.e.n.j */
/* JADX INFO: compiled from: StringUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4971j {

    /* JADX INFO: renamed from: a */
    public static final String f13290a;

    /* JADX INFO: renamed from: b */
    public static final boolean f13291b;

    static {
        String strName = Charset.defaultCharset().name();
        f13290a = strName;
        f13291b = "SJIS".equalsIgnoreCase(strName) || "EUC_JP".equalsIgnoreCase(strName);
    }
}
