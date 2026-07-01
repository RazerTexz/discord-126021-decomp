package androidx.appcompat.widget;

import android.view.KeyEvent;
import android.view.View;
import android.view.View$OnKeyListener;

/* JADX INFO: loaded from: classes.dex */
public class SearchView$6 implements View$OnKeyListener {
    public final /* synthetic */ SearchView this$0;

    public SearchView$6(SearchView searchView) {
        this.this$0 = searchView;
    }

    @Override // android.view.View$OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        SearchView searchView = this.this$0;
        if (searchView.mSearchable == null) {
            return false;
        }
        if (searchView.mSearchSrcTextView.isPopupShowing() && this.this$0.mSearchSrcTextView.getListSelection() != -1) {
            return this.this$0.onSuggestionsKey(view, i, keyEvent);
        }
        if (this.this$0.mSearchSrcTextView.isEmpty() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i != 66) {
            return false;
        }
        view.cancelLongPress();
        SearchView searchView2 = this.this$0;
        searchView2.launchQuerySearch(0, null, searchView2.mSearchSrcTextView.getText().toString());
        return true;
    }
}
