package d0.e0.p.d.m0.c.g1;

import d0.e0.p.d.m0.n.j0;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: BuiltInAnnotationDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j$a extends o implements Function0<j0> {
    public final /* synthetic */ j this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j$a(j jVar) {
        super(0);
        this.this$0 = jVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ j0 invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final j0 invoke() {
        return j.access$getBuiltIns$p(this.this$0).getBuiltInClassByFqName(this.this$0.getFqName()).getDefaultType();
    }
}
