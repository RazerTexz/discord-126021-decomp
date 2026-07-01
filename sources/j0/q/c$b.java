package j0.q;

import j0.g;
import j0.l.a.e;
import java.util.ArrayList;
import java.util.List;
import rx.Subscriber;

/* JADX INFO: compiled from: SubjectSubscriptionManager.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c$b<T> implements g<T> {
    public final Subscriber<? super T> j;
    public boolean k = true;
    public boolean l;
    public List<Object> m;
    public boolean n;

    public c$b(Subscriber<? super T> subscriber) {
        this.j = subscriber;
    }

    public void a(Object obj) {
        if (!this.n) {
            synchronized (this) {
                this.k = false;
                if (this.l) {
                    if (this.m == null) {
                        this.m = new ArrayList();
                    }
                    this.m.add(obj);
                    return;
                }
                this.n = true;
            }
        }
        e.a(this.j, obj);
    }

    @Override // j0.g
    public void onCompleted() {
        this.j.onCompleted();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        this.j.onError(th);
    }

    @Override // j0.g
    public void onNext(T t) {
        this.j.onNext(t);
    }
}
