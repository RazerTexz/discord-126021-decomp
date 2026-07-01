package b.i.a.c;

import java.util.HashSet;

/* JADX INFO: compiled from: ExoPlayerLibraryInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i1 {
    public static final HashSet<String> a = new HashSet<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f1016b = "goog.exo.core";

    public static synchronized void a(String str) {
        if (a.add(str)) {
            String str2 = f1016b;
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 2 + str.length());
            sb.append(str2);
            sb.append(", ");
            sb.append(str);
            f1016b = sb.toString();
        }
    }
}
