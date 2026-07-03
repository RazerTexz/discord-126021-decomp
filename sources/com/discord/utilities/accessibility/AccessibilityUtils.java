package com.discord.utilities.accessibility;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.StringRes;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.discord.stores.StoreStream;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: AccessibilityUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AccessibilityUtils {
    public static final AccessibilityUtils INSTANCE = new AccessibilityUtils();

    private AccessibilityUtils() {
    }

    public final boolean isReducedMotionEnabled() {
        return StoreStream.INSTANCE.getAccessibility().getReducedMotionEnabled();
    }

    public final void sendAnnouncement(Context context, @StringRes int message) {
        C12238m.checkNotNullParameter(context, "context");
        String string = context.getString(message);
        C12238m.checkNotNullExpressionValue(string, "context.getString(message)");
        sendAnnouncement(context, string);
    }

    public final void setViewIsHeading(View view) {
        C12238m.checkNotNullParameter(view, "view");
        ViewCompat.setAccessibilityDelegate(view, new AccessibilityDelegateCompat() { // from class: com.discord.utilities.accessibility.AccessibilityUtils.setViewIsHeading.1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
                C12238m.checkNotNullParameter(host, "host");
                C12238m.checkNotNullParameter(info, "info");
                super.onInitializeAccessibilityNodeInfo(host, info);
                info.setHeading(true);
            }
        });
    }

    public final void sendAnnouncement(Context context, String message) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(message, "message");
        Object systemService = context.getSystemService("accessibility");
        if (!(systemService instanceof AccessibilityManager)) {
            systemService = null;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) systemService;
        if (accessibilityManager != null) {
            AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
            C12238m.checkNotNullExpressionValue(accessibilityEventObtain, "event");
            accessibilityEventObtain.setEventType(16384);
            accessibilityEventObtain.getText().add(message);
            try {
                accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain);
            } catch (IllegalStateException unused) {
            }
        }
    }
}
