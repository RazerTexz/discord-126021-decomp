package p637j0.p651n;

import p637j0.InterfaceC12581g;
import p658rx.exceptions.OnErrorNotImplementedException;

/* JADX INFO: renamed from: j0.n.a */
/* JADX INFO: compiled from: Observers.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12758a {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC12581g<Object> f27363a = new a();

    /* JADX INFO: renamed from: j0.n.a$a */
    /* JADX INFO: compiled from: Observers.java */
    public static class a implements InterfaceC12581g<Object> {
        @Override // p637j0.InterfaceC12581g
        public final void onCompleted() {
        }

        @Override // p637j0.InterfaceC12581g
        public final void onError(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }

        @Override // p637j0.InterfaceC12581g
        public final void onNext(Object obj) {
        }
    }
}
