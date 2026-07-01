package androidx.appcompat.widget;

/* JADX INFO: loaded from: classes.dex */
public class SearchView$1 implements Runnable {
    public final /* synthetic */ SearchView this$0;

    public SearchView$1(SearchView searchView) {
        this.this$0 = searchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.updateFocusedState();
    }
}
