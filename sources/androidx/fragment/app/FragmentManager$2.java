package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.core.os.CancellationSignal;

/* JADX INFO: loaded from: classes.dex */
public class FragmentManager$2 implements FragmentTransition$Callback {
    public final /* synthetic */ FragmentManager this$0;

    public FragmentManager$2(FragmentManager fragmentManager) {
        this.this$0 = fragmentManager;
    }

    @Override // androidx.fragment.app.FragmentTransition$Callback
    public void onComplete(@NonNull Fragment fragment, @NonNull CancellationSignal cancellationSignal) {
        if (cancellationSignal.isCanceled()) {
            return;
        }
        this.this$0.removeCancellationSignal(fragment, cancellationSignal);
    }

    @Override // androidx.fragment.app.FragmentTransition$Callback
    public void onStart(@NonNull Fragment fragment, @NonNull CancellationSignal cancellationSignal) {
        this.this$0.addCancellationSignal(fragment, cancellationSignal);
    }
}
