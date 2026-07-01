package com.discord.stores;

import android.content.Context;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGuildProfiles.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildProfiles$fetchGuildProfile$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuildProfiles this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildProfiles$fetchGuildProfile$1(StoreGuildProfiles storeGuildProfiles, long j) {
        super(0);
        this.this$0 = storeGuildProfiles;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGuildProfiles$GuildProfileData storeGuildProfiles$GuildProfileData = (StoreGuildProfiles$GuildProfileData) StoreGuildProfiles.access$getGuildProfilesState$p(this.this$0).get(Long.valueOf(this.$guildId));
        if ((storeGuildProfiles$GuildProfileData != null ? storeGuildProfiles$GuildProfileData.getFetchState() : null) == StoreGuildProfiles$FetchStates.FETCHING) {
            return;
        }
        StoreGuildProfiles.access$handleGuildProfileFetchStart(this.this$0, this.$guildId);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().getGuildPreview(this.$guildId), false, 1, null), this.this$0.getClass(), (Context) null, (Function1) null, new StoreGuildProfiles$fetchGuildProfile$1$2(this), (Function0) null, (Function0) null, new StoreGuildProfiles$fetchGuildProfile$1$1(this), 54, (Object) null);
    }
}
