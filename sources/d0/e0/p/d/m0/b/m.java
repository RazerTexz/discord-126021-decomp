package d0.e0.p.d.m0.b;

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
/* JADX INFO: compiled from: UnsignedType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public static final m j;
    public static final m k;
    public static final m l;
    public static final m m;
    public static final /* synthetic */ m[] n;
    private final d0.e0.p.d.m0.g.a classId;
    private final d0.e0.p.d.m0.g.e typeName;

    static {
        d0.e0.p.d.m0.g.a aVarFromString = d0.e0.p.d.m0.g.a.fromString("kotlin/UByteArray");
        d0.z.d.m.checkNotNullExpressionValue(aVarFromString, "fromString(\"kotlin/UByteArray\")");
        m mVar = new m("UBYTEARRAY", 0, aVarFromString);
        j = mVar;
        d0.e0.p.d.m0.g.a aVarFromString2 = d0.e0.p.d.m0.g.a.fromString("kotlin/UShortArray");
        d0.z.d.m.checkNotNullExpressionValue(aVarFromString2, "fromString(\"kotlin/UShortArray\")");
        m mVar2 = new m("USHORTARRAY", 1, aVarFromString2);
        k = mVar2;
        d0.e0.p.d.m0.g.a aVarFromString3 = d0.e0.p.d.m0.g.a.fromString("kotlin/UIntArray");
        d0.z.d.m.checkNotNullExpressionValue(aVarFromString3, "fromString(\"kotlin/UIntArray\")");
        m mVar3 = new m("UINTARRAY", 2, aVarFromString3);
        l = mVar3;
        d0.e0.p.d.m0.g.a aVarFromString4 = d0.e0.p.d.m0.g.a.fromString("kotlin/ULongArray");
        d0.z.d.m.checkNotNullExpressionValue(aVarFromString4, "fromString(\"kotlin/ULongArray\")");
        m mVar4 = new m("ULONGARRAY", 3, aVarFromString4);
        m = mVar4;
        n = new m[]{mVar, mVar2, mVar3, mVar4};
    }

    public m(String str, int i, d0.e0.p.d.m0.g.a aVar) {
        super(str, i);
        this.classId = aVar;
        d0.e0.p.d.m0.g.e shortClassName = aVar.getShortClassName();
        d0.z.d.m.checkNotNullExpressionValue(shortClassName, "classId.shortClassName");
        this.typeName = shortClassName;
    }

    public static m valueOf(String str) {
        d0.z.d.m.checkNotNullParameter(str, "value");
        return (m) Enum.valueOf(m.class, str);
    }

    public static m[] values() {
        m[] mVarArr = n;
        m[] mVarArr2 = new m[mVarArr.length];
        System.arraycopy(mVarArr, 0, mVarArr2, 0, mVarArr.length);
        return mVarArr2;
    }

    public final d0.e0.p.d.m0.g.e getTypeName() {
        return this.typeName;
    }
}
