package androidx.appcompat.widget;

import android.database.DataSetObserver;

/* JADX INFO: loaded from: classes.dex */
public class ActivityChooserView$1 extends DataSetObserver {
    public final /* synthetic */ ActivityChooserView this$0;

    public ActivityChooserView$1(ActivityChooserView activityChooserView) {
        this.this$0 = activityChooserView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        super.onChanged();
        this.this$0.mAdapter.notifyDataSetChanged();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        super.onInvalidated();
        this.this$0.mAdapter.notifyDataSetInvalidated();
    }
}
