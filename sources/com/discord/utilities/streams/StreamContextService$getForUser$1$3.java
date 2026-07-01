package com.discord.utilities.streams;

import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelApplicationStream$GuildStream;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreApplicationStreamPreviews$StreamPreview;
import com.discord.stores.StoreApplicationStreaming$ActiveApplicationStream;
import com.discord.utilities.permissions.PermissionUtils;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function10;

/* JADX INFO: compiled from: StreamContextService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StreamContextService$getForUser$1$3 extends o implements Function10<Guild, StoreApplicationStreamPreviews$StreamPreview, Long, User, MeUser, String, Map<Long, ? extends VoiceState>, Channel, Long, StoreApplicationStreaming$ActiveApplicationStream, StreamContext> {
    public final /* synthetic */ ModelApplicationStream $stream;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamContextService$getForUser$1$3(ModelApplicationStream modelApplicationStream) {
        super(10);
        this.$stream = modelApplicationStream;
    }

    @Override // kotlin.jvm.functions.Function10
    public /* bridge */ /* synthetic */ StreamContext invoke(Guild guild, StoreApplicationStreamPreviews$StreamPreview storeApplicationStreamPreviews$StreamPreview, Long l, User user, MeUser meUser, String str, Map<Long, ? extends VoiceState> map, Channel channel, Long l2, StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStream) {
        return invoke(guild, storeApplicationStreamPreviews$StreamPreview, l, user, meUser, str, (Map<Long, VoiceState>) map, channel, l2.longValue(), storeApplicationStreaming$ActiveApplicationStream);
    }

    public final StreamContext invoke(Guild guild, StoreApplicationStreamPreviews$StreamPreview storeApplicationStreamPreviews$StreamPreview, Long l, User user, MeUser meUser, String str, Map<Long, VoiceState> map, Channel channel, long j, StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStream) {
        StreamContext$Joinability streamContext$Joinability;
        m.checkNotNullParameter(meUser, "me");
        m.checkNotNullParameter(map, "voiceStates");
        if (((this.$stream instanceof ModelApplicationStream$GuildStream) && guild == null) || user == null) {
            return null;
        }
        int userLimit = channel != null ? channel.getUserLimit() : 0;
        boolean z2 = userLimit > 0 && map.size() >= userLimit;
        boolean z3 = channel != null && channel.getId() == j;
        boolean zCan = PermissionUtils.can(Permission.CONNECT, l);
        boolean zCan2 = PermissionUtils.can(16L, l);
        if (!(this.$stream instanceof ModelApplicationStream$GuildStream) || zCan || z3) {
            streamContext$Joinability = (!z2 || zCan2) ? StreamContext$Joinability.CAN_CONNECT : StreamContext$Joinability.VOICE_CHANNEL_FULL;
        } else {
            streamContext$Joinability = StreamContext$Joinability.MISSING_PERMISSIONS;
        }
        return new StreamContext(this.$stream, guild, storeApplicationStreamPreviews$StreamPreview, streamContext$Joinability, user, str, storeApplicationStreaming$ActiveApplicationStream != null && storeApplicationStreaming$ActiveApplicationStream.getState().isStreamActive() && m.areEqual(storeApplicationStreaming$ActiveApplicationStream.getStream(), this.$stream), user.getId() == meUser.getId());
    }
}
