package com.discord.widgets.settings;

import a0.a.a.b;
import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelMuteConfig;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadsJoined;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.settings.MuteSettingsSheetViewModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func4;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: MuteSettingsSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MuteSettingsSheetViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final long MUTE_DURATION_ALWAYS = 0;
    private final long channelId;
    private final Clock clock;
    private final Config config;
    private final PublishSubject<Event> eventSubject;
    private final long guildId;
    private final Observable<StoreState> storeStateObservable;
    private final StoreUserGuildSettings storeUserGuildSettings;

    /* JADX INFO: renamed from: com.discord.widgets.settings.MuteSettingsSheetViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: MuteSettingsSheetViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            MuteSettingsSheetViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: MuteSettingsSheetViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(long guildId, long channelId, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreUserGuildSettings storeUserGuildSettings, StoreThreadsJoined storeThreadsJoined) {
            Observable<StoreState> observableH = Observable.h(storeGuilds.observeGuild(guildId), storeChannels.observeChannel(channelId), storeUserGuildSettings.observeGuildSettings(), storeThreadsJoined.observeJoinedThread(channelId), new Func4<Guild, Channel, Map<Long, ? extends ModelNotificationSettings>, StoreThreadsJoined.JoinedThread, StoreState>() { // from class: com.discord.widgets.settings.MuteSettingsSheetViewModel$Companion$observeStoreState$1
                /* JADX WARN: Code duplicated, block: B:10:0x0017  */
                /* JADX WARN: Code duplicated, block: B:11:0x001c  */
                @Override // rx.functions.Func4
                public final MuteSettingsSheetViewModel.StoreState call(Guild guild, Channel channel, Map<Long, ? extends ModelNotificationSettings> map, StoreThreadsJoined.JoinedThread joinedThread) {
                    Long lValueOf;
                    long guildId2;
                    long jLongValue;
                    if (guild == null) {
                        if (channel != null) {
                            guildId2 = channel.getGuildId();
                        } else {
                            lValueOf = null;
                        }
                        if (lValueOf != null) {
                            jLongValue = lValueOf.longValue();
                        } else {
                            jLongValue = 0;
                        }
                        return new MuteSettingsSheetViewModel.StoreState(guild, channel, map.get(Long.valueOf(jLongValue)), joinedThread);
                    }
                    guildId2 = guild.getId();
                    lValueOf = Long.valueOf(guildId2);
                    if (lValueOf != null) {
                        jLongValue = lValueOf.longValue();
                    } else {
                        jLongValue = 0;
                    }
                    return new MuteSettingsSheetViewModel.StoreState(guild, channel, map.get(Long.valueOf(jLongValue)), joinedThread);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableH, "Observable.combineLatest…dThread\n        )\n      }");
            return observableH;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: MuteSettingsSheetViewModel.kt */
    public static abstract class Config {

        /* JADX INFO: compiled from: MuteSettingsSheetViewModel.kt */
        public static final /* data */ class Channel extends Config {
            private final long channelId;

            public Channel(long j) {
                super(null);
                this.channelId = j;
            }

            public static /* synthetic */ Channel copy$default(Channel channel, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = channel.channelId;
                }
                return channel.copy(j);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            public final Channel copy(long channelId) {
                return new Channel(channelId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Channel) && this.channelId == ((Channel) other).channelId;
                }
                return true;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public int hashCode() {
                return b.a(this.channelId);
            }

            public String toString() {
                return outline.C(outline.U("Channel(channelId="), this.channelId, ")");
            }
        }

        /* JADX INFO: compiled from: MuteSettingsSheetViewModel.kt */
        public static final /* data */ class Guild extends Config {
            private final long guildId;

            public Guild(long j) {
                super(null);
                this.guildId = j;
            }

            public static /* synthetic */ Guild copy$default(Guild guild, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = guild.guildId;
                }
                return guild.copy(j);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            public final Guild copy(long guildId) {
                return new Guild(guildId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Guild) && this.guildId == ((Guild) other).guildId;
                }
                return true;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public int hashCode() {
                return b.a(this.guildId);
            }

            public String toString() {
                return outline.C(outline.U("Guild(guildId="), this.guildId, ")");
            }
        }

        private Config() {
        }

        public /* synthetic */ Config(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: MuteSettingsSheetViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: MuteSettingsSheetViewModel.kt */
        public static final class Dismiss extends Event {
            public static final Dismiss INSTANCE = new Dismiss();

            private Dismiss() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: MuteSettingsSheetViewModel.kt */
        public static final /* data */ class NavigateToChannelSettings extends Event {
            private final long channelId;

            public NavigateToChannelSettings(long j) {
                super(null);
                this.channelId = j;
            }

            public static /* synthetic */ NavigateToChannelSettings copy$default(NavigateToChannelSettings navigateToChannelSettings, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = navigateToChannelSettings.channelId;
                }
                return navigateToChannelSettings.copy(j);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            public final NavigateToChannelSettings copy(long channelId) {
                return new NavigateToChannelSettings(channelId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof NavigateToChannelSettings) && this.channelId == ((NavigateToChannelSettings) other).channelId;
                }
                return true;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public int hashCode() {
                return b.a(this.channelId);
            }

            public String toString() {
                return outline.C(outline.U("NavigateToChannelSettings(channelId="), this.channelId, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: MuteSettingsSheetViewModel.kt */
    public enum SettingsType {
        GUILD,
        DM,
        GROUP_DM,
        THREAD,
        GUILD_CHANNEL,
        CATEGORY,
        UNKNOWN
    }

    /* JADX INFO: compiled from: MuteSettingsSheetViewModel.kt */
    public static final /* data */ class StoreState {
        private final Channel channel;
        private final Guild guild;
        private final ModelNotificationSettings guildNotificationSettings;
        private final StoreThreadsJoined.JoinedThread joinedThread;

        public StoreState(Guild guild, Channel channel, ModelNotificationSettings modelNotificationSettings, StoreThreadsJoined.JoinedThread joinedThread) {
            this.guild = guild;
            this.channel = channel;
            this.guildNotificationSettings = modelNotificationSettings;
            this.joinedThread = joinedThread;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Guild guild, Channel channel, ModelNotificationSettings modelNotificationSettings, StoreThreadsJoined.JoinedThread joinedThread, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = storeState.guild;
            }
            if ((i & 2) != 0) {
                channel = storeState.channel;
            }
            if ((i & 4) != 0) {
                modelNotificationSettings = storeState.guildNotificationSettings;
            }
            if ((i & 8) != 0) {
                joinedThread = storeState.joinedThread;
            }
            return storeState.copy(guild, channel, modelNotificationSettings, joinedThread);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final ModelNotificationSettings getGuildNotificationSettings() {
            return this.guildNotificationSettings;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final StoreThreadsJoined.JoinedThread getJoinedThread() {
            return this.joinedThread;
        }

        public final StoreState copy(Guild guild, Channel channel, ModelNotificationSettings guildNotificationSettings, StoreThreadsJoined.JoinedThread joinedThread) {
            return new StoreState(guild, channel, guildNotificationSettings, joinedThread);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.guild, storeState.guild) && Intrinsics3.areEqual(this.channel, storeState.channel) && Intrinsics3.areEqual(this.guildNotificationSettings, storeState.guildNotificationSettings) && Intrinsics3.areEqual(this.joinedThread, storeState.joinedThread);
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final ModelNotificationSettings getGuildNotificationSettings() {
            return this.guildNotificationSettings;
        }

        public final StoreThreadsJoined.JoinedThread getJoinedThread() {
            return this.joinedThread;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            Channel channel = this.channel;
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            ModelNotificationSettings modelNotificationSettings = this.guildNotificationSettings;
            int iHashCode3 = (iHashCode2 + (modelNotificationSettings != null ? modelNotificationSettings.hashCode() : 0)) * 31;
            StoreThreadsJoined.JoinedThread joinedThread = this.joinedThread;
            return iHashCode3 + (joinedThread != null ? joinedThread.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(guild=");
            sbU.append(this.guild);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", guildNotificationSettings=");
            sbU.append(this.guildNotificationSettings);
            sbU.append(", joinedThread=");
            sbU.append(this.joinedThread);
            sbU.append(")");
            return sbU.toString();
        }

        public /* synthetic */ StoreState(Guild guild, Channel channel, ModelNotificationSettings modelNotificationSettings, StoreThreadsJoined.JoinedThread joinedThread, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(guild, channel, (i & 4) != 0 ? null : modelNotificationSettings, joinedThread);
        }
    }

    /* JADX INFO: compiled from: MuteSettingsSheetViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: MuteSettingsSheetViewModel.kt */
        public static final class Failure extends ViewState {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: MuteSettingsSheetViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final boolean isChannelMuted;
            private final boolean isGuildMuted;
            private final String muteEndTime;
            private final int notificationSetting;
            private final SettingsType settingsType;
            private final String subtitle;

            public /* synthetic */ Loaded(SettingsType settingsType, String str, boolean z2, boolean z3, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this(settingsType, str, (i2 & 4) != 0 ? false : z2, (i2 & 8) != 0 ? false : z3, (i2 & 16) != 0 ? null : str2, (i2 & 32) != 0 ? ModelNotificationSettings.FREQUENCY_UNSET : i);
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, SettingsType settingsType, String str, boolean z2, boolean z3, String str2, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    settingsType = loaded.settingsType;
                }
                if ((i2 & 2) != 0) {
                    str = loaded.subtitle;
                }
                String str3 = str;
                if ((i2 & 4) != 0) {
                    z2 = loaded.isChannelMuted;
                }
                boolean z4 = z2;
                if ((i2 & 8) != 0) {
                    z3 = loaded.isGuildMuted;
                }
                boolean z5 = z3;
                if ((i2 & 16) != 0) {
                    str2 = loaded.muteEndTime;
                }
                String str4 = str2;
                if ((i2 & 32) != 0) {
                    i = loaded.notificationSetting;
                }
                return loaded.copy(settingsType, str3, z4, z5, str4, i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final SettingsType getSettingsType() {
                return this.settingsType;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getSubtitle() {
                return this.subtitle;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getIsChannelMuted() {
                return this.isChannelMuted;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getIsGuildMuted() {
                return this.isGuildMuted;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final String getMuteEndTime() {
                return this.muteEndTime;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final int getNotificationSetting() {
                return this.notificationSetting;
            }

            public final Loaded copy(SettingsType settingsType, String subtitle, boolean isChannelMuted, boolean isGuildMuted, String muteEndTime, int notificationSetting) {
                Intrinsics3.checkNotNullParameter(settingsType, "settingsType");
                Intrinsics3.checkNotNullParameter(subtitle, "subtitle");
                return new Loaded(settingsType, subtitle, isChannelMuted, isGuildMuted, muteEndTime, notificationSetting);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.settingsType, loaded.settingsType) && Intrinsics3.areEqual(this.subtitle, loaded.subtitle) && this.isChannelMuted == loaded.isChannelMuted && this.isGuildMuted == loaded.isGuildMuted && Intrinsics3.areEqual(this.muteEndTime, loaded.muteEndTime) && this.notificationSetting == loaded.notificationSetting;
            }

            public final String getMuteEndTime() {
                return this.muteEndTime;
            }

            public final int getNotificationSetting() {
                return this.notificationSetting;
            }

            public final SettingsType getSettingsType() {
                return this.settingsType;
            }

            public final String getSubtitle() {
                return this.subtitle;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v6, types: [int] */
            /* JADX WARN: Type inference failed for: r2v4, types: [int] */
            /* JADX WARN: Type inference failed for: r2v7 */
            /* JADX WARN: Type inference failed for: r2v9 */
            /* JADX WARN: Type inference failed for: r3v0 */
            /* JADX WARN: Type inference failed for: r3v1, types: [int] */
            /* JADX WARN: Type inference failed for: r3v2 */
            public int hashCode() {
                SettingsType settingsType = this.settingsType;
                int iHashCode = (settingsType != null ? settingsType.hashCode() : 0) * 31;
                String str = this.subtitle;
                int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
                boolean z2 = this.isChannelMuted;
                ?? r2 = z2;
                if (z2) {
                    r2 = 1;
                }
                int i = (iHashCode2 + r2) * 31;
                boolean z3 = this.isGuildMuted;
                int i2 = (i + (z3 ? 1 : z3)) * 31;
                String str2 = this.muteEndTime;
                return ((i2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.notificationSetting;
            }

            public final boolean isChannelMuted() {
                return this.isChannelMuted;
            }

            public final boolean isGuildMuted() {
                return this.isGuildMuted;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(settingsType=");
                sbU.append(this.settingsType);
                sbU.append(", subtitle=");
                sbU.append(this.subtitle);
                sbU.append(", isChannelMuted=");
                sbU.append(this.isChannelMuted);
                sbU.append(", isGuildMuted=");
                sbU.append(this.isGuildMuted);
                sbU.append(", muteEndTime=");
                sbU.append(this.muteEndTime);
                sbU.append(", notificationSetting=");
                return outline.B(sbU, this.notificationSetting, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(SettingsType settingsType, String str, boolean z2, boolean z3, String str2, int i) {
                super(null);
                Intrinsics3.checkNotNullParameter(settingsType, "settingsType");
                Intrinsics3.checkNotNullParameter(str, "subtitle");
                this.settingsType = settingsType;
                this.subtitle = str;
                this.isChannelMuted = z2;
                this.isGuildMuted = z3;
                this.muteEndTime = str2;
                this.notificationSetting = i;
            }
        }

        /* JADX INFO: compiled from: MuteSettingsSheetViewModel.kt */
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            SettingsType.values();
            int[] iArr = new int[7];
            $EnumSwitchMapping$0 = iArr;
            iArr[SettingsType.GUILD.ordinal()] = 1;
            iArr[SettingsType.THREAD.ordinal()] = 2;
            iArr[SettingsType.GUILD_CHANNEL.ordinal()] = 3;
            iArr[SettingsType.DM.ordinal()] = 4;
            iArr[SettingsType.GROUP_DM.ordinal()] = 5;
            iArr[SettingsType.CATEGORY.ordinal()] = 6;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ MuteSettingsSheetViewModel(long j, long j2, Observable observable, StoreUserGuildSettings storeUserGuildSettings, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableObserveStoreState;
        if ((i & 4) != 0) {
            Companion companion = INSTANCE;
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observableObserveStoreState = companion.observeStoreState(j, j2, companion2.getGuilds(), companion2.getChannels(), companion2.getUserGuildSettings(), companion2.getThreadsJoined());
        } else {
            observableObserveStoreState = observable;
        }
        this(j, j2, observableObserveStoreState, (i & 8) != 0 ? StoreStream.INSTANCE.getUserGuildSettings() : storeUserGuildSettings, (i & 16) != 0 ? ClockFactory.get() : clock);
    }

    @MainThread
    private final void emitDismissEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.Dismiss.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0091  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:81:0x0121  */
    @MainThread
    private final void handleStoreState(StoreState storeState) {
        SettingsType settingsType;
        String name;
        ModelNotificationSettings.ChannelOverride channelOverride;
        String muteEndTime;
        ModelNotificationSettings guildNotificationSettings;
        int i;
        ModelMuteConfig muteConfig;
        StoreThreadsJoined.JoinedThread joinedThread;
        List<ModelNotificationSettings.ChannelOverride> channelOverrides;
        Object next;
        boolean z2;
        Guild guild = storeState.getGuild();
        Channel channel = storeState.getChannel();
        if (guild != null) {
            settingsType = SettingsType.GUILD;
        } else if (channel == null) {
            settingsType = SettingsType.UNKNOWN;
        } else if (ChannelUtils.m(channel)) {
            settingsType = SettingsType.DM;
        } else if (ChannelUtils.p(channel)) {
            settingsType = SettingsType.GROUP_DM;
        } else if (ChannelUtils.k(channel)) {
            settingsType = SettingsType.CATEGORY;
        } else {
            settingsType = ChannelUtils.H(channel) ? SettingsType.THREAD : SettingsType.GUILD_CHANNEL;
        }
        SettingsType settingsType2 = settingsType;
        if (settingsType2 == SettingsType.UNKNOWN) {
            updateViewState(ViewState.Failure.INSTANCE);
            return;
        }
        int iOrdinal = settingsType2.ordinal();
        if (iOrdinal == 0) {
            Intrinsics3.checkNotNull(guild);
            name = guild.getName();
        } else if (iOrdinal == 1 || iOrdinal == 2) {
            Intrinsics3.checkNotNull(channel);
            name = ChannelUtils.c(channel);
        } else if (iOrdinal == 3) {
            StringBuilder sb = new StringBuilder();
            sb.append('\"');
            Intrinsics3.checkNotNull(channel);
            sb.append(ChannelUtils.c(channel));
            sb.append('\"');
            name = sb.toString();
        } else if (iOrdinal == 4) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(MentionUtils.CHANNELS_CHAR);
            Intrinsics3.checkNotNull(channel);
            sb2.append(ChannelUtils.c(channel));
            name = sb2.toString();
        } else if (iOrdinal != 5) {
            name = "";
        } else {
            Intrinsics3.checkNotNull(channel);
            name = ChannelUtils.c(channel);
        }
        ModelNotificationSettings guildNotificationSettings2 = storeState.getGuildNotificationSettings();
        Integer numValueOf = null;
        if (guildNotificationSettings2 == null || (channelOverrides = guildNotificationSettings2.getChannelOverrides()) == null) {
            channelOverride = null;
        } else {
            Iterator<T> it = channelOverrides.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                ModelNotificationSettings.ChannelOverride channelOverride2 = (ModelNotificationSettings.ChannelOverride) next;
                Channel channel2 = storeState.getChannel();
                if (channel2 != null) {
                    long id2 = channel2.getId();
                    Intrinsics3.checkNotNullExpressionValue(channelOverride2, "channelOverride");
                    if (id2 == channelOverride2.getChannelId()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
            } while (!z2);
            channelOverride = (ModelNotificationSettings.ChannelOverride) next;
        }
        boolean z3 = channel == null || !ChannelUtils.H(channel) ? !(channelOverride == null || !channelOverride.isMuted()) : !((joinedThread = storeState.getJoinedThread()) == null || !joinedThread.getMuted());
        if (channel != null && ChannelUtils.H(channel)) {
            StoreThreadsJoined.JoinedThread joinedThread2 = storeState.getJoinedThread();
            if (joinedThread2 == null || (muteConfig = joinedThread2.getMuteConfig()) == null) {
                muteEndTime = null;
            } else {
                muteEndTime = muteConfig.getEndTime();
            }
        } else if (channelOverride != null) {
            muteEndTime = channelOverride.getMuteEndTime();
        } else {
            muteEndTime = null;
        }
        if (channel != null && ChannelUtils.H(channel)) {
            StoreThreadsJoined.JoinedThread joinedThread3 = storeState.getJoinedThread();
            numValueOf = joinedThread3 != null ? Integer.valueOf(joinedThread3.getFlags()) : null;
            if (numValueOf != null && numValueOf.intValue() == 8) {
                i = ModelNotificationSettings.FREQUENCY_NOTHING;
            } else {
                i = (numValueOf != null && numValueOf.intValue() == 4) ? ModelNotificationSettings.FREQUENCY_MENTIONS : ModelNotificationSettings.FREQUENCY_ALL;
            }
            numValueOf = Integer.valueOf(i);
        } else if (channelOverride != null) {
            numValueOf = Integer.valueOf(channelOverride.getMessageNotifications());
        }
        updateViewState(new ViewState.Loaded(settingsType2, name, z3, (channel == null || ChannelUtils.B(channel) || (guildNotificationSettings = storeState.getGuildNotificationSettings()) == null || !guildNotificationSettings.isMuted()) ? false : true, muteEndTime, numValueOf != null ? numValueOf.intValue() : ModelNotificationSettings.FREQUENCY_UNSET));
    }

    @MainThread
    public final void emitNotificationSettingsEvent(long channelId) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.NavigateToChannelSettings(channelId));
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Clock getClock() {
        return this.clock;
    }

    public final Config getConfig() {
        return this.config;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final Observable<StoreState> getStoreStateObservable() {
        return this.storeStateObservable;
    }

    public final StoreUserGuildSettings getStoreUserGuildSettings() {
        return this.storeUserGuildSettings;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void onChannelSettingsSelected() {
        Config config = this.config;
        if (config instanceof Config.Channel) {
            emitNotificationSettingsEvent(((Config.Channel) config).getChannelId());
        }
    }

    @MainThread
    public final void selectMuteDurationMs(long muteDurationMs, Context appContext) {
        Intrinsics3.checkNotNullParameter(appContext, "appContext");
        ModelMuteConfig modelMuteConfig = muteDurationMs != 0 ? new ModelMuteConfig(TimeUtils.toUTCDateTime$default(Long.valueOf(this.clock.currentTimeMillis() + muteDurationMs), null, 2, null)) : null;
        Config config = this.config;
        if (config instanceof Config.Guild) {
            this.storeUserGuildSettings.setGuildMuted(appContext, ((Config.Guild) config).getGuildId(), true, modelMuteConfig);
        } else if (config instanceof Config.Channel) {
            this.storeUserGuildSettings.setChannelMuted(appContext, ((Config.Channel) config).getChannelId(), true, modelMuteConfig);
        }
        emitDismissEvent();
    }

    @MainThread
    public final void unmute(Context appContext) {
        Intrinsics3.checkNotNullParameter(appContext, "appContext");
        Config config = this.config;
        if (config instanceof Config.Channel) {
            this.storeUserGuildSettings.setChannelMuted(appContext, ((Config.Channel) config).getChannelId(), false, null);
            emitDismissEvent();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MuteSettingsSheetViewModel(long j, long j2, Observable<StoreState> observable, StoreUserGuildSettings storeUserGuildSettings, Clock clock) {
        Config channel;
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        Intrinsics3.checkNotNullParameter(storeUserGuildSettings, "storeUserGuildSettings");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.guildId = j;
        this.channelId = j2;
        this.storeStateObservable = observable;
        this.storeUserGuildSettings = storeUserGuildSettings;
        this.clock = clock;
        if (j != 0) {
            channel = new Config.Guild(j);
        } else {
            channel = new Config.Channel(j2);
        }
        this.config = channel;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) MuteSettingsSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
