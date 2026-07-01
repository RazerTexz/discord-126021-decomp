package com.discord.widgets.channels.list;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.channel.ChannelUtils3;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.api.directory.DirectoryEntryGuild2;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityMetadata;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.api.permission.Permission;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreMentions;
import com.discord.stores.StoreMessageAck;
import com.discord.stores.StoreMessagesMostRecent;
import com.discord.stores.StoreNux;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadsActiveJoined;
import com.discord.stores.StoreThreadsJoined;
import com.discord.stores.StoreUserConnections;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.stores.utilities.RestCallState;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.utilities.directories.DirectoryUtils2;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableCombineLatestOverloads2;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.channels.list.WidgetChannelListModel;
import com.discord.widgets.channels.list.items.ChannelListBottomNavSpaceItem;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemActiveEvent;
import com.discord.widgets.channels.list.items.ChannelListItemActiveEvent2;
import com.discord.widgets.channels.list.items.ChannelListItemAddServer;
import com.discord.widgets.channels.list.items.ChannelListItemCategory;
import com.discord.widgets.channels.list.items.ChannelListItemDirectory;
import com.discord.widgets.channels.list.items.ChannelListItemEventsSeparator;
import com.discord.widgets.channels.list.items.ChannelListItemGuildJoinRequest;
import com.discord.widgets.channels.list.items.ChannelListItemGuildRoleSubscriptionsOverview;
import com.discord.widgets.channels.list.items.ChannelListItemGuildScheduledEvents;
import com.discord.widgets.channels.list.items.ChannelListItemInvite;
import com.discord.widgets.channels.list.items.ChannelListItemMfaNotice;
import com.discord.widgets.channels.list.items.ChannelListItemPrivate;
import com.discord.widgets.channels.list.items.ChannelListItemStageAudienceCount;
import com.discord.widgets.channels.list.items.ChannelListItemStageVoiceChannel;
import com.discord.widgets.channels.list.items.ChannelListItemTextChannel;
import com.discord.widgets.channels.list.items.ChannelListItemVoiceChannel;
import com.discord.widgets.channels.list.items.ChannelListItemVoiceUser;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventLocationInfo;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.stage.model.StageChannel;
import d0.f0._Sequences2;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.MutableCollectionsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func6;

/* JADX INFO: compiled from: WidgetChannelListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelListModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<GuildScheduledEvent> guildScheduledEvents;
    private final boolean isGuildSelected;
    private final List<ChannelListItem> items;
    private final Guild selectedGuild;
    private final boolean showEmptyState;
    private final boolean showPremiumGuildHint;

    /* JADX INFO: compiled from: WidgetChannelListModel.kt */
    public static final class Companion {

        /* JADX INFO: compiled from: WidgetChannelListModel.kt */
        public static final /* data */ class TextLikeChannelData {
            private final boolean hide;
            private final boolean locked;
            private final int mentionCount;
            private final boolean selected;
            private final boolean unread;

            public TextLikeChannelData(boolean z2, int i, boolean z3, boolean z4, boolean z5) {
                this.selected = z2;
                this.mentionCount = i;
                this.unread = z3;
                this.locked = z4;
                this.hide = z5;
            }

            public static /* synthetic */ TextLikeChannelData copy$default(TextLikeChannelData textLikeChannelData, boolean z2, int i, boolean z3, boolean z4, boolean z5, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    z2 = textLikeChannelData.selected;
                }
                if ((i2 & 2) != 0) {
                    i = textLikeChannelData.mentionCount;
                }
                int i3 = i;
                if ((i2 & 4) != 0) {
                    z3 = textLikeChannelData.unread;
                }
                boolean z6 = z3;
                if ((i2 & 8) != 0) {
                    z4 = textLikeChannelData.locked;
                }
                boolean z7 = z4;
                if ((i2 & 16) != 0) {
                    z5 = textLikeChannelData.hide;
                }
                return textLikeChannelData.copy(z2, i3, z6, z7, z5);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getSelected() {
                return this.selected;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getMentionCount() {
                return this.mentionCount;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getUnread() {
                return this.unread;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getLocked() {
                return this.locked;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final boolean getHide() {
                return this.hide;
            }

            public final TextLikeChannelData copy(boolean selected, int mentionCount, boolean unread, boolean locked, boolean hide) {
                return new TextLikeChannelData(selected, mentionCount, unread, locked, hide);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof TextLikeChannelData)) {
                    return false;
                }
                TextLikeChannelData textLikeChannelData = (TextLikeChannelData) other;
                return this.selected == textLikeChannelData.selected && this.mentionCount == textLikeChannelData.mentionCount && this.unread == textLikeChannelData.unread && this.locked == textLikeChannelData.locked && this.hide == textLikeChannelData.hide;
            }

            public final boolean getHide() {
                return this.hide;
            }

            public final boolean getLocked() {
                return this.locked;
            }

            public final int getMentionCount() {
                return this.mentionCount;
            }

            public final boolean getSelected() {
                return this.selected;
            }

            public final boolean getUnread() {
                return this.unread;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v10 */
            /* JADX WARN: Type inference failed for: r0v11 */
            /* JADX WARN: Type inference failed for: r0v5, types: [int] */
            /* JADX WARN: Type inference failed for: r0v7, types: [int] */
            /* JADX WARN: Type inference failed for: r0v9, types: [int] */
            /* JADX WARN: Type inference failed for: r1v0 */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r2v2, types: [int] */
            /* JADX WARN: Type inference failed for: r2v4, types: [int] */
            /* JADX WARN: Type inference failed for: r2v6 */
            /* JADX WARN: Type inference failed for: r2v7 */
            /* JADX WARN: Type inference failed for: r2v8 */
            /* JADX WARN: Type inference failed for: r2v9 */
            public int hashCode() {
                boolean z2 = this.selected;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = ((r0 * 31) + this.mentionCount) * 31;
                boolean z3 = this.unread;
                ?? r2 = z3;
                if (z3) {
                    r2 = 1;
                }
                int i2 = (i + r2) * 31;
                boolean z4 = this.locked;
                ?? r3 = z4;
                if (z4) {
                    r3 = 1;
                }
                int i3 = (i2 + r3) * 31;
                boolean z5 = this.hide;
                return i3 + (z5 ? 1 : z5);
            }

            public String toString() {
                StringBuilder sbU = outline.U("TextLikeChannelData(selected=");
                sbU.append(this.selected);
                sbU.append(", mentionCount=");
                sbU.append(this.mentionCount);
                sbU.append(", unread=");
                sbU.append(this.unread);
                sbU.append(", locked=");
                sbU.append(this.locked);
                sbU.append(", hide=");
                return outline.O(sbU, this.hide, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetChannelListModel.kt */
        public static final /* data */ class VocalChannelData {
            private final boolean isGuildRoleSubscriptionChannel;
            private final boolean isGuildRoleSubscriptionLockedChannel;
            private final boolean locked;
            private final int mentionCount;
            private final boolean nsfw;
            private final int numUsersConnected;
            private final Long permission;
            private final boolean textChannelSelected;
            private final boolean unread;
            private final boolean voiceChannelSelected;

            public VocalChannelData(boolean z2, boolean z3, int i, boolean z4, boolean z5, boolean z6, Long l, int i2, boolean z7, boolean z8) {
                this.voiceChannelSelected = z2;
                this.textChannelSelected = z3;
                this.mentionCount = i;
                this.unread = z4;
                this.locked = z5;
                this.nsfw = z6;
                this.permission = l;
                this.numUsersConnected = i2;
                this.isGuildRoleSubscriptionLockedChannel = z7;
                this.isGuildRoleSubscriptionChannel = z8;
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getVoiceChannelSelected() {
                return this.voiceChannelSelected;
            }

            /* JADX INFO: renamed from: component10, reason: from getter */
            public final boolean getIsGuildRoleSubscriptionChannel() {
                return this.isGuildRoleSubscriptionChannel;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getTextChannelSelected() {
                return this.textChannelSelected;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final int getMentionCount() {
                return this.mentionCount;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getUnread() {
                return this.unread;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final boolean getLocked() {
                return this.locked;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final boolean getNsfw() {
                return this.nsfw;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final Long getPermission() {
                return this.permission;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final int getNumUsersConnected() {
                return this.numUsersConnected;
            }

            /* JADX INFO: renamed from: component9, reason: from getter */
            public final boolean getIsGuildRoleSubscriptionLockedChannel() {
                return this.isGuildRoleSubscriptionLockedChannel;
            }

            public final VocalChannelData copy(boolean voiceChannelSelected, boolean textChannelSelected, int mentionCount, boolean unread, boolean locked, boolean nsfw, Long permission, int numUsersConnected, boolean isGuildRoleSubscriptionLockedChannel, boolean isGuildRoleSubscriptionChannel) {
                return new VocalChannelData(voiceChannelSelected, textChannelSelected, mentionCount, unread, locked, nsfw, permission, numUsersConnected, isGuildRoleSubscriptionLockedChannel, isGuildRoleSubscriptionChannel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof VocalChannelData)) {
                    return false;
                }
                VocalChannelData vocalChannelData = (VocalChannelData) other;
                return this.voiceChannelSelected == vocalChannelData.voiceChannelSelected && this.textChannelSelected == vocalChannelData.textChannelSelected && this.mentionCount == vocalChannelData.mentionCount && this.unread == vocalChannelData.unread && this.locked == vocalChannelData.locked && this.nsfw == vocalChannelData.nsfw && Intrinsics3.areEqual(this.permission, vocalChannelData.permission) && this.numUsersConnected == vocalChannelData.numUsersConnected && this.isGuildRoleSubscriptionLockedChannel == vocalChannelData.isGuildRoleSubscriptionLockedChannel && this.isGuildRoleSubscriptionChannel == vocalChannelData.isGuildRoleSubscriptionChannel;
            }

            public final boolean getLocked() {
                return this.locked;
            }

            public final int getMentionCount() {
                return this.mentionCount;
            }

            public final boolean getNsfw() {
                return this.nsfw;
            }

            public final int getNumUsersConnected() {
                return this.numUsersConnected;
            }

            public final Long getPermission() {
                return this.permission;
            }

            public final boolean getTextChannelSelected() {
                return this.textChannelSelected;
            }

            public final boolean getUnread() {
                return this.unread;
            }

            public final boolean getVoiceChannelSelected() {
                return this.voiceChannelSelected;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v11, types: [int] */
            /* JADX WARN: Type inference failed for: r0v17, types: [int] */
            /* JADX WARN: Type inference failed for: r0v19, types: [int] */
            /* JADX WARN: Type inference failed for: r0v20 */
            /* JADX WARN: Type inference failed for: r0v21 */
            /* JADX WARN: Type inference failed for: r0v3, types: [int] */
            /* JADX WARN: Type inference failed for: r0v7, types: [int] */
            /* JADX WARN: Type inference failed for: r0v9, types: [int] */
            /* JADX WARN: Type inference failed for: r1v0 */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v14, types: [int] */
            /* JADX WARN: Type inference failed for: r2v16 */
            /* JADX WARN: Type inference failed for: r2v18 */
            /* JADX WARN: Type inference failed for: r2v19 */
            /* JADX WARN: Type inference failed for: r2v20 */
            /* JADX WARN: Type inference failed for: r2v21 */
            /* JADX WARN: Type inference failed for: r2v22 */
            /* JADX WARN: Type inference failed for: r2v23 */
            /* JADX WARN: Type inference failed for: r2v24 */
            /* JADX WARN: Type inference failed for: r2v25 */
            /* JADX WARN: Type inference failed for: r2v26 */
            /* JADX WARN: Type inference failed for: r2v4, types: [int] */
            /* JADX WARN: Type inference failed for: r2v6, types: [int] */
            /* JADX WARN: Type inference failed for: r2v8, types: [int] */
            public int hashCode() {
                boolean z2 = this.voiceChannelSelected;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = r0 * 31;
                boolean z3 = this.textChannelSelected;
                ?? r2 = z3;
                if (z3) {
                    r2 = 1;
                }
                int i2 = (((i + r2) * 31) + this.mentionCount) * 31;
                boolean z4 = this.unread;
                ?? r3 = z4;
                if (z4) {
                    r3 = 1;
                }
                int i3 = (i2 + r3) * 31;
                boolean z5 = this.locked;
                ?? r4 = z5;
                if (z5) {
                    r4 = 1;
                }
                int i4 = (i3 + r4) * 31;
                boolean z6 = this.nsfw;
                ?? r5 = z6;
                if (z6) {
                    r5 = 1;
                }
                int i5 = (i4 + r5) * 31;
                Long l = this.permission;
                int iHashCode = (((i5 + (l != null ? l.hashCode() : 0)) * 31) + this.numUsersConnected) * 31;
                boolean z7 = this.isGuildRoleSubscriptionLockedChannel;
                ?? r6 = z7;
                if (z7) {
                    r6 = 1;
                }
                int i6 = (iHashCode + r6) * 31;
                boolean z8 = this.isGuildRoleSubscriptionChannel;
                return i6 + (z8 ? 1 : z8);
            }

            public final boolean isGuildRoleSubscriptionChannel() {
                return this.isGuildRoleSubscriptionChannel;
            }

            public final boolean isGuildRoleSubscriptionLockedChannel() {
                return this.isGuildRoleSubscriptionLockedChannel;
            }

            public String toString() {
                StringBuilder sbU = outline.U("VocalChannelData(voiceChannelSelected=");
                sbU.append(this.voiceChannelSelected);
                sbU.append(", textChannelSelected=");
                sbU.append(this.textChannelSelected);
                sbU.append(", mentionCount=");
                sbU.append(this.mentionCount);
                sbU.append(", unread=");
                sbU.append(this.unread);
                sbU.append(", locked=");
                sbU.append(this.locked);
                sbU.append(", nsfw=");
                sbU.append(this.nsfw);
                sbU.append(", permission=");
                sbU.append(this.permission);
                sbU.append(", numUsersConnected=");
                sbU.append(this.numUsersConnected);
                sbU.append(", isGuildRoleSubscriptionLockedChannel=");
                sbU.append(this.isGuildRoleSubscriptionLockedChannel);
                sbU.append(", isGuildRoleSubscriptionChannel=");
                return outline.O(sbU, this.isGuildRoleSubscriptionChannel, ")");
            }
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:85:0x0190  */
        private final ChannelListItemActiveEvent2 getChannelEventNoticeData(GuildChannelsInfo guildChannelsInfo, Map<Long, StageChannel> stageChannels, List<GuildScheduledEvent> guildScheduledEvents, Map<Long, ? extends Collection<ChannelListItemVoiceUser>> voiceStates, Map<Long, Channel> guildChannels, long selectedVoiceChannelId) {
            Object next;
            Object next2;
            GuildScheduledEventEntityMetadata entityMetadata;
            String location;
            boolean z2;
            Channel channel;
            List listEmptyList;
            ChannelListItemVoiceUser channelListItemVoiceUser;
            Object next3;
            GuildScheduledEvent guildScheduledEvent;
            Channel channel2;
            Long channelId;
            StageChannel stageChannel = (StageChannel) _Sequences2.firstOrNull(_Sequences2.filter(_Collections.asSequence(stageChannels.values()), WidgetChannelListModel$Companion$getChannelEventNoticeData$1.INSTANCE));
            if (stageChannel != null) {
                GuildScheduledEventLocationInfo.ChannelLocation channelLocation = new GuildScheduledEventLocationInfo.ChannelLocation(stageChannel.getChannel());
                int audienceSize = stageChannel.getAudienceSize();
                List<UserGuildMember> speakers = stageChannel.getSpeakers();
                boolean containsMe = stageChannel.getContainsMe();
                StageRoles stageRolesM46getMyRolestwRsX0 = stageChannel.m46getMyRolestwRsX0();
                boolean z3 = stageRolesM46getMyRolestwRsX0 != null && StageRoles.m33isSpeakerimpl(stageRolesM46getMyRolestwRsX0.m35unboximpl());
                StageInstance stageInstance = stageChannel.getStageInstance();
                return new ChannelListItemActiveEvent2(stageInstance != null ? stageInstance.getTopic() : null, channelLocation, audienceSize, speakers, containsMe, z3, null);
            }
            Iterator<T> it = guildScheduledEvents.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                guildScheduledEvent = (GuildScheduledEvent) next;
            } while (!(guildScheduledEvent.getStatus() == GuildScheduledEventStatus.ACTIVE && (channel2 = guildChannels.get(guildScheduledEvent.getChannelId())) != null && channel2.getType() == 2 && PermissionUtils.can(Permission.CONNECT, guildChannelsInfo.getChannelPermissions().get(guildScheduledEvent.getChannelId())) && ((channelId = guildScheduledEvent.getChannelId()) == null || channelId.longValue() != selectedVoiceChannelId)));
            GuildScheduledEvent guildScheduledEvent2 = (GuildScheduledEvent) next;
            if (guildScheduledEvent2 != null && (channel = guildChannels.get(guildScheduledEvent2.getChannelId())) != null) {
                Collection<ChannelListItemVoiceUser> collection = voiceStates.get(guildScheduledEvent2.getChannelId());
                if (collection != null) {
                    listEmptyList = new ArrayList(Iterables2.collectionSizeOrDefault(collection, 10));
                    for (ChannelListItemVoiceUser channelListItemVoiceUser2 : collection) {
                        listEmptyList.add(new UserGuildMember(channelListItemVoiceUser2.getUser(), channelListItemVoiceUser2.getComputed()));
                    }
                } else {
                    listEmptyList = null;
                }
                long id2 = StoreStream.INSTANCE.getUsers().getMeSnapshot().getId();
                Collection<ChannelListItemVoiceUser> collection2 = voiceStates.get(guildScheduledEvent2.getChannelId());
                if (collection2 != null) {
                    Iterator<T> it2 = collection2.iterator();
                    do {
                        if (!it2.hasNext()) {
                            next3 = null;
                            break;
                        }
                        next3 = it2.next();
                    } while (!(((ChannelListItemVoiceUser) next3).getUser().getId() == id2));
                    channelListItemVoiceUser = (ChannelListItemVoiceUser) next3;
                } else {
                    channelListItemVoiceUser = null;
                }
                boolean z4 = channelListItemVoiceUser != null;
                if (!z4) {
                    GuildScheduledEventLocationInfo.ChannelLocation channelLocation2 = new GuildScheduledEventLocationInfo.ChannelLocation(channel);
                    if (listEmptyList == null) {
                        listEmptyList = Collections2.emptyList();
                    }
                    return new ChannelListItemActiveEvent2(guildScheduledEvent2.getName(), channelLocation2, 0, listEmptyList, z4, z4, null);
                }
            }
            Iterator<T> it3 = guildScheduledEvents.iterator();
            do {
                if (!it3.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it3.next();
                GuildScheduledEvent guildScheduledEvent3 = (GuildScheduledEvent) next2;
                if (guildScheduledEvent3.getStatus() == GuildScheduledEventStatus.ACTIVE && guildScheduledEvent3.getEntityType() == GuildScheduledEventEntityType.EXTERNAL) {
                    GuildScheduledEventEntityMetadata entityMetadata2 = guildScheduledEvent3.getEntityMetadata();
                    if ((entityMetadata2 != null ? entityMetadata2.getLocation() : null) != null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
            } while (!z2);
            GuildScheduledEvent guildScheduledEvent4 = (GuildScheduledEvent) next2;
            return (guildScheduledEvent4 == null || (entityMetadata = guildScheduledEvent4.getEntityMetadata()) == null || (location = entityMetadata.getLocation()) == null) ? (ChannelListItemActiveEvent2) null : new ChannelListItemActiveEvent2(guildScheduledEvent4.getName(), new GuildScheduledEventLocationInfo.ExternalLocation(location), 0, Collections2.emptyList(), false, false, Long.valueOf(guildScheduledEvent4.getId()));
        }

        private final Observable<WidgetChannelListModel> getPrivateChannelList() {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            final StoreChannels channels = companion.getChannels();
            final StoreChannelsSelected channelsSelected = companion.getChannelsSelected();
            final StoreUserPresence presences = companion.getPresences();
            final StoreMessagesMostRecent messagesMostRecent = companion.getMessagesMostRecent();
            final StoreMentions mentions = companion.getMentions();
            final StoreApplicationStreaming applicationStreaming = companion.getApplicationStreaming();
            final StoreUserGuildSettings userGuildSettings = companion.getUserGuildSettings();
            final StoreExperiments experiments = companion.getExperiments();
            final StoreUserConnections userConnections = companion.getUserConnections();
            Observable<WidgetChannelListModel> observableG = ObservableExtensionsKt.leadingEdgeThrottle(ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{channels, channelsSelected, presences, messagesMostRecent, mentions, applicationStreaming, userGuildSettings, experiments, userConnections}, false, null, null, 14, null), 250L, TimeUnit.MILLISECONDS).G(new Func1<Unit, WidgetChannelListModel>() { // from class: com.discord.widgets.channels.list.WidgetChannelListModel$Companion$getPrivateChannelList$1
                @Override // j0.k.Func1
                public final WidgetChannelListModel call(Unit unit) {
                    Map<Long, Channel> channelsForGuild = channels.getChannelsForGuild(0L);
                    Channel.Companion companion2 = Channel.INSTANCE;
                    Map<Long, Long> mostRecentIds = messagesMostRecent.getMostRecentIds();
                    Intrinsics3.checkNotNullParameter(companion2, "$this$getSortByMostRecent");
                    Intrinsics3.checkNotNullParameter(mostRecentIds, "mostRecentMessageIds");
                    ChannelUtils3 channelUtils3 = new ChannelUtils3(mostRecentIds);
                    long id2 = channelsSelected.getId();
                    Map<Long, Presence> mapM19getPresences = presences.m19getPresences();
                    Map<Long, Integer> mentionCounts = mentions.getMentionCounts();
                    Map<Long, ModelApplicationStream> streamsByUser = applicationStreaming.getStreamsByUser();
                    ModelNotificationSettings modelNotificationSettings = userGuildSettings.getGuildSettings().get(0L);
                    if (modelNotificationSettings == null) {
                        modelNotificationSettings = new ModelNotificationSettings();
                    }
                    experiments.getUserExperiment("2021-04_contact_sync_android_main", true);
                    userConnections.getStateSnapshot();
                    List listSortedWith = _Collections.sortedWith(channelsForGuild.values(), channelUtils3);
                    ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listSortedWith, 10));
                    Iterator<T> it = listSortedWith.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            return new WidgetChannelListModel(null, _Collections.plus((Collection<? extends ChannelListBottomNavSpaceItem>) arrayList, new ChannelListBottomNavSpaceItem(0L, 1, null)), false, false, arrayList.isEmpty(), null, 44, null);
                        }
                        Channel channel = (Channel) it.next();
                        User userA = ChannelUtils.a(channel);
                        Presence presence = mapM19getPresences.get(userA != null ? Long.valueOf(userA.getId()) : null);
                        boolean z2 = channel.getId() == id2;
                        Integer num = (Integer) outline.d(channel, mentionCounts);
                        int iIntValue = num != null ? num.intValue() : 0;
                        User userA2 = ChannelUtils.a(channel);
                        boolean zContainsKey = streamsByUser.containsKey(userA2 != null ? Long.valueOf(userA2.getId()) : null);
                        ModelNotificationSettings.ChannelOverride channelOverride = modelNotificationSettings.getChannelOverride(channel.getId());
                        arrayList.add(new ChannelListItemPrivate(channel, presence, z2, iIntValue, zContainsKey, channelOverride != null ? channelOverride.isMuted() : false));
                    }
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableG, "ObservationDeckProvider\n…            )\n          }");
            return observableG;
        }

        private final Observable<WidgetChannelListModel> getSelectedGuildChannelList(long selectedGuildId) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            long id2 = companion.getUsers().getMeSnapshot().getId();
            Observable<GuildChannelsInfo> observable = GuildChannelsInfo.INSTANCE.get(selectedGuildId);
            Observable observableObserveChannelsForGuild$default = StoreChannels.observeChannelsForGuild$default(companion.getChannels(), selectedGuildId, null, 2, null);
            Observable<Map<Long, StoreThreadsJoined.JoinedThread>> observableObserveJoinedThreads = companion.getThreadsJoined().observeJoinedThreads();
            Observable<Map<Long, Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>>> observableObserveActiveJoinedThreadsForGuild = companion.getThreadsActiveJoined().observeActiveJoinedThreadsForGuild(selectedGuildId);
            Observable<Set<Long>> observableObserveChannelsWithActiveThreadsByGuild = companion.getThreadsActive().observeChannelsWithActiveThreadsByGuild(selectedGuildId);
            Observable<Channel> observableObserveSelectedChannel = companion.getChannelsSelected().observeSelectedChannel();
            Observable<Long> observableObserveSelectedVoiceChannelId = companion.getVoiceChannelSelected().observeSelectedVoiceChannelId();
            Observable observable2 = VoiceStates.get$default(VoiceStates.INSTANCE, selectedGuildId, null, 2, null);
            Observable<Map<Long, Integer>> observableObserveMentionCounts = companion.getMentions().observeMentionCounts();
            Observable<Set<Long>> unreadChannelIds = companion.getReadStates().getUnreadChannelIds();
            Observable<Set<Long>> observableObserveCollapsedCategories = companion.getStoreChannelCategories().observeCollapsedCategories(selectedGuildId);
            Observable<StoreNux.NuxState> nuxState = companion.getNux().getNuxState();
            Observable<Map<Long, StageChannel>> observableObserveGuildStageChannels = companion.getStageChannels().observeGuildStageChannels(selectedGuildId);
            Observable<Map<Long, StageInstance>> observableObserveStageInstancesForGuild = companion.getStageInstances().observeStageInstancesForGuild(selectedGuildId);
            Observable observableObserveGuildScheduledEvents$default = StoreGuildScheduledEvents.observeGuildScheduledEvents$default(companion.getGuildScheduledEvents(), selectedGuildId, false, 2, null);
            Observable observableObserveCanCreateAnyEvent$default = GuildScheduledEventUtilities.Companion.observeCanCreateAnyEvent$default(GuildScheduledEventUtilities.INSTANCE, selectedGuildId, null, null, null, 14, null);
            Observable<Boolean> observableObserveCanGuildSeeGuildRoleSubscriptions = GuildRoleSubscriptionsFeatureFlag.INSTANCE.getINSTANCE().observeCanGuildSeeGuildRoleSubscriptions(selectedGuildId);
            Observable<Map<Long, RestCallState<List<DirectoryEntryGuild>>>> observableObserveDirectories = companion.getDirectories().observeDirectories();
            Observable<Map<Long, StoreMessageAck.Ack>> observableObserveAll = companion.getMessageAck().observeAll();
            Observable<Map<Long, RestCallState<List<DirectoryEntryGuild2>>>> observableObserveDirectoryGuildScheduledEvents = companion.getDirectories().observeDirectoryGuildScheduledEvents();
            Observable<GuildJoinRequest> observableObserveGuildJoinRequest = companion.getGuildJoinRequests().observeGuildJoinRequest(selectedGuildId);
            Observable<GuildMember> observableObserveGuildMember = companion.getGuilds().observeGuildMember(selectedGuildId, id2);
            Intrinsics3.checkNotNullExpressionValue(observableObserveGuildMember, "StoreStream\n            …er(selectedGuildId, meId)");
            return ObservableCombineLatestOverloads2.combineLatest(observable, observableObserveChannelsForGuild$default, observableObserveJoinedThreads, observableObserveActiveJoinedThreadsForGuild, observableObserveChannelsWithActiveThreadsByGuild, observableObserveSelectedChannel, observableObserveSelectedVoiceChannelId, observable2, observableObserveMentionCounts, unreadChannelIds, observableObserveCollapsedCategories, nuxState, observableObserveGuildStageChannels, observableObserveStageInstancesForGuild, observableObserveGuildScheduledEvents$default, observableObserveCanCreateAnyEvent$default, observableObserveCanGuildSeeGuildRoleSubscriptions, observableObserveDirectories, observableObserveAll, observableObserveDirectoryGuildScheduledEvents, observableObserveGuildJoinRequest, observableObserveGuildMember, new WidgetChannelListModel$Companion$getSelectedGuildChannelList$1(selectedGuildId));
        }

        /* JADX WARN: Code duplicated, block: B:132:0x04f8  */
        /* JADX WARN: Code duplicated, block: B:134:0x04fb  */
        /* JADX WARN: Code duplicated, block: B:164:0x0609  */
        /* JADX WARN: Code duplicated, block: B:167:0x0624  */
        /* JADX WARN: Code duplicated, block: B:192:0x0630 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:20:0x0080  */
        /* JADX WARN: Failed to find 'out' block for switch in B:67:0x03d0. Please report as an issue. */
        private final List<ChannelListItem> guildListBuilder(long selectedGuildId, GuildChannelsInfo guild, Map<Long, Channel> guildChannels, Map<Long, ? extends Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>> activeJoinedGuildThreads, Map<Long, StoreThreadsJoined.JoinedThread> joinedThreads, Set<Long> channelsWithActiveThreads, Channel selectedChannel, long selectedVoiceChannelId, Map<Long, ? extends Collection<ChannelListItemVoiceUser>> voiceStates, Map<Long, Integer> mentionCounts, Set<Long> unreadChannelIds, Set<Long> collapsedCategories, Map<Long, StageChannel> stageChannels, Map<Long, StageInstance> stageInstances, List<GuildScheduledEvent> guildScheduledEvents, boolean canCreateAnyEvent, boolean canSeeGuildRoleSubscriptions, Map<Long, ? extends RestCallState<? extends List<DirectoryEntryGuild>>> directories, Map<Long, StoreMessageAck.Ack> messageAcks, Map<Long, ? extends RestCallState<? extends List<DirectoryEntryGuild2>>> directoryEvents, GuildJoinRequest guildJoinRequest, GuildMember member) {
            boolean z2;
            WidgetChannelListModel$Companion$guildListBuilder$3 widgetChannelListModel$Companion$guildListBuilder$3;
            WidgetChannelListModel$Companion$guildListBuilder$2 widgetChannelListModel$Companion$guildListBuilder$2;
            ChannelListItemInvite channelListItemInvite;
            boolean z3;
            HashSet hashSet;
            Map<Long, Collection<Channel>> map;
            ArrayList arrayList;
            WidgetChannelListModel$Companion$guildListBuilder$5 widgetChannelListModel$Companion$guildListBuilder$5;
            WidgetChannelListModel$Companion$guildListBuilder$4 widgetChannelListModel$Companion$guildListBuilder$4;
            boolean z4;
            ChannelListItemTextChannel channelListItemTextChannelInvoke;
            List listEmptyList;
            char c;
            boolean z5;
            List list;
            Set<Long> set = collapsedCategories;
            ArrayList arrayList2 = new ArrayList(activeJoinedGuildThreads.size() + guildChannels.size());
            if (guild.getUnelevated()) {
                arrayList2.add(new ChannelListItemMfaNotice());
            }
            ChannelListItemActiveEvent2 channelEventNoticeData = getChannelEventNoticeData(guild, stageChannels, guildScheduledEvents, voiceStates, guildChannels, selectedVoiceChannelId);
            if (channelEventNoticeData != null) {
                arrayList2.add(new ChannelListItemEventsSeparator(true));
                arrayList2.add(new ChannelListItemActiveEvent(channelEventNoticeData));
                arrayList2.add(new ChannelListItemEventsSeparator(false));
            }
            Guild guild2 = guild.getGuild();
            if (guild2 != null) {
                if ((guildScheduledEvents.isEmpty() ^ true) || (guild2.getFeatures().contains(GuildFeature.COMMUNITY) && canCreateAnyEvent)) {
                    arrayList2.add(new ChannelListItemGuildScheduledEvents(guildScheduledEvents, guild2));
                }
            }
            if (canSeeGuildRoleSubscriptions) {
                arrayList2.add(ChannelListItemGuildRoleSubscriptionsOverview.INSTANCE);
            }
            Map<Long, Collection<Channel>> mapSortThreadsForChannelList = ThreadUtils.INSTANCE.sortThreadsForChannelList(activeJoinedGuildThreads, selectedChannel);
            Map<Long, Collection<Channel>> sortedCategories = guild.getSortedCategories(guildChannels);
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet();
            Guild guild3 = guild.getGuild();
            boolean z6 = guild3 != null && guild3.isHub();
            ChannelListItemInvite channelListItemInvite2 = new ChannelListItemInvite(selectedGuildId, z6);
            WidgetChannelListModel$Companion$guildListBuilder$2 widgetChannelListModel$Companion$guildListBuilder$6 = new WidgetChannelListModel$Companion$guildListBuilder$2(arrayList2, hashSet2, set);
            WidgetChannelListModel$Companion$guildListBuilder$3 widgetChannelListModel$Companion$guildListBuilder$7 = new WidgetChannelListModel$Companion$guildListBuilder$3(unreadChannelIds);
            WidgetChannelListModel$Companion$guildListBuilder$4 widgetChannelListModel$Companion$guildListBuilder$8 = new WidgetChannelListModel$Companion$guildListBuilder$4(mapSortThreadsForChannelList, widgetChannelListModel$Companion$guildListBuilder$7);
            WidgetChannelListModel$Companion$guildListBuilder$5 widgetChannelListModel$Companion$guildListBuilder$9 = new WidgetChannelListModel$Companion$guildListBuilder$5(mapSortThreadsForChannelList, selectedChannel);
            for (Map.Entry<Long, Collection<Channel>> entry : sortedCategories.entrySet()) {
                WidgetChannelListModel$Companion$guildListBuilder$3 widgetChannelListModel$Companion$guildListBuilder$10 = widgetChannelListModel$Companion$guildListBuilder$7;
                long jLongValue = entry.getKey().longValue();
                Collection<Channel> value = entry.getValue();
                WidgetChannelListModel$Companion$guildListBuilder$2 widgetChannelListModel$Companion$guildListBuilder$11 = widgetChannelListModel$Companion$guildListBuilder$6;
                ChannelListItemInvite channelListItemInvite3 = channelListItemInvite2;
                Map<Long, Collection<Channel>> map2 = mapSortThreadsForChannelList;
                ArrayList arrayList3 = arrayList2;
                boolean zCan = PermissionUtils.can(Permission.VIEW_CHANNEL, guild.getChannelPermissions().get(Long.valueOf(jLongValue)));
                boolean zCan2 = PermissionUtils.can(16L, guild.getChannelPermissions().get(Long.valueOf(jLongValue)));
                if (zCan && zCan2) {
                    hashSet2.add(Long.valueOf(jLongValue));
                }
                ModelNotificationSettings.ChannelOverride channelOverride = guild.getNotificationSettings().getChannelOverride(jLongValue);
                boolean z7 = channelOverride != null && channelOverride.isMuted();
                for (Channel channel : value) {
                    long id2 = channel.getId();
                    Long l = guild.getChannelPermissions().get(Long.valueOf(id2));
                    ModelNotificationSettings.ChannelOverride channelOverride2 = guild.getNotificationSettings().getChannelOverride(id2);
                    boolean z8 = channelOverride2 != null && channelOverride2.isMuted();
                    if (z6) {
                        z2 = z8;
                        if (channel.getType() != 14 && !GrowthTeamFeatures.INSTANCE.hubStudyGroupEnabled()) {
                            widgetChannelListModel$Companion$guildListBuilder$3 = widgetChannelListModel$Companion$guildListBuilder$10;
                            widgetChannelListModel$Companion$guildListBuilder$2 = widgetChannelListModel$Companion$guildListBuilder$11;
                            channelListItemInvite = channelListItemInvite3;
                            z3 = z6;
                            hashSet = hashSet2;
                            collapsedCategories = set;
                            widgetChannelListModel$Companion$guildListBuilder$5 = widgetChannelListModel$Companion$guildListBuilder$9;
                            widgetChannelListModel$Companion$guildListBuilder$4 = widgetChannelListModel$Companion$guildListBuilder$8;
                            arrayList = arrayList3;
                            map = map2;
                            z4 = zCan2;
                        }
                        arrayList3 = arrayList;
                        z6 = z3;
                        zCan2 = z4;
                        widgetChannelListModel$Companion$guildListBuilder$10 = widgetChannelListModel$Companion$guildListBuilder$3;
                        widgetChannelListModel$Companion$guildListBuilder$11 = widgetChannelListModel$Companion$guildListBuilder$2;
                        channelListItemInvite3 = channelListItemInvite;
                        hashSet2 = hashSet;
                        map2 = map;
                        widgetChannelListModel$Companion$guildListBuilder$9 = widgetChannelListModel$Companion$guildListBuilder$5;
                        widgetChannelListModel$Companion$guildListBuilder$8 = widgetChannelListModel$Companion$guildListBuilder$4;
                        set = collapsedCategories;
                    } else {
                        z2 = z8;
                    }
                    boolean z9 = z2;
                    widgetChannelListModel$Companion$guildListBuilder$3 = widgetChannelListModel$Companion$guildListBuilder$10;
                    widgetChannelListModel$Companion$guildListBuilder$2 = widgetChannelListModel$Companion$guildListBuilder$11;
                    channelListItemInvite = channelListItemInvite3;
                    z3 = z6;
                    hashSet = hashSet2;
                    map = map2;
                    boolean z10 = zCan2;
                    arrayList = arrayList3;
                    widgetChannelListModel$Companion$guildListBuilder$5 = widgetChannelListModel$Companion$guildListBuilder$9;
                    widgetChannelListModel$Companion$guildListBuilder$4 = widgetChannelListModel$Companion$guildListBuilder$8;
                    WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1 widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1 = new WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1(z7, guild, hashSet2, z6, selectedChannel, mentionCounts, unreadChannelIds, selectedGuildId, widgetChannelListModel$Companion$guildListBuilder$9, collapsedCategories, widgetChannelListModel$Companion$guildListBuilder$3, hashSet3, widgetChannelListModel$Companion$guildListBuilder$8, selectedVoiceChannelId, voiceStates, canSeeGuildRoleSubscriptions, channelsWithActiveThreads, guildScheduledEvents, stageInstances, stageChannels, map, joinedThreads, arrayList, widgetChannelListModel$Companion$guildListBuilder$2, messageAcks, directories, directoryEvents);
                    WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$2 widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$2 = new WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$2(id2, channel, l, guild, hashSet, z3, selectedChannel, mentionCounts, unreadChannelIds, selectedGuildId, widgetChannelListModel$Companion$guildListBuilder$5, collapsedCategories, widgetChannelListModel$Companion$guildListBuilder$3, hashSet3, widgetChannelListModel$Companion$guildListBuilder$4, selectedVoiceChannelId, voiceStates, canSeeGuildRoleSubscriptions, channelsWithActiveThreads, guildScheduledEvents, stageInstances, stageChannels, map, joinedThreads, arrayList, widgetChannelListModel$Companion$guildListBuilder$2, messageAcks, directories, directoryEvents);
                    WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$3 widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$3 = new WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$3(channel, l, widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1, z9, guild, hashSet, z3, selectedChannel, mentionCounts, unreadChannelIds, selectedGuildId, widgetChannelListModel$Companion$guildListBuilder$5, collapsedCategories, widgetChannelListModel$Companion$guildListBuilder$3, hashSet3, widgetChannelListModel$Companion$guildListBuilder$4, selectedVoiceChannelId, voiceStates, canSeeGuildRoleSubscriptions, channelsWithActiveThreads, guildScheduledEvents, stageInstances, stageChannels, map, joinedThreads, arrayList, widgetChannelListModel$Companion$guildListBuilder$2, messageAcks, directories, directoryEvents);
                    WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$4 widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$4 = new WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$4(widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1, guild, hashSet, z3, selectedChannel, mentionCounts, unreadChannelIds, selectedGuildId, widgetChannelListModel$Companion$guildListBuilder$5, collapsedCategories, widgetChannelListModel$Companion$guildListBuilder$3, hashSet3, widgetChannelListModel$Companion$guildListBuilder$4, selectedVoiceChannelId, voiceStates, canSeeGuildRoleSubscriptions, channelsWithActiveThreads, guildScheduledEvents, stageInstances, stageChannels, map, joinedThreads, arrayList, widgetChannelListModel$Companion$guildListBuilder$2, messageAcks, directories, directoryEvents);
                    WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$5 widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$5 = new WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$5(widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$2, channel, l, guild, hashSet, z3, selectedChannel, mentionCounts, unreadChannelIds, selectedGuildId, widgetChannelListModel$Companion$guildListBuilder$5, collapsedCategories, widgetChannelListModel$Companion$guildListBuilder$3, hashSet3, widgetChannelListModel$Companion$guildListBuilder$4, selectedVoiceChannelId, voiceStates, canSeeGuildRoleSubscriptions, channelsWithActiveThreads, guildScheduledEvents, stageInstances, stageChannels, map, joinedThreads, arrayList, widgetChannelListModel$Companion$guildListBuilder$2, messageAcks, directories, directoryEvents);
                    WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$6 widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$6 = new WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$6(widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$2, channel, l, guild, hashSet, z3, selectedChannel, mentionCounts, unreadChannelIds, selectedGuildId, widgetChannelListModel$Companion$guildListBuilder$5, collapsedCategories, widgetChannelListModel$Companion$guildListBuilder$3, hashSet3, widgetChannelListModel$Companion$guildListBuilder$4, selectedVoiceChannelId, voiceStates, canSeeGuildRoleSubscriptions, channelsWithActiveThreads, guildScheduledEvents, stageInstances, stageChannels, map, joinedThreads, arrayList, widgetChannelListModel$Companion$guildListBuilder$2, messageAcks, directories, directoryEvents);
                    WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$7 widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$7 = new WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$7(widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$4, guild, hashSet, z3, selectedChannel, mentionCounts, unreadChannelIds, selectedGuildId, widgetChannelListModel$Companion$guildListBuilder$5, collapsedCategories, widgetChannelListModel$Companion$guildListBuilder$3, hashSet3, widgetChannelListModel$Companion$guildListBuilder$4, selectedVoiceChannelId, voiceStates, canSeeGuildRoleSubscriptions, channelsWithActiveThreads, guildScheduledEvents, stageInstances, stageChannels, map, joinedThreads, arrayList, widgetChannelListModel$Companion$guildListBuilder$2, messageAcks, directories, directoryEvents);
                    WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$8 widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$8 = new WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$8(id2, guild, hashSet, z3, selectedChannel, mentionCounts, unreadChannelIds, selectedGuildId, widgetChannelListModel$Companion$guildListBuilder$5, collapsedCategories, widgetChannelListModel$Companion$guildListBuilder$3, hashSet3, widgetChannelListModel$Companion$guildListBuilder$4, selectedVoiceChannelId, voiceStates, canSeeGuildRoleSubscriptions, channelsWithActiveThreads, guildScheduledEvents, stageInstances, stageChannels, map, joinedThreads, arrayList, widgetChannelListModel$Companion$guildListBuilder$2, messageAcks, directories, directoryEvents);
                    int type = channel.getType();
                    if (type == 0) {
                        z4 = z10;
                        channelListItemTextChannelInvoke = widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$3.invoke();
                        if (channelListItemTextChannelInvoke != null) {
                            arrayList.add(channelListItemTextChannelInvoke);
                            arrayList.addAll(widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$7.invoke(channel));
                        }
                    } else if (type == 2) {
                        z3 = z3;
                        collapsedCategories = collapsedCategories;
                        arrayList = arrayList;
                        z4 = z10;
                        ChannelListItemVoiceChannel channelListItemVoiceChannelInvoke = widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$5.invoke();
                        if (channelListItemVoiceChannelInvoke != null) {
                            arrayList.add(channelListItemVoiceChannelInvoke);
                            Collection<ChannelListItemVoiceUser> collectionEmptyList = voiceStates.get(Long.valueOf(id2));
                            if (collectionEmptyList == null) {
                                collectionEmptyList = Collections2.emptyList();
                            }
                            arrayList.addAll(collectionEmptyList);
                        }
                    } else if (type == 4) {
                        z3 = z3;
                        arrayList = arrayList;
                        widgetChannelListModel$Companion$guildListBuilder$2.invoke2();
                        collapsedCategories = collapsedCategories;
                        z4 = z10;
                        arrayList.add(new ChannelListItemCategory(channel, collapsedCategories.contains(Long.valueOf(id2)), z9, z4));
                    } else if (type != 5) {
                        channelListItemGuildScheduledEvents = null;
                        ChannelListItem channelListItemGuildScheduledEvents = null;
                        switch (type) {
                            case 13:
                                z3 = z3;
                                arrayList = arrayList;
                                ChannelListItemStageVoiceChannel channelListItemStageVoiceChannelInvoke = widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$6.invoke();
                                if (channelListItemStageVoiceChannelInvoke != null) {
                                    arrayList.add(channelListItemStageVoiceChannelInvoke);
                                    arrayList.addAll(widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$8.invoke());
                                    StageChannel stageChannel = stageChannels.get(Long.valueOf(id2));
                                    Integer numValueOf = stageChannel != null ? Integer.valueOf(stageChannel.getAudienceSize()) : null;
                                    if (numValueOf != null && (numValueOf.intValue() > 0 || channelListItemStageVoiceChannelInvoke.getHasActiveEvent() || channelListItemStageVoiceChannelInvoke.getHasSpeakers())) {
                                        arrayList.add(new ChannelListItemStageAudienceCount(channel, numValueOf.intValue()));
                                    }
                                }
                                collapsedCategories = collapsedCategories;
                                z4 = z10;
                                break;
                            case 14:
                                if (PermissionUtils.INSTANCE.hasAccess(channel, l) && GrowthTeamFeatures.INSTANCE.isHubEnabled()) {
                                    StoreMessageAck.Ack ack = messageAcks.get(Long.valueOf(id2));
                                    long messageId = ack != null ? ack.getMessageId() : 0L;
                                    RestCallState restCallState = (RestCallState) outline.d(channel, directories);
                                    List listEmptyList2 = restCallState != null ? (List) restCallState.invoke() : null;
                                    if (listEmptyList2 == null) {
                                        listEmptyList2 = Collections2.emptyList();
                                    }
                                    ArrayList arrayList4 = new ArrayList();
                                    for (Object obj : listEmptyList2) {
                                        DirectoryEntryGuild directoryEntryGuild = (DirectoryEntryGuild) obj;
                                        if (messageId != 0 && DirectoryUtils2.hasMinimumMemberCount(directoryEntryGuild) && ((directoryEntryGuild.getCreatedAt().getDateTimeMillis() - SnowflakeUtils.DISCORD_EPOCH) << 22) > messageId) {
                                            arrayList4.add(obj);
                                        }
                                    }
                                    ChannelListItemDirectory channelListItemDirectory = new ChannelListItemDirectory(channel, selectedChannel != null && channel.getId() == selectedChannel.getId(), Math.min(5, arrayList4.size()));
                                    z3 = z3;
                                    if (z3 && GrowthTeamFeatures.INSTANCE.isHubEnabled()) {
                                        RestCallState restCallState2 = (RestCallState) outline.d(channel, directoryEvents);
                                        if (restCallState2 == null || (list = (List) restCallState2.invoke()) == null) {
                                            listEmptyList = null;
                                        } else {
                                            listEmptyList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                                            Iterator it = list.iterator();
                                            while (it.hasNext()) {
                                                listEmptyList.add(((DirectoryEntryGuild2) it.next()).getGuildScheduledEvent());
                                            }
                                        }
                                        if (listEmptyList == null) {
                                            listEmptyList = Collections2.emptyList();
                                        }
                                        ChannelListItem[] channelListItemArr = new ChannelListItem[4];
                                        Guild guild4 = guild.getGuild();
                                        if (guild4 != null) {
                                            if (ChannelUtils.x(channel)) {
                                                c = 1;
                                            } else {
                                                c = 1;
                                                z5 = GrowthTeamFeatures.INSTANCE.hubEventsEnabled(channel.getGuildId(), true);
                                                if (!z5) {
                                                    guild4 = null;
                                                }
                                                if (guild4 != null) {
                                                    channelListItemGuildScheduledEvents = new ChannelListItemGuildScheduledEvents(listEmptyList, guild4);
                                                }
                                            }
                                            if (!z5) {
                                                guild4 = null;
                                            }
                                            if (guild4 != null) {
                                                channelListItemGuildScheduledEvents = new ChannelListItemGuildScheduledEvents(listEmptyList, guild4);
                                            }
                                        } else {
                                            c = 1;
                                        }
                                        channelListItemArr[0] = channelListItemGuildScheduledEvents;
                                        channelListItemArr[c] = channelListItemDirectory;
                                        channelListItemArr[2] = new ChannelListItemAddServer();
                                        channelListItemArr[3] = new ChannelListItemInvite(selectedGuildId, z3);
                                        List listListOfNotNull = Collections2.listOfNotNull((Object[]) channelListItemArr);
                                        arrayList = arrayList;
                                        arrayList.addAll(listListOfNotNull);
                                    } else {
                                        arrayList = arrayList;
                                        arrayList.add(channelListItemDirectory);
                                    }
                                } else {
                                    z3 = z3;
                                    arrayList = arrayList;
                                }
                                collapsedCategories = collapsedCategories;
                                z4 = z10;
                                break;
                            case 15:
                                z4 = z10;
                                channelListItemTextChannelInvoke = widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$3.invoke();
                                if (channelListItemTextChannelInvoke != null) {
                                    arrayList.add(channelListItemTextChannelInvoke);
                                    arrayList.addAll(widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$7.invoke(channel));
                                }
                                break;
                            default:
                                z3 = z3;
                                arrayList = arrayList;
                                collapsedCategories = collapsedCategories;
                                z4 = z10;
                                break;
                        }
                    } else {
                        z4 = z10;
                        channelListItemTextChannelInvoke = widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$3.invoke();
                        if (channelListItemTextChannelInvoke != null) {
                            arrayList.add(channelListItemTextChannelInvoke);
                            arrayList.addAll(widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$7.invoke(channel));
                        }
                    }
                    arrayList3 = arrayList;
                    z6 = z3;
                    zCan2 = z4;
                    widgetChannelListModel$Companion$guildListBuilder$10 = widgetChannelListModel$Companion$guildListBuilder$3;
                    widgetChannelListModel$Companion$guildListBuilder$11 = widgetChannelListModel$Companion$guildListBuilder$2;
                    channelListItemInvite3 = channelListItemInvite;
                    hashSet2 = hashSet;
                    map2 = map;
                    widgetChannelListModel$Companion$guildListBuilder$9 = widgetChannelListModel$Companion$guildListBuilder$5;
                    widgetChannelListModel$Companion$guildListBuilder$8 = widgetChannelListModel$Companion$guildListBuilder$4;
                    set = collapsedCategories;
                }
                widgetChannelListModel$Companion$guildListBuilder$7 = widgetChannelListModel$Companion$guildListBuilder$10;
                widgetChannelListModel$Companion$guildListBuilder$6 = widgetChannelListModel$Companion$guildListBuilder$11;
                channelListItemInvite2 = channelListItemInvite3;
                arrayList2 = arrayList3;
                mapSortThreadsForChannelList = map2;
                hashSet2 = hashSet2;
            }
            WidgetChannelListModel$Companion$guildListBuilder$2 widgetChannelListModel$Companion$guildListBuilder$12 = widgetChannelListModel$Companion$guildListBuilder$6;
            ChannelListItemInvite channelListItemInvite4 = channelListItemInvite2;
            boolean z11 = z6;
            ArrayList arrayList5 = arrayList2;
            if (guild.getAbleToInstantInvite() && !z11) {
                arrayList5.add(guild.getUnelevated() ? 1 : 0, channelListItemInvite4);
            }
            if (guildJoinRequest != null && member != null && guildJoinRequest.getApplicationStatus() != ApplicationStatus.APPROVED && member.getPending()) {
                boolean unelevated = guild.getUnelevated();
                arrayList5.add(unelevated ? 1 : 0, new ChannelListItemEventsSeparator(false));
                arrayList5.add(unelevated ? 1 : 0, new ChannelListItemGuildJoinRequest(guildJoinRequest, member));
            }
            widgetChannelListModel$Companion$guildListBuilder$12.invoke2();
            return arrayList5;
        }

        public final Observable<WidgetChannelListModel> get() {
            Observable<WidgetChannelListModel> observableR = StoreStream.INSTANCE.getGuildSelected().observeSelectedGuildId().Y(new Func1<Long, Observable<? extends WidgetChannelListModel>>() { // from class: com.discord.widgets.channels.list.WidgetChannelListModel$Companion$get$1
                @Override // j0.k.Func1
                public final Observable<? extends WidgetChannelListModel> call(Long l) {
                    if (l != null && l.longValue() == 0) {
                        return WidgetChannelListModel.INSTANCE.getPrivateChannelList();
                    }
                    WidgetChannelListModel.Companion companion = WidgetChannelListModel.INSTANCE;
                    Intrinsics3.checkNotNullExpressionValue(l, "guildId");
                    return companion.getSelectedGuildChannelList(l.longValue());
                }
            }).r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream\n          .g…  .distinctUntilChanged()");
            return observableR;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChannelListModel.kt */
    public static abstract class ThreadSpineType {

        /* JADX INFO: compiled from: WidgetChannelListModel.kt */
        public static final class End extends ThreadSpineType {
            public static final End INSTANCE = new End();

            private End() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetChannelListModel.kt */
        public static final class Middle extends ThreadSpineType {
            public static final Middle INSTANCE = new Middle();

            private Middle() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetChannelListModel.kt */
        public static final class Single extends ThreadSpineType {
            public static final Single INSTANCE = new Single();

            private Single() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetChannelListModel.kt */
        public static final class Start extends ThreadSpineType {
            public static final Start INSTANCE = new Start();

            private Start() {
                super(null);
            }
        }

        private ThreadSpineType() {
        }

        public /* synthetic */ ThreadSpineType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChannelListModel.kt */
    public static final class VoiceStates {
        public static final VoiceStates INSTANCE = new VoiceStates();

        private VoiceStates() {
        }

        private final Map<Long, List<ChannelListItemVoiceUser>> createVoiceStates(Map<Long, VoiceState> voiceStates, Map<Long, ? extends User> users, Map<Long, GuildMember> computed, Map<Long, Channel> channels, Map<Long, ? extends ModelApplicationStream> guildStreams, Map<Long, Long> guildPermissions, Comparator<ChannelListItemVoiceUser> voiceUserComparator) {
            Long channelId;
            Channel channel;
            HashMap map = new HashMap();
            for (VoiceState voiceState : voiceStates.values()) {
                long userId = voiceState.getUserId();
                User user = users.get(Long.valueOf(userId));
                if (user != null && (channelId = voiceState.getChannelId()) != null) {
                    long jLongValue = channelId.longValue();
                    boolean zCan = PermissionUtils.can(Permission.CONNECT, guildPermissions.get(Long.valueOf(jLongValue)));
                    Long lValueOf = Long.valueOf(jLongValue);
                    Object arrayList = map.get(lValueOf);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        map.put(lValueOf, arrayList);
                    }
                    List list = (List) arrayList;
                    GuildMember guildMember = computed.get(Long.valueOf(userId));
                    if (guildMember != null && (channel = channels.get(Long.valueOf(jLongValue))) != null) {
                        list.add(new ChannelListItemVoiceUser(channel, voiceState, user, guildMember, guildStreams.containsKey(Long.valueOf(userId)), zCan));
                    }
                }
            }
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                MutableCollectionsJVM.sortWith((List) ((Map.Entry) it.next()).getValue(), voiceUserComparator);
            }
            return map;
        }

        private final Comparator<ChannelListItemVoiceUser> createVoiceUserComparator() {
            return new Comparator<ChannelListItemVoiceUser>() { // from class: com.discord.widgets.channels.list.WidgetChannelListModel$VoiceStates$createVoiceUserComparator$1
                @Override // java.util.Comparator
                public final int compare(ChannelListItemVoiceUser channelListItemVoiceUser, ChannelListItemVoiceUser channelListItemVoiceUser2) {
                    if (channelListItemVoiceUser.isApplicationStreaming() && !channelListItemVoiceUser2.isApplicationStreaming()) {
                        return -1;
                    }
                    if (!channelListItemVoiceUser2.isApplicationStreaming() || channelListItemVoiceUser.isApplicationStreaming()) {
                        return GuildMember.INSTANCE.compareUserNames(channelListItemVoiceUser.getUser(), channelListItemVoiceUser2.getUser(), channelListItemVoiceUser.getComputed(), channelListItemVoiceUser2.getComputed());
                    }
                    return 1;
                }
            };
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Observable get$default(VoiceStates voiceStates, long j, Comparator comparator, int i, Object obj) {
            if ((i & 2) != 0) {
                comparator = voiceStates.createVoiceUserComparator();
            }
            return voiceStates.get(j, comparator);
        }

        public final Observable<Map<Long, List<ChannelListItemVoiceUser>>> get(long guildId, final Comparator<ChannelListItemVoiceUser> voiceUserComparator) {
            Intrinsics3.checkNotNullParameter(voiceUserComparator, "voiceUserComparator");
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable observableF = Observable.f(companion.getApplicationStreaming().observeStreamsForGuild(guildId), ObservableExtensionsKt.leadingEdgeThrottle(companion.getVoiceStates().observe(guildId), 200L, TimeUnit.MILLISECONDS), companion.getUsers().observeAllUsers(), companion.getGuilds().observeComputed(guildId), StoreChannels.observeChannelsForGuild$default(companion.getChannels(), guildId, null, 2, null), companion.getPermissions().observeChannelPermissionsForGuild(guildId), new Func6<Map<Long, ? extends ModelApplicationStream>, Map<Long, ? extends VoiceState>, Map<Long, ? extends User>, Map<Long, ? extends GuildMember>, Map<Long, ? extends Channel>, Map<Long, ? extends Long>, Map<Long, ? extends List<? extends ChannelListItemVoiceUser>>>() { // from class: com.discord.widgets.channels.list.WidgetChannelListModel$VoiceStates$get$1
                @Override // rx.functions.Func6
                public /* bridge */ /* synthetic */ Map<Long, ? extends List<? extends ChannelListItemVoiceUser>> call(Map<Long, ? extends ModelApplicationStream> map, Map<Long, ? extends VoiceState> map2, Map<Long, ? extends User> map3, Map<Long, ? extends GuildMember> map4, Map<Long, ? extends Channel> map5, Map<Long, ? extends Long> map6) {
                    return call2(map, (Map<Long, VoiceState>) map2, map3, (Map<Long, GuildMember>) map4, (Map<Long, Channel>) map5, (Map<Long, Long>) map6);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final Map<Long, List<ChannelListItemVoiceUser>> call2(Map<Long, ? extends ModelApplicationStream> map, Map<Long, VoiceState> map2, Map<Long, ? extends User> map3, Map<Long, GuildMember> map4, Map<Long, Channel> map5, Map<Long, Long> map6) {
                    WidgetChannelListModel.VoiceStates voiceStates = WidgetChannelListModel.VoiceStates.INSTANCE;
                    Intrinsics3.checkNotNullExpressionValue(map2, "voiceStates");
                    Intrinsics3.checkNotNullExpressionValue(map3, "users");
                    Intrinsics3.checkNotNullExpressionValue(map4, "guildMembers");
                    Intrinsics3.checkNotNullExpressionValue(map5, "guildChannels");
                    Intrinsics3.checkNotNullExpressionValue(map, "guildStreams");
                    Intrinsics3.checkNotNullExpressionValue(map6, "guildPermissions");
                    return voiceStates.createVoiceStates(map2, map3, map4, map5, map, map6, voiceUserComparator);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableF, "Observable\n          .co…            )\n          }");
            Observable<Map<Long, List<ChannelListItemVoiceUser>>> observableR = ObservableExtensionsKt.computationLatest(observableF).r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n          .co…  .distinctUntilChanged()");
            return observableR;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetChannelListModel(Guild guild, List<? extends ChannelListItem> list, boolean z2, boolean z3, boolean z4, List<GuildScheduledEvent> list2) {
        Intrinsics3.checkNotNullParameter(list, "items");
        Intrinsics3.checkNotNullParameter(list2, "guildScheduledEvents");
        this.selectedGuild = guild;
        this.items = list;
        this.isGuildSelected = z2;
        this.showPremiumGuildHint = z3;
        this.showEmptyState = z4;
        this.guildScheduledEvents = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChannelListModel copy$default(WidgetChannelListModel widgetChannelListModel, Guild guild, List list, boolean z2, boolean z3, boolean z4, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = widgetChannelListModel.selectedGuild;
        }
        if ((i & 2) != 0) {
            list = widgetChannelListModel.items;
        }
        List list3 = list;
        if ((i & 4) != 0) {
            z2 = widgetChannelListModel.isGuildSelected;
        }
        boolean z5 = z2;
        if ((i & 8) != 0) {
            z3 = widgetChannelListModel.showPremiumGuildHint;
        }
        boolean z6 = z3;
        if ((i & 16) != 0) {
            z4 = widgetChannelListModel.showEmptyState;
        }
        boolean z7 = z4;
        if ((i & 32) != 0) {
            list2 = widgetChannelListModel.guildScheduledEvents;
        }
        return widgetChannelListModel.copy(guild, list3, z5, z6, z7, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getSelectedGuild() {
        return this.selectedGuild;
    }

    public final List<ChannelListItem> component2() {
        return this.items;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsGuildSelected() {
        return this.isGuildSelected;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getShowPremiumGuildHint() {
        return this.showPremiumGuildHint;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getShowEmptyState() {
        return this.showEmptyState;
    }

    public final List<GuildScheduledEvent> component6() {
        return this.guildScheduledEvents;
    }

    public final WidgetChannelListModel copy(Guild selectedGuild, List<? extends ChannelListItem> items, boolean isGuildSelected, boolean showPremiumGuildHint, boolean showEmptyState, List<GuildScheduledEvent> guildScheduledEvents) {
        Intrinsics3.checkNotNullParameter(items, "items");
        Intrinsics3.checkNotNullParameter(guildScheduledEvents, "guildScheduledEvents");
        return new WidgetChannelListModel(selectedGuild, items, isGuildSelected, showPremiumGuildHint, showEmptyState, guildScheduledEvents);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelListModel)) {
            return false;
        }
        WidgetChannelListModel widgetChannelListModel = (WidgetChannelListModel) other;
        return Intrinsics3.areEqual(this.selectedGuild, widgetChannelListModel.selectedGuild) && Intrinsics3.areEqual(this.items, widgetChannelListModel.items) && this.isGuildSelected == widgetChannelListModel.isGuildSelected && this.showPremiumGuildHint == widgetChannelListModel.showPremiumGuildHint && this.showEmptyState == widgetChannelListModel.showEmptyState && Intrinsics3.areEqual(this.guildScheduledEvents, widgetChannelListModel.guildScheduledEvents);
    }

    public final List<GuildScheduledEvent> getGuildScheduledEvents() {
        return this.guildScheduledEvents;
    }

    public final List<ChannelListItem> getItems() {
        return this.items;
    }

    public final Guild getSelectedGuild() {
        return this.selectedGuild;
    }

    public final boolean getShowEmptyState() {
        return this.showEmptyState;
    }

    public final boolean getShowPremiumGuildHint() {
        return this.showPremiumGuildHint;
    }

    public final boolean getStartsWithPaddedElement() {
        ChannelListItem channelListItem = (ChannelListItem) _Collections.firstOrNull((List) this.items);
        if (channelListItem != null) {
            return (channelListItem instanceof ChannelListItemInvite) || (channelListItem instanceof ChannelListItemMfaNotice) || (channelListItem instanceof ChannelListItemCategory) || (channelListItem instanceof ChannelListItemEventsSeparator) || (channelListItem instanceof ChannelListItemGuildJoinRequest);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Guild guild = this.selectedGuild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        List<ChannelListItem> list = this.items;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.isGuildSelected;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode2 + r2) * 31;
        boolean z3 = this.showPremiumGuildHint;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (i + r3) * 31;
        boolean z4 = this.showEmptyState;
        int i3 = (i2 + (z4 ? 1 : z4)) * 31;
        List<GuildScheduledEvent> list2 = this.guildScheduledEvents;
        return i3 + (list2 != null ? list2.hashCode() : 0);
    }

    public final boolean isGuildSelected() {
        return this.isGuildSelected;
    }

    public String toString() {
        StringBuilder sbU = outline.U("WidgetChannelListModel(selectedGuild=");
        sbU.append(this.selectedGuild);
        sbU.append(", items=");
        sbU.append(this.items);
        sbU.append(", isGuildSelected=");
        sbU.append(this.isGuildSelected);
        sbU.append(", showPremiumGuildHint=");
        sbU.append(this.showPremiumGuildHint);
        sbU.append(", showEmptyState=");
        sbU.append(this.showEmptyState);
        sbU.append(", guildScheduledEvents=");
        return outline.L(sbU, this.guildScheduledEvents, ")");
    }

    public /* synthetic */ WidgetChannelListModel(Guild guild, List list, boolean z2, boolean z3, boolean z4, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(guild, list, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? false : z4, (i & 32) != 0 ? Collections2.emptyList() : list2);
    }
}
