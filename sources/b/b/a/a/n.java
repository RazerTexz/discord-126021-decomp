package b.b.a.a;

import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;
import rx.functions.Action1;

/* JADX INFO: compiled from: FlexInputFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n implements Action1 {
    public final /* synthetic */ Function1 j;

    public n(Function1 function1) {
        this.j = function1;
    }

    @Override // rx.functions.Action1
    public final /* synthetic */ void call(Object obj) {
        Intrinsics3.checkNotNullExpressionValue(this.j.invoke(obj), "invoke(...)");
    }
}
