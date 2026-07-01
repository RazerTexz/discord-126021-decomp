package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityManager$AccessibilityStateChangeListener;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityManagerCompat$AccessibilityStateChangeListenerWrapper implements AccessibilityManager$AccessibilityStateChangeListener {
    public AccessibilityManagerCompat$AccessibilityStateChangeListener mListener;

    public AccessibilityManagerCompat$AccessibilityStateChangeListenerWrapper(@NonNull AccessibilityManagerCompat$AccessibilityStateChangeListener accessibilityManagerCompat$AccessibilityStateChangeListener) {
        this.mListener = accessibilityManagerCompat$AccessibilityStateChangeListener;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AccessibilityManagerCompat$AccessibilityStateChangeListenerWrapper) {
            return this.mListener.equals(((AccessibilityManagerCompat$AccessibilityStateChangeListenerWrapper) obj).mListener);
        }
        return false;
    }

    public int hashCode() {
        return this.mListener.hashCode();
    }

    @Override // android.view.accessibility.AccessibilityManager$AccessibilityStateChangeListener
    public void onAccessibilityStateChanged(boolean z2) {
        this.mListener.onAccessibilityStateChanged(z2);
    }
}
