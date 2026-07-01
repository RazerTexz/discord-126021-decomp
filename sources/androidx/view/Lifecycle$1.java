package androidx.view;

/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class Lifecycle$1 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$Event;
    public static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$State;

    static {
        Lifecycle$Event.values();
        int[] iArr = new int[7];
        $SwitchMap$androidx$lifecycle$Lifecycle$Event = iArr;
        try {
            iArr[Lifecycle$Event.ON_CREATE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle$Event.ON_STOP.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle$Event.ON_START.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle$Event.ON_PAUSE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle$Event.ON_RESUME.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle$Event.ON_DESTROY.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle$Event.ON_ANY.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        Lifecycle$State.values();
        int[] iArr2 = new int[5];
        $SwitchMap$androidx$lifecycle$Lifecycle$State = iArr2;
        try {
            iArr2[Lifecycle$State.CREATED.ordinal()] = 1;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle$State.STARTED.ordinal()] = 2;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle$State.RESUMED.ordinal()] = 3;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle$State.DESTROYED.ordinal()] = 4;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle$State.INITIALIZED.ordinal()] = 5;
        } catch (NoSuchFieldError unused12) {
        }
    }
}
