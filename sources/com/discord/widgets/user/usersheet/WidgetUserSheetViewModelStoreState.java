package com.discord.widgets.user.usersheet;

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
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserNotes;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.StoreUserProfile;
import com.discord.stores.StoreUserRelationships;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceStates;
import com.discord.utilities.p501rx.LeadingEdgeThrottle;
import com.discord.utilities.p501rx.ObservableCombineLatestOverloadsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContextService;
import com.discord.widgets.guildcommunicationdisabled.start.GuildCommunicationDisabledGuildsFeatureFlag;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.user.presence.ModelRichPresence;
import com.discord.widgets.user.usersheet.WidgetUserSheetViewModel;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function4;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p643a.C12666r;
import p637j0.p642l.p647e.C12721k;
import p637j0.p653p.C12781a;
import p658rx.Observable;
import p658rx.Scheduler;
import p658rx.functions.Func4;

/* JADX INFO: compiled from: WidgetUserSheetViewModelStoreState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheetViewModelStoreState {
    public static final WidgetUserSheetViewModelStoreState INSTANCE = new WidgetUserSheetViewModelStoreState();

    /* JADX INFO: compiled from: WidgetUserSheetViewModelStoreState.kt */
    public static final /* data */ class BootstrapData {
        private final Channel channel;
        private final MeUser me;
        private final Channel selectedVoiceChannel;
        private final User user;

        public BootstrapData(User user, MeUser meUser, Channel channel, Channel channel2) {
            C12238m.checkNotNullParameter(meUser, "me");
            this.user = user;
            this.me = meUser;
            this.channel = channel;
            this.selectedVoiceChannel = channel2;
        }

        public static /* synthetic */ BootstrapData copy$default(BootstrapData bootstrapData, User user, MeUser meUser, Channel channel, Channel channel2, int i, Object obj) {
            if ((i & 1) != 0) {
                user = bootstrapData.user;
            }
            if ((i & 2) != 0) {
                meUser = bootstrapData.me;
            }
            if ((i & 4) != 0) {
                channel = bootstrapData.channel;
            }
            if ((i & 8) != 0) {
                channel2 = bootstrapData.selectedVoiceChannel;
            }
            return bootstrapData.copy(user, meUser, channel, channel2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final MeUser getMe() {
            return this.me;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Channel getSelectedVoiceChannel() {
            return this.selectedVoiceChannel;
        }

        public final BootstrapData copy(User user, MeUser me2, Channel channel, Channel selectedVoiceChannel) {
            C12238m.checkNotNullParameter(me2, "me");
            return new BootstrapData(user, me2, channel, selectedVoiceChannel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BootstrapData)) {
                return false;
            }
            BootstrapData bootstrapData = (BootstrapData) other;
            return C12238m.areEqual(this.user, bootstrapData.user) && C12238m.areEqual(this.me, bootstrapData.me) && C12238m.areEqual(this.channel, bootstrapData.channel) && C12238m.areEqual(this.selectedVoiceChannel, bootstrapData.selectedVoiceChannel);
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final MeUser getMe() {
            return this.me;
        }

        public final Channel getSelectedVoiceChannel() {
            return this.selectedVoiceChannel;
        }

        public final User getUser() {
            return this.user;
        }

        public int hashCode() {
            User user = this.user;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            MeUser meUser = this.me;
            int iHashCode2 = (iHashCode + (meUser != null ? meUser.hashCode() : 0)) * 31;
            Channel channel = this.channel;
            int iHashCode3 = (iHashCode2 + (channel != null ? channel.hashCode() : 0)) * 31;
            Channel channel2 = this.selectedVoiceChannel;
            return iHashCode3 + (channel2 != null ? channel2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("BootstrapData(user=");
            sbM833U.append(this.user);
            sbM833U.append(", me=");
            sbM833U.append(this.me);
            sbM833U.append(", channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", selectedVoiceChannel=");
            sbM833U.append(this.selectedVoiceChannel);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModelStoreState$observeStoreState$2 */
    /* JADX INFO: compiled from: WidgetUserSheetViewModelStoreState.kt */
    public static final /* synthetic */ class C104012 extends C12236k implements Function4<User, MeUser, Channel, Channel, BootstrapData> {
        public static final C104012 INSTANCE = new C104012();

        public C104012() {
            super(4, BootstrapData.class, "<init>", "<init>(Lcom/discord/models/user/User;Lcom/discord/models/user/MeUser;Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function4
        public final BootstrapData invoke(User user, MeUser meUser, Channel channel, Channel channel2) {
            C12238m.checkNotNullParameter(meUser, "p2");
            return new BootstrapData(user, meUser, channel, channel2);
        }
    }

    private WidgetUserSheetViewModelStoreState() {
    }

    public static /* synthetic */ Observable observeStoreState$default(WidgetUserSheetViewModelStoreState widgetUserSheetViewModelStoreState, long j, Long l, Long l2, StoreUser storeUser, StoreChannels storeChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreUserProfile storeUserProfile, StoreUserRelationships storeUserRelationships, StoreVoiceStates storeVoiceStates, StoreGuilds storeGuilds, StoreMediaSettings storeMediaSettings, StoreUserPresence storeUserPresence, StorePermissions storePermissions, StoreUserNotes storeUserNotes, StoreStageChannels storeStageChannels, StreamContextService streamContextService, Scheduler scheduler, int i, Object obj) {
        Scheduler scheduler2;
        StoreUser users = (i & 8) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        StoreChannels channels = (i & 16) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreVoiceChannelSelected voiceChannelSelected = (i & 32) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected;
        StoreUserProfile userProfile = (i & 64) != 0 ? StoreStream.INSTANCE.getUserProfile() : storeUserProfile;
        StoreUserRelationships userRelationships = (i & 128) != 0 ? StoreStream.INSTANCE.getUserRelationships() : storeUserRelationships;
        StoreVoiceStates voiceStates = (i & 256) != 0 ? StoreStream.INSTANCE.getVoiceStates() : storeVoiceStates;
        StoreGuilds guilds = (i & 512) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        StoreMediaSettings mediaSettings = (i & 1024) != 0 ? StoreStream.INSTANCE.getMediaSettings() : storeMediaSettings;
        StoreUserPresence presences = (i & 2048) != 0 ? StoreStream.INSTANCE.getPresences() : storeUserPresence;
        StorePermissions permissions = (i & 4096) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions;
        StoreUserNotes usersNotes = (i & 8192) != 0 ? StoreStream.INSTANCE.getUsersNotes() : storeUserNotes;
        StoreStageChannels stageChannels = (i & 16384) != 0 ? StoreStream.INSTANCE.getStageChannels() : storeStageChannels;
        StreamContextService streamContextService2 = (32768 & i) != 0 ? new StreamContextService(null, null, null, null, null, null, null, null, 255, null) : streamContextService;
        if ((i & 65536) != 0) {
            Scheduler schedulerM10873a = C12781a.m10873a();
            C12238m.checkNotNullExpressionValue(schedulerM10873a, "Schedulers.computation()");
            scheduler2 = schedulerM10873a;
        } else {
            scheduler2 = scheduler;
        }
        return widgetUserSheetViewModelStoreState.observeStoreState(j, l, l2, users, channels, voiceChannelSelected, userProfile, userRelationships, voiceStates, guilds, mediaSettings, presences, permissions, usersNotes, stageChannels, streamContextService2, scheduler2);
    }

    public final Observable<WidgetUserSheetViewModel.StoreState> observeStoreState(long userId, Long channelId, final Long guildId, StoreUser storeUser, StoreChannels storeChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, final StoreUserProfile storeUserProfile, final StoreUserRelationships storeUserRelationships, final StoreVoiceStates storeVoiceStates, final StoreGuilds storeGuilds, final StoreMediaSettings storeMediaSettings, final StoreUserPresence storeUserPresence, final StorePermissions storePermissions, final StoreUserNotes storeUserNotes, final StoreStageChannels storeStageChannels, final StreamContextService streamContextService, Scheduler storeStateRxScheduler) {
        Observable<Channel> c12721k;
        C12238m.checkNotNullParameter(storeUser, "storeUser");
        C12238m.checkNotNullParameter(storeChannels, "storeChannels");
        C12238m.checkNotNullParameter(storeVoiceChannelSelected, "storeVoiceChannelSelected");
        C12238m.checkNotNullParameter(storeUserProfile, "storeUserProfile");
        C12238m.checkNotNullParameter(storeUserRelationships, "storeUserRelationships");
        C12238m.checkNotNullParameter(storeVoiceStates, "storeVoiceStates");
        C12238m.checkNotNullParameter(storeGuilds, "storeGuilds");
        C12238m.checkNotNullParameter(storeMediaSettings, "storeMediaSettings");
        C12238m.checkNotNullParameter(storeUserPresence, "storeUserPresence");
        C12238m.checkNotNullParameter(storePermissions, "storePermissions");
        C12238m.checkNotNullParameter(storeUserNotes, "storeUserNotes");
        C12238m.checkNotNullParameter(storeStageChannels, "storeStageChannels");
        C12238m.checkNotNullParameter(streamContextService, "streamContextService");
        C12238m.checkNotNullParameter(storeStateRxScheduler, "storeStateRxScheduler");
        Observable<User> observableObserveUser = storeUser.observeUser(userId);
        Observable observableObserveMe$default = StoreUser.observeMe$default(storeUser, false, 1, null);
        if (channelId == null || (c12721k = storeChannels.observeChannel(channelId.longValue())) == null) {
            c12721k = new C12721k<>(null);
        }
        Observable<Channel> observableObserveSelectedChannel = storeVoiceChannelSelected.observeSelectedChannel();
        final C104012 c104012 = C104012.INSTANCE;
        Object obj = c104012;
        if (c104012 != null) {
            obj = new Func4() { // from class: com.discord.widgets.user.usersheet.WidgetUserSheetViewModelStoreState$sam$rx_functions_Func4$0
                @Override // p658rx.functions.Func4
                public final /* synthetic */ Object call(Object obj2, Object obj3, Object obj4, Object obj5) {
                    return c104012.invoke(obj2, obj3, obj4, obj5);
                }
            };
        }
        Observable<WidgetUserSheetViewModel.StoreState> observableM11112r = Observable.m11074h0(new C12666r(Observable.m11073h(observableObserveUser, observableObserveMe$default, c12721k, observableObserveSelectedChannel, (Func4) obj).m11099Y(new InterfaceC12589b<BootstrapData, Observable<? extends WidgetUserSheetViewModel.StoreState>>() { // from class: com.discord.widgets.user.usersheet.WidgetUserSheetViewModelStoreState.observeStoreState.3

            /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModelStoreState$observeStoreState$3$2, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetUserSheetViewModelStoreState.kt */
            public static final class AnonymousClass2 extends AbstractC12240o implements Function16<Map<Long, ? extends GuildMember>, Map<Long, ? extends GuildRole>, Map<Long, ? extends VoiceState>, Map<Long, ? extends VoiceState>, StoreMediaSettings.VoiceConfiguration, ModelRichPresence, Guild, Long, StreamContext, UserProfile, Integer, StoreUserNotes.UserNoteState, StageRoles, StageRequestToSpeakState, StageRoles, Boolean, WidgetUserSheetViewModel.StoreState> {
                public final /* synthetic */ Channel $channel;
                public final /* synthetic */ MeUser $me;
                public final /* synthetic */ Channel $selectedVoiceChannel;
                public final /* synthetic */ User $user;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(User user, MeUser meUser, Channel channel, Channel channel2) {
                    super(16);
                    this.$user = user;
                    this.$me = meUser;
                    this.$channel = channel;
                    this.$selectedVoiceChannel = channel2;
                }

                @Override // kotlin.jvm.functions.Function16
                public /* bridge */ /* synthetic */ WidgetUserSheetViewModel.StoreState invoke(Map<Long, ? extends GuildMember> map, Map<Long, ? extends GuildRole> map2, Map<Long, ? extends VoiceState> map3, Map<Long, ? extends VoiceState> map4, StoreMediaSettings.VoiceConfiguration voiceConfiguration, ModelRichPresence modelRichPresence, Guild guild, Long l, StreamContext streamContext, UserProfile userProfile, Integer num, StoreUserNotes.UserNoteState userNoteState, StageRoles stageRoles, StageRequestToSpeakState stageRequestToSpeakState, StageRoles stageRoles2, Boolean bool) {
                    return invoke((Map<Long, GuildMember>) map, (Map<Long, GuildRole>) map2, (Map<Long, VoiceState>) map3, (Map<Long, VoiceState>) map4, voiceConfiguration, modelRichPresence, guild, l, streamContext, userProfile, num, userNoteState, stageRoles, stageRequestToSpeakState, stageRoles2, bool.booleanValue());
                }

                public final WidgetUserSheetViewModel.StoreState invoke(Map<Long, GuildMember> map, Map<Long, GuildRole> map2, Map<Long, VoiceState> map3, Map<Long, VoiceState> map4, StoreMediaSettings.VoiceConfiguration voiceConfiguration, ModelRichPresence modelRichPresence, Guild guild, Long l, StreamContext streamContext, UserProfile userProfile, Integer num, StoreUserNotes.UserNoteState userNoteState, StageRoles stageRoles, StageRequestToSpeakState stageRequestToSpeakState, StageRoles stageRoles2, boolean z2) {
                    C12238m.checkNotNullParameter(map, "computedMembers");
                    C12238m.checkNotNullParameter(map2, "guildRoles");
                    C12238m.checkNotNullParameter(map3, "mySelectedVoiceChannelVoiceStates");
                    C12238m.checkNotNullParameter(map4, "currentChannelVoiceStates");
                    C12238m.checkNotNullParameter(voiceConfiguration, "voiceConfig");
                    C12238m.checkNotNullParameter(userProfile, "userProfile");
                    C12238m.checkNotNullParameter(userNoteState, "userNote");
                    C12238m.checkNotNullParameter(stageRequestToSpeakState, "userRequestToSpeakState");
                    Boolean bool = (Boolean) C1643a.m849f(this.$user, voiceConfiguration.getMutedUsers());
                    boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
                    boolean zIsSelfMuted = voiceConfiguration.isSelfMuted();
                    boolean zIsSelfDeafened = voiceConfiguration.isSelfDeafened();
                    Float f = (Float) C1643a.m849f(this.$user, voiceConfiguration.getUserOutputVolumes());
                    float fFloatValue = f != null ? f.floatValue() : 100.0f;
                    User user = this.$user;
                    MeUser meUser = this.$me;
                    Channel channel = this.$channel;
                    Channel channel2 = this.$selectedVoiceChannel;
                    return new WidgetUserSheetViewModel.StoreState(user, meUser, channel, map, map2, map3, map4, zBooleanValue, zIsSelfMuted, zIsSelfDeafened, fFloatValue, modelRichPresence, guild, l, streamContext, userProfile, num, userNoteState, (channel2 == null || !ChannelUtils.m7669D(channel2)) ? null : channel2, stageRoles, stageRequestToSpeakState, stageRoles2, z2, null);
                }
            }

            /* JADX WARN: Code duplicated, block: B:16:0x0065  */
            /* JADX WARN: Code duplicated, block: B:21:0x0082  */
            /* JADX WARN: Code duplicated, block: B:37:0x00e6  */
            /* JADX WARN: Code duplicated, block: B:46:0x0112  */
            /* JADX WARN: Code duplicated, block: B:49:0x0126  */
            /* JADX WARN: Code duplicated, block: B:52:0x0131  */
            /* JADX WARN: Code duplicated, block: B:55:0x0144  */
            /* JADX WARN: Code duplicated, block: B:58:0x0150  */
            /* JADX WARN: Code duplicated, block: B:61:0x015d  */
            /* JADX WARN: Code duplicated, block: B:63:0x0165  */
            /* JADX WARN: Code duplicated, block: B:66:0x0179  */
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends WidgetUserSheetViewModel.StoreState> call(BootstrapData bootstrapData) {
                Observable<Map<Long, GuildMember>> c12721k2;
                Observable<Map<Long, GuildRole>> c12721k3;
                Observable<Guild> c12721k4;
                Observable<Map<Long, GuildMember>> observable;
                Observable<Long> c12721k5;
                MeUser meUser;
                Channel channel;
                Observable<StageRoles> c12721k6;
                MeUser meUser2;
                Observable<StageRequestToSpeakState> c12721k7;
                Observable<StageRoles> c12721k8;
                Observable<Boolean> c12721k9;
                Observable<Map<Long, VoiceState>> observableObserve;
                Observable<Map<Long, VoiceState>> observableObserve2;
                User user = bootstrapData.getUser();
                MeUser me2 = bootstrapData.getMe();
                Channel channel2 = bootstrapData.getChannel();
                Channel selectedVoiceChannel = bootstrapData.getSelectedVoiceChannel();
                if (user == null) {
                    return Observable.m11068d0(5L, TimeUnit.SECONDS).m11083G(new InterfaceC12589b() { // from class: com.discord.widgets.user.usersheet.WidgetUserSheetViewModelStoreState.observeStoreState.3.1
                        @Override // p637j0.p641k.InterfaceC12589b
                        public final Void call(Long l) {
                            return null;
                        }
                    });
                }
                Long lValueOf = guildId;
                if (lValueOf == null) {
                    lValueOf = channel2 != null ? Long.valueOf(channel2.getGuildId()) : null;
                }
                if (lValueOf != null) {
                    lValueOf.longValue();
                    Observable<Map<Long, GuildMember>> observableObserveComputed = storeGuilds.observeComputed(lValueOf.longValue(), C12147n.listOf((Object[]) new Long[]{Long.valueOf(user.getId()), Long.valueOf(me2.getId())}));
                    if (observableObserveComputed != null) {
                        c12721k2 = observableObserveComputed;
                    } else {
                        c12721k2 = new C12721k(C12136h0.emptyMap());
                    }
                } else {
                    c12721k2 = new C12721k(C12136h0.emptyMap());
                }
                if (lValueOf != null) {
                    lValueOf.longValue();
                    Observable<Map<Long, GuildRole>> observableObserveRoles = storeGuilds.observeRoles(lValueOf.longValue());
                    if (observableObserveRoles != null) {
                        c12721k3 = observableObserveRoles;
                    } else {
                        c12721k3 = new C12721k(C12136h0.emptyMap());
                    }
                } else {
                    c12721k3 = new C12721k(C12136h0.emptyMap());
                }
                Observable<Map<Long, VoiceState>> c12721k10 = (selectedVoiceChannel == null || (observableObserve2 = storeVoiceStates.observe(selectedVoiceChannel.getGuildId(), selectedVoiceChannel.getId())) == null) ? new C12721k(C12136h0.emptyMap()) : observableObserve2;
                Observable<Map<Long, VoiceState>> c12721k11 = (channel2 == null || (observableObserve = storeVoiceStates.observe(channel2.getGuildId(), channel2.getId())) == null) ? new C12721k(C12136h0.emptyMap()) : observableObserve;
                Observable<ModelRichPresence> observable2 = ModelRichPresence.INSTANCE.get(user.getId(), storeUserPresence);
                if (lValueOf != null) {
                    lValueOf.longValue();
                    c12721k4 = storeGuilds.observeGuild(lValueOf.longValue());
                    if (c12721k4 == null) {
                        c12721k4 = new C12721k<>(null);
                    }
                } else {
                    c12721k4 = new C12721k<>(null);
                }
                if (channel2 != null) {
                    observable = c12721k2;
                    c12721k5 = storePermissions.observePermissionsForChannel(channel2.getId());
                    if (c12721k5 == null) {
                    }
                    Observable<StreamContext> forUser = streamContextService.getForUser(user.getId(), true);
                    if (selectedVoiceChannel != null) {
                        meUser = me2;
                        channel = channel2;
                        c12721k6 = storeStageChannels.observeUserRoles(user.getId(), selectedVoiceChannel.getId());
                        if (c12721k6 == null) {
                        }
                        if (selectedVoiceChannel != null) {
                            meUser2 = meUser;
                            c12721k7 = storeStageChannels.observeUserRequestToSpeakState(user.getId(), selectedVoiceChannel.getId());
                            if (c12721k7 == null) {
                            }
                            if (selectedVoiceChannel != null || (c12721k8 = storeStageChannels.observeMyRoles(selectedVoiceChannel.getId())) == null) {
                                c12721k8 = new C12721k<>(null);
                            }
                            if (lValueOf != null) {
                                lValueOf.longValue();
                                c12721k9 = GuildCommunicationDisabledGuildsFeatureFlag.INSTANCE.getINSTANCE().observeCanGuildAccessCommunicationDisabled(lValueOf.longValue());
                                if (c12721k9 == null) {
                                    c12721k9 = new C12721k(Boolean.FALSE);
                                }
                            } else {
                                c12721k9 = new C12721k(Boolean.FALSE);
                            }
                            C12238m.checkNotNullExpressionValue(observable, "computedMembersObservable");
                            C12238m.checkNotNullExpressionValue(c12721k3, "guildRolesObservable");
                            C12238m.checkNotNullExpressionValue(c12721k10, "mySelectedVoiceChannelVoiceStatesObservable");
                            C12238m.checkNotNullExpressionValue(c12721k11, "currentChannelVoiceStatesObservable");
                            Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig = storeMediaSettings.getVoiceConfig();
                            C12238m.checkNotNullExpressionValue(c12721k4, "guildsObservable");
                            C12238m.checkNotNullExpressionValue(c12721k5, "permissionsObservable");
                            Observable<UserProfile> observableObserveUserProfile = storeUserProfile.observeUserProfile(user.getId());
                            Observable<Integer> observableObserve3 = storeUserRelationships.observe(user.getId());
                            Observable<StoreUserNotes.UserNoteState> observableObserveUserNote = storeUserNotes.observeUserNote(user.getId());
                            C12238m.checkNotNullExpressionValue(c12721k6, "userStageRolesObservable");
                            C12238m.checkNotNullExpressionValue(c12721k7, "userStageRequestToSpeakStateObservable");
                            C12238m.checkNotNullExpressionValue(c12721k8, "myStageRolesObservable");
                            C12238m.checkNotNullExpressionValue(c12721k9, "canDisableCommunicationObservable");
                            return ObservableCombineLatestOverloadsKt.combineLatest(observable, c12721k3, c12721k10, c12721k11, voiceConfig, observable2, c12721k4, c12721k5, forUser, observableObserveUserProfile, observableObserve3, observableObserveUserNote, c12721k6, c12721k7, c12721k8, c12721k9, new AnonymousClass2(user, meUser2, channel, selectedVoiceChannel));
                        }
                        meUser2 = meUser;
                        c12721k7 = new C12721k(StageRequestToSpeakState.NONE);
                        if (selectedVoiceChannel != null) {
                            c12721k8 = new C12721k<>(null);
                        } else {
                            c12721k8 = new C12721k<>(null);
                        }
                        if (lValueOf != null) {
                            lValueOf.longValue();
                            c12721k9 = GuildCommunicationDisabledGuildsFeatureFlag.INSTANCE.getINSTANCE().observeCanGuildAccessCommunicationDisabled(lValueOf.longValue());
                            if (c12721k9 == null) {
                                c12721k9 = new C12721k(Boolean.FALSE);
                            }
                        } else {
                            c12721k9 = new C12721k(Boolean.FALSE);
                        }
                        C12238m.checkNotNullExpressionValue(observable, "computedMembersObservable");
                        C12238m.checkNotNullExpressionValue(c12721k3, "guildRolesObservable");
                        C12238m.checkNotNullExpressionValue(c12721k10, "mySelectedVoiceChannelVoiceStatesObservable");
                        C12238m.checkNotNullExpressionValue(c12721k11, "currentChannelVoiceStatesObservable");
                        Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig2 = storeMediaSettings.getVoiceConfig();
                        C12238m.checkNotNullExpressionValue(c12721k4, "guildsObservable");
                        C12238m.checkNotNullExpressionValue(c12721k5, "permissionsObservable");
                        Observable<UserProfile> observableObserveUserProfile2 = storeUserProfile.observeUserProfile(user.getId());
                        Observable<Integer> observableObserve4 = storeUserRelationships.observe(user.getId());
                        Observable<StoreUserNotes.UserNoteState> observableObserveUserNote2 = storeUserNotes.observeUserNote(user.getId());
                        C12238m.checkNotNullExpressionValue(c12721k6, "userStageRolesObservable");
                        C12238m.checkNotNullExpressionValue(c12721k7, "userStageRequestToSpeakStateObservable");
                        C12238m.checkNotNullExpressionValue(c12721k8, "myStageRolesObservable");
                        C12238m.checkNotNullExpressionValue(c12721k9, "canDisableCommunicationObservable");
                        return ObservableCombineLatestOverloadsKt.combineLatest(observable, c12721k3, c12721k10, c12721k11, voiceConfig2, observable2, c12721k4, c12721k5, forUser, observableObserveUserProfile2, observableObserve4, observableObserveUserNote2, c12721k6, c12721k7, c12721k8, c12721k9, new AnonymousClass2(user, meUser2, channel, selectedVoiceChannel));
                    }
                    meUser = me2;
                    channel = channel2;
                    c12721k6 = new C12721k<>(null);
                    if (selectedVoiceChannel != null) {
                        meUser2 = meUser;
                        c12721k7 = storeStageChannels.observeUserRequestToSpeakState(user.getId(), selectedVoiceChannel.getId());
                        if (c12721k7 == null) {
                        }
                        if (selectedVoiceChannel != null) {
                            c12721k8 = new C12721k<>(null);
                        } else {
                            c12721k8 = new C12721k<>(null);
                        }
                        if (lValueOf != null) {
                            lValueOf.longValue();
                            c12721k9 = GuildCommunicationDisabledGuildsFeatureFlag.INSTANCE.getINSTANCE().observeCanGuildAccessCommunicationDisabled(lValueOf.longValue());
                            if (c12721k9 == null) {
                                c12721k9 = new C12721k(Boolean.FALSE);
                            }
                        } else {
                            c12721k9 = new C12721k(Boolean.FALSE);
                        }
                        C12238m.checkNotNullExpressionValue(observable, "computedMembersObservable");
                        C12238m.checkNotNullExpressionValue(c12721k3, "guildRolesObservable");
                        C12238m.checkNotNullExpressionValue(c12721k10, "mySelectedVoiceChannelVoiceStatesObservable");
                        C12238m.checkNotNullExpressionValue(c12721k11, "currentChannelVoiceStatesObservable");
                        Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig3 = storeMediaSettings.getVoiceConfig();
                        C12238m.checkNotNullExpressionValue(c12721k4, "guildsObservable");
                        C12238m.checkNotNullExpressionValue(c12721k5, "permissionsObservable");
                        Observable<UserProfile> observableObserveUserProfile3 = storeUserProfile.observeUserProfile(user.getId());
                        Observable<Integer> observableObserve5 = storeUserRelationships.observe(user.getId());
                        Observable<StoreUserNotes.UserNoteState> observableObserveUserNote3 = storeUserNotes.observeUserNote(user.getId());
                        C12238m.checkNotNullExpressionValue(c12721k6, "userStageRolesObservable");
                        C12238m.checkNotNullExpressionValue(c12721k7, "userStageRequestToSpeakStateObservable");
                        C12238m.checkNotNullExpressionValue(c12721k8, "myStageRolesObservable");
                        C12238m.checkNotNullExpressionValue(c12721k9, "canDisableCommunicationObservable");
                        return ObservableCombineLatestOverloadsKt.combineLatest(observable, c12721k3, c12721k10, c12721k11, voiceConfig3, observable2, c12721k4, c12721k5, forUser, observableObserveUserProfile3, observableObserve5, observableObserveUserNote3, c12721k6, c12721k7, c12721k8, c12721k9, new AnonymousClass2(user, meUser2, channel, selectedVoiceChannel));
                    }
                    meUser2 = meUser;
                    c12721k7 = new C12721k(StageRequestToSpeakState.NONE);
                    if (selectedVoiceChannel != null) {
                        c12721k8 = new C12721k<>(null);
                    } else {
                        c12721k8 = new C12721k<>(null);
                    }
                    if (lValueOf != null) {
                        lValueOf.longValue();
                        c12721k9 = GuildCommunicationDisabledGuildsFeatureFlag.INSTANCE.getINSTANCE().observeCanGuildAccessCommunicationDisabled(lValueOf.longValue());
                        if (c12721k9 == null) {
                            c12721k9 = new C12721k(Boolean.FALSE);
                        }
                    } else {
                        c12721k9 = new C12721k(Boolean.FALSE);
                    }
                    C12238m.checkNotNullExpressionValue(observable, "computedMembersObservable");
                    C12238m.checkNotNullExpressionValue(c12721k3, "guildRolesObservable");
                    C12238m.checkNotNullExpressionValue(c12721k10, "mySelectedVoiceChannelVoiceStatesObservable");
                    C12238m.checkNotNullExpressionValue(c12721k11, "currentChannelVoiceStatesObservable");
                    Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig4 = storeMediaSettings.getVoiceConfig();
                    C12238m.checkNotNullExpressionValue(c12721k4, "guildsObservable");
                    C12238m.checkNotNullExpressionValue(c12721k5, "permissionsObservable");
                    Observable<UserProfile> observableObserveUserProfile4 = storeUserProfile.observeUserProfile(user.getId());
                    Observable<Integer> observableObserve6 = storeUserRelationships.observe(user.getId());
                    Observable<StoreUserNotes.UserNoteState> observableObserveUserNote4 = storeUserNotes.observeUserNote(user.getId());
                    C12238m.checkNotNullExpressionValue(c12721k6, "userStageRolesObservable");
                    C12238m.checkNotNullExpressionValue(c12721k7, "userStageRequestToSpeakStateObservable");
                    C12238m.checkNotNullExpressionValue(c12721k8, "myStageRolesObservable");
                    C12238m.checkNotNullExpressionValue(c12721k9, "canDisableCommunicationObservable");
                    return ObservableCombineLatestOverloadsKt.combineLatest(observable, c12721k3, c12721k10, c12721k11, voiceConfig4, observable2, c12721k4, c12721k5, forUser, observableObserveUserProfile4, observableObserve6, observableObserveUserNote4, c12721k6, c12721k7, c12721k8, c12721k9, new AnonymousClass2(user, meUser2, channel, selectedVoiceChannel));
                }
                observable = c12721k2;
                c12721k5 = new C12721k<>(null);
                Observable<StreamContext> forUser2 = streamContextService.getForUser(user.getId(), true);
                if (selectedVoiceChannel != null) {
                    meUser = me2;
                    channel = channel2;
                    c12721k6 = storeStageChannels.observeUserRoles(user.getId(), selectedVoiceChannel.getId());
                    if (c12721k6 == null) {
                    }
                    if (selectedVoiceChannel != null) {
                        meUser2 = meUser;
                        c12721k7 = storeStageChannels.observeUserRequestToSpeakState(user.getId(), selectedVoiceChannel.getId());
                        if (c12721k7 == null) {
                        }
                        if (selectedVoiceChannel != null) {
                            c12721k8 = new C12721k<>(null);
                        } else {
                            c12721k8 = new C12721k<>(null);
                        }
                        if (lValueOf != null) {
                            lValueOf.longValue();
                            c12721k9 = GuildCommunicationDisabledGuildsFeatureFlag.INSTANCE.getINSTANCE().observeCanGuildAccessCommunicationDisabled(lValueOf.longValue());
                            if (c12721k9 == null) {
                                c12721k9 = new C12721k(Boolean.FALSE);
                            }
                        } else {
                            c12721k9 = new C12721k(Boolean.FALSE);
                        }
                        C12238m.checkNotNullExpressionValue(observable, "computedMembersObservable");
                        C12238m.checkNotNullExpressionValue(c12721k3, "guildRolesObservable");
                        C12238m.checkNotNullExpressionValue(c12721k10, "mySelectedVoiceChannelVoiceStatesObservable");
                        C12238m.checkNotNullExpressionValue(c12721k11, "currentChannelVoiceStatesObservable");
                        Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig5 = storeMediaSettings.getVoiceConfig();
                        C12238m.checkNotNullExpressionValue(c12721k4, "guildsObservable");
                        C12238m.checkNotNullExpressionValue(c12721k5, "permissionsObservable");
                        Observable<UserProfile> observableObserveUserProfile5 = storeUserProfile.observeUserProfile(user.getId());
                        Observable<Integer> observableObserve7 = storeUserRelationships.observe(user.getId());
                        Observable<StoreUserNotes.UserNoteState> observableObserveUserNote5 = storeUserNotes.observeUserNote(user.getId());
                        C12238m.checkNotNullExpressionValue(c12721k6, "userStageRolesObservable");
                        C12238m.checkNotNullExpressionValue(c12721k7, "userStageRequestToSpeakStateObservable");
                        C12238m.checkNotNullExpressionValue(c12721k8, "myStageRolesObservable");
                        C12238m.checkNotNullExpressionValue(c12721k9, "canDisableCommunicationObservable");
                        return ObservableCombineLatestOverloadsKt.combineLatest(observable, c12721k3, c12721k10, c12721k11, voiceConfig5, observable2, c12721k4, c12721k5, forUser2, observableObserveUserProfile5, observableObserve7, observableObserveUserNote5, c12721k6, c12721k7, c12721k8, c12721k9, new AnonymousClass2(user, meUser2, channel, selectedVoiceChannel));
                    }
                    meUser2 = meUser;
                    c12721k7 = new C12721k(StageRequestToSpeakState.NONE);
                    if (selectedVoiceChannel != null) {
                        c12721k8 = new C12721k<>(null);
                    } else {
                        c12721k8 = new C12721k<>(null);
                    }
                    if (lValueOf != null) {
                        lValueOf.longValue();
                        c12721k9 = GuildCommunicationDisabledGuildsFeatureFlag.INSTANCE.getINSTANCE().observeCanGuildAccessCommunicationDisabled(lValueOf.longValue());
                        if (c12721k9 == null) {
                            c12721k9 = new C12721k(Boolean.FALSE);
                        }
                    } else {
                        c12721k9 = new C12721k(Boolean.FALSE);
                    }
                    C12238m.checkNotNullExpressionValue(observable, "computedMembersObservable");
                    C12238m.checkNotNullExpressionValue(c12721k3, "guildRolesObservable");
                    C12238m.checkNotNullExpressionValue(c12721k10, "mySelectedVoiceChannelVoiceStatesObservable");
                    C12238m.checkNotNullExpressionValue(c12721k11, "currentChannelVoiceStatesObservable");
                    Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig6 = storeMediaSettings.getVoiceConfig();
                    C12238m.checkNotNullExpressionValue(c12721k4, "guildsObservable");
                    C12238m.checkNotNullExpressionValue(c12721k5, "permissionsObservable");
                    Observable<UserProfile> observableObserveUserProfile6 = storeUserProfile.observeUserProfile(user.getId());
                    Observable<Integer> observableObserve8 = storeUserRelationships.observe(user.getId());
                    Observable<StoreUserNotes.UserNoteState> observableObserveUserNote6 = storeUserNotes.observeUserNote(user.getId());
                    C12238m.checkNotNullExpressionValue(c12721k6, "userStageRolesObservable");
                    C12238m.checkNotNullExpressionValue(c12721k7, "userStageRequestToSpeakStateObservable");
                    C12238m.checkNotNullExpressionValue(c12721k8, "myStageRolesObservable");
                    C12238m.checkNotNullExpressionValue(c12721k9, "canDisableCommunicationObservable");
                    return ObservableCombineLatestOverloadsKt.combineLatest(observable, c12721k3, c12721k10, c12721k11, voiceConfig6, observable2, c12721k4, c12721k5, forUser2, observableObserveUserProfile6, observableObserve8, observableObserveUserNote6, c12721k6, c12721k7, c12721k8, c12721k9, new AnonymousClass2(user, meUser2, channel, selectedVoiceChannel));
                }
                meUser = me2;
                channel = channel2;
                c12721k6 = new C12721k<>(null);
                if (selectedVoiceChannel != null) {
                    meUser2 = meUser;
                    c12721k7 = storeStageChannels.observeUserRequestToSpeakState(user.getId(), selectedVoiceChannel.getId());
                    if (c12721k7 == null) {
                    }
                    if (selectedVoiceChannel != null) {
                        c12721k8 = new C12721k<>(null);
                    } else {
                        c12721k8 = new C12721k<>(null);
                    }
                    if (lValueOf != null) {
                        lValueOf.longValue();
                        c12721k9 = GuildCommunicationDisabledGuildsFeatureFlag.INSTANCE.getINSTANCE().observeCanGuildAccessCommunicationDisabled(lValueOf.longValue());
                        if (c12721k9 == null) {
                            c12721k9 = new C12721k(Boolean.FALSE);
                        }
                    } else {
                        c12721k9 = new C12721k(Boolean.FALSE);
                    }
                    C12238m.checkNotNullExpressionValue(observable, "computedMembersObservable");
                    C12238m.checkNotNullExpressionValue(c12721k3, "guildRolesObservable");
                    C12238m.checkNotNullExpressionValue(c12721k10, "mySelectedVoiceChannelVoiceStatesObservable");
                    C12238m.checkNotNullExpressionValue(c12721k11, "currentChannelVoiceStatesObservable");
                    Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig7 = storeMediaSettings.getVoiceConfig();
                    C12238m.checkNotNullExpressionValue(c12721k4, "guildsObservable");
                    C12238m.checkNotNullExpressionValue(c12721k5, "permissionsObservable");
                    Observable<UserProfile> observableObserveUserProfile7 = storeUserProfile.observeUserProfile(user.getId());
                    Observable<Integer> observableObserve9 = storeUserRelationships.observe(user.getId());
                    Observable<StoreUserNotes.UserNoteState> observableObserveUserNote7 = storeUserNotes.observeUserNote(user.getId());
                    C12238m.checkNotNullExpressionValue(c12721k6, "userStageRolesObservable");
                    C12238m.checkNotNullExpressionValue(c12721k7, "userStageRequestToSpeakStateObservable");
                    C12238m.checkNotNullExpressionValue(c12721k8, "myStageRolesObservable");
                    C12238m.checkNotNullExpressionValue(c12721k9, "canDisableCommunicationObservable");
                    return ObservableCombineLatestOverloadsKt.combineLatest(observable, c12721k3, c12721k10, c12721k11, voiceConfig7, observable2, c12721k4, c12721k5, forUser2, observableObserveUserProfile7, observableObserve9, observableObserveUserNote7, c12721k6, c12721k7, c12721k8, c12721k9, new AnonymousClass2(user, meUser2, channel, selectedVoiceChannel));
                }
                meUser2 = meUser;
                c12721k7 = new C12721k(StageRequestToSpeakState.NONE);
                if (selectedVoiceChannel != null) {
                    c12721k8 = new C12721k<>(null);
                } else {
                    c12721k8 = new C12721k<>(null);
                }
                if (lValueOf != null) {
                    lValueOf.longValue();
                    c12721k9 = GuildCommunicationDisabledGuildsFeatureFlag.INSTANCE.getINSTANCE().observeCanGuildAccessCommunicationDisabled(lValueOf.longValue());
                    if (c12721k9 == null) {
                        c12721k9 = new C12721k(Boolean.FALSE);
                    }
                } else {
                    c12721k9 = new C12721k(Boolean.FALSE);
                }
                C12238m.checkNotNullExpressionValue(observable, "computedMembersObservable");
                C12238m.checkNotNullExpressionValue(c12721k3, "guildRolesObservable");
                C12238m.checkNotNullExpressionValue(c12721k10, "mySelectedVoiceChannelVoiceStatesObservable");
                C12238m.checkNotNullExpressionValue(c12721k11, "currentChannelVoiceStatesObservable");
                Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig8 = storeMediaSettings.getVoiceConfig();
                C12238m.checkNotNullExpressionValue(c12721k4, "guildsObservable");
                C12238m.checkNotNullExpressionValue(c12721k5, "permissionsObservable");
                Observable<UserProfile> observableObserveUserProfile8 = storeUserProfile.observeUserProfile(user.getId());
                Observable<Integer> observableObserve10 = storeUserRelationships.observe(user.getId());
                Observable<StoreUserNotes.UserNoteState> observableObserveUserNote8 = storeUserNotes.observeUserNote(user.getId());
                C12238m.checkNotNullExpressionValue(c12721k6, "userStageRolesObservable");
                C12238m.checkNotNullExpressionValue(c12721k7, "userStageRequestToSpeakStateObservable");
                C12238m.checkNotNullExpressionValue(c12721k8, "myStageRolesObservable");
                C12238m.checkNotNullExpressionValue(c12721k9, "canDisableCommunicationObservable");
                return ObservableCombineLatestOverloadsKt.combineLatest(observable, c12721k3, c12721k10, c12721k11, voiceConfig8, observable2, c12721k4, c12721k5, forUser2, observableObserveUserProfile8, observableObserve10, observableObserveUserNote8, c12721k6, c12721k7, c12721k8, c12721k9, new AnonymousClass2(user, meUser2, channel, selectedVoiceChannel));
            }
        }).f27640j, new LeadingEdgeThrottle(250L, TimeUnit.MILLISECONDS, storeStateRxScheduler))).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "Observable\n          .co…  .distinctUntilChanged()");
        return observableM11112r;
    }
}
