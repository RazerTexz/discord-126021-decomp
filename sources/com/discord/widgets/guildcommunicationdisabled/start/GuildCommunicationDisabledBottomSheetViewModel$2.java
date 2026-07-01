package com.discord.widgets.guildcommunicationdisabled.start;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildCommunicationDisabledBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class GuildCommunicationDisabledBottomSheetViewModel$2 extends k implements Function1<GuildCommunicationDisabledBottomSheetViewModel$StoreState, Unit> {
    public GuildCommunicationDisabledBottomSheetViewModel$2(GuildCommunicationDisabledBottomSheetViewModel guildCommunicationDisabledBottomSheetViewModel) {
        super(1, guildCommunicationDisabledBottomSheetViewModel, GuildCommunicationDisabledBottomSheetViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/guildcommunicationdisabled/start/GuildCommunicationDisabledBottomSheetViewModel$StoreState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildCommunicationDisabledBottomSheetViewModel$StoreState guildCommunicationDisabledBottomSheetViewModel$StoreState) {
        invoke2(guildCommunicationDisabledBottomSheetViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildCommunicationDisabledBottomSheetViewModel$StoreState guildCommunicationDisabledBottomSheetViewModel$StoreState) {
        m.checkNotNullParameter(guildCommunicationDisabledBottomSheetViewModel$StoreState, "p1");
        GuildCommunicationDisabledBottomSheetViewModel.access$handleStoreState((GuildCommunicationDisabledBottomSheetViewModel) this.receiver, guildCommunicationDisabledBottomSheetViewModel$StoreState);
    }
}
