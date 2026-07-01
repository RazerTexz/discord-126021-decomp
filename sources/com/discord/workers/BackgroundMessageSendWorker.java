package com.discord.workers;

import android.app.Application;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.discord.stores.StoreStream;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.m.BlockingObservable;

/* JADX INFO: compiled from: BackgroundMessageSendWorker.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BackgroundMessageSendWorker extends Worker {

    /* JADX INFO: compiled from: BackgroundMessageSendWorker.kt */
    public static final class a<T, R> implements Func1<Boolean, Boolean> {
        public static final a j = new a();

        @Override // j0.k.Func1
        public Boolean call(Boolean bool) {
            return Boolean.valueOf(Intrinsics3.areEqual(bool, Boolean.TRUE));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundMessageSendWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(workerParameters, "params");
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        Context applicationContext = getApplicationContext();
        if (!(applicationContext instanceof Application)) {
            applicationContext = null;
        }
        Application application = (Application) applicationContext;
        if (application == null) {
            ListenableWorker.Result resultFailure = ListenableWorker.Result.failure();
            Intrinsics3.checkNotNullExpressionValue(resultFailure, "Result.failure()");
            return resultFailure;
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        companion.initialize(application);
        new BlockingObservable(companion.getMessages().observeInitResendFinished().y(a.j).Z(1)).b();
        ListenableWorker.Result resultSuccess = ListenableWorker.Result.success();
        Intrinsics3.checkNotNullExpressionValue(resultSuccess, "Result.success()");
        return resultSuccess;
    }
}
