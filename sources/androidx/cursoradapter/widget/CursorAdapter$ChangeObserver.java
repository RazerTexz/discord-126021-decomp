package androidx.cursoradapter.widget;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public class CursorAdapter$ChangeObserver extends ContentObserver {
    public final /* synthetic */ CursorAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CursorAdapter$ChangeObserver(CursorAdapter cursorAdapter) {
        super(new Handler());
        this.this$0 = cursorAdapter;
    }

    @Override // android.database.ContentObserver
    public boolean deliverSelfNotifications() {
        return true;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z2) {
        this.this$0.onContentChanged();
    }
}
