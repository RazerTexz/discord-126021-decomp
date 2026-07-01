package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.core.os.CancellationSignal;

/* JADX INFO: loaded from: classes.dex */
public interface FragmentTransition$Callback {
    void onComplete(@NonNull Fragment fragment, @NonNull CancellationSignal cancellationSignal);

    void onStart(@NonNull Fragment fragment, @NonNull CancellationSignal cancellationSignal);
}
