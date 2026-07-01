package androidx.fragment.app;

import androidx.view.Lifecycle$State;

/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class FragmentStateManager$2 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$State;

    static {
        Lifecycle$State.values();
        int[] iArr = new int[5];
        $SwitchMap$androidx$lifecycle$Lifecycle$State = iArr;
        try {
            iArr[Lifecycle$State.RESUMED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle$State.STARTED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle$State.CREATED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle$State.INITIALIZED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
