package androidx.view;

import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: LifecycleOwner.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LifecycleOwnerKt {
    public static final LifecycleCoroutineScope getLifecycleScope(LifecycleOwner lifecycleOwner) {
        C12238m.checkNotNullParameter(lifecycleOwner, "$this$lifecycleScope");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        C12238m.checkNotNullExpressionValue(lifecycle, "lifecycle");
        return LifecycleKt.getCoroutineScope(lifecycle);
    }
}
