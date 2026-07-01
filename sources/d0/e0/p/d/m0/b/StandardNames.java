package d0.e0.p.d.m0.b;

import androidx.core.app.NotificationCompat;
import d0.e0.p.d.m0.b.p.FunctionClassKind;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.FqNameUnsafe;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.p.collections;
import d0.t.Collections2;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.k, reason: use source file name */
/* JADX INFO: compiled from: StandardNames.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class StandardNames {
    public static final StandardNames a = new StandardNames();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Name f3215b;
    public static final Name c;
    public static final FqName d;
    public static final FqName e;
    public static final FqName f;
    public static final FqName g;
    public static final FqName h;
    public static final FqName i;
    public static final List<String> j;
    public static final Name k;
    public static final FqName l;
    public static final FqName m;
    public static final FqName n;
    public static final FqName o;
    public static final Set<FqName> p;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.k$a */
    /* JADX INFO: compiled from: StandardNames.kt */
    public static final class a {
        public static final FqName A;
        public static final FqName B;
        public static final FqName C;
        public static final FqName D;
        public static final FqName E;
        public static final FqName F;
        public static final FqName G;
        public static final FqName H;
        public static final FqName I;
        public static final FqName J;
        public static final FqName K;
        public static final FqName L;
        public static final FqName M;
        public static final FqName N;
        public static final FqName O;
        public static final FqName P;
        public static final FqName Q;
        public static final FqName R;
        public static final FqName S;
        public static final FqName T;
        public static final FqName U;
        public static final FqName V;
        public static final FqName W;
        public static final FqNameUnsafe X;
        public static final FqNameUnsafe Y;
        public static final ClassId Z;
        public static final a a;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public static final FqName f3216a0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final FqNameUnsafe f3217b;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public static final FqName f3218b0;
        public static final FqNameUnsafe c;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public static final FqName f3219c0;
        public static final FqNameUnsafe d;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public static final FqName f3220d0;
        public static final FqNameUnsafe e;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public static final ClassId f3221e0;
        public static final FqNameUnsafe f;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public static final ClassId f3222f0;
        public static final FqNameUnsafe g;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public static final ClassId f3223g0;
        public static final FqNameUnsafe h;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public static final ClassId f3224h0;
        public static final FqNameUnsafe i;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public static final FqName f3225i0;
        public static final FqNameUnsafe j;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public static final FqName f3226j0;
        public static final FqNameUnsafe k;
        public static final FqName k0;
        public static final FqNameUnsafe l;
        public static final FqName l0;
        public static final FqNameUnsafe m;
        public static final Set<Name> m0;
        public static final FqNameUnsafe n;
        public static final Set<Name> n0;
        public static final FqNameUnsafe o;
        public static final Map<FqNameUnsafe, PrimitiveType> o0;
        public static final FqNameUnsafe p;
        public static final Map<FqNameUnsafe, PrimitiveType> p0;
        public static final FqNameUnsafe q;
        public static final FqNameUnsafe r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final FqName f3227s;
        public static final FqName t;
        public static final FqName u;
        public static final FqName v;
        public static final FqName w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final FqName f3228x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final FqName f3229y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final FqName f3230z;

        static {
            a aVar = new a();
            a = aVar;
            FqNameUnsafe unsafe = aVar.c("Any").toUnsafe();
            Intrinsics3.checkNotNullExpressionValue(unsafe, "fqName(simpleName).toUnsafe()");
            f3217b = unsafe;
            FqNameUnsafe unsafe2 = aVar.c("Nothing").toUnsafe();
            Intrinsics3.checkNotNullExpressionValue(unsafe2, "fqName(simpleName).toUnsafe()");
            c = unsafe2;
            FqNameUnsafe unsafe3 = aVar.c("Cloneable").toUnsafe();
            Intrinsics3.checkNotNullExpressionValue(unsafe3, "fqName(simpleName).toUnsafe()");
            d = unsafe3;
            aVar.c("Suppress");
            FqNameUnsafe unsafe4 = aVar.c("Unit").toUnsafe();
            Intrinsics3.checkNotNullExpressionValue(unsafe4, "fqName(simpleName).toUnsafe()");
            e = unsafe4;
            FqNameUnsafe unsafe5 = aVar.c("CharSequence").toUnsafe();
            Intrinsics3.checkNotNullExpressionValue(unsafe5, "fqName(simpleName).toUnsafe()");
            f = unsafe5;
            FqNameUnsafe unsafe6 = aVar.c("String").toUnsafe();
            Intrinsics3.checkNotNullExpressionValue(unsafe6, "fqName(simpleName).toUnsafe()");
            g = unsafe6;
            FqNameUnsafe unsafe7 = aVar.c("Array").toUnsafe();
            Intrinsics3.checkNotNullExpressionValue(unsafe7, "fqName(simpleName).toUnsafe()");
            h = unsafe7;
            FqNameUnsafe unsafe8 = aVar.c("Boolean").toUnsafe();
            Intrinsics3.checkNotNullExpressionValue(unsafe8, "fqName(simpleName).toUnsafe()");
            i = unsafe8;
            FqNameUnsafe unsafe9 = aVar.c("Char").toUnsafe();
            Intrinsics3.checkNotNullExpressionValue(unsafe9, "fqName(simpleName).toUnsafe()");
            j = unsafe9;
            FqNameUnsafe unsafe10 = aVar.c("Byte").toUnsafe();
            Intrinsics3.checkNotNullExpressionValue(unsafe10, "fqName(simpleName).toUnsafe()");
            k = unsafe10;
            FqNameUnsafe unsafe11 = aVar.c("Short").toUnsafe();
            Intrinsics3.checkNotNullExpressionValue(unsafe11, "fqName(simpleName).toUnsafe()");
            l = unsafe11;
            FqNameUnsafe unsafe12 = aVar.c("Int").toUnsafe();
            Intrinsics3.checkNotNullExpressionValue(unsafe12, "fqName(simpleName).toUnsafe()");
            m = unsafe12;
            FqNameUnsafe unsafe13 = aVar.c("Long").toUnsafe();
            Intrinsics3.checkNotNullExpressionValue(unsafe13, "fqName(simpleName).toUnsafe()");
            n = unsafe13;
            FqNameUnsafe unsafe14 = aVar.c("Float").toUnsafe();
            Intrinsics3.checkNotNullExpressionValue(unsafe14, "fqName(simpleName).toUnsafe()");
            o = unsafe14;
            FqNameUnsafe unsafe15 = aVar.c("Double").toUnsafe();
            Intrinsics3.checkNotNullExpressionValue(unsafe15, "fqName(simpleName).toUnsafe()");
            p = unsafe15;
            FqNameUnsafe unsafe16 = aVar.c("Number").toUnsafe();
            Intrinsics3.checkNotNullExpressionValue(unsafe16, "fqName(simpleName).toUnsafe()");
            q = unsafe16;
            FqNameUnsafe unsafe17 = aVar.c("Enum").toUnsafe();
            Intrinsics3.checkNotNullExpressionValue(unsafe17, "fqName(simpleName).toUnsafe()");
            r = unsafe17;
            Intrinsics3.checkNotNullExpressionValue(aVar.c("Function").toUnsafe(), "fqName(simpleName).toUnsafe()");
            f3227s = aVar.c("Throwable");
            t = aVar.c("Comparable");
            FqName fqName = StandardNames.o;
            Intrinsics3.checkNotNullExpressionValue(fqName.child(Name.identifier("IntRange")).toUnsafe(), "RANGES_PACKAGE_FQ_NAME.child(Name.identifier(simpleName)).toUnsafe()");
            Intrinsics3.checkNotNullExpressionValue(fqName.child(Name.identifier("LongRange")).toUnsafe(), "RANGES_PACKAGE_FQ_NAME.child(Name.identifier(simpleName)).toUnsafe()");
            u = aVar.c("Deprecated");
            aVar.c("DeprecatedSinceKotlin");
            v = aVar.c("DeprecationLevel");
            w = aVar.c("ReplaceWith");
            f3228x = aVar.c("ExtensionFunctionType");
            f3229y = aVar.c("ParameterName");
            f3230z = aVar.c("Annotation");
            A = aVar.a("Target");
            B = aVar.a("AnnotationTarget");
            C = aVar.a("AnnotationRetention");
            D = aVar.a("Retention");
            E = aVar.a("Repeatable");
            F = aVar.a("MustBeDocumented");
            G = aVar.c("UnsafeVariance");
            aVar.c("PublishedApi");
            H = aVar.b("Iterator");
            I = aVar.b("Iterable");
            J = aVar.b("Collection");
            K = aVar.b("List");
            L = aVar.b("ListIterator");
            M = aVar.b("Set");
            FqName fqNameB = aVar.b("Map");
            N = fqNameB;
            FqName fqNameChild = fqNameB.child(Name.identifier("Entry"));
            Intrinsics3.checkNotNullExpressionValue(fqNameChild, "map.child(Name.identifier(\"Entry\"))");
            O = fqNameChild;
            P = aVar.b("MutableIterator");
            Q = aVar.b("MutableIterable");
            R = aVar.b("MutableCollection");
            S = aVar.b("MutableList");
            T = aVar.b("MutableListIterator");
            U = aVar.b("MutableSet");
            FqName fqNameB2 = aVar.b("MutableMap");
            V = fqNameB2;
            FqName fqNameChild2 = fqNameB2.child(Name.identifier("MutableEntry"));
            Intrinsics3.checkNotNullExpressionValue(fqNameChild2, "mutableMap.child(Name.identifier(\"MutableEntry\"))");
            W = fqNameChild2;
            X = reflect("KClass");
            a aVar2 = a;
            reflect("KCallable");
            reflect("KProperty0");
            reflect("KProperty1");
            reflect("KProperty2");
            reflect("KMutableProperty0");
            reflect("KMutableProperty1");
            reflect("KMutableProperty2");
            FqNameUnsafe fqNameUnsafeReflect = reflect("KProperty");
            Y = fqNameUnsafeReflect;
            reflect("KMutableProperty");
            ClassId classId = ClassId.topLevel(fqNameUnsafeReflect.toSafe());
            Intrinsics3.checkNotNullExpressionValue(classId, "topLevel(kPropertyFqName.toSafe())");
            Z = classId;
            reflect("KDeclarationContainer");
            FqName fqNameC = aVar2.c("UByte");
            f3216a0 = fqNameC;
            FqName fqNameC2 = aVar2.c("UShort");
            f3218b0 = fqNameC2;
            FqName fqNameC3 = aVar2.c("UInt");
            f3219c0 = fqNameC3;
            FqName fqNameC4 = aVar2.c("ULong");
            f3220d0 = fqNameC4;
            ClassId classId2 = ClassId.topLevel(fqNameC);
            Intrinsics3.checkNotNullExpressionValue(classId2, "topLevel(uByteFqName)");
            f3221e0 = classId2;
            ClassId classId3 = ClassId.topLevel(fqNameC2);
            Intrinsics3.checkNotNullExpressionValue(classId3, "topLevel(uShortFqName)");
            f3222f0 = classId3;
            ClassId classId4 = ClassId.topLevel(fqNameC3);
            Intrinsics3.checkNotNullExpressionValue(classId4, "topLevel(uIntFqName)");
            f3223g0 = classId4;
            ClassId classId5 = ClassId.topLevel(fqNameC4);
            Intrinsics3.checkNotNullExpressionValue(classId5, "topLevel(uLongFqName)");
            f3224h0 = classId5;
            f3225i0 = aVar2.c("UByteArray");
            f3226j0 = aVar2.c("UShortArray");
            k0 = aVar2.c("UIntArray");
            l0 = aVar2.c("ULongArray");
            PrimitiveType.valuesCustom();
            HashSet hashSetNewHashSetWithExpectedSize = collections.newHashSetWithExpectedSize(8);
            PrimitiveType[] primitiveTypeArrValues = PrimitiveType.valuesCustom();
            int i2 = 0;
            for (int i3 = 0; i3 < 8; i3++) {
                hashSetNewHashSetWithExpectedSize.add(primitiveTypeArrValues[i3].getTypeName());
            }
            m0 = hashSetNewHashSetWithExpectedSize;
            PrimitiveType.valuesCustom();
            HashSet hashSetNewHashSetWithExpectedSize2 = collections.newHashSetWithExpectedSize(8);
            PrimitiveType[] primitiveTypeArrValues2 = PrimitiveType.valuesCustom();
            for (int i4 = 0; i4 < 8; i4++) {
                hashSetNewHashSetWithExpectedSize2.add(primitiveTypeArrValues2[i4].getArrayTypeName());
            }
            n0 = hashSetNewHashSetWithExpectedSize2;
            PrimitiveType.valuesCustom();
            HashMap mapNewHashMapWithExpectedSize = collections.newHashMapWithExpectedSize(8);
            PrimitiveType[] primitiveTypeArrValues3 = PrimitiveType.valuesCustom();
            int i5 = 0;
            while (i5 < 8) {
                PrimitiveType primitiveType = primitiveTypeArrValues3[i5];
                i5++;
                String strAsString = primitiveType.getTypeName().asString();
                Intrinsics3.checkNotNullExpressionValue(strAsString, "primitiveType.typeName.asString()");
                FqName fqNameChild3 = StandardNames.l.child(Name.identifier(strAsString));
                Intrinsics3.checkNotNullExpressionValue(fqNameChild3, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(simpleName))");
                FqNameUnsafe unsafe18 = fqNameChild3.toUnsafe();
                Intrinsics3.checkNotNullExpressionValue(unsafe18, "fqName(simpleName).toUnsafe()");
                mapNewHashMapWithExpectedSize.put(unsafe18, primitiveType);
            }
            o0 = mapNewHashMapWithExpectedSize;
            PrimitiveType.valuesCustom();
            HashMap mapNewHashMapWithExpectedSize2 = collections.newHashMapWithExpectedSize(8);
            PrimitiveType[] primitiveTypeArrValues4 = PrimitiveType.valuesCustom();
            while (i2 < 8) {
                PrimitiveType primitiveType2 = primitiveTypeArrValues4[i2];
                i2++;
                String strAsString2 = primitiveType2.getArrayTypeName().asString();
                Intrinsics3.checkNotNullExpressionValue(strAsString2, "primitiveType.arrayTypeName.asString()");
                FqName fqNameChild4 = StandardNames.l.child(Name.identifier(strAsString2));
                Intrinsics3.checkNotNullExpressionValue(fqNameChild4, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(simpleName))");
                FqNameUnsafe unsafe19 = fqNameChild4.toUnsafe();
                Intrinsics3.checkNotNullExpressionValue(unsafe19, "fqName(simpleName).toUnsafe()");
                mapNewHashMapWithExpectedSize2.put(unsafe19, primitiveType2);
            }
            p0 = mapNewHashMapWithExpectedSize2;
        }

        public static final FqNameUnsafe reflect(String str) {
            Intrinsics3.checkNotNullParameter(str, "simpleName");
            FqNameUnsafe unsafe = StandardNames.i.child(Name.identifier(str)).toUnsafe();
            Intrinsics3.checkNotNullExpressionValue(unsafe, "KOTLIN_REFLECT_FQ_NAME.child(Name.identifier(simpleName)).toUnsafe()");
            return unsafe;
        }

        public final FqName a(String str) {
            FqName fqNameChild = StandardNames.m.child(Name.identifier(str));
            Intrinsics3.checkNotNullExpressionValue(fqNameChild, "ANNOTATION_PACKAGE_FQ_NAME.child(Name.identifier(simpleName))");
            return fqNameChild;
        }

        public final FqName b(String str) {
            FqName fqNameChild = StandardNames.n.child(Name.identifier(str));
            Intrinsics3.checkNotNullExpressionValue(fqNameChild, "COLLECTIONS_PACKAGE_FQ_NAME.child(Name.identifier(simpleName))");
            return fqNameChild;
        }

        public final FqName c(String str) {
            FqName fqNameChild = StandardNames.l.child(Name.identifier(str));
            Intrinsics3.checkNotNullExpressionValue(fqNameChild, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(simpleName))");
            return fqNameChild;
        }
    }

    static {
        Name nameIdentifier = Name.identifier("values");
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(\"values\")");
        f3215b = nameIdentifier;
        Name nameIdentifier2 = Name.identifier("valueOf");
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier2, "identifier(\"valueOf\")");
        c = nameIdentifier2;
        FqName fqName = new FqName("kotlin.coroutines");
        d = fqName;
        FqName fqNameChild = fqName.child(Name.identifier("experimental"));
        Intrinsics3.checkNotNullExpressionValue(fqNameChild, "COROUTINES_PACKAGE_FQ_NAME_RELEASE.child(Name.identifier(\"experimental\"))");
        e = fqNameChild;
        Intrinsics3.checkNotNullExpressionValue(fqNameChild.child(Name.identifier("intrinsics")), "COROUTINES_PACKAGE_FQ_NAME_EXPERIMENTAL.child(Name.identifier(\"intrinsics\"))");
        FqName fqNameChild2 = fqNameChild.child(Name.identifier("Continuation"));
        Intrinsics3.checkNotNullExpressionValue(fqNameChild2, "COROUTINES_PACKAGE_FQ_NAME_EXPERIMENTAL.child(Name.identifier(\"Continuation\"))");
        f = fqNameChild2;
        FqName fqNameChild3 = fqName.child(Name.identifier("Continuation"));
        Intrinsics3.checkNotNullExpressionValue(fqNameChild3, "COROUTINES_PACKAGE_FQ_NAME_RELEASE.child(Name.identifier(\"Continuation\"))");
        g = fqNameChild3;
        h = new FqName("kotlin.Result");
        FqName fqName2 = new FqName("kotlin.reflect");
        i = fqName2;
        j = Collections2.listOf((Object[]) new String[]{"KProperty", "KMutableProperty", "KFunction", "KSuspendFunction"});
        Name nameIdentifier3 = Name.identifier("kotlin");
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier3, "identifier(\"kotlin\")");
        k = nameIdentifier3;
        FqName fqName3 = FqName.topLevel(nameIdentifier3);
        Intrinsics3.checkNotNullExpressionValue(fqName3, "topLevel(BUILT_INS_PACKAGE_NAME)");
        l = fqName3;
        FqName fqNameChild4 = fqName3.child(Name.identifier("annotation"));
        Intrinsics3.checkNotNullExpressionValue(fqNameChild4, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(\"annotation\"))");
        m = fqNameChild4;
        FqName fqNameChild5 = fqName3.child(Name.identifier("collections"));
        Intrinsics3.checkNotNullExpressionValue(fqNameChild5, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(\"collections\"))");
        n = fqNameChild5;
        FqName fqNameChild6 = fqName3.child(Name.identifier("ranges"));
        Intrinsics3.checkNotNullExpressionValue(fqNameChild6, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(\"ranges\"))");
        o = fqNameChild6;
        Intrinsics3.checkNotNullExpressionValue(fqName3.child(Name.identifier(NotificationCompat.MessagingStyle.Message.KEY_TEXT)), "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(\"text\"))");
        FqName fqNameChild7 = fqName3.child(Name.identifier("internal"));
        Intrinsics3.checkNotNullExpressionValue(fqNameChild7, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(\"internal\"))");
        p = Sets5.setOf((Object[]) new FqName[]{fqName3, fqNameChild5, fqNameChild6, fqNameChild4, fqName2, fqNameChild7, fqName});
    }

    public static final ClassId getFunctionClassId(int i2) {
        return new ClassId(l, Name.identifier(getFunctionName(i2)));
    }

    public static final String getFunctionName(int i2) {
        return Intrinsics3.stringPlus("Function", Integer.valueOf(i2));
    }

    public static final FqName getPrimitiveFqName(PrimitiveType primitiveType) {
        Intrinsics3.checkNotNullParameter(primitiveType, "primitiveType");
        FqName fqNameChild = l.child(primitiveType.getTypeName());
        Intrinsics3.checkNotNullExpressionValue(fqNameChild, "BUILT_INS_PACKAGE_FQ_NAME.child(primitiveType.typeName)");
        return fqNameChild;
    }

    public static final String getSuspendFunctionName(int i2) {
        return Intrinsics3.stringPlus(FunctionClassKind.l.getClassNamePrefix(), Integer.valueOf(i2));
    }

    public static final boolean isPrimitiveArray(FqNameUnsafe fqNameUnsafe) {
        Intrinsics3.checkNotNullParameter(fqNameUnsafe, "arrayFqName");
        return a.p0.get(fqNameUnsafe) != null;
    }
}
