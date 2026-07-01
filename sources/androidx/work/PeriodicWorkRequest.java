package androidx.work;

import android.annotation.SuppressLint;

/* JADX INFO: loaded from: classes.dex */
public final class PeriodicWorkRequest extends WorkRequest {

    @SuppressLint({"MinMaxConstant"})
    public static final long MIN_PERIODIC_FLEX_MILLIS = 300000;

    @SuppressLint({"MinMaxConstant"})
    public static final long MIN_PERIODIC_INTERVAL_MILLIS = 900000;

    public PeriodicWorkRequest(PeriodicWorkRequest$Builder periodicWorkRequest$Builder) {
        super(periodicWorkRequest$Builder.mId, periodicWorkRequest$Builder.mWorkSpec, periodicWorkRequest$Builder.mTags);
    }
}
