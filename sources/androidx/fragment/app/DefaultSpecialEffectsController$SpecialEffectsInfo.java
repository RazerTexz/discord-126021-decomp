package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.core.os.CancellationSignal;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSpecialEffectsController$SpecialEffectsInfo {

    @NonNull
    private final SpecialEffectsController$Operation mOperation;

    @NonNull
    private final CancellationSignal mSignal;

    public DefaultSpecialEffectsController$SpecialEffectsInfo(@NonNull SpecialEffectsController$Operation specialEffectsController$Operation, @NonNull CancellationSignal cancellationSignal) {
        this.mOperation = specialEffectsController$Operation;
        this.mSignal = cancellationSignal;
    }

    public void completeSpecialEffect() {
        this.mOperation.completeSpecialEffect(this.mSignal);
    }

    @NonNull
    public SpecialEffectsController$Operation getOperation() {
        return this.mOperation;
    }

    @NonNull
    public CancellationSignal getSignal() {
        return this.mSignal;
    }

    public boolean isVisibilityUnchanged() {
        SpecialEffectsController$Operation$State specialEffectsController$Operation$State;
        SpecialEffectsController$Operation$State specialEffectsController$Operation$StateFrom = SpecialEffectsController$Operation$State.from(this.mOperation.getFragment().mView);
        SpecialEffectsController$Operation$State finalState = this.mOperation.getFinalState();
        return specialEffectsController$Operation$StateFrom == finalState || !(specialEffectsController$Operation$StateFrom == (specialEffectsController$Operation$State = SpecialEffectsController$Operation$State.VISIBLE) || finalState == specialEffectsController$Operation$State);
    }
}
