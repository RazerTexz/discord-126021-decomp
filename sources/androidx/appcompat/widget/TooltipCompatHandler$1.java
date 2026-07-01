package androidx.appcompat.widget;

/* JADX INFO: loaded from: classes.dex */
public class TooltipCompatHandler$1 implements Runnable {
    public final /* synthetic */ TooltipCompatHandler this$0;

    public TooltipCompatHandler$1(TooltipCompatHandler tooltipCompatHandler) {
        this.this$0 = tooltipCompatHandler;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.show(false);
    }
}
