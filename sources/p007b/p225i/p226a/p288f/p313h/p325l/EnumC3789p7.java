package p007b.p225i.p226a.p288f.p313h.p325l;

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
/* JADX INFO: renamed from: b.i.a.f.h.l.p7 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class EnumC3789p7 {

    /* JADX INFO: renamed from: A */
    public static final EnumC3789p7 f10199A;

    /* JADX INFO: renamed from: B */
    public static final /* synthetic */ EnumC3789p7[] f10200B;

    /* JADX INFO: renamed from: j */
    public static final EnumC3789p7 f10201j;

    /* JADX INFO: renamed from: k */
    public static final EnumC3789p7 f10202k;

    /* JADX INFO: renamed from: l */
    public static final EnumC3789p7 f10203l;

    /* JADX INFO: renamed from: m */
    public static final EnumC3789p7 f10204m;

    /* JADX INFO: renamed from: n */
    public static final EnumC3789p7 f10205n;

    /* JADX INFO: renamed from: o */
    public static final EnumC3789p7 f10206o;

    /* JADX INFO: renamed from: p */
    public static final EnumC3789p7 f10207p;

    /* JADX INFO: renamed from: q */
    public static final EnumC3789p7 f10208q;

    /* JADX INFO: renamed from: r */
    public static final EnumC3789p7 f10209r;

    /* JADX INFO: renamed from: s */
    public static final EnumC3789p7 f10210s;

    /* JADX INFO: renamed from: t */
    public static final EnumC3789p7 f10211t;

    /* JADX INFO: renamed from: u */
    public static final EnumC3789p7 f10212u;

    /* JADX INFO: renamed from: v */
    public static final EnumC3789p7 f10213v;

    /* JADX INFO: renamed from: w */
    public static final EnumC3789p7 f10214w;

    /* JADX INFO: renamed from: x */
    public static final EnumC3789p7 f10215x;

    /* JADX INFO: renamed from: y */
    public static final EnumC3789p7 f10216y;

    /* JADX INFO: renamed from: z */
    public static final EnumC3789p7 f10217z;
    private final EnumC3880w7 zzs;
    private final int zzt;

    static {
        EnumC3789p7 enumC3789p7 = new EnumC3789p7("DOUBLE", 0, EnumC3880w7.DOUBLE, 1);
        f10201j = enumC3789p7;
        EnumC3789p7 enumC3789p8 = new EnumC3789p7("FLOAT", 1, EnumC3880w7.FLOAT, 5);
        f10202k = enumC3789p8;
        EnumC3880w7 enumC3880w7 = EnumC3880w7.LONG;
        EnumC3789p7 enumC3789p9 = new EnumC3789p7("INT64", 2, enumC3880w7, 0);
        f10203l = enumC3789p9;
        EnumC3789p7 enumC3789p10 = new EnumC3789p7("UINT64", 3, enumC3880w7, 0);
        f10204m = enumC3789p10;
        EnumC3880w7 enumC3880w8 = EnumC3880w7.INT;
        EnumC3789p7 enumC3789p11 = new EnumC3789p7("INT32", 4, enumC3880w8, 0);
        f10205n = enumC3789p11;
        EnumC3789p7 enumC3789p12 = new EnumC3789p7("FIXED64", 5, enumC3880w7, 1);
        f10206o = enumC3789p12;
        EnumC3789p7 enumC3789p13 = new EnumC3789p7("FIXED32", 6, enumC3880w8, 5);
        f10207p = enumC3789p13;
        EnumC3789p7 enumC3789p14 = new EnumC3789p7("BOOL", 7, EnumC3880w7.BOOLEAN, 0);
        f10208q = enumC3789p14;
        final EnumC3880w7 enumC3880w9 = EnumC3880w7.STRING;
        final String str = "STRING";
        EnumC3789p7 enumC3789p15 = new EnumC3789p7(str, enumC3880w9) { // from class: b.i.a.f.h.l.s7
        };
        f10209r = enumC3789p15;
        final EnumC3880w7 enumC3880w10 = EnumC3880w7.MESSAGE;
        final String str2 = "GROUP";
        EnumC3789p7 enumC3789p16 = new EnumC3789p7(str2, enumC3880w10) { // from class: b.i.a.f.h.l.r7
        };
        f10210s = enumC3789p16;
        final String str3 = "MESSAGE";
        EnumC3789p7 enumC3789p17 = new EnumC3789p7(str3, enumC3880w10) { // from class: b.i.a.f.h.l.u7
        };
        f10211t = enumC3789p17;
        final EnumC3880w7 enumC3880w11 = EnumC3880w7.BYTE_STRING;
        final String str4 = "BYTES";
        EnumC3789p7 enumC3789p18 = new EnumC3789p7(str4, enumC3880w11) { // from class: b.i.a.f.h.l.t7
        };
        f10212u = enumC3789p18;
        EnumC3789p7 enumC3789p19 = new EnumC3789p7("UINT32", 12, enumC3880w8, 0);
        f10213v = enumC3789p19;
        EnumC3789p7 enumC3789p20 = new EnumC3789p7("ENUM", 13, EnumC3880w7.ENUM, 0);
        f10214w = enumC3789p20;
        EnumC3789p7 enumC3789p21 = new EnumC3789p7("SFIXED32", 14, enumC3880w8, 5);
        f10215x = enumC3789p21;
        EnumC3789p7 enumC3789p22 = new EnumC3789p7("SFIXED64", 15, enumC3880w7, 1);
        f10216y = enumC3789p22;
        EnumC3789p7 enumC3789p23 = new EnumC3789p7("SINT32", 16, enumC3880w8, 0);
        f10217z = enumC3789p23;
        EnumC3789p7 enumC3789p24 = new EnumC3789p7("SINT64", 17, enumC3880w7, 0);
        f10199A = enumC3789p24;
        f10200B = new EnumC3789p7[]{enumC3789p7, enumC3789p8, enumC3789p9, enumC3789p10, enumC3789p11, enumC3789p12, enumC3789p13, enumC3789p14, enumC3789p15, enumC3789p16, enumC3789p17, enumC3789p18, enumC3789p19, enumC3789p20, enumC3789p21, enumC3789p22, enumC3789p23, enumC3789p24};
    }

    public EnumC3789p7(String str, int i, EnumC3880w7 enumC3880w7, int i2) {
        super(str, i);
        this.zzs = enumC3880w7;
        this.zzt = i2;
    }

    public static EnumC3789p7[] values() {
        return (EnumC3789p7[]) f10200B.clone();
    }

    /* JADX INFO: renamed from: f */
    public final EnumC3880w7 m5180f() {
        return this.zzs;
    }

    public EnumC3789p7(String str, int i, EnumC3880w7 enumC3880w7, int i2, C3802q7 c3802q7) {
        super(str, i);
        this.zzs = enumC3880w7;
        this.zzt = i2;
    }
}
