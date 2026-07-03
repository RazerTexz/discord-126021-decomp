package androidx.view;

import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: androidx.savedstate.ViewKt, reason: from Kotlin metadata */
/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes.dex */
public final class View {
    public static final SavedStateRegistryOwner findViewTreeSavedStateRegistryOwner(android.view.View view) {
        C12238m.checkNotNullParameter(view, "$this$findViewTreeSavedStateRegistryOwner");
        return ViewTreeSavedStateRegistryOwner.get(view);
    }
}
