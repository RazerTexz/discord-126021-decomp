package d0.e0.p.d;

import kotlin.reflect.KProperty0$Getter;

/* JADX INFO: compiled from: KProperty0Impl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p$a<R> extends s$c<R> implements KProperty0$Getter<R> {
    public final p<R> q;

    /* JADX WARN: Multi-variable type inference failed */
    public p$a(p<? extends R> pVar) {
        d0.z.d.m.checkNotNullParameter(pVar, "property");
        this.q = pVar;
    }

    @Override // d0.e0.p.d.s$a
    public p<R> getProperty() {
        return this.q;
    }

    @Override // kotlin.jvm.functions.Function0
    public R invoke() {
        return getProperty().get();
    }

    @Override // d0.e0.p.d.s$a
    public /* bridge */ /* synthetic */ s getProperty() {
        return getProperty();
    }
}
