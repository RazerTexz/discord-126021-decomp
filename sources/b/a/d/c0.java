package b.a.d;

import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.functions.Action1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: AppTransformers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c0<T> extends Lambda implements Function1<T, Unit> {
    public final /* synthetic */ Action1 $action;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(Action1 action1) {
        super(1);
        this.$action = action1;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Object obj) {
        this.$action.call(obj);
        return Unit.a;
    }
}
