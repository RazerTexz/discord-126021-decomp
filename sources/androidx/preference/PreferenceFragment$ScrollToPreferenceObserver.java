package androidx.preference;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$AdapterDataObserver;

/* JADX INFO: loaded from: classes.dex */
public class PreferenceFragment$ScrollToPreferenceObserver extends RecyclerView$AdapterDataObserver {
    private final RecyclerView$Adapter mAdapter;
    private final String mKey;
    private final RecyclerView mList;
    private final Preference mPreference;

    public PreferenceFragment$ScrollToPreferenceObserver(RecyclerView$Adapter recyclerView$Adapter, RecyclerView recyclerView, Preference preference, String str) {
        this.mAdapter = recyclerView$Adapter;
        this.mList = recyclerView;
        this.mPreference = preference;
        this.mKey = str;
    }

    private void scrollToPreference() {
        this.mAdapter.unregisterAdapterDataObserver(this);
        Preference preference = this.mPreference;
        int preferenceAdapterPosition = preference != null ? ((PreferenceGroup$PreferencePositionCallback) this.mAdapter).getPreferenceAdapterPosition(preference) : ((PreferenceGroup$PreferencePositionCallback) this.mAdapter).getPreferenceAdapterPosition(this.mKey);
        if (preferenceAdapterPosition != -1) {
            this.mList.scrollToPosition(preferenceAdapterPosition);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public void onChanged() {
        scrollToPreference();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public void onItemRangeChanged(int i, int i2) {
        scrollToPreference();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public void onItemRangeInserted(int i, int i2) {
        scrollToPreference();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public void onItemRangeMoved(int i, int i2, int i3) {
        scrollToPreference();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public void onItemRangeRemoved(int i, int i2) {
        scrollToPreference();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public void onItemRangeChanged(int i, int i2, Object obj) {
        scrollToPreference();
    }
}
