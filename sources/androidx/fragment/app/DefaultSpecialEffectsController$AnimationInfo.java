package androidx.fragment.app;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.os.CancellationSignal;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSpecialEffectsController$AnimationInfo extends DefaultSpecialEffectsController$SpecialEffectsInfo {

    @Nullable
    private FragmentAnim$AnimationOrAnimator mAnimation;
    private boolean mLoadedAnim;

    public DefaultSpecialEffectsController$AnimationInfo(@NonNull SpecialEffectsController$Operation specialEffectsController$Operation, @NonNull CancellationSignal cancellationSignal) {
        super(specialEffectsController$Operation, cancellationSignal);
        this.mLoadedAnim = false;
    }

    @Nullable
    public FragmentAnim$AnimationOrAnimator getAnimation(@NonNull Context context) {
        if (this.mLoadedAnim) {
            return this.mAnimation;
        }
        FragmentAnim$AnimationOrAnimator fragmentAnim$AnimationOrAnimatorLoadAnimation = FragmentAnim.loadAnimation(context, getOperation().getFragment(), getOperation().getFinalState() == SpecialEffectsController$Operation$State.VISIBLE);
        this.mAnimation = fragmentAnim$AnimationOrAnimatorLoadAnimation;
        this.mLoadedAnim = true;
        return fragmentAnim$AnimationOrAnimatorLoadAnimation;
    }
}
