package androidx.work.impl.foreground;

import android.app.Notification;
import android.os.Build$VERSION;

/* JADX INFO: loaded from: classes.dex */
public class SystemForegroundService$2 implements Runnable {
    public final /* synthetic */ SystemForegroundService this$0;
    public final /* synthetic */ Notification val$notification;
    public final /* synthetic */ int val$notificationId;
    public final /* synthetic */ int val$notificationType;

    public SystemForegroundService$2(SystemForegroundService systemForegroundService, int i, Notification notification, int i2) {
        this.this$0 = systemForegroundService;
        this.val$notificationId = i;
        this.val$notification = notification;
        this.val$notificationType = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (Build$VERSION.SDK_INT >= 29) {
            this.this$0.startForeground(this.val$notificationId, this.val$notification, this.val$notificationType);
        } else {
            this.this$0.startForeground(this.val$notificationId, this.val$notification);
        }
    }
}
