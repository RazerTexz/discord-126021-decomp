package androidx.loader.content;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public final class Loader$ForceLoadContentObserver extends ContentObserver {
    public final /* synthetic */ Loader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Loader$ForceLoadContentObserver(Loader loader) {
        super(new Handler());
        this.this$0 = loader;
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
