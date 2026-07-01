package androidx.recyclerview.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;

/* JADX INFO: loaded from: classes.dex */
public class ItemTouchHelper$RecoverAnimation$1 implements ValueAnimator$AnimatorUpdateListener {
    public final /* synthetic */ ItemTouchHelper$RecoverAnimation this$0;

    public ItemTouchHelper$RecoverAnimation$1(ItemTouchHelper$RecoverAnimation itemTouchHelper$RecoverAnimation) {
        this.this$0 = itemTouchHelper$RecoverAnimation;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.this$0.setFraction(valueAnimator.getAnimatedFraction());
    }
}
