package p007b.p452o.p453a.p466q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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
/* JADX INFO: renamed from: b.o.a.q.b */
/* JADX INFO: compiled from: GestureAction.java */
/* JADX INFO: loaded from: classes3.dex */
public final class EnumC5194b {

    /* JADX INFO: renamed from: j */
    public static final EnumC5194b f14072j;

    /* JADX INFO: renamed from: k */
    public static final EnumC5194b f14073k;

    /* JADX INFO: renamed from: l */
    public static final EnumC5194b f14074l;

    /* JADX INFO: renamed from: m */
    public static final EnumC5194b f14075m;

    /* JADX INFO: renamed from: n */
    public static final EnumC5194b f14076n;

    /* JADX INFO: renamed from: o */
    public static final EnumC5194b f14077o;

    /* JADX INFO: renamed from: p */
    public static final EnumC5194b f14078p;

    /* JADX INFO: renamed from: q */
    public static final EnumC5194b f14079q;

    /* JADX INFO: renamed from: r */
    public static final /* synthetic */ EnumC5194b[] f14080r;
    private EnumC5196d type;
    private int value;

    static {
        EnumC5196d enumC5196d = EnumC5196d.ONE_SHOT;
        EnumC5194b enumC5194b = new EnumC5194b("NONE", 0, 0, enumC5196d);
        f14072j = enumC5194b;
        EnumC5194b enumC5194b2 = new EnumC5194b("AUTO_FOCUS", 1, 1, enumC5196d);
        f14073k = enumC5194b2;
        EnumC5194b enumC5194b3 = new EnumC5194b("TAKE_PICTURE", 2, 2, enumC5196d);
        f14074l = enumC5194b3;
        EnumC5194b enumC5194b4 = new EnumC5194b("TAKE_PICTURE_SNAPSHOT", 3, 3, enumC5196d);
        f14075m = enumC5194b4;
        EnumC5196d enumC5196d2 = EnumC5196d.CONTINUOUS;
        EnumC5194b enumC5194b5 = new EnumC5194b("ZOOM", 4, 4, enumC5196d2);
        f14076n = enumC5194b5;
        EnumC5194b enumC5194b6 = new EnumC5194b("EXPOSURE_CORRECTION", 5, 5, enumC5196d2);
        f14077o = enumC5194b6;
        EnumC5194b enumC5194b7 = new EnumC5194b("FILTER_CONTROL_1", 6, 6, enumC5196d2);
        f14078p = enumC5194b7;
        EnumC5194b enumC5194b8 = new EnumC5194b("FILTER_CONTROL_2", 7, 7, enumC5196d2);
        f14079q = enumC5194b8;
        f14080r = new EnumC5194b[]{enumC5194b, enumC5194b2, enumC5194b3, enumC5194b4, enumC5194b5, enumC5194b6, enumC5194b7, enumC5194b8};
    }

    public EnumC5194b(String str, @NonNull int i, int i2, EnumC5196d enumC5196d) {
        super(str, i);
        this.value = i2;
        this.type = enumC5196d;
    }

    @Nullable
    /* JADX INFO: renamed from: f */
    public static EnumC5194b m7389f(int i) {
        EnumC5194b[] enumC5194bArrValues = values();
        for (int i2 = 0; i2 < 8; i2++) {
            EnumC5194b enumC5194b = enumC5194bArrValues[i2];
            if (enumC5194b.value == i) {
                return enumC5194b;
            }
        }
        return null;
    }

    public static EnumC5194b valueOf(String str) {
        return (EnumC5194b) Enum.valueOf(EnumC5194b.class, str);
    }

    public static EnumC5194b[] values() {
        return (EnumC5194b[]) f14080r.clone();
    }

    @NonNull
    /* JADX INFO: renamed from: g */
    public EnumC5196d m7390g() {
        return this.type;
    }

    /* JADX INFO: renamed from: h */
    public int m7391h() {
        return this.value;
    }
}
