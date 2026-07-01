package com.discord.widgets.guildcommunicationdisabled.start;

import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserCommunicationDisabledUpdate;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DisableGuildCommunicationViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DisableGuildCommunicationViewModel$onDisableCommunicationConfirm$1 extends o implements Function1<Void, TrackNetworkMetadataReceiver> {
    public final /* synthetic */ long $disabledUntilTimestamp;
    public final /* synthetic */ long $durationS;
    public final /* synthetic */ String $reason;
    public final /* synthetic */ DisableGuildCommunicationViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisableGuildCommunicationViewModel$onDisableCommunicationConfirm$1(DisableGuildCommunicationViewModel disableGuildCommunicationViewModel, long j, long j2, String str) {
        super(1);
        this.this$0 = disableGuildCommunicationViewModel;
        this.$durationS = j;
        this.$disabledUntilTimestamp = j2;
        this.$reason = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ TrackNetworkMetadataReceiver invoke(Void r1) {
        return invoke2(r1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final TrackNetworkMetadataReceiver invoke2(Void r7) {
        return new TrackNetworkActionUserCommunicationDisabledUpdate(Long.valueOf(DisableGuildCommunicationViewModel.access$getGuildId$p(this.this$0)), Long.valueOf(DisableGuildCommunicationViewModel.access$getUserId$p(this.this$0)), Float.valueOf(this.$durationS), this.$reason, Long.valueOf(this.$disabledUntilTimestamp));
    }
}
