package b.o.a.q;

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
/* JADX INFO: renamed from: b.o.a.q.b, reason: use source file name */
/* JADX INFO: compiled from: GestureAction.java */
/* JADX INFO: loaded from: classes3.dex */
public final class GestureAction {
    public static final GestureAction j;
    public static final GestureAction k;
    public static final GestureAction l;
    public static final GestureAction m;
    public static final GestureAction n;
    public static final GestureAction o;
    public static final GestureAction p;
    public static final GestureAction q;
    public static final /* synthetic */ GestureAction[] r;
    private GestureType type;
    private int value;

    static {
        GestureType gestureType = GestureType.ONE_SHOT;
        GestureAction gestureAction = new GestureAction("NONE", 0, 0, gestureType);
        j = gestureAction;
        GestureAction gestureAction2 = new GestureAction("AUTO_FOCUS", 1, 1, gestureType);
        k = gestureAction2;
        GestureAction gestureAction3 = new GestureAction("TAKE_PICTURE", 2, 2, gestureType);
        l = gestureAction3;
        GestureAction gestureAction4 = new GestureAction("TAKE_PICTURE_SNAPSHOT", 3, 3, gestureType);
        m = gestureAction4;
        GestureType gestureType2 = GestureType.CONTINUOUS;
        GestureAction gestureAction5 = new GestureAction("ZOOM", 4, 4, gestureType2);
        n = gestureAction5;
        GestureAction gestureAction6 = new GestureAction("EXPOSURE_CORRECTION", 5, 5, gestureType2);
        o = gestureAction6;
        GestureAction gestureAction7 = new GestureAction("FILTER_CONTROL_1", 6, 6, gestureType2);
        p = gestureAction7;
        GestureAction gestureAction8 = new GestureAction("FILTER_CONTROL_2", 7, 7, gestureType2);
        q = gestureAction8;
        r = new GestureAction[]{gestureAction, gestureAction2, gestureAction3, gestureAction4, gestureAction5, gestureAction6, gestureAction7, gestureAction8};
    }

    public GestureAction(String str, @NonNull int i, int i2, GestureType gestureType) {
        super(str, i);
        this.value = i2;
        this.type = gestureType;
    }

    @Nullable
    public static GestureAction f(int i) {
        GestureAction[] gestureActionArrValues = values();
        for (int i2 = 0; i2 < 8; i2++) {
            GestureAction gestureAction = gestureActionArrValues[i2];
            if (gestureAction.value == i) {
                return gestureAction;
            }
        }
        return null;
    }

    public static GestureAction valueOf(String str) {
        return (GestureAction) Enum.valueOf(GestureAction.class, str);
    }

    public static GestureAction[] values() {
        return (GestureAction[]) r.clone();
    }

    @NonNull
    public GestureType g() {
        return this.type;
    }

    public int h() {
        return this.value;
    }
}
