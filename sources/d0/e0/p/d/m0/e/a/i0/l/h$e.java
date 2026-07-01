package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.e.a.g0.g$a;
import d0.e0.p.d.m0.e.b.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$e extends d0.z.d.o implements Function0<List<? extends d0.e0.p.d.m0.c.d>> {
    public final /* synthetic */ d0.e0.p.d.m0.e.a.i0.g $c;
    public final /* synthetic */ h this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$e(h hVar, d0.e0.p.d.m0.e.a.i0.g gVar) {
        super(0);
        this.this$0 = hVar;
        this.$c = gVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends d0.e0.p.d.m0.c.d> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends d0.e0.p.d.m0.c.d> invoke2() {
        Collection<d0.e0.p.d.m0.e.a.k0.k> constructors = h.access$getJClass$p(this.this$0).getConstructors();
        ArrayList arrayList = new ArrayList(constructors.size());
        Iterator<d0.e0.p.d.m0.e.a.k0.k> it = constructors.iterator();
        while (it.hasNext()) {
            arrayList.add(h.access$resolveConstructor(this.this$0, it.next()));
        }
        if (h.access$getJClass$p(this.this$0).isRecord()) {
            d0.e0.p.d.m0.c.d dVarAccess$createDefaultRecordConstructor = h.access$createDefaultRecordConstructor(this.this$0);
            boolean z2 = false;
            String strComputeJvmDescriptor$default = u.computeJvmDescriptor$default(dVarAccess$createDefaultRecordConstructor, false, false, 2, null);
            if (!arrayList.isEmpty()) {
                Iterator it2 = arrayList.iterator();
                do {
                    if (!it2.hasNext()) {
                        z2 = true;
                        break;
                    }
                } while (!d0.z.d.m.areEqual(u.computeJvmDescriptor$default((d0.e0.p.d.m0.c.d) it2.next(), false, false, 2, null), strComputeJvmDescriptor$default));
            } else {
                z2 = true;
                break;
            }
            if (z2) {
                arrayList.add(dVarAccess$createDefaultRecordConstructor);
                ((g$a) this.$c.getComponents().getJavaResolverCache()).recordConstructor(h.access$getJClass$p(this.this$0), dVarAccess$createDefaultRecordConstructor);
            }
        }
        d0.e0.p.d.m0.e.a.l0.l signatureEnhancement = this.$c.getComponents().getSignatureEnhancement();
        d0.e0.p.d.m0.e.a.i0.g gVar = this.$c;
        h hVar = this.this$0;
        boolean zIsEmpty = arrayList.isEmpty();
        List listListOfNotNull = arrayList;
        if (zIsEmpty) {
            listListOfNotNull = d0.t.n.listOfNotNull(h.access$createDefaultConstructor(hVar));
        }
        return d0.t.u.toList(signatureEnhancement.enhanceSignatures(gVar, listListOfNotNull));
    }
}
