package androidx.view;

/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class FullLifecycleObserverAdapter$1 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$Event;

    static {
        Lifecycle$Event.values();
        int[] iArr = new int[7];
        $SwitchMap$androidx$lifecycle$Lifecycle$Event = iArr;
        try {
            iArr[Lifecycle$Event.ON_CREATE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle$Event.ON_START.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle$Event.ON_RESUME.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle$Event.ON_PAUSE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle$Event.ON_STOP.ordinal()] = 5;
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
    }
}
