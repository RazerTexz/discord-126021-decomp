package j0;

import rx.Observable;

/* JADX INFO: compiled from: Completable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements d$a {
    public final /* synthetic */ Observable j;

    public c(Observable observable) {
        this.j = observable;
    }

    @Override // rx.functions.Action1
    public void call(e eVar) {
        e eVar2 = eVar;
        b bVar = new b(this, eVar2);
        eVar2.a(bVar);
        this.j.i0(bVar);
    }
}
