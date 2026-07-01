package d0.e0.p.d.m0.b;

import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.Name;
import d0.z.d.Intrinsics3;

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
/* JADX INFO: renamed from: d0.e0.p.d.m0.b.m, reason: use source file name */
/* JADX INFO: compiled from: UnsignedType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class UnsignedType {
    public static final UnsignedType j;
    public static final UnsignedType k;
    public static final UnsignedType l;
    public static final UnsignedType m;
    public static final /* synthetic */ UnsignedType[] n;
    private final ClassId classId;
    private final Name typeName;

    static {
        ClassId classIdFromString = ClassId.fromString("kotlin/UByteArray");
        Intrinsics3.checkNotNullExpressionValue(classIdFromString, "fromString(\"kotlin/UByteArray\")");
        UnsignedType unsignedType = new UnsignedType("UBYTEARRAY", 0, classIdFromString);
        j = unsignedType;
        ClassId classIdFromString2 = ClassId.fromString("kotlin/UShortArray");
        Intrinsics3.checkNotNullExpressionValue(classIdFromString2, "fromString(\"kotlin/UShortArray\")");
        UnsignedType unsignedType2 = new UnsignedType("USHORTARRAY", 1, classIdFromString2);
        k = unsignedType2;
        ClassId classIdFromString3 = ClassId.fromString("kotlin/UIntArray");
        Intrinsics3.checkNotNullExpressionValue(classIdFromString3, "fromString(\"kotlin/UIntArray\")");
        UnsignedType unsignedType3 = new UnsignedType("UINTARRAY", 2, classIdFromString3);
        l = unsignedType3;
        ClassId classIdFromString4 = ClassId.fromString("kotlin/ULongArray");
        Intrinsics3.checkNotNullExpressionValue(classIdFromString4, "fromString(\"kotlin/ULongArray\")");
        UnsignedType unsignedType4 = new UnsignedType("ULONGARRAY", 3, classIdFromString4);
        m = unsignedType4;
        n = new UnsignedType[]{unsignedType, unsignedType2, unsignedType3, unsignedType4};
    }

    public UnsignedType(String str, int i, ClassId classId) {
        super(str, i);
        this.classId = classId;
        Name shortClassName = classId.getShortClassName();
        Intrinsics3.checkNotNullExpressionValue(shortClassName, "classId.shortClassName");
        this.typeName = shortClassName;
    }

    public static UnsignedType valueOf(String str) {
        Intrinsics3.checkNotNullParameter(str, "value");
        return (UnsignedType) Enum.valueOf(UnsignedType.class, str);
    }

    public static UnsignedType[] values() {
        UnsignedType[] unsignedTypeArr = n;
        UnsignedType[] unsignedTypeArr2 = new UnsignedType[unsignedTypeArr.length];
        System.arraycopy(unsignedTypeArr, 0, unsignedTypeArr2, 0, unsignedTypeArr.length);
        return unsignedTypeArr2;
    }

    public final Name getTypeName() {
        return this.typeName;
    }
}
