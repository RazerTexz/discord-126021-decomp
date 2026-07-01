package androidx.work;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.annotation.VisibleForTesting;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.WorkRequest;
import androidx.work.WorkRequest$Builder;
import androidx.work.impl.model.WorkSpec;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class WorkRequest$Builder<B extends WorkRequest$Builder<?, ?>, W extends WorkRequest> {
    public WorkSpec mWorkSpec;
    public Class<? extends ListenableWorker> mWorkerClass;
    public boolean mBackoffCriteriaSet = false;
    public Set<String> mTags = new HashSet();
    public UUID mId = UUID.randomUUID();

    public WorkRequest$Builder(@NonNull Class<? extends ListenableWorker> cls) {
        this.mWorkerClass = cls;
        this.mWorkSpec = new WorkSpec(this.mId.toString(), cls.getName());
        addTag(cls.getName());
    }

    @NonNull
    public final B addTag(@NonNull String str) {
        this.mTags.add(str);
        return (B) getThis();
    }

    @NonNull
    public final W build() {
        W w = (W) buildInternal();
        this.mId = UUID.randomUUID();
        WorkSpec workSpec = new WorkSpec(this.mWorkSpec);
        this.mWorkSpec = workSpec;
        workSpec.f38id = this.mId.toString();
        return w;
    }

    @NonNull
    public abstract W buildInternal();

    @NonNull
    public abstract B getThis();

    @NonNull
    public final B keepResultsForAtLeast(long j, @NonNull TimeUnit timeUnit) {
        this.mWorkSpec.minimumRetentionDuration = timeUnit.toMillis(j);
        return (B) getThis();
    }

    @NonNull
    public final B setBackoffCriteria(@NonNull BackoffPolicy backoffPolicy, long j, @NonNull TimeUnit timeUnit) {
        this.mBackoffCriteriaSet = true;
        WorkSpec workSpec = this.mWorkSpec;
        workSpec.backoffPolicy = backoffPolicy;
        workSpec.setBackoffDelayDuration(timeUnit.toMillis(j));
        return (B) getThis();
    }

    @NonNull
    public final B setConstraints(@NonNull Constraints constraints) {
        this.mWorkSpec.constraints = constraints;
        return (B) getThis();
    }

    @NonNull
    public B setInitialDelay(long j, @NonNull TimeUnit timeUnit) {
        this.mWorkSpec.initialDelay = timeUnit.toMillis(j);
        if (RecyclerView.FOREVER_NS - System.currentTimeMillis() > this.mWorkSpec.initialDelay) {
            return (B) getThis();
        }
        throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
    }

    @NonNull
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public final B setInitialRunAttemptCount(int i) {
        this.mWorkSpec.runAttemptCount = i;
        return (B) getThis();
    }

    @NonNull
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public final B setInitialState(@NonNull WorkInfo$State workInfo$State) {
        this.mWorkSpec.state = workInfo$State;
        return (B) getThis();
    }

    @NonNull
    public final B setInputData(@NonNull Data data) {
        this.mWorkSpec.input = data;
        return (B) getThis();
    }

    @NonNull
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public final B setPeriodStartTime(long j, @NonNull TimeUnit timeUnit) {
        this.mWorkSpec.periodStartTime = timeUnit.toMillis(j);
        return (B) getThis();
    }

    @NonNull
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public final B setScheduleRequestedAt(long j, @NonNull TimeUnit timeUnit) {
        this.mWorkSpec.scheduleRequestedAt = timeUnit.toMillis(j);
        return (B) getThis();
    }

    @NonNull
    @RequiresApi(26)
    public final B keepResultsForAtLeast(@NonNull Duration duration) {
        this.mWorkSpec.minimumRetentionDuration = duration.toMillis();
        return (B) getThis();
    }

    @NonNull
    @RequiresApi(26)
    public final B setBackoffCriteria(@NonNull BackoffPolicy backoffPolicy, @NonNull Duration duration) {
        this.mBackoffCriteriaSet = true;
        WorkSpec workSpec = this.mWorkSpec;
        workSpec.backoffPolicy = backoffPolicy;
        workSpec.setBackoffDelayDuration(duration.toMillis());
        return (B) getThis();
    }

    @NonNull
    @RequiresApi(26)
    public B setInitialDelay(@NonNull Duration duration) {
        this.mWorkSpec.initialDelay = duration.toMillis();
        if (RecyclerView.FOREVER_NS - System.currentTimeMillis() > this.mWorkSpec.initialDelay) {
            return (B) getThis();
        }
        throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
    }
}
