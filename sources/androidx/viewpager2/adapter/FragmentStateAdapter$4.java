package androidx.viewpager2.adapter;

/* JADX INFO: loaded from: classes.dex */
public class FragmentStateAdapter$4 implements Runnable {
    public final /* synthetic */ FragmentStateAdapter this$0;

    public FragmentStateAdapter$4(FragmentStateAdapter fragmentStateAdapter) {
        this.this$0 = fragmentStateAdapter;
    }

    @Override // java.lang.Runnable
    public void run() {
        FragmentStateAdapter fragmentStateAdapter = this.this$0;
        fragmentStateAdapter.mIsInGracePeriod = false;
        fragmentStateAdapter.gcFragments();
    }
}
