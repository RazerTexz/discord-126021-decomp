package androidx.viewpager2.adapter;

import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$AdapterDataObserver;
import androidx.view.Lifecycle$State;
import androidx.view.LifecycleEventObserver;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback;

/* JADX INFO: loaded from: classes.dex */
public class FragmentStateAdapter$FragmentMaxLifecycleEnforcer {
    private RecyclerView$AdapterDataObserver mDataObserver;
    private LifecycleEventObserver mLifecycleObserver;
    private ViewPager2$OnPageChangeCallback mPageChangeCallback;
    private long mPrimaryItemId = -1;
    private ViewPager2 mViewPager;
    public final /* synthetic */ FragmentStateAdapter this$0;

    public FragmentStateAdapter$FragmentMaxLifecycleEnforcer(FragmentStateAdapter fragmentStateAdapter) {
        this.this$0 = fragmentStateAdapter;
    }

    @NonNull
    private ViewPager2 inferViewPager(@NonNull RecyclerView recyclerView) {
        ViewParent parent = recyclerView.getParent();
        if (parent instanceof ViewPager2) {
            return (ViewPager2) parent;
        }
        throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
    }

    public void register(@NonNull RecyclerView recyclerView) {
        this.mViewPager = inferViewPager(recyclerView);
        FragmentStateAdapter$FragmentMaxLifecycleEnforcer$1 fragmentStateAdapter$FragmentMaxLifecycleEnforcer$1 = new FragmentStateAdapter$FragmentMaxLifecycleEnforcer$1(this);
        this.mPageChangeCallback = fragmentStateAdapter$FragmentMaxLifecycleEnforcer$1;
        this.mViewPager.registerOnPageChangeCallback(fragmentStateAdapter$FragmentMaxLifecycleEnforcer$1);
        FragmentStateAdapter$FragmentMaxLifecycleEnforcer$2 fragmentStateAdapter$FragmentMaxLifecycleEnforcer$2 = new FragmentStateAdapter$FragmentMaxLifecycleEnforcer$2(this);
        this.mDataObserver = fragmentStateAdapter$FragmentMaxLifecycleEnforcer$2;
        this.this$0.registerAdapterDataObserver(fragmentStateAdapter$FragmentMaxLifecycleEnforcer$2);
        FragmentStateAdapter$FragmentMaxLifecycleEnforcer$3 fragmentStateAdapter$FragmentMaxLifecycleEnforcer$3 = new FragmentStateAdapter$FragmentMaxLifecycleEnforcer$3(this);
        this.mLifecycleObserver = fragmentStateAdapter$FragmentMaxLifecycleEnforcer$3;
        this.this$0.mLifecycle.addObserver(fragmentStateAdapter$FragmentMaxLifecycleEnforcer$3);
    }

    public void unregister(@NonNull RecyclerView recyclerView) {
        inferViewPager(recyclerView).unregisterOnPageChangeCallback(this.mPageChangeCallback);
        this.this$0.unregisterAdapterDataObserver(this.mDataObserver);
        this.this$0.mLifecycle.removeObserver(this.mLifecycleObserver);
        this.mViewPager = null;
    }

    public void updateFragmentMaxLifecycle(boolean z2) {
        int currentItem;
        Fragment fragment;
        if (this.this$0.shouldDelayFragmentTransactions() || this.mViewPager.getScrollState() != 0 || this.this$0.mFragments.isEmpty() || this.this$0.getItemCount() == 0 || (currentItem = this.mViewPager.getCurrentItem()) >= this.this$0.getItemCount()) {
            return;
        }
        long itemId = this.this$0.getItemId(currentItem);
        if ((itemId != this.mPrimaryItemId || z2) && (fragment = this.this$0.mFragments.get(itemId)) != null && fragment.isAdded()) {
            this.mPrimaryItemId = itemId;
            FragmentTransaction fragmentTransactionBeginTransaction = this.this$0.mFragmentManager.beginTransaction();
            Fragment fragment2 = null;
            for (int i = 0; i < this.this$0.mFragments.size(); i++) {
                long jKeyAt = this.this$0.mFragments.keyAt(i);
                Fragment fragmentValueAt = this.this$0.mFragments.valueAt(i);
                if (fragmentValueAt.isAdded()) {
                    if (jKeyAt != this.mPrimaryItemId) {
                        fragmentTransactionBeginTransaction.setMaxLifecycle(fragmentValueAt, Lifecycle$State.STARTED);
                    } else {
                        fragment2 = fragmentValueAt;
                    }
                    fragmentValueAt.setMenuVisibility(jKeyAt == this.mPrimaryItemId);
                }
            }
            if (fragment2 != null) {
                fragmentTransactionBeginTransaction.setMaxLifecycle(fragment2, Lifecycle$State.RESUMED);
            }
            if (fragmentTransactionBeginTransaction.isEmpty()) {
                return;
            }
            fragmentTransactionBeginTransaction.commitNow();
        }
    }
}
