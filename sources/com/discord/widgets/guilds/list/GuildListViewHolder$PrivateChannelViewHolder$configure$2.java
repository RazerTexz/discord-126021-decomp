package com.discord.widgets.guilds.list;

import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildListViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildListViewHolder$PrivateChannelViewHolder$configure$2 extends o implements Function1<View, Unit> {
    public final /* synthetic */ GuildListItem$PrivateChannelItem $data;
    public final /* synthetic */ GuildListViewHolder$PrivateChannelViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildListViewHolder$PrivateChannelViewHolder$configure$2(GuildListViewHolder$PrivateChannelViewHolder guildListViewHolder$PrivateChannelViewHolder, GuildListItem$PrivateChannelItem guildListItem$PrivateChannelItem) {
        super(1);
        this.this$0 = guildListViewHolder$PrivateChannelViewHolder;
        this.$data = guildListItem$PrivateChannelItem;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        GuildListViewHolder$PrivateChannelViewHolder.access$getOnLongPressed$p(this.this$0).invoke(this.$data);
    }
}
