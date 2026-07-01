package b.o.a.n.v;

import androidx.annotation.NonNull;
import b.d.b.a.outline;
import b.o.a.CameraLogger;
import b.o.a.n.CameraEngine;
import b.o.a.r.WorkerHandler;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: b.o.a.n.v.a, reason: use source file name */
/* JADX INFO: compiled from: CameraOrchestrator.java */
/* JADX INFO: loaded from: classes3.dex */
public class CameraOrchestrator {
    public static final CameraLogger a = new CameraLogger(CameraOrchestrator.class.getSimpleName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f1941b;
    public final ArrayDeque<c<?>> c = new ArrayDeque<>();
    public boolean d = false;
    public final Object e = new Object();

    /* JADX INFO: renamed from: b.o.a.n.v.a$a */
    /* JADX INFO: compiled from: CameraOrchestrator.java */
    public class a implements Callable<Task<Void>> {
        public final /* synthetic */ Runnable j;

        public a(CameraOrchestrator cameraOrchestrator, Runnable runnable) {
            this.j = runnable;
        }

        @Override // java.util.concurrent.Callable
        public Task<Void> call() throws Exception {
            this.j.run();
            return b.i.a.f.e.o.f.Z(null);
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.v.a$b */
    /* JADX INFO: compiled from: CameraOrchestrator.java */
    public interface b {
    }

    /* JADX INFO: renamed from: b.o.a.n.v.a$c */
    /* JADX INFO: compiled from: CameraOrchestrator.java */
    public static class c<T> {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TaskCompletionSource<T> f1942b = new TaskCompletionSource<>();
        public final Callable<Task<T>> c;
        public final boolean d;
        public final long e;

        public c(String str, Callable callable, boolean z2, long j, a aVar) {
            this.a = str;
            this.c = callable;
            this.d = z2;
            this.e = j;
        }
    }

    public CameraOrchestrator(@NonNull b bVar) {
        this.f1941b = bVar;
    }

    public static void a(CameraOrchestrator cameraOrchestrator, c cVar) {
        if (!cameraOrchestrator.d) {
            StringBuilder sbU = outline.U("mJobRunning was not true after completing job=");
            sbU.append(cVar.a);
            throw new IllegalStateException(sbU.toString());
        }
        cameraOrchestrator.d = false;
        cameraOrchestrator.c.remove(cVar);
        WorkerHandler workerHandler = CameraEngine.this.k;
        workerHandler.f.postDelayed(new CameraOrchestrator2(cameraOrchestrator), 0L);
    }

    @NonNull
    public Task<Void> b(@NonNull String str, boolean z2, @NonNull Runnable runnable) {
        return d(str, z2, 0L, new a(this, runnable));
    }

    @NonNull
    public Task<Void> c(@NonNull String str, boolean z2, long j, @NonNull Runnable runnable) {
        return d(str, z2, j, new a(this, runnable));
    }

    @NonNull
    public final <T> Task<T> d(@NonNull String str, boolean z2, long j, @NonNull Callable<Task<T>> callable) {
        a.a(1, str.toUpperCase(), "- Scheduling.");
        c<?> cVar = new c<>(str, callable, z2, System.currentTimeMillis() + j, null);
        synchronized (this.e) {
            this.c.addLast(cVar);
            CameraEngine.this.k.f.postDelayed(new CameraOrchestrator2(this), j);
        }
        return cVar.f1942b.a;
    }

    public void e(@NonNull String str, int i) {
        synchronized (this.e) {
            ArrayList arrayList = new ArrayList();
            for (c<?> cVar : this.c) {
                if (cVar.a.equals(str)) {
                    arrayList.add(cVar);
                }
            }
            a.a(0, "trim: name=", str, "scheduled=", Integer.valueOf(arrayList.size()), "allowed=", Integer.valueOf(i));
            int iMax = Math.max(arrayList.size() - i, 0);
            if (iMax > 0) {
                Collections.reverse(arrayList);
                Iterator it = arrayList.subList(0, iMax).iterator();
                while (it.hasNext()) {
                    this.c.remove((c) it.next());
                }
            }
        }
    }
}
