package p007b.p452o.p453a.p466q;

import androidx.annotation.NonNull;

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
/* JADX INFO: renamed from: b.o.a.q.a */
/* JADX INFO: compiled from: Gesture.java */
/* JADX INFO: loaded from: classes3.dex */
public final class EnumC5193a {

    /* JADX INFO: renamed from: j */
    public static final EnumC5193a f14066j;

    /* JADX INFO: renamed from: k */
    public static final EnumC5193a f14067k;

    /* JADX INFO: renamed from: l */
    public static final EnumC5193a f14068l;

    /* JADX INFO: renamed from: m */
    public static final EnumC5193a f14069m;

    /* JADX INFO: renamed from: n */
    public static final EnumC5193a f14070n;

    /* JADX INFO: renamed from: o */
    public static final /* synthetic */ EnumC5193a[] f14071o;
    private EnumC5196d type;

    static {
        EnumC5196d enumC5196d = EnumC5196d.CONTINUOUS;
        EnumC5193a enumC5193a = new EnumC5193a("PINCH", 0, enumC5196d);
        f14066j = enumC5193a;
        EnumC5196d enumC5196d2 = EnumC5196d.ONE_SHOT;
        EnumC5193a enumC5193a2 = new EnumC5193a("TAP", 1, enumC5196d2);
        f14067k = enumC5193a2;
        EnumC5193a enumC5193a3 = new EnumC5193a("LONG_TAP", 2, enumC5196d2);
        f14068l = enumC5193a3;
        EnumC5193a enumC5193a4 = new EnumC5193a("SCROLL_HORIZONTAL", 3, enumC5196d);
        f14069m = enumC5193a4;
        EnumC5193a enumC5193a5 = new EnumC5193a("SCROLL_VERTICAL", 4, enumC5196d);
        f14070n = enumC5193a5;
        f14071o = new EnumC5193a[]{enumC5193a, enumC5193a2, enumC5193a3, enumC5193a4, enumC5193a5};
    }

    public EnumC5193a(@NonNull String str, int i, EnumC5196d enumC5196d) {
        super(str, i);
        this.type = enumC5196d;
    }

    public static EnumC5193a valueOf(String str) {
        return (EnumC5193a) Enum.valueOf(EnumC5193a.class, str);
    }

    public static EnumC5193a[] values() {
        return (EnumC5193a[]) f14071o.clone();
    }

    /* JADX INFO: renamed from: f */
    public boolean m7388f(@NonNull EnumC5194b enumC5194b) {
        return enumC5194b == EnumC5194b.f14072j || enumC5194b.m7390g() == this.type;
    }
}
