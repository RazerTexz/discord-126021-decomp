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
/* JADX INFO: renamed from: d0.e0.p.d.m0.b.m */
/* JADX INFO: compiled from: UnsignedType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class EnumC11293m {

    /* JADX INFO: renamed from: j */
    public static final EnumC11293m f22574j;

    /* JADX INFO: renamed from: k */
    public static final EnumC11293m f22575k;

    /* JADX INFO: renamed from: l */
    public static final EnumC11293m f22576l;

    /* JADX INFO: renamed from: m */
    public static final EnumC11293m f22577m;

    /* JADX INFO: renamed from: n */
    public static final /* synthetic */ EnumC11293m[] f22578n;
    private final C11712a classId;
    private final C11716e typeName;

    static {
        C11712a c11712aFromString = C11712a.fromString("kotlin/UByteArray");
        C12238m.checkNotNullExpressionValue(c11712aFromString, "fromString(\"kotlin/UByteArray\")");
        EnumC11293m enumC11293m = new EnumC11293m("UBYTEARRAY", 0, c11712aFromString);
        f22574j = enumC11293m;
        C11712a c11712aFromString2 = C11712a.fromString("kotlin/UShortArray");
        C12238m.checkNotNullExpressionValue(c11712aFromString2, "fromString(\"kotlin/UShortArray\")");
        EnumC11293m enumC11293m2 = new EnumC11293m("USHORTARRAY", 1, c11712aFromString2);
        f22575k = enumC11293m2;
        C11712a c11712aFromString3 = C11712a.fromString("kotlin/UIntArray");
        C12238m.checkNotNullExpressionValue(c11712aFromString3, "fromString(\"kotlin/UIntArray\")");
        EnumC11293m enumC11293m3 = new EnumC11293m("UINTARRAY", 2, c11712aFromString3);
        f22576l = enumC11293m3;
        C11712a c11712aFromString4 = C11712a.fromString("kotlin/ULongArray");
        C12238m.checkNotNullExpressionValue(c11712aFromString4, "fromString(\"kotlin/ULongArray\")");
        EnumC11293m enumC11293m4 = new EnumC11293m("ULONGARRAY", 3, c11712aFromString4);
        f22577m = enumC11293m4;
        f22578n = new EnumC11293m[]{enumC11293m, enumC11293m2, enumC11293m3, enumC11293m4};
    }

    public EnumC11293m(String str, int i, C11712a c11712a) {
        super(str, i);
        this.classId = c11712a;
        C11716e shortClassName = c11712a.getShortClassName();
        C12238m.checkNotNullExpressionValue(shortClassName, "classId.shortClassName");
        this.typeName = shortClassName;
    }

    public static EnumC11293m valueOf(String str) {
        C12238m.checkNotNullParameter(str, "value");
        return (EnumC11293m) Enum.valueOf(EnumC11293m.class, str);
    }

    public static EnumC11293m[] values() {
        EnumC11293m[] enumC11293mArr = f22578n;
        EnumC11293m[] enumC11293mArr2 = new EnumC11293m[enumC11293mArr.length];
        System.arraycopy(enumC11293mArr, 0, enumC11293mArr2, 0, enumC11293mArr.length);
        return enumC11293mArr2;
    }

    public final C11716e getTypeName() {
        return this.typeName;
    }
}
