package androidx.view;

import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: androidx.lifecycle.LifecycleOwnerKt, reason: use source file name */
/* JADX INFO: compiled from: LifecycleOwner.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LifecycleOwner2 {
    public static final Lifecycle2 getLifecycleScope(LifecycleOwner lifecycleOwner) {
        Intrinsics3.checkNotNullParameter(lifecycleOwner, "$this$lifecycleScope");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics3.checkNotNullExpressionValue(lifecycle, "lifecycle");
        return Lifecycle4.getCoroutineScope(lifecycle);
    }
}
