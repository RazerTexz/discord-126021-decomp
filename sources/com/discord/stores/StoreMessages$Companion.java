package com.discord.stores;

import android.content.Context;
import androidx.work.Operation;
import androidx.work.WorkManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessages$Companion {
    private StoreMessages$Companion() {
    }

    public static final /* synthetic */ Operation access$cancelBackgroundSendingWork(StoreMessages$Companion storeMessages$Companion, Context context) {
        return storeMessages$Companion.cancelBackgroundSendingWork(context);
    }

    private final Operation cancelBackgroundSendingWork(Context context) {
        Operation operationCancelUniqueWork = WorkManager.getInstance(context).cancelUniqueWork("BACKGROUND_MESSAGE_SENDING");
        m.checkNotNullExpressionValue(operationCancelUniqueWork, "WorkManager.getInstance(…dWorker.UNIQUE_WORK_NAME)");
        return operationCancelUniqueWork;
    }

    public /* synthetic */ StoreMessages$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
