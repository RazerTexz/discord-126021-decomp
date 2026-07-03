package com.discord.widgets.guilds.create;

import com.discord.analytics.generated.events.network_action.TrackNetworkActionGuildCreate;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.guild.Guild;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.widgets.guilds.create.WidgetGuildCreateViewModel$createGuild$createGuildRequestObservable$1 */
/* JADX INFO: compiled from: WidgetGuildCreateViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8616xe6641ce0 extends AbstractC12240o implements Function1<Guild, TrackNetworkMetadataReceiver> {
    public final /* synthetic */ WidgetGuildCreateViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8616xe6641ce0(WidgetGuildCreateViewModel widgetGuildCreateViewModel) {
        super(1);
        this.this$0 = widgetGuildCreateViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public final TrackNetworkMetadataReceiver invoke(Guild guild) {
        return new TrackNetworkActionGuildCreate(this.this$0.stockGuildTemplate.name(), null);
    }
}
