package d0.e0.p.d;

import d0.e0.p.d.m0.n.w0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: KTypeImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class x$a extends d0.z.d.o implements Function0<List<? extends d0.e0.i>> {
    public final /* synthetic */ Function0 $computeJavaType;
    public final /* synthetic */ x this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x$a(x xVar, Function0 function0) {
        super(0);
        this.this$0 = xVar;
        this.$computeJavaType = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends d0.e0.i> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends d0.e0.i> invoke2() {
        d0.e0.i iVarInvariant;
        List<w0> arguments = this.this$0.getType().getArguments();
        if (arguments.isEmpty()) {
            return d0.t.n.emptyList();
        }
        Lazy lazy = d0.g.lazy(d0.i.PUBLICATION, new x$a$b(this));
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(arguments, 10));
        int i = 0;
        for (Object obj : arguments) {
            int i2 = i + 1;
            if (i < 0) {
                d0.t.n.throwIndexOverflow();
            }
            w0 w0Var = (w0) obj;
            if (w0Var.isStarProjection()) {
                iVarInvariant = d0.e0.i.f3190b.getSTAR();
            } else {
                d0.e0.p.d.m0.n.c0 type = w0Var.getType();
                d0.z.d.m.checkNotNullExpressionValue(type, "typeProjection.type");
                x xVar = new x(type, this.$computeJavaType != null ? new x$a$a(i, this, lazy, null) : null);
                int iOrdinal = w0Var.getProjectionKind().ordinal();
                if (iOrdinal == 0) {
                    iVarInvariant = d0.e0.i.f3190b.invariant(xVar);
                } else if (iOrdinal == 1) {
                    iVarInvariant = d0.e0.i.f3190b.contravariant(xVar);
                } else {
                    if (iOrdinal != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    iVarInvariant = d0.e0.i.f3190b.covariant(xVar);
                }
            }
            arrayList.add(iVarInvariant);
            i = i2;
        }
        return arrayList;
    }
}
