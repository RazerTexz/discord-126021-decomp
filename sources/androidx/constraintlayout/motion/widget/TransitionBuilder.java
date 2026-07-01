package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.widget.ConstraintSet;

/* JADX INFO: loaded from: classes.dex */
public class TransitionBuilder {
    private static final String TAG = "TransitionBuilder";

    public static MotionScene$Transition buildTransition(MotionScene motionScene, int i, int i2, ConstraintSet constraintSet, int i3, ConstraintSet constraintSet2) {
        MotionScene$Transition motionScene$Transition = new MotionScene$Transition(i, motionScene, i2, i3);
        updateConstraintSetInMotionScene(motionScene, motionScene$Transition, constraintSet, constraintSet2);
        return motionScene$Transition;
    }

    private static void updateConstraintSetInMotionScene(MotionScene motionScene, MotionScene$Transition motionScene$Transition, ConstraintSet constraintSet, ConstraintSet constraintSet2) {
        int startConstraintSetId = motionScene$Transition.getStartConstraintSetId();
        int endConstraintSetId = motionScene$Transition.getEndConstraintSetId();
        motionScene.setConstraintSet(startConstraintSetId, constraintSet);
        motionScene.setConstraintSet(endConstraintSetId, constraintSet2);
    }

    public static void validate(MotionLayout motionLayout) {
        MotionScene motionScene = motionLayout.mScene;
        if (motionScene == null) {
            throw new RuntimeException("Invalid motion layout. Layout missing Motion Scene.");
        }
        if (!motionScene.validateLayout(motionLayout)) {
            throw new RuntimeException("MotionLayout doesn't have the right motion scene.");
        }
        if (motionScene.mCurrentTransition == null || motionScene.getDefinedTransitions().isEmpty()) {
            throw new RuntimeException("Invalid motion layout. Motion Scene doesn't have any transition.");
        }
    }
}
