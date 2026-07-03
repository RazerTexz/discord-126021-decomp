package p507d0.p513e0.p514p.p515d.p517m0.p518b.p519p;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11291k;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.C12238m;

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
/* JADX INFO: renamed from: d0.e0.p.d.m0.b.p.c */
/* JADX INFO: compiled from: FunctionClassKind.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class EnumC11298c {

    /* JADX INFO: renamed from: j */
    public static final a f22601j;

    /* JADX INFO: renamed from: k */
    public static final EnumC11298c f22602k;

    /* JADX INFO: renamed from: l */
    public static final EnumC11298c f22603l;

    /* JADX INFO: renamed from: m */
    public static final EnumC11298c f22604m;

    /* JADX INFO: renamed from: n */
    public static final EnumC11298c f22605n;

    /* JADX INFO: renamed from: o */
    public static final /* synthetic */ EnumC11298c[] f22606o;
    private final String classNamePrefix;
    private final C11713b packageFqName;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.p.c$a */
    /* JADX INFO: compiled from: FunctionClassKind.kt */
    public static final class a {

        /* JADX INFO: renamed from: d0.e0.p.d.m0.b.p.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: FunctionClassKind.kt */
        public static final class C13305a {

            /* JADX INFO: renamed from: a */
            public final EnumC11298c f22607a;

            /* JADX INFO: renamed from: b */
            public final int f22608b;

            public C13305a(EnumC11298c enumC11298c, int i) {
                C12238m.checkNotNullParameter(enumC11298c, "kind");
                this.f22607a = enumC11298c;
                this.f22608b = i;
            }

            public final EnumC11298c component1() {
                return this.f22607a;
            }

            public final int component2() {
                return this.f22608b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C13305a)) {
                    return false;
                }
                C13305a c13305a = (C13305a) obj;
                return this.f22607a == c13305a.f22607a && this.f22608b == c13305a.f22608b;
            }

            public final EnumC11298c getKind() {
                return this.f22607a;
            }

            public int hashCode() {
                return (this.f22607a.hashCode() * 31) + this.f22608b;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("KindWithArity(kind=");
                sbM833U.append(this.f22607a);
                sbM833U.append(", arity=");
                return C1643a.m813A(sbM833U, this.f22608b, ')');
            }
        }

        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final EnumC11298c byClassNamePrefix(C11713b c11713b, String str) {
            C12238m.checkNotNullParameter(c11713b, "packageFqName");
            C12238m.checkNotNullParameter(str, "className");
            EnumC11298c[] enumC11298cArrValues = EnumC11298c.values();
            for (int i = 0; i < 4; i++) {
                EnumC11298c enumC11298c = enumC11298cArrValues[i];
                if (C12238m.areEqual(enumC11298c.getPackageFqName(), c11713b) && C12103t.startsWith$default(str, enumC11298c.getClassNamePrefix(), false, 2, null)) {
                    return enumC11298c;
                }
            }
            return null;
        }

        public final EnumC11298c getFunctionalClassKind(String str, C11713b c11713b) {
            C12238m.checkNotNullParameter(str, "className");
            C12238m.checkNotNullParameter(c11713b, "packageFqName");
            C13305a className = parseClassName(str, c11713b);
            if (className == null) {
                return null;
            }
            return className.getKind();
        }

        public final C13305a parseClassName(String str, C11713b c11713b) {
            Integer numValueOf;
            C12238m.checkNotNullParameter(str, "className");
            C12238m.checkNotNullParameter(c11713b, "packageFqName");
            EnumC11298c enumC11298cByClassNamePrefix = byClassNamePrefix(c11713b, str);
            if (enumC11298cByClassNamePrefix == null) {
                return null;
            }
            String strSubstring = str.substring(enumC11298cByClassNamePrefix.getClassNamePrefix().length());
            C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
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
            return new C13305a(enumC11298cByClassNamePrefix, numValueOf.intValue());
        }
    }

    static {
        EnumC11298c enumC11298c = new EnumC11298c("Function", 0, C11291k.f22499l, "Function");
        f22602k = enumC11298c;
        EnumC11298c enumC11298c2 = new EnumC11298c("SuspendFunction", 1, C11291k.f22491d, "SuspendFunction");
        f22603l = enumC11298c2;
        C11713b c11713b = C11291k.f22496i;
        EnumC11298c enumC11298c3 = new EnumC11298c("KFunction", 2, c11713b, "KFunction");
        f22604m = enumC11298c3;
        EnumC11298c enumC11298c4 = new EnumC11298c("KSuspendFunction", 3, c11713b, "KSuspendFunction");
        f22605n = enumC11298c4;
        f22606o = new EnumC11298c[]{enumC11298c, enumC11298c2, enumC11298c3, enumC11298c4};
        f22601j = new a(null);
    }

    public EnumC11298c(String str, int i, C11713b c11713b, String str2) {
        super(str, i);
        this.packageFqName = c11713b;
        this.classNamePrefix = str2;
    }

    public static EnumC11298c valueOf(String str) {
        C12238m.checkNotNullParameter(str, "value");
        return (EnumC11298c) Enum.valueOf(EnumC11298c.class, str);
    }

    public static EnumC11298c[] values() {
        EnumC11298c[] enumC11298cArr = f22606o;
        EnumC11298c[] enumC11298cArr2 = new EnumC11298c[enumC11298cArr.length];
        System.arraycopy(enumC11298cArr, 0, enumC11298cArr2, 0, enumC11298cArr.length);
        return enumC11298cArr2;
    }

    public final String getClassNamePrefix() {
        return this.classNamePrefix;
    }

    public final C11713b getPackageFqName() {
        return this.packageFqName;
    }

    public final C11716e numberedClassName(int i) {
        C11716e c11716eIdentifier = C11716e.identifier(C12238m.stringPlus(this.classNamePrefix, Integer.valueOf(i)));
        C12238m.checkNotNullExpressionValue(c11716eIdentifier, "identifier(\"$classNamePrefix$arity\")");
        return c11716eIdentifier;
    }
}
