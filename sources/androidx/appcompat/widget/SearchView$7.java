package androidx.appcompat.widget;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView$OnEditorActionListener;

/* JADX INFO: loaded from: classes.dex */
public class SearchView$7 implements TextView$OnEditorActionListener {
    public final /* synthetic */ SearchView this$0;

    public SearchView$7(SearchView searchView) {
        this.this$0 = searchView;
    }

    @Override // android.widget.TextView$OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        this.this$0.onSubmitQuery();
        return true;
    }
}
