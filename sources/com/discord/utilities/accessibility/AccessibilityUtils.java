package com.discord.utilities.accessibility;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.StringRes;
import androidx.core.view.ViewCompat;
import com.discord.stores.StoreStream;
import d0.z.d.m;

/* JADX INFO: compiled from: AccessibilityUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AccessibilityUtils {
    public static final AccessibilityUtils INSTANCE = new AccessibilityUtils();

    private AccessibilityUtils() {
    }

    public final boolean isReducedMotionEnabled() {
        return StoreStream.Companion.getAccessibility().getReducedMotionEnabled();
    }

    public final void sendAnnouncement(Context context, @StringRes int message) {
        m.checkNotNullParameter(context, "context");
        String string = context.getString(message);
        m.checkNotNullExpressionValue(string, "context.getString(message)");
        sendAnnouncement(context, string);
    }

    public final void setViewIsHeading(View view) {
        m.checkNotNullParameter(view, "view");
        ViewCompat.setAccessibilityDelegate(view, new AccessibilityUtils$setViewIsHeading$1());
    }

    public final void sendAnnouncement(Context context, String message) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(message, "message");
        Object systemService = context.getSystemService("accessibility");
        if (!(systemService instanceof AccessibilityManager)) {
            systemService = null;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) systemService;
        if (accessibilityManager != null) {
            AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
            m.checkNotNullExpressionValue(accessibilityEventObtain, "event");
            accessibilityEventObtain.setEventType(16384);
            accessibilityEventObtain.getText().add(message);
            try {
                accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain);
            } catch (IllegalStateException unused) {
            }
        }
    }
}
