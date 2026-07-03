package p686z;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: z.a */
/* JADX INFO: compiled from: AndroidExecutors.java */
/* JADX INFO: loaded from: classes.dex */
public final class C13196a {

    /* JADX INFO: renamed from: a */
    public static final C13196a f27960a = new C13196a();

    /* JADX INFO: renamed from: b */
    public static final int f27961b;

    /* JADX INFO: renamed from: c */
    public static final int f27962c;

    /* JADX INFO: renamed from: d */
    public static final int f27963d;

    /* JADX INFO: renamed from: e */
    public final Executor f27964e = new b(null);

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
        f27961b = iAvailableProcessors;
        f27962c = iAvailableProcessors + 1;
        f27963d = (iAvailableProcessors * 2) + 1;
    }
}
