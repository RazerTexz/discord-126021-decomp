package com.discord.widgets.settings;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelMuteConfig;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.domain.ModelNotificationSettings$ChannelOverride;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreThreadsJoined$JoinedThread;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: MuteSettingsSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MuteSettingsSheetViewModel extends d0<MuteSettingsSheetViewModel$ViewState> {
    public static final MuteSettingsSheetViewModel$Companion Companion = new MuteSettingsSheetViewModel$Companion(null);
    public static final long MUTE_DURATION_ALWAYS = 0;
    private final long channelId;
    private final Clock clock;
    private final MuteSettingsSheetViewModel$Config config;
    private final PublishSubject<MuteSettingsSheetViewModel$Event> eventSubject;
    private final long guildId;
    private final Observable<MuteSettingsSheetViewModel$StoreState> storeStateObservable;
    private final StoreUserGuildSettings storeUserGuildSettings;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ MuteSettingsSheetViewModel(long j, long j2, Observable observable, StoreUserGuildSettings storeUserGuildSettings, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableAccess$observeStoreState;
        if ((i & 4) != 0) {
            MuteSettingsSheetViewModel$Companion muteSettingsSheetViewModel$Companion = Companion;
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            observableAccess$observeStoreState = MuteSettingsSheetViewModel$Companion.access$observeStoreState(muteSettingsSheetViewModel$Companion, j, j2, storeStream$Companion.getGuilds(), storeStream$Companion.getChannels(), storeStream$Companion.getUserGuildSettings(), storeStream$Companion.getThreadsJoined());
        } else {
            observableAccess$observeStoreState = observable;
        }
        this(j, j2, observableAccess$observeStoreState, (i & 8) != 0 ? StoreStream.Companion.getUserGuildSettings() : storeUserGuildSettings, (i & 16) != 0 ? ClockFactory.get() : clock);
    }

    public static final /* synthetic */ void access$handleStoreState(MuteSettingsSheetViewModel muteSettingsSheetViewModel, MuteSettingsSheetViewModel$StoreState muteSettingsSheetViewModel$StoreState) {
        muteSettingsSheetViewModel.handleStoreState(muteSettingsSheetViewModel$StoreState);
    }

    @MainThread
    private final void emitDismissEvent() {
        PublishSubject<MuteSettingsSheetViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(MuteSettingsSheetViewModel$Event$Dismiss.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0091  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:81:0x0121  */
    @MainThread
    private final void handleStoreState(MuteSettingsSheetViewModel$StoreState storeState) {
        MuteSettingsSheetViewModel$SettingsType muteSettingsSheetViewModel$SettingsType;
        String name;
        ModelNotificationSettings$ChannelOverride modelNotificationSettings$ChannelOverride;
        String muteEndTime;
        ModelNotificationSettings guildNotificationSettings;
        int i;
        ModelMuteConfig muteConfig;
        StoreThreadsJoined$JoinedThread joinedThread;
        List<ModelNotificationSettings$ChannelOverride> channelOverrides;
        Object next;
        boolean z2;
        Guild guild = storeState.getGuild();
        Channel channel = storeState.getChannel();
        if (guild != null) {
            muteSettingsSheetViewModel$SettingsType = MuteSettingsSheetViewModel$SettingsType.GUILD;
        } else if (channel == null) {
            muteSettingsSheetViewModel$SettingsType = MuteSettingsSheetViewModel$SettingsType.UNKNOWN;
        } else if (ChannelUtils.m(channel)) {
            muteSettingsSheetViewModel$SettingsType = MuteSettingsSheetViewModel$SettingsType.DM;
        } else if (ChannelUtils.p(channel)) {
            muteSettingsSheetViewModel$SettingsType = MuteSettingsSheetViewModel$SettingsType.GROUP_DM;
        } else if (ChannelUtils.k(channel)) {
            muteSettingsSheetViewModel$SettingsType = MuteSettingsSheetViewModel$SettingsType.CATEGORY;
        } else {
            muteSettingsSheetViewModel$SettingsType = ChannelUtils.H(channel) ? MuteSettingsSheetViewModel$SettingsType.THREAD : MuteSettingsSheetViewModel$SettingsType.GUILD_CHANNEL;
        }
        MuteSettingsSheetViewModel$SettingsType muteSettingsSheetViewModel$SettingsType2 = muteSettingsSheetViewModel$SettingsType;
        if (muteSettingsSheetViewModel$SettingsType2 == MuteSettingsSheetViewModel$SettingsType.UNKNOWN) {
            updateViewState(MuteSettingsSheetViewModel$ViewState$Failure.INSTANCE);
            return;
        }
        int iOrdinal = muteSettingsSheetViewModel$SettingsType2.ordinal();
        if (iOrdinal == 0) {
            m.checkNotNull(guild);
            name = guild.getName();
        } else if (iOrdinal == 1 || iOrdinal == 2) {
            m.checkNotNull(channel);
            name = ChannelUtils.c(channel);
        } else if (iOrdinal == 3) {
            StringBuilder sb = new StringBuilder();
            sb.append('\"');
            m.checkNotNull(channel);
            sb.append(ChannelUtils.c(channel));
            sb.append('\"');
            name = sb.toString();
        } else if (iOrdinal == 4) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(MentionUtilsKt.CHANNELS_CHAR);
            m.checkNotNull(channel);
            sb2.append(ChannelUtils.c(channel));
            name = sb2.toString();
        } else if (iOrdinal != 5) {
            name = "";
        } else {
            m.checkNotNull(channel);
            name = ChannelUtils.c(channel);
        }
        ModelNotificationSettings guildNotificationSettings2 = storeState.getGuildNotificationSettings();
        Integer numValueOf = null;
        if (guildNotificationSettings2 == null || (channelOverrides = guildNotificationSettings2.getChannelOverrides()) == null) {
            modelNotificationSettings$ChannelOverride = null;
        } else {
            Iterator<T> it = channelOverrides.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                ModelNotificationSettings$ChannelOverride modelNotificationSettings$ChannelOverride2 = (ModelNotificationSettings$ChannelOverride) next;
                Channel channel2 = storeState.getChannel();
                if (channel2 != null) {
                    long id2 = channel2.getId();
                    m.checkNotNullExpressionValue(modelNotificationSettings$ChannelOverride2, "channelOverride");
                    if (id2 == modelNotificationSettings$ChannelOverride2.getChannelId()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
            } while (!z2);
            modelNotificationSettings$ChannelOverride = (ModelNotificationSettings$ChannelOverride) next;
        }
        boolean z3 = channel == null || !ChannelUtils.H(channel) ? !(modelNotificationSettings$ChannelOverride == null || !modelNotificationSettings$ChannelOverride.isMuted()) : !((joinedThread = storeState.getJoinedThread()) == null || !joinedThread.getMuted());
        if (channel != null && ChannelUtils.H(channel)) {
            StoreThreadsJoined$JoinedThread joinedThread2 = storeState.getJoinedThread();
            if (joinedThread2 == null || (muteConfig = joinedThread2.getMuteConfig()) == null) {
                muteEndTime = null;
            } else {
                muteEndTime = muteConfig.getEndTime();
            }
        } else if (modelNotificationSettings$ChannelOverride != null) {
            muteEndTime = modelNotificationSettings$ChannelOverride.getMuteEndTime();
        } else {
            muteEndTime = null;
        }
        if (channel != null && ChannelUtils.H(channel)) {
            StoreThreadsJoined$JoinedThread joinedThread3 = storeState.getJoinedThread();
            numValueOf = joinedThread3 != null ? Integer.valueOf(joinedThread3.getFlags()) : null;
            if (numValueOf != null && numValueOf.intValue() == 8) {
                i = ModelNotificationSettings.FREQUENCY_NOTHING;
            } else {
                i = (numValueOf != null && numValueOf.intValue() == 4) ? ModelNotificationSettings.FREQUENCY_MENTIONS : ModelNotificationSettings.FREQUENCY_ALL;
            }
            numValueOf = Integer.valueOf(i);
        } else if (modelNotificationSettings$ChannelOverride != null) {
            numValueOf = Integer.valueOf(modelNotificationSettings$ChannelOverride.getMessageNotifications());
        }
        updateViewState(new MuteSettingsSheetViewModel$ViewState$Loaded(muteSettingsSheetViewModel$SettingsType2, name, z3, (channel == null || ChannelUtils.B(channel) || (guildNotificationSettings = storeState.getGuildNotificationSettings()) == null || !guildNotificationSettings.isMuted()) ? false : true, muteEndTime, numValueOf != null ? numValueOf.intValue() : ModelNotificationSettings.FREQUENCY_UNSET));
    }

    @MainThread
    public final void emitNotificationSettingsEvent(long channelId) {
        PublishSubject<MuteSettingsSheetViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new MuteSettingsSheetViewModel$Event$NavigateToChannelSettings(channelId));
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Clock getClock() {
        return this.clock;
    }

    public final MuteSettingsSheetViewModel$Config getConfig() {
        return this.config;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final Observable<MuteSettingsSheetViewModel$StoreState> getStoreStateObservable() {
        return this.storeStateObservable;
    }

    public final StoreUserGuildSettings getStoreUserGuildSettings() {
        return this.storeUserGuildSettings;
    }

    public final Observable<MuteSettingsSheetViewModel$Event> observeEvents() {
        PublishSubject<MuteSettingsSheetViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void onChannelSettingsSelected() {
        MuteSettingsSheetViewModel$Config muteSettingsSheetViewModel$Config = this.config;
        if (muteSettingsSheetViewModel$Config instanceof MuteSettingsSheetViewModel$Config$Channel) {
            emitNotificationSettingsEvent(((MuteSettingsSheetViewModel$Config$Channel) muteSettingsSheetViewModel$Config).getChannelId());
        }
    }

    @MainThread
    public final void selectMuteDurationMs(long muteDurationMs, Context appContext) {
        m.checkNotNullParameter(appContext, "appContext");
        ModelMuteConfig modelMuteConfig = muteDurationMs != 0 ? new ModelMuteConfig(TimeUtils.toUTCDateTime$default(Long.valueOf(this.clock.currentTimeMillis() + muteDurationMs), null, 2, null)) : null;
        MuteSettingsSheetViewModel$Config muteSettingsSheetViewModel$Config = this.config;
        if (muteSettingsSheetViewModel$Config instanceof MuteSettingsSheetViewModel$Config$Guild) {
            this.storeUserGuildSettings.setGuildMuted(appContext, ((MuteSettingsSheetViewModel$Config$Guild) muteSettingsSheetViewModel$Config).getGuildId(), true, modelMuteConfig);
        } else if (muteSettingsSheetViewModel$Config instanceof MuteSettingsSheetViewModel$Config$Channel) {
            this.storeUserGuildSettings.setChannelMuted(appContext, ((MuteSettingsSheetViewModel$Config$Channel) muteSettingsSheetViewModel$Config).getChannelId(), true, modelMuteConfig);
        }
        emitDismissEvent();
    }

    @MainThread
    public final void unmute(Context appContext) {
        m.checkNotNullParameter(appContext, "appContext");
        MuteSettingsSheetViewModel$Config muteSettingsSheetViewModel$Config = this.config;
        if (muteSettingsSheetViewModel$Config instanceof MuteSettingsSheetViewModel$Config$Channel) {
            this.storeUserGuildSettings.setChannelMuted(appContext, ((MuteSettingsSheetViewModel$Config$Channel) muteSettingsSheetViewModel$Config).getChannelId(), false, null);
            emitDismissEvent();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MuteSettingsSheetViewModel(long j, long j2, Observable<MuteSettingsSheetViewModel$StoreState> observable, StoreUserGuildSettings storeUserGuildSettings, Clock clock) {
        MuteSettingsSheetViewModel$Config muteSettingsSheetViewModel$Config$Channel;
        super(MuteSettingsSheetViewModel$ViewState$Uninitialized.INSTANCE);
        m.checkNotNullParameter(observable, "storeStateObservable");
        m.checkNotNullParameter(storeUserGuildSettings, "storeUserGuildSettings");
        m.checkNotNullParameter(clock, "clock");
        this.guildId = j;
        this.channelId = j2;
        this.storeStateObservable = observable;
        this.storeUserGuildSettings = storeUserGuildSettings;
        this.clock = clock;
        if (j != 0) {
            muteSettingsSheetViewModel$Config$Channel = new MuteSettingsSheetViewModel$Config$Guild(j);
        } else {
            muteSettingsSheetViewModel$Config$Channel = new MuteSettingsSheetViewModel$Config$Channel(j2);
        }
        this.config = muteSettingsSheetViewModel$Config$Channel;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), MuteSettingsSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new MuteSettingsSheetViewModel$1(this), 62, (Object) null);
    }
}
