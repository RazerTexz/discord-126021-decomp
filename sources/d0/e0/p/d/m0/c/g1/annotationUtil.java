package d0.e0.p.d.m0.c.g1;

import d0.Tuples;
import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.b.StandardNames;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.v.w;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.Variance;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.f, reason: use source file name */
/* JADX INFO: compiled from: annotationUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class annotationUtil {
    public static final Name a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Name f3250b;
    public static final Name c;
    public static final Name d;
    public static final Name e;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.f$a */
    /* JADX INFO: compiled from: annotationUtil.kt */
    public static final class a extends Lambda implements Function1<ModuleDescriptor2, KotlinType> {
        public final /* synthetic */ KotlinBuiltIns $this_createDeprecatedAnnotation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(KotlinBuiltIns kotlinBuiltIns) {
            super(1);
            this.$this_createDeprecatedAnnotation = kotlinBuiltIns;
        }

        @Override // kotlin.jvm.functions.Function1
        public final KotlinType invoke(ModuleDescriptor2 moduleDescriptor2) {
            Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
            KotlinType4 arrayType = moduleDescriptor2.getBuiltIns().getArrayType(Variance.INVARIANT, this.$this_createDeprecatedAnnotation.getStringType());
            Intrinsics3.checkNotNullExpressionValue(arrayType, "module.builtIns.getArrayType(Variance.INVARIANT, stringType)");
            return arrayType;
        }
    }

    static {
        Name nameIdentifier = Name.identifier("message");
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(\"message\")");
        a = nameIdentifier;
        Name nameIdentifier2 = Name.identifier("replaceWith");
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier2, "identifier(\"replaceWith\")");
        f3250b = nameIdentifier2;
        Name nameIdentifier3 = Name.identifier("level");
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier3, "identifier(\"level\")");
        c = nameIdentifier3;
        Name nameIdentifier4 = Name.identifier("expression");
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier4, "identifier(\"expression\")");
        d = nameIdentifier4;
        Name nameIdentifier5 = Name.identifier("imports");
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier5, "identifier(\"imports\")");
        e = nameIdentifier5;
    }

    public static final AnnotationDescriptor createDeprecatedAnnotation(KotlinBuiltIns kotlinBuiltIns, String str, String str2, String str3) {
        Intrinsics3.checkNotNullParameter(kotlinBuiltIns, "<this>");
        Intrinsics3.checkNotNullParameter(str, "message");
        Intrinsics3.checkNotNullParameter(str2, "replaceWith");
        Intrinsics3.checkNotNullParameter(str3, "level");
        BuiltInAnnotationDescriptor builtInAnnotationDescriptor = new BuiltInAnnotationDescriptor(kotlinBuiltIns, StandardNames.a.w, Maps6.mapOf(Tuples.to(d, new w(str2)), Tuples.to(e, new d0.e0.p.d.m0.k.v.b(Collections2.emptyList(), new a(kotlinBuiltIns)))));
        FqName fqName = StandardNames.a.u;
        Name name = c;
        ClassId classId = ClassId.topLevel(StandardNames.a.v);
        Intrinsics3.checkNotNullExpressionValue(classId, "topLevel(StandardNames.FqNames.deprecationLevel)");
        Name nameIdentifier = Name.identifier(str3);
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(level)");
        return new BuiltInAnnotationDescriptor(kotlinBuiltIns, fqName, Maps6.mapOf(Tuples.to(a, new w(str)), Tuples.to(f3250b, new d0.e0.p.d.m0.k.v.a(builtInAnnotationDescriptor)), Tuples.to(name, new d0.e0.p.d.m0.k.v.j(classId, nameIdentifier))));
    }

    public static /* synthetic */ AnnotationDescriptor createDeprecatedAnnotation$default(KotlinBuiltIns kotlinBuiltIns, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            str3 = "WARNING";
        }
        return createDeprecatedAnnotation(kotlinBuiltIns, str, str2, str3);
    }
}
