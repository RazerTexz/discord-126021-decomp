package androidx.core.view;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener$3 implements Runnable {
    public final /* synthetic */ WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener this$0;
    public final /* synthetic */ WindowInsetsAnimationCompat val$anim;
    public final /* synthetic */ WindowInsetsAnimationCompat$BoundsCompat val$animationBounds;
    public final /* synthetic */ ValueAnimator val$animator;
    public final /* synthetic */ View val$v;

    public WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener$3(WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener windowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener, View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsAnimationCompat$BoundsCompat windowInsetsAnimationCompat$BoundsCompat, ValueAnimator valueAnimator) {
        this.this$0 = windowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener;
        this.val$v = view;
        this.val$anim = windowInsetsAnimationCompat;
        this.val$animationBounds = windowInsetsAnimationCompat$BoundsCompat;
        this.val$animator = valueAnimator;
    }

    @Override // java.lang.Runnable
    public void run() {
        WindowInsetsAnimationCompat$Impl21.dispatchOnStart(this.val$v, this.val$anim, this.val$animationBounds);
        this.val$animator.start();
    }
}
