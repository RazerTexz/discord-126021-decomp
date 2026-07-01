package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.c.b$a;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.y0;
import d0.e0.p.d.m0.n.c1;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: TypeAliasConstructorDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j0$b extends d0.z.d.o implements Function0<j0> {
    public final /* synthetic */ d0.e0.p.d.m0.c.d $underlyingConstructorDescriptor;
    public final /* synthetic */ j0 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0$b(j0 j0Var, d0.e0.p.d.m0.c.d dVar) {
        super(0);
        this.this$0 = j0Var;
        this.$underlyingConstructorDescriptor = dVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ j0 invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final j0 invoke() {
        d0.e0.p.d.m0.m.o storageManager = this.this$0.getStorageManager();
        y0 typeAliasDescriptor = this.this$0.getTypeAliasDescriptor();
        d0.e0.p.d.m0.c.d dVar = this.$underlyingConstructorDescriptor;
        j0 j0Var = this.this$0;
        d0.e0.p.d.m0.c.g1.g annotations = dVar.getAnnotations();
        b$a kind = this.$underlyingConstructorDescriptor.getKind();
        d0.z.d.m.checkNotNullExpressionValue(kind, "underlyingConstructorDescriptor.kind");
        u0 source = this.this$0.getTypeAliasDescriptor().getSource();
        d0.z.d.m.checkNotNullExpressionValue(source, "typeAliasDescriptor.source");
        j0 j0Var2 = new j0(storageManager, typeAliasDescriptor, dVar, j0Var, annotations, kind, source, null);
        j0 j0Var3 = this.this$0;
        d0.e0.p.d.m0.c.d dVar2 = this.$underlyingConstructorDescriptor;
        c1 c1VarAccess$getTypeSubstitutorForUnderlyingClass = j0$a.access$getTypeSubstitutorForUnderlyingClass(j0.M, j0Var3.getTypeAliasDescriptor());
        if (c1VarAccess$getTypeSubstitutorForUnderlyingClass == null) {
            return null;
        }
        q0 dispatchReceiverParameter = dVar2.getDispatchReceiverParameter();
        j0Var2.initialize(null, dispatchReceiverParameter == null ? null : dispatchReceiverParameter.substitute(c1VarAccess$getTypeSubstitutorForUnderlyingClass), j0Var3.getTypeAliasDescriptor().getDeclaredTypeParameters(), j0Var3.getValueParameters(), j0Var3.getReturnType(), d0.e0.p.d.m0.c.z.FINAL, j0Var3.getTypeAliasDescriptor().getVisibility());
        return j0Var2;
    }
}
