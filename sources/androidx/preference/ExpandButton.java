package androidx.preference;

import android.content.Context;
import android.text.TextUtils;
import androidx.room.RoomDatabase;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ExpandButton extends Preference {
    private long mId;

    public ExpandButton(Context context, List<Preference> list, long j) {
        super(context);
        initLayout();
        setSummary(list);
        this.mId = j + 1000000;
    }

    private void initLayout() {
        setLayoutResource(C0525R.layout.expand_button);
        setIcon(C0525R.drawable.ic_arrow_down_24dp);
        setTitle(C0525R.string.expand_button_title);
        setOrder(RoomDatabase.MAX_BIND_PARAMETER_CNT);
    }

    private void setSummary(List<Preference> list) {
        ArrayList arrayList = new ArrayList();
        CharSequence string = null;
        for (Preference preference : list) {
            CharSequence title = preference.getTitle();
            boolean z2 = preference instanceof PreferenceGroup;
            if (z2 && !TextUtils.isEmpty(title)) {
                arrayList.add((PreferenceGroup) preference);
            }
            if (arrayList.contains(preference.getParent())) {
                if (z2) {
                    arrayList.add((PreferenceGroup) preference);
                }
            } else if (!TextUtils.isEmpty(title)) {
                string = string == null ? title : getContext().getString(C0525R.string.summary_collapsed_preference_list, string, title);
            }
        }
        setSummary(string);
    }

    @Override // androidx.preference.Preference
    public long getId() {
        return this.mId;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        preferenceViewHolder.setDividerAllowedAbove(false);
    }
}
