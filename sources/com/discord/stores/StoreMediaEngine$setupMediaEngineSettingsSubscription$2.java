package com.discord.stores;

import com.discord.app.AppLog;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMediaEngine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMediaEngine$setupMediaEngineSettingsSubscription$2 extends o implements Function1<Error, Unit> {
    public static final StoreMediaEngine$setupMediaEngineSettingsSubscription$2 INSTANCE = new StoreMediaEngine$setupMediaEngineSettingsSubscription$2();

    public StoreMediaEngine$setupMediaEngineSettingsSubscription$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "error");
        Logger.e$default(AppLog.g, "handleVoiceConfigChanged", error.getThrowable(), null, 4, null);
    }
}
