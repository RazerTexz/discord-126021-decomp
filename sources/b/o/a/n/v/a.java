package b.o.a.n.v;

import androidx.annotation.NonNull;
import b.o.a.n.i$c;
import com.google.android.gms.tasks.Task;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: CameraOrchestrator.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static final b.o.a.b a = new b.o.a.b(a.class.getSimpleName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a$b f1941b;
    public final ArrayDeque<a$c<?>> c = new ArrayDeque<>();
    public boolean d = false;
    public final Object e = new Object();

    public a(@NonNull a$b a_b) {
        this.f1941b = a_b;
    }

    public static void a(a aVar, a$c a_c) {
        if (!aVar.d) {
            StringBuilder sbU = b.d.b.a.a.U("mJobRunning was not true after completing job=");
            sbU.append(a_c.a);
            throw new IllegalStateException(sbU.toString());
        }
        aVar.d = false;
        aVar.c.remove(a_c);
        b.o.a.r.g gVar = ((i$c) aVar.f1941b).a.k;
        gVar.f.postDelayed(new b(aVar), 0L);
    }

    @NonNull
    public Task<Void> b(@NonNull String str, boolean z2, @NonNull Runnable runnable) {
        return d(str, z2, 0L, new a$a(this, runnable));
    }

    @NonNull
    public Task<Void> c(@NonNull String str, boolean z2, long j, @NonNull Runnable runnable) {
        return d(str, z2, j, new a$a(this, runnable));
    }

    @NonNull
    public final <T> Task<T> d(@NonNull String str, boolean z2, long j, @NonNull Callable<Task<T>> callable) {
        a.a(1, str.toUpperCase(), "- Scheduling.");
        a$c<?> a_c = new a$c<>(str, callable, z2, System.currentTimeMillis() + j, null);
        synchronized (this.e) {
            this.c.addLast(a_c);
            ((i$c) this.f1941b).a.k.f.postDelayed(new b(this), j);
        }
        return a_c.f1942b.a;
    }

    public void e(@NonNull String str, int i) {
        synchronized (this.e) {
            ArrayList arrayList = new ArrayList();
            for (a$c<?> a_c : this.c) {
                if (a_c.a.equals(str)) {
                    arrayList.add(a_c);
                }
            }
            a.a(0, "trim: name=", str, "scheduled=", Integer.valueOf(arrayList.size()), "allowed=", Integer.valueOf(i));
            int iMax = Math.max(arrayList.size() - i, 0);
            if (iMax > 0) {
                Collections.reverse(arrayList);
                Iterator it = arrayList.subList(0, iMax).iterator();
                while (it.hasNext()) {
                    this.c.remove((a$c) it.next());
                }
            }
        }
    }
}
