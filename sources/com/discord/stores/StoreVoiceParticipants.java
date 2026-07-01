package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelCall;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVideoStreams;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContextService;
import d0.Tuples;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.functions.Func7;
import rx.functions.FuncN;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: StoreVoiceParticipants.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreVoiceParticipants extends Store {
    private final BehaviorSubject<Long> selectedParticipantSubject;
    private final StoreStream stream;

    /* JADX INFO: compiled from: StoreVoiceParticipants.kt */
    public static final /* data */ class VoiceUser {
        private final boolean _isSpeaking;
        private final ModelApplicationStream applicationStream;
        private final Integer applicationStreamId;
        private final Integer callStreamId;
        private final GuildMember guildMember;
        private final boolean isBooster;
        private final boolean isDeafened;
        private final boolean isInvitedToSpeak;
        private final boolean isMe;
        private final boolean isMuted;
        private final boolean isRequestingToSpeak;
        private final boolean isRinging;
        private final boolean isSelfDeafened;
        private final boolean isSelfMuted;
        private final boolean isServerDeafened;
        private final boolean isServerMuted;
        private final boolean isSpeaking;
        private final String nickname;
        private final StreamContext streamContext;
        private final StoreVideoStreams.UserStreams streams;
        private final User user;
        private final StoreMediaSettings.VoiceConfiguration voiceConfiguration;
        private final VoiceState voiceState;
        private final String watchingStream;

        /* JADX WARN: Code duplicated, block: B:36:0x0077  */
        /* JADX WARN: Code duplicated, block: B:53:0x009e  */
        public VoiceUser(User user, VoiceState voiceState, boolean z2, StoreVideoStreams.UserStreams userStreams, boolean z3, GuildMember guildMember, String str, StreamContext streamContext, boolean z4, StoreMediaSettings.VoiceConfiguration voiceConfiguration, boolean z5) {
            boolean selfMute;
            boolean selfDeaf;
            Intrinsics3.checkNotNullParameter(user, "user");
            this.user = user;
            this.voiceState = voiceState;
            this.isRinging = z2;
            this.streams = userStreams;
            this.isMe = z3;
            this.guildMember = guildMember;
            this.watchingStream = str;
            this.streamContext = streamContext;
            this.isBooster = z4;
            this.voiceConfiguration = voiceConfiguration;
            this._isSpeaking = z5;
            this.isSpeaking = (voiceState == null || !z5 || voiceState.getMute() || voiceState.getDeaf()) ? false : true;
            this.nickname = guildMember != null ? guildMember.getNick() : null;
            this.callStreamId = userStreams != null ? userStreams.getCallStreamId() : null;
            this.applicationStreamId = userStreams != null ? userStreams.getApplicationStreamId() : null;
            this.applicationStream = streamContext != null ? streamContext.getStream() : null;
            boolean mute = voiceState != null ? voiceState.getMute() : false;
            this.isServerMuted = mute;
            if (z3) {
                if (voiceConfiguration != null) {
                    selfMute = voiceConfiguration.isSelfMuted();
                } else {
                    selfMute = false;
                }
            } else if (voiceState != null) {
                selfMute = voiceState.getSelfMute();
            } else {
                selfMute = false;
            }
            this.isSelfMuted = selfMute;
            this.isMuted = mute || selfMute;
            boolean deaf = voiceState != null ? voiceState.getDeaf() : false;
            this.isServerDeafened = deaf;
            if (z3) {
                if (voiceConfiguration != null) {
                    selfDeaf = voiceConfiguration.isSelfDeafened();
                } else {
                    selfDeaf = false;
                }
            } else if (voiceState != null) {
                selfDeaf = voiceState.getSelfDeaf();
            } else {
                selfDeaf = false;
            }
            this.isSelfDeafened = selfDeaf;
            this.isDeafened = deaf || selfDeaf;
            this.isRequestingToSpeak = AnimatableValueParser.y0(voiceState).getIsRequestingToSpeak();
            this.isInvitedToSpeak = AnimatableValueParser.y0(voiceState) == StageRequestToSpeakState.REQUESTED_TO_SPEAK_AND_AWAITING_USER_ACK;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        private final StoreMediaSettings.VoiceConfiguration getVoiceConfiguration() {
            return this.voiceConfiguration;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        private final boolean get_isSpeaking() {
            return this._isSpeaking;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final VoiceState getVoiceState() {
            return this.voiceState;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsRinging() {
            return this.isRinging;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final StoreVideoStreams.UserStreams getStreams() {
            return this.streams;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsMe() {
            return this.isMe;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final GuildMember getGuildMember() {
            return this.guildMember;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getWatchingStream() {
            return this.watchingStream;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final StreamContext getStreamContext() {
            return this.streamContext;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final boolean getIsBooster() {
            return this.isBooster;
        }

        public final VoiceUser copy(User user, VoiceState voiceState, boolean isRinging, StoreVideoStreams.UserStreams streams, boolean isMe, GuildMember guildMember, String watchingStream, StreamContext streamContext, boolean isBooster, StoreMediaSettings.VoiceConfiguration voiceConfiguration, boolean _isSpeaking) {
            Intrinsics3.checkNotNullParameter(user, "user");
            return new VoiceUser(user, voiceState, isRinging, streams, isMe, guildMember, watchingStream, streamContext, isBooster, voiceConfiguration, _isSpeaking);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VoiceUser)) {
                return false;
            }
            VoiceUser voiceUser = (VoiceUser) other;
            return Intrinsics3.areEqual(this.user, voiceUser.user) && Intrinsics3.areEqual(this.voiceState, voiceUser.voiceState) && this.isRinging == voiceUser.isRinging && Intrinsics3.areEqual(this.streams, voiceUser.streams) && this.isMe == voiceUser.isMe && Intrinsics3.areEqual(this.guildMember, voiceUser.guildMember) && Intrinsics3.areEqual(this.watchingStream, voiceUser.watchingStream) && Intrinsics3.areEqual(this.streamContext, voiceUser.streamContext) && this.isBooster == voiceUser.isBooster && Intrinsics3.areEqual(this.voiceConfiguration, voiceUser.voiceConfiguration) && this._isSpeaking == voiceUser._isSpeaking;
        }

        public final ModelApplicationStream getApplicationStream() {
            return this.applicationStream;
        }

        public final Integer getApplicationStreamId() {
            return this.applicationStreamId;
        }

        public final Integer getCallStreamId() {
            return this.callStreamId;
        }

        public final String getDisplayName() {
            String str = this.nickname;
            return str != null ? str : this.user.getUsername();
        }

        public final GuildMember getGuildMember() {
            return this.guildMember;
        }

        public final String getNickname() {
            return this.nickname;
        }

        public final StreamContext getStreamContext() {
            return this.streamContext;
        }

        public final StoreVideoStreams.UserStreams getStreams() {
            return this.streams;
        }

        public final User getUser() {
            return this.user;
        }

        public final VoiceState getVoiceState() {
            return this.voiceState;
        }

        public final String getWatchingStream() {
            return this.watchingStream;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v22, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r2v20, types: [int] */
        /* JADX WARN: Type inference failed for: r2v22 */
        /* JADX WARN: Type inference failed for: r2v26 */
        /* JADX WARN: Type inference failed for: r2v28 */
        /* JADX WARN: Type inference failed for: r2v30 */
        /* JADX WARN: Type inference failed for: r2v31 */
        /* JADX WARN: Type inference failed for: r2v32 */
        /* JADX WARN: Type inference failed for: r2v4, types: [int] */
        /* JADX WARN: Type inference failed for: r2v9, types: [int] */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public int hashCode() {
            User user = this.user;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            VoiceState voiceState = this.voiceState;
            int iHashCode2 = (iHashCode + (voiceState != null ? voiceState.hashCode() : 0)) * 31;
            boolean z2 = this.isRinging;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode2 + r2) * 31;
            StoreVideoStreams.UserStreams userStreams = this.streams;
            int iHashCode3 = (i + (userStreams != null ? userStreams.hashCode() : 0)) * 31;
            boolean z3 = this.isMe;
            ?? r3 = z3;
            if (z3) {
                r3 = 1;
            }
            int i2 = (iHashCode3 + r3) * 31;
            GuildMember guildMember = this.guildMember;
            int iHashCode4 = (i2 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
            String str = this.watchingStream;
            int iHashCode5 = (iHashCode4 + (str != null ? str.hashCode() : 0)) * 31;
            StreamContext streamContext = this.streamContext;
            int iHashCode6 = (iHashCode5 + (streamContext != null ? streamContext.hashCode() : 0)) * 31;
            boolean z4 = this.isBooster;
            ?? r4 = z4;
            if (z4) {
                r4 = 1;
            }
            int i3 = (iHashCode6 + r4) * 31;
            StoreMediaSettings.VoiceConfiguration voiceConfiguration = this.voiceConfiguration;
            int iHashCode7 = (i3 + (voiceConfiguration != null ? voiceConfiguration.hashCode() : 0)) * 31;
            boolean z5 = this._isSpeaking;
            return iHashCode7 + (z5 ? 1 : z5);
        }

        public final boolean isBooster() {
            return this.isBooster;
        }

        public final boolean isConnected() {
            return this.voiceState != null;
        }

        /* JADX INFO: renamed from: isDeafened, reason: from getter */
        public final boolean getIsDeafened() {
            return this.isDeafened;
        }

        /* JADX INFO: renamed from: isInvitedToSpeak, reason: from getter */
        public final boolean getIsInvitedToSpeak() {
            return this.isInvitedToSpeak;
        }

        public final boolean isMe() {
            return this.isMe;
        }

        /* JADX INFO: renamed from: isMuted, reason: from getter */
        public final boolean getIsMuted() {
            return this.isMuted;
        }

        /* JADX INFO: renamed from: isRequestingToSpeak, reason: from getter */
        public final boolean getIsRequestingToSpeak() {
            return this.isRequestingToSpeak;
        }

        public final boolean isRinging() {
            return this.isRinging;
        }

        /* JADX INFO: renamed from: isSpeaking, reason: from getter */
        public final boolean getIsSpeaking() {
            return this.isSpeaking;
        }

        public String toString() {
            StringBuilder sbU = outline.U("VoiceUser(user=");
            sbU.append(this.user);
            sbU.append(", voiceState=");
            sbU.append(this.voiceState);
            sbU.append(", isRinging=");
            sbU.append(this.isRinging);
            sbU.append(", streams=");
            sbU.append(this.streams);
            sbU.append(", isMe=");
            sbU.append(this.isMe);
            sbU.append(", guildMember=");
            sbU.append(this.guildMember);
            sbU.append(", watchingStream=");
            sbU.append(this.watchingStream);
            sbU.append(", streamContext=");
            sbU.append(this.streamContext);
            sbU.append(", isBooster=");
            sbU.append(this.isBooster);
            sbU.append(", voiceConfiguration=");
            sbU.append(this.voiceConfiguration);
            sbU.append(", _isSpeaking=");
            return outline.O(sbU, this._isSpeaking, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreVoiceParticipants$get$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreVoiceParticipants.kt */
    public static final class AnonymousClass1<T, R> implements Func1<Channel, Observable<? extends Map<Long, ? extends VoiceUser>>> {
        public final /* synthetic */ long $channelId;

        /* JADX INFO: renamed from: com.discord.stores.StoreVoiceParticipants$get$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreVoiceParticipants.kt */
        public static final class C01941<T, R> implements Func1<Map<Long, ? extends VoiceState>, Observable<? extends Map<Long, ? extends VoiceUser>>> {
            public final /* synthetic */ Channel $channel;
            public final /* synthetic */ long $guildId;

            public C01941(Channel channel, long j) {
                this.$channel = channel;
                this.$guildId = j;
            }

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Observable<? extends Map<Long, ? extends VoiceUser>> call(Map<Long, ? extends VoiceState> map) {
                return call2((Map<Long, VoiceState>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends Map<Long, VoiceUser>> call2(final Map<Long, VoiceState> map) {
                Observable observableObserveMe$default = StoreUser.observeMe$default(StoreVoiceParticipants.this.getStream().getUsers(), false, 1, null);
                StoreVoiceParticipants storeVoiceParticipants = StoreVoiceParticipants.this;
                Channel channel = this.$channel;
                Intrinsics3.checkNotNullExpressionValue(map, "voiceStates");
                return Observable.j(observableObserveMe$default, storeVoiceParticipants.getOtherVoiceUsers(channel, map), new Func2<MeUser, Collection<? extends User>, Tuples2<? extends MeUser, ? extends Collection<? extends User>>>() { // from class: com.discord.stores.StoreVoiceParticipants.get.1.1.1
                    @Override // rx.functions.Func2
                    public final Tuples2<MeUser, Collection<User>> call(MeUser meUser, Collection<? extends User> collection) {
                        return Tuples.to(meUser, collection);
                    }
                }).Y(new Func1<Tuples2<? extends MeUser, ? extends Collection<? extends User>>, Observable<? extends Map<Long, ? extends VoiceUser>>>() { // from class: com.discord.stores.StoreVoiceParticipants.get.1.1.2
                    @Override // j0.k.Func1
                    public /* bridge */ /* synthetic */ Observable<? extends Map<Long, ? extends VoiceUser>> call(Tuples2<? extends MeUser, ? extends Collection<? extends User>> tuples2) {
                        return call2((Tuples2<MeUser, ? extends Collection<? extends User>>) tuples2);
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final Observable<? extends Map<Long, VoiceUser>> call2(Tuples2<MeUser, ? extends Collection<? extends User>> tuples2) {
                        final MeUser meUserComponent1 = tuples2.component1();
                        final Collection<? extends User> collectionComponent2 = tuples2.component2();
                        Intrinsics3.checkNotNullExpressionValue(collectionComponent2, "otherUsers");
                        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(collectionComponent2, 10));
                        Iterator<T> it = collectionComponent2.iterator();
                        while (it.hasNext()) {
                            arrayList.add(Long.valueOf(((User) it.next()).getId()));
                        }
                        return Observable.e(ObservableExtensionsKt.leadingEdgeThrottle(StoreVoiceParticipants.this.getStream().getVoiceSpeaking().observeSpeakingUsers(), 250L, TimeUnit.MILLISECONDS), StoreVoiceParticipants.this.getStream().getCalls().get(AnonymousClass1.this.$channelId).G(new Func1<ModelCall, List<? extends Long>>() { // from class: com.discord.stores.StoreVoiceParticipants.get.1.1.2.1
                            @Override // j0.k.Func1
                            public final List<Long> call(ModelCall modelCall) {
                                List<Long> ringing;
                                return (modelCall == null || (ringing = modelCall.getRinging()) == null) ? Collections2.emptyList() : ringing;
                            }
                        }), StoreVoiceParticipants.this.getStream().getVideoStreams().observeUserStreams(), ObservableExtensionsKt.leadingEdgeThrottle(StoreVoiceParticipants.this.getStream().getGuilds().observeComputed(C01941.this.$guildId), 1L, TimeUnit.SECONDS), StoreVoiceParticipants.this.getStream().getApplicationStreaming().observeStreamSpectators(), StoreVoiceParticipants.this.getStream().getMediaSettings().getVoiceConfig(), StoreVoiceParticipants.this.getStreamContextsForUsers(_Collections.plus((Collection<? extends Long>) arrayList, Long.valueOf(meUserComponent1.getId()))), new Func7<Set<? extends Long>, List<? extends Long>, Map<Long, ? extends StoreVideoStreams.UserStreams>, Map<Long, ? extends GuildMember>, Map<String, ? extends List<? extends Long>>, StoreMediaSettings.VoiceConfiguration, Map<Long, ? extends StreamContext>, Map<Long, ? extends VoiceUser>>() { // from class: com.discord.stores.StoreVoiceParticipants.get.1.1.2.2
                            @Override // rx.functions.Func7
                            public /* bridge */ /* synthetic */ Map<Long, ? extends VoiceUser> call(Set<? extends Long> set, List<? extends Long> list, Map<Long, ? extends StoreVideoStreams.UserStreams> map2, Map<Long, ? extends GuildMember> map3, Map<String, ? extends List<? extends Long>> map4, StoreMediaSettings.VoiceConfiguration voiceConfiguration, Map<Long, ? extends StreamContext> map5) {
                                return call2((Set<Long>) set, (List<Long>) list, (Map<Long, StoreVideoStreams.UserStreams>) map2, (Map<Long, GuildMember>) map3, (Map<String, ? extends List<Long>>) map4, voiceConfiguration, (Map<Long, StreamContext>) map5);
                            }

                            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                            public final Map<Long, VoiceUser> call2(Set<Long> set, List<Long> list, Map<Long, StoreVideoStreams.UserStreams> map2, Map<Long, GuildMember> map3, Map<String, ? extends List<Long>> map4, StoreMediaSettings.VoiceConfiguration voiceConfiguration, Map<Long, StreamContext> map5) {
                                StoreVoiceParticipants storeVoiceParticipants2 = StoreVoiceParticipants.this;
                                MeUser meUser = meUserComponent1;
                                Intrinsics3.checkNotNullExpressionValue(meUser, "meUser");
                                Collection collection = collectionComponent2;
                                Intrinsics3.checkNotNullExpressionValue(collection, "otherUsers");
                                Map map6 = map;
                                Intrinsics3.checkNotNullExpressionValue(map6, "voiceStates");
                                Intrinsics3.checkNotNullExpressionValue(set, "speakingUsers");
                                Intrinsics3.checkNotNullExpressionValue(list, "ringingUsers");
                                Intrinsics3.checkNotNullExpressionValue(map2, "videoStreams");
                                Intrinsics3.checkNotNullExpressionValue(map3, "guildMembers");
                                Intrinsics3.checkNotNullExpressionValue(map4, "streamSpectators");
                                Intrinsics3.checkNotNullExpressionValue(voiceConfiguration, "voiceConfig");
                                Intrinsics3.checkNotNullExpressionValue(map5, "streamContexts");
                                return storeVoiceParticipants2.create(meUser, collection, map6, set, list, map2, map3, map4, voiceConfiguration, map5);
                            }
                        });
                    }
                });
            }
        }

        public AnonymousClass1(long j) {
            this.$channelId = j;
        }

        @Override // j0.k.Func1
        public final Observable<? extends Map<Long, VoiceUser>> call(Channel channel) {
            if (channel == null) {
                return new ScalarSynchronousObservable(Maps6.emptyMap());
            }
            long guildId = ChannelUtils.B(channel) ? 0L : channel.getGuildId();
            return StoreVoiceParticipants.this.getStream().getVoiceStates().observe(guildId, channel.getId()).Y(new C01941(channel, guildId));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreVoiceParticipants$getOtherVoiceUsers$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreVoiceParticipants.kt */
    public static final class AnonymousClass1<T, R> implements Func1<Long, Observable<? extends Collection<? extends User>>> {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ Map $voiceStates;

        public AnonymousClass1(Channel channel, Map map) {
            this.$channel = channel;
            this.$voiceStates = map;
        }

        @Override // j0.k.Func1
        public final Observable<? extends Collection<User>> call(final Long l) {
            return StoreStream.INSTANCE.getGuilds().observeComputed(this.$channel.getGuildId()).G(new Func1<Map<Long, ? extends GuildMember>, Set<? extends Long>>() { // from class: com.discord.stores.StoreVoiceParticipants.getOtherVoiceUsers.1.1
                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ Set<? extends Long> call(Map<Long, ? extends GuildMember> map) {
                    return call2((Map<Long, GuildMember>) map);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final Set<Long> call2(Map<Long, GuildMember> map) {
                    return map.keySet();
                }
            }).G(new Func1<Set<? extends Long>, List<? extends Long>>() { // from class: com.discord.stores.StoreVoiceParticipants.getOtherVoiceUsers.1.2
                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ List<? extends Long> call(Set<? extends Long> set) {
                    return call2((Set<Long>) set);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final List<Long> call2(Set<Long> set) {
                    Intrinsics3.checkNotNullExpressionValue(set, "memberIds");
                    ArrayList arrayList = new ArrayList();
                    for (T t : set) {
                        long jLongValue = ((Number) t).longValue();
                        Long l2 = l;
                        if ((l2 == null || jLongValue != l2.longValue()) && AnonymousClass1.this.$voiceStates.containsKey(Long.valueOf(jLongValue))) {
                            arrayList.add(t);
                        }
                    }
                    return arrayList;
                }
            }).Y(new Func1<List<? extends Long>, Observable<? extends Collection<? extends User>>>() { // from class: com.discord.stores.StoreVoiceParticipants.getOtherVoiceUsers.1.3
                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ Observable<? extends Collection<? extends User>> call(List<? extends Long> list) {
                    return call2((List<Long>) list);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final Observable<? extends Collection<User>> call2(List<Long> list) {
                    StoreUser users = StoreStream.INSTANCE.getUsers();
                    Intrinsics3.checkNotNullExpressionValue(list, "otherMemberIds");
                    return users.observeUsers(list).u(new Action1<Map<Long, ? extends User>>() { // from class: com.discord.stores.StoreVoiceParticipants.getOtherVoiceUsers.1.3.1
                        @Override // rx.functions.Action1
                        public final void call(Map<Long, ? extends User> map) {
                            StoreStream.Companion companion = StoreStream.INSTANCE;
                            StageInstance stageInstanceForChannel = companion.getStageInstances().getStageInstanceForChannel(AnonymousClass1.this.$channel.getId());
                            if ((stageInstanceForChannel != null ? stageInstanceForChannel.getPrivacyLevel() : null) == StageInstancePrivacyLevel.PUBLIC) {
                                StoreGuildMemberRequester guildMemberRequester = companion.getGuildMemberRequester();
                                Iterator it = AnonymousClass1.this.$voiceStates.keySet().iterator();
                                while (it.hasNext()) {
                                    long jLongValue = ((Number) it.next()).longValue();
                                    Intrinsics3.checkNotNullExpressionValue(map, "otherUsers");
                                    if (!map.containsKey(Long.valueOf(jLongValue))) {
                                        guildMemberRequester.queueRequest(AnonymousClass1.this.$channel.getGuildId(), jLongValue);
                                    }
                                }
                                guildMemberRequester.performQueuedRequests();
                            }
                        }
                    }).G(new Func1<Map<Long, ? extends User>, Collection<? extends User>>() { // from class: com.discord.stores.StoreVoiceParticipants.getOtherVoiceUsers.1.3.2
                        @Override // j0.k.Func1
                        public final Collection<User> call(Map<Long, ? extends User> map) {
                            return map.values();
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreVoiceParticipants$init$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreVoiceParticipants.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            StoreVoiceParticipants.this.selectParticipant(null);
        }
    }

    public StoreVoiceParticipants(StoreStream storeStream) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        this.stream = storeStream;
        this.selectedParticipantSubject = BehaviorSubject.l0(0L);
    }

    private final Map<Long, VoiceUser> create(MeUser meUser, Collection<? extends User> otherUsers, Map<Long, VoiceState> voiceStates, Set<Long> speakingUsers, Collection<Long> ringingUsers, Map<Long, StoreVideoStreams.UserStreams> videoStreams, Map<Long, GuildMember> guildMembers, Map<String, ? extends List<Long>> streamSpectators, StoreMediaSettings.VoiceConfiguration voiceConfiguration, Map<Long, StreamContext> streamContexts) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry<String, ? extends List<Long>> entry : streamSpectators.entrySet()) {
            if (entry.getValue().contains(Long.valueOf(meUser.getId()))) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap2.size());
        Iterator it = linkedHashMap2.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add((String) ((Map.Entry) it.next()).getKey());
        }
        String str = (String) _Collections.firstOrNull((List) arrayList);
        VoiceState voiceState = voiceStates.get(Long.valueOf(meUser.getId()));
        boolean zContains = ringingUsers.contains(Long.valueOf(meUser.getId()));
        StoreVideoStreams.UserStreams userStreams = videoStreams.get(Long.valueOf(meUser.getId()));
        GuildMember guildMember = guildMembers.get(Long.valueOf(meUser.getId()));
        GuildMember guildMember2 = guildMembers.get(Long.valueOf(meUser.getId()));
        linkedHashMap.put(Long.valueOf(meUser.getId()), new VoiceUser(meUser, voiceState, zContains, userStreams, true, guildMember, str, null, (guildMember2 != null ? guildMember2.getPremiumSince() : null) != null, voiceConfiguration, speakingUsers.contains(Long.valueOf(meUser.getId()))));
        ArrayList<VoiceUser> arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(otherUsers, 10));
        for (User user : otherUsers) {
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Map.Entry<String, ? extends List<Long>> entry2 : streamSpectators.entrySet()) {
                if (entry2.getValue().contains(Long.valueOf(user.getId()))) {
                    linkedHashMap3.put(entry2.getKey(), entry2.getValue());
                }
            }
            ArrayList arrayList3 = new ArrayList(linkedHashMap3.size());
            Iterator it2 = linkedHashMap3.entrySet().iterator();
            while (it2.hasNext()) {
                arrayList3.add((String) ((Map.Entry) it2.next()).getKey());
            }
            String str2 = (String) _Collections.firstOrNull((List) arrayList3);
            VoiceState voiceState2 = (VoiceState) outline.f(user, voiceStates);
            boolean zContains2 = ringingUsers.contains(Long.valueOf(user.getId()));
            StoreVideoStreams.UserStreams userStreams2 = (StoreVideoStreams.UserStreams) outline.f(user, videoStreams);
            GuildMember guildMember3 = (GuildMember) outline.f(user, guildMembers);
            StreamContext streamContext = (StreamContext) outline.f(user, streamContexts);
            GuildMember guildMember4 = (GuildMember) outline.f(user, guildMembers);
            arrayList2.add(new VoiceUser(user, voiceState2, zContains2, userStreams2, false, guildMember3, str2, streamContext, (guildMember4 != null ? guildMember4.getPremiumSince() : null) != null, voiceConfiguration, speakingUsers.contains(Long.valueOf(user.getId()))));
        }
        for (VoiceUser voiceUser : arrayList2) {
            linkedHashMap.put(Long.valueOf(voiceUser.getUser().getId()), voiceUser);
        }
        return linkedHashMap;
    }

    private final Observable<Collection<User>> getOtherVoiceUsers(Channel channel, Map<Long, VoiceState> voiceStates) {
        if (ChannelUtils.B(channel)) {
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(ChannelUtils.g(channel));
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(channel.getRecipients())");
            return scalarSynchronousObservable;
        }
        if (ChannelUtils.w(channel)) {
            Observable observableY = StoreStream.INSTANCE.getUsers().observeMeId().Y(new AnonymousClass1(channel, voiceStates));
            Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n            …          }\n            }");
            return observableY;
        }
        ScalarSynchronousObservable scalarSynchronousObservable2 = new ScalarSynchronousObservable(Collections2.emptyList());
        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable2, "Observable.just(emptyList())");
        return scalarSynchronousObservable2;
    }

    private final Observable<Map<Long, StreamContext>> getStreamContextsForUsers(final List<Long> userIds) {
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(userIds, 10));
        for (Iterator it = userIds.iterator(); it.hasNext(); it = it) {
            arrayList.add(new StreamContextService(null, null, null, null, null, null, null, null, 255, null).getForUser(((Number) it.next()).longValue(), true));
        }
        Observable<Map<Long, StreamContext>> observableB = Observable.b(arrayList, new FuncN<Map<Long, ? extends StreamContext>>() { // from class: com.discord.stores.StoreVoiceParticipants.getStreamContextsForUsers.1
            @Override // rx.functions.FuncN
            public final Map<Long, ? extends StreamContext> call(Object[] objArr) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int i = 0;
                for (Object obj : userIds) {
                    int i2 = i + 1;
                    if (i < 0) {
                        Collections2.throwIndexOverflow();
                    }
                    linkedHashMap.put(Long.valueOf(((Number) obj).longValue()), (StreamContext) objArr[i]);
                    i = i2;
                }
                return linkedHashMap;
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableB, "Observable\n        .comb…}\n          map\n        }");
        return observableB;
    }

    public final Observable<Map<Long, VoiceUser>> get(long channelId) {
        Observable<R> observableY = StoreStream.INSTANCE.getChannels().observeChannel(channelId).Y(new AnonymousClass1(channelId));
        Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n        .get…  }\n          }\n        }");
        Observable<Map<Long, VoiceUser>> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream\n        .get…  .distinctUntilChanged()");
        return observableR;
    }

    public final StoreStream getStream() {
        return this.stream;
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        ObservableExtensionsKt.appSubscribe(this.stream.getVoiceChannelSelected().observeSelectedVoiceChannelId(), (Class<?>) StoreVoiceParticipants.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    public final void selectParticipant(Long userId) {
        this.selectedParticipantSubject.onNext(userId);
    }
}
