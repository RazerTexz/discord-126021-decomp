package androidx.core.view.accessibility;

import android.graphics.Region;
import android.os.Build$VERSION;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo$TouchDelegateInfo;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class AccessibilityNodeInfoCompat$TouchDelegateInfoCompat {
    public final AccessibilityNodeInfo$TouchDelegateInfo mInfo;

    public AccessibilityNodeInfoCompat$TouchDelegateInfoCompat(@NonNull Map<Region, View> map) {
        if (Build$VERSION.SDK_INT >= 29) {
            this.mInfo = new AccessibilityNodeInfo$TouchDelegateInfo(map);
        } else {
            this.mInfo = null;
        }
    }

    @Nullable
    public Region getRegionAt(@IntRange(from = 0) int i) {
        if (Build$VERSION.SDK_INT >= 29) {
            return this.mInfo.getRegionAt(i);
        }
        return null;
    }

    @IntRange(from = 0)
    public int getRegionCount() {
        if (Build$VERSION.SDK_INT >= 29) {
            return this.mInfo.getRegionCount();
        }
        return 0;
    }

    @Nullable
    public AccessibilityNodeInfoCompat getTargetForRegion(@NonNull Region region) {
        AccessibilityNodeInfo targetForRegion;
        if (Build$VERSION.SDK_INT < 29 || (targetForRegion = this.mInfo.getTargetForRegion(region)) == null) {
            return null;
        }
        return AccessibilityNodeInfoCompat.wrap(targetForRegion);
    }

    public AccessibilityNodeInfoCompat$TouchDelegateInfoCompat(@NonNull AccessibilityNodeInfo$TouchDelegateInfo accessibilityNodeInfo$TouchDelegateInfo) {
        this.mInfo = accessibilityNodeInfo$TouchDelegateInfo;
    }
}
