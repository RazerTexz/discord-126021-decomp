package j0.n;

import b.i.a.f.e.o.f;
import j0.g;
import j0.l.a.e$c;
import rx.exceptions.OnErrorThrowable;

/* JADX INFO: compiled from: SerializedObserver.java */
/* JADX INFO: loaded from: classes3.dex */
public class c<T> implements g<T> {
    public final g<? super T> j;
    public boolean k;
    public volatile boolean l;
    public c$a m;

    public c(g<? super T> gVar) {
        this.j = gVar;
    }

    @Override // j0.g
    public void onCompleted() {
        if (this.l) {
            return;
        }
        synchronized (this) {
            if (this.l) {
                return;
            }
            this.l = true;
            if (!this.k) {
                this.k = true;
                this.j.onCompleted();
                return;
            }
            c$a c_a = this.m;
            if (c_a == null) {
                c_a = new c$a();
                this.m = c_a;
            }
            c_a.a(j0.l.a.e.a);
        }
    }

    @Override // j0.g
    public void onError(Throwable th) {
        f.o1(th);
        if (this.l) {
            return;
        }
        synchronized (this) {
            if (this.l) {
                return;
            }
            this.l = true;
            if (!this.k) {
                this.k = true;
                this.j.onError(th);
                return;
            }
            c$a c_a = this.m;
            if (c_a == null) {
                c_a = new c$a();
                this.m = c_a;
            }
            c_a.a(new e$c(th));
        }
    }

    @Override // j0.g
    public void onNext(T t) {
        if (this.l) {
            return;
        }
        synchronized (this) {
            if (this.l) {
                return;
            }
            if (this.k) {
                c$a c_a = this.m;
                if (c_a == null) {
                    c_a = new c$a();
                    this.m = c_a;
                }
                if (t == null) {
                    t = (T) j0.l.a.e.f3771b;
                }
                c_a.a(t);
                return;
            }
            this.k = true;
            try {
                this.j.onNext(t);
                while (true) {
                    synchronized (this) {
                        c$a c_a2 = this.m;
                        if (c_a2 == null) {
                            this.k = false;
                            return;
                        }
                        this.m = null;
                        for (Object obj : c_a2.a) {
                            if (obj == null) {
                                break;
                            }
                            try {
                                if (j0.l.a.e.a(this.j, obj)) {
                                    this.l = true;
                                    return;
                                }
                            } catch (Throwable th) {
                                this.l = true;
                                f.o1(th);
                                this.j.onError(OnErrorThrowable.a(th, t));
                                return;
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                this.l = true;
                f.p1(th2, this.j, t);
            }
        }
    }
}
