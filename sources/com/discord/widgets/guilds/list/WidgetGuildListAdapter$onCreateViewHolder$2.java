package com.discord.widgets.guilds.list;

import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildListAdapter$onCreateViewHolder$2 extends o implements Function1<GuildListItem$GuildItem, Unit> {
    public final /* synthetic */ View $itemView;
    public final /* synthetic */ WidgetGuildListAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildListAdapter$onCreateViewHolder$2(WidgetGuildListAdapter widgetGuildListAdapter, View view) {
        super(1);
        this.this$0 = widgetGuildListAdapter;
        this.$itemView = view;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildListItem$GuildItem guildListItem$GuildItem) {
        invoke2(guildListItem$GuildItem);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildListItem$GuildItem guildListItem$GuildItem) {
        m.checkNotNullParameter(guildListItem$GuildItem, "item");
        WidgetGuildListAdapter$InteractionListener widgetGuildListAdapter$InteractionListenerAccess$getInteractionListener$p = WidgetGuildListAdapter.access$getInteractionListener$p(this.this$0);
        View view = this.$itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        widgetGuildListAdapter$InteractionListenerAccess$getInteractionListener$p.onItemClicked(view, guildListItem$GuildItem);
    }
}
