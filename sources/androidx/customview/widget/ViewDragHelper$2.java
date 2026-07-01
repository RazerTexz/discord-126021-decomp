package androidx.customview.widget;

/* JADX INFO: loaded from: classes.dex */
public class ViewDragHelper$2 implements Runnable {
    public final /* synthetic */ ViewDragHelper this$0;

    public ViewDragHelper$2(ViewDragHelper viewDragHelper) {
        this.this$0 = viewDragHelper;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.setDragState(0);
    }
}
