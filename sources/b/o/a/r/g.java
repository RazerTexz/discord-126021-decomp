package b.o.a.r;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: WorkerHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class g {
    public static final b.o.a.b a = new b.o.a.b(g.class.getSimpleName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, WeakReference<g>> f1952b = new ConcurrentHashMap<>(4);
    public static g c;
    public String d;
    public HandlerThread e;
    public Handler f;
    public Executor g;

    public g(@NonNull String str) {
        this.d = str;
        g$a g_a = new g$a(this, str);
        this.e = g_a;
        g_a.setDaemon(true);
        this.e.start();
        this.f = new Handler(this.e.getLooper());
        this.g = new g$b(this);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f.post(new g$c(this, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
    }

    public static void a(@NonNull Runnable runnable) {
        g gVarB = b("FallbackCameraThread");
        c = gVarB;
        gVarB.f.post(runnable);
    }

    @NonNull
    public static g b(@NonNull String str) {
        ConcurrentHashMap<String, WeakReference<g>> concurrentHashMap = f1952b;
        if (concurrentHashMap.containsKey(str)) {
            g gVar = concurrentHashMap.get(str).get();
            if (gVar == null) {
                a.a(2, "get:", "Thread reference died. Removing.", str);
                concurrentHashMap.remove(str);
            } else {
                if (gVar.e.isAlive() && !gVar.e.isInterrupted()) {
                    a.a(2, "get:", "Reusing cached worker handler.", str);
                    return gVar;
                }
                HandlerThread handlerThread = gVar.e;
                if (handlerThread.isAlive()) {
                    handlerThread.interrupt();
                    handlerThread.quit();
                }
                concurrentHashMap.remove(gVar.d);
                a.a(2, "get:", "Thread reference found, but not alive or interrupted.", "Removing.", str);
                concurrentHashMap.remove(str);
            }
        }
        a.a(1, "get:", "Creating new handler.", str);
        g gVar2 = new g(str);
        concurrentHashMap.put(str, new WeakReference<>(gVar2));
        return gVar2;
    }

    public void c(@NonNull Runnable runnable) {
        if (Thread.currentThread() == this.e) {
            runnable.run();
        } else {
            this.f.post(runnable);
        }
    }
}
