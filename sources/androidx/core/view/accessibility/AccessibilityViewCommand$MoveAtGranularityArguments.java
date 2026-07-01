package androidx.core.view.accessibility;

/* JADX INFO: loaded from: classes.dex */
public final class AccessibilityViewCommand$MoveAtGranularityArguments extends AccessibilityViewCommand$CommandArguments {
    public boolean getExtendSelection() {
        return this.mBundle.getBoolean(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN);
    }

    public int getGranularity() {
        return this.mBundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT);
    }
}
