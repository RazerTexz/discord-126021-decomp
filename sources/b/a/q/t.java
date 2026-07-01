package b.a.q;

import kotlin.Unit;
import rx.functions.Action1;

/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class t<T> implements Action1<Unit> {
    public final /* synthetic */ w j;

    public t(w wVar) {
        this.j = wVar;
    }

    @Override // rx.functions.Action1
    public void call(Unit unit) {
        this.j.this$0.s(new s(this));
    }
}
