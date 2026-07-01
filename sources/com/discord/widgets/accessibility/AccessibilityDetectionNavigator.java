package com.discord.widgets.accessibility;

import android.content.Context;
import com.discord.app.AppComponent;
import com.discord.stores.StoreNotices$Notice;
import com.discord.stores.StoreStream;
import com.discord.utilities.accessibility.AccessibilityFeatureFlags;
import com.discord.utilities.accessibility.AccessibilityMonitor;
import com.discord.utilities.accessibility.AccessibilityState;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AccessibilityDetectionNavigator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AccessibilityDetectionNavigator {
    public static final AccessibilityDetectionNavigator INSTANCE = new AccessibilityDetectionNavigator();

    private AccessibilityDetectionNavigator() {
    }

    public static final /* synthetic */ void access$showAccessibilityDetectionDialog(AccessibilityDetectionNavigator accessibilityDetectionNavigator, AccessibilityState accessibilityState) {
        accessibilityDetectionNavigator.showAccessibilityDetectionDialog(accessibilityState);
    }

    private final void showAccessibilityDetectionDialog(AccessibilityState accessibilityState) {
        if (accessibilityState.getFeatures().contains(AccessibilityFeatureFlags.SCREENREADER)) {
            StoreStream.Companion.getNotices().requestToShow(new StoreNotices$Notice("ALLOW_ACCESSIBILITY_DETECTION_DIALOG", null, 0L, 0, true, null, 0L, false, 0L, AccessibilityDetectionNavigator$showAccessibilityDetectionDialog$1.INSTANCE, 486, null));
        }
    }

    public final void enqueueNoticeWhenEnabled(AppComponent appComponent) {
        m.checkNotNullParameter(appComponent, "appComponent");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(AccessibilityMonitor.Companion.getINSTANCE().observeAccessibilityState(), appComponent, null, 2, null), AccessibilityDetectionNavigator.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AccessibilityDetectionNavigator$enqueueNoticeWhenEnabled$1(this), 62, (Object) null);
    }
}
