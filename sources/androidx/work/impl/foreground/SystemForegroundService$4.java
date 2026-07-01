package androidx.work.impl.foreground;

/* JADX INFO: loaded from: classes.dex */
public class SystemForegroundService$4 implements Runnable {
    public final /* synthetic */ SystemForegroundService this$0;
    public final /* synthetic */ int val$notificationId;

    public SystemForegroundService$4(SystemForegroundService systemForegroundService, int i) {
        this.this$0 = systemForegroundService;
        this.val$notificationId = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.mNotificationManager.cancel(this.val$notificationId);
    }
}
