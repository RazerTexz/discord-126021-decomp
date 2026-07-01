package d0.e0.p.d;

import d0.e0.p.d.m0.c.z0;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: KCallableImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f$d extends d0.z.d.o implements Function0<List<? extends y>> {
    public final /* synthetic */ f this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f$d(f fVar) {
        super(0);
        this.this$0 = fVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends y> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends y> invoke2() {
        List<z0> typeParameters = this.this$0.getDescriptor().getTypeParameters();
        d0.z.d.m.checkNotNullExpressionValue(typeParameters, "descriptor.typeParameters");
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(typeParameters, 10));
        for (z0 z0Var : typeParameters) {
            f fVar = this.this$0;
            d0.z.d.m.checkNotNullExpressionValue(z0Var, "descriptor");
            arrayList.add(new y(fVar, z0Var));
        }
        return arrayList;
    }
}
