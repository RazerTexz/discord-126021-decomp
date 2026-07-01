package androidx.fragment.app;

import androidx.core.os.CancellationSignal$OnCancelListener;

/* JADX INFO: loaded from: classes.dex */
public class SpecialEffectsController$Operation$1 implements CancellationSignal$OnCancelListener {
    public final /* synthetic */ SpecialEffectsController$Operation this$0;

    public SpecialEffectsController$Operation$1(SpecialEffectsController$Operation specialEffectsController$Operation) {
        this.this$0 = specialEffectsController$Operation;
    }

    @Override // androidx.core.os.CancellationSignal$OnCancelListener
    public void onCancel() {
        this.this$0.cancel();
    }
}
