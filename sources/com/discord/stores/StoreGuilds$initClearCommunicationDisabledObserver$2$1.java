package com.discord.stores;

import com.discord.models.member.GuildMember;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuilds.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuilds$initClearCommunicationDisabledObserver$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ List $members;
    public final /* synthetic */ StoreGuilds$initClearCommunicationDisabledObserver$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuilds$initClearCommunicationDisabledObserver$2$1(StoreGuilds$initClearCommunicationDisabledObserver$2 storeGuilds$initClearCommunicationDisabledObserver$2, List list) {
        super(0);
        this.this$0 = storeGuilds$initClearCommunicationDisabledObserver$2;
        this.$members = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        List<GuildMember> list = this.$members;
        m.checkNotNullExpressionValue(list, "members");
        for (GuildMember guildMember : list) {
            StoreGuilds.access$handleGuildMemberCommunicationEnabledInternal(this.this$0.this$0, guildMember.getGuildId(), guildMember.getUserId());
        }
    }
}
