package d0.e0.p.d.m0.e.a.i0;

import d0.e0.p.d.m0.e.a.i0.l.s;
import d0.e0.p.d.m0.e.a.k0.y;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: resolvers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$a extends o implements Function1<y, s> {
    public final /* synthetic */ h this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$a(h hVar) {
        super(1);
        this.this$0 = hVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ s invoke(y yVar) {
        return invoke2(yVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final s invoke2(y yVar) {
        m.checkNotNullParameter(yVar, "typeParameter");
        Integer num = (Integer) h.access$getTypeParameters$p(this.this$0).get(yVar);
        if (num == null) {
            return null;
        }
        h hVar = this.this$0;
        return new s(a.copyWithNewDefaultTypeQualifiers(a.child(h.access$getC$p(hVar), hVar), h.access$getContainingDeclaration$p(hVar).getAnnotations()), yVar, h.access$getTypeParametersIndexOffset$p(hVar) + num.intValue(), h.access$getContainingDeclaration$p(hVar));
    }
}
