package androidx.core.view.accessibility;

/* JADX INFO: loaded from: classes.dex */
public final class AccessibilityViewCommand$SetTextArguments extends AccessibilityViewCommand$CommandArguments {
    public CharSequence getText() {
        return this.mBundle.getCharSequence(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE);
    }
}
