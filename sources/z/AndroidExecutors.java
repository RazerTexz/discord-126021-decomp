package z;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: z.a, reason: use source file name */
/* JADX INFO: compiled from: AndroidExecutors.java */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidExecutors {
    public static final AndroidExecutors a = new AndroidExecutors();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f3857b;
    public static final int c;
    public static final int d;
    public final Executor e = new b(null);

    /* JADX INFO: renamed from: z.a$b */
    /* JADX INFO: compiled from: AndroidExecutors.java */
    public static class b implements Executor {
        public b(a aVar) {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f3857b = iAvailableProcessors;
        c = iAvailableProcessors + 1;
        d = (iAvailableProcessors * 2) + 1;
    }
}
