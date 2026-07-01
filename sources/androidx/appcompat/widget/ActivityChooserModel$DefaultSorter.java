package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityChooserModel$DefaultSorter implements ActivityChooserModel$ActivitySorter {
    private static final float WEIGHT_DECAY_COEFFICIENT = 0.95f;
    private final Map<ComponentName, ActivityChooserModel$ActivityResolveInfo> mPackageNameToActivityMap = new HashMap();

    @Override // androidx.appcompat.widget.ActivityChooserModel$ActivitySorter
    public void sort(Intent intent, List<ActivityChooserModel$ActivityResolveInfo> list, List<ActivityChooserModel$HistoricalRecord> list2) {
        Map<ComponentName, ActivityChooserModel$ActivityResolveInfo> map = this.mPackageNameToActivityMap;
        map.clear();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ActivityChooserModel$ActivityResolveInfo activityChooserModel$ActivityResolveInfo = list.get(i);
            activityChooserModel$ActivityResolveInfo.weight = 0.0f;
            ActivityInfo activityInfo = activityChooserModel$ActivityResolveInfo.resolveInfo.activityInfo;
            map.put(new ComponentName(activityInfo.packageName, activityInfo.name), activityChooserModel$ActivityResolveInfo);
        }
        float f = 1.0f;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            ActivityChooserModel$HistoricalRecord activityChooserModel$HistoricalRecord = list2.get(size2);
            ActivityChooserModel$ActivityResolveInfo activityChooserModel$ActivityResolveInfo2 = map.get(activityChooserModel$HistoricalRecord.activity);
            if (activityChooserModel$ActivityResolveInfo2 != null) {
                activityChooserModel$ActivityResolveInfo2.weight = (activityChooserModel$HistoricalRecord.weight * f) + activityChooserModel$ActivityResolveInfo2.weight;
                f *= WEIGHT_DECAY_COEFFICIENT;
            }
        }
        Collections.sort(list);
    }
}
