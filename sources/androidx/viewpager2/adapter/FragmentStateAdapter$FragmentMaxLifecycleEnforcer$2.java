package androidx.viewpager2.adapter;

/* JADX INFO: loaded from: classes.dex */
public class FragmentStateAdapter$FragmentMaxLifecycleEnforcer$2 extends FragmentStateAdapter$DataSetChangeObserver {
    public final /* synthetic */ FragmentStateAdapter$FragmentMaxLifecycleEnforcer this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentStateAdapter$FragmentMaxLifecycleEnforcer$2(FragmentStateAdapter$FragmentMaxLifecycleEnforcer fragmentStateAdapter$FragmentMaxLifecycleEnforcer) {
        super(null);
        this.this$1 = fragmentStateAdapter$FragmentMaxLifecycleEnforcer;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter$DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public void onChanged() {
        this.this$1.updateFragmentMaxLifecycle(true);
    }
}
