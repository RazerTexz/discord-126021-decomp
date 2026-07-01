package d0.e0.p.d.m0.b.p;

import b.d.b.a.outline;
import d0.e0.p.d.m0.b.StandardNames;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'm' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: renamed from: d0.e0.p.d.m0.b.p.c, reason: use source file name */
/* JADX INFO: compiled from: FunctionClassKind.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FunctionClassKind {
    public static final a j;
    public static final FunctionClassKind k;
    public static final FunctionClassKind l;
    public static final FunctionClassKind m;
    public static final FunctionClassKind n;
    public static final /* synthetic */ FunctionClassKind[] o;
    private final String classNamePrefix;
    private final FqName packageFqName;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.p.c$a */
    /* JADX INFO: compiled from: FunctionClassKind.kt */
    public static final class a {

        /* JADX INFO: renamed from: d0.e0.p.d.m0.b.p.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: FunctionClassKind.kt */
        public static final class C0378a {
            public final FunctionClassKind a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f3235b;

            public C0378a(FunctionClassKind functionClassKind, int i) {
                Intrinsics3.checkNotNullParameter(functionClassKind, "kind");
                this.a = functionClassKind;
                this.f3235b = i;
            }

            public final FunctionClassKind component1() {
                return this.a;
            }

            public final int component2() {
                return this.f3235b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0378a)) {
                    return false;
                }
                C0378a c0378a = (C0378a) obj;
                return this.a == c0378a.a && this.f3235b == c0378a.f3235b;
            }

            public final FunctionClassKind getKind() {
                return this.a;
            }

            public int hashCode() {
                return (this.a.hashCode() * 31) + this.f3235b;
            }

            public String toString() {
                StringBuilder sbU = outline.U("KindWithArity(kind=");
                sbU.append(this.a);
                sbU.append(", arity=");
                return outline.A(sbU, this.f3235b, ')');
            }
        }

        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final FunctionClassKind byClassNamePrefix(FqName fqName, String str) {
            Intrinsics3.checkNotNullParameter(fqName, "packageFqName");
            Intrinsics3.checkNotNullParameter(str, "className");
            FunctionClassKind[] functionClassKindArrValues = FunctionClassKind.values();
            for (int i = 0; i < 4; i++) {
                FunctionClassKind functionClassKind = functionClassKindArrValues[i];
                if (Intrinsics3.areEqual(functionClassKind.getPackageFqName(), fqName) && StringsJVM.startsWith$default(str, functionClassKind.getClassNamePrefix(), false, 2, null)) {
                    return functionClassKind;
                }
            }
            return null;
        }

        public final FunctionClassKind getFunctionalClassKind(String str, FqName fqName) {
            Intrinsics3.checkNotNullParameter(str, "className");
            Intrinsics3.checkNotNullParameter(fqName, "packageFqName");
            C0378a className = parseClassName(str, fqName);
            if (className == null) {
                return null;
            }
            return className.getKind();
        }

        public final C0378a parseClassName(String str, FqName fqName) {
            Integer numValueOf;
            Intrinsics3.checkNotNullParameter(str, "className");
            Intrinsics3.checkNotNullParameter(fqName, "packageFqName");
            FunctionClassKind functionClassKindByClassNamePrefix = byClassNamePrefix(fqName, str);
            if (functionClassKindByClassNamePrefix == null) {
                return null;
            }
            String strSubstring = str.substring(functionClassKindByClassNamePrefix.getClassNamePrefix().length());
            Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            if (strSubstring.length() == 0) {
                numValueOf = null;
            } else {
                int length = strSubstring.length();
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i < length) {
                        char cCharAt = strSubstring.charAt(i);
                        i++;
                        int i3 = cCharAt - '0';
                        if (!(i3 >= 0 && i3 <= 9)) {
                            break;
                        }
                        i2 = (i2 * 10) + i3;
                    } else {
                        numValueOf = Integer.valueOf(i2);
                    }
                }
                numValueOf = null;
            }
            if (numValueOf == null) {
                return null;
            }
            return new C0378a(functionClassKindByClassNamePrefix, numValueOf.intValue());
        }
    }

    static {
        FunctionClassKind functionClassKind = new FunctionClassKind("Function", 0, StandardNames.l, "Function");
        k = functionClassKind;
        FunctionClassKind functionClassKind2 = new FunctionClassKind("SuspendFunction", 1, StandardNames.d, "SuspendFunction");
        l = functionClassKind2;
        FqName fqName = StandardNames.i;
        FunctionClassKind functionClassKind3 = new FunctionClassKind("KFunction", 2, fqName, "KFunction");
        m = functionClassKind3;
        FunctionClassKind functionClassKind4 = new FunctionClassKind("KSuspendFunction", 3, fqName, "KSuspendFunction");
        n = functionClassKind4;
        o = new FunctionClassKind[]{functionClassKind, functionClassKind2, functionClassKind3, functionClassKind4};
        j = new a(null);
    }

    public FunctionClassKind(String str, int i, FqName fqName, String str2) {
        super(str, i);
        this.packageFqName = fqName;
        this.classNamePrefix = str2;
    }

    public static FunctionClassKind valueOf(String str) {
        Intrinsics3.checkNotNullParameter(str, "value");
        return (FunctionClassKind) Enum.valueOf(FunctionClassKind.class, str);
    }

    public static FunctionClassKind[] values() {
        FunctionClassKind[] functionClassKindArr = o;
        FunctionClassKind[] functionClassKindArr2 = new FunctionClassKind[functionClassKindArr.length];
        System.arraycopy(functionClassKindArr, 0, functionClassKindArr2, 0, functionClassKindArr.length);
        return functionClassKindArr2;
    }

    public final String getClassNamePrefix() {
        return this.classNamePrefix;
    }

    public final FqName getPackageFqName() {
        return this.packageFqName;
    }

    public final Name numberedClassName(int i) {
        Name nameIdentifier = Name.identifier(Intrinsics3.stringPlus(this.classNamePrefix, Integer.valueOf(i)));
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(\"$classNamePrefix$arity\")");
        return nameIdentifier;
    }
}
