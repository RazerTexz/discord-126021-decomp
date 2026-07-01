package androidx.fragment.app;

import android.animation.Animator;
import android.view.animation.Animation;

/* JADX INFO: loaded from: classes.dex */
public class FragmentAnim$AnimationOrAnimator {
    public final Animation animation;
    public final Animator animator;

    public FragmentAnim$AnimationOrAnimator(Animation animation) {
        this.animation = animation;
        this.animator = null;
        if (animation == null) {
            throw new IllegalStateException("Animation cannot be null");
        }
    }

    public FragmentAnim$AnimationOrAnimator(Animator animator) {
        this.animation = null;
        this.animator = animator;
        if (animator == null) {
            throw new IllegalStateException("Animator cannot be null");
        }
    }
}
