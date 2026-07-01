package com.discord.stores;

import b.d.b.a.a;
import com.discord.app.AppLog;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreNotices.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNotices$init$3 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ StoreNotices this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreNotices$init$3(StoreNotices storeNotices) {
        super(1);
        this.this$0 = storeNotices;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        AppLog appLog = AppLog.g;
        StringBuilder sbU = a.U("Could not process next notice: ");
        sbU.append(StoreNotices.access$getNoticeQueue$p(this.this$0));
        Logger.e$default(appLog, sbU.toString(), error.getThrowable(), null, 4, null);
    }
}
