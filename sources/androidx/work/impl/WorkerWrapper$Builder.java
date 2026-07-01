package androidx.work.impl;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.annotation.VisibleForTesting;
import androidx.work.Configuration;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters$RuntimeExtras;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
public class WorkerWrapper$Builder {

    @NonNull
    public Context mAppContext;

    @NonNull
    public Configuration mConfiguration;

    @NonNull
    public ForegroundProcessor mForegroundProcessor;

    @NonNull
    public WorkerParameters$RuntimeExtras mRuntimeExtras = new WorkerParameters$RuntimeExtras();
    public List<Scheduler> mSchedulers;

    @NonNull
    public WorkDatabase mWorkDatabase;

    @NonNull
    public String mWorkSpecId;

    @NonNull
    public TaskExecutor mWorkTaskExecutor;

    @Nullable
    public ListenableWorker mWorker;

    public WorkerWrapper$Builder(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor, @NonNull ForegroundProcessor foregroundProcessor, @NonNull WorkDatabase workDatabase, @NonNull String str) {
        this.mAppContext = context.getApplicationContext();
        this.mWorkTaskExecutor = taskExecutor;
        this.mForegroundProcessor = foregroundProcessor;
        this.mConfiguration = configuration;
        this.mWorkDatabase = workDatabase;
        this.mWorkSpecId = str;
    }

    public WorkerWrapper build() {
        return new WorkerWrapper(this);
    }

    @NonNull
    public WorkerWrapper$Builder withRuntimeExtras(@Nullable WorkerParameters$RuntimeExtras workerParameters$RuntimeExtras) {
        if (workerParameters$RuntimeExtras != null) {
            this.mRuntimeExtras = workerParameters$RuntimeExtras;
        }
        return this;
    }

    @NonNull
    public WorkerWrapper$Builder withSchedulers(@NonNull List<Scheduler> list) {
        this.mSchedulers = list;
        return this;
    }

    @NonNull
    @VisibleForTesting
    public WorkerWrapper$Builder withWorker(@NonNull ListenableWorker listenableWorker) {
        this.mWorker = listenableWorker;
        return this;
    }
}
