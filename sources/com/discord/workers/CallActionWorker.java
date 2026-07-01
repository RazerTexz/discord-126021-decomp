package com.discord.workers;

import android.content.Context;
import androidx.work.Data;
import androidx.work.ListenableWorker$Result;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.discord.app.AppLog;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.io.NetworkUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rest.RestAPI;
import d0.z.d.m;
import j0.m.a;
import java.util.List;
import java.util.Objects;
import rx.Observable;

/* JADX INFO: compiled from: CallActionWorker.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallActionWorker extends Worker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallActionWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(workerParameters, "params");
    }

    @Override // androidx.work.Worker
    public ListenableWorker$Result doWork() {
        AppLog appLog = AppLog.g;
        String simpleName = CallActionWorker.class.getSimpleName();
        m.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        StringBuilder sb = new StringBuilder();
        sb.append("Starting for [");
        Data inputData = getInputData();
        m.checkNotNullExpressionValue(inputData, "inputData");
        sb.append(inputData.getKeyValueMap());
        sb.append(']');
        Logger.i$default(appLog, simpleName, sb.toString(), null, 4, null);
        if (!NotificationClient.INSTANCE.isAuthed()) {
            String simpleName2 = CallActionWorker.class.getSimpleName();
            m.checkNotNullExpressionValue(simpleName2, "javaClass.simpleName");
            Logger.d$default(appLog, simpleName2, "Not authenticated. Aborting job request.", null, 4, null);
            ListenableWorker$Result listenableWorker$ResultFailure = ListenableWorker$Result.failure();
            m.checkNotNullExpressionValue(listenableWorker$ResultFailure, "Result.failure()");
            return listenableWorker$ResultFailure;
        }
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        Context applicationContext = getApplicationContext();
        m.checkNotNullExpressionValue(applicationContext, "applicationContext");
        if (!NetworkUtils.isDeviceConnected$default(networkUtils, applicationContext, null, null, 6, null)) {
            ListenableWorker$Result listenableWorker$ResultRetry = ListenableWorker$Result.retry();
            m.checkNotNullExpressionValue(listenableWorker$ResultRetry, "Result.retry()");
            return listenableWorker$ResultRetry;
        }
        long j = getInputData().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L);
        long j2 = getInputData().getLong("com.discord.intent.extra.EXTRA_MESSAGE_ID", -1L);
        try {
            Observable<Void> observableStopRinging = RestAPI.Companion.getApi().stopRinging(j, j2, (List<Long>) null);
            Objects.requireNonNull(observableStopRinging);
            new a(observableStopRinging).b();
            String simpleName3 = getClass().getSimpleName();
            m.checkNotNullExpressionValue(simpleName3, "javaClass.simpleName");
            try {
                Logger.d$default(appLog, simpleName3, "Call declined: " + j + '-' + j2, null, 4, null);
                ListenableWorker$Result listenableWorker$ResultSuccess = ListenableWorker$Result.success();
                m.checkNotNullExpressionValue(listenableWorker$ResultSuccess, "Result.success()");
                return listenableWorker$ResultSuccess;
            } catch (Throwable th) {
                th = th;
                AppLog appLog2 = AppLog.g;
                String simpleName4 = CallActionWorker.class.getSimpleName();
                m.checkNotNullExpressionValue(simpleName4, "javaClass.simpleName");
                appLog2.w(simpleName4, "Call declined failure: " + j + '-' + j2, th);
                ListenableWorker$Result listenableWorker$ResultRetry2 = getRunAttemptCount() < 3 ? ListenableWorker$Result.retry() : ListenableWorker$Result.failure();
                m.checkNotNullExpressionValue(listenableWorker$ResultRetry2, "if (runAttemptCount < MA…y() else Result.failure()");
                return listenableWorker$ResultRetry2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
