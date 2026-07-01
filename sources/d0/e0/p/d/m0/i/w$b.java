package d0.e0.p.d.m0.i;

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
/* JADX INFO: compiled from: WireFormat.java */
/* JADX INFO: loaded from: classes3.dex */
public class w$b {
    public static final w$b A;
    public static final /* synthetic */ w$b[] B;
    public static final w$b j;
    public static final w$b k;
    public static final w$b l;
    public static final w$b m;
    public static final w$b n;
    public static final w$b o;
    public static final w$b p;
    public static final w$b q;
    public static final w$b r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final w$b f3434s;
    public static final w$b t;
    public static final w$b u;
    public static final w$b v;
    public static final w$b w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final w$b f3435x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final w$b f3436y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final w$b f3437z;
    private final w$c javaType;
    private final int wireType;

    static {
        w$b w_b = new w$b("DOUBLE", 0, w$c.DOUBLE, 1);
        j = w_b;
        w$b w_b2 = new w$b("FLOAT", 1, w$c.FLOAT, 5);
        k = w_b2;
        w$c w_c = w$c.LONG;
        w$b w_b3 = new w$b("INT64", 2, w_c, 0);
        l = w_b3;
        w$b w_b4 = new w$b("UINT64", 3, w_c, 0);
        m = w_b4;
        w$c w_c2 = w$c.INT;
        w$b w_b5 = new w$b("INT32", 4, w_c2, 0);
        n = w_b5;
        w$b w_b6 = new w$b("FIXED64", 5, w_c, 1);
        o = w_b6;
        w$b w_b7 = new w$b("FIXED32", 6, w_c2, 5);
        p = w_b7;
        w$b w_b8 = new w$b("BOOL", 7, w$c.BOOLEAN, 0);
        q = w_b8;
        w$b$a w_b_a = new w$b$a("STRING", 8, w$c.STRING, 2);
        r = w_b_a;
        w$c w_c3 = w$c.MESSAGE;
        w$b$b w_b_b = new w$b$b("GROUP", 9, w_c3, 3);
        f3434s = w_b_b;
        w$b$c w_b_c = new w$b$c("MESSAGE", 10, w_c3, 2);
        t = w_b_c;
        w$b$d w_b_d = new w$b$d("BYTES", 11, w$c.BYTE_STRING, 2);
        u = w_b_d;
        w$b w_b9 = new w$b("UINT32", 12, w_c2, 0);
        v = w_b9;
        w$b w_b10 = new w$b("ENUM", 13, w$c.ENUM, 0);
        w = w_b10;
        w$b w_b11 = new w$b("SFIXED32", 14, w_c2, 5);
        f3435x = w_b11;
        w$b w_b12 = new w$b("SFIXED64", 15, w_c, 1);
        f3436y = w_b12;
        w$b w_b13 = new w$b("SINT32", 16, w_c2, 0);
        f3437z = w_b13;
        w$b w_b14 = new w$b("SINT64", 17, w_c, 0);
        A = w_b14;
        B = new w$b[]{w_b, w_b2, w_b3, w_b4, w_b5, w_b6, w_b7, w_b8, w_b_a, w_b_b, w_b_c, w_b_d, w_b9, w_b10, w_b11, w_b12, w_b13, w_b14};
    }

    public w$b(String str, int i, w$c w_c, int i2) {
        super(str, i);
        this.javaType = w_c;
        this.wireType = i2;
    }

    public static w$b valueOf(String str) {
        return (w$b) Enum.valueOf(w$b.class, str);
    }

    public static w$b[] values() {
        return (w$b[]) B.clone();
    }

    public w$c getJavaType() {
        return this.javaType;
    }

    public int getWireType() {
        return this.wireType;
    }

    public boolean isPackable() {
        return true;
    }

    public w$b(String str, int i, w$c w_c, int i2, w$a w_a) {
        super(str, i);
        this.javaType = w_c;
        this.wireType = i2;
    }
}
