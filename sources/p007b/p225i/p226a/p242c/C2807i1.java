package p007b.p225i.p226a.p242c;

import java.util.HashSet;

/* JADX INFO: renamed from: b.i.a.c.i1 */
/* JADX INFO: compiled from: ExoPlayerLibraryInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2807i1 {

    /* JADX INFO: renamed from: a */
    public static final HashSet<String> f7121a = new HashSet<>();

    /* JADX INFO: renamed from: b */
    public static String f7122b = "goog.exo.core";

    /* JADX INFO: renamed from: a */
    public static synchronized void m3272a(String str) {
        if (f7121a.add(str)) {
            String str2 = f7122b;
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 2 + str.length());
            sb.append(str2);
            sb.append(", ");
            sb.append(str);
            f7122b = sb.toString();
        }
    }
}
