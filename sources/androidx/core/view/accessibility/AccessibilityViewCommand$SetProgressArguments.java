package androidx.core.view.accessibility;

/* JADX INFO: loaded from: classes.dex */
public final class AccessibilityViewCommand$SetProgressArguments extends AccessibilityViewCommand$CommandArguments {
    public float getProgress() {
        return this.mBundle.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE);
    }
}
