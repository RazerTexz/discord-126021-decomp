package d0.e0.p.d.m0.c;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: typeParameterUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a1$c extends d0.z.d.o implements Function1<m, Sequence<? extends z0>> {
    public static final a1$c j = new a1$c();

    public a1$c() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Sequence<? extends z0> invoke(m mVar) {
        return invoke2(mVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Sequence<z0> invoke2(m mVar) {
        d0.z.d.m.checkNotNullParameter(mVar, "it");
        List<z0> typeParameters = ((a) mVar).getTypeParameters();
        d0.z.d.m.checkNotNullExpressionValue(typeParameters, "it as CallableDescriptor).typeParameters");
        return d0.t.u.asSequence(typeParameters);
    }
}
