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
/* JADX INFO: renamed from: d0.e0.p.d.m0.b.n, reason: use source file name */
/* JADX INFO: compiled from: UnsignedType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class UnsignedType2 {
    public static final UnsignedType2 j;
    public static final UnsignedType2 k;
    public static final UnsignedType2 l;
    public static final UnsignedType2 m;
    public static final /* synthetic */ UnsignedType2[] n;
    private final ClassId arrayClassId;
    private final ClassId classId;
    private final Name typeName;

    static {
        ClassId classIdFromString = ClassId.fromString("kotlin/UByte");
        Intrinsics3.checkNotNullExpressionValue(classIdFromString, "fromString(\"kotlin/UByte\")");
        UnsignedType2 unsignedType2 = new UnsignedType2("UBYTE", 0, classIdFromString);
        j = unsignedType2;
        ClassId classIdFromString2 = ClassId.fromString("kotlin/UShort");
        Intrinsics3.checkNotNullExpressionValue(classIdFromString2, "fromString(\"kotlin/UShort\")");
        UnsignedType2 unsignedType3 = new UnsignedType2("USHORT", 1, classIdFromString2);
        k = unsignedType3;
        ClassId classIdFromString3 = ClassId.fromString("kotlin/UInt");
        Intrinsics3.checkNotNullExpressionValue(classIdFromString3, "fromString(\"kotlin/UInt\")");
        UnsignedType2 unsignedType4 = new UnsignedType2("UINT", 2, classIdFromString3);
        l = unsignedType4;
        ClassId classIdFromString4 = ClassId.fromString("kotlin/ULong");
        Intrinsics3.checkNotNullExpressionValue(classIdFromString4, "fromString(\"kotlin/ULong\")");
        UnsignedType2 unsignedType5 = new UnsignedType2("ULONG", 3, classIdFromString4);
        m = unsignedType5;
        n = new UnsignedType2[]{unsignedType2, unsignedType3, unsignedType4, unsignedType5};
    }

    public UnsignedType2(String str, int i, ClassId classId) {
        super(str, i);
        this.classId = classId;
        Name shortClassName = classId.getShortClassName();
        Intrinsics3.checkNotNullExpressionValue(shortClassName, "classId.shortClassName");
        this.typeName = shortClassName;
        this.arrayClassId = new ClassId(classId.getPackageFqName(), Name.identifier(Intrinsics3.stringPlus(shortClassName.asString(), "Array")));
    }

    public static UnsignedType2 valueOf(String str) {
        Intrinsics3.checkNotNullParameter(str, "value");
        return (UnsignedType2) Enum.valueOf(UnsignedType2.class, str);
    }

    public static UnsignedType2[] values() {
        UnsignedType2[] unsignedType2Arr = n;
        UnsignedType2[] unsignedType2Arr2 = new UnsignedType2[unsignedType2Arr.length];
        System.arraycopy(unsignedType2Arr, 0, unsignedType2Arr2, 0, unsignedType2Arr.length);
        return unsignedType2Arr2;
    }

    public final ClassId getArrayClassId() {
        return this.arrayClassId;
    }

    public final ClassId getClassId() {
        return this.classId;
    }

    public final Name getTypeName() {
        return this.typeName;
    }
}
