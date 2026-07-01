package com.discord.stores;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences$Editor;
import b.d.b.a.a;
import co.discord.media_engine.VideoInputDeviceDescription;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.message.Message;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.role.GuildRole;
import com.discord.api.thread.ThreadMetadata;
import com.discord.api.voice.state.VoiceState;
import com.discord.app.AppComponent;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.domain.ModelPayload;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.rtcconnection.RtcConnection$Metadata;
import com.discord.rtcconnection.audio.DiscordAudioManager$DeviceTypes;
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.PermissionOverwriteUtilsKt;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.AnalyticsTracker$PremiumUpsellType;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.analytics.AnalyticsUtils$Tracker;
import com.discord.utilities.analytics.SearchType;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.analytics.Traits$Location$Obj;
import com.discord.utilities.analytics.Traits$Location$ObjType;
import com.discord.utilities.analytics.Traits$Location$Page;
import com.discord.utilities.analytics.Traits$Location$Section;
import com.discord.utilities.analytics.Traits$Source;
import com.discord.utilities.collections.CollectionExtensionsKt;
import com.discord.utilities.intent.RouteHandlers$AnalyticsMetadata;
import com.discord.utilities.rest.FileUploadAlertType;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.widgets.chat.input.emoji.EmojiPickerContextType;
import com.discord.widgets.chat.input.emoji.EmojiPickerContextType$Chat;
import com.discord.widgets.chat.input.emoji.EmojiPickerContextType$Global;
import com.discord.widgets.guilds.invite.GuildInvite;
import com.discord.widgets.voice.feedback.FeedbackIssue;
import com.discord.widgets.voice.feedback.PendingFeedback$CallFeedback;
import com.discord.widgets.voice.feedback.PendingFeedback$StreamFeedback;
import d0.d0.f;
import d0.o;
import d0.t.g0;
import d0.t.h0;
import d0.t.n;
import d0.z.d.m;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: StoreAnalytics.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAnalytics extends Store {
    private String analyticsToken;
    private String authToken;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private String fingerprint;
    private AtomicBoolean hasTrackedAppUiShown;
    private String inputMode;
    private final PublishSubject<StoreAnalytics$ScreenViewed> screenViewedSubject;
    private Channel selectedVoiceChannel;
    private final StoreStream stores;

    public StoreAnalytics(StoreStream storeStream, Dispatcher dispatcher, Clock clock) {
        m.checkNotNullParameter(storeStream, "stores");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(clock, "clock");
        this.stores = storeStream;
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.hasTrackedAppUiShown = new AtomicBoolean(false);
        this.screenViewedSubject = PublishSubject.k0();
    }

    public static final /* synthetic */ Map access$getChannelSnapshotAnalyticsProperties(StoreAnalytics storeAnalytics, Channel channel, boolean z2) {
        return storeAnalytics.getChannelSnapshotAnalyticsProperties(channel, z2);
    }

    public static final /* synthetic */ Map access$getGuildAnalyticsPropertiesInternal(StoreAnalytics storeAnalytics, long j) {
        return storeAnalytics.getGuildAnalyticsPropertiesInternal(j);
    }

    public static final /* synthetic */ String access$getInputMode$p(StoreAnalytics storeAnalytics) {
        return storeAnalytics.inputMode;
    }

    public static final /* synthetic */ Channel access$getSelectedVoiceChannel$p(StoreAnalytics storeAnalytics) {
        return storeAnalytics.selectedVoiceChannel;
    }

    public static final /* synthetic */ StoreStream access$getStores$p(StoreAnalytics storeAnalytics) {
        return storeAnalytics.stores;
    }

    public static final /* synthetic */ Map access$getThreadSnapshotAnalyticsProperties(StoreAnalytics storeAnalytics, Channel channel) {
        return storeAnalytics.getThreadSnapshotAnalyticsProperties(channel);
    }

    public static final /* synthetic */ void access$onScreenViewed(StoreAnalytics storeAnalytics, StoreAnalytics$ScreenViewed storeAnalytics$ScreenViewed) {
        storeAnalytics.onScreenViewed(storeAnalytics$ScreenViewed);
    }

    public static final /* synthetic */ void access$setInputMode$p(StoreAnalytics storeAnalytics, String str) {
        storeAnalytics.inputMode = str;
    }

    public static final /* synthetic */ void access$setSelectedVoiceChannel$p(StoreAnalytics storeAnalytics, Channel channel) {
        storeAnalytics.selectedVoiceChannel = channel;
    }

    private final void emojiPickerUpsellViewed(AnalyticsTracker$PremiumUpsellType type, EmojiPickerContextType emojiPickerContextType, Map<String, ? extends Object> properties) {
        String str;
        if (m.areEqual(emojiPickerContextType, EmojiPickerContextType$Global.INSTANCE)) {
            str = "Custom Status Modal";
        } else if (m.areEqual(emojiPickerContextType, EmojiPickerContextType$Chat.INSTANCE)) {
            Channel channel = this.stores.getChannels().getChannel(this.stores.getChannelsSelected().getId());
            str = (channel == null || channel.getGuildId() != 0) ? Traits$Location$Page.GUILD_CHANNEL : "DM Channel";
        } else {
            str = "";
        }
        AnalyticsTracker.premiumUpsellViewed$default(AnalyticsTracker.INSTANCE, type, new Traits$Location((String) KotlinExtensionsKt.getExhaustive(str), Traits$Location$Section.EMOJI_PICKER_POPOUT, Traits$Location$Obj.BUTTON_UPSELL, Traits$Location$ObjType.SEARCH, null, 16, null), h0.plus(properties, o.to("has_search_query", Boolean.TRUE)), null, 8, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void emojiPickerUpsellViewed$default(StoreAnalytics storeAnalytics, AnalyticsTracker$PremiumUpsellType analyticsTracker$PremiumUpsellType, EmojiPickerContextType emojiPickerContextType, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = h0.emptyMap();
        }
        storeAnalytics.emojiPickerUpsellViewed(analyticsTracker$PremiumUpsellType, emojiPickerContextType, map);
    }

    private final Map<String, Object> getChannelSnapshotAnalyticsProperties(long channelId, boolean includeNsfw) {
        Channel channel = this.stores.getChannels().getChannel(channelId);
        Map<String, Object> channelSnapshotAnalyticsProperties = channel != null ? getChannelSnapshotAnalyticsProperties(channel, includeNsfw) : null;
        return channelSnapshotAnalyticsProperties != null ? channelSnapshotAnalyticsProperties : h0.emptyMap();
    }

    public static /* synthetic */ Map getChannelSnapshotAnalyticsProperties$default(StoreAnalytics storeAnalytics, long j, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return storeAnalytics.getChannelSnapshotAnalyticsProperties(j, z2);
    }

    @StoreThread
    private final Map<String, Object> getGuildAnalyticsPropertiesInternal(long guildId) {
        Collection<Channel> collectionEmptyList;
        GuildMember guildMember;
        List<Long> roles;
        Guild guild = this.stores.getGuilds().getGuildsInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        if (guild == null) {
            return new HashMap();
        }
        int approximateMemberCount = this.stores.getGuildMemberCounts().getApproximateMemberCount(guildId);
        Map<Long, Channel> channelsForGuildInternal$app_productionGoogleRelease = this.stores.getChannels().getChannelsForGuildInternal$app_productionGoogleRelease(guildId);
        if (channelsForGuildInternal$app_productionGoogleRelease == null || (collectionEmptyList = channelsForGuildInternal$app_productionGoogleRelease.values()) == null) {
            collectionEmptyList = n.emptyList();
        }
        Collection<Channel> collection = collectionEmptyList;
        Map<Long, GuildRole> map = this.stores.getGuilds().getGuildRolesInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        int size = map != null ? map.size() : 0;
        long id2 = this.stores.getUsers().getMe().getId();
        Map<Long, GuildMember> map2 = this.stores.getGuilds().getGuildMembersComputedInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        int size2 = (map2 == null || (guildMember = map2.get(Long.valueOf(id2))) == null || (roles = guildMember.getRoles()) == null) ? 0 : roles.size();
        Long l = this.stores.getPermissions().getGuildPermissions().get(Long.valueOf(guildId));
        return guildPropertiesMap(guild.getId(), approximateMemberCount, collection, size, size2, l != null ? l.longValue() : 0L, guild.getFeatures().contains(GuildFeature.VIP_REGIONS));
    }

    private final Map<String, Object> getGuildAndChannelSnapshotAnalyticsProperties(long channelId) {
        Channel channel = this.stores.getChannels().getChannel(channelId);
        Map<String, Object> mapPlus = channel != null ? h0.plus(getGuildSnapshotAnalyticsProperties(channel.getGuildId()), getChannelSnapshotAnalyticsProperties$default(this, channel, false, 2, (Object) null)) : null;
        return mapPlus != null ? mapPlus : h0.emptyMap();
    }

    private final Map<String, Object> getGuildSnapshotAnalyticsProperties(long guildId) {
        Guild guild = this.stores.getGuilds().getGuilds().get(Long.valueOf(guildId));
        Map<String, Object> guildSnapshotAnalyticsProperties = guild != null ? getGuildSnapshotAnalyticsProperties(guild) : null;
        return guildSnapshotAnalyticsProperties != null ? guildSnapshotAnalyticsProperties : h0.emptyMap();
    }

    private final Map<String, Object> getSnapshotAnalyticsProperties() {
        return getGuildAndChannelSnapshotAnalyticsProperties(this.stores.getChannelsSelected().getId());
    }

    private final String getStreamFeedbackReasonFromIssue(FeedbackIssue issue) {
        if (issue != null) {
            int iOrdinal = issue.ordinal();
            if (iOrdinal == 0) {
                return "OTHER";
            }
            switch (iOrdinal) {
                case 10:
                    return "BLACK_SCREEN";
                case 11:
                    return "BLURRY";
                case 12:
                    return "LAGGING";
                case 13:
                    return "OUT_OF_SYNC";
                case 14:
                    return "AUDIO_MISSING";
                case 15:
                    return "AUDIO_POOR";
                case 16:
                    return "STREAM_STOPPED_UNEXPECTEDLY";
            }
        }
        return null;
    }

    private final Map<String, Object> getThreadSnapshotAnalyticsProperties(Channel channel) {
        Integer threadMessageCount = this.stores.getThreadMessages().getThreadMessageCount(channel.getId());
        boolean z2 = false;
        int iIntValue = threadMessageCount != null ? threadMessageCount.intValue() : 0;
        Pair[] pairArr = new Pair[9];
        pairArr[0] = o.to(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, Long.valueOf(channel.getId()));
        pairArr[1] = o.to(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, Long.valueOf(channel.getGuildId()));
        pairArr[2] = o.to("parent_id", Long.valueOf(channel.getParentId()));
        pairArr[3] = o.to("channel_type", Integer.valueOf(channel.getType()));
        pairArr[4] = o.to("thread_approximate_message_count", Integer.valueOf(f.coerceAtMost(iIntValue, 50)));
        ThreadMetadata threadMetadata = channel.getThreadMetadata();
        pairArr[5] = o.to("thread_archived", Boolean.valueOf(threadMetadata != null && threadMetadata.getArchived()));
        ThreadMetadata threadMetadata2 = channel.getThreadMetadata();
        if (threadMetadata2 != null && threadMetadata2.getLocked()) {
            z2 = true;
        }
        pairArr[6] = o.to("thread_locked", Boolean.valueOf(z2));
        ThreadMetadata threadMetadata3 = channel.getThreadMetadata();
        pairArr[7] = o.to("thread_auto_archive_duration_minutes", threadMetadata3 != null ? Integer.valueOf(threadMetadata3.getAutoArchiveDuration()) : null);
        pairArr[8] = o.to("thread_approximate_creation_date", Long.valueOf((channel.getId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH));
        return h0.mapOf(pairArr);
    }

    private final Map<String, Object> guildPropertiesMap(long guildId, int guildSize, Collection<Channel> guildChannels, int numGuildRoles, int guildMemberNumRoles, long guildPermissions, boolean isVip) {
        int i;
        Pair[] pairArr = new Pair[9];
        int i2 = 0;
        pairArr[0] = o.to(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, Long.valueOf(guildId));
        pairArr[1] = o.to("guild_size_total", Integer.valueOf(guildSize));
        pairArr[2] = o.to("guild_num_channels", Integer.valueOf(guildChannels.size()));
        if (guildChannels.isEmpty()) {
            i = 0;
        } else {
            Iterator<T> it = guildChannels.iterator();
            i = 0;
            while (it.hasNext()) {
                if (ChannelUtils.v((Channel) it.next()) && (i = i + 1) < 0) {
                    n.throwCountOverflow();
                }
            }
        }
        pairArr[3] = o.to("guild_num_text_channels", Integer.valueOf(i));
        if (!guildChannels.isEmpty()) {
            Iterator<T> it2 = guildChannels.iterator();
            while (it2.hasNext()) {
                if (ChannelUtils.w((Channel) it2.next()) && (i2 = i2 + 1) < 0) {
                    n.throwCountOverflow();
                }
            }
        }
        pairArr[4] = o.to("guild_num_voice_channels", Integer.valueOf(i2));
        pairArr[5] = o.to("guild_num_roles", Integer.valueOf(numGuildRoles));
        pairArr[6] = o.to("guild_member_num_roles", Integer.valueOf(guildMemberNumRoles));
        pairArr[7] = o.to("guild_member_perms", Long.valueOf(guildPermissions));
        pairArr[8] = o.to("guild_is_vip", Boolean.valueOf(isVip));
        return h0.mutableMapOf(pairArr);
    }

    @StoreThread
    private final void handleVideoInputUpdate(VideoInputDeviceDescription selectedVideoInputDevice, boolean isScreenSharing) {
        Channel channel = this.selectedVoiceChannel;
        if (channel != null) {
            Map<Long, VoiceState> mapEmptyMap = this.stores.getVoiceStates().get().get(Long.valueOf(channel.getGuildId()));
            if (mapEmptyMap == null) {
                mapEmptyMap = h0.emptyMap();
            }
            Map<Long, VoiceState> map = mapEmptyMap;
            long id2 = this.stores.getUsers().getMe().getId();
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            RtcConnection$Metadata rtcConnectionMetadata = this.stores.getRtcConnection().getRtcConnectionMetadata();
            analyticsTracker.videoInputsUpdate(id2, channel, map, selectedVideoInputDevice, isScreenSharing, rtcConnectionMetadata != null ? rtcConnectionMetadata.mediaSessionId : null);
        }
    }

    private final void onScreenViewed(StoreAnalytics$ScreenViewed screenViewed) {
        if (this.hasTrackedAppUiShown.getAndSet(true)) {
            return;
        }
        this.dispatcher.schedule(new StoreAnalytics$onScreenViewed$1(this, screenViewed));
    }

    public static /* synthetic */ void onUserSettingsPaneViewed$default(StoreAnalytics storeAnalytics, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        storeAnalytics.onUserSettingsPaneViewed(str, str2);
    }

    public static /* synthetic */ void trackSearchResultSelected$default(StoreAnalytics storeAnalytics, SearchType searchType, int i, Traits$Location traits$Location, Traits$Source traits$Source, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            traits$Location = null;
        }
        if ((i2 & 8) != 0) {
            traits$Source = null;
        }
        storeAnalytics.trackSearchResultSelected(searchType, i, traits$Location, traits$Source);
    }

    public static /* synthetic */ void trackSearchResultViewed$default(StoreAnalytics storeAnalytics, SearchType searchType, int i, Integer num, Traits$Location traits$Location, boolean z2, int i2, Object obj) {
        storeAnalytics.trackSearchResultViewed(searchType, i, (i2 & 4) != 0 ? null : num, (i2 & 8) != 0 ? null : traits$Location, (i2 & 16) != 0 ? false : z2);
    }

    public static /* synthetic */ void trackSearchResultsEmpty$default(StoreAnalytics storeAnalytics, SearchType searchType, Traits$Location traits$Location, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            traits$Location = null;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        storeAnalytics.trackSearchResultsEmpty(searchType, traits$Location, z2);
    }

    public static /* synthetic */ void trackSearchStarted$default(StoreAnalytics storeAnalytics, SearchType searchType, Traits$Location traits$Location, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            traits$Location = null;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        storeAnalytics.trackSearchStarted(searchType, traits$Location, z2);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0025  */
    /* JADX WARN: Code duplicated, block: B:31:0x003a  */
    private final void updateTrackingData() {
        boolean z2;
        boolean z3;
        String str = this.authToken;
        boolean z4 = !(str == null || str.length() == 0);
        if (z4) {
            z2 = false;
        } else {
            String str2 = this.fingerprint;
            if (str2 == null || str2.length() == 0) {
                z2 = false;
            } else {
                z2 = true;
            }
        }
        if (z4) {
            String str3 = this.analyticsToken;
            if (str3 == null || str3.length() == 0) {
                z3 = false;
            } else {
                z3 = true;
            }
        } else {
            z3 = false;
        }
        if (z2) {
            AnalyticsTracker.INSTANCE.getTracker().setTrackingData(null, true);
        } else if (z3) {
            AnalyticsUtils$Tracker.setTrackingData$default(AnalyticsTracker.INSTANCE.getTracker(), this.analyticsToken, false, 2, null);
        } else {
            AnalyticsTracker.INSTANCE.getTracker().setTrackingData(null, false);
        }
    }

    public final void ackMessage(long channelId) {
        this.dispatcher.schedule(new StoreAnalytics$ackMessage$1(this, channelId));
    }

    public final void appLandingViewed() {
        AnalyticsTracker.appLandingViewed(getPrefsSessionDurable().getLong("CACHE_KEY_LOGOUT_TS", 0L));
    }

    public final void appUiViewed(Class<? extends AppComponent> screen) {
        m.checkNotNullParameter(screen, "screen");
        PublishSubject<StoreAnalytics$ScreenViewed> publishSubject = this.screenViewedSubject;
        publishSubject.k.onNext(new StoreAnalytics$ScreenViewed(screen, this.clock.currentTimeMillis()));
    }

    public final void deepLinkReceived(Intent intent, RouteHandlers$AnalyticsMetadata metadata) {
        m.checkNotNullParameter(intent, "intent");
        m.checkNotNullParameter(metadata, "metadata");
        Long channelId = metadata.getChannelId();
        Map<String, ? extends Object> guildAndChannelSnapshotAnalyticsProperties = channelId != null ? getGuildAndChannelSnapshotAnalyticsProperties(channelId.longValue()) : null;
        if (guildAndChannelSnapshotAnalyticsProperties == null) {
            guildAndChannelSnapshotAnalyticsProperties = h0.emptyMap();
        }
        AnalyticsTracker.INSTANCE.deepLinkReceived(intent, metadata, guildAndChannelSnapshotAnalyticsProperties);
    }

    public final void emojiAutocompleteUpsellInlineViewed() {
        AnalyticsTracker.premiumUpsellViewed$default(AnalyticsTracker.INSTANCE, AnalyticsTracker$PremiumUpsellType.EmojiAutocompleteInline, null, h0.emptyMap(), null, 8, null);
    }

    public final void emojiAutocompleteUpsellModalViewed() {
        AnalyticsTracker.premiumUpsellViewed$default(AnalyticsTracker.INSTANCE, AnalyticsTracker$PremiumUpsellType.EmojiAutocompleteModal, null, h0.emptyMap(), null, 8, null);
    }

    public final void emojiPickerUpsellHeaderViewed(EmojiPickerContextType emojiPickerContextType) {
        m.checkNotNullParameter(emojiPickerContextType, "emojiPickerContextType");
        emojiPickerUpsellViewed$default(this, AnalyticsTracker$PremiumUpsellType.EmojiPickerHeaderViewed, emojiPickerContextType, null, 4, null);
    }

    public final void emojiPickerUpsellLockedItemClicked(EmojiPickerContextType emojiPickerContextType, boolean isAnimated) {
        m.checkNotNullParameter(emojiPickerContextType, "emojiPickerContextType");
        emojiPickerUpsellViewed(AnalyticsTracker$PremiumUpsellType.EmojiPickerLockedItemClicked, emojiPickerContextType, h0.mapOf(o.to("is_animated", Boolean.valueOf(isAnimated)), o.to("is_external", Boolean.TRUE)));
    }

    public final Traits$Location getEmojiPickerUpsellLocation() {
        Channel channel = this.stores.getChannels().getChannel(this.stores.getChannelsSelected().getId());
        return new Traits$Location((channel == null || channel.getGuildId() != 0) ? Traits$Location$Page.GUILD_CHANNEL : "DM Channel", Traits$Location$Section.EMOJI_PICKER_POPOUT, null, null, null, 28, null);
    }

    @StoreThread
    public final void handleAuthToken(String authToken) {
        this.authToken = authToken;
        updateTrackingData();
    }

    @StoreThread
    public final void handleConnected(boolean connected) {
        if (connected) {
            return;
        }
        this.analyticsToken = null;
        updateTrackingData();
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        this.analyticsToken = payload.getAnalyticsToken();
        updateTrackingData();
    }

    @StoreThread
    public final void handleFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
        updateTrackingData();
    }

    @StoreThread
    public final void handleIsScreenSharingChanged(boolean isScreenSharing) {
        handleVideoInputUpdate(this.stores.getMediaEngine().getSelectedVideoInputDevice(), isScreenSharing);
    }

    @StoreThread
    public final void handlePreLogout() {
        SharedPreferences$Editor sharedPreferences$EditorEdit = getPrefsSessionDurable().edit();
        m.checkNotNullExpressionValue(sharedPreferences$EditorEdit, "editor");
        sharedPreferences$EditorEdit.putLong("CACHE_KEY_LOGOUT_TS", this.clock.currentTimeMillis());
        sharedPreferences$EditorEdit.apply();
    }

    @StoreThread
    public final void handleUserSpeaking(Set<Long> speakingUsers) {
        Channel channel;
        m.checkNotNullParameter(speakingUsers, "speakingUsers");
        String str = this.inputMode;
        if (str == null || (channel = this.selectedVoiceChannel) == null) {
            return;
        }
        long id2 = this.stores.getUsers().getMe().getId();
        AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
        analyticsTracker.userSpeaking(id2, speakingUsers, str, channel);
        analyticsTracker.userListening(id2, speakingUsers, str, channel);
    }

    @StoreThread
    public final void handleVideoInputDeviceSelected(VideoInputDeviceDescription videoInputDevice) {
        handleVideoInputUpdate(videoInputDevice, this.stores.getApplicationStreaming().isScreenSharing());
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        m.checkNotNullParameter(context, "context");
        super.init(context);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationBuffered(this.stores.getMediaSettings().getInputMode()), StoreAnalytics.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreAnalytics$init$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationBuffered(this.stores.getVoiceChannelSelected().observeSelectedChannel()), StoreAnalytics.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreAnalytics$init$2(this), 62, (Object) null);
        Observable observableZ = this.screenViewedSubject.Y(StoreAnalytics$init$3.INSTANCE).z();
        m.checkNotNullExpressionValue(observableZ, "screenViewedSubject\n    …       }\n        .first()");
        ObservableExtensionsKt.appSubscribe$default(observableZ, StoreAnalytics.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreAnalytics$init$4(this), 62, (Object) null);
    }

    public final void inviteSent(ModelInvite invite, Message message, String location) {
        GuildScheduledEvent guildScheduledEvent;
        Channel channel;
        com.discord.api.guild.Guild guild;
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        Pair[] pairArr = new Pair[5];
        pairArr[0] = o.to(ModelAuditLogEntry.CHANGE_KEY_LOCATION, location);
        pairArr[1] = o.to("message_id", Long.valueOf(message.getId()));
        Long lValueOf = null;
        pairArr[2] = o.to("invite_guild_id", (invite == null || (guild = invite.guild) == null) ? null : Long.valueOf(guild.getId()));
        pairArr[3] = o.to("invite_channel_id", (invite == null || (channel = invite.getChannel()) == null) ? null : Long.valueOf(channel.getId()));
        if (invite != null && (guildScheduledEvent = invite.getGuildScheduledEvent()) != null) {
            lValueOf = Long.valueOf(guildScheduledEvent.getId());
        }
        pairArr[4] = o.to("invite_guild_scheduled_event_id", lValueOf);
        AnalyticsTracker.INSTANCE.inviteSent(invite, h0.plus(h0.mapOf(pairArr), getGuildAndChannelSnapshotAnalyticsProperties(message.getChannelId())));
    }

    public final void inviteSuggestionOpened(long guildId, List<Channel> channelSuggestions, List<? extends User> userSuggestions) {
        m.checkNotNullParameter(channelSuggestions, "channelSuggestions");
        m.checkNotNullParameter(userSuggestions, "userSuggestions");
        AnalyticsTracker.INSTANCE.inviteSuggestionOpened(guildId, channelSuggestions, userSuggestions);
    }

    public final void onGuildSettingsPaneViewed(String pane, long guildId) {
        m.checkNotNullParameter(pane, "pane");
        this.dispatcher.schedule(new StoreAnalytics$onGuildSettingsPaneViewed$1(this, guildId, pane));
    }

    public final void onNotificationSettingsUpdated(ModelNotificationSettings notifSettings, Long channelId) {
        m.checkNotNullParameter(notifSettings, "notifSettings");
        this.dispatcher.schedule(new StoreAnalytics$onNotificationSettingsUpdated$1(this, channelId, notifSettings));
    }

    public final void onOverlayVoiceEvent(boolean isActive) {
        this.dispatcher.schedule(new StoreAnalytics$onOverlayVoiceEvent$1(this, isActive));
    }

    public final void onThreadNotificationSettingsUpdated(long channelId, long parentChannelId, int flags, int oldFlags) {
        this.dispatcher.schedule(new StoreAnalytics$onThreadNotificationSettingsUpdated$1(this, channelId, parentChannelId, oldFlags, flags));
    }

    public final void onUserSettingsPaneViewed(String pane, String locationSection) {
        m.checkNotNullParameter(pane, "pane");
        AnalyticsTracker.INSTANCE.settingsPaneViewed("user", pane, locationSection != null ? g0.mapOf(o.to("location_section", locationSection)) : null);
    }

    public final void openCustomEmojiPopout(Channel channel, long emojiId, boolean isPremium, boolean joinedSourceGuild, boolean sourceGuildPrivate) {
        m.checkNotNullParameter(channel, "channel");
        AnalyticsTracker.INSTANCE.openCustomEmojiPopout(channel.getGuildId(), emojiId, isPremium, joinedSourceGuild, sourceGuildPrivate, CollectionExtensionsKt.filterNonNullValues(getChannelSnapshotAnalyticsProperties$default(this, channel, false, 2, (Object) null)));
    }

    public final void openUnicodeEmojiPopout(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        AnalyticsTracker.INSTANCE.openUnicodeEmojiPopout(channel.getGuildId(), CollectionExtensionsKt.filterNonNullValues(getChannelSnapshotAnalyticsProperties$default(this, channel, false, 2, (Object) null)));
    }

    public final void streamQualityIndicatorViewed(boolean hasPremiumStreamResolution, Boolean hasPremiumStreamFps) {
        AnalyticsTracker.premiumUpsellViewed$default(AnalyticsTracker.INSTANCE, AnalyticsTracker$PremiumUpsellType.StreamQualityIndicator, null, CollectionExtensionsKt.filterNonNullValues(h0.mapOf(o.to("has_premium_stream_fps", hasPremiumStreamFps), o.to("has_premium_stream_resolution", Boolean.valueOf(hasPremiumStreamResolution)))), null, 8, null);
    }

    public final void trackApplicationCommandBrowserJump(long targetApplicationId) {
        AnalyticsTracker.INSTANCE.applicationCommandBrowserJump(targetApplicationId);
    }

    public final void trackApplicationCommandBrowserOpened(long channelId) {
        AnalyticsTracker.INSTANCE.applicationCommandBrowserOpened(getGuildAndChannelSnapshotAnalyticsProperties(channelId));
    }

    public final void trackApplicationCommandBrowserScrolled() {
        AnalyticsTracker.INSTANCE.applicationCommandBrowserScrolled();
    }

    public final void trackApplicationCommandSelected(long channelId, long applicationId, long commandId) {
        AnalyticsTracker.INSTANCE.applicationCommandSelected(applicationId, commandId, getGuildAndChannelSnapshotAnalyticsProperties(channelId));
    }

    public final void trackApplicationCommandValidationFailure(long applicationId, long commandId, String argumentType, boolean isRequired) {
        m.checkNotNullParameter(argumentType, "argumentType");
        AnalyticsTracker.INSTANCE.applicationCommandValidationFailure(applicationId, commandId, argumentType, isRequired);
    }

    public final void trackAutocompleteOpen(long channelId, String autocompleteType, int numEmojiResults, int numStickerResults) {
        m.checkNotNullParameter(autocompleteType, "autocompleteType");
        AnalyticsTracker.INSTANCE.autocompleteOpen(CollectionExtensionsKt.filterNonNullValues(getGuildAndChannelSnapshotAnalyticsProperties(channelId)), autocompleteType, numEmojiResults, numStickerResults);
    }

    public final void trackAutocompleteSelect(long channelId, String autocompleteType, int numEmojiResults, int numStickerResults, String selectionType, String selection, Long stickerId) {
        m.checkNotNullParameter(autocompleteType, "autocompleteType");
        AnalyticsTracker.INSTANCE.autocompleteSelect(CollectionExtensionsKt.filterNonNullValues(getGuildAndChannelSnapshotAnalyticsProperties(channelId)), autocompleteType, numEmojiResults, numStickerResults, selectionType, selection, stickerId);
    }

    public final void trackCallReportProblem(PendingFeedback$CallFeedback pendingCallFeedback) {
        m.checkNotNullParameter(pendingCallFeedback, "pendingCallFeedback");
        this.dispatcher.schedule(new StoreAnalytics$trackCallReportProblem$1(this, pendingCallFeedback));
    }

    @StoreThread
    public final void trackChannelOpened(long channelId, ChannelAnalyticsViewType channelView, SelectedChannelAnalyticsLocation analyticsLocation) {
        m.checkNotNullParameter(channelView, "channelView");
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease = this.stores.getChannels().findChannelByIdInternal$app_productionGoogleRelease(channelId);
        if (channelFindChannelByIdInternal$app_productionGoogleRelease != null) {
            AnalyticsTracker.INSTANCE.channelOpened(channelId, new StoreAnalytics$trackChannelOpened$$inlined$let$lambda$1(channelFindChannelByIdInternal$app_productionGoogleRelease, this, channelId, channelView, analyticsLocation));
        }
    }

    public final void trackChatInputComponentViewed(String type) {
        m.checkNotNullParameter(type, "type");
        AnalyticsTracker.INSTANCE.chatInputComponentViewed(type);
    }

    public final void trackFailedMessageResolved(int numAttachments, int maxAttachmentSize, int totalAttachmentSize, boolean hasImage, boolean hasVideo, FailedMessageResolutionType resolutionType, long initialAttemptTimestamp, int numRetries, long channelId) {
        m.checkNotNullParameter(resolutionType, "resolutionType");
        AnalyticsTracker.INSTANCE.failedMessageResolved(numAttachments, maxAttachmentSize, totalAttachmentSize, hasImage, hasVideo, resolutionType, initialAttemptTimestamp, numRetries, getGuildAndChannelSnapshotAnalyticsProperties(channelId));
    }

    public final void trackFileUploadAlertViewed(FileUploadAlertType alertType, int numAttachments, int maxAttachmentSize, int totalAttachmentSize, boolean hasImage, boolean hasVideo, boolean isPremium) {
        m.checkNotNullParameter(alertType, "alertType");
        AnalyticsTracker.INSTANCE.fileUploadAlertViewed(alertType, numAttachments, maxAttachmentSize, totalAttachmentSize, hasImage, hasVideo, isPremium, getSnapshotAnalyticsProperties());
    }

    public final void trackGuildProfileOpened(long guildId) {
        AnalyticsTracker.INSTANCE.openGuildProfileSheet(guildId);
    }

    @StoreThread
    public final void trackGuildViewed(long guildId) {
        boolean zContains;
        GuildMember guildMember;
        Guild guild = this.stores.getGuilds().getGuildsInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        if (guild != null) {
            long id2 = this.stores.getUsers().getMe().getId();
            Map<Long, GuildMember> map = this.stores.getGuilds().getGuildMembersComputedInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
            boolean pending = (map == null || (guildMember = map.get(Long.valueOf(id2))) == null) ? false : guildMember.getPending();
            try {
                zContains = guild.getFeatures().contains(GuildFeature.PREVIEW_ENABLED);
            } catch (Exception e) {
                AppLog.g.e("Guild is missing feature set", e, g0.mapOf(o.to(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, String.valueOf(guild.getId()))));
                zContains = false;
            }
            AnalyticsTracker.INSTANCE.guildViewed(guildId, new StoreAnalytics$trackGuildViewed$1(h0.plus(getGuildAnalyticsPropertiesInternal(guildId), h0.mapOf(o.to("is_pending", Boolean.valueOf(pending)), o.to("preview_enabled", Boolean.valueOf(zContains))))));
        }
    }

    public final void trackMediaSessionJoined(Map<String, Object> properties) {
        m.checkNotNullParameter(properties, "properties");
        this.dispatcher.schedule(new StoreAnalytics$trackMediaSessionJoined$1(this, properties));
    }

    public final void trackOpenGiftAcceptModal(String giftCode, String location, long channelId) {
        m.checkNotNullParameter(giftCode, "giftCode");
        m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        this.dispatcher.schedule(new StoreAnalytics$trackOpenGiftAcceptModal$1(this, giftCode, channelId, location));
    }

    public final void trackSearchResultSelected(SearchType searchType, int totalResultsCount, Traits$Location locationTrait, Traits$Source sourceTrait) {
        m.checkNotNullParameter(searchType, "searchType");
        AnalyticsTracker.INSTANCE.searchResultSelected(searchType, locationTrait, sourceTrait, totalResultsCount, getSnapshotAnalyticsProperties());
    }

    public final void trackSearchResultViewed(SearchType searchType, int totalResultsCount, Integer lockedResultsCount, Traits$Location locationTrait, boolean throttle) {
        m.checkNotNullParameter(searchType, "searchType");
        AnalyticsTracker.INSTANCE.searchResultViewed(searchType, totalResultsCount, lockedResultsCount, locationTrait, getSnapshotAnalyticsProperties(), throttle);
    }

    public final void trackSearchResultsEmpty(SearchType searchType, Traits$Location locationTrait, boolean throttle) {
        m.checkNotNullParameter(searchType, "searchType");
        AnalyticsTracker.INSTANCE.searchResultsEmpty(searchType, locationTrait, getSnapshotAnalyticsProperties(), throttle);
    }

    public final void trackSearchStarted(SearchType searchType, Traits$Location locationTrait, boolean throttle) {
        m.checkNotNullParameter(searchType, "searchType");
        AnalyticsTracker.INSTANCE.searchStart(searchType, locationTrait, getSnapshotAnalyticsProperties(), throttle);
    }

    public final void trackShowCallFeedbackSheet(long channelId) {
        this.dispatcher.schedule(new StoreAnalytics$trackShowCallFeedbackSheet$1(this, channelId));
    }

    public final void trackStreamReportProblem(PendingFeedback$StreamFeedback pendingStreamFeedback) {
        m.checkNotNullParameter(pendingStreamFeedback, "pendingStreamFeedback");
        AnalyticsTracker.INSTANCE.reportStreamProblem(pendingStreamFeedback.getStream(), pendingStreamFeedback.getFeedbackRating(), getStreamFeedbackReasonFromIssue(pendingStreamFeedback.getIssue()), pendingStreamFeedback.getMediaSessionId(), pendingStreamFeedback.getIssueDetails());
    }

    @StoreThread
    public final void trackTextInVoiceOpened(long channelId, SelectedChannelAnalyticsLocation analyticsLocation) {
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease = this.stores.getChannels().findChannelByIdInternal$app_productionGoogleRelease(channelId);
        if (channelFindChannelByIdInternal$app_productionGoogleRelease != null) {
            AnalyticsTracker.INSTANCE.textInVoiceOpened(channelId, new StoreAnalytics$trackTextInVoiceOpened$$inlined$let$lambda$1(channelFindChannelByIdInternal$app_productionGoogleRelease, this, channelId, analyticsLocation));
        }
    }

    public final void trackThreadBrowserTabChanged(long channelId, String tabType) {
        m.checkNotNullParameter(tabType, "tabType");
        AnalyticsTracker.INSTANCE.threadBrowserTabChanged(getGuildAndChannelSnapshotAnalyticsProperties(channelId), tabType);
    }

    public final void trackVideoLayoutToggled(String videoLayout, long meId, Channel channel) {
        m.checkNotNullParameter(videoLayout, "videoLayout");
        AnalyticsTracker.INSTANCE.videoLayoutToggled(videoLayout, meId, channel);
    }

    @StoreThread
    public final void trackVideoStreamEnded(Map<String, Object> properties) {
        m.checkNotNullParameter(properties, "properties");
        Object obj = properties.get("sender_user_id");
        if (!(obj instanceof Long)) {
            obj = null;
        }
        Long l = (Long) obj;
        if (l != null) {
            long jLongValue = l.longValue();
            Object obj2 = properties.get(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID);
            if (!(obj2 instanceof Long)) {
                obj2 = null;
            }
            Long l2 = (Long) obj2;
            if (l2 != null) {
                long jLongValue2 = l2.longValue();
                Object obj3 = properties.get(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID);
                Integer maxViewersForStream = this.stores.getApplicationStreaming().getMaxViewersForStream(jLongValue, jLongValue2, (Long) (obj3 instanceof Long ? obj3 : null));
                if (maxViewersForStream != null) {
                    properties.put("max_viewers", maxViewersForStream);
                }
                AnalyticsTracker.INSTANCE.videoStreamEnded(properties);
            }
        }
    }

    public final void trackVoiceAudioOutputModeSelected(long channelId, DiscordAudioManager$DeviceTypes fromAudioOutputMode, DiscordAudioManager$DeviceTypes toAudioOutputMode) {
        m.checkNotNullParameter(fromAudioOutputMode, "fromAudioOutputMode");
        m.checkNotNullParameter(toAudioOutputMode, "toAudioOutputMode");
        this.dispatcher.schedule(new StoreAnalytics$trackVoiceAudioOutputModeSelected$1(this, channelId, fromAudioOutputMode, toAudioOutputMode));
    }

    public final void trackVoiceConnectionFailure(Map<String, Object> properties) {
        m.checkNotNullParameter(properties, "properties");
        this.dispatcher.schedule(new StoreAnalytics$trackVoiceConnectionFailure$1(this, properties));
    }

    public final void trackVoiceConnectionSuccess(Map<String, Object> properties) {
        m.checkNotNullParameter(properties, "properties");
        this.dispatcher.schedule(new StoreAnalytics$trackVoiceConnectionSuccess$1(this, properties));
    }

    @StoreThread
    public final void trackVoiceDisconnect(Map<String, Object> properties) {
        m.checkNotNullParameter(properties, "properties");
        this.dispatcher.schedule(new StoreAnalytics$trackVoiceDisconnect$1(this, properties));
    }

    public static /* synthetic */ Map getChannelSnapshotAnalyticsProperties$default(StoreAnalytics storeAnalytics, Channel channel, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return storeAnalytics.getChannelSnapshotAnalyticsProperties(channel, z2);
    }

    private final Map<String, Object> getGuildSnapshotAnalyticsProperties(Guild guild) {
        GuildMember guildMember;
        List<Long> roles;
        int approximateMemberCount = this.stores.getGuildMemberCounts().getApproximateMemberCount(guild.getId());
        Collection<Channel> collectionValues = this.stores.getChannels().getChannelsForGuild(guild.getId()).values();
        Map map = (Map) a.e(guild, this.stores.getGuilds().getRoles());
        int size = map != null ? map.size() : 0;
        long id2 = this.stores.getUsers().getMeSnapshot().getId();
        Map map2 = (Map) a.e(guild, this.stores.getGuilds().getMembers());
        int size2 = (map2 == null || (guildMember = (GuildMember) map2.get(Long.valueOf(id2))) == null || (roles = guildMember.getRoles()) == null) ? 0 : roles.size();
        Long l = (Long) a.e(guild, this.stores.getPermissions().getGuildPermissions());
        return guildPropertiesMap(guild.getId(), approximateMemberCount, collectionValues, size, size2, l != null ? l.longValue() : 0L, guild.getFeatures().contains(GuildFeature.VIP_REGIONS));
    }

    private final Map<String, Object> getChannelSnapshotAnalyticsProperties(Channel channel, boolean includeNsfw) {
        PermissionOverwrite permissionOverwrite;
        Object next;
        Long l = (Long) a.d(channel, this.stores.getPermissions().getPermissionsByChannel());
        List<PermissionOverwrite> listV = channel.v();
        if (listV != null) {
            Iterator<T> it = listV.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(((PermissionOverwrite) next).e() == channel.getGuildId()));
            permissionOverwrite = (PermissionOverwrite) next;
        } else {
            permissionOverwrite = null;
        }
        return h0.plus(h0.plus(AnalyticsUtils.INSTANCE.getProperties$app_productionGoogleRelease(channel), h0.mapOf(o.to("channel_member_perms", l), o.to("channel_hidden", permissionOverwrite != null ? Boolean.valueOf(PermissionOverwriteUtilsKt.denies(permissionOverwrite, Permission.VIEW_CHANNEL)) : null))), includeNsfw ? g0.mapOf(o.to("channel_is_nsfw", Boolean.valueOf(channel.getNsfw()))) : h0.emptyMap());
    }

    public final void inviteSent(GuildInvite invite, Channel channel, Message message, String location) {
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        Pair[] pairArr = new Pair[5];
        pairArr[0] = o.to(ModelAuditLogEntry.CHANGE_KEY_LOCATION, location);
        pairArr[1] = o.to("message_id", Long.valueOf(message.getId()));
        pairArr[2] = o.to("invite_guild_id", invite != null ? invite.getGuildId() : null);
        pairArr[3] = o.to("invite_channel_id", invite != null ? invite.getChannelId() : null);
        pairArr[4] = o.to("invite_guild_scheduled_event_id", invite != null ? invite.getGuildScheduledEventId() : null);
        AnalyticsTracker.INSTANCE.inviteSent(invite, channel, h0.plus(h0.mapOf(pairArr), getGuildAndChannelSnapshotAnalyticsProperties(message.getChannelId())));
    }
}
