package androidx.fragment.app;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSpecialEffectsController$1 implements Runnable {
    public final /* synthetic */ DefaultSpecialEffectsController this$0;
    public final /* synthetic */ List val$awaitingContainerChanges;
    public final /* synthetic */ SpecialEffectsController$Operation val$operation;

    public DefaultSpecialEffectsController$1(DefaultSpecialEffectsController defaultSpecialEffectsController, List list, SpecialEffectsController$Operation specialEffectsController$Operation) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$awaitingContainerChanges = list;
        this.val$operation = specialEffectsController$Operation;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.val$awaitingContainerChanges.contains(this.val$operation)) {
            this.val$awaitingContainerChanges.remove(this.val$operation);
            this.this$0.applyContainerChanges(this.val$operation);
        }
    }
}
