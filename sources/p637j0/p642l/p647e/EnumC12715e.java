package p637j0.p642l.p647e;

import p637j0.C12580f;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.exceptions.OnErrorNotImplementedException;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: j0.l.e.e */
/* JADX INFO: compiled from: InternalObservableUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC12715e {
    ;


    /* JADX INFO: renamed from: j */
    public static final e f27270j = new e();

    /* JADX INFO: renamed from: k */
    public static final b f27271k = new b();

    /* JADX INFO: renamed from: l */
    public static final Action1<Throwable> f27272l = new Action1<Throwable>() { // from class: j0.l.e.e.a
        @Override // p658rx.functions.Action1
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    };

    /* JADX INFO: renamed from: j0.l.e.e$b */
    /* JADX INFO: compiled from: InternalObservableUtils.java */
    public static final class b implements InterfaceC12589b<C12580f<?>, Throwable> {
        @Override // p637j0.p641k.InterfaceC12589b
        public Throwable call(C12580f<?> c12580f) {
            return c12580f.f26690c;
        }
    }

    /* JADX INFO: renamed from: j0.l.e.e$c */
    /* JADX INFO: compiled from: InternalObservableUtils.java */
    public static final class c implements InterfaceC12589b<Observable<? extends C12580f<?>>, Observable<?>> {

        /* JADX INFO: renamed from: j */
        public final InterfaceC12589b<? super Observable<? extends Void>, ? extends Observable<?>> f27274j;

        public c(InterfaceC12589b<? super Observable<? extends Void>, ? extends Observable<?>> interfaceC12589b) {
            this.f27274j = interfaceC12589b;
        }

        @Override // p637j0.p641k.InterfaceC12589b
        public Observable<?> call(Observable<? extends C12580f<?>> observable) {
            return this.f27274j.call(observable.m11083G(EnumC12715e.f27270j));
        }
    }

    /* JADX INFO: renamed from: j0.l.e.e$d */
    /* JADX INFO: compiled from: InternalObservableUtils.java */
    public static final class d implements InterfaceC12589b<Observable<? extends C12580f<?>>, Observable<?>> {

        /* JADX INFO: renamed from: j */
        public final InterfaceC12589b<? super Observable<? extends Throwable>, ? extends Observable<?>> f27275j;

        public d(InterfaceC12589b<? super Observable<? extends Throwable>, ? extends Observable<?>> interfaceC12589b) {
            this.f27275j = interfaceC12589b;
        }

        @Override // p637j0.p641k.InterfaceC12589b
        public Observable<?> call(Observable<? extends C12580f<?>> observable) {
            return this.f27275j.call(observable.m11083G(EnumC12715e.f27271k));
        }
    }

    /* JADX INFO: renamed from: j0.l.e.e$e */
    /* JADX INFO: compiled from: InternalObservableUtils.java */
    public static final class e implements InterfaceC12589b<Object, Void> {
        @Override // p637j0.p641k.InterfaceC12589b
        public /* bridge */ /* synthetic */ Void call(Object obj) {
            return null;
        }
    }
}
