package d0.e0.p.d.m0.j;

import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptorWithTypeParameters;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.TypeAliasDescriptor;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.e0.p.d.m0.c.g1.AnnotationUseSiteTarget;
import d0.e0.p.d.m0.g.FqNameUnsafe;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.j.ClassifierNamePolicy;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.TypeProjection;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.j.c, reason: use source file name */
/* JADX INFO: compiled from: DescriptorRenderer.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DescriptorRenderer2 {
    public static final k a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DescriptorRenderer2 f3439b;
    public static final DescriptorRenderer2 c;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.c$a */
    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public static final class a extends Lambda implements Function1<DescriptorRenderer4, Unit> {
        public static final a j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DescriptorRenderer4 descriptorRenderer4) {
            invoke2(descriptorRenderer4);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DescriptorRenderer4 descriptorRenderer4) {
            Intrinsics3.checkNotNullParameter(descriptorRenderer4, "<this>");
            descriptorRenderer4.setWithDefinedIn(false);
            descriptorRenderer4.setModifiers(Sets5.emptySet());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.c$b */
    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public static final class b extends Lambda implements Function1<DescriptorRenderer4, Unit> {
        public static final b j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DescriptorRenderer4 descriptorRenderer4) {
            invoke2(descriptorRenderer4);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DescriptorRenderer4 descriptorRenderer4) {
            Intrinsics3.checkNotNullParameter(descriptorRenderer4, "<this>");
            descriptorRenderer4.setWithDefinedIn(false);
            descriptorRenderer4.setModifiers(Sets5.emptySet());
            descriptorRenderer4.setWithoutSuperTypes(true);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.c$c */
    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public static final class c extends Lambda implements Function1<DescriptorRenderer4, Unit> {
        public static final c j = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DescriptorRenderer4 descriptorRenderer4) {
            invoke2(descriptorRenderer4);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DescriptorRenderer4 descriptorRenderer4) {
            Intrinsics3.checkNotNullParameter(descriptorRenderer4, "<this>");
            descriptorRenderer4.setWithDefinedIn(false);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.c$d */
    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public static final class d extends Lambda implements Function1<DescriptorRenderer4, Unit> {
        public static final d j = new d();

        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DescriptorRenderer4 descriptorRenderer4) {
            invoke2(descriptorRenderer4);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DescriptorRenderer4 descriptorRenderer4) {
            Intrinsics3.checkNotNullParameter(descriptorRenderer4, "<this>");
            descriptorRenderer4.setModifiers(Sets5.emptySet());
            descriptorRenderer4.setClassifierNamePolicy(ClassifierNamePolicy.b.a);
            descriptorRenderer4.setParameterNameRenderingPolicy(DescriptorRenderer7.ONLY_NON_SYNTHESIZED);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.c$e */
    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public static final class e extends Lambda implements Function1<DescriptorRenderer4, Unit> {
        public static final e j = new e();

        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DescriptorRenderer4 descriptorRenderer4) {
            invoke2(descriptorRenderer4);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DescriptorRenderer4 descriptorRenderer4) {
            Intrinsics3.checkNotNullParameter(descriptorRenderer4, "<this>");
            descriptorRenderer4.setDebugMode(true);
            descriptorRenderer4.setClassifierNamePolicy(ClassifierNamePolicy.a.a);
            descriptorRenderer4.setModifiers(DescriptorRenderer3.k);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.c$f */
    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public static final class f extends Lambda implements Function1<DescriptorRenderer4, Unit> {
        public static final f j = new f();

        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DescriptorRenderer4 descriptorRenderer4) {
            invoke2(descriptorRenderer4);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DescriptorRenderer4 descriptorRenderer4) {
            Intrinsics3.checkNotNullParameter(descriptorRenderer4, "<this>");
            descriptorRenderer4.setModifiers(DescriptorRenderer3.j);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.c$g */
    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public static final class g extends Lambda implements Function1<DescriptorRenderer4, Unit> {
        public static final g j = new g();

        public g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DescriptorRenderer4 descriptorRenderer4) {
            invoke2(descriptorRenderer4);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DescriptorRenderer4 descriptorRenderer4) {
            Intrinsics3.checkNotNullParameter(descriptorRenderer4, "<this>");
            descriptorRenderer4.setModifiers(DescriptorRenderer3.k);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.c$h */
    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public static final class h extends Lambda implements Function1<DescriptorRenderer4, Unit> {
        public static final h j = new h();

        public h() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DescriptorRenderer4 descriptorRenderer4) {
            invoke2(descriptorRenderer4);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DescriptorRenderer4 descriptorRenderer4) {
            Intrinsics3.checkNotNullParameter(descriptorRenderer4, "<this>");
            descriptorRenderer4.setTextFormat(DescriptorRenderer9.HTML);
            descriptorRenderer4.setModifiers(DescriptorRenderer3.k);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.c$i */
    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public static final class i extends Lambda implements Function1<DescriptorRenderer4, Unit> {
        public static final i j = new i();

        public i() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DescriptorRenderer4 descriptorRenderer4) {
            invoke2(descriptorRenderer4);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DescriptorRenderer4 descriptorRenderer4) {
            Intrinsics3.checkNotNullParameter(descriptorRenderer4, "<this>");
            descriptorRenderer4.setWithDefinedIn(false);
            descriptorRenderer4.setModifiers(Sets5.emptySet());
            descriptorRenderer4.setClassifierNamePolicy(ClassifierNamePolicy.b.a);
            descriptorRenderer4.setWithoutTypeParameters(true);
            descriptorRenderer4.setParameterNameRenderingPolicy(DescriptorRenderer7.NONE);
            descriptorRenderer4.setReceiverAfterName(true);
            descriptorRenderer4.setRenderCompanionObjectName(true);
            descriptorRenderer4.setWithoutSuperTypes(true);
            descriptorRenderer4.setStartFromName(true);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.c$j */
    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public static final class j extends Lambda implements Function1<DescriptorRenderer4, Unit> {
        public static final j j = new j();

        public j() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DescriptorRenderer4 descriptorRenderer4) {
            invoke2(descriptorRenderer4);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DescriptorRenderer4 descriptorRenderer4) {
            Intrinsics3.checkNotNullParameter(descriptorRenderer4, "<this>");
            descriptorRenderer4.setClassifierNamePolicy(ClassifierNamePolicy.b.a);
            descriptorRenderer4.setParameterNameRenderingPolicy(DescriptorRenderer7.ONLY_NON_SYNTHESIZED);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.c$k */
    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public static final class k {
        public k(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final String getClassifierKindPrefix(ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters) {
            Intrinsics3.checkNotNullParameter(classifierDescriptorWithTypeParameters, "classifier");
            if (classifierDescriptorWithTypeParameters instanceof TypeAliasDescriptor) {
                return "typealias";
            }
            if (!(classifierDescriptorWithTypeParameters instanceof ClassDescriptor)) {
                throw new AssertionError(Intrinsics3.stringPlus("Unexpected classifier: ", classifierDescriptorWithTypeParameters));
            }
            ClassDescriptor classDescriptor = (ClassDescriptor) classifierDescriptorWithTypeParameters;
            if (classDescriptor.isCompanionObject()) {
                return "companion object";
            }
            int iOrdinal = classDescriptor.getKind().ordinal();
            if (iOrdinal == 0) {
                return "class";
            }
            if (iOrdinal == 1) {
                return "interface";
            }
            if (iOrdinal == 2) {
                return "enum class";
            }
            if (iOrdinal == 3) {
                return "enum entry";
            }
            if (iOrdinal == 4) {
                return "annotation class";
            }
            if (iOrdinal == 5) {
                return "object";
            }
            throw new NoWhenBranchMatchedException();
        }

        public final DescriptorRenderer2 withOptions(Function1<? super DescriptorRenderer4, Unit> function1) {
            Intrinsics3.checkNotNullParameter(function1, "changeOptions");
            DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = new DescriptorRendererOptionsImpl();
            function1.invoke(descriptorRendererOptionsImpl);
            descriptorRendererOptionsImpl.lock();
            return new DescriptorRendererImpl(descriptorRendererOptionsImpl);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.c$l */
    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public interface l {

        /* JADX INFO: renamed from: d0.e0.p.d.m0.j.c$l$a */
        /* JADX INFO: compiled from: DescriptorRenderer.kt */
        public static final class a implements l {
            public static final a a = new a();

            @Override // d0.e0.p.d.m0.j.DescriptorRenderer2.l
            public void appendAfterValueParameter(ValueParameterDescriptor valueParameterDescriptor, int i, int i2, StringBuilder sb) {
                Intrinsics3.checkNotNullParameter(valueParameterDescriptor, "parameter");
                Intrinsics3.checkNotNullParameter(sb, "builder");
                if (i != i2 - 1) {
                    sb.append(", ");
                }
            }

            @Override // d0.e0.p.d.m0.j.DescriptorRenderer2.l
            public void appendAfterValueParameters(int i, StringBuilder sb) {
                Intrinsics3.checkNotNullParameter(sb, "builder");
                sb.append(")");
            }

            @Override // d0.e0.p.d.m0.j.DescriptorRenderer2.l
            public void appendBeforeValueParameter(ValueParameterDescriptor valueParameterDescriptor, int i, int i2, StringBuilder sb) {
                Intrinsics3.checkNotNullParameter(valueParameterDescriptor, "parameter");
                Intrinsics3.checkNotNullParameter(sb, "builder");
            }

            @Override // d0.e0.p.d.m0.j.DescriptorRenderer2.l
            public void appendBeforeValueParameters(int i, StringBuilder sb) {
                Intrinsics3.checkNotNullParameter(sb, "builder");
                sb.append("(");
            }
        }

        void appendAfterValueParameter(ValueParameterDescriptor valueParameterDescriptor, int i, int i2, StringBuilder sb);

        void appendAfterValueParameters(int i, StringBuilder sb);

        void appendBeforeValueParameter(ValueParameterDescriptor valueParameterDescriptor, int i, int i2, StringBuilder sb);

        void appendBeforeValueParameters(int i, StringBuilder sb);
    }

    static {
        k kVar = new k(null);
        a = kVar;
        kVar.withOptions(c.j);
        kVar.withOptions(a.j);
        kVar.withOptions(b.j);
        kVar.withOptions(d.j);
        kVar.withOptions(i.j);
        f3439b = kVar.withOptions(f.j);
        kVar.withOptions(g.j);
        kVar.withOptions(j.j);
        c = kVar.withOptions(e.j);
        kVar.withOptions(h.j);
    }

    public static /* synthetic */ String renderAnnotation$default(DescriptorRenderer2 descriptorRenderer2, AnnotationDescriptor annotationDescriptor, AnnotationUseSiteTarget annotationUseSiteTarget, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderAnnotation");
        }
        if ((i2 & 2) != 0) {
            annotationUseSiteTarget = null;
        }
        return descriptorRenderer2.renderAnnotation(annotationDescriptor, annotationUseSiteTarget);
    }

    public abstract String render(DeclarationDescriptor declarationDescriptor);

    public abstract String renderAnnotation(AnnotationDescriptor annotationDescriptor, AnnotationUseSiteTarget annotationUseSiteTarget);

    public abstract String renderFlexibleType(String str, String str2, KotlinBuiltIns kotlinBuiltIns);

    public abstract String renderFqName(FqNameUnsafe fqNameUnsafe);

    public abstract String renderName(Name name, boolean z2);

    public abstract String renderType(KotlinType kotlinType);

    public abstract String renderTypeProjection(TypeProjection typeProjection);

    public final DescriptorRenderer2 withOptions(Function1<? super DescriptorRenderer4, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "changeOptions");
        DescriptorRendererOptionsImpl descriptorRendererOptionsImplCopy = ((DescriptorRendererImpl) this).getOptions().copy();
        function1.invoke(descriptorRendererOptionsImplCopy);
        descriptorRendererOptionsImplCopy.lock();
        return new DescriptorRendererImpl(descriptorRendererOptionsImplCopy);
    }
}
