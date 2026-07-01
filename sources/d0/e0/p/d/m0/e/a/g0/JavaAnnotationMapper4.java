package d0.e0.p.d.m0.e.a.g0;

import d0.Tuples;
import d0.e0.p.d.m0.b.StandardNames;
import d0.e0.p.d.m0.e.a.i0.context4;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.v.w;
import d0.e0.p.d.m0.m.storage5;
import d0.e0.p.d.m0.m.storage7;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.PropertyReference1Impl;
import d0.z.d.Reflection2;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g0.e, reason: use source file name */
/* JADX INFO: compiled from: JavaAnnotationMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JavaAnnotationMapper4 extends JavaAnnotationMapper {
    public static final /* synthetic */ KProperty<Object>[] g = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(JavaAnnotationMapper4.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    public final storage5 h;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g0.e$a */
    /* JADX INFO: compiled from: JavaAnnotationMapper.kt */
    public static final class a extends Lambda implements Function0<Map<Name, ? extends w>> {
        public static final a j = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Name, ? extends w> invoke() {
            return MapsJVM.mapOf(Tuples.to(JavaAnnotationMapper2.a.getDEPRECATED_ANNOTATION_MESSAGE$descriptors_jvm(), new w("Deprecated in Java")));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaAnnotationMapper4(d0.e0.p.d.m0.e.a.k0.a aVar, context4 context4Var) {
        super(context4Var, aVar, StandardNames.a.u);
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        this.h = context4Var.getStorageManager().createLazyValue(a.j);
    }

    @Override // d0.e0.p.d.m0.e.a.g0.JavaAnnotationMapper, d0.e0.p.d.m0.c.g1.AnnotationDescriptor
    public Map<Name, d0.e0.p.d.m0.k.v.g<?>> getAllValueArguments() {
        return (Map) storage7.getValue(this.h, this, (KProperty<?>) g[0]);
    }
}
