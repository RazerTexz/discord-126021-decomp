package com.discord.workers;

import android.content.Context;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.discord.app.AppLog;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.io.NetworkUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rest.RestAPI;
import d0.z.d.Intrinsics3;
import j0.m.BlockingObservable;
import java.util.List;
import java.util.Objects;
import rx.Observable;

/* JADX INFO: compiled from: CallActionWorker.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallActionWorker extends Worker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallActionWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(workerParameters, "params");
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        AppLog appLog = AppLog.g;
        String simpleName = CallActionWorker.class.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        StringBuilder sb = new StringBuilder();
        sb.append("Starting for [");
        Data inputData = getInputData();
        Intrinsics3.checkNotNullExpressionValue(inputData, "inputData");
        sb.append(inputData.getKeyValueMap());
        sb.append(']');
        Logger.i$default(appLog, simpleName, sb.toString(), null, 4, null);
        if (!NotificationClient.INSTANCE.isAuthed()) {
            String simpleName2 = CallActionWorker.class.getSimpleName();
            Intrinsics3.checkNotNullExpressionValue(simpleName2, "javaClass.simpleName");
            Logger.d$default(appLog, simpleName2, "Not authenticated. Aborting job request.", null, 4, null);
            ListenableWorker.Result resultFailure = ListenableWorker.Result.failure();
            Intrinsics3.checkNotNullExpressionValue(resultFailure, "Result.failure()");
            return resultFailure;
        }
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics3.checkNotNullExpressionValue(applicationContext, "applicationContext");
        if (!NetworkUtils.isDeviceConnected$default(networkUtils, applicationContext, null, null, 6, null)) {
            ListenableWorker.Result resultRetry = ListenableWorker.Result.retry();
            Intrinsics3.checkNotNullExpressionValue(resultRetry, "Result.retry()");
            return resultRetry;
        }
        long j = getInputData().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L);
        long j2 = getInputData().getLong("com.discord.intent.extra.EXTRA_MESSAGE_ID", -1L);
        try {
            Observable<Void> observableStopRinging = RestAPI.INSTANCE.getApi().stopRinging(j, j2, (List<Long>) null);
            Objects.requireNonNull(observableStopRinging);
            new BlockingObservable(observableStopRinging).b();
            String simpleName3 = getClass().getSimpleName();
            Intrinsics3.checkNotNullExpressionValue(simpleName3, "javaClass.simpleName");
            try {
                Logger.d$default(appLog, simpleName3, "Call declined: " + j + '-' + j2, null, 4, null);
                ListenableWorker.Result resultSuccess = ListenableWorker.Result.success();
                Intrinsics3.checkNotNullExpressionValue(resultSuccess, "Result.success()");
                return resultSuccess;
            } catch (Throwable th) {
                th = th;
                AppLog appLog2 = AppLog.g;
                String simpleName4 = CallActionWorker.class.getSimpleName();
                Intrinsics3.checkNotNullExpressionValue(simpleName4, "javaClass.simpleName");
                appLog2.w(simpleName4, "Call declined failure: " + j + '-' + j2, th);
                ListenableWorker.Result resultRetry2 = getRunAttemptCount() < 3 ? ListenableWorker.Result.retry() : ListenableWorker.Result.failure();
                Intrinsics3.checkNotNullExpressionValue(resultRetry2, "if (runAttemptCount < MA…y() else Result.failure()");
                return resultRetry2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
