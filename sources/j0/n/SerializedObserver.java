package j0.n;

import b.i.a.f.e.o.f;
import j0.Observer2;
import j0.l.a.NotificationLite;
import rx.exceptions.OnErrorThrowable;

/* JADX INFO: renamed from: j0.n.c, reason: use source file name */
/* JADX INFO: compiled from: SerializedObserver.java */
/* JADX INFO: loaded from: classes3.dex */
public class SerializedObserver<T> implements Observer2<T> {
    public final Observer2<? super T> j;
    public boolean k;
    public volatile boolean l;
    public a m;

    /* JADX INFO: renamed from: j0.n.c$a */
    /* JADX INFO: compiled from: SerializedObserver.java */
    public static final class a {
        public Object[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3800b;

        public void a(Object obj) {
            int i = this.f3800b;
            Object[] objArr = this.a;
            if (objArr == null) {
                objArr = new Object[16];
                this.a = objArr;
            } else if (i == objArr.length) {
                Object[] objArr2 = new Object[(i >> 2) + i];
                System.arraycopy(objArr, 0, objArr2, 0, i);
                this.a = objArr2;
                objArr = objArr2;
            }
            objArr[i] = obj;
            this.f3800b = i + 1;
        }
    }

    public SerializedObserver(Observer2<? super T> observer2) {
        this.j = observer2;
    }

    @Override // j0.Observer2
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
            a aVar = this.m;
            if (aVar == null) {
                aVar = new a();
                this.m = aVar;
            }
            aVar.a(NotificationLite.a);
        }
    }

    @Override // j0.Observer2
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
            a aVar = this.m;
            if (aVar == null) {
                aVar = new a();
                this.m = aVar;
            }
            aVar.a(new NotificationLite.c(th));
        }
    }

    @Override // j0.Observer2
    public void onNext(T t) {
        if (this.l) {
            return;
        }
        synchronized (this) {
            if (this.l) {
                return;
            }
            if (this.k) {
                a aVar = this.m;
                if (aVar == null) {
                    aVar = new a();
                    this.m = aVar;
                }
                if (t == null) {
                    t = (T) NotificationLite.f3771b;
                }
                aVar.a(t);
                return;
            }
            this.k = true;
            try {
                this.j.onNext(t);
                while (true) {
                    synchronized (this) {
                        a aVar2 = this.m;
                        if (aVar2 == null) {
                            this.k = false;
                            return;
                        }
                        this.m = null;
                        for (Object obj : aVar2.a) {
                            if (obj == null) {
                                break;
                            }
                            try {
                                if (NotificationLite.a(this.j, obj)) {
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
