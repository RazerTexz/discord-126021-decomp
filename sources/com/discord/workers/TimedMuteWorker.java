package com.discord.workers;

import android.content.Context;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelMuteConfig;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreStream;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.io.NetworkUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import d0.z.d.Intrinsics3;
import j0.m.BlockingObservable;
import java.util.Objects;
import rx.Observable;

/* JADX INFO: compiled from: TimedMuteWorker.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TimedMuteWorker extends Worker {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public Clock clock;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimedMuteWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(workerParameters, "params");
        this.clock = ClockFactory.get();
    }

    /* JADX WARN: Code duplicated, block: B:35:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:36:0x01ae  */
    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        String str;
        long j;
        ListenableWorker.Result resultFailure;
        AppLog appLog = AppLog.g;
        String simpleName = TimedMuteWorker.class.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        StringBuilder sb = new StringBuilder();
        sb.append("Starting for [");
        Data inputData = getInputData();
        Intrinsics3.checkNotNullExpressionValue(inputData, "inputData");
        sb.append(inputData.getKeyValueMap());
        sb.append(']');
        Logger.i$default(appLog, simpleName, sb.toString(), null, 4, null);
        NotificationClient notificationClient = NotificationClient.INSTANCE;
        if (!notificationClient.isAuthed()) {
            String simpleName2 = TimedMuteWorker.class.getSimpleName();
            Intrinsics3.checkNotNullExpressionValue(simpleName2, "javaClass.simpleName");
            Logger.d$default(appLog, simpleName2, "Not authenticated. Aborting job request.", null, 4, null);
            ListenableWorker.Result resultFailure2 = ListenableWorker.Result.failure();
            Intrinsics3.checkNotNullExpressionValue(resultFailure2, "Result.failure()");
            return resultFailure2;
        }
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics3.checkNotNullExpressionValue(applicationContext, "applicationContext");
        if (!NetworkUtils.isDeviceConnected$default(networkUtils, applicationContext, null, null, 6, null)) {
            ListenableWorker.Result resultRetry = ListenableWorker.Result.retry();
            Intrinsics3.checkNotNullExpressionValue(resultRetry, "Result.retry()");
            return resultRetry;
        }
        long j2 = getInputData().getLong("com.discord.intent.extra.EXTRA_GUILD_ID", -1L);
        long j3 = getInputData().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L);
        long j4 = getInputData().getLong("com.discord.intent.extra.EXTRA_UNTIL_TIMESTAMP_MS", 0L);
        if (j2 == -1 || j3 == -1) {
            ListenableWorker.Result resultFailure3 = ListenableWorker.Result.failure();
            Intrinsics3.checkNotNullExpressionValue(resultFailure3, "Result.failure()");
            return resultFailure3;
        }
        if (this.clock.currentTimeMillis() > j4) {
            ListenableWorker.Result resultSuccess = ListenableWorker.Result.success();
            Intrinsics3.checkNotNullExpressionValue(resultSuccess, "Result.success()");
            return resultSuccess;
        }
        String uTCDateTime$default = TimeUtils.toUTCDateTime$default(Long.valueOf(j4), null, 2, null);
        try {
            Observable<ModelNotificationSettings> observableUpdateUserGuildSettings = RestAPI.INSTANCE.getApi().updateUserGuildSettings(j2, new RestAPIParams.UserGuildSettings(j3, new RestAPIParams.UserGuildSettings.ChannelOverride(Boolean.TRUE, new ModelMuteConfig(uTCDateTime$default), null, null, 12, null)));
            Objects.requireNonNull(observableUpdateUserGuildSettings);
            ModelNotificationSettings modelNotificationSettings = (ModelNotificationSettings) new BlockingObservable(observableUpdateUserGuildSettings).b();
            String simpleName3 = getClass().getSimpleName();
            Intrinsics3.checkNotNullExpressionValue(simpleName3, "javaClass.simpleName");
            str = uTCDateTime$default;
            try {
                Logger.d$default(appLog, simpleName3, "Muted: " + j2 + '-' + j3 + " until " + uTCDateTime$default, null, 4, null);
                j = j3;
                try {
                    NotificationClient.clear$default(notificationClient, j, getApplicationContext(), false, 4, null);
                    StoreAnalytics analytics = StoreStream.INSTANCE.getAnalytics();
                    Intrinsics3.checkNotNullExpressionValue(modelNotificationSettings, "notifSettings");
                    analytics.onNotificationSettingsUpdated(modelNotificationSettings, Long.valueOf(j));
                    ListenableWorker.Result resultSuccess2 = ListenableWorker.Result.success();
                    Intrinsics3.checkNotNullExpressionValue(resultSuccess2, "Result.success()");
                    return resultSuccess2;
                } catch (Throwable th) {
                    th = th;
                    AppLog appLog2 = AppLog.g;
                    String simpleName4 = TimedMuteWorker.class.getSimpleName();
                    Intrinsics3.checkNotNullExpressionValue(simpleName4, "javaClass.simpleName");
                    appLog2.w(simpleName4, "Mute failure: " + j2 + '-' + j + " until " + str, th);
                    if (getRunAttemptCount() < 3) {
                        resultFailure = ListenableWorker.Result.retry();
                    } else {
                        resultFailure = ListenableWorker.Result.failure();
                    }
                    Intrinsics3.checkNotNullExpressionValue(resultFailure, "if (runAttemptCount < MA…y() else Result.failure()");
                    return resultFailure;
                }
            } catch (Throwable th2) {
                th = th2;
                j = j3;
                AppLog appLog3 = AppLog.g;
                String simpleName5 = TimedMuteWorker.class.getSimpleName();
                Intrinsics3.checkNotNullExpressionValue(simpleName5, "javaClass.simpleName");
                appLog3.w(simpleName5, "Mute failure: " + j2 + '-' + j + " until " + str, th);
                if (getRunAttemptCount() < 3) {
                    resultFailure = ListenableWorker.Result.retry();
                } else {
                    resultFailure = ListenableWorker.Result.failure();
                }
                Intrinsics3.checkNotNullExpressionValue(resultFailure, "if (runAttemptCount < MA…y() else Result.failure()");
                return resultFailure;
            }
        } catch (Throwable th3) {
            th = th3;
            str = uTCDateTime$default;
        }
    }
}
