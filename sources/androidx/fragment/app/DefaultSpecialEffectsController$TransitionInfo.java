package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.os.CancellationSignal;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSpecialEffectsController$TransitionInfo extends DefaultSpecialEffectsController$SpecialEffectsInfo {
    private final boolean mOverlapAllowed;

    @Nullable
    private final Object mSharedElementTransition;

    @Nullable
    private final Object mTransition;

    public DefaultSpecialEffectsController$TransitionInfo(@NonNull SpecialEffectsController$Operation specialEffectsController$Operation, @NonNull CancellationSignal cancellationSignal, boolean z2, boolean z3) {
        super(specialEffectsController$Operation, cancellationSignal);
        if (specialEffectsController$Operation.getFinalState() == SpecialEffectsController$Operation$State.VISIBLE) {
            this.mTransition = z2 ? specialEffectsController$Operation.getFragment().getReenterTransition() : specialEffectsController$Operation.getFragment().getEnterTransition();
            this.mOverlapAllowed = z2 ? specialEffectsController$Operation.getFragment().getAllowReturnTransitionOverlap() : specialEffectsController$Operation.getFragment().getAllowEnterTransitionOverlap();
        } else {
            this.mTransition = z2 ? specialEffectsController$Operation.getFragment().getReturnTransition() : specialEffectsController$Operation.getFragment().getExitTransition();
            this.mOverlapAllowed = true;
        }
        if (!z3) {
            this.mSharedElementTransition = null;
        } else if (z2) {
            this.mSharedElementTransition = specialEffectsController$Operation.getFragment().getSharedElementReturnTransition();
        } else {
            this.mSharedElementTransition = specialEffectsController$Operation.getFragment().getSharedElementEnterTransition();
        }
    }

    @Nullable
    public FragmentTransitionImpl getHandlingImpl() {
        FragmentTransitionImpl handlingImpl = getHandlingImpl(this.mTransition);
        FragmentTransitionImpl handlingImpl2 = getHandlingImpl(this.mSharedElementTransition);
        if (handlingImpl == null || handlingImpl2 == null || handlingImpl == handlingImpl2) {
            return handlingImpl != null ? handlingImpl : handlingImpl2;
        }
        StringBuilder sbU = a.U("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
        sbU.append(getOperation().getFragment());
        sbU.append(" returned Transition ");
        sbU.append(this.mTransition);
        sbU.append(" which uses a different Transition  type than its shared element transition ");
        sbU.append(this.mSharedElementTransition);
        throw new IllegalArgumentException(sbU.toString());
    }

    @Nullable
    public Object getSharedElementTransition() {
        return this.mSharedElementTransition;
    }

    @Nullable
    public Object getTransition() {
        return this.mTransition;
    }

    public boolean hasSharedElementTransition() {
        return this.mSharedElementTransition != null;
    }

    public boolean isOverlapAllowed() {
        return this.mOverlapAllowed;
    }

    @Nullable
    private FragmentTransitionImpl getHandlingImpl(Object obj) {
        if (obj == null) {
            return null;
        }
        FragmentTransitionImpl fragmentTransitionImpl = FragmentTransition.PLATFORM_IMPL;
        if (fragmentTransitionImpl != null && fragmentTransitionImpl.canHandle(obj)) {
            return fragmentTransitionImpl;
        }
        FragmentTransitionImpl fragmentTransitionImpl2 = FragmentTransition.SUPPORT_IMPL;
        if (fragmentTransitionImpl2 != null && fragmentTransitionImpl2.canHandle(obj)) {
            return fragmentTransitionImpl2;
        }
        throw new IllegalArgumentException("Transition " + obj + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
    }
}
