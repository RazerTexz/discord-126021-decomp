package com.discord.stores;

import com.discord.models.member.GuildMember;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGuilds.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuilds$initClearCommunicationDisabledObserver$2 extends o implements Function1<List<? extends GuildMember>, Unit> {
    public final /* synthetic */ StoreGuilds this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuilds$initClearCommunicationDisabledObserver$2(StoreGuilds storeGuilds) {
        super(1);
        this.this$0 = storeGuilds;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends GuildMember> list) {
        invoke2((List<GuildMember>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<GuildMember> list) {
        StoreGuilds.access$getDispatcher$p(this.this$0).schedule(new StoreGuilds$initClearCommunicationDisabledObserver$2$1(this, list));
    }
}
