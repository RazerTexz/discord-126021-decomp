package androidx.core.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.view.View;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener$1 implements ValueAnimator$AnimatorUpdateListener {
    public final /* synthetic */ WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener this$0;
    public final /* synthetic */ WindowInsetsAnimationCompat val$anim;
    public final /* synthetic */ int val$animationMask;
    public final /* synthetic */ WindowInsetsCompat val$startingInsets;
    public final /* synthetic */ WindowInsetsCompat val$targetInsets;
    public final /* synthetic */ View val$v;

    public WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener$1(WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener windowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener, WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2, int i, View view) {
        this.this$0 = windowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener;
        this.val$anim = windowInsetsAnimationCompat;
        this.val$targetInsets = windowInsetsCompat;
        this.val$startingInsets = windowInsetsCompat2;
        this.val$animationMask = i;
        this.val$v = view;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.val$anim.setFraction(valueAnimator.getAnimatedFraction());
        WindowInsetsAnimationCompat$Impl21.dispatchOnProgress(this.val$v, WindowInsetsAnimationCompat$Impl21.interpolateInsets(this.val$targetInsets, this.val$startingInsets, this.val$anim.getInterpolatedFraction(), this.val$animationMask), Collections.singletonList(this.val$anim));
    }
}
