package d0.e0.p.d.m0.b;

import b.d.b.a.outline;
import d0.e0.p.d.m0.b.StandardNames;
import d0.e0.p.d.m0.b.p.BuiltInFictitiousFunctionClassFactory;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.PackageFragmentDescriptor;
import d0.e0.p.d.m0.c.PackageViewDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.PropertyGetterDescriptor;
import d0.e0.p.d.m0.c.PropertySetterDescriptor;
import d0.e0.p.d.m0.c.descriptorUtil;
import d0.e0.p.d.m0.c.findClassInModule;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.c.h1.AdditionalClassPartsProvider;
import d0.e0.p.d.m0.c.h1.ClassDescriptorFactory;
import d0.e0.p.d.m0.c.h1.PlatformDependentDeclarationFilter;
import d0.e0.p.d.m0.c.i1.ModuleDescriptorImpl3;
import d0.e0.p.d.m0.d.b.LookupLocation3;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.FqNameUnsafe;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.DescriptorUtils;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.m.LockBasedStorageManager;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.m.storage3;
import d0.e0.p.d.m0.m.storage5;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.KotlinTypeFactory;
import d0.e0.p.d.m0.n.TypeConstructor;
import d0.e0.p.d.m0.n.TypeProjectionImpl;
import d0.e0.p.d.m0.n.TypeUtils;
import d0.e0.p.d.m0.n.Variance;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.h, reason: use source file name */
/* JADX INFO: compiled from: KotlinBuiltIns.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class KotlinBuiltIns {
    public static final Name a = Name.special("<built-ins module>");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ModuleDescriptorImpl3 f3211b;
    public final storage5<e> c;
    public final storage3<Name, ClassDescriptor> d;
    public final StorageManager e;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.h$a */
    /* JADX INFO: compiled from: KotlinBuiltIns.java */
    public class a implements Function0<Collection<PackageViewDescriptor>> {
        public a() {
        }

        @Override // kotlin.jvm.functions.Function0
        public Collection<PackageViewDescriptor> invoke() {
            return Arrays.asList(KotlinBuiltIns.this.f3211b.getPackage(StandardNames.l), KotlinBuiltIns.this.f3211b.getPackage(StandardNames.n), KotlinBuiltIns.this.f3211b.getPackage(StandardNames.o), KotlinBuiltIns.this.f3211b.getPackage(StandardNames.m));
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.h$b */
    /* JADX INFO: compiled from: KotlinBuiltIns.java */
    public class b implements Function0<e> {
        public b() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public e invoke() {
            EnumMap enumMap = new EnumMap(PrimitiveType.class);
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            PrimitiveType[] primitiveTypeArrValues = PrimitiveType.valuesCustom();
            for (int i = 0; i < 8; i++) {
                PrimitiveType primitiveType = primitiveTypeArrValues[i];
                KotlinType4 kotlinType4B = KotlinBuiltIns.b(KotlinBuiltIns.this, primitiveType.getTypeName().asString());
                KotlinType4 kotlinType4B2 = KotlinBuiltIns.b(KotlinBuiltIns.this, primitiveType.getArrayTypeName().asString());
                enumMap.put(primitiveType, kotlinType4B2);
                map.put(kotlinType4B, kotlinType4B2);
                map2.put(kotlinType4B2, kotlinType4B);
            }
            return new e(enumMap, map, map2, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.h$c */
    /* JADX INFO: compiled from: KotlinBuiltIns.java */
    public class c implements Function1<Name, ClassDescriptor> {
        public c() {
        }

        @Override // kotlin.jvm.functions.Function1
        public ClassDescriptor invoke(Name name) {
            ClassifierDescriptor contributedClassifier = KotlinBuiltIns.this.getBuiltInsPackageScope().getContributedClassifier(name, LookupLocation3.FROM_BUILTINS);
            if (contributedClassifier == null) {
                StringBuilder sbU = outline.U("Built-in class ");
                sbU.append(StandardNames.l.child(name));
                sbU.append(" is not found");
                throw new AssertionError(sbU.toString());
            }
            if (contributedClassifier instanceof ClassDescriptor) {
                return (ClassDescriptor) contributedClassifier;
            }
            throw new AssertionError("Must be a class descriptor " + name + ", but was " + contributedClassifier);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.h$d */
    /* JADX INFO: compiled from: KotlinBuiltIns.java */
    public class d implements Function0<Void> {
        public final /* synthetic */ ModuleDescriptorImpl3 j;

        public d(ModuleDescriptorImpl3 moduleDescriptorImpl3) {
            this.j = moduleDescriptorImpl3;
        }

        @Override // kotlin.jvm.functions.Function0
        public Void invoke() {
            KotlinBuiltIns kotlinBuiltIns = KotlinBuiltIns.this;
            if (kotlinBuiltIns.f3211b == null) {
                kotlinBuiltIns.f3211b = this.j;
                return null;
            }
            StringBuilder sbU = outline.U("Built-ins module is already set: ");
            sbU.append(KotlinBuiltIns.this.f3211b);
            sbU.append(" (attempting to reset to ");
            sbU.append(this.j);
            sbU.append(")");
            throw new AssertionError(sbU.toString());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.h$e */
    /* JADX INFO: compiled from: KotlinBuiltIns.java */
    public static class e {
        public final Map<PrimitiveType, KotlinType4> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<KotlinType, KotlinType4> f3212b;
        public final Map<KotlinType4, KotlinType4> c;

        public e(Map map, Map map2, Map map3, a aVar) {
            this.a = map;
            this.f3212b = map2;
            this.c = map3;
        }
    }

    public KotlinBuiltIns(StorageManager storageManager) {
        if (storageManager == null) {
            a(0);
            throw null;
        }
        this.e = storageManager;
        storageManager.createLazyValue(new a());
        this.c = storageManager.createLazyValue(new b());
        this.d = storageManager.createMemoizedFunction(new c());
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 8:
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 45:
            case 52:
            case 66:
            case 70:
            case 71:
            case 72:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 81:
            case 82:
            case 84:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                i2 = 2;
                break;
            case 8:
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 45:
            case 52:
            case 66:
            case 70:
            case 71:
            case 72:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 81:
            case 82:
            case 84:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 71:
                objArr[0] = "module";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 8:
            case 9:
            case 75:
            case 76:
            case 88:
            case 95:
            case 102:
            case 106:
            case 107:
            case Opcodes.D2F /* 144 */:
            case Opcodes.I2B /* 145 */:
            case Opcodes.I2S /* 147 */:
            case 155:
            case 156:
            case 157:
                objArr[0] = "descriptor";
                break;
            case 11:
            case 97:
            case 99:
            case 101:
            case 103:
            case 105:
            case Opcodes.I2F /* 134 */:
                objArr[0] = "fqName";
                break;
            case 13:
                objArr[0] = "simpleName";
                break;
            case 15:
            case 16:
            case 52:
            case 87:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 96:
            case 98:
            case 104:
            case 108:
            case 109:
            case 110:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case Opcodes.LUSHR /* 125 */:
            case 126:
            case Opcodes.LAND /* 127 */:
            case 128:
            case Opcodes.LOR /* 129 */:
            case 130:
            case Opcodes.LXOR /* 131 */:
            case Opcodes.IINC /* 132 */:
            case Opcodes.I2L /* 133 */:
            case Opcodes.I2D /* 135 */:
            case Opcodes.L2I /* 136 */:
            case Opcodes.L2F /* 137 */:
            case Opcodes.L2D /* 138 */:
            case Opcodes.F2I /* 139 */:
            case Opcodes.F2L /* 140 */:
            case Opcodes.F2D /* 141 */:
            case Opcodes.D2I /* 142 */:
            case Opcodes.D2L /* 143 */:
            case Opcodes.I2C /* 146 */:
            case Opcodes.LCMP /* 148 */:
            case Opcodes.FCMPL /* 149 */:
            case 150:
            case Opcodes.DCMPL /* 151 */:
            case Opcodes.DCMPG /* 152 */:
            case 153:
            case 154:
            case Opcodes.IF_ICMPEQ /* 159 */:
                objArr[0] = "type";
                break;
            case 45:
                objArr[0] = "classSimpleName";
                break;
            case 66:
                objArr[0] = "arrayType";
                break;
            case 70:
                objArr[0] = "notNullArrayType";
                break;
            case 72:
                objArr[0] = "primitiveType";
                break;
            case 74:
                objArr[0] = "kotlinType";
                break;
            case 77:
            case 81:
                objArr[0] = "projectionType";
                break;
            case 78:
            case 82:
            case 84:
                objArr[0] = "argument";
                break;
            case 79:
                objArr[0] = "annotations";
                break;
            case 100:
                objArr[0] = "typeConstructor";
                break;
            case 111:
                objArr[0] = "classDescriptor";
                break;
            case 158:
                objArr[0] = "declarationDescriptor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i) {
            case 2:
                objArr[1] = "getAdditionalClassPartsProvider";
                break;
            case 3:
                objArr[1] = "getPlatformDependentDeclarationFilter";
                break;
            case 4:
                objArr[1] = "getClassDescriptorFactories";
                break;
            case 5:
                objArr[1] = "getStorageManager";
                break;
            case 6:
                objArr[1] = "getBuiltInsModule";
                break;
            case 7:
                objArr[1] = "getBuiltInPackagesImportedByDefault";
                break;
            case 8:
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 45:
            case 52:
            case 66:
            case 70:
            case 71:
            case 72:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 81:
            case 82:
            case 84:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 10:
                objArr[1] = "getBuiltInsPackageScope";
                break;
            case 12:
                objArr[1] = "getBuiltInClassByFqName";
                break;
            case 14:
                objArr[1] = "getBuiltInClassByName";
                break;
            case 17:
                objArr[1] = "getSuspendFunction";
                break;
            case 18:
                objArr[1] = "getKFunction";
                break;
            case 19:
                objArr[1] = "getKSuspendFunction";
                break;
            case 20:
                objArr[1] = "getKClass";
                break;
            case 21:
                objArr[1] = "getKCallable";
                break;
            case 22:
                objArr[1] = "getKProperty";
                break;
            case 23:
                objArr[1] = "getKProperty0";
                break;
            case 24:
                objArr[1] = "getKProperty1";
                break;
            case 25:
                objArr[1] = "getKProperty2";
                break;
            case 26:
                objArr[1] = "getKMutableProperty0";
                break;
            case 27:
                objArr[1] = "getKMutableProperty1";
                break;
            case 28:
                objArr[1] = "getKMutableProperty2";
                break;
            case 29:
                objArr[1] = "getIterator";
                break;
            case 30:
                objArr[1] = "getIterable";
                break;
            case 31:
                objArr[1] = "getMutableIterable";
                break;
            case 32:
                objArr[1] = "getMutableIterator";
                break;
            case 33:
                objArr[1] = "getCollection";
                break;
            case 34:
                objArr[1] = "getMutableCollection";
                break;
            case 35:
                objArr[1] = "getList";
                break;
            case 36:
                objArr[1] = "getMutableList";
                break;
            case 37:
                objArr[1] = "getSet";
                break;
            case 38:
                objArr[1] = "getMutableSet";
                break;
            case 39:
                objArr[1] = "getMap";
                break;
            case 40:
                objArr[1] = "getMutableMap";
                break;
            case 41:
                objArr[1] = "getMapEntry";
                break;
            case 42:
                objArr[1] = "getMutableMapEntry";
                break;
            case 43:
                objArr[1] = "getListIterator";
                break;
            case 44:
                objArr[1] = "getMutableListIterator";
                break;
            case 46:
                objArr[1] = "getBuiltInTypeByClassName";
                break;
            case 47:
                objArr[1] = "getNothingType";
                break;
            case 48:
                objArr[1] = "getNullableNothingType";
                break;
            case 49:
                objArr[1] = "getAnyType";
                break;
            case 50:
                objArr[1] = "getNullableAnyType";
                break;
            case 51:
                objArr[1] = "getDefaultBound";
                break;
            case 53:
                objArr[1] = "getPrimitiveKotlinType";
                break;
            case 54:
                objArr[1] = "getNumberType";
                break;
            case 55:
                objArr[1] = "getByteType";
                break;
            case 56:
                objArr[1] = "getShortType";
                break;
            case 57:
                objArr[1] = "getIntType";
                break;
            case 58:
                objArr[1] = "getLongType";
                break;
            case 59:
                objArr[1] = "getFloatType";
                break;
            case 60:
                objArr[1] = "getDoubleType";
                break;
            case 61:
                objArr[1] = "getCharType";
                break;
            case 62:
                objArr[1] = "getBooleanType";
                break;
            case 63:
                objArr[1] = "getUnitType";
                break;
            case 64:
                objArr[1] = "getStringType";
                break;
            case 65:
                objArr[1] = "getIterableType";
                break;
            case 67:
            case 68:
            case 69:
                objArr[1] = "getArrayElementType";
                break;
            case 73:
                objArr[1] = "getPrimitiveArrayKotlinType";
                break;
            case 80:
            case 83:
                objArr[1] = "getArrayType";
                break;
            case 85:
                objArr[1] = "getEnumType";
                break;
            case 86:
                objArr[1] = "getAnnotationType";
                break;
        }
        switch (i) {
            case 1:
                objArr[2] = "setBuiltInsModule";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                break;
            case 8:
                objArr[2] = "isBuiltIn";
                break;
            case 9:
                objArr[2] = "isUnderKotlinPackage";
                break;
            case 11:
                objArr[2] = "getBuiltInClassByFqName";
                break;
            case 13:
                objArr[2] = "getBuiltInClassByName";
                break;
            case 15:
                objArr[2] = "getPrimitiveClassDescriptor";
                break;
            case 16:
                objArr[2] = "getPrimitiveArrayClassDescriptor";
                break;
            case 45:
                objArr[2] = "getBuiltInTypeByClassName";
                break;
            case 52:
                objArr[2] = "getPrimitiveKotlinType";
                break;
            case 66:
                objArr[2] = "getArrayElementType";
                break;
            case 70:
            case 71:
                objArr[2] = "getElementTypeForUnsignedArray";
                break;
            case 72:
                objArr[2] = "getPrimitiveArrayKotlinType";
                break;
            case 74:
                objArr[2] = "getPrimitiveArrayKotlinTypeByPrimitiveKotlinType";
                break;
            case 75:
            case 92:
                objArr[2] = "getPrimitiveType";
                break;
            case 76:
                objArr[2] = "getPrimitiveArrayType";
                break;
            case 77:
            case 78:
            case 79:
            case 81:
            case 82:
                objArr[2] = "getArrayType";
                break;
            case 84:
                objArr[2] = "getEnumType";
                break;
            case 87:
                objArr[2] = "isArray";
                break;
            case 88:
            case 89:
                objArr[2] = "isArrayOrPrimitiveArray";
                break;
            case 90:
                objArr[2] = "isPrimitiveArray";
                break;
            case 91:
                objArr[2] = "getPrimitiveArrayElementType";
                break;
            case 93:
                objArr[2] = "isPrimitiveType";
                break;
            case 94:
                objArr[2] = "isPrimitiveTypeOrNullablePrimitiveType";
                break;
            case 95:
                objArr[2] = "isPrimitiveClass";
                break;
            case 96:
            case 97:
            case 98:
            case 99:
                objArr[2] = "isConstructedFromGivenClass";
                break;
            case 100:
            case 101:
                objArr[2] = "isTypeConstructorForGivenClass";
                break;
            case 102:
            case 103:
                objArr[2] = "classFqNameEquals";
                break;
            case 104:
            case 105:
                objArr[2] = "isNotNullConstructedFromGivenClass";
                break;
            case 106:
                objArr[2] = "isSpecialClassWithNoSupertypes";
                break;
            case 107:
            case 108:
                objArr[2] = "isAny";
                break;
            case 109:
            case 111:
                objArr[2] = "isBoolean";
                break;
            case 110:
                objArr[2] = "isBooleanOrNullableBoolean";
                break;
            case 112:
                objArr[2] = "isNumber";
                break;
            case 113:
                objArr[2] = "isChar";
                break;
            case 114:
                objArr[2] = "isCharOrNullableChar";
                break;
            case 115:
                objArr[2] = "isInt";
                break;
            case 116:
                objArr[2] = "isByte";
                break;
            case 117:
                objArr[2] = "isLong";
                break;
            case 118:
                objArr[2] = "isLongOrNullableLong";
                break;
            case 119:
                objArr[2] = "isShort";
                break;
            case 120:
                objArr[2] = "isFloat";
                break;
            case 121:
                objArr[2] = "isFloatOrNullableFloat";
                break;
            case 122:
                objArr[2] = "isDouble";
                break;
            case 123:
                objArr[2] = "isUByte";
                break;
            case 124:
                objArr[2] = "isUShort";
                break;
            case Opcodes.LUSHR /* 125 */:
                objArr[2] = "isUInt";
                break;
            case 126:
                objArr[2] = "isULong";
                break;
            case Opcodes.LAND /* 127 */:
                objArr[2] = "isUByteArray";
                break;
            case 128:
                objArr[2] = "isUShortArray";
                break;
            case Opcodes.LOR /* 129 */:
                objArr[2] = "isUIntArray";
                break;
            case 130:
                objArr[2] = "isULongArray";
                break;
            case Opcodes.LXOR /* 131 */:
                objArr[2] = "isUnsignedArrayType";
                break;
            case Opcodes.IINC /* 132 */:
                objArr[2] = "isDoubleOrNullableDouble";
                break;
            case Opcodes.I2L /* 133 */:
            case Opcodes.I2F /* 134 */:
                objArr[2] = "isConstructedFromGivenClassAndNotNullable";
                break;
            case Opcodes.I2D /* 135 */:
                objArr[2] = "isNothing";
                break;
            case Opcodes.L2I /* 136 */:
                objArr[2] = "isNullableNothing";
                break;
            case Opcodes.L2F /* 137 */:
                objArr[2] = "isNothingOrNullableNothing";
                break;
            case Opcodes.L2D /* 138 */:
                objArr[2] = "isAnyOrNullableAny";
                break;
            case Opcodes.F2I /* 139 */:
                objArr[2] = "isNullableAny";
                break;
            case Opcodes.F2L /* 140 */:
                objArr[2] = "isDefaultBound";
                break;
            case Opcodes.F2D /* 141 */:
                objArr[2] = "isUnit";
                break;
            case Opcodes.D2I /* 142 */:
                objArr[2] = "isUnitOrNullableUnit";
                break;
            case Opcodes.D2L /* 143 */:
                objArr[2] = "isBooleanOrSubtype";
                break;
            case Opcodes.D2F /* 144 */:
                objArr[2] = "isMemberOfAny";
                break;
            case Opcodes.I2B /* 145 */:
            case Opcodes.I2C /* 146 */:
                objArr[2] = "isEnum";
                break;
            case Opcodes.I2S /* 147 */:
            case Opcodes.LCMP /* 148 */:
                objArr[2] = "isComparable";
                break;
            case Opcodes.FCMPL /* 149 */:
                objArr[2] = "isCollectionOrNullableCollection";
                break;
            case 150:
                objArr[2] = "isListOrNullableList";
                break;
            case Opcodes.DCMPL /* 151 */:
                objArr[2] = "isSetOrNullableSet";
                break;
            case Opcodes.DCMPG /* 152 */:
                objArr[2] = "isMapOrNullableMap";
                break;
            case 153:
                objArr[2] = "isIterableOrNullableIterable";
                break;
            case 154:
                objArr[2] = "isThrowableOrNullableThrowable";
                break;
            case 155:
                objArr[2] = "isKClass";
                break;
            case 156:
                objArr[2] = "isNonPrimitiveArray";
                break;
            case 157:
                objArr[2] = "isCloneable";
                break;
            case 158:
                objArr[2] = "isDeprecated";
                break;
            case Opcodes.IF_ICMPEQ /* 159 */:
                objArr[2] = "isNotNullOrNullableFunctionSupertype";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                throw new IllegalStateException(str2);
            case 8:
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 45:
            case 52:
            case 66:
            case 70:
            case 71:
            case 72:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 81:
            case 82:
            case 84:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static KotlinType4 b(KotlinBuiltIns kotlinBuiltIns, String str) {
        Objects.requireNonNull(kotlinBuiltIns);
        if (str == null) {
            a(45);
            throw null;
        }
        KotlinType4 defaultType = kotlinBuiltIns.f(str).getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        a(46);
        throw null;
    }

    public static boolean c(ClassifierDescriptor classifierDescriptor, FqNameUnsafe fqNameUnsafe) {
        if (classifierDescriptor == null) {
            a(102);
            throw null;
        }
        if (fqNameUnsafe != null) {
            return classifierDescriptor.getName().equals(fqNameUnsafe.shortName()) && fqNameUnsafe.equals(DescriptorUtils.getFqName(classifierDescriptor));
        }
        a(103);
        throw null;
    }

    public static PrimitiveType getPrimitiveArrayType(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(76);
            throw null;
        }
        if (StandardNames.a.n0.contains(declarationDescriptor.getName())) {
            return StandardNames.a.p0.get(DescriptorUtils.getFqName(declarationDescriptor));
        }
        return null;
    }

    public static PrimitiveType getPrimitiveType(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(75);
            throw null;
        }
        if (StandardNames.a.m0.contains(declarationDescriptor.getName())) {
            return StandardNames.a.o0.get(DescriptorUtils.getFqName(declarationDescriptor));
        }
        return null;
    }

    public static boolean i(KotlinType kotlinType, FqNameUnsafe fqNameUnsafe) {
        if (kotlinType == null) {
            a(96);
            throw null;
        }
        if (fqNameUnsafe != null) {
            return isTypeConstructorForGivenClass(kotlinType.getConstructor(), fqNameUnsafe);
        }
        a(97);
        throw null;
    }

    public static boolean isAny(ClassDescriptor classDescriptor) {
        if (classDescriptor != null) {
            return c(classDescriptor, StandardNames.a.f3217b);
        }
        a(107);
        throw null;
    }

    public static boolean isAnyOrNullableAny(KotlinType kotlinType) {
        if (kotlinType != null) {
            return i(kotlinType, StandardNames.a.f3217b);
        }
        a(Opcodes.L2D);
        throw null;
    }

    public static boolean isArray(KotlinType kotlinType) {
        if (kotlinType != null) {
            return i(kotlinType, StandardNames.a.h);
        }
        a(87);
        throw null;
    }

    public static boolean isArrayOrPrimitiveArray(ClassDescriptor classDescriptor) {
        if (classDescriptor != null) {
            return c(classDescriptor, StandardNames.a.h) || getPrimitiveArrayType(classDescriptor) != null;
        }
        a(88);
        throw null;
    }

    public static boolean isBoolean(KotlinType kotlinType) {
        if (kotlinType != null) {
            return j(kotlinType, StandardNames.a.i);
        }
        a(109);
        throw null;
    }

    public static boolean isBuiltIn(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            return DescriptorUtils.getParentOfType(declarationDescriptor, BuiltInsPackageFragment.class, false) != null;
        }
        a(8);
        throw null;
    }

    public static boolean isByte(KotlinType kotlinType) {
        if (kotlinType != null) {
            return j(kotlinType, StandardNames.a.k);
        }
        a(116);
        throw null;
    }

    public static boolean isChar(KotlinType kotlinType) {
        if (kotlinType != null) {
            return j(kotlinType, StandardNames.a.j);
        }
        a(113);
        throw null;
    }

    public static boolean isDefaultBound(KotlinType kotlinType) {
        if (kotlinType != null) {
            return isNullableAny(kotlinType);
        }
        a(Opcodes.F2L);
        throw null;
    }

    public static boolean isDeprecated(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(158);
            throw null;
        }
        if (declarationDescriptor.getOriginal().getAnnotations().hasAnnotation(StandardNames.a.u)) {
            return true;
        }
        if (!(declarationDescriptor instanceof PropertyDescriptor)) {
            return false;
        }
        PropertyDescriptor propertyDescriptor = (PropertyDescriptor) declarationDescriptor;
        boolean zIsVar = propertyDescriptor.isVar();
        PropertyGetterDescriptor getter = propertyDescriptor.getGetter();
        PropertySetterDescriptor setter = propertyDescriptor.getSetter();
        if (getter != null && isDeprecated(getter)) {
            if (!zIsVar) {
                return true;
            }
            if (setter != null && isDeprecated(setter)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDouble(KotlinType kotlinType) {
        if (kotlinType != null) {
            return isDoubleOrNullableDouble(kotlinType) && !kotlinType.isMarkedNullable();
        }
        a(122);
        throw null;
    }

    public static boolean isDoubleOrNullableDouble(KotlinType kotlinType) {
        if (kotlinType != null) {
            return i(kotlinType, StandardNames.a.p);
        }
        a(Opcodes.IINC);
        throw null;
    }

    public static boolean isFloat(KotlinType kotlinType) {
        if (kotlinType != null) {
            return isFloatOrNullableFloat(kotlinType) && !kotlinType.isMarkedNullable();
        }
        a(120);
        throw null;
    }

    public static boolean isFloatOrNullableFloat(KotlinType kotlinType) {
        if (kotlinType != null) {
            return i(kotlinType, StandardNames.a.o);
        }
        a(121);
        throw null;
    }

    public static boolean isInt(KotlinType kotlinType) {
        if (kotlinType != null) {
            return j(kotlinType, StandardNames.a.m);
        }
        a(115);
        throw null;
    }

    public static boolean isKClass(ClassDescriptor classDescriptor) {
        if (classDescriptor != null) {
            return c(classDescriptor, StandardNames.a.X);
        }
        a(155);
        throw null;
    }

    public static boolean isLong(KotlinType kotlinType) {
        if (kotlinType != null) {
            return j(kotlinType, StandardNames.a.n);
        }
        a(117);
        throw null;
    }

    public static boolean isNothing(KotlinType kotlinType) {
        if (kotlinType != null) {
            return isNothingOrNullableNothing(kotlinType) && !TypeUtils.isNullableType(kotlinType);
        }
        a(Opcodes.I2D);
        throw null;
    }

    public static boolean isNothingOrNullableNothing(KotlinType kotlinType) {
        if (kotlinType != null) {
            return i(kotlinType, StandardNames.a.c);
        }
        a(Opcodes.L2F);
        throw null;
    }

    public static boolean isNullableAny(KotlinType kotlinType) {
        if (kotlinType != null) {
            return isAnyOrNullableAny(kotlinType) && kotlinType.isMarkedNullable();
        }
        a(Opcodes.F2I);
        throw null;
    }

    public static boolean isPrimitiveArray(KotlinType kotlinType) {
        if (kotlinType != null) {
            ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
            return (declarationDescriptor == null || getPrimitiveArrayType(declarationDescriptor) == null) ? false : true;
        }
        a(90);
        throw null;
    }

    public static boolean isPrimitiveClass(ClassDescriptor classDescriptor) {
        if (classDescriptor != null) {
            return getPrimitiveType(classDescriptor) != null;
        }
        a(95);
        throw null;
    }

    public static boolean isPrimitiveType(KotlinType kotlinType) {
        if (kotlinType != null) {
            return !kotlinType.isMarkedNullable() && isPrimitiveTypeOrNullablePrimitiveType(kotlinType);
        }
        a(93);
        throw null;
    }

    public static boolean isPrimitiveTypeOrNullablePrimitiveType(KotlinType kotlinType) {
        if (kotlinType != null) {
            ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
            return (declarationDescriptor instanceof ClassDescriptor) && isPrimitiveClass((ClassDescriptor) declarationDescriptor);
        }
        a(94);
        throw null;
    }

    public static boolean isShort(KotlinType kotlinType) {
        if (kotlinType != null) {
            return j(kotlinType, StandardNames.a.l);
        }
        a(119);
        throw null;
    }

    public static boolean isSpecialClassWithNoSupertypes(ClassDescriptor classDescriptor) {
        if (classDescriptor != null) {
            return c(classDescriptor, StandardNames.a.f3217b) || c(classDescriptor, StandardNames.a.c);
        }
        a(106);
        throw null;
    }

    public static boolean isString(KotlinType kotlinType) {
        return kotlinType != null && k(kotlinType, StandardNames.a.g);
    }

    public static boolean isTypeConstructorForGivenClass(TypeConstructor typeConstructor, FqNameUnsafe fqNameUnsafe) {
        if (typeConstructor == null) {
            a(100);
            throw null;
        }
        if (fqNameUnsafe != null) {
            ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
            return (declarationDescriptor instanceof ClassDescriptor) && c(declarationDescriptor, fqNameUnsafe);
        }
        a(101);
        throw null;
    }

    public static boolean isUByteArray(KotlinType kotlinType) {
        if (kotlinType != null) {
            return j(kotlinType, StandardNames.a.f3225i0.toUnsafe());
        }
        a(Opcodes.LAND);
        throw null;
    }

    public static boolean isUIntArray(KotlinType kotlinType) {
        if (kotlinType != null) {
            return j(kotlinType, StandardNames.a.k0.toUnsafe());
        }
        a(Opcodes.LOR);
        throw null;
    }

    public static boolean isULongArray(KotlinType kotlinType) {
        if (kotlinType != null) {
            return j(kotlinType, StandardNames.a.l0.toUnsafe());
        }
        a(130);
        throw null;
    }

    public static boolean isUShortArray(KotlinType kotlinType) {
        if (kotlinType != null) {
            return j(kotlinType, StandardNames.a.f3226j0.toUnsafe());
        }
        a(128);
        throw null;
    }

    public static boolean isUnderKotlinPackage(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(9);
            throw null;
        }
        while (declarationDescriptor != null) {
            if (declarationDescriptor instanceof PackageFragmentDescriptor) {
                return ((PackageFragmentDescriptor) declarationDescriptor).getFqName().startsWith(StandardNames.k);
            }
            declarationDescriptor = declarationDescriptor.getContainingDeclaration();
        }
        return false;
    }

    public static boolean isUnit(KotlinType kotlinType) {
        if (kotlinType != null) {
            return k(kotlinType, StandardNames.a.e);
        }
        a(Opcodes.F2D);
        throw null;
    }

    public static boolean isUnsignedArrayType(KotlinType kotlinType) {
        if (kotlinType != null) {
            return isUByteArray(kotlinType) || isUShortArray(kotlinType) || isUIntArray(kotlinType) || isULongArray(kotlinType);
        }
        a(Opcodes.LXOR);
        throw null;
    }

    public static boolean j(KotlinType kotlinType, FqNameUnsafe fqNameUnsafe) {
        if (kotlinType == null) {
            a(Opcodes.I2L);
            throw null;
        }
        if (fqNameUnsafe != null) {
            return i(kotlinType, fqNameUnsafe) && !kotlinType.isMarkedNullable();
        }
        a(Opcodes.I2F);
        throw null;
    }

    public static boolean k(KotlinType kotlinType, FqNameUnsafe fqNameUnsafe) {
        if (kotlinType == null) {
            a(104);
            throw null;
        }
        if (fqNameUnsafe != null) {
            return !kotlinType.isMarkedNullable() && i(kotlinType, fqNameUnsafe);
        }
        a(105);
        throw null;
    }

    public void d(boolean z2) {
        ModuleDescriptorImpl3 moduleDescriptorImpl3 = new ModuleDescriptorImpl3(a, this.e, this, null);
        this.f3211b = moduleDescriptorImpl3;
        moduleDescriptorImpl3.initialize(BuiltInsLoader.a.getInstance().createPackageFragmentProvider(this.e, this.f3211b, g(), h(), e(), z2));
        ModuleDescriptorImpl3 moduleDescriptorImpl4 = this.f3211b;
        moduleDescriptorImpl4.setDependencies(moduleDescriptorImpl4);
    }

    public AdditionalClassPartsProvider e() {
        return AdditionalClassPartsProvider.a.a;
    }

    public final ClassDescriptor f(String str) {
        if (str == null) {
            a(13);
            throw null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) ((LockBasedStorageManager.m) this.d).invoke(Name.identifier(str));
        if (classDescriptor != null) {
            return classDescriptor;
        }
        a(14);
        throw null;
    }

    public Iterable<ClassDescriptorFactory> g() {
        List listSingletonList = Collections.singletonList(new BuiltInFictitiousFunctionClassFactory(this.e, this.f3211b));
        if (listSingletonList != null) {
            return listSingletonList;
        }
        a(4);
        throw null;
    }

    public ClassDescriptor getAny() {
        return f("Any");
    }

    public KotlinType4 getAnyType() {
        KotlinType4 defaultType = getAny().getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        a(49);
        throw null;
    }

    public ClassDescriptor getArray() {
        return f("Array");
    }

    public KotlinType getArrayElementType(KotlinType kotlinType) {
        ClassId classId;
        ClassId unsignedClassIdByArrayClassId;
        ClassDescriptor classDescriptorFindClassAcrossModuleDependencies;
        KotlinType4 defaultType = null;
        if (kotlinType == null) {
            a(66);
            throw null;
        }
        if (isArray(kotlinType)) {
            if (kotlinType.getArguments().size() != 1) {
                throw new IllegalStateException();
            }
            KotlinType type = kotlinType.getArguments().get(0).getType();
            if (type != null) {
                return type;
            }
            a(67);
            throw null;
        }
        KotlinType kotlinTypeMakeNotNullable = TypeUtils.makeNotNullable(kotlinType);
        KotlinType4 kotlinType4 = this.c.invoke().c.get(kotlinTypeMakeNotNullable);
        if (kotlinType4 != null) {
            return kotlinType4;
        }
        ModuleDescriptor2 containingModuleOrNull = DescriptorUtils.getContainingModuleOrNull(kotlinTypeMakeNotNullable);
        if (containingModuleOrNull != null) {
            if (kotlinTypeMakeNotNullable == null) {
                a(70);
                throw null;
            }
            ClassifierDescriptor declarationDescriptor = kotlinTypeMakeNotNullable.getConstructor().getDeclarationDescriptor();
            if (declarationDescriptor != null) {
                UnsignedType3 unsignedType3 = UnsignedType3.a;
                if (unsignedType3.isShortNameOfUnsignedArray(declarationDescriptor.getName()) && (classId = DescriptorUtils2.getClassId(declarationDescriptor)) != null && (unsignedClassIdByArrayClassId = unsignedType3.getUnsignedClassIdByArrayClassId(classId)) != null && (classDescriptorFindClassAcrossModuleDependencies = findClassInModule.findClassAcrossModuleDependencies(containingModuleOrNull, unsignedClassIdByArrayClassId)) != null) {
                    defaultType = classDescriptorFindClassAcrossModuleDependencies.getDefaultType();
                }
            }
            if (defaultType != null) {
                return defaultType;
            }
        }
        throw new IllegalStateException("not array: " + kotlinType);
    }

    public KotlinType4 getArrayType(Variance variance, KotlinType kotlinType, Annotations4 annotations4) {
        if (variance == null) {
            a(77);
            throw null;
        }
        if (kotlinType == null) {
            a(78);
            throw null;
        }
        if (annotations4 == null) {
            a(79);
            throw null;
        }
        KotlinType4 kotlinType4SimpleNotNullType = KotlinTypeFactory.simpleNotNullType(annotations4, getArray(), Collections.singletonList(new TypeProjectionImpl(variance, kotlinType)));
        if (kotlinType4SimpleNotNullType != null) {
            return kotlinType4SimpleNotNullType;
        }
        a(80);
        throw null;
    }

    public KotlinType4 getBooleanType() {
        KotlinType4 primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.BOOLEAN);
        if (primitiveKotlinType != null) {
            return primitiveKotlinType;
        }
        a(62);
        throw null;
    }

    public ClassDescriptor getBuiltInClassByFqName(FqName fqName) {
        if (fqName == null) {
            a(11);
            throw null;
        }
        ClassDescriptor classDescriptorResolveClassByFqName = descriptorUtil.resolveClassByFqName(this.f3211b, fqName, LookupLocation3.FROM_BUILTINS);
        if (classDescriptorResolveClassByFqName != null) {
            return classDescriptorResolveClassByFqName;
        }
        a(12);
        throw null;
    }

    public ModuleDescriptorImpl3 getBuiltInsModule() {
        ModuleDescriptorImpl3 moduleDescriptorImpl3 = this.f3211b;
        if (moduleDescriptorImpl3 != null) {
            return moduleDescriptorImpl3;
        }
        a(6);
        throw null;
    }

    public MemberScope3 getBuiltInsPackageScope() {
        MemberScope3 memberScope = this.f3211b.getPackage(StandardNames.l).getMemberScope();
        if (memberScope != null) {
            return memberScope;
        }
        a(10);
        throw null;
    }

    public KotlinType4 getByteType() {
        KotlinType4 primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.BYTE);
        if (primitiveKotlinType != null) {
            return primitiveKotlinType;
        }
        a(55);
        throw null;
    }

    public KotlinType4 getCharType() {
        KotlinType4 primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.CHAR);
        if (primitiveKotlinType != null) {
            return primitiveKotlinType;
        }
        a(61);
        throw null;
    }

    public ClassDescriptor getCollection() {
        ClassDescriptor builtInClassByFqName = getBuiltInClassByFqName(StandardNames.a.J);
        if (builtInClassByFqName != null) {
            return builtInClassByFqName;
        }
        a(33);
        throw null;
    }

    public ClassDescriptor getComparable() {
        return f("Comparable");
    }

    public KotlinType4 getDefaultBound() {
        KotlinType4 nullableAnyType = getNullableAnyType();
        if (nullableAnyType != null) {
            return nullableAnyType;
        }
        a(51);
        throw null;
    }

    public KotlinType4 getDoubleType() {
        KotlinType4 primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.DOUBLE);
        if (primitiveKotlinType != null) {
            return primitiveKotlinType;
        }
        a(60);
        throw null;
    }

    public KotlinType4 getFloatType() {
        KotlinType4 primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.FLOAT);
        if (primitiveKotlinType != null) {
            return primitiveKotlinType;
        }
        a(59);
        throw null;
    }

    public ClassDescriptor getFunction(int i) {
        return f(StandardNames.getFunctionName(i));
    }

    public KotlinType4 getIntType() {
        KotlinType4 primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.INT);
        if (primitiveKotlinType != null) {
            return primitiveKotlinType;
        }
        a(57);
        throw null;
    }

    public ClassDescriptor getKClass() {
        ClassDescriptor builtInClassByFqName = getBuiltInClassByFqName(StandardNames.a.X.toSafe());
        if (builtInClassByFqName != null) {
            return builtInClassByFqName;
        }
        a(20);
        throw null;
    }

    public KotlinType4 getLongType() {
        KotlinType4 primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.LONG);
        if (primitiveKotlinType != null) {
            return primitiveKotlinType;
        }
        a(58);
        throw null;
    }

    public ClassDescriptor getNothing() {
        return f("Nothing");
    }

    public KotlinType4 getNothingType() {
        KotlinType4 defaultType = getNothing().getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        a(47);
        throw null;
    }

    public KotlinType4 getNullableAnyType() {
        KotlinType4 kotlinType4MakeNullableAsSpecified = getAnyType().makeNullableAsSpecified(true);
        if (kotlinType4MakeNullableAsSpecified != null) {
            return kotlinType4MakeNullableAsSpecified;
        }
        a(50);
        throw null;
    }

    public KotlinType4 getNullableNothingType() {
        KotlinType4 kotlinType4MakeNullableAsSpecified = getNothingType().makeNullableAsSpecified(true);
        if (kotlinType4MakeNullableAsSpecified != null) {
            return kotlinType4MakeNullableAsSpecified;
        }
        a(48);
        throw null;
    }

    public ClassDescriptor getNumber() {
        return f("Number");
    }

    public KotlinType4 getNumberType() {
        KotlinType4 defaultType = getNumber().getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        a(54);
        throw null;
    }

    public KotlinType4 getPrimitiveArrayKotlinType(PrimitiveType primitiveType) {
        if (primitiveType == null) {
            a(72);
            throw null;
        }
        KotlinType4 kotlinType4 = this.c.invoke().a.get(primitiveType);
        if (kotlinType4 != null) {
            return kotlinType4;
        }
        a(73);
        throw null;
    }

    public KotlinType4 getPrimitiveKotlinType(PrimitiveType primitiveType) {
        if (primitiveType == null) {
            a(52);
            throw null;
        }
        if (primitiveType == null) {
            a(15);
            throw null;
        }
        KotlinType4 defaultType = f(primitiveType.getTypeName().asString()).getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        a(53);
        throw null;
    }

    public KotlinType4 getShortType() {
        KotlinType4 primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.SHORT);
        if (primitiveKotlinType != null) {
            return primitiveKotlinType;
        }
        a(56);
        throw null;
    }

    public ClassDescriptor getString() {
        return f("String");
    }

    public KotlinType4 getStringType() {
        KotlinType4 defaultType = getString().getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        a(64);
        throw null;
    }

    public ClassDescriptor getSuspendFunction(int i) {
        ClassDescriptor builtInClassByFqName = getBuiltInClassByFqName(StandardNames.d.child(Name.identifier(StandardNames.getSuspendFunctionName(i))));
        if (builtInClassByFqName != null) {
            return builtInClassByFqName;
        }
        a(17);
        throw null;
    }

    public ClassDescriptor getUnit() {
        return f("Unit");
    }

    public KotlinType4 getUnitType() {
        KotlinType4 defaultType = getUnit().getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        a(63);
        throw null;
    }

    public PlatformDependentDeclarationFilter h() {
        return PlatformDependentDeclarationFilter.b.a;
    }

    public void setBuiltInsModule(ModuleDescriptorImpl3 moduleDescriptorImpl3) {
        if (moduleDescriptorImpl3 != null) {
            this.e.compute(new d(moduleDescriptorImpl3));
        } else {
            a(1);
            throw null;
        }
    }

    public KotlinType4 getArrayType(Variance variance, KotlinType kotlinType) {
        if (variance == null) {
            a(81);
            throw null;
        }
        if (kotlinType != null) {
            KotlinType4 arrayType = getArrayType(variance, kotlinType, Annotations4.f.getEMPTY());
            if (arrayType != null) {
                return arrayType;
            }
            a(83);
            throw null;
        }
        a(82);
        throw null;
    }
}
