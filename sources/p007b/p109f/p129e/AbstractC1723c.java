package p007b.p109f.p129e;

import android.util.Pair;
import com.facebook.datasource.DataSource;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.f.e.c */
/* JADX INFO: compiled from: AbstractDataSource.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1723c<T> implements DataSource<T> {

    /* JADX INFO: renamed from: a */
    public Map<String, Object> f3152a;

    /* JADX INFO: renamed from: d */
    public T f3155d = null;

    /* JADX INFO: renamed from: e */
    public Throwable f3156e = null;

    /* JADX INFO: renamed from: f */
    public float f3157f = 0.0f;

    /* JADX INFO: renamed from: c */
    public boolean f3154c = false;

    /* JADX INFO: renamed from: b */
    public int f3153b = 1;

    /* JADX INFO: renamed from: g */
    public final ConcurrentLinkedQueue<Pair<InterfaceC1726f<T>, Executor>> f3158g = new ConcurrentLinkedQueue<>();

    @Override // com.facebook.datasource.DataSource
    /* JADX INFO: renamed from: a */
    public Map<String, Object> mo1017a() {
        return this.f3152a;
    }

    @Override // com.facebook.datasource.DataSource
    /* JADX INFO: renamed from: b */
    public synchronized boolean mo1018b() {
        return this.f3155d != null;
    }

    @Override // com.facebook.datasource.DataSource
    /* JADX INFO: renamed from: c */
    public synchronized boolean mo1019c() {
        return this.f3153b != 1;
    }

    @Override // com.facebook.datasource.DataSource
    public boolean close() {
        synchronized (this) {
            if (this.f3154c) {
                return false;
            }
            this.f3154c = true;
            T t = this.f3155d;
            this.f3155d = null;
            if (t != null) {
                mo1023g(t);
            }
            if (!mo1019c()) {
                m1026j();
            }
            synchronized (this) {
                this.f3158g.clear();
            }
            return true;
        }
    }

    @Override // com.facebook.datasource.DataSource
    /* JADX INFO: renamed from: d */
    public synchronized Throwable mo1020d() {
        return this.f3156e;
    }

    @Override // com.facebook.datasource.DataSource
    /* JADX INFO: renamed from: e */
    public boolean mo1021e() {
        return false;
    }

    @Override // com.facebook.datasource.DataSource
    /* JADX INFO: renamed from: f */
    public void mo1022f(InterfaceC1726f<T> interfaceC1726f, Executor executor) {
        Objects.requireNonNull(executor);
        synchronized (this) {
            if (this.f3154c) {
                return;
            }
            boolean z2 = true;
            if (this.f3153b == 1) {
                this.f3158g.add(Pair.create(interfaceC1726f, executor));
            }
            if (!mo1018b() && !mo1019c() && !m1030n()) {
                z2 = false;
            }
            if (z2) {
                executor.execute(new RunnableC1721a(this, m1024h(), interfaceC1726f, m1030n()));
            }
        }
    }

    /* JADX INFO: renamed from: g */
    public void mo1023g(T t) {
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized float getProgress() {
        return this.f3157f;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized T getResult() {
        return this.f3155d;
    }

    /* JADX INFO: renamed from: h */
    public synchronized boolean m1024h() {
        return this.f3153b == 3;
    }

    /* JADX INFO: renamed from: i */
    public synchronized boolean m1025i() {
        return this.f3154c;
    }

    /* JADX INFO: renamed from: j */
    public final void m1026j() {
        boolean zM1024h = m1024h();
        boolean zM1030n = m1030n();
        for (Pair<InterfaceC1726f<T>, Executor> pair : this.f3158g) {
            ((Executor) pair.second).execute(new RunnableC1721a(this, zM1024h, (InterfaceC1726f) pair.first, zM1030n));
        }
    }

    /* JADX INFO: renamed from: k */
    public boolean m1027k(Throwable th, Map<String, Object> map) {
        boolean z2;
        synchronized (this) {
            z2 = true;
            if (this.f3154c || this.f3153b != 1) {
                z2 = false;
            } else {
                this.f3153b = 3;
                this.f3156e = th;
                this.f3152a = map;
            }
        }
        if (z2) {
            m1026j();
        }
        return z2;
    }

    /* JADX INFO: renamed from: l */
    public boolean m1028l(float f) {
        boolean z2;
        synchronized (this) {
            z2 = false;
            if (!this.f3154c && this.f3153b == 1 && f >= this.f3157f) {
                this.f3157f = f;
                z2 = true;
            }
        }
        if (z2) {
            for (Pair<InterfaceC1726f<T>, Executor> pair : this.f3158g) {
                ((Executor) pair.second).execute(new RunnableC1722b(this, (InterfaceC1726f) pair.first));
            }
        }
        return z2;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0040 */
    /* JADX INFO: renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m1029m(T t, boolean z2, Map<String, Object> map) throws Throwable {
        T t2;
        this.f3152a = map;
        T t3 = null;
        try {
            synchronized (this) {
                try {
                    boolean z3 = true;
                    try {
                        if (this.f3154c || this.f3153b != 1) {
                            z3 = false;
                            if (t != null) {
                                mo1023g(t);
                            }
                        } else {
                            if (z2) {
                                this.f3153b = 2;
                                this.f3157f = 1.0f;
                            }
                            t2 = this.f3155d;
                            if (t2 != t) {
                                try {
                                    this.f3155d = t;
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
                                                mo1023g(t3);
                                            }
                                            throw th;
                                        }
                                    }
                                }
                            } else {
                                t = null;
                            }
                            if (t != null) {
                                mo1023g(t);
                            }
                        }
                        if (z3) {
                            m1026j();
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

    /* JADX INFO: renamed from: n */
    public final synchronized boolean m1030n() {
        return m1025i() && !mo1019c();
    }
}
