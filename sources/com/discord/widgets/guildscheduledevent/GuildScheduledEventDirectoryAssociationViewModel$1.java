package com.discord.widgets.guildscheduledevent;

import com.discord.api.guildscheduledevent.GuildScheduledEventBroadcast;
import com.discord.stores.utilities.RestCallState;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildScheduledEventDirectoryAssociationViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventDirectoryAssociationViewModel$1 extends o implements Function1<RestCallState<? extends GuildScheduledEventBroadcast>, Unit> {
    public final /* synthetic */ GuildScheduledEventDirectoryAssociationViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDirectoryAssociationViewModel$1(GuildScheduledEventDirectoryAssociationViewModel guildScheduledEventDirectoryAssociationViewModel) {
        super(1);
        this.this$0 = guildScheduledEventDirectoryAssociationViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends GuildScheduledEventBroadcast> restCallState) {
        invoke2((RestCallState<GuildScheduledEventBroadcast>) restCallState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RestCallState<GuildScheduledEventBroadcast> restCallState) {
        m.checkNotNullParameter(restCallState, "async");
        GuildScheduledEventDirectoryAssociationState guildScheduledEventDirectoryAssociationStateAccess$getViewState$p = GuildScheduledEventDirectoryAssociationViewModel.access$getViewState$p(this.this$0);
        if (guildScheduledEventDirectoryAssociationStateAccess$getViewState$p != null) {
            GuildScheduledEventDirectoryAssociationViewModel.access$updateViewState(this.this$0, guildScheduledEventDirectoryAssociationStateAccess$getViewState$p.copy(restCallState));
        }
    }
}
