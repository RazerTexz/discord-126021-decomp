package d0.e0.p.d.m0.e.a.g0;

import d0.e0.p.d.m0.n.j0;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: JavaAnnotationMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b$a extends o implements Function0<j0> {
    public final /* synthetic */ d0.e0.p.d.m0.e.a.i0.g $c;
    public final /* synthetic */ b this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b$a(d0.e0.p.d.m0.e.a.i0.g gVar, b bVar) {
        super(0);
        this.$c = gVar;
        this.this$0 = bVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ j0 invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final j0 invoke() {
        j0 defaultType = this.$c.getModule().getBuiltIns().getBuiltInClassByFqName(this.this$0.getFqName()).getDefaultType();
        m.checkNotNullExpressionValue(defaultType, "c.module.builtIns.getBuiltInClassByFqName(fqName).defaultType");
        return defaultType;
    }
}
