package b.i.a.f.h.l;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'l' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class p7 {
    public static final p7 A;
    public static final /* synthetic */ p7[] B;
    public static final p7 j;
    public static final p7 k;
    public static final p7 l;
    public static final p7 m;
    public static final p7 n;
    public static final p7 o;
    public static final p7 p;
    public static final p7 q;
    public static final p7 r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final p7 f1479s;
    public static final p7 t;
    public static final p7 u;
    public static final p7 v;
    public static final p7 w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final p7 f1480x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final p7 f1481y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final p7 f1482z;
    private final w7 zzs;
    private final int zzt;

    static {
        p7 p7Var = new p7("DOUBLE", 0, w7.DOUBLE, 1);
        j = p7Var;
        p7 p7Var2 = new p7("FLOAT", 1, w7.FLOAT, 5);
        k = p7Var2;
        w7 w7Var = w7.LONG;
        p7 p7Var3 = new p7("INT64", 2, w7Var, 0);
        l = p7Var3;
        p7 p7Var4 = new p7("UINT64", 3, w7Var, 0);
        m = p7Var4;
        w7 w7Var2 = w7.INT;
        p7 p7Var5 = new p7("INT32", 4, w7Var2, 0);
        n = p7Var5;
        p7 p7Var6 = new p7("FIXED64", 5, w7Var, 1);
        o = p7Var6;
        p7 p7Var7 = new p7("FIXED32", 6, w7Var2, 5);
        p = p7Var7;
        p7 p7Var8 = new p7("BOOL", 7, w7.BOOLEAN, 0);
        q = p7Var8;
        final w7 w7Var3 = w7.STRING;
        final String str = "STRING";
        p7 p7Var9 = new p7(str, w7Var3) { // from class: b.i.a.f.h.l.s7
        };
        r = p7Var9;
        final w7 w7Var4 = w7.MESSAGE;
        final String str2 = "GROUP";
        p7 p7Var10 = new p7(str2, w7Var4) { // from class: b.i.a.f.h.l.r7
        };
        f1479s = p7Var10;
        final String str3 = "MESSAGE";
        p7 p7Var11 = new p7(str3, w7Var4) { // from class: b.i.a.f.h.l.u7
        };
        t = p7Var11;
        final w7 w7Var5 = w7.BYTE_STRING;
        final String str4 = "BYTES";
        p7 p7Var12 = new p7(str4, w7Var5) { // from class: b.i.a.f.h.l.t7
        };
        u = p7Var12;
        p7 p7Var13 = new p7("UINT32", 12, w7Var2, 0);
        v = p7Var13;
        p7 p7Var14 = new p7("ENUM", 13, w7.ENUM, 0);
        w = p7Var14;
        p7 p7Var15 = new p7("SFIXED32", 14, w7Var2, 5);
        f1480x = p7Var15;
        p7 p7Var16 = new p7("SFIXED64", 15, w7Var, 1);
        f1481y = p7Var16;
        p7 p7Var17 = new p7("SINT32", 16, w7Var2, 0);
        f1482z = p7Var17;
        p7 p7Var18 = new p7("SINT64", 17, w7Var, 0);
        A = p7Var18;
        B = new p7[]{p7Var, p7Var2, p7Var3, p7Var4, p7Var5, p7Var6, p7Var7, p7Var8, p7Var9, p7Var10, p7Var11, p7Var12, p7Var13, p7Var14, p7Var15, p7Var16, p7Var17, p7Var18};
    }

    public p7(String str, int i, w7 w7Var, int i2) {
        super(str, i);
        this.zzs = w7Var;
        this.zzt = i2;
    }

    public static p7[] values() {
        return (p7[]) B.clone();
    }

    public final w7 f() {
        return this.zzs;
    }

    public p7(String str, int i, w7 w7Var, int i2, q7 q7Var) {
        super(str, i);
        this.zzs = w7Var;
        this.zzt = i2;
    }
}
