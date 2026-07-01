package com.discord.utilities.accessibility;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;

/* JADX INFO: compiled from: AccessibilityMonitor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AccessibilityMonitor$animationScaleObserver$1 extends ContentObserver {
    public final /* synthetic */ AccessibilityMonitor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccessibilityMonitor$animationScaleObserver$1(AccessibilityMonitor accessibilityMonitor, Handler handler) {
        super(handler);
        this.this$0 = accessibilityMonitor;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean selfChange) {
        onChange(selfChange, null);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean selfChange, Uri uri) {
        AccessibilityMonitor.access$handleReduceMotionUpdated(this.this$0);
    }
}
