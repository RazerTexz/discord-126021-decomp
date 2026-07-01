package z;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: AndroidExecutors.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final a a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f3857b;
    public static final int c;
    public static final int d;
    public final Executor e = new a$b(null);

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f3857b = iAvailableProcessors;
        c = iAvailableProcessors + 1;
        d = (iAvailableProcessors * 2) + 1;
    }
}
