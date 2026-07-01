package androidx.core.app;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.graphics.Rect;
import android.os.Build$VERSION;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(16)
public class ActivityOptionsCompat$ActivityOptionsCompatImpl extends ActivityOptionsCompat {
    private final ActivityOptions mActivityOptions;

    public ActivityOptionsCompat$ActivityOptionsCompatImpl(ActivityOptions activityOptions) {
        this.mActivityOptions = activityOptions;
    }

    @Override // androidx.core.app.ActivityOptionsCompat
    public Rect getLaunchBounds() {
        if (Build$VERSION.SDK_INT < 24) {
            return null;
        }
        return this.mActivityOptions.getLaunchBounds();
    }

    @Override // androidx.core.app.ActivityOptionsCompat
    public void requestUsageTimeReport(@NonNull PendingIntent pendingIntent) {
        if (Build$VERSION.SDK_INT >= 23) {
            this.mActivityOptions.requestUsageTimeReport(pendingIntent);
        }
    }

    @Override // androidx.core.app.ActivityOptionsCompat
    @NonNull
    public ActivityOptionsCompat setLaunchBounds(@Nullable Rect rect) {
        return Build$VERSION.SDK_INT < 24 ? this : new ActivityOptionsCompat$ActivityOptionsCompatImpl(this.mActivityOptions.setLaunchBounds(rect));
    }

    @Override // androidx.core.app.ActivityOptionsCompat
    public Bundle toBundle() {
        return this.mActivityOptions.toBundle();
    }

    @Override // androidx.core.app.ActivityOptionsCompat
    public void update(@NonNull ActivityOptionsCompat activityOptionsCompat) {
        if (activityOptionsCompat instanceof ActivityOptionsCompat$ActivityOptionsCompatImpl) {
            this.mActivityOptions.update(((ActivityOptionsCompat$ActivityOptionsCompatImpl) activityOptionsCompat).mActivityOptions);
        }
    }
}
