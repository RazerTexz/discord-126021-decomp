package com.discord.widgets.hubs;

import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.stores.utilities.RestCallState;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubDescriptionViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDescriptionViewModel$addServer$2 extends o implements Function1<RestCallState<? extends DirectoryEntryGuild>, Unit> {
    public final /* synthetic */ HubDescriptionState $state;
    public final /* synthetic */ WidgetHubDescriptionViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDescriptionViewModel$addServer$2(WidgetHubDescriptionViewModel widgetHubDescriptionViewModel, HubDescriptionState hubDescriptionState) {
        super(1);
        this.this$0 = widgetHubDescriptionViewModel;
        this.$state = hubDescriptionState;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends DirectoryEntryGuild> restCallState) {
        invoke2((RestCallState<DirectoryEntryGuild>) restCallState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RestCallState<DirectoryEntryGuild> restCallState) {
        m.checkNotNullParameter(restCallState, "it");
        WidgetHubDescriptionViewModel.access$updateViewState(this.this$0, HubDescriptionState.copy$default(this.$state, null, null, null, restCallState, 7, null));
    }
}
