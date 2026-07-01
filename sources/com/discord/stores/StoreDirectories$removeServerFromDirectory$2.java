package com.discord.stores;

import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.Success;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreDirectories.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreDirectories$removeServerFromDirectory$2 extends o implements Function1<RestCallState<? extends DirectoryEntryGuild>, Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreDirectories this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreDirectories$removeServerFromDirectory$2(StoreDirectories storeDirectories, long j, long j2) {
        super(1);
        this.this$0 = storeDirectories;
        this.$channelId = j;
        this.$guildId = j2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends DirectoryEntryGuild> restCallState) {
        invoke2((RestCallState<DirectoryEntryGuild>) restCallState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RestCallState<DirectoryEntryGuild> restCallState) {
        m.checkNotNullParameter(restCallState, "request");
        if (restCallState instanceof Success) {
            StoreDirectories.access$getDispatcher$p(this.this$0).schedule(new StoreDirectories$removeServerFromDirectory$2$1(this));
        }
    }
}
