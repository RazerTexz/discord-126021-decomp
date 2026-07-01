package d0.e0.p.d.m0.e.a.g0;

import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.e0.p.d.m0.e.a.h0.PossiblyExternalAnnotationDescriptor;
import d0.e0.p.d.m0.e.a.i0.context4;
import d0.e0.p.d.m0.e.a.k0.annotationArguments;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.m.storage5;
import d0.e0.p.d.m0.m.storage7;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.t.Maps6;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.PropertyReference1Impl;
import d0.z.d.Reflection2;
import java.util.Collection;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g0.b, reason: use source file name */
/* JADX INFO: compiled from: JavaAnnotationMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public class JavaAnnotationMapper implements AnnotationDescriptor, PossiblyExternalAnnotationDescriptor {
    public static final /* synthetic */ KProperty<Object>[] a = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(JavaAnnotationMapper.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;"))};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FqName f3314b;
    public final SourceElement c;
    public final storage5 d;
    public final annotationArguments e;
    public final boolean f;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g0.b$a */
    /* JADX INFO: compiled from: JavaAnnotationMapper.kt */
    public static final class a extends Lambda implements Function0<KotlinType4> {
        public final /* synthetic */ context4 $c;
        public final /* synthetic */ JavaAnnotationMapper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(context4 context4Var, JavaAnnotationMapper javaAnnotationMapper) {
            super(0);
            this.$c = context4Var;
            this.this$0 = javaAnnotationMapper;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final KotlinType4 invoke() {
            KotlinType4 defaultType = this.$c.getModule().getBuiltIns().getBuiltInClassByFqName(this.this$0.getFqName()).getDefaultType();
            Intrinsics3.checkNotNullExpressionValue(defaultType, "c.module.builtIns.getBuiltInClassByFqName(fqName).defaultType");
            return defaultType;
        }
    }

    public JavaAnnotationMapper(context4 context4Var, d0.e0.p.d.m0.e.a.k0.a aVar, FqName fqName) {
        Collection<annotationArguments> arguments;
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        this.f3314b = fqName;
        SourceElement sourceElementSource = aVar == null ? null : context4Var.getComponents().getSourceElementFactory().source(aVar);
        if (sourceElementSource == null) {
            sourceElementSource = SourceElement.a;
            Intrinsics3.checkNotNullExpressionValue(sourceElementSource, "NO_SOURCE");
        }
        this.c = sourceElementSource;
        this.d = context4Var.getStorageManager().createLazyValue(new a(context4Var, this));
        this.e = (aVar == null || (arguments = aVar.getArguments()) == null) ? null : (annotationArguments) _Collections.firstOrNull(arguments);
        this.f = Intrinsics3.areEqual(aVar != null ? Boolean.valueOf(aVar.isIdeExternalAnnotation()) : null, Boolean.TRUE);
    }

    @Override // d0.e0.p.d.m0.c.g1.AnnotationDescriptor
    public Map<Name, d0.e0.p.d.m0.k.v.g<?>> getAllValueArguments() {
        return Maps6.emptyMap();
    }

    @Override // d0.e0.p.d.m0.c.g1.AnnotationDescriptor
    public FqName getFqName() {
        return this.f3314b;
    }

    @Override // d0.e0.p.d.m0.c.g1.AnnotationDescriptor
    public SourceElement getSource() {
        return this.c;
    }

    @Override // d0.e0.p.d.m0.e.a.h0.PossiblyExternalAnnotationDescriptor
    public boolean isIdeExternalAnnotation() {
        return this.f;
    }

    @Override // d0.e0.p.d.m0.c.g1.AnnotationDescriptor
    public KotlinType4 getType() {
        return (KotlinType4) storage7.getValue(this.d, this, (KProperty<?>) a[0]);
    }
}
