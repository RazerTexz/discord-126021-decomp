package androidx.constraintlayout.motion.widget;

/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class MotionLayout$2 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState;

    static {
        MotionLayout$TransitionState.values();
        int[] iArr = new int[4];
        $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState = iArr;
        try {
            iArr[MotionLayout$TransitionState.UNDEFINED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[MotionLayout$TransitionState.SETUP.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[MotionLayout$TransitionState.MOVING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[MotionLayout$TransitionState.FINISHED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
