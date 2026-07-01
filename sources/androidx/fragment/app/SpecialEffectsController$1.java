package androidx.fragment.app;

/* JADX INFO: loaded from: classes.dex */
public class SpecialEffectsController$1 implements Runnable {
    public final /* synthetic */ SpecialEffectsController this$0;
    public final /* synthetic */ SpecialEffectsController$FragmentStateManagerOperation val$operation;

    public SpecialEffectsController$1(SpecialEffectsController specialEffectsController, SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation) {
        this.this$0 = specialEffectsController;
        this.val$operation = specialEffectsController$FragmentStateManagerOperation;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.this$0.mPendingOperations.contains(this.val$operation)) {
            this.val$operation.getFinalState().applyState(this.val$operation.getFragment().mView);
        }
    }
}
