package androidx.appcompat.widget;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: loaded from: classes.dex */
public class SearchView$5 implements View$OnClickListener {
    public final /* synthetic */ SearchView this$0;

    public SearchView$5(SearchView searchView) {
        this.this$0 = searchView;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        SearchView searchView = this.this$0;
        if (view == searchView.mSearchButton) {
            searchView.onSearchClicked();
            return;
        }
        if (view == searchView.mCloseButton) {
            searchView.onCloseClicked();
            return;
        }
        if (view == searchView.mGoButton) {
            searchView.onSubmitQuery();
        } else if (view == searchView.mVoiceButton) {
            searchView.onVoiceClicked();
        } else if (view == searchView.mSearchSrcTextView) {
            searchView.forceSuggestionQuery();
        }
    }
}
