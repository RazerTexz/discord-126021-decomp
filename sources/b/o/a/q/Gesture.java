package b.o.a.q;

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
/* JADX INFO: renamed from: b.o.a.q.a, reason: use source file name */
/* JADX INFO: compiled from: Gesture.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Gesture {
    public static final Gesture j;
    public static final Gesture k;
    public static final Gesture l;
    public static final Gesture m;
    public static final Gesture n;
    public static final /* synthetic */ Gesture[] o;
    private GestureType type;

    static {
        GestureType gestureType = GestureType.CONTINUOUS;
        Gesture gesture = new Gesture("PINCH", 0, gestureType);
        j = gesture;
        GestureType gestureType2 = GestureType.ONE_SHOT;
        Gesture gesture2 = new Gesture("TAP", 1, gestureType2);
        k = gesture2;
        Gesture gesture3 = new Gesture("LONG_TAP", 2, gestureType2);
        l = gesture3;
        Gesture gesture4 = new Gesture("SCROLL_HORIZONTAL", 3, gestureType);
        m = gesture4;
        Gesture gesture5 = new Gesture("SCROLL_VERTICAL", 4, gestureType);
        n = gesture5;
        o = new Gesture[]{gesture, gesture2, gesture3, gesture4, gesture5};
    }

    public Gesture(@NonNull String str, int i, GestureType gestureType) {
        super(str, i);
        this.type = gestureType;
    }

    public static Gesture valueOf(String str) {
        return (Gesture) Enum.valueOf(Gesture.class, str);
    }

    public static Gesture[] values() {
        return (Gesture[]) o.clone();
    }

    public boolean f(@NonNull GestureAction gestureAction) {
        return gestureAction == GestureAction.j || gestureAction.g() == this.type;
    }
}
