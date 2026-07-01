package androidx.appcompat.widget;

/* JADX INFO: loaded from: classes.dex */
public class ForwardingListener$TriggerLongPress implements Runnable {
    public final /* synthetic */ ForwardingListener this$0;

    public ForwardingListener$TriggerLongPress(ForwardingListener forwardingListener) {
        this.this$0 = forwardingListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.onLongPress();
    }
}
