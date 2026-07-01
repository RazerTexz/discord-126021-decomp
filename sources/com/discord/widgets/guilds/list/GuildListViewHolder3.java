package com.discord.widgets.guilds.list;

import android.view.View;
import com.discord.widgets.guilds.list.GuildListItem;
import com.discord.widgets.guilds.list.GuildListViewHolder;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.guilds.list.GuildListViewHolder$FolderViewHolder$configure$4, reason: use source file name */
/* JADX INFO: compiled from: GuildListViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildListViewHolder3 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ GuildListItem.FolderItem $data;
    public final /* synthetic */ GuildListViewHolder.FolderViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildListViewHolder3(GuildListViewHolder.FolderViewHolder folderViewHolder, GuildListItem.FolderItem folderItem) {
        super(1);
        this.this$0 = folderViewHolder;
        this.$data = folderItem;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        this.this$0.onLongPressed.invoke(this.$data);
    }
}
