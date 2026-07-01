package androidx.appcompat.widget;

import androidx.cursoradapter.widget.CursorAdapter;

/* JADX INFO: loaded from: classes.dex */
public class SearchView$2 implements Runnable {
    public final /* synthetic */ SearchView this$0;

    public SearchView$2(SearchView searchView) {
        this.this$0 = searchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        CursorAdapter cursorAdapter = this.this$0.mSuggestionsAdapter;
        if (cursorAdapter instanceof SuggestionsAdapter) {
            cursorAdapter.changeCursor(null);
        }
    }
}
