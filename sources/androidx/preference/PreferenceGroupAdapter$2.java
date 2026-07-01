package androidx.preference;

import androidx.recyclerview.widget.DiffUtil$Callback;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PreferenceGroupAdapter$2 extends DiffUtil$Callback {
    public final /* synthetic */ PreferenceGroupAdapter this$0;
    public final /* synthetic */ PreferenceManager$PreferenceComparisonCallback val$comparisonCallback;
    public final /* synthetic */ List val$oldVisibleList;
    public final /* synthetic */ List val$visiblePreferenceList;

    public PreferenceGroupAdapter$2(PreferenceGroupAdapter preferenceGroupAdapter, List list, List list2, PreferenceManager$PreferenceComparisonCallback preferenceManager$PreferenceComparisonCallback) {
        this.this$0 = preferenceGroupAdapter;
        this.val$oldVisibleList = list;
        this.val$visiblePreferenceList = list2;
        this.val$comparisonCallback = preferenceManager$PreferenceComparisonCallback;
    }

    @Override // androidx.recyclerview.widget.DiffUtil$Callback
    public boolean areContentsTheSame(int i, int i2) {
        return this.val$comparisonCallback.arePreferenceContentsTheSame((Preference) this.val$oldVisibleList.get(i), (Preference) this.val$visiblePreferenceList.get(i2));
    }

    @Override // androidx.recyclerview.widget.DiffUtil$Callback
    public boolean areItemsTheSame(int i, int i2) {
        return this.val$comparisonCallback.arePreferenceItemsTheSame((Preference) this.val$oldVisibleList.get(i), (Preference) this.val$visiblePreferenceList.get(i2));
    }

    @Override // androidx.recyclerview.widget.DiffUtil$Callback
    public int getNewListSize() {
        return this.val$visiblePreferenceList.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil$Callback
    public int getOldListSize() {
        return this.val$oldVisibleList.size();
    }
}
