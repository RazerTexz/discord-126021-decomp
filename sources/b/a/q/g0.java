package b.a.q;

import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;
import rx.functions.Action1;

/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class g0 implements Action1 {
    public final /* synthetic */ Function1 j;

    public g0(Function1 function1) {
        this.j = function1;
    }

    @Override // rx.functions.Action1
    public final /* synthetic */ void call(Object obj) {
        Intrinsics3.checkNotNullExpressionValue(this.j.invoke(obj), "invoke(...)");
    }
}
