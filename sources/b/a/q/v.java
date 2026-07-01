package b.a.q;

import rx.functions.Action1;

/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class v<T> implements Action1<Throwable> {
    public final /* synthetic */ w j;

    public v(w wVar) {
        this.j = wVar;
    }

    @Override // rx.functions.Action1
    public void call(Throwable th) {
        this.j.this$0.s(new u(this, th));
    }
}
