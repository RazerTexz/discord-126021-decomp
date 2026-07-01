package androidx.fragment.app;

/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class DefaultSpecialEffectsController$10 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;

    static {
        SpecialEffectsController$Operation$State.values();
        int[] iArr = new int[4];
        $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = iArr;
        try {
            iArr[SpecialEffectsController$Operation$State.GONE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController$Operation$State.INVISIBLE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController$Operation$State.REMOVED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController$Operation$State.VISIBLE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
