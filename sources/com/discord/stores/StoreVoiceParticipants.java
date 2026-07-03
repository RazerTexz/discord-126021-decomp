package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContextService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.functions.Func2;
import p658rx.functions.Func7;
import p658rx.functions.FuncN;
import p658rx.subjects.BehaviorSubject;

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
            C12238m.checkNotNullParameter(user, "user");
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
            this.isRequestingToSpeak = C1460d.m592y0(voiceState).getIsRequestingToSpeak();
            this.isInvitedToSpeak = C1460d.m592y0(voiceState) == StageRequestToSpeakState.REQUESTED_TO_SPEAK_AND_AWAITING_USER_ACK;
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
            C12238m.checkNotNullParameter(user, "user");
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
            return C12238m.areEqual(this.user, voiceUser.user) && C12238m.areEqual(this.voiceState, voiceUser.voiceState) && this.isRinging == voiceUser.isRinging && C12238m.areEqual(this.streams, voiceUser.streams) && this.isMe == voiceUser.isMe && C12238m.areEqual(this.guildMember, voiceUser.guildMember) && C12238m.areEqual(this.watchingStream, voiceUser.watchingStream) && C12238m.areEqual(this.streamContext, voiceUser.streamContext) && this.isBooster == voiceUser.isBooster && C12238m.areEqual(this.voiceConfiguration, voiceUser.voiceConfiguration) && this._isSpeaking == voiceUser._isSpeaking;
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
            StringBuilder sbM833U = C1643a.m833U("VoiceUser(user=");
            sbM833U.append(this.user);
            sbM833U.append(", voiceState=");
            sbM833U.append(this.voiceState);
            sbM833U.append(", isRinging=");
            sbM833U.append(this.isRinging);
            sbM833U.append(", streams=");
            sbM833U.append(this.streams);
            sbM833U.append(", isMe=");
            sbM833U.append(this.isMe);
            sbM833U.append(", guildMember=");
            sbM833U.append(this.guildMember);
            sbM833U.append(", watchingStream=");
            sbM833U.append(this.watchingStream);
            sbM833U.append(", streamContext=");
            sbM833U.append(this.streamContext);
            sbM833U.append(", isBooster=");
            sbM833U.append(this.isBooster);
            sbM833U.append(", voiceConfiguration=");
            sbM833U.append(this.voiceConfiguration);
            sbM833U.append(", _isSpeaking=");
            return C1643a.m827O(sbM833U, this._isSpeaking, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreVoiceParticipants$get$1 */
    /* JADX INFO: compiled from: StoreVoiceParticipants.kt */
    public static final class C66231<T, R> implements InterfaceC12589b<Channel, Observable<? extends Map<Long, ? extends VoiceUser>>> {
        public final /* synthetic */ long $channelId;

        /* JADX INFO: renamed from: com.discord.stores.StoreVoiceParticipants$get$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreVoiceParticipants.kt */
        public static final class AnonymousClass1<T, R> implements InterfaceC12589b<Map<Long, ? extends VoiceState>, Observable<? extends Map<Long, ? extends VoiceUser>>> {
            public final /* synthetic */ Channel $channel;
            public final /* synthetic */ long $guildId;

            public AnonymousClass1(Channel channel, long j) {
                this.$channel = channel;
                this.$guildId = j;
            }

            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Observable<? extends Map<Long, ? extends VoiceUser>> call(Map<Long, ? extends VoiceState> map) {
                return call2((Map<Long, VoiceState>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends Map<Long, VoiceUser>> call2(final Map<Long, VoiceState> map) {
                Observable observableObserveMe$default = StoreUser.observeMe$default(StoreVoiceParticipants.this.getStream().getUsers(), false, 1, null);
                StoreVoiceParticipants storeVoiceParticipants = StoreVoiceParticipants.this;
                Channel channel = this.$channel;
                C12238m.checkNotNullExpressionValue(map, "voiceStates");
                return Observable.m11076j(observableObserveMe$default, storeVoiceParticipants.getOtherVoiceUsers(channel, map), new Func2<MeUser, Collection<? extends User>, Pair<? extends MeUser, ? extends Collection<? extends User>>>() { // from class: com.discord.stores.StoreVoiceParticipants.get.1.1.1
                    @Override // p658rx.functions.Func2
                    public final Pair<MeUser, Collection<User>> call(MeUser meUser, Collection<? extends User> collection) {
                        return C12116o.m10073to(meUser, collection);
                    }
                }).m11099Y(new InterfaceC12589b<Pair<? extends MeUser, ? extends Collection<? extends User>>, Observable<? extends Map<Long, ? extends VoiceUser>>>() { // from class: com.discord.stores.StoreVoiceParticipants.get.1.1.2
                    @Override // p637j0.p641k.InterfaceC12589b
                    public /* bridge */ /* synthetic */ Observable<? extends Map<Long, ? extends VoiceUser>> call(Pair<? extends MeUser, ? extends Collection<? extends User>> pair) {
                        return call2((Pair<MeUser, ? extends Collection<? extends User>>) pair);
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final Observable<? extends Map<Long, VoiceUser>> call2(Pair<MeUser, ? extends Collection<? extends User>> pair) {
                        final MeUser meUserComponent1 = pair.component1();
                        final Collection<? extends User> collectionComponent2 = pair.component2();
                        C12238m.checkNotNullExpressionValue(collectionComponent2, "otherUsers");
                        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(collectionComponent2, 10));
                        Iterator<T> it = collectionComponent2.iterator();
                        while (it.hasNext()) {
                            arrayList.add(Long.valueOf(((User) it.next()).getId()));
                        }
                        return Observable.m11069e(ObservableExtensionsKt.leadingEdgeThrottle(StoreVoiceParticipants.this.getStream().getVoiceSpeaking().observeSpeakingUsers(), 250L, TimeUnit.MILLISECONDS), StoreVoiceParticipants.this.getStream().getCalls().get(C66231.this.$channelId).m11083G(new InterfaceC12589b<ModelCall, List<? extends Long>>() { // from class: com.discord.stores.StoreVoiceParticipants.get.1.1.2.1
                            @Override // p637j0.p641k.InterfaceC12589b
                            public final List<Long> call(ModelCall modelCall) {
                                List<Long> ringing;
                                return (modelCall == null || (ringing = modelCall.getRinging()) == null) ? C12147n.emptyList() : ringing;
                            }
                        }), StoreVoiceParticipants.this.getStream().getVideoStreams().observeUserStreams(), ObservableExtensionsKt.leadingEdgeThrottle(StoreVoiceParticipants.this.getStream().getGuilds().observeComputed(AnonymousClass1.this.$guildId), 1L, TimeUnit.SECONDS), StoreVoiceParticipants.this.getStream().getApplicationStreaming().observeStreamSpectators(), StoreVoiceParticipants.this.getStream().getMediaSettings().getVoiceConfig(), StoreVoiceParticipants.this.getStreamContextsForUsers(C12163u.plus((Collection<? extends Long>) arrayList, Long.valueOf(meUserComponent1.getId()))), new Func7<Set<? extends Long>, List<? extends Long>, Map<Long, ? extends StoreVideoStreams.UserStreams>, Map<Long, ? extends GuildMember>, Map<String, ? extends List<? extends Long>>, StoreMediaSettings.VoiceConfiguration, Map<Long, ? extends StreamContext>, Map<Long, ? extends VoiceUser>>() { // from class: com.discord.stores.StoreVoiceParticipants.get.1.1.2.2
                            @Override // p658rx.functions.Func7
                            public /* bridge */ /* synthetic */ Map<Long, ? extends VoiceUser> call(Set<? extends Long> set, List<? extends Long> list, Map<Long, ? extends StoreVideoStreams.UserStreams> map2, Map<Long, ? extends GuildMember> map3, Map<String, ? extends List<? extends Long>> map4, StoreMediaSettings.VoiceConfiguration voiceConfiguration, Map<Long, ? extends StreamContext> map5) {
                                return call2((Set<Long>) set, (List<Long>) list, (Map<Long, StoreVideoStreams.UserStreams>) map2, (Map<Long, GuildMember>) map3, (Map<String, ? extends List<Long>>) map4, voiceConfiguration, (Map<Long, StreamContext>) map5);
                            }

                            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                            public final Map<Long, VoiceUser> call2(Set<Long> set, List<Long> list, Map<Long, StoreVideoStreams.UserStreams> map2, Map<Long, GuildMember> map3, Map<String, ? extends List<Long>> map4, StoreMediaSettings.VoiceConfiguration voiceConfiguration, Map<Long, StreamContext> map5) {
                                StoreVoiceParticipants storeVoiceParticipants2 = StoreVoiceParticipants.this;
                                MeUser meUser = meUserComponent1;
                                C12238m.checkNotNullExpressionValue(meUser, "meUser");
                                Collection collection = collectionComponent2;
                                C12238m.checkNotNullExpressionValue(collection, "otherUsers");
                                Map map6 = map;
                                C12238m.checkNotNullExpressionValue(map6, "voiceStates");
                                C12238m.checkNotNullExpressionValue(set, "speakingUsers");
                                C12238m.checkNotNullExpressionValue(list, "ringingUsers");
                                C12238m.checkNotNullExpressionValue(map2, "videoStreams");
                                C12238m.checkNotNullExpressionValue(map3, "guildMembers");
                                C12238m.checkNotNullExpressionValue(map4, "streamSpectators");
                                C12238m.checkNotNullExpressionValue(voiceConfiguration, "voiceConfig");
                                C12238m.checkNotNullExpressionValue(map5, "streamContexts");
                                return storeVoiceParticipants2.create(meUser, collection, map6, set, list, map2, map3, map4, voiceConfiguration, map5);
                            }
                        });
                    }
                });
            }
        }

        public C66231(long j) {
            this.$channelId = j;
        }

        @Override // p637j0.p641k.InterfaceC12589b
        public final Observable<? extends Map<Long, VoiceUser>> call(Channel channel) {
            if (channel == null) {
                return new C12721k(C12136h0.emptyMap());
            }
            long guildId = ChannelUtils.m7667B(channel) ? 0L : channel.getGuildId();
            return StoreVoiceParticipants.this.getStream().getVoiceStates().observe(guildId, channel.getId()).m11099Y(new AnonymousClass1(channel, guildId));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreVoiceParticipants$getOtherVoiceUsers$1 */
    /* JADX INFO: compiled from: StoreVoiceParticipants.kt */
    public static final class C66241<T, R> implements InterfaceC12589b<Long, Observable<? extends Collection<? extends User>>> {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ Map $voiceStates;

        public C66241(Channel channel, Map map) {
            this.$channel = channel;
            this.$voiceStates = map;
        }

        @Override // p637j0.p641k.InterfaceC12589b
        public final Observable<? extends Collection<User>> call(final Long l) {
            return StoreStream.INSTANCE.getGuilds().observeComputed(this.$channel.getGuildId()).m11083G(new InterfaceC12589b<Map<Long, ? extends GuildMember>, Set<? extends Long>>() { // from class: com.discord.stores.StoreVoiceParticipants.getOtherVoiceUsers.1.1
                @Override // p637j0.p641k.InterfaceC12589b
                public /* bridge */ /* synthetic */ Set<? extends Long> call(Map<Long, ? extends GuildMember> map) {
                    return call2((Map<Long, GuildMember>) map);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final Set<Long> call2(Map<Long, GuildMember> map) {
                    return map.keySet();
                }
            }).m11083G(new InterfaceC12589b<Set<? extends Long>, List<? extends Long>>() { // from class: com.discord.stores.StoreVoiceParticipants.getOtherVoiceUsers.1.2
                @Override // p637j0.p641k.InterfaceC12589b
                public /* bridge */ /* synthetic */ List<? extends Long> call(Set<? extends Long> set) {
                    return call2((Set<Long>) set);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final List<Long> call2(Set<Long> set) {
                    C12238m.checkNotNullExpressionValue(set, "memberIds");
                    ArrayList arrayList = new ArrayList();
                    for (T t : set) {
                        long jLongValue = ((Number) t).longValue();
                        Long l2 = l;
                        if ((l2 == null || jLongValue != l2.longValue()) && C66241.this.$voiceStates.containsKey(Long.valueOf(jLongValue))) {
                            arrayList.add(t);
                        }
                    }
                    return arrayList;
                }
            }).m11099Y(new InterfaceC12589b<List<? extends Long>, Observable<? extends Collection<? extends User>>>() { // from class: com.discord.stores.StoreVoiceParticipants.getOtherVoiceUsers.1.3
                @Override // p637j0.p641k.InterfaceC12589b
                public /* bridge */ /* synthetic */ Observable<? extends Collection<? extends User>> call(List<? extends Long> list) {
                    return call2((List<Long>) list);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final Observable<? extends Collection<User>> call2(List<Long> list) {
                    StoreUser users = StoreStream.INSTANCE.getUsers();
                    C12238m.checkNotNullExpressionValue(list, "otherMemberIds");
                    return users.observeUsers(list).m11115u(new Action1<Map<Long, ? extends User>>() { // from class: com.discord.stores.StoreVoiceParticipants.getOtherVoiceUsers.1.3.1
                        @Override // p658rx.functions.Action1
                        public final void call(Map<Long, ? extends User> map) {
                            StoreStream.Companion companion = StoreStream.INSTANCE;
                            StageInstance stageInstanceForChannel = companion.getStageInstances().getStageInstanceForChannel(C66241.this.$channel.getId());
                            if ((stageInstanceForChannel != null ? stageInstanceForChannel.getPrivacyLevel() : null) == StageInstancePrivacyLevel.PUBLIC) {
                                StoreGuildMemberRequester guildMemberRequester = companion.getGuildMemberRequester();
                                Iterator it = C66241.this.$voiceStates.keySet().iterator();
                                while (it.hasNext()) {
                                    long jLongValue = ((Number) it.next()).longValue();
                                    C12238m.checkNotNullExpressionValue(map, "otherUsers");
                                    if (!map.containsKey(Long.valueOf(jLongValue))) {
                                        guildMemberRequester.queueRequest(C66241.this.$channel.getGuildId(), jLongValue);
                                    }
                                }
                                guildMemberRequester.performQueuedRequests();
                            }
                        }
                    }).m11083G(new InterfaceC12589b<Map<Long, ? extends User>, Collection<? extends User>>() { // from class: com.discord.stores.StoreVoiceParticipants.getOtherVoiceUsers.1.3.2
                        @Override // p637j0.p641k.InterfaceC12589b
                        public final Collection<User> call(Map<Long, ? extends User> map) {
                            return map.values();
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreVoiceParticipants$init$1 */
    /* JADX INFO: compiled from: StoreVoiceParticipants.kt */
    public static final class C66261 extends AbstractC12240o implements Function1<Long, Unit> {
        public C66261() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.f27425a;
        }

        public final void invoke(long j) {
            StoreVoiceParticipants.this.selectParticipant(null);
        }
    }

    public StoreVoiceParticipants(StoreStream storeStream) {
        C12238m.checkNotNullParameter(storeStream, "stream");
        this.stream = storeStream;
        this.selectedParticipantSubject = BehaviorSubject.m11130l0(0L);
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
        String str = (String) C12163u.firstOrNull((List) arrayList);
        VoiceState voiceState = voiceStates.get(Long.valueOf(meUser.getId()));
        boolean zContains = ringingUsers.contains(Long.valueOf(meUser.getId()));
        StoreVideoStreams.UserStreams userStreams = videoStreams.get(Long.valueOf(meUser.getId()));
        GuildMember guildMember = guildMembers.get(Long.valueOf(meUser.getId()));
        GuildMember guildMember2 = guildMembers.get(Long.valueOf(meUser.getId()));
        linkedHashMap.put(Long.valueOf(meUser.getId()), new VoiceUser(meUser, voiceState, zContains, userStreams, true, guildMember, str, null, (guildMember2 != null ? guildMember2.getPremiumSince() : null) != null, voiceConfiguration, speakingUsers.contains(Long.valueOf(meUser.getId()))));
        ArrayList<VoiceUser> arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(otherUsers, 10));
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
            String str2 = (String) C12163u.firstOrNull((List) arrayList3);
            VoiceState voiceState2 = (VoiceState) C1643a.m849f(user, voiceStates);
            boolean zContains2 = ringingUsers.contains(Long.valueOf(user.getId()));
            StoreVideoStreams.UserStreams userStreams2 = (StoreVideoStreams.UserStreams) C1643a.m849f(user, videoStreams);
            GuildMember guildMember3 = (GuildMember) C1643a.m849f(user, guildMembers);
            StreamContext streamContext = (StreamContext) C1643a.m849f(user, streamContexts);
            GuildMember guildMember4 = (GuildMember) C1643a.m849f(user, guildMembers);
            arrayList2.add(new VoiceUser(user, voiceState2, zContains2, userStreams2, false, guildMember3, str2, streamContext, (guildMember4 != null ? guildMember4.getPremiumSince() : null) != null, voiceConfiguration, speakingUsers.contains(Long.valueOf(user.getId()))));
        }
        for (VoiceUser voiceUser : arrayList2) {
            linkedHashMap.put(Long.valueOf(voiceUser.getUser().getId()), voiceUser);
        }
        return linkedHashMap;
    }

    private final Observable<Collection<User>> getOtherVoiceUsers(Channel channel, Map<Long, VoiceState> voiceStates) {
        if (ChannelUtils.m7667B(channel)) {
            C12721k c12721k = new C12721k(ChannelUtils.m7683g(channel));
            C12238m.checkNotNullExpressionValue(c12721k, "Observable.just(channel.getRecipients())");
            return c12721k;
        }
        if (ChannelUtils.m7699w(channel)) {
            Observable observableM11099Y = StoreStream.INSTANCE.getUsers().observeMeId().m11099Y(new C66241(channel, voiceStates));
            C12238m.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n            …          }\n            }");
            return observableM11099Y;
        }
        C12721k c12721k2 = new C12721k(C12147n.emptyList());
        C12238m.checkNotNullExpressionValue(c12721k2, "Observable.just(emptyList())");
        return c12721k2;
    }

    private final Observable<Map<Long, StreamContext>> getStreamContextsForUsers(final List<Long> userIds) {
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(userIds, 10));
        for (Iterator it = userIds.iterator(); it.hasNext(); it = it) {
            arrayList.add(new StreamContextService(null, null, null, null, null, null, null, null, 255, null).getForUser(((Number) it.next()).longValue(), true));
        }
        Observable<Map<Long, StreamContext>> observableM11065b = Observable.m11065b(arrayList, new FuncN<Map<Long, ? extends StreamContext>>() { // from class: com.discord.stores.StoreVoiceParticipants.getStreamContextsForUsers.1
            @Override // p658rx.functions.FuncN
            public final Map<Long, ? extends StreamContext> call(Object[] objArr) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int i = 0;
                for (Object obj : userIds) {
                    int i2 = i + 1;
                    if (i < 0) {
                        C12147n.throwIndexOverflow();
                    }
                    linkedHashMap.put(Long.valueOf(((Number) obj).longValue()), (StreamContext) objArr[i]);
                    i = i2;
                }
                return linkedHashMap;
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11065b, "Observable\n        .comb…}\n          map\n        }");
        return observableM11065b;
    }

    public final Observable<Map<Long, VoiceUser>> get(long channelId) {
        Observable<R> observableM11099Y = StoreStream.INSTANCE.getChannels().observeChannel(channelId).m11099Y(new C66231(channelId));
        C12238m.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n        .get…  }\n          }\n        }");
        Observable<Map<Long, VoiceUser>> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11099Y).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "StoreStream\n        .get…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final StoreStream getStream() {
        return this.stream;
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        C12238m.checkNotNullParameter(context, "context");
        super.init(context);
        ObservableExtensionsKt.appSubscribe(this.stream.getVoiceChannelSelected().observeSelectedVoiceChannelId(), (Class<?>) StoreVoiceParticipants.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C66261());
    }

    public final void selectParticipant(Long userId) {
        this.selectedParticipantSubject.onNext(userId);
    }
}
