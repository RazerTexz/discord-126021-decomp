package androidx.viewpager2.widget;

/* JADX INFO: loaded from: classes.dex */
public class ViewPager2$PageAwareAccessibilityProvider$3 extends ViewPager2$DataSetChangeObserver {
    public final /* synthetic */ ViewPager2$PageAwareAccessibilityProvider this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPager2$PageAwareAccessibilityProvider$3(ViewPager2$PageAwareAccessibilityProvider viewPager2$PageAwareAccessibilityProvider) {
        super(null);
        this.this$1 = viewPager2$PageAwareAccessibilityProvider;
    }

    @Override // androidx.viewpager2.widget.ViewPager2$DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public void onChanged() {
        this.this$1.updatePageAccessibilityActions();
    }
}
