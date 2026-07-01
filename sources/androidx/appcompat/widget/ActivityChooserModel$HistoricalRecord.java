package androidx.appcompat.widget;

import android.content.ComponentName;
import b.d.b.a.a;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityChooserModel$HistoricalRecord {
    public final ComponentName activity;
    public final long time;
    public final float weight;

    public ActivityChooserModel$HistoricalRecord(String str, long j, float f) {
        this(ComponentName.unflattenFromString(str), j, f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ActivityChooserModel$HistoricalRecord.class != obj.getClass()) {
            return false;
        }
        ActivityChooserModel$HistoricalRecord activityChooserModel$HistoricalRecord = (ActivityChooserModel$HistoricalRecord) obj;
        ComponentName componentName = this.activity;
        if (componentName == null) {
            if (activityChooserModel$HistoricalRecord.activity != null) {
                return false;
            }
        } else if (!componentName.equals(activityChooserModel$HistoricalRecord.activity)) {
            return false;
        }
        return this.time == activityChooserModel$HistoricalRecord.time && Float.floatToIntBits(this.weight) == Float.floatToIntBits(activityChooserModel$HistoricalRecord.weight);
    }

    public int hashCode() {
        ComponentName componentName = this.activity;
        int iHashCode = componentName == null ? 0 : componentName.hashCode();
        long j = this.time;
        return Float.floatToIntBits(this.weight) + ((((iHashCode + 31) * 31) + ((int) (j ^ (j >>> 32)))) * 31);
    }

    public String toString() {
        StringBuilder sbX = a.X("[", "; activity:");
        sbX.append(this.activity);
        sbX.append("; time:");
        sbX.append(this.time);
        sbX.append("; weight:");
        sbX.append(new BigDecimal(this.weight));
        sbX.append("]");
        return sbX.toString();
    }

    public ActivityChooserModel$HistoricalRecord(ComponentName componentName, long j, float f) {
        this.activity = componentName;
        this.time = j;
        this.weight = f;
    }
}
