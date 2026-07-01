package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager$1 implements Runnable {
    public final /* synthetic */ StaggeredGridLayoutManager this$0;

    public StaggeredGridLayoutManager$1(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.this$0 = staggeredGridLayoutManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.checkForGaps();
    }
}
