package j0.l.e;

import j0.Notification;
import j0.k.Func1;
import rx.Observable;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action1;

/* JADX INFO: renamed from: j0.l.e.e, reason: use source file name */
/* JADX INFO: compiled from: InternalObservableUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public enum InternalObservableUtils {
    ;

    public static final e j = new e();
    public static final b k = new b();
    public static final Action1<Throwable> l = new Action1<Throwable>() { // from class: j0.l.e.e.a
        @Override // rx.functions.Action1
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    };

    /* JADX INFO: renamed from: j0.l.e.e$b */
    /* JADX INFO: compiled from: InternalObservableUtils.java */
    public static final class b implements Func1<Notification<?>, Throwable> {
        @Override // j0.k.Func1
        public Throwable call(Notification<?> notification) {
            return notification.c;
        }
    }

    /* JADX INFO: renamed from: j0.l.e.e$c */
    /* JADX INFO: compiled from: InternalObservableUtils.java */
    public static final class c implements Func1<Observable<? extends Notification<?>>, Observable<?>> {
        public final Func1<? super Observable<? extends Void>, ? extends Observable<?>> j;

        public c(Func1<? super Observable<? extends Void>, ? extends Observable<?>> func1) {
            this.j = func1;
        }

        @Override // j0.k.Func1
        public Observable<?> call(Observable<? extends Notification<?>> observable) {
            return this.j.call(observable.G(InternalObservableUtils.j));
        }
    }

    /* JADX INFO: renamed from: j0.l.e.e$d */
    /* JADX INFO: compiled from: InternalObservableUtils.java */
    public static final class d implements Func1<Observable<? extends Notification<?>>, Observable<?>> {
        public final Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> j;

        public d(Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> func1) {
            this.j = func1;
        }

        @Override // j0.k.Func1
        public Observable<?> call(Observable<? extends Notification<?>> observable) {
            return this.j.call(observable.G(InternalObservableUtils.k));
        }
    }

    /* JADX INFO: renamed from: j0.l.e.e$e */
    /* JADX INFO: compiled from: InternalObservableUtils.java */
    public static final class e implements Func1<Object, Void> {
        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Void call(Object obj) {
            return null;
        }
    }
}
