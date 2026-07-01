package com.discord.widgets.guilds.list;

import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildListViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildListViewHolder$FolderViewHolder$configure$4 extends o implements Function1<View, Unit> {
    public final /* synthetic */ GuildListItem$FolderItem $data;
    public final /* synthetic */ GuildListViewHolder$FolderViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildListViewHolder$FolderViewHolder$configure$4(GuildListViewHolder$FolderViewHolder guildListViewHolder$FolderViewHolder, GuildListItem$FolderItem guildListItem$FolderItem) {
        super(1);
        this.this$0 = guildListViewHolder$FolderViewHolder;
        this.$data = guildListItem$FolderItem;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        GuildListViewHolder$FolderViewHolder.access$getOnLongPressed$p(this.this$0).invoke(this.$data);
    }
}
