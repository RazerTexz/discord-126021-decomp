package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemSelectedListener;

/* JADX INFO: loaded from: classes.dex */
public class SearchView$9 implements AdapterView$OnItemSelectedListener {
    public final /* synthetic */ SearchView this$0;

    public SearchView$9(SearchView searchView) {
        this.this$0 = searchView;
    }

    @Override // android.widget.AdapterView$OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.this$0.onItemSelected(i);
    }

    @Override // android.widget.AdapterView$OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
