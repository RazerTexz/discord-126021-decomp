package com.discord.workers;

import android.app.Application;
import android.content.Context;
import androidx.work.ListenableWorker$Result;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import d0.z.d.m;
import j0.m.a;

/* JADX INFO: compiled from: BackgroundMessageSendWorker.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BackgroundMessageSendWorker extends Worker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundMessageSendWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(workerParameters, "params");
    }

    @Override // androidx.work.Worker
    public ListenableWorker$Result doWork() {
        Context applicationContext = getApplicationContext();
        if (!(applicationContext instanceof Application)) {
            applicationContext = null;
        }
        Application application = (Application) applicationContext;
        if (application == null) {
            ListenableWorker$Result listenableWorker$ResultFailure = ListenableWorker$Result.failure();
            m.checkNotNullExpressionValue(listenableWorker$ResultFailure, "Result.failure()");
            return listenableWorker$ResultFailure;
        }
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        storeStream$Companion.initialize(application);
        new a(storeStream$Companion.getMessages().observeInitResendFinished().y(BackgroundMessageSendWorker$a.j).Z(1)).b();
        ListenableWorker$Result listenableWorker$ResultSuccess = ListenableWorker$Result.success();
        m.checkNotNullExpressionValue(listenableWorker$ResultSuccess, "Result.success()");
        return listenableWorker$ResultSuccess;
    }
}
