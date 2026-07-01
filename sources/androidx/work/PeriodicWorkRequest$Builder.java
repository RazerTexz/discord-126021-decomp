package androidx.work;

import android.os.Build$VERSION;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.work.impl.model.WorkSpec;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class PeriodicWorkRequest$Builder extends WorkRequest$Builder<PeriodicWorkRequest$Builder, PeriodicWorkRequest> {
    public PeriodicWorkRequest$Builder(@NonNull Class<? extends ListenableWorker> cls, long j, @NonNull TimeUnit timeUnit) {
        super(cls);
        this.mWorkSpec.setPeriodic(timeUnit.toMillis(j));
    }

    @Override // androidx.work.WorkRequest$Builder
    @NonNull
    public /* bridge */ /* synthetic */ WorkRequest buildInternal() {
        return buildInternal();
    }

    @Override // androidx.work.WorkRequest$Builder
    @NonNull
    public PeriodicWorkRequest$Builder getThis() {
        return this;
    }

    @Override // androidx.work.WorkRequest$Builder
    @NonNull
    public /* bridge */ /* synthetic */ WorkRequest$Builder getThis() {
        return getThis();
    }

    @Override // androidx.work.WorkRequest$Builder
    @NonNull
    public PeriodicWorkRequest buildInternal() {
        if (this.mBackoffCriteriaSet && Build$VERSION.SDK_INT >= 23 && this.mWorkSpec.constraints.requiresDeviceIdle()) {
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        }
        WorkSpec workSpec = this.mWorkSpec;
        if (workSpec.runInForeground && Build$VERSION.SDK_INT >= 23 && workSpec.constraints.requiresDeviceIdle()) {
            throw new IllegalArgumentException("Cannot run in foreground with an idle mode constraint");
        }
        return new PeriodicWorkRequest(this);
    }

    @RequiresApi(26)
    public PeriodicWorkRequest$Builder(@NonNull Class<? extends ListenableWorker> cls, @NonNull Duration duration) {
        super(cls);
        this.mWorkSpec.setPeriodic(duration.toMillis());
    }

    public PeriodicWorkRequest$Builder(@NonNull Class<? extends ListenableWorker> cls, long j, @NonNull TimeUnit timeUnit, long j2, @NonNull TimeUnit timeUnit2) {
        super(cls);
        this.mWorkSpec.setPeriodic(timeUnit.toMillis(j), timeUnit2.toMillis(j2));
    }

    @RequiresApi(26)
    public PeriodicWorkRequest$Builder(@NonNull Class<? extends ListenableWorker> cls, @NonNull Duration duration, @NonNull Duration duration2) {
        super(cls);
        this.mWorkSpec.setPeriodic(duration.toMillis(), duration2.toMillis());
    }
}
