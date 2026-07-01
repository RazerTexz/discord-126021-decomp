package com.discord.widgets.guilds.contextmenu;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildContextMenuViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class GuildContextMenuViewModel$1 extends k implements Function1<GuildContextMenuViewModel$StoreState, Unit> {
    public GuildContextMenuViewModel$1(GuildContextMenuViewModel guildContextMenuViewModel) {
        super(1, guildContextMenuViewModel, GuildContextMenuViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$StoreState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildContextMenuViewModel$StoreState guildContextMenuViewModel$StoreState) {
        invoke2(guildContextMenuViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildContextMenuViewModel$StoreState guildContextMenuViewModel$StoreState) {
        m.checkNotNullParameter(guildContextMenuViewModel$StoreState, "p1");
        GuildContextMenuViewModel.access$handleStoreState((GuildContextMenuViewModel) this.receiver, guildContextMenuViewModel$StoreState);
    }
}
