package p507d0.p513e0.p514p.p515d.p517m0.p518b;

import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p592z.p594d.C12238m;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'j' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: renamed from: d0.e0.p.d.m0.b.n */
/* JADX INFO: compiled from: UnsignedType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class EnumC11294n {

    /* JADX INFO: renamed from: j */
    public static final EnumC11294n f22579j;

    /* JADX INFO: renamed from: k */
    public static final EnumC11294n f22580k;

    /* JADX INFO: renamed from: l */
    public static final EnumC11294n f22581l;

    /* JADX INFO: renamed from: m */
    public static final EnumC11294n f22582m;

    /* JADX INFO: renamed from: n */
    public static final /* synthetic */ EnumC11294n[] f22583n;
    private final C11712a arrayClassId;
    private final C11712a classId;
    private final C11716e typeName;

    static {
        C11712a c11712aFromString = C11712a.fromString("kotlin/UByte");
        C12238m.checkNotNullExpressionValue(c11712aFromString, "fromString(\"kotlin/UByte\")");
        EnumC11294n enumC11294n = new EnumC11294n("UBYTE", 0, c11712aFromString);
        f22579j = enumC11294n;
        C11712a c11712aFromString2 = C11712a.fromString("kotlin/UShort");
        C12238m.checkNotNullExpressionValue(c11712aFromString2, "fromString(\"kotlin/UShort\")");
        EnumC11294n enumC11294n2 = new EnumC11294n("USHORT", 1, c11712aFromString2);
        f22580k = enumC11294n2;
        C11712a c11712aFromString3 = C11712a.fromString("kotlin/UInt");
        C12238m.checkNotNullExpressionValue(c11712aFromString3, "fromString(\"kotlin/UInt\")");
        EnumC11294n enumC11294n3 = new EnumC11294n("UINT", 2, c11712aFromString3);
        f22581l = enumC11294n3;
        C11712a c11712aFromString4 = C11712a.fromString("kotlin/ULong");
        C12238m.checkNotNullExpressionValue(c11712aFromString4, "fromString(\"kotlin/ULong\")");
        EnumC11294n enumC11294n4 = new EnumC11294n("ULONG", 3, c11712aFromString4);
        f22582m = enumC11294n4;
        f22583n = new EnumC11294n[]{enumC11294n, enumC11294n2, enumC11294n3, enumC11294n4};
    }

    public EnumC11294n(String str, int i, C11712a c11712a) {
        super(str, i);
        this.classId = c11712a;
        C11716e shortClassName = c11712a.getShortClassName();
        C12238m.checkNotNullExpressionValue(shortClassName, "classId.shortClassName");
        this.typeName = shortClassName;
        this.arrayClassId = new C11712a(c11712a.getPackageFqName(), C11716e.identifier(C12238m.stringPlus(shortClassName.asString(), "Array")));
    }

    public static EnumC11294n valueOf(String str) {
        C12238m.checkNotNullParameter(str, "value");
        return (EnumC11294n) Enum.valueOf(EnumC11294n.class, str);
    }

    public static EnumC11294n[] values() {
        EnumC11294n[] enumC11294nArr = f22583n;
        EnumC11294n[] enumC11294nArr2 = new EnumC11294n[enumC11294nArr.length];
        System.arraycopy(enumC11294nArr, 0, enumC11294nArr2, 0, enumC11294nArr.length);
        return enumC11294nArr2;
    }

    public final C11712a getArrayClassId() {
        return this.arrayClassId;
    }

    public final C11712a getClassId() {
        return this.classId;
    }

    public final C11716e getTypeName() {
        return this.typeName;
    }
}
