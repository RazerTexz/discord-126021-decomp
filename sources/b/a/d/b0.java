package b.a.d;

import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: Add missing generic type declarations: [R, T] */
/* JADX INFO: compiled from: AppTransformers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b0<R, T> extends d0.z.d.o implements Function1<T, Observable<R>> {
    public final /* synthetic */ Object $switchedValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(Object obj) {
        super(1);
        this.$switchedValue = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        j0.l.e.k kVar = new j0.l.e.k(this.$switchedValue);
        d0.z.d.m.checkNotNullExpressionValue(kVar, "Observable.just(switchedValue)");
        return kVar;
    }
}
