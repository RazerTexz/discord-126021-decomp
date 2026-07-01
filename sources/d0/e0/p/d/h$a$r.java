package d0.e0.p.d;

import d0.e0.p.d.m0.c.z0;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: KClassImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$a$r extends d0.z.d.o implements Function0<List<? extends y>> {
    public final /* synthetic */ h$a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$a$r(h$a h_a) {
        super(0);
        this.this$0 = h_a;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends y> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends y> invoke2() {
        List<z0> declaredTypeParameters = this.this$0.getDescriptor().getDeclaredTypeParameters();
        d0.z.d.m.checkNotNullExpressionValue(declaredTypeParameters, "descriptor.declaredTypeParameters");
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(declaredTypeParameters, 10));
        for (z0 z0Var : declaredTypeParameters) {
            h hVar = this.this$0.p;
            d0.z.d.m.checkNotNullExpressionValue(z0Var, "descriptor");
            arrayList.add(new y(hVar, z0Var));
        }
        return arrayList;
    }
}
