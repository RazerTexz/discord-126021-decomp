package p007b.p008a.p018d;

import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;

/* JADX INFO: Add missing generic type declarations: [R, T] */
/* JADX INFO: renamed from: b.a.d.b0 */
/* JADX INFO: compiled from: AppTransformers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0855b0<R, T> extends AbstractC12240o implements Function1<T, Observable<R>> {
    public final /* synthetic */ Object $switchedValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0855b0(Object obj) {
        super(1);
        this.$switchedValue = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        C12721k c12721k = new C12721k(this.$switchedValue);
        C12238m.checkNotNullExpressionValue(c12721k, "Observable.just(switchedValue)");
        return c12721k;
    }
}
