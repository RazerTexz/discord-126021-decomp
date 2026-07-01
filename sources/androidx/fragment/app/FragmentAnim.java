package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources$NotFoundException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.annotation.AnimRes;
import androidx.annotation.NonNull;
import androidx.core.os.CancellationSignal;
import androidx.fragment.R$animator;
import androidx.fragment.R$id;

/* JADX INFO: loaded from: classes.dex */
public class FragmentAnim {
    private FragmentAnim() {
    }

    public static void animateRemoveFragment(@NonNull Fragment fragment, @NonNull FragmentAnim$AnimationOrAnimator fragmentAnim$AnimationOrAnimator, @NonNull FragmentTransition$Callback fragmentTransition$Callback) {
        View view = fragment.mView;
        ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        CancellationSignal cancellationSignal = new CancellationSignal();
        cancellationSignal.setOnCancelListener(new FragmentAnim$1(fragment));
        fragmentTransition$Callback.onStart(fragment, cancellationSignal);
        if (fragmentAnim$AnimationOrAnimator.animation != null) {
            FragmentAnim$EndViewTransitionAnimation fragmentAnim$EndViewTransitionAnimation = new FragmentAnim$EndViewTransitionAnimation(fragmentAnim$AnimationOrAnimator.animation, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            fragmentAnim$EndViewTransitionAnimation.setAnimationListener(new FragmentAnim$2(viewGroup, fragment, fragmentTransition$Callback, cancellationSignal));
            fragment.mView.startAnimation(fragmentAnim$EndViewTransitionAnimation);
            return;
        }
        Animator animator = fragmentAnim$AnimationOrAnimator.animator;
        fragment.setAnimator(animator);
        animator.addListener(new FragmentAnim$3(viewGroup, view, fragment, fragmentTransition$Callback, cancellationSignal));
        animator.setTarget(fragment.mView);
        animator.start();
    }

    public static FragmentAnim$AnimationOrAnimator loadAnimation(@NonNull Context context, @NonNull Fragment fragment, boolean z2) {
        int nextTransition = fragment.getNextTransition();
        int nextAnim = fragment.getNextAnim();
        boolean z3 = false;
        fragment.setNextAnim(0);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            int i = R$id.visible_removing_fragment_view_tag;
            if (viewGroup.getTag(i) != null) {
                fragment.mContainer.setTag(i, null);
            }
        }
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation animationOnCreateAnimation = fragment.onCreateAnimation(nextTransition, z2, nextAnim);
        if (animationOnCreateAnimation != null) {
            return new FragmentAnim$AnimationOrAnimator(animationOnCreateAnimation);
        }
        Animator animatorOnCreateAnimator = fragment.onCreateAnimator(nextTransition, z2, nextAnim);
        if (animatorOnCreateAnimator != null) {
            return new FragmentAnim$AnimationOrAnimator(animatorOnCreateAnimator);
        }
        if (nextAnim == 0 && nextTransition != 0) {
            nextAnim = transitToAnimResourceId(nextTransition, z2);
        }
        if (nextAnim != 0) {
            boolean zEquals = "anim".equals(context.getResources().getResourceTypeName(nextAnim));
            if (zEquals) {
                try {
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, nextAnim);
                    if (animationLoadAnimation != null) {
                        return new FragmentAnim$AnimationOrAnimator(animationLoadAnimation);
                    }
                    z3 = true;
                } catch (Resources$NotFoundException e) {
                    throw e;
                } catch (RuntimeException unused) {
                }
            }
            if (!z3) {
                try {
                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, nextAnim);
                    if (animatorLoadAnimator != null) {
                        return new FragmentAnim$AnimationOrAnimator(animatorLoadAnimator);
                    }
                } catch (RuntimeException e2) {
                    if (zEquals) {
                        throw e2;
                    }
                    Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, nextAnim);
                    if (animationLoadAnimation2 != null) {
                        return new FragmentAnim$AnimationOrAnimator(animationLoadAnimation2);
                    }
                }
            }
        }
        return null;
    }

    @AnimRes
    private static int transitToAnimResourceId(int i, boolean z2) {
        if (i == 4097) {
            return z2 ? R$animator.fragment_open_enter : R$animator.fragment_open_exit;
        }
        if (i == 4099) {
            return z2 ? R$animator.fragment_fade_enter : R$animator.fragment_fade_exit;
        }
        if (i != 8194) {
            return -1;
        }
        return z2 ? R$animator.fragment_close_enter : R$animator.fragment_close_exit;
    }
}
