package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemClickListener;

/* JADX INFO: loaded from: classes.dex */
public class SearchView$8 implements AdapterView$OnItemClickListener {
    public final /* synthetic */ SearchView this$0;

    public SearchView$8(SearchView searchView) {
        this.this$0 = searchView;
    }

    @Override // android.widget.AdapterView$OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.this$0.onItemClicked(i, 0, null);
    }
}
