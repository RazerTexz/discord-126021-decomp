package d0.e0.p.d.m0.e.a.i0.m;

import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.t;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: JavaTypeResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$a extends o implements Function0<j0> {
    public final /* synthetic */ z0 $this_getErasedUpperBound;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$a(z0 z0Var) {
        super(0);
        this.$this_getErasedUpperBound = z0Var;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ j0 invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final j0 invoke() {
        StringBuilder sbU = b.d.b.a.a.U("Can't compute erased upper bound of type parameter `");
        sbU.append(this.$this_getErasedUpperBound);
        sbU.append('`');
        j0 j0VarCreateErrorType = t.createErrorType(sbU.toString());
        m.checkNotNullExpressionValue(j0VarCreateErrorType, "createErrorType(\"Can't compute erased upper bound of type parameter `$this`\")");
        return j0VarCreateErrorType;
    }
}
