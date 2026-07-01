package androidx.work;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class Configuration$Builder {
    public Executor mExecutor;
    public InputMergerFactory mInputMergerFactory;
    public int mLoggingLevel;
    public int mMaxJobSchedulerId;
    public int mMaxSchedulerLimit;
    public int mMinJobSchedulerId;
    public RunnableScheduler mRunnableScheduler;
    public Executor mTaskExecutor;
    public WorkerFactory mWorkerFactory;

    public Configuration$Builder() {
        this.mLoggingLevel = 4;
        this.mMinJobSchedulerId = 0;
        this.mMaxJobSchedulerId = Integer.MAX_VALUE;
        this.mMaxSchedulerLimit = 20;
    }

    @NonNull
    public Configuration build() {
        return new Configuration(this);
    }

    @NonNull
    public Configuration$Builder setExecutor(@NonNull Executor executor) {
        this.mExecutor = executor;
        return this;
    }

    @NonNull
    public Configuration$Builder setInputMergerFactory(@NonNull InputMergerFactory inputMergerFactory) {
        this.mInputMergerFactory = inputMergerFactory;
        return this;
    }

    @NonNull
    public Configuration$Builder setJobSchedulerJobIdRange(int i, int i2) {
        if (i2 - i < 1000) {
            throw new IllegalArgumentException("WorkManager needs a range of at least 1000 job ids.");
        }
        this.mMinJobSchedulerId = i;
        this.mMaxJobSchedulerId = i2;
        return this;
    }

    @NonNull
    public Configuration$Builder setMaxSchedulerLimit(int i) {
        if (i < 20) {
            throw new IllegalArgumentException("WorkManager needs to be able to schedule at least 20 jobs in JobScheduler.");
        }
        this.mMaxSchedulerLimit = Math.min(i, 50);
        return this;
    }

    @NonNull
    public Configuration$Builder setMinimumLoggingLevel(int i) {
        this.mLoggingLevel = i;
        return this;
    }

    @NonNull
    public Configuration$Builder setRunnableScheduler(@NonNull RunnableScheduler runnableScheduler) {
        this.mRunnableScheduler = runnableScheduler;
        return this;
    }

    @NonNull
    public Configuration$Builder setTaskExecutor(@NonNull Executor executor) {
        this.mTaskExecutor = executor;
        return this;
    }

    @NonNull
    public Configuration$Builder setWorkerFactory(@NonNull WorkerFactory workerFactory) {
        this.mWorkerFactory = workerFactory;
        return this;
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
    public Configuration$Builder(@NonNull Configuration configuration) {
        this.mExecutor = configuration.mExecutor;
        this.mWorkerFactory = configuration.mWorkerFactory;
        this.mInputMergerFactory = configuration.mInputMergerFactory;
        this.mTaskExecutor = configuration.mTaskExecutor;
        this.mLoggingLevel = configuration.mLoggingLevel;
        this.mMinJobSchedulerId = configuration.mMinJobSchedulerId;
        this.mMaxJobSchedulerId = configuration.mMaxJobSchedulerId;
        this.mMaxSchedulerLimit = configuration.mMaxSchedulerLimit;
        this.mRunnableScheduler = configuration.mRunnableScheduler;
    }
}
