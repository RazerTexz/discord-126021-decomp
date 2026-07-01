package androidx.fragment.app;

import androidx.core.os.CancellationSignal;

/* JADX INFO: loaded from: classes.dex */
public class FragmentTransition$3 implements Runnable {
    public final /* synthetic */ FragmentTransition$Callback val$callback;
    public final /* synthetic */ Fragment val$outFragment;
    public final /* synthetic */ CancellationSignal val$signal;

    public FragmentTransition$3(FragmentTransition$Callback fragmentTransition$Callback, Fragment fragment, CancellationSignal cancellationSignal) {
        this.val$callback = fragmentTransition$Callback;
        this.val$outFragment = fragment;
        this.val$signal = cancellationSignal;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.val$callback.onComplete(this.val$outFragment, this.val$signal);
    }
}
