package d0.e0.p.d.m0.e.a.g0;

import d0.t.g0;
import d0.t.h0;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: JavaAnnotationMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$a extends o implements Function0<Map<d0.e0.p.d.m0.g.e, ? extends d0.e0.p.d.m0.k.v.g<?>>> {
    public final /* synthetic */ h this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$a(h hVar) {
        super(0);
        this.this$0 = hVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<d0.e0.p.d.m0.g.e, ? extends d0.e0.p.d.m0.k.v.g<?>> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<d0.e0.p.d.m0.g.e, ? extends d0.e0.p.d.m0.k.v.g<?>> invoke2() {
        d0.e0.p.d.m0.k.v.g<?> gVarMapJavaRetentionArgument$descriptors_jvm = d.a.mapJavaRetentionArgument$descriptors_jvm(this.this$0.e);
        Map<d0.e0.p.d.m0.g.e, ? extends d0.e0.p.d.m0.k.v.g<?>> mapMapOf = gVarMapJavaRetentionArgument$descriptors_jvm == null ? null : g0.mapOf(d0.o.to(c.a.getRETENTION_ANNOTATION_VALUE$descriptors_jvm(), gVarMapJavaRetentionArgument$descriptors_jvm));
        return mapMapOf != null ? mapMapOf : h0.emptyMap();
    }
}
