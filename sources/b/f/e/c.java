package b.f.e;

import android.util.Pair;
import com.facebook.datasource.DataSource;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: AbstractDataSource.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c<T> implements DataSource<T> {
    public Map<String, Object> a;
    public T d = null;
    public Throwable e = null;
    public float f = 0.0f;
    public boolean c = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f475b = 1;
    public final ConcurrentLinkedQueue<Pair<f<T>, Executor>> g = new ConcurrentLinkedQueue<>();

    @Override // com.facebook.datasource.DataSource
    public Map<String, Object> a() {
        return this.a;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized boolean b() {
        return this.d != null;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized boolean c() {
        return this.f475b != 1;
    }

    @Override // com.facebook.datasource.DataSource
    public boolean close() {
        synchronized (this) {
            if (this.c) {
                return false;
            }
            this.c = true;
            T t = this.d;
            this.d = null;
            if (t != null) {
                g(t);
            }
            if (!c()) {
                j();
            }
            synchronized (this) {
                this.g.clear();
            }
            return true;
        }
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized Throwable d() {
        return this.e;
    }

    @Override // com.facebook.datasource.DataSource
    public boolean e() {
        return false;
    }

    @Override // com.facebook.datasource.DataSource
    public void f(f<T> fVar, Executor executor) {
        Objects.requireNonNull(executor);
        synchronized (this) {
            if (this.c) {
                return;
            }
            boolean z2 = true;
            if (this.f475b == 1) {
                this.g.add(Pair.create(fVar, executor));
            }
            if (!b() && !c() && !n()) {
                z2 = false;
            }
            if (z2) {
                executor.execute(new a(this, h(), fVar, n()));
            }
        }
    }

    public void g(T t) {
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized float getProgress() {
        return this.f;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized T getResult() {
        return this.d;
    }

    public synchronized boolean h() {
        return this.f475b == 3;
    }

    public synchronized boolean i() {
        return this.c;
    }

    public final void j() {
        boolean zH = h();
        boolean zN = n();
        for (Pair<f<T>, Executor> pair : this.g) {
            ((Executor) pair.second).execute(new a(this, zH, (f) pair.first, zN));
        }
    }

    public boolean k(Throwable th, Map<String, Object> map) {
        boolean z2;
        synchronized (this) {
            z2 = true;
            if (this.c || this.f475b != 1) {
                z2 = false;
            } else {
                this.f475b = 3;
                this.e = th;
                this.a = map;
            }
        }
        if (z2) {
            j();
        }
        return z2;
    }

    public boolean l(float f) {
        boolean z2;
        synchronized (this) {
            z2 = false;
            if (!this.c && this.f475b == 1 && f >= this.f) {
                this.f = f;
                z2 = true;
            }
        }
        if (z2) {
            for (Pair<f<T>, Executor> pair : this.g) {
                ((Executor) pair.second).execute(new b(this, (f) pair.first));
            }
        }
        return z2;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0040 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m(T t, boolean z2, Map<String, Object> map) throws Throwable {
        T t2;
        this.a = map;
        T t3 = null;
        try {
            synchronized (this) {
                try {
                    boolean z3 = true;
                    try {
                        if (this.c || this.f475b != 1) {
                            z3 = false;
                            if (t != null) {
                                g(t);
                            }
                        } else {
                            if (z2) {
                                this.f475b = 2;
                                this.f = 1.0f;
                            }
                            t2 = this.d;
                            if (t2 != t) {
                                try {
                                    this.d = t;
                                    t = t2;
                                } catch (Throwable th) {
                                    th = th;
                                    t3 = t2;
                                    T t4 = t3;
                                    while (true) {
                                        try {
                                            throw th;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            t3 = t4;
                                            if (t3 != null) {
                                                g(t3);
                                            }
                                            throw th;
                                        }
                                    }
                                }
                            } else {
                                t = null;
                            }
                            if (t != null) {
                                g(t);
                            }
                        }
                        if (z3) {
                            j();
                        }
                        return z3;
                    } catch (Throwable th3) {
                        t2 = t;
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public final synchronized boolean n() {
        return i() && !c();
    }
}
