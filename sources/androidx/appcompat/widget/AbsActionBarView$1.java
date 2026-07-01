package androidx.appcompat.widget;

/* JADX INFO: loaded from: classes.dex */
public class AbsActionBarView$1 implements Runnable {
    public final /* synthetic */ AbsActionBarView this$0;

    public AbsActionBarView$1(AbsActionBarView absActionBarView) {
        this.this$0 = absActionBarView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.showOverflowMenu();
    }
}
