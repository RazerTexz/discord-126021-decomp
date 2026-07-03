package com.discord.widgets.guilds.list;

import android.view.View;
import com.discord.widgets.guilds.list.GuildListItem;
import com.discord.widgets.guilds.list.GuildListViewHolder;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildListViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildListViewHolder$PrivateChannelViewHolder$configure$2 extends AbstractC12240o implements Function1<View, Unit> {
    public final /* synthetic */ GuildListItem.PrivateChannelItem $data;
    public final /* synthetic */ GuildListViewHolder.PrivateChannelViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildListViewHolder$PrivateChannelViewHolder$configure$2(GuildListViewHolder.PrivateChannelViewHolder privateChannelViewHolder, GuildListItem.PrivateChannelItem privateChannelItem) {
        super(1);
        this.this$0 = privateChannelViewHolder;
        this.$data = privateChannelItem;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        C12238m.checkNotNullParameter(view, "it");
        this.this$0.onLongPressed.invoke(this.$data);
    }
}
