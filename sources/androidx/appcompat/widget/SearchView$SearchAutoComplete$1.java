package androidx.appcompat.widget;

/* JADX INFO: loaded from: classes.dex */
public class SearchView$SearchAutoComplete$1 implements Runnable {
    public final /* synthetic */ SearchView$SearchAutoComplete this$0;

    public SearchView$SearchAutoComplete$1(SearchView$SearchAutoComplete searchView$SearchAutoComplete) {
        this.this$0 = searchView$SearchAutoComplete;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.showSoftInputIfNecessary();
    }
}
