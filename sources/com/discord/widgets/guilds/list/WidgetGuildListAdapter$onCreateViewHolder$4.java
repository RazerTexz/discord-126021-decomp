package com.discord.widgets.guilds.list;

import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildListAdapter$onCreateViewHolder$4 extends o implements Function1<GuildListItem$FolderItem, Unit> {
    public final /* synthetic */ View $itemView;
    public final /* synthetic */ WidgetGuildListAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildListAdapter$onCreateViewHolder$4(WidgetGuildListAdapter widgetGuildListAdapter, View view) {
        super(1);
        this.this$0 = widgetGuildListAdapter;
        this.$itemView = view;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildListItem$FolderItem guildListItem$FolderItem) {
        invoke2(guildListItem$FolderItem);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildListItem$FolderItem guildListItem$FolderItem) {
        m.checkNotNullParameter(guildListItem$FolderItem, "item");
        WidgetGuildListAdapter$InteractionListener widgetGuildListAdapter$InteractionListenerAccess$getInteractionListener$p = WidgetGuildListAdapter.access$getInteractionListener$p(this.this$0);
        View view = this.$itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        widgetGuildListAdapter$InteractionListenerAccess$getInteractionListener$p.onItemClicked(view, guildListItem$FolderItem);
    }
}
