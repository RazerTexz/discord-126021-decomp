package androidx.fragment.app;

/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class SpecialEffectsController$3 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact;
    public static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;

    static {
        SpecialEffectsController$Operation$LifecycleImpact.values();
        int[] iArr = new int[3];
        $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact = iArr;
        try {
            iArr[SpecialEffectsController$Operation$LifecycleImpact.ADDING.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact[SpecialEffectsController$Operation$LifecycleImpact.REMOVING.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact[SpecialEffectsController$Operation$LifecycleImpact.NONE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        SpecialEffectsController$Operation$State.values();
        int[] iArr2 = new int[4];
        $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = iArr2;
        try {
            iArr2[SpecialEffectsController$Operation$State.REMOVED.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController$Operation$State.VISIBLE.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController$Operation$State.GONE.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController$Operation$State.INVISIBLE.ordinal()] = 4;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
