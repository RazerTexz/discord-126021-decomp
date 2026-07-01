package com.discord.widgets.guilds.list;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import androidx.media.AudioAttributesCompat;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.restapi.RestAPIParams$UserSettings;
import com.discord.stores.StoreGuildsSorted$Entry;
import com.discord.stores.StoreGuildsSorted$Entry$Folder;
import com.discord.stores.StoreGuildsSorted$Entry$SingletonGuild;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreNavigation$PanelAction;
import com.discord.stores.StoreStream;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.guilds.MemberVerificationUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import d0.c0.c;
import d0.f0.q;
import d0.t.n;
import d0.t.o;
import d0.t.r;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.Sequence;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsListViewModel extends d0<WidgetGuildsListViewModel$ViewState> {
    public static final WidgetGuildsListViewModel$Companion Companion = new WidgetGuildsListViewModel$Companion(null);
    private final Clock clock;
    private WidgetGuildListAdapter$Operation$TargetOperation currentTargetOperation;
    private final PublishSubject<WidgetGuildsListViewModel$Event> eventSubject;
    private boolean wasLeftPanelOpened;
    private boolean wasOnHomeTab;

    public WidgetGuildsListViewModel() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetGuildsListViewModel(Clock clock, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        clock = (i & 1) != 0 ? ClockFactory.get() : clock;
        this(clock, (i & 2) != 0 ? WidgetGuildsListViewModel$Companion.access$observeStores(Companion, clock) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetGuildsListViewModel widgetGuildsListViewModel, WidgetGuildsListViewModel$StoreState widgetGuildsListViewModel$StoreState) {
        widgetGuildsListViewModel.handleStoreState(widgetGuildsListViewModel$StoreState);
    }

    private final Sequence<GuildListItem$PrivateChannelItem> createDirectMessageItems(Map<Long, Channel> privateChannels, Map<Long, Integer> mentionCounts, ModelNotificationSettings dmSettings) {
        return q.map(q.sortedWith(q.filter(q.filterNotNull(u.asSequence(privateChannels.values())), new WidgetGuildsListViewModel$createDirectMessageItems$1(dmSettings, mentionCounts)), ChannelUtils.h(Channel.Companion)), new WidgetGuildsListViewModel$createDirectMessageItems$2(mentionCounts));
    }

    private final GuildListItem$GuildItem createGuildItem(Guild guild, long selectedGuildId, long selectedVoiceChannelId, Set<Long> unreadGuildIds, Map<Long, ? extends ModelNotificationSettings> guildSettings, int numMentions, Map<Long, ? extends List<Long>> channelIds, Map<Long, Channel> channels, Set<Long> lurkingGuildIds, Set<Long> guildIdsWithActiveStageEvents, Set<Long> guildIdsWithActiveScheduledEvents, Long folderId, Boolean isLastGuildInFolder, Map<Long, StreamContext> allApplicationStreamContexts, Map<Long, Long> allChannelPermissions, ApplicationStatus applicationStatus, boolean isPendingGuild) {
        boolean z2;
        long id2 = guild.getId();
        List<Long> list = channelIds.get(Long.valueOf(id2));
        ModelNotificationSettings modelNotificationSettings = guildSettings.get(Long.valueOf(id2));
        boolean zContains = (modelNotificationSettings == null || !modelNotificationSettings.isMuted()) ? unreadGuildIds.contains(Long.valueOf(id2)) : false;
        boolean z3 = id2 == selectedGuildId;
        if (selectedVoiceChannelId > 0 && list != null && !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                if (selectedVoiceChannelId == ((Number) it.next()).longValue()) {
                    z2 = true;
                    break;
                }
            }
        } else {
            z2 = false;
            break;
        }
        boolean zShouldDisplayVideoIconOnGuild = shouldDisplayVideoIconOnGuild(id2, modelNotificationSettings, allApplicationStreamContexts, allChannelPermissions);
        boolean zContains2 = lurkingGuildIds.contains(Long.valueOf(guild.getId()));
        boolean zContains3 = guildIdsWithActiveStageEvents.contains(Long.valueOf(guild.getId()));
        Channel channel = channels.get(Long.valueOf(selectedVoiceChannelId));
        return new GuildListItem$GuildItem(guild, numMentions, zContains2, zContains, z3, folderId, z2, zShouldDisplayVideoIconOnGuild, false, isLastGuildInFolder, applicationStatus, isPendingGuild, zContains3, channel != null && ChannelUtils.D(channel), guildIdsWithActiveScheduledEvents.contains(Long.valueOf(guild.getId())), 256, null);
    }

    public static /* synthetic */ GuildListItem$GuildItem createGuildItem$default(WidgetGuildsListViewModel widgetGuildsListViewModel, Guild guild, long j, long j2, Set set, Map map, int i, Map map2, Map map3, Set set2, Set set3, Set set4, Long l, Boolean bool, Map map4, Map map5, ApplicationStatus applicationStatus, boolean z2, int i2, Object obj) {
        return widgetGuildsListViewModel.createGuildItem(guild, j, j2, set, map, i, map2, map3, set2, set3, set4, l, bool, map4, map5, applicationStatus, (i2 & 65536) != 0 ? false : z2);
    }

    private final List<GuildListItem> createPendingGuildsFolder(List<Guild> pendingGuilds, Map<Long, GuildJoinRequest> guildJoinRequests, Set<Long> openFolderIds, long selectedGuildId, long selectedVoiceChannelId, Set<Long> unreadGuildIds, Map<Long, ? extends ModelNotificationSettings> guildSettings, Map<Long, ? extends List<Long>> channelIds, Map<Long, Channel> channels, Set<Long> lurkingGuildIds, Set<Long> guildIdsWithActiveStageEvents, Set<Long> guildIdsWithActiveScheduledEvents, Map<Long, StreamContext> allApplicationStreamContexts, Map<Long, Long> allChannelPermissions) {
        ArrayList arrayList = new ArrayList();
        GuildListItem$FolderItem guildListItem$FolderItem = new GuildListItem$FolderItem(-7L, null, null, openFolderIds.contains(-7L), pendingGuilds, false, false, false, 0, false, false);
        arrayList.add(guildListItem$FolderItem);
        if (guildListItem$FolderItem.isOpen()) {
            ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(pendingGuilds, 10));
            int i = 0;
            for (Object obj : pendingGuilds) {
                int i2 = i + 1;
                if (i < 0) {
                    n.throwIndexOverflow();
                }
                Guild guild = (Guild) obj;
                Long lValueOf = Long.valueOf(guildListItem$FolderItem.getFolderId());
                Boolean boolValueOf = Boolean.valueOf(n.getLastIndex(pendingGuilds) == i);
                GuildJoinRequest guildJoinRequest = (GuildJoinRequest) a.e(guild, guildJoinRequests);
                arrayList2.add(createGuildItem(guild, selectedGuildId, selectedVoiceChannelId, unreadGuildIds, guildSettings, 0, channelIds, channels, lurkingGuildIds, guildIdsWithActiveStageEvents, guildIdsWithActiveScheduledEvents, lValueOf, boolValueOf, allApplicationStreamContexts, allChannelPermissions, guildJoinRequest != null ? guildJoinRequest.getApplicationStatus() : null, true));
                i = i2;
            }
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:162:0x028d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x022b  */
    /* JADX WARN: Code duplicated, block: B:65:0x0251  */
    /* JADX WARN: Code duplicated, block: B:67:0x0263  */
    /* JADX WARN: Code duplicated, block: B:72:0x0277  */
    /* JADX WARN: Code duplicated, block: B:76:0x028b  */
    private final void handleStoreState(WidgetGuildsListViewModel$StoreState storeState) {
        boolean z2;
        ArrayList arrayList;
        ArrayList arrayList2;
        Sequence sequence;
        HashMap map;
        ArrayList arrayList3;
        HashMap map2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i;
        boolean z6;
        HashMap map3;
        ArrayList arrayList4;
        boolean z7;
        Integer num;
        ModelNotificationSettings modelNotificationSettings;
        ArrayList arrayList5 = new ArrayList(storeState.getPendingGuilds().size() + storeState.getSortedGuilds().size() + 3);
        arrayList5.add(new GuildListItem$FriendsItem(storeState.getSelectedGuildId() <= 0));
        r.addAll(arrayList5, createDirectMessageItems(storeState.getPrivateChannels(), storeState.getMentionCounts(), storeState.getGuildSettings().get(0L)));
        HashMap map4 = new HashMap();
        for (StoreGuildsSorted$Entry storeGuildsSorted$Entry : storeState.getSortedGuilds()) {
            if (storeGuildsSorted$Entry instanceof StoreGuildsSorted$Entry$SingletonGuild) {
                long id2 = ((StoreGuildsSorted$Entry$SingletonGuild) storeGuildsSorted$Entry).getGuild().getId();
                map4.put(Long.valueOf(id2), Integer.valueOf(sumMentionCountsForGuild(id2, storeState.getChannelIds(), storeState.getMentionCounts())));
            } else if (storeGuildsSorted$Entry instanceof StoreGuildsSorted$Entry$Folder) {
                Iterator<Guild> it = ((StoreGuildsSorted$Entry$Folder) storeGuildsSorted$Entry).getGuilds().iterator();
                while (it.hasNext()) {
                    long id3 = it.next().getId();
                    map4.put(Long.valueOf(id3), Integer.valueOf(sumMentionCountsForGuild(id3, storeState.getChannelIds(), storeState.getMentionCounts())));
                }
            }
        }
        Sequence sequenceFilter = q.filter(u.asSequence(storeState.getSortedGuilds()), WidgetGuildsListViewModel$handleStoreState$$inlined$filterIsInstance$1.INSTANCE);
        Objects.requireNonNull(sequenceFilter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
        Sequence map5 = q.map(q.filter(sequenceFilter, new WidgetGuildsListViewModel$handleStoreState$lurkerGuildItems$1(storeState)), new WidgetGuildsListViewModel$handleStoreState$lurkerGuildItems$2(this, storeState, map4));
        ArrayList arrayList6 = new ArrayList();
        for (StoreGuildsSorted$Entry storeGuildsSorted$Entry2 : q.filter(u.asSequence(storeState.getSortedGuilds()), new WidgetGuildsListViewModel$handleStoreState$2(storeState))) {
            if (storeGuildsSorted$Entry2 instanceof StoreGuildsSorted$Entry$SingletonGuild) {
                StoreGuildsSorted$Entry$SingletonGuild storeGuildsSorted$Entry$SingletonGuild = (StoreGuildsSorted$Entry$SingletonGuild) storeGuildsSorted$Entry2;
                Guild guild = storeGuildsSorted$Entry$SingletonGuild.getGuild();
                long selectedGuildId = storeState.getSelectedGuildId();
                long selectedVoiceChannelId = storeState.getSelectedVoiceChannelId();
                Set<Long> unreadGuildIds = storeState.getUnreadGuildIds();
                Map<Long, ModelNotificationSettings> guildSettings = storeState.getGuildSettings();
                Integer num2 = (Integer) map4.get(Long.valueOf(storeGuildsSorted$Entry$SingletonGuild.getGuild().getId()));
                if (num2 == null) {
                    num2 = 0;
                }
                m.checkNotNullExpressionValue(num2, "mentionCountsByGuild[folder.guild.id] ?: 0");
                int iIntValue = num2.intValue();
                Map<Long, List<Long>> channelIds = storeState.getChannelIds();
                Map<Long, Channel> channels = storeState.getChannels();
                Set<Long> lurkingGuildIds = storeState.getLurkingGuildIds();
                Set<Long> guildIdsWithActiveStageEvents = storeState.getGuildIdsWithActiveStageEvents();
                Set<Long> guildIdsWithActiveScheduledEvents = storeState.getGuildIdsWithActiveScheduledEvents();
                Map<Long, StreamContext> allApplicationStreamContexts = storeState.getAllApplicationStreamContexts();
                Map<Long, Long> allChannelPermissions = storeState.getAllChannelPermissions();
                ArrayList arrayList7 = arrayList6;
                GuildJoinRequest guildJoinRequest = storeState.getGuildJoinRequests().get(Long.valueOf(storeGuildsSorted$Entry$SingletonGuild.getGuild().getId()));
                sequence = map5;
                map = map4;
                arrayList3 = arrayList5;
                arrayList2 = arrayList7;
                arrayList2.add(createGuildItem$default(this, guild, selectedGuildId, selectedVoiceChannelId, unreadGuildIds, guildSettings, iIntValue, channelIds, channels, lurkingGuildIds, guildIdsWithActiveStageEvents, guildIdsWithActiveScheduledEvents, null, null, allApplicationStreamContexts, allChannelPermissions, guildJoinRequest != null ? guildJoinRequest.getApplicationStatus() : null, false, 65536, null));
            } else {
                arrayList2 = arrayList6;
                sequence = map5;
                map = map4;
                arrayList3 = arrayList5;
                if (storeGuildsSorted$Entry2 instanceof StoreGuildsSorted$Entry$Folder) {
                    StoreGuildsSorted$Entry$Folder storeGuildsSorted$Entry$Folder = (StoreGuildsSorted$Entry$Folder) storeGuildsSorted$Entry2;
                    boolean zContains = storeState.getOpenFolderIds().contains(Long.valueOf(storeGuildsSorted$Entry$Folder.getId()));
                    String str = "mentionCountsByGuild[guild.id] ?: 0";
                    if (zContains) {
                        map2 = map;
                        z3 = false;
                        z4 = false;
                        z5 = false;
                        i = 0;
                        z6 = false;
                    } else {
                        boolean z8 = false;
                        int iIntValue2 = 0;
                        boolean z9 = false;
                        boolean z10 = false;
                        boolean z11 = false;
                        for (Guild guild2 : storeGuildsSorted$Entry$Folder.getGuilds()) {
                            z9 = z9 || guild2.getId() == storeState.getSelectedGuildId();
                            if (z10) {
                                z10 = true;
                            } else {
                                List list = (List) a.e(guild2, storeState.getChannelIds());
                                if (list != null ? list.contains(Long.valueOf(storeState.getSelectedVoiceChannelId())) : false) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                            }
                            if (z11) {
                                z7 = true;
                            } else {
                                Channel channel = storeState.getChannels().get(Long.valueOf(storeState.getSelectedVoiceChannelId()));
                                if (channel != null) {
                                    z7 = true;
                                    if (ChannelUtils.D(channel)) {
                                    }
                                    if (!z8) {
                                        if (storeState.getUnreadGuildIds().contains(Long.valueOf(guild2.getId())) || ((modelNotificationSettings = (ModelNotificationSettings) a.e(guild2, storeState.getGuildSettings())) != null && modelNotificationSettings.isMuted() == z7)) {
                                            z8 = false;
                                        } else {
                                            z8 = true;
                                        }
                                    }
                                    HashMap map6 = map;
                                    num = (Integer) map6.get(Long.valueOf(guild2.getId()));
                                    if (num == null) {
                                        num = 0;
                                    }
                                    m.checkNotNullExpressionValue(num, "mentionCountsByGuild[guild.id] ?: 0");
                                    iIntValue2 += num.intValue();
                                    map = map6;
                                } else {
                                    z7 = true;
                                }
                                z11 = false;
                                if (!z8) {
                                    if (storeState.getUnreadGuildIds().contains(Long.valueOf(guild2.getId()))) {
                                        z8 = false;
                                    } else {
                                        z8 = false;
                                    }
                                }
                                HashMap map7 = map;
                                num = (Integer) map7.get(Long.valueOf(guild2.getId()));
                                if (num == null) {
                                    num = 0;
                                }
                                m.checkNotNullExpressionValue(num, "mentionCountsByGuild[guild.id] ?: 0");
                                iIntValue2 += num.intValue();
                                map = map7;
                            }
                            z11 = true;
                            if (!z8) {
                                if (storeState.getUnreadGuildIds().contains(Long.valueOf(guild2.getId()))) {
                                    z8 = false;
                                } else {
                                    z8 = false;
                                }
                            }
                            HashMap map8 = map;
                            num = (Integer) map8.get(Long.valueOf(guild2.getId()));
                            if (num == null) {
                                num = 0;
                            }
                            m.checkNotNullExpressionValue(num, "mentionCountsByGuild[guild.id] ?: 0");
                            iIntValue2 += num.intValue();
                            map = map8;
                        }
                        map2 = map;
                        z6 = z8;
                        i = iIntValue2;
                        z3 = z9;
                        z4 = z10;
                        z5 = z11;
                    }
                    arrayList2.add(new GuildListItem$FolderItem(storeGuildsSorted$Entry$Folder.getId(), storeGuildsSorted$Entry$Folder.getColor(), storeGuildsSorted$Entry$Folder.getName(), zContains, storeGuildsSorted$Entry$Folder.getGuilds(), z3, z4, z5, i, z6, false, 1024, null));
                    if (zContains) {
                        List<Guild> guilds = storeGuildsSorted$Entry$Folder.getGuilds();
                        ArrayList arrayList8 = new ArrayList(o.collectionSizeOrDefault(guilds, 10));
                        int i2 = 0;
                        for (Object obj : guilds) {
                            int i3 = i2 + 1;
                            if (i2 < 0) {
                                n.throwIndexOverflow();
                            }
                            Guild guild3 = (Guild) obj;
                            long selectedGuildId2 = storeState.getSelectedGuildId();
                            long selectedVoiceChannelId2 = storeState.getSelectedVoiceChannelId();
                            Set<Long> unreadGuildIds2 = storeState.getUnreadGuildIds();
                            Map<Long, ModelNotificationSettings> guildSettings2 = storeState.getGuildSettings();
                            Integer num3 = (Integer) map2.get(Long.valueOf(guild3.getId()));
                            if (num3 == null) {
                                num3 = 0;
                            }
                            m.checkNotNullExpressionValue(num3, str);
                            int iIntValue3 = num3.intValue();
                            Map<Long, List<Long>> channelIds2 = storeState.getChannelIds();
                            Map<Long, Channel> channels2 = storeState.getChannels();
                            Set<Long> lurkingGuildIds2 = storeState.getLurkingGuildIds();
                            Set<Long> guildIdsWithActiveStageEvents2 = storeState.getGuildIdsWithActiveStageEvents();
                            Set<Long> guildIdsWithActiveScheduledEvents2 = storeState.getGuildIdsWithActiveScheduledEvents();
                            Long lValueOf = Long.valueOf(storeGuildsSorted$Entry$Folder.getId());
                            ArrayList arrayList9 = arrayList8;
                            Boolean boolValueOf = Boolean.valueOf(n.getLastIndex(storeGuildsSorted$Entry$Folder.getGuilds()) == i2);
                            Map<Long, StreamContext> allApplicationStreamContexts2 = storeState.getAllApplicationStreamContexts();
                            Map<Long, Long> allChannelPermissions2 = storeState.getAllChannelPermissions();
                            GuildJoinRequest guildJoinRequest2 = (GuildJoinRequest) a.e(guild3, storeState.getGuildJoinRequests());
                            arrayList9.add(createGuildItem$default(this, guild3, selectedGuildId2, selectedVoiceChannelId2, unreadGuildIds2, guildSettings2, iIntValue3, channelIds2, channels2, lurkingGuildIds2, guildIdsWithActiveStageEvents2, guildIdsWithActiveScheduledEvents2, lValueOf, boolValueOf, allApplicationStreamContexts2, allChannelPermissions2, guildJoinRequest2 != null ? guildJoinRequest2.getApplicationStatus() : null, false, 65536, null));
                            arrayList8 = arrayList9;
                            i2 = i3;
                            map2 = map2;
                            str = str;
                            arrayList2 = arrayList2;
                        }
                        map3 = map2;
                        arrayList4 = arrayList2;
                        arrayList4.addAll(arrayList8);
                    } else {
                        map3 = map2;
                        arrayList4 = arrayList2;
                    }
                }
                arrayList6 = arrayList4;
                map4 = map3;
                map5 = sequence;
                arrayList5 = arrayList3;
            }
            arrayList4 = arrayList2;
            map3 = map;
            arrayList6 = arrayList4;
            map4 = map3;
            map5 = sequence;
            arrayList5 = arrayList3;
        }
        ArrayList arrayList10 = arrayList6;
        Sequence sequence2 = map5;
        ArrayList arrayList11 = arrayList5;
        if (storeState.getOpenFolderIds().contains(-7L)) {
            StoreStream.Companion.getGuildJoinRequests().fetchPendingGuilds();
        }
        Map<Long, GuildJoinRequest> guildJoinRequests = storeState.getGuildJoinRequests();
        if (guildJoinRequests.isEmpty()) {
            z2 = false;
            break;
        }
        Iterator<Map$Entry<Long, GuildJoinRequest>> it2 = guildJoinRequests.entrySet().iterator();
        while (true) {
            if (it2.hasNext()) {
                if (n.emptyList().contains(it2.next().getKey())) {
                    z2 = true;
                    break;
                }
            } else {
                z2 = false;
                break;
            }
        }
        if (z2) {
            arrayList = arrayList11;
            arrayList.addAll(createPendingGuildsFolder(storeState.getPendingGuilds(), storeState.getGuildJoinRequests(), storeState.getOpenFolderIds(), storeState.getSelectedGuildId(), storeState.getSelectedVoiceChannelId(), storeState.getUnreadGuildIds(), storeState.getGuildSettings(), storeState.getChannelIds(), storeState.getChannels(), storeState.getLurkingGuildIds(), storeState.getGuildIdsWithActiveStageEvents(), storeState.getGuildIdsWithActiveScheduledEvents(), storeState.getAllApplicationStreamContexts(), storeState.getAllChannelPermissions()));
        } else {
            arrayList = arrayList11;
        }
        r.addAll(arrayList, sequence2);
        GuildListItem$DividerItem guildListItem$DividerItem = GuildListItem$DividerItem.INSTANCE;
        arrayList.add(guildListItem$DividerItem);
        arrayList.addAll(arrayList10);
        if (!storeState.getUnavailableGuilds().isEmpty()) {
            arrayList.add(new GuildListItem$UnavailableItem(storeState.getUnavailableGuilds().size()));
        }
        arrayList.add(GuildListItem$CreateItem.INSTANCE);
        GrowthTeamFeatures growthTeamFeatures = GrowthTeamFeatures.INSTANCE;
        if (growthTeamFeatures.isHubDiscoveryEnabled()) {
            arrayList.add(new GuildListItem$HubItem(storeState.getShowHubSparkle() && growthTeamFeatures.isHubDiscoverySparkleEnabled()));
        }
        if (storeState.isNewUser()) {
            arrayList.add(guildListItem$DividerItem);
            arrayList.add(GuildListItem$HelpItem.INSTANCE);
        }
        arrayList.add(GuildListItem$SpaceItem.INSTANCE);
        WidgetGuildsListViewModel$ViewState$Loaded widgetGuildsListViewModel$ViewState$Loaded = new WidgetGuildsListViewModel$ViewState$Loaded(arrayList, !storeState.getChannelIds().isEmpty(), false);
        if (storeState.isLeftPanelOpened() != this.wasLeftPanelOpened || storeState.isOnHomeTab() != this.wasOnHomeTab) {
            if (storeState.isLeftPanelOpened() && storeState.isOnHomeTab()) {
                this.eventSubject.k.onNext(WidgetGuildsListViewModel$Event$FocusFirstElement.INSTANCE);
            }
            this.wasLeftPanelOpened = storeState.isLeftPanelOpened();
            this.wasOnHomeTab = storeState.isOnHomeTab();
        }
        updateViewState(widgetGuildsListViewModel$ViewState$Loaded);
    }

    private final void move(int fromPosition, int toPosition, Long folderId) {
        ArrayList<GuildListItem> arrayList;
        int i = toPosition;
        WidgetGuildsListViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetGuildsListViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetGuildsListViewModel$ViewState$Loaded widgetGuildsListViewModel$ViewState$Loaded = (WidgetGuildsListViewModel$ViewState$Loaded) viewState;
        if (widgetGuildsListViewModel$ViewState$Loaded != null) {
            List<GuildListItem> items = widgetGuildsListViewModel$ViewState$Loaded.getItems();
            GuildListItem guildListItem = items.get(fromPosition);
            if (this.currentTargetOperation != null || (fromPosition > i || Math.abs(fromPosition - i) >= 2) || ((guildListItem instanceof GuildListItem$GuildItem) && (m.areEqual(((GuildListItem$GuildItem) guildListItem).getFolderId(), folderId) ^ true))) {
                ArrayList<GuildListItem> arrayList2 = new ArrayList<>(items);
                untargetCurrentTarget(arrayList2);
                if (fromPosition < i) {
                    i--;
                }
                int i2 = i;
                if (!(guildListItem instanceof GuildListItem$FolderItem)) {
                    if (guildListItem instanceof GuildListItem$GuildItem) {
                        arrayList2.remove(fromPosition);
                        GuildListItem$GuildItem guildListItem$GuildItem = (GuildListItem$GuildItem) guildListItem;
                        arrayList = arrayList2;
                        arrayList.add(i2, GuildListItem$GuildItem.copy$default(guildListItem$GuildItem, null, 0, false, false, false, folderId, false, false, false, null, null, false, false, false, false, 32735, null));
                        rebuildFolders(arrayList, u.toSet(n.listOfNotNull((Object[]) new Long[]{guildListItem$GuildItem.getFolderId(), folderId})));
                    }
                    updateViewState(WidgetGuildsListViewModel$ViewState$Loaded.copy$default(widgetGuildsListViewModel$ViewState$Loaded, arrayList, false, true, 2, null));
                }
                arrayList2.remove(fromPosition);
                arrayList2.add(i2, guildListItem);
                arrayList = arrayList2;
                updateViewState(WidgetGuildsListViewModel$ViewState$Loaded.copy$default(widgetGuildsListViewModel$ViewState$Loaded, arrayList, false, true, 2, null));
            }
        }
    }

    private final void performTargetOperation(ArrayList<GuildListItem> editingList, int fromPosition, int toPosition) {
        GuildListItem guildListItem = editingList.get(fromPosition);
        m.checkNotNullExpressionValue(guildListItem, "editingList[fromPosition]");
        GuildListItem guildListItem2 = guildListItem;
        GuildListItem guildListItem3 = editingList.get(toPosition);
        m.checkNotNullExpressionValue(guildListItem3, "editingList[toPosition]");
        GuildListItem guildListItem4 = guildListItem3;
        boolean z2 = guildListItem2 instanceof GuildListItem$GuildItem;
        if (z2 && (guildListItem4 instanceof GuildListItem$GuildItem)) {
            GuildListItem$GuildItem guildListItem$GuildItem = (GuildListItem$GuildItem) guildListItem4;
            GuildListItem$GuildItem guildListItem$GuildItem2 = (GuildListItem$GuildItem) guildListItem2;
            editingList.set(toPosition, new GuildListItem$FolderItem(c.k.nextLong(), null, null, false, n.listOf((Object[]) new Guild[]{guildListItem$GuildItem.getGuild(), guildListItem$GuildItem2.getGuild()}), guildListItem$GuildItem.isSelected() || guildListItem$GuildItem2.isSelected(), guildListItem$GuildItem.isConnectedToVoice() || guildListItem$GuildItem2.isConnectedToVoice(), guildListItem$GuildItem.isConnectedToStageChannel() || guildListItem$GuildItem2.isConnectedToStageChannel(), guildListItem$GuildItem2.getMentionCount() + guildListItem$GuildItem.getMentionCount(), guildListItem$GuildItem.getIsUnread() || guildListItem$GuildItem2.getIsUnread(), false));
            m.checkNotNullExpressionValue(editingList.remove(fromPosition), "editingList.removeAt(fromPosition)");
            return;
        }
        if (z2 && (guildListItem4 instanceof GuildListItem$FolderItem)) {
            GuildListItem$FolderItem guildListItem$FolderItem = (GuildListItem$FolderItem) guildListItem4;
            GuildListItem$GuildItem guildListItem$GuildItem3 = (GuildListItem$GuildItem) guildListItem2;
            editingList.set(toPosition, GuildListItem$FolderItem.copy$default(guildListItem$FolderItem, 0L, null, null, false, u.plus((Collection<? extends Guild>) u.toMutableList((Collection) guildListItem$FolderItem.getGuilds()), guildListItem$GuildItem3.getGuild()), guildListItem$FolderItem.isAnyGuildSelected() || guildListItem$GuildItem3.isSelected(), guildListItem$FolderItem.isAnyGuildConnectedToVoice() || guildListItem$GuildItem3.isConnectedToVoice(), false, 0, guildListItem$FolderItem.getIsUnread() || guildListItem$GuildItem3.getIsUnread(), false, 399, null));
            editingList.remove(fromPosition);
        }
    }

    private final void rebuildFolders(ArrayList<GuildListItem> editingList, Set<Long> changedFolderIds) {
        if (changedFolderIds.isEmpty()) {
            return;
        }
        HashMap map = new HashMap();
        ArrayList<GuildListItem$GuildItem> arrayList = new ArrayList();
        for (Object obj : editingList) {
            if (obj instanceof GuildListItem$GuildItem) {
                arrayList.add(obj);
            }
        }
        for (GuildListItem$GuildItem guildListItem$GuildItem : arrayList) {
            Long folderId = guildListItem$GuildItem.getFolderId();
            if (folderId != null) {
                long jLongValue = folderId.longValue();
                ArrayList arrayList2 = (ArrayList) map.get(Long.valueOf(jLongValue));
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(guildListItem$GuildItem.getGuild());
                map.put(Long.valueOf(jLongValue), arrayList2);
            }
        }
        Iterator<T> it = changedFolderIds.iterator();
        while (it.hasNext()) {
            long jLongValue2 = ((Number) it.next()).longValue();
            Iterator<GuildListItem> it2 = editingList.iterator();
            int i = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i = -1;
                    break;
                }
                GuildListItem next = it2.next();
                if ((next instanceof GuildListItem$FolderItem) && ((GuildListItem$FolderItem) next).getFolderId() == jLongValue2) {
                    break;
                } else {
                    i++;
                }
            }
            GuildListItem guildListItem = editingList.get(i);
            Objects.requireNonNull(guildListItem, "null cannot be cast to non-null type com.discord.widgets.guilds.list.GuildListItem.FolderItem");
            GuildListItem$FolderItem guildListItem$FolderItem = (GuildListItem$FolderItem) guildListItem;
            ArrayList arrayList3 = (ArrayList) map.get(Long.valueOf(jLongValue2));
            if (arrayList3 == null) {
                arrayList3 = new ArrayList();
            }
            editingList.set(i, GuildListItem$FolderItem.copy$default(guildListItem$FolderItem, 0L, null, null, false, arrayList3, false, false, false, 0, false, false, 2031, null));
        }
    }

    private final boolean shouldDisplayVideoIconOnGuild(long guildId, ModelNotificationSettings guildNotificationSettings, Map<Long, StreamContext> streamContexts, Map<Long, Long> permissions) {
        if (streamContexts == null || streamContexts.isEmpty()) {
            return false;
        }
        if (guildNotificationSettings != null && guildNotificationSettings.isMuted()) {
            return false;
        }
        Collection<StreamContext> collectionValues = streamContexts.values();
        if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
            for (StreamContext streamContext : collectionValues) {
                Guild guild = streamContext.getGuild();
                if (guild != null && guild.getId() == guildId && PermissionUtils.can(Permission.VIEW_CHANNEL, permissions.get(Long.valueOf(streamContext.getStream().getChannelId())))) {
                    return true;
                }
            }
        }
        return false;
    }

    private final int sumMentionCountsForGuild(long guildId, Map<Long, ? extends Collection<Long>> guildChannels, Map<Long, Integer> mentionCounts) {
        Collection<Long> collection = guildChannels.get(Long.valueOf(guildId));
        if (collection == null) {
            return 0;
        }
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            Integer num = mentionCounts.get(Long.valueOf(((Number) it.next()).longValue()));
            arrayList.add(Integer.valueOf(num != null ? num.intValue() : 0));
        }
        return u.sumOfInt(arrayList);
    }

    private final void untargetCurrentTarget(ArrayList<GuildListItem> editingList) {
        GuildListItem guildListItemCopy$default;
        WidgetGuildListAdapter$Operation$TargetOperation widgetGuildListAdapter$Operation$TargetOperation = this.currentTargetOperation;
        if (widgetGuildListAdapter$Operation$TargetOperation != null) {
            int targetPosition = widgetGuildListAdapter$Operation$TargetOperation.getTargetPosition();
            GuildListItem guildListItem = editingList.get(targetPosition);
            m.checkNotNullExpressionValue(guildListItem, "editingList[toPosition]");
            GuildListItem guildListItem2 = guildListItem;
            if (guildListItem2 instanceof GuildListItem$GuildItem) {
                guildListItemCopy$default = GuildListItem$GuildItem.copy$default((GuildListItem$GuildItem) guildListItem2, null, 0, false, false, false, null, false, false, false, null, null, false, false, false, false, 32511, null);
            } else if (guildListItem2 instanceof GuildListItem$FolderItem) {
                guildListItemCopy$default = GuildListItem$FolderItem.copy$default((GuildListItem$FolderItem) guildListItem2, 0L, null, null, false, null, false, false, false, 0, false, false, AudioAttributesCompat.FLAG_ALL, null);
            }
            editingList.set(targetPosition, guildListItemCopy$default);
        }
        this.currentTargetOperation = null;
    }

    public final Observable<WidgetGuildsListViewModel$Event> listenForEvents() {
        PublishSubject<WidgetGuildsListViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void moveAbove(int fromPosition, int targetPosition) {
        WidgetGuildsListViewModel$ViewState viewState = getViewState();
        Long folderId = null;
        if (!(viewState instanceof WidgetGuildsListViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetGuildsListViewModel$ViewState$Loaded widgetGuildsListViewModel$ViewState$Loaded = (WidgetGuildsListViewModel$ViewState$Loaded) viewState;
        if (widgetGuildsListViewModel$ViewState$Loaded != null) {
            GuildListItem guildListItem = widgetGuildsListViewModel$ViewState$Loaded.getItems().get(targetPosition);
            if (guildListItem instanceof GuildListItem$GuildItem) {
                folderId = ((GuildListItem$GuildItem) guildListItem).getFolderId();
            } else if (!(guildListItem instanceof GuildListItem$FolderItem) && !(guildListItem instanceof GuildListItem$HelpItem) && !(guildListItem instanceof GuildListItem$CreateItem)) {
                throw new IllegalStateException("invalid target");
            }
            move(fromPosition, targetPosition, folderId);
        }
    }

    public final void moveBelow(int fromPosition, int targetPosition) {
        WidgetGuildsListViewModel$ViewState viewState = getViewState();
        Long lValueOf = null;
        if (!(viewState instanceof WidgetGuildsListViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetGuildsListViewModel$ViewState$Loaded widgetGuildsListViewModel$ViewState$Loaded = (WidgetGuildsListViewModel$ViewState$Loaded) viewState;
        if (widgetGuildsListViewModel$ViewState$Loaded != null) {
            GuildListItem guildListItem = widgetGuildsListViewModel$ViewState$Loaded.getItems().get(targetPosition);
            if (guildListItem instanceof GuildListItem$GuildItem) {
                lValueOf = ((GuildListItem$GuildItem) guildListItem).getFolderId();
            } else {
                if (!(guildListItem instanceof GuildListItem$FolderItem)) {
                    throw new IllegalStateException("invalid target");
                }
                GuildListItem$FolderItem guildListItem$FolderItem = (GuildListItem$FolderItem) guildListItem;
                if (guildListItem$FolderItem.isOpen()) {
                    lValueOf = Long.valueOf(guildListItem$FolderItem.getFolderId());
                }
            }
            move(fromPosition, targetPosition + 1, lValueOf);
        }
    }

    public final boolean onDrop() {
        WidgetGuildsListViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetGuildsListViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetGuildsListViewModel$ViewState$Loaded widgetGuildsListViewModel$ViewState$Loaded = (WidgetGuildsListViewModel$ViewState$Loaded) viewState;
        if (widgetGuildsListViewModel$ViewState$Loaded == null) {
            return false;
        }
        List<GuildListItem> items = widgetGuildsListViewModel$ViewState$Loaded.getItems();
        ArrayList arrayList = new ArrayList();
        WidgetGuildListAdapter$Operation$TargetOperation widgetGuildListAdapter$Operation$TargetOperation = this.currentTargetOperation;
        if (widgetGuildListAdapter$Operation$TargetOperation != null) {
            ArrayList<GuildListItem> arrayList2 = new ArrayList<>(items);
            untargetCurrentTarget(arrayList2);
            performTargetOperation(arrayList2, widgetGuildListAdapter$Operation$TargetOperation.getFromPosition(), widgetGuildListAdapter$Operation$TargetOperation.getTargetPosition());
            items = arrayList2;
        }
        for (GuildListItem guildListItem : items) {
            if (guildListItem instanceof GuildListItem$FolderItem) {
                GuildListItem$FolderItem guildListItem$FolderItem = (GuildListItem$FolderItem) guildListItem;
                arrayList.add(new StoreGuildsSorted$Entry$Folder(guildListItem$FolderItem.getFolderId(), guildListItem$FolderItem.getGuilds(), guildListItem$FolderItem.getColor(), guildListItem$FolderItem.getName()));
            } else if (guildListItem instanceof GuildListItem$GuildItem) {
                GuildListItem$GuildItem guildListItem$GuildItem = (GuildListItem$GuildItem) guildListItem;
                if (guildListItem$GuildItem.getFolderId() == null) {
                    arrayList.add(new StoreGuildsSorted$Entry$SingletonGuild(guildListItem$GuildItem.getGuild()));
                }
            }
        }
        StoreStream.Companion.getGuildsSorted().setPositions(arrayList);
        ArrayList arrayList3 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList3.add(((StoreGuildsSorted$Entry) it.next()).asModelGuildFolder());
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().updateUserSettings(RestAPIParams$UserSettings.Companion.createWithGuildFolders(arrayList3)), false, 1, null), WidgetGuildsListViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, WidgetGuildsListViewModel$onDrop$2.INSTANCE, 62, (Object) null);
        return widgetGuildListAdapter$Operation$TargetOperation != null;
    }

    public final void onItemClicked(GuildListItem item, Context context, FragmentManager fragmentManager) {
        m.checkNotNullParameter(item, "item");
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        boolean z2 = !GrowthTeamFeatures.INSTANCE.isHubEnabled();
        if (item instanceof GuildListItem$GuildItem) {
            GuildListItem$GuildItem guildListItem$GuildItem = (GuildListItem$GuildItem) item;
            if (guildListItem$GuildItem.isPendingGuild()) {
                MemberVerificationUtils.maybeShowVerificationGate$default(MemberVerificationUtils.INSTANCE, context, fragmentManager, guildListItem$GuildItem.getGuild().getId(), "Guilds List", null, null, WidgetGuildsListViewModel$onItemClicked$1.INSTANCE, 48, null);
                return;
            }
            if (guildListItem$GuildItem.isSelected()) {
                StoreNavigation.setNavigationPanelAction$default(StoreStream.Companion.getNavigation(), StoreNavigation$PanelAction.CLOSE, null, 2, null);
                return;
            } else if (guildListItem$GuildItem.getGuild().isHub() && z2) {
                b.a.d.m.g(context, 2131888506, 0, null, 12);
                return;
            } else {
                StoreStream.Companion.getGuildSelected().set(guildListItem$GuildItem.getGuild().getId());
                return;
            }
        }
        if (item instanceof GuildListItem$PrivateChannelItem) {
            ChannelSelector.selectChannel$default(ChannelSelector.Companion.getInstance(), 0L, ((GuildListItem$PrivateChannelItem) item).getChannel().getId(), null, null, 12, null);
            return;
        }
        if (item instanceof GuildListItem$UnavailableItem) {
            this.eventSubject.k.onNext(new WidgetGuildsListViewModel$Event$ShowUnavailableGuilds(((GuildListItem$UnavailableItem) item).getUnavailableGuildCount()));
            return;
        }
        if (item instanceof GuildListItem$FriendsItem) {
            if (((GuildListItem$FriendsItem) item).isSelected()) {
                StoreNavigation.setNavigationPanelAction$default(StoreStream.Companion.getNavigation(), StoreNavigation$PanelAction.CLOSE, null, 2, null);
                return;
            } else {
                StoreStream.Companion.getGuildSelected().set(0L);
                return;
            }
        }
        if (m.areEqual(item, GuildListItem$CreateItem.INSTANCE)) {
            this.eventSubject.k.onNext(WidgetGuildsListViewModel$Event$ShowCreateGuild.INSTANCE);
            return;
        }
        if (item instanceof GuildListItem$HubItem) {
            StoreStream.Companion.getDirectories().markDiscordHubClicked();
            this.eventSubject.k.onNext(WidgetGuildsListViewModel$Event$ShowHubVerification.INSTANCE);
            return;
        }
        if (m.areEqual(item, GuildListItem$HelpItem.INSTANCE)) {
            this.eventSubject.k.onNext(WidgetGuildsListViewModel$Event$ShowHelp.INSTANCE);
        } else if (item instanceof GuildListItem$FolderItem) {
            GuildListItem$FolderItem guildListItem$FolderItem = (GuildListItem$FolderItem) item;
            if (guildListItem$FolderItem.isOpen()) {
                StoreStream.Companion.getExpandedGuildFolders().closeFolder(item.getItemId());
            } else {
                StoreStream.Companion.getExpandedGuildFolders().openFolder(item.getItemId());
            }
            this.eventSubject.k.onNext(new WidgetGuildsListViewModel$Event$AnnounceFolderToggleForAccessibility(guildListItem$FolderItem));
        }
    }

    public final void onItemLongPressed(GuildListItem item) {
        m.checkNotNullParameter(item, "item");
        if (item instanceof GuildListItem$PrivateChannelItem) {
            PublishSubject<WidgetGuildsListViewModel$Event> publishSubject = this.eventSubject;
            publishSubject.k.onNext(new WidgetGuildsListViewModel$Event$ShowChannelActions(((GuildListItem$PrivateChannelItem) item).getChannel().getId()));
        }
    }

    public final void target(int fromPosition, int toPosition) {
        GuildListItem guildListItemCopy$default;
        WidgetGuildsListViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetGuildsListViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        WidgetGuildsListViewModel$ViewState$Loaded widgetGuildsListViewModel$ViewState$Loaded = (WidgetGuildsListViewModel$ViewState$Loaded) viewState;
        if (widgetGuildsListViewModel$ViewState$Loaded == null) {
            throw new IllegalStateException("targeting with no items");
        }
        ArrayList<GuildListItem> arrayList = new ArrayList<>(widgetGuildsListViewModel$ViewState$Loaded.getItems());
        untargetCurrentTarget(arrayList);
        GuildListItem guildListItem = arrayList.get(toPosition);
        if (guildListItem instanceof GuildListItem$GuildItem) {
            guildListItemCopy$default = GuildListItem$GuildItem.copy$default((GuildListItem$GuildItem) guildListItem, null, 0, false, false, false, null, false, false, true, null, null, false, false, false, false, 32511, null);
        } else {
            if (!(guildListItem instanceof GuildListItem$FolderItem)) {
                throw new IllegalStateException("invalid target item: " + guildListItem);
            }
            guildListItemCopy$default = GuildListItem$FolderItem.copy$default((GuildListItem$FolderItem) guildListItem, 0L, null, null, false, null, false, false, false, 0, false, true, AudioAttributesCompat.FLAG_ALL, null);
        }
        arrayList.set(toPosition, guildListItemCopy$default);
        this.currentTargetOperation = new WidgetGuildListAdapter$Operation$TargetOperation(fromPosition, toPosition);
        updateViewState(WidgetGuildsListViewModel$ViewState$Loaded.copy$default(widgetGuildsListViewModel$ViewState$Loaded, arrayList, false, true, 2, null));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildsListViewModel(Clock clock, Observable<WidgetGuildsListViewModel$StoreState> observable) {
        super(WidgetGuildsListViewModel$ViewState$Uninitialized.INSTANCE);
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(observable, "storeObservable");
        this.clock = clock;
        this.eventSubject = PublishSubject.k0();
        Observable observableR = ObservableExtensionsKt.computationLatest(observable).r();
        m.checkNotNullExpressionValue(observableR, "storeObservable\n        …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR, this, null, 2, null), WidgetGuildsListViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildsListViewModel$1(this), 62, (Object) null);
    }
}
