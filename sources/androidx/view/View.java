package androidx.view;

import d0.z.d.m;

/* JADX INFO: renamed from: androidx.savedstate.ViewKt, reason: from Kotlin metadata */
/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes.dex */
public final class View {
    public static final SavedStateRegistryOwner findViewTreeSavedStateRegistryOwner(android.view.View view) {
        m.checkNotNullParameter(view, "$this$findViewTreeSavedStateRegistryOwner");
        return ViewTreeSavedStateRegistryOwner.get(view);
    }
}
