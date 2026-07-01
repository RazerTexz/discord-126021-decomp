package androidx.work;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class Constraints$Builder {
    public boolean mRequiresCharging = false;
    public boolean mRequiresDeviceIdle = false;
    public NetworkType mRequiredNetworkType = NetworkType.NOT_REQUIRED;
    public boolean mRequiresBatteryNotLow = false;
    public boolean mRequiresStorageNotLow = false;
    public long mTriggerContentUpdateDelay = -1;
    public long mTriggerContentMaxDelay = -1;
    public ContentUriTriggers mContentUriTriggers = new ContentUriTriggers();

    @NonNull
    @RequiresApi(24)
    public Constraints$Builder addContentUriTrigger(@NonNull Uri uri, boolean z2) {
        this.mContentUriTriggers.add(uri, z2);
        return this;
    }

    @NonNull
    public Constraints build() {
        return new Constraints(this);
    }

    @NonNull
    public Constraints$Builder setRequiredNetworkType(@NonNull NetworkType networkType) {
        this.mRequiredNetworkType = networkType;
        return this;
    }

    @NonNull
    public Constraints$Builder setRequiresBatteryNotLow(boolean z2) {
        this.mRequiresBatteryNotLow = z2;
        return this;
    }

    @NonNull
    public Constraints$Builder setRequiresCharging(boolean z2) {
        this.mRequiresCharging = z2;
        return this;
    }

    @NonNull
    @RequiresApi(23)
    public Constraints$Builder setRequiresDeviceIdle(boolean z2) {
        this.mRequiresDeviceIdle = z2;
        return this;
    }

    @NonNull
    public Constraints$Builder setRequiresStorageNotLow(boolean z2) {
        this.mRequiresStorageNotLow = z2;
        return this;
    }

    @NonNull
    @RequiresApi(24)
    public Constraints$Builder setTriggerContentMaxDelay(long j, @NonNull TimeUnit timeUnit) {
        this.mTriggerContentMaxDelay = timeUnit.toMillis(j);
        return this;
    }

    @NonNull
    @RequiresApi(24)
    public Constraints$Builder setTriggerContentUpdateDelay(long j, @NonNull TimeUnit timeUnit) {
        this.mTriggerContentUpdateDelay = timeUnit.toMillis(j);
        return this;
    }

    @NonNull
    @RequiresApi(26)
    public Constraints$Builder setTriggerContentMaxDelay(Duration duration) {
        this.mTriggerContentMaxDelay = duration.toMillis();
        return this;
    }

    @NonNull
    @RequiresApi(26)
    public Constraints$Builder setTriggerContentUpdateDelay(Duration duration) {
        this.mTriggerContentUpdateDelay = duration.toMillis();
        return this;
    }
}
