package com.discord.stores;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelMuteConfig;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelPayload$VersionedUserGuildSettings;
import com.discord.models.guild.Guild;
import com.discord.restapi.RestAPIParams$ThreadMemberSettings;
import com.discord.restapi.RestAPIParams$UserGuildSettings;
import com.discord.restapi.RestAPIParams$UserGuildSettings$ChannelOverride;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.widgets.forums.ForumUtils;
import d0.t.h0;
import d0.t.n0;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.Subscription;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: StoreUserGuildSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserGuildSettings extends StoreV2 {
    private final StoreAnalytics analytics;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private final PublishSubject<StoreUserGuildSettings$Event> eventSubject;
    private final Map<Long, ModelNotificationSettings> guildSettings;
    private final Persister<Map<Long, ModelNotificationSettings>> guildSettingsCache;
    private Map<Long, ? extends ModelNotificationSettings> guildSettingsSnapshot;
    private final HashSet<Long> guildsToHideMutedChannelsIn;
    private final Persister<Set<Long>> guildsToHideMutedChannelsInCache;
    private Set<Long> guildsToHideMutedChannelsInSnapshot;
    private final ObservationDeck observationDeck;
    private Subscription recomputeSettingsSubscription;
    private final RestAPI restApi;
    private final StoreChannels storeChannels;
    private final StoreThreadsJoined storeThreadsJoined;

    public /* synthetic */ StoreUserGuildSettings(Dispatcher dispatcher, Clock clock, StoreAnalytics storeAnalytics, StoreChannels storeChannels, StoreThreadsJoined storeThreadsJoined, ObservationDeck observationDeck, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, clock, storeAnalytics, storeChannels, storeThreadsJoined, (i & 32) != 0 ? ObservationDeckProvider.get() : observationDeck, (i & 64) != 0 ? RestAPI.Companion.getApi() : restAPI);
    }

    public static final /* synthetic */ StoreAnalytics access$getAnalytics$p(StoreUserGuildSettings storeUserGuildSettings) {
        return storeUserGuildSettings.analytics;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreUserGuildSettings storeUserGuildSettings) {
        return storeUserGuildSettings.dispatcher;
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(StoreUserGuildSettings storeUserGuildSettings) {
        return storeUserGuildSettings.eventSubject;
    }

    public static final /* synthetic */ HashSet access$getGuildsToHideMutedChannelsIn$p(StoreUserGuildSettings storeUserGuildSettings) {
        return storeUserGuildSettings.guildsToHideMutedChannelsIn;
    }

    public static final /* synthetic */ Subscription access$getRecomputeSettingsSubscription$p(StoreUserGuildSettings storeUserGuildSettings) {
        return storeUserGuildSettings.recomputeSettingsSubscription;
    }

    public static final /* synthetic */ StoreUserGuildSettings$SettingsUpdateType access$getSettingsUpdateType(StoreUserGuildSettings storeUserGuildSettings, Channel channel) {
        return storeUserGuildSettings.getSettingsUpdateType(channel);
    }

    public static final /* synthetic */ StoreChannels access$getStoreChannels$p(StoreUserGuildSettings storeUserGuildSettings) {
        return storeUserGuildSettings.storeChannels;
    }

    public static final /* synthetic */ StoreThreadsJoined access$getStoreThreadsJoined$p(StoreUserGuildSettings storeUserGuildSettings) {
        return storeUserGuildSettings.storeThreadsJoined;
    }

    public static final /* synthetic */ void access$recomputeMuteConfigs(StoreUserGuildSettings storeUserGuildSettings) {
        storeUserGuildSettings.recomputeMuteConfigs();
    }

    public static final /* synthetic */ void access$setRecomputeSettingsSubscription$p(StoreUserGuildSettings storeUserGuildSettings, Subscription subscription) {
        storeUserGuildSettings.recomputeSettingsSubscription = subscription;
    }

    public static final /* synthetic */ void access$updateThreadMemberSettings(StoreUserGuildSettings storeUserGuildSettings, Context context, long j, long j2, RestAPIParams$ThreadMemberSettings restAPIParams$ThreadMemberSettings, int i) {
        storeUserGuildSettings.updateThreadMemberSettings(context, j, j2, restAPIParams$ThreadMemberSettings, i);
    }

    public static final /* synthetic */ void access$updateUserGuildSettings(StoreUserGuildSettings storeUserGuildSettings, Context context, long j, RestAPIParams$UserGuildSettings restAPIParams$UserGuildSettings, StoreUserGuildSettings$SettingsUpdateType storeUserGuildSettings$SettingsUpdateType) {
        storeUserGuildSettings.updateUserGuildSettings(context, j, restAPIParams$UserGuildSettings, storeUserGuildSettings$SettingsUpdateType);
    }

    private final StoreUserGuildSettings$SettingsUpdateType getSettingsUpdateType(Channel channel) {
        if (ChannelUtils.H(channel)) {
            return StoreUserGuildSettings$SettingsUpdateType.THREAD;
        }
        return ChannelUtils.F(channel) ? StoreUserGuildSettings$SettingsUpdateType.CHANNEL : StoreUserGuildSettings$SettingsUpdateType.CATEGORY;
    }

    @StoreThread
    private final void handleGuildSettings(List<? extends ModelNotificationSettings> guildSettingsList) {
        Subscription subscription = this.recomputeSettingsSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Iterator<? extends ModelNotificationSettings> it = guildSettingsList.iterator();
        while (it.hasNext()) {
            ModelNotificationSettings modelNotificationSettingsCopyAndRecomputeTransientFields = it.next().copyAndRecomputeTransientFields(this.clock);
            Map<Long, ModelNotificationSettings> map = this.guildSettings;
            m.checkNotNullExpressionValue(modelNotificationSettingsCopyAndRecomputeTransientFields, "computedSettings");
            if (!m.areEqual(modelNotificationSettingsCopyAndRecomputeTransientFields, map.get(Long.valueOf(modelNotificationSettingsCopyAndRecomputeTransientFields.getGuildId())))) {
                this.guildSettings.put(Long.valueOf(modelNotificationSettingsCopyAndRecomputeTransientFields.getGuildId()), modelNotificationSettingsCopyAndRecomputeTransientFields);
                markChanged();
            }
        }
        Iterator<ModelNotificationSettings> it2 = this.guildSettings.values().iterator();
        long jMin = Long.MAX_VALUE;
        while (it2.hasNext()) {
            jMin = Math.min(jMin, it2.next().getNextMuteEndTimeMs(this.clock));
        }
        if (jMin < RecyclerView.FOREVER_NS) {
            Observable<Long> observableE0 = Observable.e0(jMin - this.clock.currentTimeMillis(), TimeUnit.MILLISECONDS, this.dispatcher.getScheduler());
            m.checkNotNullExpressionValue(observableE0, "Observable.timer(\n      …patcher.scheduler\n      )");
            ObservableExtensionsKt.appSubscribe$default(observableE0, StoreUserGuildSettings.class, (Context) null, new StoreUserGuildSettings$handleGuildSettings$1(this), (Function1) null, (Function0) null, (Function0) null, new StoreUserGuildSettings$handleGuildSettings$2(this), 58, (Object) null);
        }
    }

    @StoreThread
    private final void recomputeMuteConfigs() {
        handleGuildSettingUpdated$app_productionGoogleRelease(new ArrayList(this.guildSettings.values()));
    }

    public static /* synthetic */ void setChannelMuted$default(StoreUserGuildSettings storeUserGuildSettings, Context context, long j, boolean z2, ModelMuteConfig modelMuteConfig, int i, Object obj) {
        if ((i & 8) != 0) {
            modelMuteConfig = null;
        }
        storeUserGuildSettings.setChannelMuted(context, j, z2, modelMuteConfig);
    }

    public static /* synthetic */ void setGuildMuted$default(StoreUserGuildSettings storeUserGuildSettings, Context context, long j, boolean z2, ModelMuteConfig modelMuteConfig, int i, Object obj) {
        if ((i & 8) != 0) {
            modelMuteConfig = null;
        }
        storeUserGuildSettings.setGuildMuted(context, j, z2, modelMuteConfig);
    }

    public static /* synthetic */ void setGuildToggles$default(StoreUserGuildSettings storeUserGuildSettings, Context context, Guild guild, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, int i, Object obj) {
        storeUserGuildSettings.setGuildToggles(context, guild, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : bool2, (i & 16) != 0 ? null : bool3, (i & 32) != 0 ? null : bool4);
    }

    private final void updateThreadMemberSettings(Context context, long channelId, long parentChannelId, RestAPIParams$ThreadMemberSettings threadMemberSettings, int oldFlags) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.updateThreadMemberSettings(channelId, threadMemberSettings), false, 1, null)), StoreUserGuildSettings.class, context, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreUserGuildSettings$updateThreadMemberSettings$1(this, channelId, parentChannelId, oldFlags), 60, (Object) null);
    }

    private final void updateUserGuildSettings(Context context, long guildId, RestAPIParams$UserGuildSettings userGuildSettings, StoreUserGuildSettings$SettingsUpdateType settingsUpdateType) {
        Set<Long> setKeySet;
        Map<Long, RestAPIParams$UserGuildSettings$ChannelOverride> channelOverrides = userGuildSettings.getChannelOverrides();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.updateUserGuildSettings(guildId, userGuildSettings), false, 1, null)), StoreUserGuildSettings.class, context, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreUserGuildSettings$updateUserGuildSettings$1(this, (channelOverrides == null || (setKeySet = channelOverrides.keySet()) == null) ? null : (Long) u.firstOrNull(setKeySet), settingsUpdateType), 60, (Object) null);
    }

    public final Map<Long, ModelNotificationSettings> getGuildSettings() {
        return this.guildSettingsSnapshot;
    }

    @StoreThread
    public final Map<Long, ModelNotificationSettings> getGuildSettingsInternal$app_productionGoogleRelease() {
        return this.guildSettings;
    }

    public final Set<Long> getGuildsToHideMutedChannelsIn() {
        return this.guildsToHideMutedChannelsInSnapshot;
    }

    @StoreThread
    public final void handleConnectionOpen$app_productionGoogleRelease(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        ModelPayload$VersionedUserGuildSettings userGuildSettings = payload.getUserGuildSettings();
        m.checkNotNullExpressionValue(userGuildSettings, "payload.userGuildSettings");
        if (!userGuildSettings.isPartial()) {
            this.guildSettings.clear();
        }
        ModelPayload$VersionedUserGuildSettings userGuildSettings2 = payload.getUserGuildSettings();
        m.checkNotNullExpressionValue(userGuildSettings2, "payload.userGuildSettings");
        List<ModelNotificationSettings> entries = userGuildSettings2.getEntries();
        m.checkNotNullExpressionValue(entries, "payload.userGuildSettings.entries");
        handleGuildSettings(entries);
        markChanged();
    }

    @StoreThread
    public final void handleGuildSettingUpdated$app_productionGoogleRelease(List<? extends ModelNotificationSettings> guildSettingsList) {
        m.checkNotNullParameter(guildSettingsList, "guildSettingsList");
        handleGuildSettings(guildSettingsList);
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        m.checkNotNullParameter(context, "context");
        super.init(context);
        this.guildsToHideMutedChannelsIn.addAll(this.guildsToHideMutedChannelsInCache.get());
        this.guildSettings.putAll(this.guildSettingsCache.get());
        markChanged();
    }

    public final Observable<StoreUserGuildSettings$Event> observeEvents() {
        PublishSubject<StoreUserGuildSettings$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final Observable<Map<Long, ModelNotificationSettings>> observeGuildSettings() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreUserGuildSettings$observeGuildSettings$1(this), 14, null);
    }

    public final Observable<Boolean> observeHideMutedChannels(long guildId) {
        Observable<Boolean> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreUserGuildSettings$observeHideMutedChannels$1(this), 14, null).G(new StoreUserGuildSettings$observeHideMutedChannels$2(guildId)).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<List<Long>> observeMutedGuildIds() {
        Observable<List<Long>> observableR = observeGuildSettings().G(StoreUserGuildSettings$observeMutedGuildIds$1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "observeGuildSettings()\n …  .distinctUntilChanged()");
        return observableR;
    }

    public final void setChannelFrequency(Context context, Channel channel, int frequency) {
        int i;
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(channel, "channel");
        StoreUserGuildSettings$SettingsUpdateType settingsUpdateType = getSettingsUpdateType(channel);
        if (!ChannelUtils.H(channel)) {
            updateUserGuildSettings(context, channel.getGuildId(), new RestAPIParams$UserGuildSettings(channel.getId(), new RestAPIParams$UserGuildSettings$ChannelOverride(Integer.valueOf(frequency), null)), settingsUpdateType);
            return;
        }
        if (frequency == ModelNotificationSettings.FREQUENCY_NOTHING) {
            i = 8;
        } else {
            i = frequency == ModelNotificationSettings.FREQUENCY_MENTIONS ? 4 : 2;
        }
        StoreThreadsJoined$JoinedThread joinedThread = this.storeThreadsJoined.getJoinedThread(channel.getId());
        updateThreadMemberSettings(context, channel.getId(), channel.getParentId(), new RestAPIParams$ThreadMemberSettings(Integer.valueOf(i), null, null, 6, null), joinedThread != null ? joinedThread.getFlags() : 0);
    }

    public final void setChannelMuted(Context context, long channelId, boolean muted, ModelMuteConfig muteConfig) {
        m.checkNotNullParameter(context, "context");
        this.dispatcher.schedule(new StoreUserGuildSettings$setChannelMuted$1(this, channelId, context, muted, muteConfig));
    }

    public final void setChannelNotificationFlags(Context context, Channel channel, int flags) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(channel, "channel");
        if (ChannelUtils.q(channel) && ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, channel.getGuildId(), null, 2, null)) {
            updateUserGuildSettings(context, channel.getGuildId(), new RestAPIParams$UserGuildSettings(channel.getId(), new RestAPIParams$UserGuildSettings$ChannelOverride(null, Integer.valueOf(flags))), getSettingsUpdateType(channel));
        }
    }

    public final void setChannelNotificationsDefault(Context context, Channel channel) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(channel, "channel");
        if (ChannelUtils.H(channel)) {
            return;
        }
        updateUserGuildSettings(context, channel.getGuildId(), new RestAPIParams$UserGuildSettings(channel.getId(), new RestAPIParams$UserGuildSettings$ChannelOverride(Boolean.FALSE, null, Integer.valueOf(ModelNotificationSettings.FREQUENCY_UNSET), null, 8, null)), getSettingsUpdateType(channel));
    }

    public final void setGuildFrequency(Context context, Guild guild, int frequency) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(guild, "guild");
        updateUserGuildSettings(context, guild.getId(), new RestAPIParams$UserGuildSettings(null, null, null, null, null, Integer.valueOf(frequency), null, null, 223, null), StoreUserGuildSettings$SettingsUpdateType.GUILD);
    }

    public final void setGuildMuted(Context context, long guildId, boolean muted, ModelMuteConfig muteConfig) {
        m.checkNotNullParameter(context, "context");
        updateUserGuildSettings(context, guildId, new RestAPIParams$UserGuildSettings(null, null, Boolean.valueOf(muted), muteConfig, null, null, null, null, 243, null), StoreUserGuildSettings$SettingsUpdateType.GUILD);
    }

    public final void setGuildToggles(Context context, Guild guild, Boolean suppressingEveryone, Boolean suppressingRoles, Boolean muted, Boolean mobilePushEnabled) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(guild, "guild");
        updateUserGuildSettings(context, guild.getId(), new RestAPIParams$UserGuildSettings(suppressingEveryone, suppressingRoles, muted, null, mobilePushEnabled, null, null, null, 232, null), StoreUserGuildSettings$SettingsUpdateType.GUILD);
    }

    public final void setHideMutedChannels(long guildId, boolean hideChannels) {
        this.dispatcher.schedule(new StoreUserGuildSettings$setHideMutedChannels$1(this, hideChannels, guildId));
    }

    public final void setNotifyHighlights(Context context, Guild guild, int notifyHighlights) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(guild, "guild");
        updateUserGuildSettings(context, guild.getId(), new RestAPIParams$UserGuildSettings(null, null, null, null, null, null, null, Integer.valueOf(notifyHighlights), Opcodes.LAND, null), StoreUserGuildSettings$SettingsUpdateType.GUILD);
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.guildSettingsSnapshot = new HashMap(this.guildSettings);
        Persister.set$default(this.guildSettingsCache, this.guildSettings, false, 2, null);
        this.guildsToHideMutedChannelsInSnapshot = new HashSet(this.guildsToHideMutedChannelsIn);
        this.guildsToHideMutedChannelsInCache.set(this.guildsToHideMutedChannelsIn, true);
    }

    public final Observable<ModelNotificationSettings> observeGuildSettings(long guildId) {
        Observable<ModelNotificationSettings> observableR = observeGuildSettings().G(new StoreUserGuildSettings$observeGuildSettings$2(guildId)).r();
        m.checkNotNullExpressionValue(observableR, "observeGuildSettings()\n …  .distinctUntilChanged()");
        return observableR;
    }

    public StoreUserGuildSettings(Dispatcher dispatcher, Clock clock, StoreAnalytics storeAnalytics, StoreChannels storeChannels, StoreThreadsJoined storeThreadsJoined, ObservationDeck observationDeck, RestAPI restAPI) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(storeAnalytics, "analytics");
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(storeThreadsJoined, "storeThreadsJoined");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(restAPI, "restApi");
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.analytics = storeAnalytics;
        this.storeChannels = storeChannels;
        this.storeThreadsJoined = storeThreadsJoined;
        this.observationDeck = observationDeck;
        this.restApi = restAPI;
        this.guildSettings = new HashMap();
        this.guildsToHideMutedChannelsIn = new HashSet<>();
        this.guildSettingsSnapshot = h0.emptyMap();
        this.guildsToHideMutedChannelsInSnapshot = n0.emptySet();
        this.guildSettingsCache = new Persister<>("STORE_SETTINGS_USER_GUILD_V6", new HashMap());
        this.guildsToHideMutedChannelsInCache = new Persister<>("STORE_SHOW_HIDE_MUTED_CHANNELS_V2", new HashSet());
        this.eventSubject = PublishSubject.k0();
    }
}
