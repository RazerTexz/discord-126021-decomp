package p007b.p452o.p453a.p455n.p463v;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.Callable;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p452o.p453a.C5103b;
import p007b.p452o.p453a.p455n.AbstractC5135i;
import p007b.p452o.p453a.p467r.C5206g;

/* JADX INFO: renamed from: b.o.a.n.v.a */
/* JADX INFO: compiled from: CameraOrchestrator.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5174a {

    /* JADX INFO: renamed from: a */
    public static final C5103b f14005a = new C5103b(C5174a.class.getSimpleName());

    /* JADX INFO: renamed from: b */
    public final b f14006b;

    /* JADX INFO: renamed from: c */
    public final ArrayDeque<c<?>> f14007c = new ArrayDeque<>();

    /* JADX INFO: renamed from: d */
    public boolean f14008d = false;

    /* JADX INFO: renamed from: e */
    public final Object f14009e = new Object();

    /* JADX INFO: renamed from: b.o.a.n.v.a$a */
    /* JADX INFO: compiled from: CameraOrchestrator.java */
    public class a implements Callable<Task<Void>> {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Runnable f14010j;

        public a(C5174a c5174a, Runnable runnable) {
            this.f14010j = runnable;
        }

        @Override // java.util.concurrent.Callable
        public Task<Void> call() throws Exception {
            this.f14010j.run();
            return C3404f.m4264Z(null);
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.v.a$b */
    /* JADX INFO: compiled from: CameraOrchestrator.java */
    public interface b {
    }

    /* JADX INFO: renamed from: b.o.a.n.v.a$c */
    /* JADX INFO: compiled from: CameraOrchestrator.java */
    public static class c<T> {

        /* JADX INFO: renamed from: a */
        public final String f14011a;

        /* JADX INFO: renamed from: b */
        public final TaskCompletionSource<T> f14012b = new TaskCompletionSource<>();

        /* JADX INFO: renamed from: c */
        public final Callable<Task<T>> f14013c;

        /* JADX INFO: renamed from: d */
        public final boolean f14014d;

        /* JADX INFO: renamed from: e */
        public final long f14015e;

        public c(String str, Callable callable, boolean z2, long j, a aVar) {
            this.f14011a = str;
            this.f14013c = callable;
            this.f14014d = z2;
            this.f14015e = j;
        }
    }

    public C5174a(@NonNull b bVar) {
        this.f14006b = bVar;
    }

    /* JADX INFO: renamed from: a */
    public static void m7362a(C5174a c5174a, c cVar) {
        if (!c5174a.f14008d) {
            StringBuilder sbM833U = C1643a.m833U("mJobRunning was not true after completing job=");
            sbM833U.append(cVar.f14011a);
            throw new IllegalStateException(sbM833U.toString());
        }
        c5174a.f14008d = false;
        c5174a.f14007c.remove(cVar);
        C5206g c5206g = AbstractC5135i.this.f13919k;
        c5206g.f14132f.postDelayed(new RunnableC5175b(c5174a), 0L);
    }

    @NonNull
    /* JADX INFO: renamed from: b */
    public Task<Void> m7363b(@NonNull String str, boolean z2, @NonNull Runnable runnable) {
        return m7365d(str, z2, 0L, new a(this, runnable));
    }

    @NonNull
    /* JADX INFO: renamed from: c */
    public Task<Void> m7364c(@NonNull String str, boolean z2, long j, @NonNull Runnable runnable) {
        return m7365d(str, z2, j, new a(this, runnable));
    }

    @NonNull
    /* JADX INFO: renamed from: d */
    public final <T> Task<T> m7365d(@NonNull String str, boolean z2, long j, @NonNull Callable<Task<T>> callable) {
        f14005a.m7159a(1, str.toUpperCase(), "- Scheduling.");
        c<?> cVar = new c<>(str, callable, z2, System.currentTimeMillis() + j, null);
        synchronized (this.f14009e) {
            this.f14007c.addLast(cVar);
            AbstractC5135i.this.f13919k.f14132f.postDelayed(new RunnableC5175b(this), j);
        }
        return cVar.f14012b.f20845a;
    }

    /* JADX INFO: renamed from: e */
    public void m7366e(@NonNull String str, int i) {
        synchronized (this.f14009e) {
            ArrayList arrayList = new ArrayList();
            for (c<?> cVar : this.f14007c) {
                if (cVar.f14011a.equals(str)) {
                    arrayList.add(cVar);
                }
            }
            f14005a.m7159a(0, "trim: name=", str, "scheduled=", Integer.valueOf(arrayList.size()), "allowed=", Integer.valueOf(i));
            int iMax = Math.max(arrayList.size() - i, 0);
            if (iMax > 0) {
                Collections.reverse(arrayList);
                Iterator it = arrayList.subList(0, iMax).iterator();
                while (it.hasNext()) {
                    this.f14007c.remove((c) it.next());
                }
            }
        }
    }
}
