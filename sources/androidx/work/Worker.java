package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.work.impl.utils.futures.SettableFuture;
import b.i.b.d.a.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class Worker extends ListenableWorker {
    public SettableFuture<ListenableWorker$Result> mFuture;

    @Keep
    @SuppressLint({"BanKeepAnnotation"})
    public Worker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @NonNull
    @WorkerThread
    public abstract ListenableWorker$Result doWork();

    @Override // androidx.work.ListenableWorker
    @NonNull
    public final a<ListenableWorker$Result> startWork() {
        this.mFuture = SettableFuture.create();
        getBackgroundExecutor().execute(new Worker$1(this));
        return this.mFuture;
    }
}
