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
public final class n {
    public static final n j;
    public static final n k;
    public static final n l;
    public static final n m;
    public static final /* synthetic */ n[] n;
    private final d0.e0.p.d.m0.g.a arrayClassId;
    private final d0.e0.p.d.m0.g.a classId;
    private final d0.e0.p.d.m0.g.e typeName;

    static {
        d0.e0.p.d.m0.g.a aVarFromString = d0.e0.p.d.m0.g.a.fromString("kotlin/UByte");
        d0.z.d.m.checkNotNullExpressionValue(aVarFromString, "fromString(\"kotlin/UByte\")");
        n nVar = new n("UBYTE", 0, aVarFromString);
        j = nVar;
        d0.e0.p.d.m0.g.a aVarFromString2 = d0.e0.p.d.m0.g.a.fromString("kotlin/UShort");
        d0.z.d.m.checkNotNullExpressionValue(aVarFromString2, "fromString(\"kotlin/UShort\")");
        n nVar2 = new n("USHORT", 1, aVarFromString2);
        k = nVar2;
        d0.e0.p.d.m0.g.a aVarFromString3 = d0.e0.p.d.m0.g.a.fromString("kotlin/UInt");
        d0.z.d.m.checkNotNullExpressionValue(aVarFromString3, "fromString(\"kotlin/UInt\")");
        n nVar3 = new n("UINT", 2, aVarFromString3);
        l = nVar3;
        d0.e0.p.d.m0.g.a aVarFromString4 = d0.e0.p.d.m0.g.a.fromString("kotlin/ULong");
        d0.z.d.m.checkNotNullExpressionValue(aVarFromString4, "fromString(\"kotlin/ULong\")");
        n nVar4 = new n("ULONG", 3, aVarFromString4);
        m = nVar4;
        n = new n[]{nVar, nVar2, nVar3, nVar4};
    }

    public n(String str, int i, d0.e0.p.d.m0.g.a aVar) {
        super(str, i);
        this.classId = aVar;
        d0.e0.p.d.m0.g.e shortClassName = aVar.getShortClassName();
        d0.z.d.m.checkNotNullExpressionValue(shortClassName, "classId.shortClassName");
        this.typeName = shortClassName;
        this.arrayClassId = new d0.e0.p.d.m0.g.a(aVar.getPackageFqName(), d0.e0.p.d.m0.g.e.identifier(d0.z.d.m.stringPlus(shortClassName.asString(), "Array")));
    }

    public static n valueOf(String str) {
        d0.z.d.m.checkNotNullParameter(str, "value");
        return (n) Enum.valueOf(n.class, str);
    }

    public static n[] values() {
        n[] nVarArr = n;
        n[] nVarArr2 = new n[nVarArr.length];
        System.arraycopy(nVarArr, 0, nVarArr2, 0, nVarArr.length);
        return nVarArr2;
    }

    public final d0.e0.p.d.m0.g.a getArrayClassId() {
        return this.arrayClassId;
    }

    public final d0.e0.p.d.m0.g.a getClassId() {
        return this.classId;
    }

    public final d0.e0.p.d.m0.g.e getTypeName() {
        return this.typeName;
    }
}
