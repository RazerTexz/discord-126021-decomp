package b.c.a;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: LottieTask.java */
/* JADX INFO: loaded from: classes.dex */
public class r<T> {
    public static Executor a = Executors.newCachedThreadPool();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<l<T>> f374b = new LinkedHashSet(1);
    public final Set<l<Throwable>> c = new LinkedHashSet(1);
    public final Handler d = new Handler(Looper.getMainLooper());

    @Nullable
    public volatile p<T> e = null;

    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public r(Callable<p<T>> callable) {
        a.execute(new r$a(this, callable));
    }

    public synchronized r<T> a(l<Throwable> lVar) {
        if (this.e != null && this.e.f373b != null) {
            lVar.a(this.e.f373b);
        }
        this.c.add(lVar);
        return this;
    }

    public synchronized r<T> b(l<T> lVar) {
        if (this.e != null && this.e.a != null) {
            lVar.a(this.e.a);
        }
        this.f374b.add(lVar);
        return this;
    }

    public final void c(@Nullable p<T> pVar) {
        if (this.e != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.e = pVar;
        this.d.post(new q(this));
    }
}
