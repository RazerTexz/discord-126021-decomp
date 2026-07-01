package androidx.fragment.app;

/* JADX INFO: loaded from: classes.dex */
public class SpecialEffectsController$2 implements Runnable {
    public final /* synthetic */ SpecialEffectsController this$0;
    public final /* synthetic */ SpecialEffectsController$FragmentStateManagerOperation val$operation;

    public SpecialEffectsController$2(SpecialEffectsController specialEffectsController, SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation) {
        this.this$0 = specialEffectsController;
        this.val$operation = specialEffectsController$FragmentStateManagerOperation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.mPendingOperations.remove(this.val$operation);
        this.this$0.mRunningOperations.remove(this.val$operation);
    }
}
