package androidx.work.impl.foreground;

/* JADX INFO: loaded from: classes.dex */
public class SystemForegroundService$1 implements Runnable {
    public final /* synthetic */ SystemForegroundService this$0;

    public SystemForegroundService$1(SystemForegroundService systemForegroundService) {
        this.this$0 = systemForegroundService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.mDispatcher.handleStop();
    }
}
