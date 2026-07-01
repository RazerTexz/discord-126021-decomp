package androidx.fragment.app;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder {

    @NonNull
    public final FragmentManager$FragmentLifecycleCallbacks mCallback;
    public final boolean mRecursive;

    public FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder(@NonNull FragmentManager$FragmentLifecycleCallbacks fragmentManager$FragmentLifecycleCallbacks, boolean z2) {
        this.mCallback = fragmentManager$FragmentLifecycleCallbacks;
        this.mRecursive = z2;
    }
}
