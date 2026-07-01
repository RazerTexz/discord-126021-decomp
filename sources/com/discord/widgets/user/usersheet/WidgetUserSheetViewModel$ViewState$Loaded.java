package com.discord.widgets.user.usersheet;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.api.user.UserProfile;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.simpleast.core.node.Node;
import com.discord.stores.StoreUserNotes$UserNoteState;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.widgets.stage.usersheet.UserProfileStageActionsView$ViewState;
import com.discord.widgets.user.presence.ModelRichPresence;
import com.discord.widgets.user.profile.UserProfileAdminView$ViewState;
import com.discord.widgets.user.profile.UserProfileConnectionsView$ViewState;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetUserSheetViewModel$ViewState$Loaded extends WidgetUserSheetViewModel$ViewState {
    private final UserProfileAdminView$ViewState adminViewState;
    private final List<Node<MessageRenderContext>> bioAst;
    private final Channel channel;
    private final VoiceState channelVoiceState;
    private final UserProfileConnectionsView$ViewState connectionsViewState;
    private final Long currentGuildId;
    private final String guildIcon;
    private final String guildIconURL;
    private final Long guildId;
    private final GuildMember guildMember;
    private final String guildName;
    private final String guildSectionHeaderText;
    private final boolean hasGuildMemberBio;
    private final boolean hasPremiumCustomization;
    private final boolean isMe;
    private final boolean profileLoaded;
    private final ModelRichPresence richPresence;
    private final List<GuildRole> roleItems;
    private final boolean showVoiceSettings;
    private final UserProfileStageActionsView$ViewState stageViewState;
    private final StreamContext streamContext;
    private final User user;
    private final boolean userInSameVoiceChannel;
    private final String userNote;
    private final StoreUserNotes$UserNoteState userNoteFetchState;
    private final UserProfile userProfile;
    private final int userRelationshipType;
    private final UserProfileVoiceSettingsView$ViewState voiceSettingsViewState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSheetViewModel$ViewState$Loaded(User user, boolean z2, boolean z3, UserProfileVoiceSettingsView$ViewState userProfileVoiceSettingsView$ViewState, VoiceState voiceState, ModelRichPresence modelRichPresence, String str, List<GuildRole> list, UserProfileAdminView$ViewState userProfileAdminView$ViewState, UserProfileStageActionsView$ViewState userProfileStageActionsView$ViewState, Channel channel, StreamContext streamContext, String str2, String str3, int i, UserProfileConnectionsView$ViewState userProfileConnectionsView$ViewState, StoreUserNotes$UserNoteState storeUserNotes$UserNoteState, String str4, boolean z4, List<Node<MessageRenderContext>> list2, boolean z5, Long l, GuildMember guildMember, UserProfile userProfile) {
        String avatar;
        super(null);
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(userProfileVoiceSettingsView$ViewState, "voiceSettingsViewState");
        m.checkNotNullParameter(list, "roleItems");
        m.checkNotNullParameter(userProfileStageActionsView$ViewState, "stageViewState");
        m.checkNotNullParameter(userProfileConnectionsView$ViewState, "connectionsViewState");
        m.checkNotNullParameter(storeUserNotes$UserNoteState, "userNoteFetchState");
        this.user = user;
        this.isMe = z2;
        this.showVoiceSettings = z3;
        this.voiceSettingsViewState = userProfileVoiceSettingsView$ViewState;
        this.channelVoiceState = voiceState;
        this.richPresence = modelRichPresence;
        this.guildSectionHeaderText = str;
        this.roleItems = list;
        this.adminViewState = userProfileAdminView$ViewState;
        this.stageViewState = userProfileStageActionsView$ViewState;
        this.channel = channel;
        this.streamContext = streamContext;
        this.guildName = str2;
        this.guildIcon = str3;
        this.userRelationshipType = i;
        this.connectionsViewState = userProfileConnectionsView$ViewState;
        this.userNoteFetchState = storeUserNotes$UserNoteState;
        this.userNote = str4;
        this.userInSameVoiceChannel = z4;
        this.bioAst = list2;
        this.profileLoaded = z5;
        this.guildId = l;
        this.guildMember = guildMember;
        this.userProfile = userProfile;
        this.hasPremiumCustomization = user.getBanner() != null || ((avatar = user.getAvatar()) != null && IconUtils.INSTANCE.isImageHashAnimated(avatar));
        this.currentGuildId = channel != null ? Long.valueOf(channel.getGuildId()) : l;
        String bio = guildMember != null ? guildMember.getBio() : null;
        this.hasGuildMemberBio = !(bio == null || bio.length() == 0);
        this.guildIconURL = str3 != null ? IconUtils.getForGuild$default(l, str3, null, false, Integer.valueOf(DimenUtils.dpToPixels(16)), 4, null) : null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetUserSheetViewModel$ViewState$Loaded copy$default(WidgetUserSheetViewModel$ViewState$Loaded widgetUserSheetViewModel$ViewState$Loaded, User user, boolean z2, boolean z3, UserProfileVoiceSettingsView$ViewState userProfileVoiceSettingsView$ViewState, VoiceState voiceState, ModelRichPresence modelRichPresence, String str, List list, UserProfileAdminView$ViewState userProfileAdminView$ViewState, UserProfileStageActionsView$ViewState userProfileStageActionsView$ViewState, Channel channel, StreamContext streamContext, String str2, String str3, int i, UserProfileConnectionsView$ViewState userProfileConnectionsView$ViewState, StoreUserNotes$UserNoteState storeUserNotes$UserNoteState, String str4, boolean z4, List list2, boolean z5, Long l, GuildMember guildMember, UserProfile userProfile, int i2, Object obj) {
        return widgetUserSheetViewModel$ViewState$Loaded.copy((i2 & 1) != 0 ? widgetUserSheetViewModel$ViewState$Loaded.user : user, (i2 & 2) != 0 ? widgetUserSheetViewModel$ViewState$Loaded.isMe : z2, (i2 & 4) != 0 ? widgetUserSheetViewModel$ViewState$Loaded.showVoiceSettings : z3, (i2 & 8) != 0 ? widgetUserSheetViewModel$ViewState$Loaded.voiceSettingsViewState : userProfileVoiceSettingsView$ViewState, (i2 & 16) != 0 ? widgetUserSheetViewModel$ViewState$Loaded.channelVoiceState : voiceState, (i2 & 32) != 0 ? widgetUserSheetViewModel$ViewState$Loaded.richPresence : modelRichPresence, (i2 & 64) != 0 ? widgetUserSheetViewModel$ViewState$Loaded.guildSectionHeaderText : str, (i2 & 128) != 0 ? widgetUserSheetViewModel$ViewState$Loaded.roleItems : list, (i2 & 256) != 0 ? widgetUserSheetViewModel$ViewState$Loaded.adminViewState : userProfileAdminView$ViewState, (i2 & 512) != 0 ? widgetUserSheetViewModel$ViewState$Loaded.stageViewState : userProfileStageActionsView$ViewState, (i2 & 1024) != 0 ? widgetUserSheetViewModel$ViewState$Loaded.channel : channel, (i2 & 2048) != 0 ? widgetUserSheetViewModel$ViewState$Loaded.streamContext : streamContext, (i2 & 4096) != 0 ? widgetUserSheetViewModel$ViewState$Loaded.guildName : str2, (i2 & 8192) != 0 ? widgetUserSheetViewModel$ViewState$Loaded.guildIcon : str3, (i2 & 16384) != 0 ? widgetUserSheetViewModel$ViewState$Loaded.userRelationshipType : i, (i2 & 32768) != 0 ? widgetUserSheetViewModel$ViewState$Loaded.connectionsViewState : userProfileConnectionsView$ViewState, (i2 & 65536) != 0 ? widgetUserSheetViewModel$ViewState$Loaded.userNoteFetchState : storeUserNotes$UserNoteState, (i2 & 131072) != 0 ? widgetUserSheetViewModel$ViewState$Loaded.userNote : str4, (i2 & 262144) != 0 ? widgetUserSheetViewModel$ViewState$Loaded.userInSameVoiceChannel : z4, (i2 & 524288) != 0 ? widgetUserSheetViewModel$ViewState$Loaded.bioAst : list2, (i2 & 1048576) != 0 ? widgetUserSheetViewModel$ViewState$Loaded.profileLoaded : z5, (i2 & 2097152) != 0 ? widgetUserSheetViewModel$ViewState$Loaded.guildId : l, (i2 & 4194304) != 0 ? widgetUserSheetViewModel$ViewState$Loaded.guildMember : guildMember, (i2 & 8388608) != 0 ? widgetUserSheetViewModel$ViewState$Loaded.userProfile : userProfile);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final UserProfileStageActionsView$ViewState getStageViewState() {
        return this.stageViewState;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final StreamContext getStreamContext() {
        return this.streamContext;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getGuildIcon() {
        return this.guildIcon;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final int getUserRelationshipType() {
        return this.userRelationshipType;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final UserProfileConnectionsView$ViewState getConnectionsViewState() {
        return this.connectionsViewState;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final StoreUserNotes$UserNoteState getUserNoteFetchState() {
        return this.userNoteFetchState;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getUserNote() {
        return this.userNote;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final boolean getUserInSameVoiceChannel() {
        return this.userInSameVoiceChannel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsMe() {
        return this.isMe;
    }

    public final List<Node<MessageRenderContext>> component20() {
        return this.bioAst;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final boolean getProfileLoaded() {
        return this.profileLoaded;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final UserProfile getUserProfile() {
        return this.userProfile;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getShowVoiceSettings() {
        return this.showVoiceSettings;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final UserProfileVoiceSettingsView$ViewState getVoiceSettingsViewState() {
        return this.voiceSettingsViewState;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final VoiceState getChannelVoiceState() {
        return this.channelVoiceState;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final ModelRichPresence getRichPresence() {
        return this.richPresence;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getGuildSectionHeaderText() {
        return this.guildSectionHeaderText;
    }

    public final List<GuildRole> component8() {
        return this.roleItems;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final UserProfileAdminView$ViewState getAdminViewState() {
        return this.adminViewState;
    }

    public final WidgetUserSheetViewModel$ViewState$Loaded copy(User user, boolean isMe, boolean showVoiceSettings, UserProfileVoiceSettingsView$ViewState voiceSettingsViewState, VoiceState channelVoiceState, ModelRichPresence richPresence, String guildSectionHeaderText, List<GuildRole> roleItems, UserProfileAdminView$ViewState adminViewState, UserProfileStageActionsView$ViewState stageViewState, Channel channel, StreamContext streamContext, String guildName, String guildIcon, int userRelationshipType, UserProfileConnectionsView$ViewState connectionsViewState, StoreUserNotes$UserNoteState userNoteFetchState, String userNote, boolean userInSameVoiceChannel, List<Node<MessageRenderContext>> bioAst, boolean profileLoaded, Long guildId, GuildMember guildMember, UserProfile userProfile) {
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(voiceSettingsViewState, "voiceSettingsViewState");
        m.checkNotNullParameter(roleItems, "roleItems");
        m.checkNotNullParameter(stageViewState, "stageViewState");
        m.checkNotNullParameter(connectionsViewState, "connectionsViewState");
        m.checkNotNullParameter(userNoteFetchState, "userNoteFetchState");
        return new WidgetUserSheetViewModel$ViewState$Loaded(user, isMe, showVoiceSettings, voiceSettingsViewState, channelVoiceState, richPresence, guildSectionHeaderText, roleItems, adminViewState, stageViewState, channel, streamContext, guildName, guildIcon, userRelationshipType, connectionsViewState, userNoteFetchState, userNote, userInSameVoiceChannel, bioAst, profileLoaded, guildId, guildMember, userProfile);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetUserSheetViewModel$ViewState$Loaded)) {
            return false;
        }
        WidgetUserSheetViewModel$ViewState$Loaded widgetUserSheetViewModel$ViewState$Loaded = (WidgetUserSheetViewModel$ViewState$Loaded) other;
        return m.areEqual(this.user, widgetUserSheetViewModel$ViewState$Loaded.user) && this.isMe == widgetUserSheetViewModel$ViewState$Loaded.isMe && this.showVoiceSettings == widgetUserSheetViewModel$ViewState$Loaded.showVoiceSettings && m.areEqual(this.voiceSettingsViewState, widgetUserSheetViewModel$ViewState$Loaded.voiceSettingsViewState) && m.areEqual(this.channelVoiceState, widgetUserSheetViewModel$ViewState$Loaded.channelVoiceState) && m.areEqual(this.richPresence, widgetUserSheetViewModel$ViewState$Loaded.richPresence) && m.areEqual(this.guildSectionHeaderText, widgetUserSheetViewModel$ViewState$Loaded.guildSectionHeaderText) && m.areEqual(this.roleItems, widgetUserSheetViewModel$ViewState$Loaded.roleItems) && m.areEqual(this.adminViewState, widgetUserSheetViewModel$ViewState$Loaded.adminViewState) && m.areEqual(this.stageViewState, widgetUserSheetViewModel$ViewState$Loaded.stageViewState) && m.areEqual(this.channel, widgetUserSheetViewModel$ViewState$Loaded.channel) && m.areEqual(this.streamContext, widgetUserSheetViewModel$ViewState$Loaded.streamContext) && m.areEqual(this.guildName, widgetUserSheetViewModel$ViewState$Loaded.guildName) && m.areEqual(this.guildIcon, widgetUserSheetViewModel$ViewState$Loaded.guildIcon) && this.userRelationshipType == widgetUserSheetViewModel$ViewState$Loaded.userRelationshipType && m.areEqual(this.connectionsViewState, widgetUserSheetViewModel$ViewState$Loaded.connectionsViewState) && m.areEqual(this.userNoteFetchState, widgetUserSheetViewModel$ViewState$Loaded.userNoteFetchState) && m.areEqual(this.userNote, widgetUserSheetViewModel$ViewState$Loaded.userNote) && this.userInSameVoiceChannel == widgetUserSheetViewModel$ViewState$Loaded.userInSameVoiceChannel && m.areEqual(this.bioAst, widgetUserSheetViewModel$ViewState$Loaded.bioAst) && this.profileLoaded == widgetUserSheetViewModel$ViewState$Loaded.profileLoaded && m.areEqual(this.guildId, widgetUserSheetViewModel$ViewState$Loaded.guildId) && m.areEqual(this.guildMember, widgetUserSheetViewModel$ViewState$Loaded.guildMember) && m.areEqual(this.userProfile, widgetUserSheetViewModel$ViewState$Loaded.userProfile);
    }

    public final UserProfileAdminView$ViewState getAdminViewState() {
        return this.adminViewState;
    }

    public final List<Node<MessageRenderContext>> getBioAst() {
        return this.bioAst;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final VoiceState getChannelVoiceState() {
        return this.channelVoiceState;
    }

    public final UserProfileConnectionsView$ViewState getConnectionsViewState() {
        return this.connectionsViewState;
    }

    public final Long getCurrentGuildId() {
        return this.currentGuildId;
    }

    public final String getGuildIcon() {
        return this.guildIcon;
    }

    public final String getGuildIconURL() {
        return this.guildIconURL;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final String getGuildName() {
        return this.guildName;
    }

    public final String getGuildSectionHeaderText() {
        return this.guildSectionHeaderText;
    }

    public final boolean getHasGuildMemberBio() {
        return this.hasGuildMemberBio;
    }

    public final boolean getHasPremiumCustomization() {
        return this.hasPremiumCustomization;
    }

    public final Presence getPresence() {
        ModelRichPresence modelRichPresence = this.richPresence;
        if (modelRichPresence != null) {
            return modelRichPresence.getPresence();
        }
        return null;
    }

    public final boolean getProfileLoaded() {
        return this.profileLoaded;
    }

    public final ModelRichPresence getRichPresence() {
        return this.richPresence;
    }

    public final List<GuildRole> getRoleItems() {
        return this.roleItems;
    }

    public final boolean getShowVoiceSettings() {
        return this.showVoiceSettings;
    }

    public final UserProfileStageActionsView$ViewState getStageViewState() {
        return this.stageViewState;
    }

    public final StreamContext getStreamContext() {
        return this.streamContext;
    }

    public final User getUser() {
        return this.user;
    }

    public final boolean getUserInSameVoiceChannel() {
        return this.userInSameVoiceChannel;
    }

    public final String getUserNote() {
        return this.userNote;
    }

    public final StoreUserNotes$UserNoteState getUserNoteFetchState() {
        return this.userNoteFetchState;
    }

    public final UserProfile getUserProfile() {
        return this.userProfile;
    }

    public final int getUserRelationshipType() {
        return this.userRelationshipType;
    }

    public final UserProfileVoiceSettingsView$ViewState getVoiceSettingsViewState() {
        return this.voiceSettingsViewState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v48, types: [int] */
    /* JADX WARN: Type inference failed for: r2v63 */
    /* JADX WARN: Type inference failed for: r2v78 */
    /* JADX WARN: Type inference failed for: r2v79 */
    /* JADX WARN: Type inference failed for: r2v80 */
    /* JADX WARN: Type inference failed for: r2v81 */
    /* JADX WARN: Type inference failed for: r2v82 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        boolean z2 = this.isMe;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        boolean z3 = this.showVoiceSettings;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (i + r3) * 31;
        UserProfileVoiceSettingsView$ViewState userProfileVoiceSettingsView$ViewState = this.voiceSettingsViewState;
        int iHashCode2 = (i2 + (userProfileVoiceSettingsView$ViewState != null ? userProfileVoiceSettingsView$ViewState.hashCode() : 0)) * 31;
        VoiceState voiceState = this.channelVoiceState;
        int iHashCode3 = (iHashCode2 + (voiceState != null ? voiceState.hashCode() : 0)) * 31;
        ModelRichPresence modelRichPresence = this.richPresence;
        int iHashCode4 = (iHashCode3 + (modelRichPresence != null ? modelRichPresence.hashCode() : 0)) * 31;
        String str = this.guildSectionHeaderText;
        int iHashCode5 = (iHashCode4 + (str != null ? str.hashCode() : 0)) * 31;
        List<GuildRole> list = this.roleItems;
        int iHashCode6 = (iHashCode5 + (list != null ? list.hashCode() : 0)) * 31;
        UserProfileAdminView$ViewState userProfileAdminView$ViewState = this.adminViewState;
        int iHashCode7 = (iHashCode6 + (userProfileAdminView$ViewState != null ? userProfileAdminView$ViewState.hashCode() : 0)) * 31;
        UserProfileStageActionsView$ViewState userProfileStageActionsView$ViewState = this.stageViewState;
        int iHashCode8 = (iHashCode7 + (userProfileStageActionsView$ViewState != null ? userProfileStageActionsView$ViewState.hashCode() : 0)) * 31;
        Channel channel = this.channel;
        int iHashCode9 = (iHashCode8 + (channel != null ? channel.hashCode() : 0)) * 31;
        StreamContext streamContext = this.streamContext;
        int iHashCode10 = (iHashCode9 + (streamContext != null ? streamContext.hashCode() : 0)) * 31;
        String str2 = this.guildName;
        int iHashCode11 = (iHashCode10 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.guildIcon;
        int iHashCode12 = (((iHashCode11 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.userRelationshipType) * 31;
        UserProfileConnectionsView$ViewState userProfileConnectionsView$ViewState = this.connectionsViewState;
        int iHashCode13 = (iHashCode12 + (userProfileConnectionsView$ViewState != null ? userProfileConnectionsView$ViewState.hashCode() : 0)) * 31;
        StoreUserNotes$UserNoteState storeUserNotes$UserNoteState = this.userNoteFetchState;
        int iHashCode14 = (iHashCode13 + (storeUserNotes$UserNoteState != null ? storeUserNotes$UserNoteState.hashCode() : 0)) * 31;
        String str4 = this.userNote;
        int iHashCode15 = (iHashCode14 + (str4 != null ? str4.hashCode() : 0)) * 31;
        boolean z4 = this.userInSameVoiceChannel;
        ?? r4 = z4;
        if (z4) {
            r4 = 1;
        }
        int i3 = (iHashCode15 + r4) * 31;
        List<Node<MessageRenderContext>> list2 = this.bioAst;
        int iHashCode16 = (i3 + (list2 != null ? list2.hashCode() : 0)) * 31;
        boolean z5 = this.profileLoaded;
        int i4 = (iHashCode16 + (z5 ? 1 : z5)) * 31;
        Long l = this.guildId;
        int iHashCode17 = (i4 + (l != null ? l.hashCode() : 0)) * 31;
        GuildMember guildMember = this.guildMember;
        int iHashCode18 = (iHashCode17 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        UserProfile userProfile = this.userProfile;
        return iHashCode18 + (userProfile != null ? userProfile.hashCode() : 0);
    }

    public final boolean isMe() {
        return this.isMe;
    }

    public final boolean shouldShowRoles() {
        Long l = this.currentGuildId;
        return (this.roleItems.isEmpty() ^ true) && (l != null && (l.longValue() > 0L ? 1 : (l.longValue() == 0L ? 0 : -1)) > 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(user=");
        sbU.append(this.user);
        sbU.append(", isMe=");
        sbU.append(this.isMe);
        sbU.append(", showVoiceSettings=");
        sbU.append(this.showVoiceSettings);
        sbU.append(", voiceSettingsViewState=");
        sbU.append(this.voiceSettingsViewState);
        sbU.append(", channelVoiceState=");
        sbU.append(this.channelVoiceState);
        sbU.append(", richPresence=");
        sbU.append(this.richPresence);
        sbU.append(", guildSectionHeaderText=");
        sbU.append(this.guildSectionHeaderText);
        sbU.append(", roleItems=");
        sbU.append(this.roleItems);
        sbU.append(", adminViewState=");
        sbU.append(this.adminViewState);
        sbU.append(", stageViewState=");
        sbU.append(this.stageViewState);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", streamContext=");
        sbU.append(this.streamContext);
        sbU.append(", guildName=");
        sbU.append(this.guildName);
        sbU.append(", guildIcon=");
        sbU.append(this.guildIcon);
        sbU.append(", userRelationshipType=");
        sbU.append(this.userRelationshipType);
        sbU.append(", connectionsViewState=");
        sbU.append(this.connectionsViewState);
        sbU.append(", userNoteFetchState=");
        sbU.append(this.userNoteFetchState);
        sbU.append(", userNote=");
        sbU.append(this.userNote);
        sbU.append(", userInSameVoiceChannel=");
        sbU.append(this.userInSameVoiceChannel);
        sbU.append(", bioAst=");
        sbU.append(this.bioAst);
        sbU.append(", profileLoaded=");
        sbU.append(this.profileLoaded);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", guildMember=");
        sbU.append(this.guildMember);
        sbU.append(", userProfile=");
        sbU.append(this.userProfile);
        sbU.append(")");
        return sbU.toString();
    }
}
