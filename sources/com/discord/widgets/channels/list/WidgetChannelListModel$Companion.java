package com.discord.widgets.channels.list;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.directory.DirectoryEntryEvent;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityMetadata;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.api.permission.Permission;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.domain.ModelNotificationSettings$ChannelOverride;
import com.discord.models.guild.Guild;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreMentions;
import com.discord.stores.StoreMessageAck$Ack;
import com.discord.stores.StoreMessagesMostRecent;
import com.discord.stores.StoreNux$NuxState;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreThreadsActiveJoined$ActiveJoinedThread;
import com.discord.stores.StoreThreadsJoined$JoinedThread;
import com.discord.stores.StoreUserConnections;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.stores.utilities.RestCallState;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.utilities.directories.DirectoryUtilsKt;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities$Companion;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableCombineLatestOverloadsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemActiveEvent;
import com.discord.widgets.channels.list.items.ChannelListItemActiveEventData;
import com.discord.widgets.channels.list.items.ChannelListItemAddServer;
import com.discord.widgets.channels.list.items.ChannelListItemCategory;
import com.discord.widgets.channels.list.items.ChannelListItemDirectory;
import com.discord.widgets.channels.list.items.ChannelListItemEventsSeparator;
import com.discord.widgets.channels.list.items.ChannelListItemGuildJoinRequest;
import com.discord.widgets.channels.list.items.ChannelListItemGuildRoleSubscriptionsOverview;
import com.discord.widgets.channels.list.items.ChannelListItemGuildScheduledEvents;
import com.discord.widgets.channels.list.items.ChannelListItemInvite;
import com.discord.widgets.channels.list.items.ChannelListItemMfaNotice;
import com.discord.widgets.channels.list.items.ChannelListItemStageAudienceCount;
import com.discord.widgets.channels.list.items.ChannelListItemStageVoiceChannel;
import com.discord.widgets.channels.list.items.ChannelListItemTextChannel;
import com.discord.widgets.channels.list.items.ChannelListItemVoiceChannel;
import com.discord.widgets.channels.list.items.ChannelListItemVoiceUser;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventLocationInfo$ChannelLocation;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventLocationInfo$ExternalLocation;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.stage.model.StageChannel;
import d0.f0.q;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelListModel$Companion {
    private WidgetChannelListModel$Companion() {
    }

    public static final /* synthetic */ Observable access$getPrivateChannelList(WidgetChannelListModel$Companion widgetChannelListModel$Companion) {
        return widgetChannelListModel$Companion.getPrivateChannelList();
    }

    public static final /* synthetic */ Observable access$getSelectedGuildChannelList(WidgetChannelListModel$Companion widgetChannelListModel$Companion, long j) {
        return widgetChannelListModel$Companion.getSelectedGuildChannelList(j);
    }

    public static final /* synthetic */ List access$guildListBuilder(WidgetChannelListModel$Companion widgetChannelListModel$Companion, long j, GuildChannelsInfo guildChannelsInfo, Map map, Map map2, Map map3, Set set, Channel channel, long j2, Map map4, Map map5, Set set2, Set set3, Map map6, Map map7, List list, boolean z2, boolean z3, Map map8, Map map9, Map map10, GuildJoinRequest guildJoinRequest, GuildMember guildMember) {
        return widgetChannelListModel$Companion.guildListBuilder(j, guildChannelsInfo, map, map2, map3, set, channel, j2, map4, map5, set2, set3, map6, map7, list, z2, z3, map8, map9, map10, guildJoinRequest, guildMember);
    }

    /* JADX WARN: Code duplicated, block: B:85:0x0190  */
    private final ChannelListItemActiveEventData getChannelEventNoticeData(GuildChannelsInfo guildChannelsInfo, Map<Long, StageChannel> stageChannels, List<GuildScheduledEvent> guildScheduledEvents, Map<Long, ? extends Collection<ChannelListItemVoiceUser>> voiceStates, Map<Long, Channel> guildChannels, long selectedVoiceChannelId) {
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
        StageChannel stageChannel = (StageChannel) q.firstOrNull(q.filter(u.asSequence(stageChannels.values()), WidgetChannelListModel$Companion$getChannelEventNoticeData$1.INSTANCE));
        if (stageChannel != null) {
            GuildScheduledEventLocationInfo$ChannelLocation guildScheduledEventLocationInfo$ChannelLocation = new GuildScheduledEventLocationInfo$ChannelLocation(stageChannel.getChannel());
            int audienceSize = stageChannel.getAudienceSize();
            List<UserGuildMember> speakers = stageChannel.getSpeakers();
            boolean containsMe = stageChannel.getContainsMe();
            StageRoles stageRolesM46getMyRolestwRsX0 = stageChannel.m46getMyRolestwRsX0();
            boolean z3 = stageRolesM46getMyRolestwRsX0 != null && StageRoles.m33isSpeakerimpl(stageRolesM46getMyRolestwRsX0.m35unboximpl());
            StageInstance stageInstance = stageChannel.getStageInstance();
            return new ChannelListItemActiveEventData(stageInstance != null ? stageInstance.getTopic() : null, guildScheduledEventLocationInfo$ChannelLocation, audienceSize, speakers, containsMe, z3, null);
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
                listEmptyList = new ArrayList(o.collectionSizeOrDefault(collection, 10));
                for (ChannelListItemVoiceUser channelListItemVoiceUser2 : collection) {
                    listEmptyList.add(new UserGuildMember(channelListItemVoiceUser2.getUser(), channelListItemVoiceUser2.getComputed()));
                }
            } else {
                listEmptyList = null;
            }
            long id2 = StoreStream.Companion.getUsers().getMeSnapshot().getId();
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
                GuildScheduledEventLocationInfo$ChannelLocation guildScheduledEventLocationInfo$ChannelLocation2 = new GuildScheduledEventLocationInfo$ChannelLocation(channel);
                if (listEmptyList == null) {
                    listEmptyList = n.emptyList();
                }
                return new ChannelListItemActiveEventData(guildScheduledEvent2.getName(), guildScheduledEventLocationInfo$ChannelLocation2, 0, listEmptyList, z4, z4, null);
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
        return (guildScheduledEvent4 == null || (entityMetadata = guildScheduledEvent4.getEntityMetadata()) == null || (location = entityMetadata.getLocation()) == null) ? (ChannelListItemActiveEventData) null : new ChannelListItemActiveEventData(guildScheduledEvent4.getName(), new GuildScheduledEventLocationInfo$ExternalLocation(location), 0, n.emptyList(), false, false, Long.valueOf(guildScheduledEvent4.getId()));
    }

    private final Observable<WidgetChannelListModel> getPrivateChannelList() {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        StoreChannels channels = storeStream$Companion.getChannels();
        StoreChannelsSelected channelsSelected = storeStream$Companion.getChannelsSelected();
        StoreUserPresence presences = storeStream$Companion.getPresences();
        StoreMessagesMostRecent messagesMostRecent = storeStream$Companion.getMessagesMostRecent();
        StoreMentions mentions = storeStream$Companion.getMentions();
        StoreApplicationStreaming applicationStreaming = storeStream$Companion.getApplicationStreaming();
        StoreUserGuildSettings userGuildSettings = storeStream$Companion.getUserGuildSettings();
        StoreExperiments experiments = storeStream$Companion.getExperiments();
        StoreUserConnections userConnections = storeStream$Companion.getUserConnections();
        Observable<WidgetChannelListModel> observableG = ObservableExtensionsKt.leadingEdgeThrottle(ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck$UpdateSource[]{channels, channelsSelected, presences, messagesMostRecent, mentions, applicationStreaming, userGuildSettings, experiments, userConnections}, false, null, null, 14, null), 250L, TimeUnit.MILLISECONDS).G(new WidgetChannelListModel$Companion$getPrivateChannelList$1(channels, messagesMostRecent, channelsSelected, presences, mentions, applicationStreaming, userGuildSettings, experiments, userConnections));
        m.checkNotNullExpressionValue(observableG, "ObservationDeckProvider\n…            )\n          }");
        return observableG;
    }

    private final Observable<WidgetChannelListModel> getSelectedGuildChannelList(long selectedGuildId) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        long id2 = storeStream$Companion.getUsers().getMeSnapshot().getId();
        Observable<GuildChannelsInfo> observable = GuildChannelsInfo.Companion.get(selectedGuildId);
        Observable observableObserveChannelsForGuild$default = StoreChannels.observeChannelsForGuild$default(storeStream$Companion.getChannels(), selectedGuildId, null, 2, null);
        Observable<Map<Long, StoreThreadsJoined$JoinedThread>> observableObserveJoinedThreads = storeStream$Companion.getThreadsJoined().observeJoinedThreads();
        Observable<Map<Long, Map<Long, StoreThreadsActiveJoined$ActiveJoinedThread>>> observableObserveActiveJoinedThreadsForGuild = storeStream$Companion.getThreadsActiveJoined().observeActiveJoinedThreadsForGuild(selectedGuildId);
        Observable<Set<Long>> observableObserveChannelsWithActiveThreadsByGuild = storeStream$Companion.getThreadsActive().observeChannelsWithActiveThreadsByGuild(selectedGuildId);
        Observable<Channel> observableObserveSelectedChannel = storeStream$Companion.getChannelsSelected().observeSelectedChannel();
        Observable<Long> observableObserveSelectedVoiceChannelId = storeStream$Companion.getVoiceChannelSelected().observeSelectedVoiceChannelId();
        Observable observable2 = WidgetChannelListModel$VoiceStates.get$default(WidgetChannelListModel$VoiceStates.INSTANCE, selectedGuildId, null, 2, null);
        Observable<Map<Long, Integer>> observableObserveMentionCounts = storeStream$Companion.getMentions().observeMentionCounts();
        Observable<Set<Long>> unreadChannelIds = storeStream$Companion.getReadStates().getUnreadChannelIds();
        Observable<Set<Long>> observableObserveCollapsedCategories = storeStream$Companion.getStoreChannelCategories().observeCollapsedCategories(selectedGuildId);
        Observable<StoreNux$NuxState> nuxState = storeStream$Companion.getNux().getNuxState();
        Observable<Map<Long, StageChannel>> observableObserveGuildStageChannels = storeStream$Companion.getStageChannels().observeGuildStageChannels(selectedGuildId);
        Observable<Map<Long, StageInstance>> observableObserveStageInstancesForGuild = storeStream$Companion.getStageInstances().observeStageInstancesForGuild(selectedGuildId);
        Observable observableObserveGuildScheduledEvents$default = StoreGuildScheduledEvents.observeGuildScheduledEvents$default(storeStream$Companion.getGuildScheduledEvents(), selectedGuildId, false, 2, null);
        Observable observableObserveCanCreateAnyEvent$default = GuildScheduledEventUtilities$Companion.observeCanCreateAnyEvent$default(GuildScheduledEventUtilities.Companion, selectedGuildId, null, null, null, 14, null);
        Observable<Boolean> observableObserveCanGuildSeeGuildRoleSubscriptions = GuildRoleSubscriptionsFeatureFlag.Companion.getINSTANCE().observeCanGuildSeeGuildRoleSubscriptions(selectedGuildId);
        Observable<Map<Long, RestCallState<List<DirectoryEntryGuild>>>> observableObserveDirectories = storeStream$Companion.getDirectories().observeDirectories();
        Observable<Map<Long, StoreMessageAck$Ack>> observableObserveAll = storeStream$Companion.getMessageAck().observeAll();
        Observable<Map<Long, RestCallState<List<DirectoryEntryEvent>>>> observableObserveDirectoryGuildScheduledEvents = storeStream$Companion.getDirectories().observeDirectoryGuildScheduledEvents();
        Observable<GuildJoinRequest> observableObserveGuildJoinRequest = storeStream$Companion.getGuildJoinRequests().observeGuildJoinRequest(selectedGuildId);
        Observable<GuildMember> observableObserveGuildMember = storeStream$Companion.getGuilds().observeGuildMember(selectedGuildId, id2);
        m.checkNotNullExpressionValue(observableObserveGuildMember, "StoreStream\n            …er(selectedGuildId, meId)");
        return ObservableCombineLatestOverloadsKt.combineLatest(observable, observableObserveChannelsForGuild$default, observableObserveJoinedThreads, observableObserveActiveJoinedThreadsForGuild, observableObserveChannelsWithActiveThreadsByGuild, observableObserveSelectedChannel, observableObserveSelectedVoiceChannelId, observable2, observableObserveMentionCounts, unreadChannelIds, observableObserveCollapsedCategories, nuxState, observableObserveGuildStageChannels, observableObserveStageInstancesForGuild, observableObserveGuildScheduledEvents$default, observableObserveCanCreateAnyEvent$default, observableObserveCanGuildSeeGuildRoleSubscriptions, observableObserveDirectories, observableObserveAll, observableObserveDirectoryGuildScheduledEvents, observableObserveGuildJoinRequest, observableObserveGuildMember, new WidgetChannelListModel$Companion$getSelectedGuildChannelList$1(selectedGuildId));
    }

    /* JADX WARN: Code duplicated, block: B:132:0x04f8  */
    /* JADX WARN: Code duplicated, block: B:134:0x04fb  */
    /* JADX WARN: Code duplicated, block: B:164:0x0609  */
    /* JADX WARN: Code duplicated, block: B:167:0x0624  */
    /* JADX WARN: Code duplicated, block: B:192:0x0630 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:20:0x0080  */
    /* JADX WARN: Failed to find 'out' block for switch in B:67:0x03d0. Please report as an issue. */
    private final List<ChannelListItem> guildListBuilder(long selectedGuildId, GuildChannelsInfo guild, Map<Long, Channel> guildChannels, Map<Long, ? extends Map<Long, StoreThreadsActiveJoined$ActiveJoinedThread>> activeJoinedGuildThreads, Map<Long, StoreThreadsJoined$JoinedThread> joinedThreads, Set<Long> channelsWithActiveThreads, Channel selectedChannel, long selectedVoiceChannelId, Map<Long, ? extends Collection<ChannelListItemVoiceUser>> voiceStates, Map<Long, Integer> mentionCounts, Set<Long> unreadChannelIds, Set<Long> collapsedCategories, Map<Long, StageChannel> stageChannels, Map<Long, StageInstance> stageInstances, List<GuildScheduledEvent> guildScheduledEvents, boolean canCreateAnyEvent, boolean canSeeGuildRoleSubscriptions, Map<Long, ? extends RestCallState<? extends List<DirectoryEntryGuild>>> directories, Map<Long, StoreMessageAck$Ack> messageAcks, Map<Long, ? extends RestCallState<? extends List<DirectoryEntryEvent>>> directoryEvents, GuildJoinRequest guildJoinRequest, GuildMember member) {
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
        ChannelListItemActiveEventData channelEventNoticeData = getChannelEventNoticeData(guild, stageChannels, guildScheduledEvents, voiceStates, guildChannels, selectedVoiceChannelId);
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
        for (Map$Entry<Long, Collection<Channel>> map$Entry : sortedCategories.entrySet()) {
            WidgetChannelListModel$Companion$guildListBuilder$3 widgetChannelListModel$Companion$guildListBuilder$10 = widgetChannelListModel$Companion$guildListBuilder$7;
            long jLongValue = map$Entry.getKey().longValue();
            Collection<Channel> value = map$Entry.getValue();
            WidgetChannelListModel$Companion$guildListBuilder$2 widgetChannelListModel$Companion$guildListBuilder$11 = widgetChannelListModel$Companion$guildListBuilder$6;
            ChannelListItemInvite channelListItemInvite3 = channelListItemInvite2;
            Map<Long, Collection<Channel>> map2 = mapSortThreadsForChannelList;
            ArrayList arrayList3 = arrayList2;
            boolean zCan = PermissionUtils.can(Permission.VIEW_CHANNEL, guild.getChannelPermissions().get(Long.valueOf(jLongValue)));
            boolean zCan2 = PermissionUtils.can(16L, guild.getChannelPermissions().get(Long.valueOf(jLongValue)));
            if (zCan && zCan2) {
                hashSet2.add(Long.valueOf(jLongValue));
            }
            ModelNotificationSettings$ChannelOverride channelOverride = guild.getNotificationSettings().getChannelOverride(jLongValue);
            boolean z7 = channelOverride != null && channelOverride.isMuted();
            for (Channel channel : value) {
                long id2 = channel.getId();
                Long l = guild.getChannelPermissions().get(Long.valueOf(id2));
                ModelNotificationSettings$ChannelOverride channelOverride2 = guild.getNotificationSettings().getChannelOverride(id2);
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
                        arrayList.addAll(widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$7.invoke2(channel));
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
                            collectionEmptyList = n.emptyList();
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
                                arrayList.addAll(widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$8.invoke2());
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
                                StoreMessageAck$Ack storeMessageAck$Ack = messageAcks.get(Long.valueOf(id2));
                                long messageId = storeMessageAck$Ack != null ? storeMessageAck$Ack.getMessageId() : 0L;
                                RestCallState restCallState = (RestCallState) a.d(channel, directories);
                                List listEmptyList2 = restCallState != null ? (List) restCallState.invoke() : null;
                                if (listEmptyList2 == null) {
                                    listEmptyList2 = n.emptyList();
                                }
                                ArrayList arrayList4 = new ArrayList();
                                for (Object obj : listEmptyList2) {
                                    DirectoryEntryGuild directoryEntryGuild = (DirectoryEntryGuild) obj;
                                    if (messageId != 0 && DirectoryUtilsKt.hasMinimumMemberCount(directoryEntryGuild) && ((directoryEntryGuild.getCreatedAt().getDateTimeMillis() - SnowflakeUtils.DISCORD_EPOCH) << 22) > messageId) {
                                        arrayList4.add(obj);
                                    }
                                }
                                ChannelListItemDirectory channelListItemDirectory = new ChannelListItemDirectory(channel, selectedChannel != null && channel.getId() == selectedChannel.getId(), Math.min(5, arrayList4.size()));
                                z3 = z3;
                                if (z3 && GrowthTeamFeatures.INSTANCE.isHubEnabled()) {
                                    RestCallState restCallState2 = (RestCallState) a.d(channel, directoryEvents);
                                    if (restCallState2 == null || (list = (List) restCallState2.invoke()) == null) {
                                        listEmptyList = null;
                                    } else {
                                        listEmptyList = new ArrayList(o.collectionSizeOrDefault(list, 10));
                                        Iterator it = list.iterator();
                                        while (it.hasNext()) {
                                            listEmptyList.add(((DirectoryEntryEvent) it.next()).getGuildScheduledEvent());
                                        }
                                    }
                                    if (listEmptyList == null) {
                                        listEmptyList = n.emptyList();
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
                                    List listListOfNotNull = n.listOfNotNull((Object[]) channelListItemArr);
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
                                arrayList.addAll(widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$7.invoke2(channel));
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
                        arrayList.addAll(widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$7.invoke2(channel));
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
        Observable<WidgetChannelListModel> observableR = StoreStream.Companion.getGuildSelected().observeSelectedGuildId().Y(WidgetChannelListModel$Companion$get$1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "StoreStream\n          .g…  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ WidgetChannelListModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
