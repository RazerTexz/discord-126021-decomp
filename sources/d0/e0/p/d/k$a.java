package d0.e0.p.d;

import kotlin.Unit;
import kotlin.reflect.KMutableProperty0$Setter;

/* JADX INFO: compiled from: KProperty0Impl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k$a<R> extends s$d<R> implements KMutableProperty0$Setter<R> {
    public final k<R> q;

    public k$a(k<R> kVar) {
        d0.z.d.m.checkNotNullParameter(kVar, "property");
        this.q = kVar;
    }

    @Override // d0.e0.p.d.s$a
    public k<R> getProperty() {
        return this.q;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
        invoke2(obj);
        return Unit.a;
    }

    @Override // d0.e0.p.d.s$a
    public /* bridge */ /* synthetic */ s getProperty() {
        return getProperty();
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(R r) {
        getProperty().set(r);
    }
}
