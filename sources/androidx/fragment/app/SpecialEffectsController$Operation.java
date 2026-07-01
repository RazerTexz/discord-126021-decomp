package androidx.fragment.app;

import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.core.os.CancellationSignal;
import b.d.b.a.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SpecialEffectsController$Operation {

    @NonNull
    private SpecialEffectsController$Operation$State mFinalState;

    @NonNull
    private final Fragment mFragment;

    @NonNull
    private SpecialEffectsController$Operation$LifecycleImpact mLifecycleImpact;

    @NonNull
    private final List<Runnable> mCompletionListeners = new ArrayList();

    @NonNull
    private final HashSet<CancellationSignal> mSpecialEffectsSignals = new HashSet<>();
    private boolean mIsCanceled = false;
    private boolean mIsComplete = false;

    public SpecialEffectsController$Operation(@NonNull SpecialEffectsController$Operation$State specialEffectsController$Operation$State, @NonNull SpecialEffectsController$Operation$LifecycleImpact specialEffectsController$Operation$LifecycleImpact, @NonNull Fragment fragment, @NonNull CancellationSignal cancellationSignal) {
        this.mFinalState = specialEffectsController$Operation$State;
        this.mLifecycleImpact = specialEffectsController$Operation$LifecycleImpact;
        this.mFragment = fragment;
        cancellationSignal.setOnCancelListener(new SpecialEffectsController$Operation$1(this));
    }

    public final void addCompletionListener(@NonNull Runnable runnable) {
        this.mCompletionListeners.add(runnable);
    }

    public final void cancel() {
        if (isCanceled()) {
            return;
        }
        this.mIsCanceled = true;
        if (this.mSpecialEffectsSignals.isEmpty()) {
            complete();
            return;
        }
        Iterator it = new ArrayList(this.mSpecialEffectsSignals).iterator();
        while (it.hasNext()) {
            ((CancellationSignal) it.next()).cancel();
        }
    }

    @CallSuper
    public void complete() {
        if (this.mIsComplete) {
            return;
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "SpecialEffectsController: " + this + " has called complete.");
        }
        this.mIsComplete = true;
        Iterator<Runnable> it = this.mCompletionListeners.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
    }

    public final void completeSpecialEffect(@NonNull CancellationSignal cancellationSignal) {
        if (this.mSpecialEffectsSignals.remove(cancellationSignal) && this.mSpecialEffectsSignals.isEmpty()) {
            complete();
        }
    }

    @NonNull
    public SpecialEffectsController$Operation$State getFinalState() {
        return this.mFinalState;
    }

    @NonNull
    public final Fragment getFragment() {
        return this.mFragment;
    }

    @NonNull
    public SpecialEffectsController$Operation$LifecycleImpact getLifecycleImpact() {
        return this.mLifecycleImpact;
    }

    public final boolean isCanceled() {
        return this.mIsCanceled;
    }

    public final boolean isComplete() {
        return this.mIsComplete;
    }

    public final void markStartedSpecialEffect(@NonNull CancellationSignal cancellationSignal) {
        onStart();
        this.mSpecialEffectsSignals.add(cancellationSignal);
    }

    public final void mergeWith(@NonNull SpecialEffectsController$Operation$State specialEffectsController$Operation$State, @NonNull SpecialEffectsController$Operation$LifecycleImpact specialEffectsController$Operation$LifecycleImpact) {
        int iOrdinal = specialEffectsController$Operation$LifecycleImpact.ordinal();
        if (iOrdinal == 0) {
            if (this.mFinalState != SpecialEffectsController$Operation$State.REMOVED) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    StringBuilder sbU = a.U("SpecialEffectsController: For fragment ");
                    sbU.append(this.mFragment);
                    sbU.append(" mFinalState = ");
                    sbU.append(this.mFinalState);
                    sbU.append(" -> ");
                    sbU.append(specialEffectsController$Operation$State);
                    sbU.append(". ");
                    Log.v(FragmentManager.TAG, sbU.toString());
                }
                this.mFinalState = specialEffectsController$Operation$State;
                return;
            }
            return;
        }
        if (iOrdinal == 1) {
            if (this.mFinalState == SpecialEffectsController$Operation$State.REMOVED) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    StringBuilder sbU2 = a.U("SpecialEffectsController: For fragment ");
                    sbU2.append(this.mFragment);
                    sbU2.append(" mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = ");
                    sbU2.append(this.mLifecycleImpact);
                    sbU2.append(" to ADDING.");
                    Log.v(FragmentManager.TAG, sbU2.toString());
                }
                this.mFinalState = SpecialEffectsController$Operation$State.VISIBLE;
                this.mLifecycleImpact = SpecialEffectsController$Operation$LifecycleImpact.ADDING;
                return;
            }
            return;
        }
        if (iOrdinal != 2) {
            return;
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder sbU3 = a.U("SpecialEffectsController: For fragment ");
            sbU3.append(this.mFragment);
            sbU3.append(" mFinalState = ");
            sbU3.append(this.mFinalState);
            sbU3.append(" -> REMOVED. mLifecycleImpact  = ");
            sbU3.append(this.mLifecycleImpact);
            sbU3.append(" to REMOVING.");
            Log.v(FragmentManager.TAG, sbU3.toString());
        }
        this.mFinalState = SpecialEffectsController$Operation$State.REMOVED;
        this.mLifecycleImpact = SpecialEffectsController$Operation$LifecycleImpact.REMOVING;
    }

    public void onStart() {
    }

    @NonNull
    public String toString() {
        StringBuilder sbX = a.X("Operation ", "{");
        sbX.append(Integer.toHexString(System.identityHashCode(this)));
        sbX.append("} ");
        sbX.append("{");
        sbX.append("mFinalState = ");
        sbX.append(this.mFinalState);
        sbX.append("} ");
        sbX.append("{");
        sbX.append("mLifecycleImpact = ");
        sbX.append(this.mLifecycleImpact);
        sbX.append("} ");
        sbX.append("{");
        sbX.append("mFragment = ");
        sbX.append(this.mFragment);
        sbX.append("}");
        return sbX.toString();
    }
}
