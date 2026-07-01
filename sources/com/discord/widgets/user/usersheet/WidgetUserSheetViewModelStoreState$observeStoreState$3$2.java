package com.discord.widgets.user.usersheet;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.role.GuildRole;
import com.discord.api.user.UserProfile;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreMediaSettings$VoiceConfiguration;
import com.discord.stores.StoreUserNotes$UserNoteState;
import com.discord.utilities.streams.StreamContext;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.user.presence.ModelRichPresence;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function16;

/* JADX INFO: compiled from: WidgetUserSheetViewModelStoreState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheetViewModelStoreState$observeStoreState$3$2 extends o implements Function16<Map<Long, ? extends GuildMember>, Map<Long, ? extends GuildRole>, Map<Long, ? extends VoiceState>, Map<Long, ? extends VoiceState>, StoreMediaSettings$VoiceConfiguration, ModelRichPresence, Guild, Long, StreamContext, UserProfile, Integer, StoreUserNotes$UserNoteState, StageRoles, StageRequestToSpeakState, StageRoles, Boolean, WidgetUserSheetViewModel$StoreState> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ MeUser $me;
    public final /* synthetic */ Channel $selectedVoiceChannel;
    public final /* synthetic */ User $user;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSheetViewModelStoreState$observeStoreState$3$2(User user, MeUser meUser, Channel channel, Channel channel2) {
        super(16);
        this.$user = user;
        this.$me = meUser;
        this.$channel = channel;
        this.$selectedVoiceChannel = channel2;
    }

    @Override // kotlin.jvm.functions.Function16
    public /* bridge */ /* synthetic */ WidgetUserSheetViewModel$StoreState invoke(Map<Long, ? extends GuildMember> map, Map<Long, ? extends GuildRole> map2, Map<Long, ? extends VoiceState> map3, Map<Long, ? extends VoiceState> map4, StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration, ModelRichPresence modelRichPresence, Guild guild, Long l, StreamContext streamContext, UserProfile userProfile, Integer num, StoreUserNotes$UserNoteState storeUserNotes$UserNoteState, StageRoles stageRoles, StageRequestToSpeakState stageRequestToSpeakState, StageRoles stageRoles2, Boolean bool) {
        return invoke((Map<Long, GuildMember>) map, (Map<Long, GuildRole>) map2, (Map<Long, VoiceState>) map3, (Map<Long, VoiceState>) map4, storeMediaSettings$VoiceConfiguration, modelRichPresence, guild, l, streamContext, userProfile, num, storeUserNotes$UserNoteState, stageRoles, stageRequestToSpeakState, stageRoles2, bool.booleanValue());
    }

    public final WidgetUserSheetViewModel$StoreState invoke(Map<Long, GuildMember> map, Map<Long, GuildRole> map2, Map<Long, VoiceState> map3, Map<Long, VoiceState> map4, StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration, ModelRichPresence modelRichPresence, Guild guild, Long l, StreamContext streamContext, UserProfile userProfile, Integer num, StoreUserNotes$UserNoteState storeUserNotes$UserNoteState, StageRoles stageRoles, StageRequestToSpeakState stageRequestToSpeakState, StageRoles stageRoles2, boolean z2) {
        m.checkNotNullParameter(map, "computedMembers");
        m.checkNotNullParameter(map2, "guildRoles");
        m.checkNotNullParameter(map3, "mySelectedVoiceChannelVoiceStates");
        m.checkNotNullParameter(map4, "currentChannelVoiceStates");
        m.checkNotNullParameter(storeMediaSettings$VoiceConfiguration, "voiceConfig");
        m.checkNotNullParameter(userProfile, "userProfile");
        m.checkNotNullParameter(storeUserNotes$UserNoteState, "userNote");
        m.checkNotNullParameter(stageRequestToSpeakState, "userRequestToSpeakState");
        Boolean bool = (Boolean) a.f(this.$user, storeMediaSettings$VoiceConfiguration.getMutedUsers());
        boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
        boolean zIsSelfMuted = storeMediaSettings$VoiceConfiguration.isSelfMuted();
        boolean zIsSelfDeafened = storeMediaSettings$VoiceConfiguration.isSelfDeafened();
        Float f = (Float) a.f(this.$user, storeMediaSettings$VoiceConfiguration.getUserOutputVolumes());
        float fFloatValue = f != null ? f.floatValue() : 100.0f;
        User user = this.$user;
        MeUser meUser = this.$me;
        Channel channel = this.$channel;
        Channel channel2 = this.$selectedVoiceChannel;
        return new WidgetUserSheetViewModel$StoreState(user, meUser, channel, map, map2, map3, map4, zBooleanValue, zIsSelfMuted, zIsSelfDeafened, fFloatValue, modelRichPresence, guild, l, streamContext, userProfile, num, storeUserNotes$UserNoteState, (channel2 == null || !ChannelUtils.D(channel2)) ? null : channel2, stageRoles, stageRequestToSpeakState, stageRoles2, z2, null);
    }
}
