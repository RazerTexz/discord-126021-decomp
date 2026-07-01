package b.f.j.r;

import java.util.Objects;

/* JADX INFO: renamed from: b.f.j.r.b, reason: use source file name */
/* JADX INFO: compiled from: FrescoSystrace.java */
/* JADX INFO: loaded from: classes3.dex */
public class FrescoSystrace {
    public static volatile a a;

    /* JADX INFO: renamed from: b.f.j.r.b$a */
    /* JADX INFO: compiled from: FrescoSystrace.java */
    public interface a {
    }

    public static a a() {
        if (a == null) {
            synchronized (FrescoSystrace.class) {
                if (a == null) {
                    a = new DefaultFrescoSystrace();
                }
            }
        }
        return a;
    }

    public static boolean b() {
        Objects.requireNonNull(a());
        return false;
    }
}
