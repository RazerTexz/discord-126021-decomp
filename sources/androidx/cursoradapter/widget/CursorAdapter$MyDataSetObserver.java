package androidx.cursoradapter.widget;

import android.database.DataSetObserver;

/* JADX INFO: loaded from: classes.dex */
public class CursorAdapter$MyDataSetObserver extends DataSetObserver {
    public final /* synthetic */ CursorAdapter this$0;

    public CursorAdapter$MyDataSetObserver(CursorAdapter cursorAdapter) {
        this.this$0 = cursorAdapter;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        CursorAdapter cursorAdapter = this.this$0;
        cursorAdapter.mDataValid = true;
        cursorAdapter.notifyDataSetChanged();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        CursorAdapter cursorAdapter = this.this$0;
        cursorAdapter.mDataValid = false;
        cursorAdapter.notifyDataSetInvalidated();
    }
}
