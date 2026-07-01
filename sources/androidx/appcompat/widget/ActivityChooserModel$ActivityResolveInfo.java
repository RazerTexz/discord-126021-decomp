package androidx.appcompat.widget;

import android.content.pm.ResolveInfo;
import b.d.b.a.a;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityChooserModel$ActivityResolveInfo implements Comparable<ActivityChooserModel$ActivityResolveInfo> {
    public final ResolveInfo resolveInfo;
    public float weight;

    public ActivityChooserModel$ActivityResolveInfo(ResolveInfo resolveInfo) {
        this.resolveInfo = resolveInfo;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ActivityChooserModel$ActivityResolveInfo activityChooserModel$ActivityResolveInfo) {
        return compareTo2(activityChooserModel$ActivityResolveInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && ActivityChooserModel$ActivityResolveInfo.class == obj.getClass() && Float.floatToIntBits(this.weight) == Float.floatToIntBits(((ActivityChooserModel$ActivityResolveInfo) obj).weight);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.weight) + 31;
    }

    public String toString() {
        StringBuilder sbX = a.X("[", "resolveInfo:");
        sbX.append(this.resolveInfo.toString());
        sbX.append("; weight:");
        sbX.append(new BigDecimal(this.weight));
        sbX.append("]");
        return sbX.toString();
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(ActivityChooserModel$ActivityResolveInfo activityChooserModel$ActivityResolveInfo) {
        return Float.floatToIntBits(activityChooserModel$ActivityResolveInfo.weight) - Float.floatToIntBits(this.weight);
    }
}
