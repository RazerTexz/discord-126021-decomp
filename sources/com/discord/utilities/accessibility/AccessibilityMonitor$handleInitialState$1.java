package com.discord.utilities.accessibility;

import android.view.accessibility.AccessibilityManager$AccessibilityStateChangeListener;
import j0.l.e.k;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;

/* JADX INFO: compiled from: AccessibilityMonitor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AccessibilityMonitor$handleInitialState$1 implements AccessibilityManager$AccessibilityStateChangeListener {
    public final /* synthetic */ AccessibilityMonitor this$0;

    public AccessibilityMonitor$handleInitialState$1(AccessibilityMonitor accessibilityMonitor) {
        this.this$0 = accessibilityMonitor;
    }

    @Override // android.view.accessibility.AccessibilityManager$AccessibilityStateChangeListener
    public final void onAccessibilityStateChanged(boolean z2) {
        new k(Unit.a).q(200L, TimeUnit.MILLISECONDS).V(new AccessibilityMonitor$handleInitialState$1$1(this, z2));
    }
}
