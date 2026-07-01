package com.discord.widgets.guildcommunicationdisabled.start;

import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserCommunicationDisabledUpdate;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEnableGuildCommunication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableGuildCommunication$handleEnableGuildCommunication$1 extends o implements Function1<Void, TrackNetworkMetadataReceiver> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ long $userId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEnableGuildCommunication$handleEnableGuildCommunication$1(long j, long j2) {
        super(1);
        this.$guildId = j;
        this.$userId = j2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ TrackNetworkMetadataReceiver invoke(Void r1) {
        return invoke2(r1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final TrackNetworkMetadataReceiver invoke2(Void r7) {
        return new TrackNetworkActionUserCommunicationDisabledUpdate(Long.valueOf(this.$guildId), Long.valueOf(this.$userId), null, null, null);
    }
}
