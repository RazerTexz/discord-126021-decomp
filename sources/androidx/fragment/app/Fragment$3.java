package androidx.fragment.app;

/* JADX INFO: loaded from: classes.dex */
public class Fragment$3 implements Runnable {
    public final /* synthetic */ Fragment this$0;
    public final /* synthetic */ SpecialEffectsController val$controller;

    public Fragment$3(Fragment fragment, SpecialEffectsController specialEffectsController) {
        this.this$0 = fragment;
        this.val$controller = specialEffectsController;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.val$controller.executePendingOperations();
    }
}
