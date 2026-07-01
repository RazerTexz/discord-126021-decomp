package b.a.e;

import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;
import rx.functions.Action1;

/* JADX INFO: renamed from: b.a.e.c, reason: use source file name */
/* JADX INFO: compiled from: Backgrounded.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Backgrounded3 implements Action1 {
    public final /* synthetic */ Function1 j;

    public Backgrounded3(Function1 function1) {
        this.j = function1;
    }

    @Override // rx.functions.Action1
    public final /* synthetic */ void call(Object obj) {
        Intrinsics3.checkNotNullExpressionValue(this.j.invoke(obj), "invoke(...)");
    }
}
