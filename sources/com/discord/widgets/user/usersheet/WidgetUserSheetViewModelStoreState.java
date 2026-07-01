package com.discord.widgets.user.usersheet;

import b.d.b.a.outline;
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
import com.discord.utilities.rx.LeadingEdgeThrottle;
import com.discord.utilities.rx.ObservableCombineLatestOverloads2;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContextService;
import com.discord.widgets.guildcommunicationdisabled.start.GuildCommunicationDisabledGuildsFeatureFlag;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.user.presence.ModelRichPresence;
import com.discord.widgets.user.usersheet.WidgetUserSheetViewModel;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.a.OnSubscribeLift;
import j0.l.e.ScalarSynchronousObservable;
import j0.p.Schedulers2;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function4;
import rx.Observable;
import rx.Scheduler;
import rx.functions.Func4;

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
            Intrinsics3.checkNotNullParameter(meUser, "me");
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
            Intrinsics3.checkNotNullParameter(me2, "me");
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
            return Intrinsics3.areEqual(this.user, bootstrapData.user) && Intrinsics3.areEqual(this.me, bootstrapData.me) && Intrinsics3.areEqual(this.channel, bootstrapData.channel) && Intrinsics3.areEqual(this.selectedVoiceChannel, bootstrapData.selectedVoiceChannel);
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
            StringBuilder sbU = outline.U("BootstrapData(user=");
            sbU.append(this.user);
            sbU.append(", me=");
            sbU.append(this.me);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", selectedVoiceChannel=");
            sbU.append(this.selectedVoiceChannel);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModelStoreState$observeStoreState$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserSheetViewModelStoreState.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function4<User, MeUser, Channel, Channel, BootstrapData> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(4, BootstrapData.class, "<init>", "<init>(Lcom/discord/models/user/User;Lcom/discord/models/user/MeUser;Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function4
        public final BootstrapData invoke(User user, MeUser meUser, Channel channel, Channel channel2) {
            Intrinsics3.checkNotNullParameter(meUser, "p2");
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
            Scheduler schedulerA = Schedulers2.a();
            Intrinsics3.checkNotNullExpressionValue(schedulerA, "Schedulers.computation()");
            scheduler2 = schedulerA;
        } else {
            scheduler2 = scheduler;
        }
        return widgetUserSheetViewModelStoreState.observeStoreState(j, l, l2, users, channels, voiceChannelSelected, userProfile, userRelationships, voiceStates, guilds, mediaSettings, presences, permissions, usersNotes, stageChannels, streamContextService2, scheduler2);
    }

    public final Observable<WidgetUserSheetViewModel.StoreState> observeStoreState(long userId, Long channelId, final Long guildId, StoreUser storeUser, StoreChannels storeChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, final StoreUserProfile storeUserProfile, final StoreUserRelationships storeUserRelationships, final StoreVoiceStates storeVoiceStates, final StoreGuilds storeGuilds, final StoreMediaSettings storeMediaSettings, final StoreUserPresence storeUserPresence, final StorePermissions storePermissions, final StoreUserNotes storeUserNotes, final StoreStageChannels storeStageChannels, final StreamContextService streamContextService, Scheduler storeStateRxScheduler) {
        Observable<Channel> scalarSynchronousObservable;
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "storeVoiceChannelSelected");
        Intrinsics3.checkNotNullParameter(storeUserProfile, "storeUserProfile");
        Intrinsics3.checkNotNullParameter(storeUserRelationships, "storeUserRelationships");
        Intrinsics3.checkNotNullParameter(storeVoiceStates, "storeVoiceStates");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storeMediaSettings, "storeMediaSettings");
        Intrinsics3.checkNotNullParameter(storeUserPresence, "storeUserPresence");
        Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
        Intrinsics3.checkNotNullParameter(storeUserNotes, "storeUserNotes");
        Intrinsics3.checkNotNullParameter(storeStageChannels, "storeStageChannels");
        Intrinsics3.checkNotNullParameter(streamContextService, "streamContextService");
        Intrinsics3.checkNotNullParameter(storeStateRxScheduler, "storeStateRxScheduler");
        Observable<User> observableObserveUser = storeUser.observeUser(userId);
        Observable observableObserveMe$default = StoreUser.observeMe$default(storeUser, false, 1, null);
        if (channelId == null || (scalarSynchronousObservable = storeChannels.observeChannel(channelId.longValue())) == null) {
            scalarSynchronousObservable = new ScalarSynchronousObservable<>(null);
        }
        Observable<Channel> observableObserveSelectedChannel = storeVoiceChannelSelected.observeSelectedChannel();
        final AnonymousClass2 anonymousClass2 = AnonymousClass2.INSTANCE;
        Object obj = anonymousClass2;
        if (anonymousClass2 != null) {
            obj = new Func4() { // from class: com.discord.widgets.user.usersheet.WidgetUserSheetViewModelStoreState$sam$rx_functions_Func4$0
                @Override // rx.functions.Func4
                public final /* synthetic */ Object call(Object obj2, Object obj3, Object obj4, Object obj5) {
                    return anonymousClass2.invoke(obj2, obj3, obj4, obj5);
                }
            };
        }
        Observable<WidgetUserSheetViewModel.StoreState> observableR = Observable.h0(new OnSubscribeLift(Observable.h(observableObserveUser, observableObserveMe$default, scalarSynchronousObservable, observableObserveSelectedChannel, (Func4) obj).Y(new Func1<BootstrapData, Observable<? extends WidgetUserSheetViewModel.StoreState>>() { // from class: com.discord.widgets.user.usersheet.WidgetUserSheetViewModelStoreState.observeStoreState.3

            /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModelStoreState$observeStoreState$3$2, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetUserSheetViewModelStoreState.kt */
            public static final class AnonymousClass2 extends Lambda implements Function16<Map<Long, ? extends GuildMember>, Map<Long, ? extends GuildRole>, Map<Long, ? extends VoiceState>, Map<Long, ? extends VoiceState>, StoreMediaSettings.VoiceConfiguration, ModelRichPresence, Guild, Long, StreamContext, UserProfile, Integer, StoreUserNotes.UserNoteState, StageRoles, StageRequestToSpeakState, StageRoles, Boolean, WidgetUserSheetViewModel.StoreState> {
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
                    Intrinsics3.checkNotNullParameter(map, "computedMembers");
                    Intrinsics3.checkNotNullParameter(map2, "guildRoles");
                    Intrinsics3.checkNotNullParameter(map3, "mySelectedVoiceChannelVoiceStates");
                    Intrinsics3.checkNotNullParameter(map4, "currentChannelVoiceStates");
                    Intrinsics3.checkNotNullParameter(voiceConfiguration, "voiceConfig");
                    Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
                    Intrinsics3.checkNotNullParameter(userNoteState, "userNote");
                    Intrinsics3.checkNotNullParameter(stageRequestToSpeakState, "userRequestToSpeakState");
                    Boolean bool = (Boolean) outline.f(this.$user, voiceConfiguration.getMutedUsers());
                    boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
                    boolean zIsSelfMuted = voiceConfiguration.isSelfMuted();
                    boolean zIsSelfDeafened = voiceConfiguration.isSelfDeafened();
                    Float f = (Float) outline.f(this.$user, voiceConfiguration.getUserOutputVolumes());
                    float fFloatValue = f != null ? f.floatValue() : 100.0f;
                    User user = this.$user;
                    MeUser meUser = this.$me;
                    Channel channel = this.$channel;
                    Channel channel2 = this.$selectedVoiceChannel;
                    return new WidgetUserSheetViewModel.StoreState(user, meUser, channel, map, map2, map3, map4, zBooleanValue, zIsSelfMuted, zIsSelfDeafened, fFloatValue, modelRichPresence, guild, l, streamContext, userProfile, num, userNoteState, (channel2 == null || !ChannelUtils.D(channel2)) ? null : channel2, stageRoles, stageRequestToSpeakState, stageRoles2, z2, null);
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
            @Override // j0.k.Func1
            public final Observable<? extends WidgetUserSheetViewModel.StoreState> call(BootstrapData bootstrapData) {
                Observable<Map<Long, GuildMember>> scalarSynchronousObservable2;
                Observable<Map<Long, GuildRole>> scalarSynchronousObservable3;
                Observable<Guild> scalarSynchronousObservable4;
                Observable<Map<Long, GuildMember>> observable;
                Observable<Long> scalarSynchronousObservable5;
                MeUser meUser;
                Channel channel;
                Observable<StageRoles> scalarSynchronousObservable6;
                MeUser meUser2;
                Observable<StageRequestToSpeakState> scalarSynchronousObservable7;
                Observable<StageRoles> scalarSynchronousObservable8;
                Observable<Boolean> scalarSynchronousObservable9;
                Observable<Map<Long, VoiceState>> observableObserve;
                Observable<Map<Long, VoiceState>> observableObserve2;
                User user = bootstrapData.getUser();
                MeUser me2 = bootstrapData.getMe();
                Channel channel2 = bootstrapData.getChannel();
                Channel selectedVoiceChannel = bootstrapData.getSelectedVoiceChannel();
                if (user == null) {
                    return Observable.d0(5L, TimeUnit.SECONDS).G(new Func1() { // from class: com.discord.widgets.user.usersheet.WidgetUserSheetViewModelStoreState.observeStoreState.3.1
                        @Override // j0.k.Func1
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
                    Observable<Map<Long, GuildMember>> observableObserveComputed = storeGuilds.observeComputed(lValueOf.longValue(), Collections2.listOf((Object[]) new Long[]{Long.valueOf(user.getId()), Long.valueOf(me2.getId())}));
                    if (observableObserveComputed != null) {
                        scalarSynchronousObservable2 = observableObserveComputed;
                    } else {
                        scalarSynchronousObservable2 = new ScalarSynchronousObservable(Maps6.emptyMap());
                    }
                } else {
                    scalarSynchronousObservable2 = new ScalarSynchronousObservable(Maps6.emptyMap());
                }
                if (lValueOf != null) {
                    lValueOf.longValue();
                    Observable<Map<Long, GuildRole>> observableObserveRoles = storeGuilds.observeRoles(lValueOf.longValue());
                    if (observableObserveRoles != null) {
                        scalarSynchronousObservable3 = observableObserveRoles;
                    } else {
                        scalarSynchronousObservable3 = new ScalarSynchronousObservable(Maps6.emptyMap());
                    }
                } else {
                    scalarSynchronousObservable3 = new ScalarSynchronousObservable(Maps6.emptyMap());
                }
                Observable<Map<Long, VoiceState>> scalarSynchronousObservable10 = (selectedVoiceChannel == null || (observableObserve2 = storeVoiceStates.observe(selectedVoiceChannel.getGuildId(), selectedVoiceChannel.getId())) == null) ? new ScalarSynchronousObservable(Maps6.emptyMap()) : observableObserve2;
                Observable<Map<Long, VoiceState>> scalarSynchronousObservable11 = (channel2 == null || (observableObserve = storeVoiceStates.observe(channel2.getGuildId(), channel2.getId())) == null) ? new ScalarSynchronousObservable(Maps6.emptyMap()) : observableObserve;
                Observable<ModelRichPresence> observable2 = ModelRichPresence.INSTANCE.get(user.getId(), storeUserPresence);
                if (lValueOf != null) {
                    lValueOf.longValue();
                    scalarSynchronousObservable4 = storeGuilds.observeGuild(lValueOf.longValue());
                    if (scalarSynchronousObservable4 == null) {
                        scalarSynchronousObservable4 = new ScalarSynchronousObservable<>(null);
                    }
                } else {
                    scalarSynchronousObservable4 = new ScalarSynchronousObservable<>(null);
                }
                if (channel2 != null) {
                    observable = scalarSynchronousObservable2;
                    scalarSynchronousObservable5 = storePermissions.observePermissionsForChannel(channel2.getId());
                    if (scalarSynchronousObservable5 == null) {
                    }
                    Observable<StreamContext> forUser = streamContextService.getForUser(user.getId(), true);
                    if (selectedVoiceChannel != null) {
                        meUser = me2;
                        channel = channel2;
                        scalarSynchronousObservable6 = storeStageChannels.observeUserRoles(user.getId(), selectedVoiceChannel.getId());
                        if (scalarSynchronousObservable6 == null) {
                        }
                        if (selectedVoiceChannel != null) {
                            meUser2 = meUser;
                            scalarSynchronousObservable7 = storeStageChannels.observeUserRequestToSpeakState(user.getId(), selectedVoiceChannel.getId());
                            if (scalarSynchronousObservable7 == null) {
                            }
                            if (selectedVoiceChannel != null || (scalarSynchronousObservable8 = storeStageChannels.observeMyRoles(selectedVoiceChannel.getId())) == null) {
                                scalarSynchronousObservable8 = new ScalarSynchronousObservable<>(null);
                            }
                            if (lValueOf != null) {
                                lValueOf.longValue();
                                scalarSynchronousObservable9 = GuildCommunicationDisabledGuildsFeatureFlag.INSTANCE.getINSTANCE().observeCanGuildAccessCommunicationDisabled(lValueOf.longValue());
                                if (scalarSynchronousObservable9 == null) {
                                    scalarSynchronousObservable9 = new ScalarSynchronousObservable(Boolean.FALSE);
                                }
                            } else {
                                scalarSynchronousObservable9 = new ScalarSynchronousObservable(Boolean.FALSE);
                            }
                            Intrinsics3.checkNotNullExpressionValue(observable, "computedMembersObservable");
                            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable3, "guildRolesObservable");
                            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable10, "mySelectedVoiceChannelVoiceStatesObservable");
                            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable11, "currentChannelVoiceStatesObservable");
                            Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig = storeMediaSettings.getVoiceConfig();
                            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable4, "guildsObservable");
                            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable5, "permissionsObservable");
                            Observable<UserProfile> observableObserveUserProfile = storeUserProfile.observeUserProfile(user.getId());
                            Observable<Integer> observableObserve3 = storeUserRelationships.observe(user.getId());
                            Observable<StoreUserNotes.UserNoteState> observableObserveUserNote = storeUserNotes.observeUserNote(user.getId());
                            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable6, "userStageRolesObservable");
                            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable7, "userStageRequestToSpeakStateObservable");
                            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable8, "myStageRolesObservable");
                            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable9, "canDisableCommunicationObservable");
                            return ObservableCombineLatestOverloads2.combineLatest(observable, scalarSynchronousObservable3, scalarSynchronousObservable10, scalarSynchronousObservable11, voiceConfig, observable2, scalarSynchronousObservable4, scalarSynchronousObservable5, forUser, observableObserveUserProfile, observableObserve3, observableObserveUserNote, scalarSynchronousObservable6, scalarSynchronousObservable7, scalarSynchronousObservable8, scalarSynchronousObservable9, new AnonymousClass2(user, meUser2, channel, selectedVoiceChannel));
                        }
                        meUser2 = meUser;
                        scalarSynchronousObservable7 = new ScalarSynchronousObservable(StageRequestToSpeakState.NONE);
                        if (selectedVoiceChannel != null) {
                            scalarSynchronousObservable8 = new ScalarSynchronousObservable<>(null);
                        } else {
                            scalarSynchronousObservable8 = new ScalarSynchronousObservable<>(null);
                        }
                        if (lValueOf != null) {
                            lValueOf.longValue();
                            scalarSynchronousObservable9 = GuildCommunicationDisabledGuildsFeatureFlag.INSTANCE.getINSTANCE().observeCanGuildAccessCommunicationDisabled(lValueOf.longValue());
                            if (scalarSynchronousObservable9 == null) {
                                scalarSynchronousObservable9 = new ScalarSynchronousObservable(Boolean.FALSE);
                            }
                        } else {
                            scalarSynchronousObservable9 = new ScalarSynchronousObservable(Boolean.FALSE);
                        }
                        Intrinsics3.checkNotNullExpressionValue(observable, "computedMembersObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable3, "guildRolesObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable10, "mySelectedVoiceChannelVoiceStatesObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable11, "currentChannelVoiceStatesObservable");
                        Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig2 = storeMediaSettings.getVoiceConfig();
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable4, "guildsObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable5, "permissionsObservable");
                        Observable<UserProfile> observableObserveUserProfile2 = storeUserProfile.observeUserProfile(user.getId());
                        Observable<Integer> observableObserve4 = storeUserRelationships.observe(user.getId());
                        Observable<StoreUserNotes.UserNoteState> observableObserveUserNote2 = storeUserNotes.observeUserNote(user.getId());
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable6, "userStageRolesObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable7, "userStageRequestToSpeakStateObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable8, "myStageRolesObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable9, "canDisableCommunicationObservable");
                        return ObservableCombineLatestOverloads2.combineLatest(observable, scalarSynchronousObservable3, scalarSynchronousObservable10, scalarSynchronousObservable11, voiceConfig2, observable2, scalarSynchronousObservable4, scalarSynchronousObservable5, forUser, observableObserveUserProfile2, observableObserve4, observableObserveUserNote2, scalarSynchronousObservable6, scalarSynchronousObservable7, scalarSynchronousObservable8, scalarSynchronousObservable9, new AnonymousClass2(user, meUser2, channel, selectedVoiceChannel));
                    }
                    meUser = me2;
                    channel = channel2;
                    scalarSynchronousObservable6 = new ScalarSynchronousObservable<>(null);
                    if (selectedVoiceChannel != null) {
                        meUser2 = meUser;
                        scalarSynchronousObservable7 = storeStageChannels.observeUserRequestToSpeakState(user.getId(), selectedVoiceChannel.getId());
                        if (scalarSynchronousObservable7 == null) {
                        }
                        if (selectedVoiceChannel != null) {
                            scalarSynchronousObservable8 = new ScalarSynchronousObservable<>(null);
                        } else {
                            scalarSynchronousObservable8 = new ScalarSynchronousObservable<>(null);
                        }
                        if (lValueOf != null) {
                            lValueOf.longValue();
                            scalarSynchronousObservable9 = GuildCommunicationDisabledGuildsFeatureFlag.INSTANCE.getINSTANCE().observeCanGuildAccessCommunicationDisabled(lValueOf.longValue());
                            if (scalarSynchronousObservable9 == null) {
                                scalarSynchronousObservable9 = new ScalarSynchronousObservable(Boolean.FALSE);
                            }
                        } else {
                            scalarSynchronousObservable9 = new ScalarSynchronousObservable(Boolean.FALSE);
                        }
                        Intrinsics3.checkNotNullExpressionValue(observable, "computedMembersObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable3, "guildRolesObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable10, "mySelectedVoiceChannelVoiceStatesObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable11, "currentChannelVoiceStatesObservable");
                        Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig3 = storeMediaSettings.getVoiceConfig();
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable4, "guildsObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable5, "permissionsObservable");
                        Observable<UserProfile> observableObserveUserProfile3 = storeUserProfile.observeUserProfile(user.getId());
                        Observable<Integer> observableObserve5 = storeUserRelationships.observe(user.getId());
                        Observable<StoreUserNotes.UserNoteState> observableObserveUserNote3 = storeUserNotes.observeUserNote(user.getId());
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable6, "userStageRolesObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable7, "userStageRequestToSpeakStateObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable8, "myStageRolesObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable9, "canDisableCommunicationObservable");
                        return ObservableCombineLatestOverloads2.combineLatest(observable, scalarSynchronousObservable3, scalarSynchronousObservable10, scalarSynchronousObservable11, voiceConfig3, observable2, scalarSynchronousObservable4, scalarSynchronousObservable5, forUser, observableObserveUserProfile3, observableObserve5, observableObserveUserNote3, scalarSynchronousObservable6, scalarSynchronousObservable7, scalarSynchronousObservable8, scalarSynchronousObservable9, new AnonymousClass2(user, meUser2, channel, selectedVoiceChannel));
                    }
                    meUser2 = meUser;
                    scalarSynchronousObservable7 = new ScalarSynchronousObservable(StageRequestToSpeakState.NONE);
                    if (selectedVoiceChannel != null) {
                        scalarSynchronousObservable8 = new ScalarSynchronousObservable<>(null);
                    } else {
                        scalarSynchronousObservable8 = new ScalarSynchronousObservable<>(null);
                    }
                    if (lValueOf != null) {
                        lValueOf.longValue();
                        scalarSynchronousObservable9 = GuildCommunicationDisabledGuildsFeatureFlag.INSTANCE.getINSTANCE().observeCanGuildAccessCommunicationDisabled(lValueOf.longValue());
                        if (scalarSynchronousObservable9 == null) {
                            scalarSynchronousObservable9 = new ScalarSynchronousObservable(Boolean.FALSE);
                        }
                    } else {
                        scalarSynchronousObservable9 = new ScalarSynchronousObservable(Boolean.FALSE);
                    }
                    Intrinsics3.checkNotNullExpressionValue(observable, "computedMembersObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable3, "guildRolesObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable10, "mySelectedVoiceChannelVoiceStatesObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable11, "currentChannelVoiceStatesObservable");
                    Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig4 = storeMediaSettings.getVoiceConfig();
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable4, "guildsObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable5, "permissionsObservable");
                    Observable<UserProfile> observableObserveUserProfile4 = storeUserProfile.observeUserProfile(user.getId());
                    Observable<Integer> observableObserve6 = storeUserRelationships.observe(user.getId());
                    Observable<StoreUserNotes.UserNoteState> observableObserveUserNote4 = storeUserNotes.observeUserNote(user.getId());
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable6, "userStageRolesObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable7, "userStageRequestToSpeakStateObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable8, "myStageRolesObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable9, "canDisableCommunicationObservable");
                    return ObservableCombineLatestOverloads2.combineLatest(observable, scalarSynchronousObservable3, scalarSynchronousObservable10, scalarSynchronousObservable11, voiceConfig4, observable2, scalarSynchronousObservable4, scalarSynchronousObservable5, forUser, observableObserveUserProfile4, observableObserve6, observableObserveUserNote4, scalarSynchronousObservable6, scalarSynchronousObservable7, scalarSynchronousObservable8, scalarSynchronousObservable9, new AnonymousClass2(user, meUser2, channel, selectedVoiceChannel));
                }
                observable = scalarSynchronousObservable2;
                scalarSynchronousObservable5 = new ScalarSynchronousObservable<>(null);
                Observable<StreamContext> forUser2 = streamContextService.getForUser(user.getId(), true);
                if (selectedVoiceChannel != null) {
                    meUser = me2;
                    channel = channel2;
                    scalarSynchronousObservable6 = storeStageChannels.observeUserRoles(user.getId(), selectedVoiceChannel.getId());
                    if (scalarSynchronousObservable6 == null) {
                    }
                    if (selectedVoiceChannel != null) {
                        meUser2 = meUser;
                        scalarSynchronousObservable7 = storeStageChannels.observeUserRequestToSpeakState(user.getId(), selectedVoiceChannel.getId());
                        if (scalarSynchronousObservable7 == null) {
                        }
                        if (selectedVoiceChannel != null) {
                            scalarSynchronousObservable8 = new ScalarSynchronousObservable<>(null);
                        } else {
                            scalarSynchronousObservable8 = new ScalarSynchronousObservable<>(null);
                        }
                        if (lValueOf != null) {
                            lValueOf.longValue();
                            scalarSynchronousObservable9 = GuildCommunicationDisabledGuildsFeatureFlag.INSTANCE.getINSTANCE().observeCanGuildAccessCommunicationDisabled(lValueOf.longValue());
                            if (scalarSynchronousObservable9 == null) {
                                scalarSynchronousObservable9 = new ScalarSynchronousObservable(Boolean.FALSE);
                            }
                        } else {
                            scalarSynchronousObservable9 = new ScalarSynchronousObservable(Boolean.FALSE);
                        }
                        Intrinsics3.checkNotNullExpressionValue(observable, "computedMembersObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable3, "guildRolesObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable10, "mySelectedVoiceChannelVoiceStatesObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable11, "currentChannelVoiceStatesObservable");
                        Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig5 = storeMediaSettings.getVoiceConfig();
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable4, "guildsObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable5, "permissionsObservable");
                        Observable<UserProfile> observableObserveUserProfile5 = storeUserProfile.observeUserProfile(user.getId());
                        Observable<Integer> observableObserve7 = storeUserRelationships.observe(user.getId());
                        Observable<StoreUserNotes.UserNoteState> observableObserveUserNote5 = storeUserNotes.observeUserNote(user.getId());
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable6, "userStageRolesObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable7, "userStageRequestToSpeakStateObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable8, "myStageRolesObservable");
                        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable9, "canDisableCommunicationObservable");
                        return ObservableCombineLatestOverloads2.combineLatest(observable, scalarSynchronousObservable3, scalarSynchronousObservable10, scalarSynchronousObservable11, voiceConfig5, observable2, scalarSynchronousObservable4, scalarSynchronousObservable5, forUser2, observableObserveUserProfile5, observableObserve7, observableObserveUserNote5, scalarSynchronousObservable6, scalarSynchronousObservable7, scalarSynchronousObservable8, scalarSynchronousObservable9, new AnonymousClass2(user, meUser2, channel, selectedVoiceChannel));
                    }
                    meUser2 = meUser;
                    scalarSynchronousObservable7 = new ScalarSynchronousObservable(StageRequestToSpeakState.NONE);
                    if (selectedVoiceChannel != null) {
                        scalarSynchronousObservable8 = new ScalarSynchronousObservable<>(null);
                    } else {
                        scalarSynchronousObservable8 = new ScalarSynchronousObservable<>(null);
                    }
                    if (lValueOf != null) {
                        lValueOf.longValue();
                        scalarSynchronousObservable9 = GuildCommunicationDisabledGuildsFeatureFlag.INSTANCE.getINSTANCE().observeCanGuildAccessCommunicationDisabled(lValueOf.longValue());
                        if (scalarSynchronousObservable9 == null) {
                            scalarSynchronousObservable9 = new ScalarSynchronousObservable(Boolean.FALSE);
                        }
                    } else {
                        scalarSynchronousObservable9 = new ScalarSynchronousObservable(Boolean.FALSE);
                    }
                    Intrinsics3.checkNotNullExpressionValue(observable, "computedMembersObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable3, "guildRolesObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable10, "mySelectedVoiceChannelVoiceStatesObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable11, "currentChannelVoiceStatesObservable");
                    Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig6 = storeMediaSettings.getVoiceConfig();
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable4, "guildsObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable5, "permissionsObservable");
                    Observable<UserProfile> observableObserveUserProfile6 = storeUserProfile.observeUserProfile(user.getId());
                    Observable<Integer> observableObserve8 = storeUserRelationships.observe(user.getId());
                    Observable<StoreUserNotes.UserNoteState> observableObserveUserNote6 = storeUserNotes.observeUserNote(user.getId());
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable6, "userStageRolesObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable7, "userStageRequestToSpeakStateObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable8, "myStageRolesObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable9, "canDisableCommunicationObservable");
                    return ObservableCombineLatestOverloads2.combineLatest(observable, scalarSynchronousObservable3, scalarSynchronousObservable10, scalarSynchronousObservable11, voiceConfig6, observable2, scalarSynchronousObservable4, scalarSynchronousObservable5, forUser2, observableObserveUserProfile6, observableObserve8, observableObserveUserNote6, scalarSynchronousObservable6, scalarSynchronousObservable7, scalarSynchronousObservable8, scalarSynchronousObservable9, new AnonymousClass2(user, meUser2, channel, selectedVoiceChannel));
                }
                meUser = me2;
                channel = channel2;
                scalarSynchronousObservable6 = new ScalarSynchronousObservable<>(null);
                if (selectedVoiceChannel != null) {
                    meUser2 = meUser;
                    scalarSynchronousObservable7 = storeStageChannels.observeUserRequestToSpeakState(user.getId(), selectedVoiceChannel.getId());
                    if (scalarSynchronousObservable7 == null) {
                    }
                    if (selectedVoiceChannel != null) {
                        scalarSynchronousObservable8 = new ScalarSynchronousObservable<>(null);
                    } else {
                        scalarSynchronousObservable8 = new ScalarSynchronousObservable<>(null);
                    }
                    if (lValueOf != null) {
                        lValueOf.longValue();
                        scalarSynchronousObservable9 = GuildCommunicationDisabledGuildsFeatureFlag.INSTANCE.getINSTANCE().observeCanGuildAccessCommunicationDisabled(lValueOf.longValue());
                        if (scalarSynchronousObservable9 == null) {
                            scalarSynchronousObservable9 = new ScalarSynchronousObservable(Boolean.FALSE);
                        }
                    } else {
                        scalarSynchronousObservable9 = new ScalarSynchronousObservable(Boolean.FALSE);
                    }
                    Intrinsics3.checkNotNullExpressionValue(observable, "computedMembersObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable3, "guildRolesObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable10, "mySelectedVoiceChannelVoiceStatesObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable11, "currentChannelVoiceStatesObservable");
                    Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig7 = storeMediaSettings.getVoiceConfig();
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable4, "guildsObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable5, "permissionsObservable");
                    Observable<UserProfile> observableObserveUserProfile7 = storeUserProfile.observeUserProfile(user.getId());
                    Observable<Integer> observableObserve9 = storeUserRelationships.observe(user.getId());
                    Observable<StoreUserNotes.UserNoteState> observableObserveUserNote7 = storeUserNotes.observeUserNote(user.getId());
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable6, "userStageRolesObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable7, "userStageRequestToSpeakStateObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable8, "myStageRolesObservable");
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable9, "canDisableCommunicationObservable");
                    return ObservableCombineLatestOverloads2.combineLatest(observable, scalarSynchronousObservable3, scalarSynchronousObservable10, scalarSynchronousObservable11, voiceConfig7, observable2, scalarSynchronousObservable4, scalarSynchronousObservable5, forUser2, observableObserveUserProfile7, observableObserve9, observableObserveUserNote7, scalarSynchronousObservable6, scalarSynchronousObservable7, scalarSynchronousObservable8, scalarSynchronousObservable9, new AnonymousClass2(user, meUser2, channel, selectedVoiceChannel));
                }
                meUser2 = meUser;
                scalarSynchronousObservable7 = new ScalarSynchronousObservable(StageRequestToSpeakState.NONE);
                if (selectedVoiceChannel != null) {
                    scalarSynchronousObservable8 = new ScalarSynchronousObservable<>(null);
                } else {
                    scalarSynchronousObservable8 = new ScalarSynchronousObservable<>(null);
                }
                if (lValueOf != null) {
                    lValueOf.longValue();
                    scalarSynchronousObservable9 = GuildCommunicationDisabledGuildsFeatureFlag.INSTANCE.getINSTANCE().observeCanGuildAccessCommunicationDisabled(lValueOf.longValue());
                    if (scalarSynchronousObservable9 == null) {
                        scalarSynchronousObservable9 = new ScalarSynchronousObservable(Boolean.FALSE);
                    }
                } else {
                    scalarSynchronousObservable9 = new ScalarSynchronousObservable(Boolean.FALSE);
                }
                Intrinsics3.checkNotNullExpressionValue(observable, "computedMembersObservable");
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable3, "guildRolesObservable");
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable10, "mySelectedVoiceChannelVoiceStatesObservable");
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable11, "currentChannelVoiceStatesObservable");
                Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig8 = storeMediaSettings.getVoiceConfig();
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable4, "guildsObservable");
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable5, "permissionsObservable");
                Observable<UserProfile> observableObserveUserProfile8 = storeUserProfile.observeUserProfile(user.getId());
                Observable<Integer> observableObserve10 = storeUserRelationships.observe(user.getId());
                Observable<StoreUserNotes.UserNoteState> observableObserveUserNote8 = storeUserNotes.observeUserNote(user.getId());
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable6, "userStageRolesObservable");
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable7, "userStageRequestToSpeakStateObservable");
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable8, "myStageRolesObservable");
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable9, "canDisableCommunicationObservable");
                return ObservableCombineLatestOverloads2.combineLatest(observable, scalarSynchronousObservable3, scalarSynchronousObservable10, scalarSynchronousObservable11, voiceConfig8, observable2, scalarSynchronousObservable4, scalarSynchronousObservable5, forUser2, observableObserveUserProfile8, observableObserve10, observableObserveUserNote8, scalarSynchronousObservable6, scalarSynchronousObservable7, scalarSynchronousObservable8, scalarSynchronousObservable9, new AnonymousClass2(user, meUser2, channel, selectedVoiceChannel));
            }
        }).j, new LeadingEdgeThrottle(250L, TimeUnit.MILLISECONDS, storeStateRxScheduler))).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n          .co…  .distinctUntilChanged()");
        return observableR;
    }
}
