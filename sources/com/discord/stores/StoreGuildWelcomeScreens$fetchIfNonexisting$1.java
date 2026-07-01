package com.discord.stores;

import android.content.Context;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGuildWelcomeScreens.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildWelcomeScreens$fetchIfNonexisting$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuildWelcomeScreens this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildWelcomeScreens$fetchIfNonexisting$1(StoreGuildWelcomeScreens storeGuildWelcomeScreens, long j) {
        super(0);
        this.this$0 = storeGuildWelcomeScreens;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGuildWelcomeScreens$State storeGuildWelcomeScreens$State = (StoreGuildWelcomeScreens$State) StoreGuildWelcomeScreens.access$getGuildWelcomeScreensState$p(this.this$0).get(Long.valueOf(this.$guildId));
        if ((storeGuildWelcomeScreens$State instanceof StoreGuildWelcomeScreens$State$Loaded) || (storeGuildWelcomeScreens$State instanceof StoreGuildWelcomeScreens$State$Fetching)) {
            return;
        }
        StoreGuildWelcomeScreens.access$handleGuildWelcomeScreenFetchStart(this.this$0, this.$guildId);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn(RestAPI.Companion.getApi().getGuildWelcomeScreen(this.$guildId), false), this.this$0.getClass(), (Context) null, (Function1) null, new StoreGuildWelcomeScreens$fetchIfNonexisting$1$2(this), (Function0) null, (Function0) null, new StoreGuildWelcomeScreens$fetchIfNonexisting$1$1(this), 54, (Object) null);
    }
}
