package com.discord.widgets.guildcommunicationdisabled.start;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DisableGuildCommunicationViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class DisableGuildCommunicationViewModel$1 extends k implements Function1<DisableGuildCommunicationViewModel$StoreState, Unit> {
    public DisableGuildCommunicationViewModel$1(DisableGuildCommunicationViewModel disableGuildCommunicationViewModel) {
        super(1, disableGuildCommunicationViewModel, DisableGuildCommunicationViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel$StoreState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DisableGuildCommunicationViewModel$StoreState disableGuildCommunicationViewModel$StoreState) {
        invoke2(disableGuildCommunicationViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DisableGuildCommunicationViewModel$StoreState disableGuildCommunicationViewModel$StoreState) {
        m.checkNotNullParameter(disableGuildCommunicationViewModel$StoreState, "p1");
        DisableGuildCommunicationViewModel.access$handleStoreState((DisableGuildCommunicationViewModel) this.receiver, disableGuildCommunicationViewModel$StoreState);
    }
}
