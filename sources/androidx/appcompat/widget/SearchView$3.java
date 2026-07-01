package androidx.appcompat.widget;

import android.view.View;
import android.view.View$OnFocusChangeListener;

/* JADX INFO: loaded from: classes.dex */
public class SearchView$3 implements View$OnFocusChangeListener {
    public final /* synthetic */ SearchView this$0;

    public SearchView$3(SearchView searchView) {
        this.this$0 = searchView;
    }

    @Override // android.view.View$OnFocusChangeListener
    public void onFocusChange(View view, boolean z2) {
        SearchView searchView = this.this$0;
        View$OnFocusChangeListener view$OnFocusChangeListener = searchView.mOnQueryTextFocusChangeListener;
        if (view$OnFocusChangeListener != null) {
            view$OnFocusChangeListener.onFocusChange(searchView, z2);
        }
    }
}
