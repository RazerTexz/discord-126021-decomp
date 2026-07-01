package com.discord.utilities.accessibility;

import android.app.Application;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AccessibilityMonitor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AccessibilityMonitor$Companion {
    private AccessibilityMonitor$Companion() {
    }

    public final AccessibilityMonitor getINSTANCE() {
        Lazy lazyAccess$getINSTANCE$cp = AccessibilityMonitor.access$getINSTANCE$cp();
        AccessibilityMonitor$Companion accessibilityMonitor$Companion = AccessibilityMonitor.Companion;
        return (AccessibilityMonitor) lazyAccess$getINSTANCE$cp.getValue();
    }

    public final void initialize(Application application) {
        m.checkNotNullParameter(application, "application");
        getINSTANCE().bindContext(application);
    }

    public /* synthetic */ AccessibilityMonitor$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
