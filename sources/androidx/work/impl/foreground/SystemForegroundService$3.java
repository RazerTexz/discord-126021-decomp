package androidx.work.impl.foreground;

import android.app.Notification;

/* JADX INFO: loaded from: classes.dex */
public class SystemForegroundService$3 implements Runnable {
    public final /* synthetic */ SystemForegroundService this$0;
    public final /* synthetic */ Notification val$notification;
    public final /* synthetic */ int val$notificationId;

    public SystemForegroundService$3(SystemForegroundService systemForegroundService, int i, Notification notification) {
        this.this$0 = systemForegroundService;
        this.val$notificationId = i;
        this.val$notification = notification;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.mNotificationManager.notify(this.val$notificationId, this.val$notification);
    }
}
