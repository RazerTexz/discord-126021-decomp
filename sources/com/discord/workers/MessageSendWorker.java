package com.discord.workers;

import android.content.Context;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.discord.api.message.Message;
import com.discord.app.AppLog;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.utilities.fcm.NotificationCache;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.fcm.NotificationData;
import com.discord.utilities.fcm.NotificationRenderer;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p500io.NetworkUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p650m.C12756a;
import p658rx.Observable;

/* JADX INFO: compiled from: MessageSendWorker.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MessageSendWorker extends Worker {

    /* JADX INFO: renamed from: com.discord.workers.MessageSendWorker$b */
    /* JADX INFO: compiled from: MessageSendWorker.kt */
    public static final class C10619b extends AbstractC12240o implements Function1<Integer, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ String $channelName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10619b(long j, String str) {
            super(1);
            this.$channelId = j;
            this.$channelName = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            int iIntValue = num.intValue();
            NotificationRenderer notificationRenderer = NotificationRenderer.INSTANCE;
            Context applicationContext = MessageSendWorker.this.getApplicationContext();
            C12238m.checkNotNullExpressionValue(applicationContext, "applicationContext");
            notificationRenderer.displaySent(applicationContext, this.$channelId, this.$channelName, false, iIntValue);
            return Unit.f27425a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageSendWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(workerParameters, "params");
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
    public ListenableWorker.Result doWork() {
        boolean zRestSubscribeOn;
        AppLog appLog = AppLog.f14950g;
        String simpleName = MessageSendWorker.class.getSimpleName();
        C12238m.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        StringBuilder sb = new StringBuilder();
        sb.append("Starting for [");
        Data inputData = getInputData();
        C12238m.checkNotNullExpressionValue(inputData, "inputData");
        sb.append(inputData.getKeyValueMap());
        sb.append(']');
        Logger.i$default(appLog, simpleName, sb.toString(), null, 4, null);
        NotificationClient notificationClient = NotificationClient.INSTANCE;
        if (!notificationClient.isAuthed()) {
            String simpleName2 = MessageSendWorker.class.getSimpleName();
            C12238m.checkNotNullExpressionValue(simpleName2, "javaClass.simpleName");
            Logger.d$default(appLog, simpleName2, "Not authenticated. Aborting job request.", null, 4, null);
            ListenableWorker.Result resultFailure = ListenableWorker.Result.failure();
            C12238m.checkNotNullExpressionValue(resultFailure, "Result.failure()");
            return resultFailure;
        }
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        Context applicationContext = getApplicationContext();
        C12238m.checkNotNullExpressionValue(applicationContext, "applicationContext");
        if (!NetworkUtils.isDeviceConnected$default(networkUtils, applicationContext, null, null, 6, null)) {
            if (getRunAttemptCount() < 3) {
                ListenableWorker.Result resultRetry = ListenableWorker.Result.retry();
                C12238m.checkNotNullExpressionValue(resultRetry, "Result.retry()");
                return resultRetry;
            }
            ListenableWorker.Result resultFailure2 = ListenableWorker.Result.failure();
            C12238m.checkNotNullExpressionValue(resultFailure2, "Result.failure()");
            return resultFailure2;
        }
        long j = getInputData().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L);
        String string = getInputData().getString("com.discord.intent.extra.EXTRA_CHANNEL_NAME");
        if (string == null) {
            string = "";
        }
        String str = string;
        String string2 = getInputData().getString("MESSAGE_CONTENT");
        if (string2 == null) {
            ListenableWorker.Result resultSuccess = ListenableWorker.Result.success();
            C12238m.checkNotNullExpressionValue(resultSuccess, "Result.success()");
            return resultSuccess;
        }
        String string3 = getInputData().getString("com.discord.intent.extra.EXTRA_MESSAGE_ID");
        long j2 = getInputData().getLong("com.discord.intent.extra.EXTRA_STICKER_ID", -1L);
        try {
            zRestSubscribeOn = ObservableExtensionsKt.restSubscribeOn(RestAPI.INSTANCE.getApi().sendMessage(j, new RestAPIParams.Message(string2, string3, null, null, j2 != -1 ? C12145m.listOf(Long.valueOf(j2)) : null, null, null, null, null, 492, null)), false);
            Observable observableTakeSingleUntilTimeout$default = ObservableExtensionsKt.takeSingleUntilTimeout$default(zRestSubscribeOn, 0L, false, 3, null);
            Objects.requireNonNull(observableTakeSingleUntilTimeout$default);
            Message message = (Message) new C12756a(observableTakeSingleUntilTimeout$default).m10860b();
            NotificationData.DisplayPayload displayPayload = NotificationCache.INSTANCE.get(j);
            try {
                if (displayPayload == null) {
                    ListenableWorker.Result resultFailure3 = ListenableWorker.Result.failure();
                    C12238m.checkNotNullExpressionValue(resultFailure3, "Result.failure()");
                    return resultFailure3;
                }
                NotificationData notificationData = (NotificationData) C12163u.lastOrNull((List) displayPayload.getExtras());
                if (notificationData == null) {
                    ListenableWorker.Result resultFailure4 = ListenableWorker.Result.failure();
                    C12238m.checkNotNullExpressionValue(resultFailure4, "Result.failure()");
                    return resultFailure4;
                }
                C12238m.checkNotNullExpressionValue(message, "message");
                NotificationData notificationDataCopyForDirectReply = notificationData.copyForDirectReply(message);
                NotificationRenderer notificationRenderer = NotificationRenderer.INSTANCE;
                Context applicationContext2 = getApplicationContext();
                C12238m.checkNotNullExpressionValue(applicationContext2, "applicationContext");
                notificationRenderer.display(applicationContext2, notificationDataCopyForDirectReply, notificationClient.getSettings$app_productionGoogleRelease());
                String simpleName3 = getClass().getSimpleName();
                C12238m.checkNotNullExpressionValue(simpleName3, "javaClass.simpleName");
                Logger.d$default(appLog, simpleName3, "Direct reply: " + j + '-' + message.getId(), null, 4, null);
                StoreStream.INSTANCE.getAnalytics().ackMessage(j);
                ListenableWorker.Result resultSuccess2 = ListenableWorker.Result.success();
                C12238m.checkNotNullExpressionValue(resultSuccess2, "Result.success()");
                return resultSuccess2;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            zRestSubscribeOn = 0;
        }
        AppLog appLog2 = AppLog.f14950g;
        String simpleName4 = MessageSendWorker.class.getSimpleName();
        C12238m.checkNotNullExpressionValue(simpleName4, "javaClass.simpleName");
        appLog2.mo8369w(simpleName4, "Direct reply failure: " + j, th);
        NotificationCache.INSTANCE.remove(j, zRestSubscribeOn, new C10619b(j, str));
        ListenableWorker.Result resultFailure5 = ListenableWorker.Result.failure();
        C12238m.checkNotNullExpressionValue(resultFailure5, "Result.failure()");
        return resultFailure5;
    }
}
