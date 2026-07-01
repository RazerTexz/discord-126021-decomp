package d0.e0.p.d.m0.k.v;

import b.d.b.a.outline;
import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.b.StandardNames;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.findClassInModule;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.n.ErrorUtils;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType2;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.KotlinTypeFactory;
import d0.e0.p.d.m0.n.TypeProjection;
import d0.e0.p.d.m0.n.TypeProjectionImpl;
import d0.e0.p.d.m0.n.Variance;
import d0.e0.p.d.m0.n.o1.TypeUtils2;
import d0.t.CollectionsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r extends g<b> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3476b = new a(null);

    /* JADX INFO: compiled from: constantValues.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final g<?> create(KotlinType kotlinType) {
            Intrinsics3.checkNotNullParameter(kotlinType, "argumentType");
            if (KotlinType2.isError(kotlinType)) {
                return null;
            }
            KotlinType type = kotlinType;
            int i = 0;
            while (KotlinBuiltIns.isArray(type)) {
                type = ((TypeProjection) _Collections.single((List) type.getArguments())).getType();
                Intrinsics3.checkNotNullExpressionValue(type, "type.arguments.single().type");
                i++;
            }
            ClassifierDescriptor declarationDescriptor = type.getConstructor().getDeclarationDescriptor();
            if (declarationDescriptor instanceof ClassDescriptor) {
                ClassId classId = DescriptorUtils2.getClassId(declarationDescriptor);
                return classId == null ? new r(new b.a(kotlinType)) : new r(classId, i);
            }
            if (!(declarationDescriptor instanceof TypeParameterDescriptor)) {
                return null;
            }
            ClassId classId2 = ClassId.topLevel(StandardNames.a.f3217b.toSafe());
            Intrinsics3.checkNotNullExpressionValue(classId2, "topLevel(StandardNames.FqNames.any.toSafe())");
            return new r(classId2, 0);
        }
    }

    /* JADX INFO: compiled from: constantValues.kt */
    public static abstract class b {

        /* JADX INFO: compiled from: constantValues.kt */
        public static final class a extends b {
            public final KotlinType a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(KotlinType kotlinType) {
                super(null);
                Intrinsics3.checkNotNullParameter(kotlinType, "type");
                this.a = kotlinType;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && Intrinsics3.areEqual(this.a, ((a) obj).a);
            }

            public final KotlinType getType() {
                return this.a;
            }

            public int hashCode() {
                return this.a.hashCode();
            }

            public String toString() {
                StringBuilder sbU = outline.U("LocalClass(type=");
                sbU.append(this.a);
                sbU.append(')');
                return sbU.toString();
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.r$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: constantValues.kt */
        public static final class C0405b extends b {
            public final ClassLiteralValue a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0405b(ClassLiteralValue classLiteralValue) {
                super(null);
                Intrinsics3.checkNotNullParameter(classLiteralValue, "value");
                this.a = classLiteralValue;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0405b) && Intrinsics3.areEqual(this.a, ((C0405b) obj).a);
            }

            public final int getArrayDimensions() {
                return this.a.getArrayNestedness();
            }

            public final ClassId getClassId() {
                return this.a.getClassId();
            }

            public final ClassLiteralValue getValue() {
                return this.a;
            }

            public int hashCode() {
                return this.a.hashCode();
            }

            public String toString() {
                StringBuilder sbU = outline.U("NormalClass(value=");
                sbU.append(this.a);
                sbU.append(')');
                return sbU.toString();
            }
        }

        public b() {
        }

        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(b bVar) {
        super(bVar);
        Intrinsics3.checkNotNullParameter(bVar, "value");
    }

    public final KotlinType getArgumentType(ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        b value = getValue();
        if (value instanceof b.a) {
            return ((b.a) getValue()).getType();
        }
        if (!(value instanceof b.C0405b)) {
            throw new NoWhenBranchMatchedException();
        }
        ClassLiteralValue value2 = ((b.C0405b) getValue()).getValue();
        ClassId classIdComponent1 = value2.component1();
        int iComponent2 = value2.component2();
        ClassDescriptor classDescriptorFindClassAcrossModuleDependencies = findClassInModule.findClassAcrossModuleDependencies(moduleDescriptor2, classIdComponent1);
        if (classDescriptorFindClassAcrossModuleDependencies == null) {
            KotlinType4 kotlinType4CreateErrorType = ErrorUtils.createErrorType("Unresolved type: " + classIdComponent1 + " (arrayDimensions=" + iComponent2 + ')');
            Intrinsics3.checkNotNullExpressionValue(kotlinType4CreateErrorType, "createErrorType(\"Unresolved type: $classId (arrayDimensions=$arrayDimensions)\")");
            return kotlinType4CreateErrorType;
        }
        KotlinType4 defaultType = classDescriptorFindClassAcrossModuleDependencies.getDefaultType();
        Intrinsics3.checkNotNullExpressionValue(defaultType, "descriptor.defaultType");
        KotlinType kotlinTypeReplaceArgumentsWithStarProjections = TypeUtils2.replaceArgumentsWithStarProjections(defaultType);
        for (int i = 0; i < iComponent2; i++) {
            kotlinTypeReplaceArgumentsWithStarProjections = moduleDescriptor2.getBuiltIns().getArrayType(Variance.INVARIANT, kotlinTypeReplaceArgumentsWithStarProjections);
            Intrinsics3.checkNotNullExpressionValue(kotlinTypeReplaceArgumentsWithStarProjections, "module.builtIns.getArrayType(Variance.INVARIANT, type)");
        }
        return kotlinTypeReplaceArgumentsWithStarProjections;
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public KotlinType getType(ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
        Annotations4 empty = Annotations4.f.getEMPTY();
        ClassDescriptor kClass = moduleDescriptor2.getBuiltIns().getKClass();
        Intrinsics3.checkNotNullExpressionValue(kClass, "module.builtIns.kClass");
        return KotlinTypeFactory.simpleNotNullType(empty, kClass, CollectionsJVM.listOf(new TypeProjectionImpl(getArgumentType(moduleDescriptor2))));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public r(ClassLiteralValue classLiteralValue) {
        this(new b.C0405b(classLiteralValue));
        Intrinsics3.checkNotNullParameter(classLiteralValue, "value");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public r(ClassId classId, int i) {
        this(new ClassLiteralValue(classId, i));
        Intrinsics3.checkNotNullParameter(classId, "classId");
    }
}
