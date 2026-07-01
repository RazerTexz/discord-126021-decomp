package androidx.preference;

import androidx.recyclerview.widget.RecyclerView$Adapter;

/* JADX INFO: loaded from: classes.dex */
public class PreferenceFragment$3 implements Runnable {
    public final /* synthetic */ PreferenceFragment this$0;
    public final /* synthetic */ String val$key;
    public final /* synthetic */ Preference val$preference;

    public PreferenceFragment$3(PreferenceFragment preferenceFragment, Preference preference, String str) {
        this.this$0 = preferenceFragment;
        this.val$preference = preference;
        this.val$key = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public void run() {
        RecyclerView$Adapter adapter = this.this$0.mList.getAdapter();
        if (!(adapter instanceof PreferenceGroup$PreferencePositionCallback)) {
            if (adapter != 0) {
                throw new IllegalStateException("Adapter must implement PreferencePositionCallback");
            }
            return;
        }
        Preference preference = this.val$preference;
        int preferenceAdapterPosition = preference != null ? ((PreferenceGroup$PreferencePositionCallback) adapter).getPreferenceAdapterPosition(preference) : ((PreferenceGroup$PreferencePositionCallback) adapter).getPreferenceAdapterPosition(this.val$key);
        if (preferenceAdapterPosition != -1) {
            this.this$0.mList.scrollToPosition(preferenceAdapterPosition);
        } else {
            adapter.registerAdapterDataObserver(new PreferenceFragment$ScrollToPreferenceObserver(adapter, this.this$0.mList, this.val$preference, this.val$key));
        }
    }
}
