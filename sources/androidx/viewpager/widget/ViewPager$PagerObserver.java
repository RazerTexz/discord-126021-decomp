package androidx.viewpager.widget;

import android.database.DataSetObserver;

/* JADX INFO: loaded from: classes.dex */
public class ViewPager$PagerObserver extends DataSetObserver {
    public final /* synthetic */ ViewPager this$0;

    public ViewPager$PagerObserver(ViewPager viewPager) {
        this.this$0 = viewPager;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        this.this$0.dataSetChanged();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.this$0.dataSetChanged();
    }
}
