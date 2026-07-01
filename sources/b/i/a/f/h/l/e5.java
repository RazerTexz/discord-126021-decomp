package b.i.a.f.h.l;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'k' uses external variables
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
public final class e5 {
    public static final e5 j;
    public static final e5 k;
    public static final e5 l;
    public static final e5 m;
    public static final e5 n;
    public static final e5 o;
    public static final e5 p;
    public static final e5 q;
    public static final e5 r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final e5 f1440s;
    public static final /* synthetic */ e5[] t;
    private final Class<?> zzk;
    private final Class<?> zzl;
    private final Object zzm;

    static {
        e5 e5Var = new e5("VOID", 0, Void.class, Void.class, null);
        j = e5Var;
        Class cls = Integer.TYPE;
        e5 e5Var2 = new e5("INT", 1, cls, Integer.class, 0);
        k = e5Var2;
        e5 e5Var3 = new e5("LONG", 2, Long.TYPE, Long.class, 0L);
        l = e5Var3;
        e5 e5Var4 = new e5("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        m = e5Var4;
        e5 e5Var5 = new e5("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        n = e5Var5;
        e5 e5Var6 = new e5("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        o = e5Var6;
        e5 e5Var7 = new e5("STRING", 6, String.class, String.class, "");
        p = e5Var7;
        e5 e5Var8 = new e5("BYTE_STRING", 7, t3.class, t3.class, t3.j);
        q = e5Var8;
        e5 e5Var9 = new e5("ENUM", 8, cls, Integer.class, null);
        r = e5Var9;
        e5 e5Var10 = new e5("MESSAGE", 9, Object.class, Object.class, null);
        f1440s = e5Var10;
        t = new e5[]{e5Var, e5Var2, e5Var3, e5Var4, e5Var5, e5Var6, e5Var7, e5Var8, e5Var9, e5Var10};
    }

    public e5(String str, int i, Class cls, Class cls2, Object obj) {
        super(str, i);
        this.zzk = cls;
        this.zzl = cls2;
        this.zzm = obj;
    }

    public static e5[] values() {
        return (e5[]) t.clone();
    }

    public final Class<?> f() {
        return this.zzl;
    }
}
