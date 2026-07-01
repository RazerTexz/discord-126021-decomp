package com.discord.stores;

import com.discord.analytics.generated.events.network_action.TrackNetworkActionInviteResolve;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.api.user.User;
import com.discord.models.domain.ModelInvite;
import com.discord.restapi.RestAPIAbortCodes;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreInstantInvites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreInstantInvites$fetchInviteIfNotLoaded$1$1 extends o implements Function1<ModelInvite, TrackNetworkMetadataReceiver> {
    public final /* synthetic */ StoreInstantInvites$fetchInviteIfNotLoaded$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreInstantInvites$fetchInviteIfNotLoaded$1$1(StoreInstantInvites$fetchInviteIfNotLoaded$1 storeInstantInvites$fetchInviteIfNotLoaded$1) {
        super(1);
        this.this$0 = storeInstantInvites$fetchInviteIfNotLoaded$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ TrackNetworkMetadataReceiver invoke(ModelInvite modelInvite) {
        return invoke2(modelInvite);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final TrackNetworkMetadataReceiver invoke2(ModelInvite modelInvite) {
        User inviter;
        Channel channel;
        Channel channel2;
        Guild guild;
        StoreInstantInvites$fetchInviteIfNotLoaded$1 storeInstantInvites$fetchInviteIfNotLoaded$1 = this.this$0;
        return new TrackNetworkActionInviteResolve(storeInstantInvites$fetchInviteIfNotLoaded$1.$inviteResolved, storeInstantInvites$fetchInviteIfNotLoaded$1.$inviteCode, Boolean.valueOf(StoreStream.Companion.getAuthentication().isAuthed()), (modelInvite == null || (guild = modelInvite.guild) == null) ? null : Long.valueOf(guild.getId()), (modelInvite == null || (channel2 = modelInvite.getChannel()) == null) ? null : Long.valueOf(channel2.getId()), (modelInvite == null || (channel = modelInvite.getChannel()) == null) ? null : Long.valueOf(channel.getType()), (modelInvite == null || (inviter = modelInvite.getInviter()) == null) ? null : Long.valueOf(inviter.getId()), modelInvite != null ? Long.valueOf(modelInvite.getApproximateMemberCount()) : null, modelInvite != null ? Long.valueOf(modelInvite.getApproximatePresenceCount()) : null, modelInvite != null ? modelInvite.getInviteType() : null, null, modelInvite != null ? Boolean.valueOf(m.areEqual(modelInvite.code, String.valueOf(RestAPIAbortCodes.USER_BANNED))) : null, null);
    }
}
