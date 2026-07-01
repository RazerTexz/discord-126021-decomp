package com.discord.widgets.guilds.create;

import com.discord.analytics.generated.events.network_action.TrackNetworkActionGuildCreate;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.guild.Guild;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildCreateViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildCreateViewModel$createGuild$createGuildRequestObservable$1 extends o implements Function1<Guild, TrackNetworkMetadataReceiver> {
    public final /* synthetic */ WidgetGuildCreateViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildCreateViewModel$createGuild$createGuildRequestObservable$1(WidgetGuildCreateViewModel widgetGuildCreateViewModel) {
        super(1);
        this.this$0 = widgetGuildCreateViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ TrackNetworkMetadataReceiver invoke(Guild guild) {
        return invoke2(guild);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final TrackNetworkMetadataReceiver invoke2(Guild guild) {
        return new TrackNetworkActionGuildCreate(WidgetGuildCreateViewModel.access$getStockGuildTemplate$p(this.this$0).name(), null);
    }
}
