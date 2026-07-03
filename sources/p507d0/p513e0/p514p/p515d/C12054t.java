package p507d0.p513e0.p514p.p515d;

import kotlin.jvm.functions.Function0;
import p507d0.p513e0.p514p.p515d.AbstractC12053s;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: d0.e0.p.d.t */
/* JADX INFO: compiled from: KPropertyImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12054t extends AbstractC12240o implements Function0<Boolean> {
    public final /* synthetic */ AbstractC12053s.a $this_computeCallerForAccessor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12054t(AbstractC12053s.a aVar) {
        super(0);
        this.$this_computeCallerForAccessor = aVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return this.$this_computeCallerForAccessor.getProperty().getDescriptor().getAnnotations().hasAnnotation(C11265j0.getJVM_STATIC());
    }
}
