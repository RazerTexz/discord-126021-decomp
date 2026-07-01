package com.discord.workers;

import android.content.Context;
import androidx.work.Data;
import androidx.work.ListenableWorker$Result;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.discord.api.message.Message;
import com.discord.app.AppLog;
import com.discord.restapi.RestAPIParams$Message;
import com.discord.stores.StoreStream;
import com.discord.utilities.fcm.NotificationCache;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.fcm.NotificationData;
import com.discord.utilities.fcm.NotificationData$DisplayPayload;
import com.discord.utilities.fcm.NotificationRenderer;
import com.discord.utilities.io.NetworkUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.u;
import d0.z.d.m;
import j0.m.a;
import java.util.List;
import java.util.Objects;
import rx.Observable;

/* JADX INFO: compiled from: MessageSendWorker.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MessageSendWorker extends Worker {
    public static final MessageSendWorker$a a = new MessageSendWorker$a(null);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageSendWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(workerParameters, "params");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v6, types: [rx.Observable] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.work.Worker
    public ListenableWorker$Result doWork() {
        boolean zRestSubscribeOn;
        AppLog appLog = AppLog.g;
        String simpleName = MessageSendWorker.class.getSimpleName();
        m.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        StringBuilder sb = new StringBuilder();
        sb.append("Starting for [");
        Data inputData = getInputData();
        m.checkNotNullExpressionValue(inputData, "inputData");
        sb.append(inputData.getKeyValueMap());
        sb.append(']');
        Logger.i$default(appLog, simpleName, sb.toString(), null, 4, null);
        NotificationClient notificationClient = NotificationClient.INSTANCE;
        if (!notificationClient.isAuthed()) {
            String simpleName2 = MessageSendWorker.class.getSimpleName();
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
            if (getRunAttemptCount() < 3) {
                ListenableWorker$Result listenableWorker$ResultRetry = ListenableWorker$Result.retry();
                m.checkNotNullExpressionValue(listenableWorker$ResultRetry, "Result.retry()");
                return listenableWorker$ResultRetry;
            }
            ListenableWorker$Result listenableWorker$ResultFailure2 = ListenableWorker$Result.failure();
            m.checkNotNullExpressionValue(listenableWorker$ResultFailure2, "Result.failure()");
            return listenableWorker$ResultFailure2;
        }
        long j = getInputData().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L);
        String string = getInputData().getString("com.discord.intent.extra.EXTRA_CHANNEL_NAME");
        if (string == null) {
            string = "";
        }
        String str = string;
        String string2 = getInputData().getString("MESSAGE_CONTENT");
        if (string2 == null) {
            ListenableWorker$Result listenableWorker$ResultSuccess = ListenableWorker$Result.success();
            m.checkNotNullExpressionValue(listenableWorker$ResultSuccess, "Result.success()");
            return listenableWorker$ResultSuccess;
        }
        String string3 = getInputData().getString("com.discord.intent.extra.EXTRA_MESSAGE_ID");
        long j2 = getInputData().getLong("com.discord.intent.extra.EXTRA_STICKER_ID", -1L);
        try {
            zRestSubscribeOn = ObservableExtensionsKt.restSubscribeOn(RestAPI.Companion.getApi().sendMessage(j, new RestAPIParams$Message(string2, string3, null, null, j2 != -1 ? d0.t.m.listOf(Long.valueOf(j2)) : null, null, null, null, null, 492, null)), false);
            Observable observableTakeSingleUntilTimeout$default = ObservableExtensionsKt.takeSingleUntilTimeout$default(zRestSubscribeOn, 0L, false, 3, null);
            Objects.requireNonNull(observableTakeSingleUntilTimeout$default);
            Message message = (Message) new a(observableTakeSingleUntilTimeout$default).b();
            NotificationData$DisplayPayload notificationData$DisplayPayload = NotificationCache.INSTANCE.get(j);
            try {
                if (notificationData$DisplayPayload == null) {
                    ListenableWorker$Result listenableWorker$ResultFailure3 = ListenableWorker$Result.failure();
                    m.checkNotNullExpressionValue(listenableWorker$ResultFailure3, "Result.failure()");
                    return listenableWorker$ResultFailure3;
                }
                NotificationData notificationData = (NotificationData) u.lastOrNull((List) notificationData$DisplayPayload.getExtras());
                if (notificationData == null) {
                    ListenableWorker$Result listenableWorker$ResultFailure4 = ListenableWorker$Result.failure();
                    m.checkNotNullExpressionValue(listenableWorker$ResultFailure4, "Result.failure()");
                    return listenableWorker$ResultFailure4;
                }
                m.checkNotNullExpressionValue(message, "message");
                NotificationData notificationDataCopyForDirectReply = notificationData.copyForDirectReply(message);
                NotificationRenderer notificationRenderer = NotificationRenderer.INSTANCE;
                Context applicationContext2 = getApplicationContext();
                m.checkNotNullExpressionValue(applicationContext2, "applicationContext");
                notificationRenderer.display(applicationContext2, notificationDataCopyForDirectReply, notificationClient.getSettings$app_productionGoogleRelease());
                String simpleName3 = getClass().getSimpleName();
                m.checkNotNullExpressionValue(simpleName3, "javaClass.simpleName");
                Logger.d$default(appLog, simpleName3, "Direct reply: " + j + '-' + message.getId(), null, 4, null);
                StoreStream.Companion.getAnalytics().ackMessage(j);
                ListenableWorker$Result listenableWorker$ResultSuccess2 = ListenableWorker$Result.success();
                m.checkNotNullExpressionValue(listenableWorker$ResultSuccess2, "Result.success()");
                return listenableWorker$ResultSuccess2;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            zRestSubscribeOn = 0;
        }
        AppLog appLog2 = AppLog.g;
        String simpleName4 = MessageSendWorker.class.getSimpleName();
        m.checkNotNullExpressionValue(simpleName4, "javaClass.simpleName");
        appLog2.w(simpleName4, "Direct reply failure: " + j, th);
        NotificationCache.INSTANCE.remove(j, zRestSubscribeOn, new MessageSendWorker$b(this, j, str));
        ListenableWorker$Result listenableWorker$ResultFailure5 = ListenableWorker$Result.failure();
        m.checkNotNullExpressionValue(listenableWorker$ResultFailure5, "Result.failure()");
        return listenableWorker$ResultFailure5;
    }
}
