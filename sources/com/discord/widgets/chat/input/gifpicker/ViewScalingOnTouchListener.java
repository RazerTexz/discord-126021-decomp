package com.discord.widgets.chat.input.gifpicker;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ViewScalingOnTouchListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewScalingOnTouchListener implements View.OnTouchListener {
    private final float scaledownFactor;

    public ViewScalingOnTouchListener(float f) {
        this.scaledownFactor = f;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent event) {
        C12238m.checkNotNullParameter(view, "view");
        C12238m.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action == 0) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, Key.SCALE_X, this.scaledownFactor);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, Key.SCALE_Y, this.scaledownFactor);
            C12238m.checkNotNullExpressionValue(objectAnimatorOfFloat, "scaleDownX");
            objectAnimatorOfFloat.setDuration(200L);
            C12238m.checkNotNullExpressionValue(objectAnimatorOfFloat2, "scaleDownY");
            objectAnimatorOfFloat2.setDuration(200L);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
            animatorSet.start();
        } else if (action == 1 || action == 3) {
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, Key.SCALE_X, 1.0f);
            ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(view, Key.SCALE_Y, 1.0f);
            C12238m.checkNotNullExpressionValue(objectAnimatorOfFloat3, "scaleUpX");
            objectAnimatorOfFloat3.setDuration(200L);
            C12238m.checkNotNullExpressionValue(objectAnimatorOfFloat4, "scaleUpY");
            objectAnimatorOfFloat4.setDuration(200L);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.play(objectAnimatorOfFloat3).with(objectAnimatorOfFloat4);
            animatorSet2.start();
        }
        return false;
    }
}
