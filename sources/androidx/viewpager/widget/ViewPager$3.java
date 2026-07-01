package androidx.viewpager.widget;

/* JADX INFO: loaded from: classes.dex */
public class ViewPager$3 implements Runnable {
    public final /* synthetic */ ViewPager this$0;

    public ViewPager$3(ViewPager viewPager) {
        this.this$0 = viewPager;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.setScrollState(0);
        this.this$0.populate();
    }
}
