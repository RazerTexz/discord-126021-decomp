package com.discord.widgets.user.usersheet;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.api.user.UserProfile;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreUserNotes$UserNoteState;
import com.discord.utilities.streams.StreamContext;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.user.presence.ModelRichPresence;
import d0.z.d.m;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetUserSheetViewModel$StoreState {
    private final boolean canDisableCommunication;
    private final Channel channel;
    private final Map<Long, GuildMember> computedMembers;
    private final Map<Long, VoiceState> currentChannelVoiceStates;
    private final Guild guild;
    private final Map<Long, GuildRole> guildRoles;
    private final MeUser me;
    private final boolean muted;
    private final Map<Long, VoiceState> mySelectedVoiceChannelVoiceStates;
    private final StageRoles myStageRoles;
    private final float outputVolume;
    private final Long permissions;
    private final ModelRichPresence richPresence;
    private final boolean selfDeafened;
    private final boolean selfMuted;
    private final Channel stageChannel;
    private final StreamContext streamContext;
    private final User user;
    private final StoreUserNotes$UserNoteState userNoteFetchState;
    private final UserProfile userProfile;
    private final Integer userRelationshipType;
    private final StageRequestToSpeakState userRequestToSpeakState;
    private final StageRoles userStageRoles;

    private WidgetUserSheetViewModel$StoreState(User user, MeUser meUser, Channel channel, Map<Long, GuildMember> map, Map<Long, GuildRole> map2, Map<Long, VoiceState> map3, Map<Long, VoiceState> map4, boolean z2, boolean z3, boolean z4, float f, ModelRichPresence modelRichPresence, Guild guild, Long l, StreamContext streamContext, UserProfile userProfile, Integer num, StoreUserNotes$UserNoteState storeUserNotes$UserNoteState, Channel channel2, StageRoles stageRoles, StageRequestToSpeakState stageRequestToSpeakState, StageRoles stageRoles2, boolean z5) {
        this.user = user;
        this.me = meUser;
        this.channel = channel;
        this.computedMembers = map;
        this.guildRoles = map2;
        this.mySelectedVoiceChannelVoiceStates = map3;
        this.currentChannelVoiceStates = map4;
        this.muted = z2;
        this.selfMuted = z3;
        this.selfDeafened = z4;
        this.outputVolume = f;
        this.richPresence = modelRichPresence;
        this.guild = guild;
        this.permissions = l;
        this.streamContext = streamContext;
        this.userProfile = userProfile;
        this.userRelationshipType = num;
        this.userNoteFetchState = storeUserNotes$UserNoteState;
        this.stageChannel = channel2;
        this.userStageRoles = stageRoles;
        this.userRequestToSpeakState = stageRequestToSpeakState;
        this.myStageRoles = stageRoles2;
        this.canDisableCommunication = z5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-U9gTzXU$default, reason: not valid java name */
    public static /* synthetic */ WidgetUserSheetViewModel$StoreState m55copyU9gTzXU$default(WidgetUserSheetViewModel$StoreState widgetUserSheetViewModel$StoreState, User user, MeUser meUser, Channel channel, Map map, Map map2, Map map3, Map map4, boolean z2, boolean z3, boolean z4, float f, ModelRichPresence modelRichPresence, Guild guild, Long l, StreamContext streamContext, UserProfile userProfile, Integer num, StoreUserNotes$UserNoteState storeUserNotes$UserNoteState, Channel channel2, StageRoles stageRoles, StageRequestToSpeakState stageRequestToSpeakState, StageRoles stageRoles2, boolean z5, int i, Object obj) {
        return widgetUserSheetViewModel$StoreState.m58copyU9gTzXU((i & 1) != 0 ? widgetUserSheetViewModel$StoreState.user : user, (i & 2) != 0 ? widgetUserSheetViewModel$StoreState.me : meUser, (i & 4) != 0 ? widgetUserSheetViewModel$StoreState.channel : channel, (i & 8) != 0 ? widgetUserSheetViewModel$StoreState.computedMembers : map, (i & 16) != 0 ? widgetUserSheetViewModel$StoreState.guildRoles : map2, (i & 32) != 0 ? widgetUserSheetViewModel$StoreState.mySelectedVoiceChannelVoiceStates : map3, (i & 64) != 0 ? widgetUserSheetViewModel$StoreState.currentChannelVoiceStates : map4, (i & 128) != 0 ? widgetUserSheetViewModel$StoreState.muted : z2, (i & 256) != 0 ? widgetUserSheetViewModel$StoreState.selfMuted : z3, (i & 512) != 0 ? widgetUserSheetViewModel$StoreState.selfDeafened : z4, (i & 1024) != 0 ? widgetUserSheetViewModel$StoreState.outputVolume : f, (i & 2048) != 0 ? widgetUserSheetViewModel$StoreState.richPresence : modelRichPresence, (i & 4096) != 0 ? widgetUserSheetViewModel$StoreState.guild : guild, (i & 8192) != 0 ? widgetUserSheetViewModel$StoreState.permissions : l, (i & 16384) != 0 ? widgetUserSheetViewModel$StoreState.streamContext : streamContext, (i & 32768) != 0 ? widgetUserSheetViewModel$StoreState.userProfile : userProfile, (i & 65536) != 0 ? widgetUserSheetViewModel$StoreState.userRelationshipType : num, (i & 131072) != 0 ? widgetUserSheetViewModel$StoreState.userNoteFetchState : storeUserNotes$UserNoteState, (i & 262144) != 0 ? widgetUserSheetViewModel$StoreState.stageChannel : channel2, (i & 524288) != 0 ? widgetUserSheetViewModel$StoreState.userStageRoles : stageRoles, (i & 1048576) != 0 ? widgetUserSheetViewModel$StoreState.userRequestToSpeakState : stageRequestToSpeakState, (i & 2097152) != 0 ? widgetUserSheetViewModel$StoreState.myStageRoles : stageRoles2, (i & 4194304) != 0 ? widgetUserSheetViewModel$StoreState.canDisableCommunication : z5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getSelfDeafened() {
        return this.selfDeafened;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final float getOutputVolume() {
        return this.outputVolume;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final ModelRichPresence getRichPresence() {
        return this.richPresence;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Long getPermissions() {
        return this.permissions;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final StreamContext getStreamContext() {
        return this.streamContext;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final UserProfile getUserProfile() {
        return this.userProfile;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final Integer getUserRelationshipType() {
        return this.userRelationshipType;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final StoreUserNotes$UserNoteState getUserNoteFetchState() {
        return this.userNoteFetchState;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final Channel getStageChannel() {
        return this.stageChannel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MeUser getMe() {
        return this.me;
    }

    /* JADX INFO: renamed from: component20-twRsX-0, reason: not valid java name and from getter */
    public final StageRoles getUserStageRoles() {
        return this.userStageRoles;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final StageRequestToSpeakState getUserRequestToSpeakState() {
        return this.userRequestToSpeakState;
    }

    /* JADX INFO: renamed from: component22-twRsX-0, reason: not valid java name and from getter */
    public final StageRoles getMyStageRoles() {
        return this.myStageRoles;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final boolean getCanDisableCommunication() {
        return this.canDisableCommunication;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    public final Map<Long, GuildMember> component4() {
        return this.computedMembers;
    }

    public final Map<Long, GuildRole> component5() {
        return this.guildRoles;
    }

    public final Map<Long, VoiceState> component6() {
        return this.mySelectedVoiceChannelVoiceStates;
    }

    public final Map<Long, VoiceState> component7() {
        return this.currentChannelVoiceStates;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getMuted() {
        return this.muted;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getSelfMuted() {
        return this.selfMuted;
    }

    /* JADX INFO: renamed from: copy-U9gTzXU, reason: not valid java name */
    public final WidgetUserSheetViewModel$StoreState m58copyU9gTzXU(User user, MeUser me2, Channel channel, Map<Long, GuildMember> computedMembers, Map<Long, GuildRole> guildRoles, Map<Long, VoiceState> mySelectedVoiceChannelVoiceStates, Map<Long, VoiceState> currentChannelVoiceStates, boolean muted, boolean selfMuted, boolean selfDeafened, float outputVolume, ModelRichPresence richPresence, Guild guild, Long permissions, StreamContext streamContext, UserProfile userProfile, Integer userRelationshipType, StoreUserNotes$UserNoteState userNoteFetchState, Channel stageChannel, StageRoles userStageRoles, StageRequestToSpeakState userRequestToSpeakState, StageRoles myStageRoles, boolean canDisableCommunication) {
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(me2, "me");
        m.checkNotNullParameter(computedMembers, "computedMembers");
        m.checkNotNullParameter(guildRoles, "guildRoles");
        m.checkNotNullParameter(mySelectedVoiceChannelVoiceStates, "mySelectedVoiceChannelVoiceStates");
        m.checkNotNullParameter(currentChannelVoiceStates, "currentChannelVoiceStates");
        m.checkNotNullParameter(userProfile, "userProfile");
        m.checkNotNullParameter(userNoteFetchState, "userNoteFetchState");
        m.checkNotNullParameter(userRequestToSpeakState, "userRequestToSpeakState");
        return new WidgetUserSheetViewModel$StoreState(user, me2, channel, computedMembers, guildRoles, mySelectedVoiceChannelVoiceStates, currentChannelVoiceStates, muted, selfMuted, selfDeafened, outputVolume, richPresence, guild, permissions, streamContext, userProfile, userRelationshipType, userNoteFetchState, stageChannel, userStageRoles, userRequestToSpeakState, myStageRoles, canDisableCommunication);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetUserSheetViewModel$StoreState)) {
            return false;
        }
        WidgetUserSheetViewModel$StoreState widgetUserSheetViewModel$StoreState = (WidgetUserSheetViewModel$StoreState) other;
        return m.areEqual(this.user, widgetUserSheetViewModel$StoreState.user) && m.areEqual(this.me, widgetUserSheetViewModel$StoreState.me) && m.areEqual(this.channel, widgetUserSheetViewModel$StoreState.channel) && m.areEqual(this.computedMembers, widgetUserSheetViewModel$StoreState.computedMembers) && m.areEqual(this.guildRoles, widgetUserSheetViewModel$StoreState.guildRoles) && m.areEqual(this.mySelectedVoiceChannelVoiceStates, widgetUserSheetViewModel$StoreState.mySelectedVoiceChannelVoiceStates) && m.areEqual(this.currentChannelVoiceStates, widgetUserSheetViewModel$StoreState.currentChannelVoiceStates) && this.muted == widgetUserSheetViewModel$StoreState.muted && this.selfMuted == widgetUserSheetViewModel$StoreState.selfMuted && this.selfDeafened == widgetUserSheetViewModel$StoreState.selfDeafened && Float.compare(this.outputVolume, widgetUserSheetViewModel$StoreState.outputVolume) == 0 && m.areEqual(this.richPresence, widgetUserSheetViewModel$StoreState.richPresence) && m.areEqual(this.guild, widgetUserSheetViewModel$StoreState.guild) && m.areEqual(this.permissions, widgetUserSheetViewModel$StoreState.permissions) && m.areEqual(this.streamContext, widgetUserSheetViewModel$StoreState.streamContext) && m.areEqual(this.userProfile, widgetUserSheetViewModel$StoreState.userProfile) && m.areEqual(this.userRelationshipType, widgetUserSheetViewModel$StoreState.userRelationshipType) && m.areEqual(this.userNoteFetchState, widgetUserSheetViewModel$StoreState.userNoteFetchState) && m.areEqual(this.stageChannel, widgetUserSheetViewModel$StoreState.stageChannel) && m.areEqual(this.userStageRoles, widgetUserSheetViewModel$StoreState.userStageRoles) && m.areEqual(this.userRequestToSpeakState, widgetUserSheetViewModel$StoreState.userRequestToSpeakState) && m.areEqual(this.myStageRoles, widgetUserSheetViewModel$StoreState.myStageRoles) && this.canDisableCommunication == widgetUserSheetViewModel$StoreState.canDisableCommunication;
    }

    public final boolean getCanDisableCommunication() {
        return this.canDisableCommunication;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final Map<Long, GuildMember> getComputedMembers() {
        return this.computedMembers;
    }

    public final Map<Long, VoiceState> getCurrentChannelVoiceStates() {
        return this.currentChannelVoiceStates;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final Map<Long, GuildRole> getGuildRoles() {
        return this.guildRoles;
    }

    public final MeUser getMe() {
        return this.me;
    }

    public final boolean getMuted() {
        return this.muted;
    }

    public final Map<Long, VoiceState> getMySelectedVoiceChannelVoiceStates() {
        return this.mySelectedVoiceChannelVoiceStates;
    }

    /* JADX INFO: renamed from: getMyStageRoles-twRsX-0, reason: not valid java name */
    public final StageRoles m59getMyStageRolestwRsX0() {
        return this.myStageRoles;
    }

    public final float getOutputVolume() {
        return this.outputVolume;
    }

    public final Long getPermissions() {
        return this.permissions;
    }

    public final ModelRichPresence getRichPresence() {
        return this.richPresence;
    }

    public final boolean getSelfDeafened() {
        return this.selfDeafened;
    }

    public final boolean getSelfMuted() {
        return this.selfMuted;
    }

    public final Channel getStageChannel() {
        return this.stageChannel;
    }

    public final StreamContext getStreamContext() {
        return this.streamContext;
    }

    public final User getUser() {
        return this.user;
    }

    public final StoreUserNotes$UserNoteState getUserNoteFetchState() {
        return this.userNoteFetchState;
    }

    public final UserProfile getUserProfile() {
        return this.userProfile;
    }

    public final Integer getUserRelationshipType() {
        return this.userRelationshipType;
    }

    public final StageRequestToSpeakState getUserRequestToSpeakState() {
        return this.userRequestToSpeakState;
    }

    /* JADX INFO: renamed from: getUserStageRoles-twRsX-0, reason: not valid java name */
    public final StageRoles m60getUserStageRolestwRsX0() {
        return this.userStageRoles;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v21, types: [int] */
    /* JADX WARN: Type inference failed for: r2v23, types: [int] */
    /* JADX WARN: Type inference failed for: r2v50, types: [int] */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v60 */
    /* JADX WARN: Type inference failed for: r2v61 */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        MeUser meUser = this.me;
        int iHashCode2 = (iHashCode + (meUser != null ? meUser.hashCode() : 0)) * 31;
        Channel channel = this.channel;
        int iHashCode3 = (iHashCode2 + (channel != null ? channel.hashCode() : 0)) * 31;
        Map<Long, GuildMember> map = this.computedMembers;
        int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, GuildRole> map2 = this.guildRoles;
        int iHashCode5 = (iHashCode4 + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<Long, VoiceState> map3 = this.mySelectedVoiceChannelVoiceStates;
        int iHashCode6 = (iHashCode5 + (map3 != null ? map3.hashCode() : 0)) * 31;
        Map<Long, VoiceState> map4 = this.currentChannelVoiceStates;
        int iHashCode7 = (iHashCode6 + (map4 != null ? map4.hashCode() : 0)) * 31;
        boolean z2 = this.muted;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode7 + r2) * 31;
        boolean z3 = this.selfMuted;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (i + r3) * 31;
        boolean z4 = this.selfDeafened;
        ?? r4 = z4;
        if (z4) {
            r4 = 1;
        }
        int iFloatToIntBits = (Float.floatToIntBits(this.outputVolume) + ((i2 + r4) * 31)) * 31;
        ModelRichPresence modelRichPresence = this.richPresence;
        int iHashCode8 = (iFloatToIntBits + (modelRichPresence != null ? modelRichPresence.hashCode() : 0)) * 31;
        Guild guild = this.guild;
        int iHashCode9 = (iHashCode8 + (guild != null ? guild.hashCode() : 0)) * 31;
        Long l = this.permissions;
        int iHashCode10 = (iHashCode9 + (l != null ? l.hashCode() : 0)) * 31;
        StreamContext streamContext = this.streamContext;
        int iHashCode11 = (iHashCode10 + (streamContext != null ? streamContext.hashCode() : 0)) * 31;
        UserProfile userProfile = this.userProfile;
        int iHashCode12 = (iHashCode11 + (userProfile != null ? userProfile.hashCode() : 0)) * 31;
        Integer num = this.userRelationshipType;
        int iHashCode13 = (iHashCode12 + (num != null ? num.hashCode() : 0)) * 31;
        StoreUserNotes$UserNoteState storeUserNotes$UserNoteState = this.userNoteFetchState;
        int iHashCode14 = (iHashCode13 + (storeUserNotes$UserNoteState != null ? storeUserNotes$UserNoteState.hashCode() : 0)) * 31;
        Channel channel2 = this.stageChannel;
        int iHashCode15 = (iHashCode14 + (channel2 != null ? channel2.hashCode() : 0)) * 31;
        StageRoles stageRoles = this.userStageRoles;
        int iHashCode16 = (iHashCode15 + (stageRoles != null ? stageRoles.hashCode() : 0)) * 31;
        StageRequestToSpeakState stageRequestToSpeakState = this.userRequestToSpeakState;
        int iHashCode17 = (iHashCode16 + (stageRequestToSpeakState != null ? stageRequestToSpeakState.hashCode() : 0)) * 31;
        StageRoles stageRoles2 = this.myStageRoles;
        int iHashCode18 = (iHashCode17 + (stageRoles2 != null ? stageRoles2.hashCode() : 0)) * 31;
        boolean z5 = this.canDisableCommunication;
        return iHashCode18 + (z5 ? 1 : z5);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(user=");
        sbU.append(this.user);
        sbU.append(", me=");
        sbU.append(this.me);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", computedMembers=");
        sbU.append(this.computedMembers);
        sbU.append(", guildRoles=");
        sbU.append(this.guildRoles);
        sbU.append(", mySelectedVoiceChannelVoiceStates=");
        sbU.append(this.mySelectedVoiceChannelVoiceStates);
        sbU.append(", currentChannelVoiceStates=");
        sbU.append(this.currentChannelVoiceStates);
        sbU.append(", muted=");
        sbU.append(this.muted);
        sbU.append(", selfMuted=");
        sbU.append(this.selfMuted);
        sbU.append(", selfDeafened=");
        sbU.append(this.selfDeafened);
        sbU.append(", outputVolume=");
        sbU.append(this.outputVolume);
        sbU.append(", richPresence=");
        sbU.append(this.richPresence);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", permissions=");
        sbU.append(this.permissions);
        sbU.append(", streamContext=");
        sbU.append(this.streamContext);
        sbU.append(", userProfile=");
        sbU.append(this.userProfile);
        sbU.append(", userRelationshipType=");
        sbU.append(this.userRelationshipType);
        sbU.append(", userNoteFetchState=");
        sbU.append(this.userNoteFetchState);
        sbU.append(", stageChannel=");
        sbU.append(this.stageChannel);
        sbU.append(", userStageRoles=");
        sbU.append(this.userStageRoles);
        sbU.append(", userRequestToSpeakState=");
        sbU.append(this.userRequestToSpeakState);
        sbU.append(", myStageRoles=");
        sbU.append(this.myStageRoles);
        sbU.append(", canDisableCommunication=");
        return a.O(sbU, this.canDisableCommunication, ")");
    }

    public /* synthetic */ WidgetUserSheetViewModel$StoreState(User user, MeUser meUser, Channel channel, Map map, Map map2, Map map3, Map map4, boolean z2, boolean z3, boolean z4, float f, ModelRichPresence modelRichPresence, Guild guild, Long l, StreamContext streamContext, UserProfile userProfile, Integer num, StoreUserNotes$UserNoteState storeUserNotes$UserNoteState, Channel channel2, StageRoles stageRoles, StageRequestToSpeakState stageRequestToSpeakState, StageRoles stageRoles2, boolean z5, DefaultConstructorMarker defaultConstructorMarker) {
        this(user, meUser, channel, map, map2, map3, map4, z2, z3, z4, f, modelRichPresence, guild, l, streamContext, userProfile, num, storeUserNotes$UserNoteState, channel2, stageRoles, stageRequestToSpeakState, stageRoles2, z5);
    }
}
