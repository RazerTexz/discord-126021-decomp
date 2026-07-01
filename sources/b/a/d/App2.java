package b.a.d;

import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function3;
import rx.functions.Action3;

/* JADX INFO: renamed from: b.a.d.a, reason: use source file name */
/* JADX INFO: compiled from: App.kt */
/* JADX INFO: loaded from: classes.dex */
public final class App2 implements Action3 {
    public final /* synthetic */ Function3 j;

    public App2(Function3 function3) {
        this.j = function3;
    }

    @Override // rx.functions.Action3
    public final /* synthetic */ void call(Object obj, Object obj2, Object obj3) {
        Intrinsics3.checkNotNullExpressionValue(this.j.invoke(obj, obj2, obj3), "invoke(...)");
    }
}
