package d0.e0.p.d.m0.e.a.g0;

import d0.e0.p.d.m0.e.a.k0.m;
import d0.t.g0;
import d0.t.h0;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: JavaAnnotationMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i$a extends o implements Function0<Map<d0.e0.p.d.m0.g.e, ? extends d0.e0.p.d.m0.k.v.g<? extends Object>>> {
    public final /* synthetic */ i this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i$a(i iVar) {
        super(0);
        this.this$0 = iVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<d0.e0.p.d.m0.g.e, ? extends d0.e0.p.d.m0.k.v.g<? extends Object>> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<d0.e0.p.d.m0.g.e, ? extends d0.e0.p.d.m0.k.v.g<? extends Object>> invoke2() {
        d0.e0.p.d.m0.k.v.g<?> gVarMapJavaTargetArguments$descriptors_jvm;
        d0.e0.p.d.m0.e.a.k0.b bVar = this.this$0.e;
        if (bVar instanceof d0.e0.p.d.m0.e.a.k0.e) {
            gVarMapJavaTargetArguments$descriptors_jvm = d.a.mapJavaTargetArguments$descriptors_jvm(((d0.e0.p.d.m0.e.a.k0.e) bVar).getElements());
        } else {
            gVarMapJavaTargetArguments$descriptors_jvm = bVar instanceof m ? d.a.mapJavaTargetArguments$descriptors_jvm(d0.t.m.listOf(bVar)) : null;
        }
        Map<d0.e0.p.d.m0.g.e, ? extends d0.e0.p.d.m0.k.v.g<? extends Object>> mapMapOf = gVarMapJavaTargetArguments$descriptors_jvm != null ? g0.mapOf(d0.o.to(c.a.getTARGET_ANNOTATION_ALLOWED_TARGETS$descriptors_jvm(), gVarMapJavaTargetArguments$descriptors_jvm)) : null;
        return mapMapOf != null ? mapMapOf : h0.emptyMap();
    }
}
