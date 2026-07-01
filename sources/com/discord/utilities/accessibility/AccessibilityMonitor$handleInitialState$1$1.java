package com.discord.utilities.accessibility;

import androidx.core.app.NotificationCompat;
import kotlin.Unit;
import rx.functions.Action1;

/* JADX INFO: compiled from: AccessibilityMonitor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AccessibilityMonitor$handleInitialState$1$1<T> implements Action1<Unit> {
    public final /* synthetic */ boolean $enabled;
    public final /* synthetic */ AccessibilityMonitor$handleInitialState$1 this$0;

    public AccessibilityMonitor$handleInitialState$1$1(AccessibilityMonitor$handleInitialState$1 accessibilityMonitor$handleInitialState$1, boolean z2) {
        this.this$0 = accessibilityMonitor$handleInitialState$1;
        this.$enabled = z2;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Unit unit) {
        call2(unit);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Unit unit) {
        AccessibilityMonitor.access$handleScreenreaderEnabledUpdate(this.this$0.this$0, this.$enabled);
    }
}
