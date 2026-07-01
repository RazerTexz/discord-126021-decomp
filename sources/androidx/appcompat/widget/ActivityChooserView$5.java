package androidx.appcompat.widget;

import android.database.DataSetObserver;

/* JADX INFO: loaded from: classes.dex */
public class ActivityChooserView$5 extends DataSetObserver {
    public final /* synthetic */ ActivityChooserView this$0;

    public ActivityChooserView$5(ActivityChooserView activityChooserView) {
        this.this$0 = activityChooserView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        super.onChanged();
        this.this$0.updateAppearance();
    }
}
