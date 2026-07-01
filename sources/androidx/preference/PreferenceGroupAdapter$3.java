package androidx.preference;

/* JADX INFO: loaded from: classes.dex */
public class PreferenceGroupAdapter$3 implements Preference$OnPreferenceClickListener {
    public final /* synthetic */ PreferenceGroupAdapter this$0;
    public final /* synthetic */ PreferenceGroup val$group;

    public PreferenceGroupAdapter$3(PreferenceGroupAdapter preferenceGroupAdapter, PreferenceGroup preferenceGroup) {
        this.this$0 = preferenceGroupAdapter;
        this.val$group = preferenceGroup;
    }

    @Override // androidx.preference.Preference$OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.val$group.setInitialExpandedChildrenCount(Integer.MAX_VALUE);
        this.this$0.onPreferenceHierarchyChange(preference);
        PreferenceGroup$OnExpandButtonClickListener onExpandButtonClickListener = this.val$group.getOnExpandButtonClickListener();
        if (onExpandButtonClickListener == null) {
            return true;
        }
        onExpandButtonClickListener.onExpandButtonClick();
        return true;
    }
}
