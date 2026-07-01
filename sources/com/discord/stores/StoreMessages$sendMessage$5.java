package com.discord.stores;

import android.content.Context;
import androidx.work.Constraints$Builder;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.OneTimeWorkRequest$Builder;
import androidx.work.WorkManager;
import com.discord.models.message.Message;
import com.discord.workers.BackgroundMessageSendWorker;
import d0.z.d.m;
import d0.z.d.o;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessages$sendMessage$5 extends o implements Function0<Unit> {
    public final /* synthetic */ Message $message;
    public final /* synthetic */ StoreMessages this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessages$sendMessage$5(StoreMessages storeMessages, Message message) {
        super(0);
        this.this$0 = storeMessages;
        this.$message = message;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreMessages.access$handleLocalMessageCreate(this.this$0, this.$message);
        Context contextAccess$getContext$p = StoreMessages.access$getContext$p(this.this$0);
        m.checkNotNullParameter(contextAccess$getContext$p, "context");
        OneTimeWorkRequest oneTimeWorkRequestBuild = new OneTimeWorkRequest$Builder(BackgroundMessageSendWorker.class).setInitialDelay(120000L, TimeUnit.MILLISECONDS).setConstraints(new Constraints$Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build();
        m.checkNotNullExpressionValue(oneTimeWorkRequestBuild, "OneTimeWorkRequestBuilde…     )\n          .build()");
        WorkManager.getInstance(contextAccess$getContext$p).enqueueUniqueWork("BACKGROUND_MESSAGE_SENDING", ExistingWorkPolicy.REPLACE, oneTimeWorkRequestBuild);
    }
}
