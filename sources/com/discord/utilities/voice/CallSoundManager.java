package com.discord.utilities.voice;

import androidx.annotation.MainThread;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppComponent;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.user.MeUser;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreRtcConnection;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.media.AppSound;
import com.discord.utilities.media.AppSoundManager;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.voice.CallSoundManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func7;

/* JADX INFO: compiled from: CallSoundManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CallSoundManager {
    private static final int JOIN_LEAVE_USER_LIMIT = 25;
    private String activeStreamKey;
    private Long activeStreamUserId;
    private int activeStreamViewerCount;
    private final AppComponent appComponent;
    private final AppSoundManager appSoundManager;
    private int numConnectedParticipants;
    private final IStoreStateGenerator storeStateGenerator;
    private Subscription storeStateSubscription;
    private List<Long> streamingUserIds;
    private Long voiceChannelId;

    /* JADX INFO: compiled from: CallSoundManager.kt */
    public interface IStoreStateGenerator {
        Observable<StoreState> observeStoreState(long voiceChannelId);
    }

    /* JADX INFO: compiled from: CallSoundManager.kt */
    public static final /* data */ class StoreState {
        private final StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream;
        private final MeUser me;
        private final RtcConnection.State rtcConnectionState;
        private final Channel selectedVoiceChannel;
        private final Map<String, List<Long>> streamSpectators;
        private final Map<Long, ModelApplicationStream> streamsByUser;
        private final Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(Map<Long, StoreVoiceParticipants.VoiceUser> map, RtcConnection.State state, Map<Long, ? extends ModelApplicationStream> map2, Map<String, ? extends List<Long>> map3, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, MeUser meUser, Channel channel) {
            C12238m.checkNotNullParameter(map, "voiceParticipants");
            C12238m.checkNotNullParameter(state, "rtcConnectionState");
            C12238m.checkNotNullParameter(map2, "streamsByUser");
            C12238m.checkNotNullParameter(map3, "streamSpectators");
            C12238m.checkNotNullParameter(meUser, "me");
            this.voiceParticipants = map;
            this.rtcConnectionState = state;
            this.streamsByUser = map2;
            this.streamSpectators = map3;
            this.activeApplicationStream = activeApplicationStream;
            this.me = meUser;
            this.selectedVoiceChannel = channel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, Map map, RtcConnection.State state, Map map2, Map map3, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, MeUser meUser, Channel channel, int i, Object obj) {
            if ((i & 1) != 0) {
                map = storeState.voiceParticipants;
            }
            if ((i & 2) != 0) {
                state = storeState.rtcConnectionState;
            }
            RtcConnection.State state2 = state;
            if ((i & 4) != 0) {
                map2 = storeState.streamsByUser;
            }
            Map map4 = map2;
            if ((i & 8) != 0) {
                map3 = storeState.streamSpectators;
            }
            Map map5 = map3;
            if ((i & 16) != 0) {
                activeApplicationStream = storeState.activeApplicationStream;
            }
            StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream2 = activeApplicationStream;
            if ((i & 32) != 0) {
                meUser = storeState.me;
            }
            MeUser meUser2 = meUser;
            if ((i & 64) != 0) {
                channel = storeState.selectedVoiceChannel;
            }
            return storeState.copy(map, state2, map4, map5, activeApplicationStream2, meUser2, channel);
        }

        public final Map<Long, StoreVoiceParticipants.VoiceUser> component1() {
            return this.voiceParticipants;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final RtcConnection.State getRtcConnectionState() {
            return this.rtcConnectionState;
        }

        public final Map<Long, ModelApplicationStream> component3() {
            return this.streamsByUser;
        }

        public final Map<String, List<Long>> component4() {
            return this.streamSpectators;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final StoreApplicationStreaming.ActiveApplicationStream getActiveApplicationStream() {
            return this.activeApplicationStream;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final MeUser getMe() {
            return this.me;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Channel getSelectedVoiceChannel() {
            return this.selectedVoiceChannel;
        }

        public final StoreState copy(Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants, RtcConnection.State rtcConnectionState, Map<Long, ? extends ModelApplicationStream> streamsByUser, Map<String, ? extends List<Long>> streamSpectators, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, MeUser me2, Channel selectedVoiceChannel) {
            C12238m.checkNotNullParameter(voiceParticipants, "voiceParticipants");
            C12238m.checkNotNullParameter(rtcConnectionState, "rtcConnectionState");
            C12238m.checkNotNullParameter(streamsByUser, "streamsByUser");
            C12238m.checkNotNullParameter(streamSpectators, "streamSpectators");
            C12238m.checkNotNullParameter(me2, "me");
            return new StoreState(voiceParticipants, rtcConnectionState, streamsByUser, streamSpectators, activeApplicationStream, me2, selectedVoiceChannel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return C12238m.areEqual(this.voiceParticipants, storeState.voiceParticipants) && C12238m.areEqual(this.rtcConnectionState, storeState.rtcConnectionState) && C12238m.areEqual(this.streamsByUser, storeState.streamsByUser) && C12238m.areEqual(this.streamSpectators, storeState.streamSpectators) && C12238m.areEqual(this.activeApplicationStream, storeState.activeApplicationStream) && C12238m.areEqual(this.me, storeState.me) && C12238m.areEqual(this.selectedVoiceChannel, storeState.selectedVoiceChannel);
        }

        public final StoreApplicationStreaming.ActiveApplicationStream getActiveApplicationStream() {
            return this.activeApplicationStream;
        }

        public final MeUser getMe() {
            return this.me;
        }

        public final RtcConnection.State getRtcConnectionState() {
            return this.rtcConnectionState;
        }

        public final Channel getSelectedVoiceChannel() {
            return this.selectedVoiceChannel;
        }

        public final Map<String, List<Long>> getStreamSpectators() {
            return this.streamSpectators;
        }

        public final Map<Long, ModelApplicationStream> getStreamsByUser() {
            return this.streamsByUser;
        }

        public final Map<Long, StoreVoiceParticipants.VoiceUser> getVoiceParticipants() {
            return this.voiceParticipants;
        }

        public int hashCode() {
            Map<Long, StoreVoiceParticipants.VoiceUser> map = this.voiceParticipants;
            int iHashCode = (map != null ? map.hashCode() : 0) * 31;
            RtcConnection.State state = this.rtcConnectionState;
            int iHashCode2 = (iHashCode + (state != null ? state.hashCode() : 0)) * 31;
            Map<Long, ModelApplicationStream> map2 = this.streamsByUser;
            int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<String, List<Long>> map3 = this.streamSpectators;
            int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
            StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream = this.activeApplicationStream;
            int iHashCode5 = (iHashCode4 + (activeApplicationStream != null ? activeApplicationStream.hashCode() : 0)) * 31;
            MeUser meUser = this.me;
            int iHashCode6 = (iHashCode5 + (meUser != null ? meUser.hashCode() : 0)) * 31;
            Channel channel = this.selectedVoiceChannel;
            return iHashCode6 + (channel != null ? channel.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StoreState(voiceParticipants=");
            sbM833U.append(this.voiceParticipants);
            sbM833U.append(", rtcConnectionState=");
            sbM833U.append(this.rtcConnectionState);
            sbM833U.append(", streamsByUser=");
            sbM833U.append(this.streamsByUser);
            sbM833U.append(", streamSpectators=");
            sbM833U.append(this.streamSpectators);
            sbM833U.append(", activeApplicationStream=");
            sbM833U.append(this.activeApplicationStream);
            sbM833U.append(", me=");
            sbM833U.append(this.me);
            sbM833U.append(", selectedVoiceChannel=");
            sbM833U.append(this.selectedVoiceChannel);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: CallSoundManager.kt */
    public static final class StoreStateGenerator implements IStoreStateGenerator {
        private final StoreApplicationStreaming storeApplicationStreaming;
        private final StoreChannels storeChannels;
        private final StoreRtcConnection storeRtcConnection;
        private final StoreUser storeUser;
        private final StoreVoiceParticipants storeVoiceParticipants;

        public StoreStateGenerator() {
            this(null, null, null, null, null, 31, null);
        }

        public StoreStateGenerator(StoreVoiceParticipants storeVoiceParticipants, StoreRtcConnection storeRtcConnection, StoreApplicationStreaming storeApplicationStreaming, StoreUser storeUser, StoreChannels storeChannels) {
            C12238m.checkNotNullParameter(storeVoiceParticipants, "storeVoiceParticipants");
            C12238m.checkNotNullParameter(storeRtcConnection, "storeRtcConnection");
            C12238m.checkNotNullParameter(storeApplicationStreaming, "storeApplicationStreaming");
            C12238m.checkNotNullParameter(storeUser, "storeUser");
            C12238m.checkNotNullParameter(storeChannels, "storeChannels");
            this.storeVoiceParticipants = storeVoiceParticipants;
            this.storeRtcConnection = storeRtcConnection;
            this.storeApplicationStreaming = storeApplicationStreaming;
            this.storeUser = storeUser;
            this.storeChannels = storeChannels;
        }

        @Override // com.discord.utilities.voice.CallSoundManager.IStoreStateGenerator
        public Observable<StoreState> observeStoreState(long voiceChannelId) {
            Observable<StoreState> observableM11069e = Observable.m11069e(this.storeVoiceParticipants.get(voiceChannelId), this.storeRtcConnection.getConnectionState(), this.storeApplicationStreaming.observeStreamsByUser(), this.storeApplicationStreaming.observeStreamSpectators(), this.storeApplicationStreaming.observeActiveStream(), StoreUser.observeMe$default(this.storeUser, false, 1, null), this.storeChannels.observeChannel(voiceChannelId), new Func7<Map<Long, ? extends StoreVoiceParticipants.VoiceUser>, RtcConnection.StateChange, Map<Long, ? extends ModelApplicationStream>, Map<String, ? extends List<? extends Long>>, StoreApplicationStreaming.ActiveApplicationStream, MeUser, Channel, StoreState>() { // from class: com.discord.utilities.voice.CallSoundManager$StoreStateGenerator$observeStoreState$1
                @Override // p658rx.functions.Func7
                public /* bridge */ /* synthetic */ CallSoundManager.StoreState call(Map<Long, ? extends StoreVoiceParticipants.VoiceUser> map, RtcConnection.StateChange stateChange, Map<Long, ? extends ModelApplicationStream> map2, Map<String, ? extends List<? extends Long>> map3, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, MeUser meUser, Channel channel) {
                    return call2((Map<Long, StoreVoiceParticipants.VoiceUser>) map, stateChange, map2, (Map<String, ? extends List<Long>>) map3, activeApplicationStream, meUser, channel);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final CallSoundManager.StoreState call2(Map<Long, StoreVoiceParticipants.VoiceUser> map, RtcConnection.StateChange stateChange, Map<Long, ? extends ModelApplicationStream> map2, Map<String, ? extends List<Long>> map3, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, MeUser meUser, Channel channel) {
                    C12238m.checkNotNullExpressionValue(map, "voiceParticipants");
                    RtcConnection.State state = stateChange.state;
                    C12238m.checkNotNullExpressionValue(map2, "streamsByUser");
                    C12238m.checkNotNullExpressionValue(map3, "streamSpectators");
                    C12238m.checkNotNullExpressionValue(meUser, "me");
                    return new CallSoundManager.StoreState(map, state, map2, map3, activeApplicationStream, meUser, channel);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11069e, "Observable.combineLatest…Channel\n        )\n      }");
            return observableM11069e;
        }

        public /* synthetic */ StoreStateGenerator(StoreVoiceParticipants storeVoiceParticipants, StoreRtcConnection storeRtcConnection, StoreApplicationStreaming storeApplicationStreaming, StoreUser storeUser, StoreChannels storeChannels, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? StoreStream.INSTANCE.getVoiceParticipants() : storeVoiceParticipants, (i & 2) != 0 ? StoreStream.INSTANCE.getRtcConnection() : storeRtcConnection, (i & 4) != 0 ? StoreStream.INSTANCE.getApplicationStreaming() : storeApplicationStreaming, (i & 8) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 16) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.CallSoundManager$subscribeToStoreState$1 */
    /* JADX INFO: compiled from: CallSoundManager.kt */
    public static final class C70281 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C70281() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            CallSoundManager.this.storeStateSubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.CallSoundManager$subscribeToStoreState$2 */
    /* JADX INFO: compiled from: CallSoundManager.kt */
    public static final class C70292 extends AbstractC12240o implements Function0<Unit> {
        public C70292() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            CallSoundManager.this.appSoundManager.stop(AppSound.INSTANCE.getSOUND_CALL_CALLING());
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.CallSoundManager$subscribeToStoreState$3 */
    /* JADX INFO: compiled from: CallSoundManager.kt */
    public static final class C70303 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public final /* synthetic */ long $voiceChannelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C70303(long j) {
            super(1);
            this.$voiceChannelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            CallSoundManager callSoundManager = CallSoundManager.this;
            long j = this.$voiceChannelId;
            C12238m.checkNotNullExpressionValue(storeState, "storeState");
            callSoundManager.handleStoreState(j, storeState);
        }
    }

    public CallSoundManager(AppComponent appComponent, AppSoundManager appSoundManager, IStoreStateGenerator iStoreStateGenerator) {
        C12238m.checkNotNullParameter(appComponent, "appComponent");
        C12238m.checkNotNullParameter(appSoundManager, "appSoundManager");
        C12238m.checkNotNullParameter(iStoreStateGenerator, "storeStateGenerator");
        this.appComponent = appComponent;
        this.appSoundManager = appSoundManager;
        this.storeStateGenerator = iStoreStateGenerator;
        this.streamingUserIds = C12147n.emptyList();
    }

    @MainThread
    private final void handleStoreState(long channelId, StoreState storeState) {
        boolean z2;
        boolean z3;
        boolean z4;
        Channel selectedVoiceChannel;
        StoreApplicationStreaming.ActiveApplicationStream.State state;
        int size;
        Long l = this.voiceChannelId;
        List<Long> list = this.streamingUserIds;
        int i = this.activeStreamViewerCount;
        String str = this.activeStreamKey;
        Long l2 = this.activeStreamUserId;
        int i2 = this.numConnectedParticipants;
        this.voiceChannelId = Long.valueOf(channelId);
        Collection<ModelApplicationStream> collectionValues = storeState.getStreamsByUser().values();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionValues.iterator();
        while (true) {
            z2 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((ModelApplicationStream) next).getChannelId() == channelId) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Long.valueOf(((ModelApplicationStream) it2.next()).getOwnerId()));
        }
        this.streamingUserIds = arrayList2;
        StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream = storeState.getActiveApplicationStream();
        if (activeApplicationStream == null || (state = activeApplicationStream.getState()) == null || !state.isStreamActive()) {
            this.activeStreamKey = null;
            this.activeStreamUserId = null;
            this.activeStreamViewerCount = 0;
        } else {
            this.activeStreamKey = activeApplicationStream.getStream().getEncodedStreamKey();
            this.activeStreamUserId = Long.valueOf(activeApplicationStream.getStream().getOwnerId());
            List<Long> list2 = storeState.getStreamSpectators().get(this.activeStreamKey);
            if (list2 != null) {
                ArrayList arrayList3 = new ArrayList();
                for (Object obj : list2) {
                    if (((Number) obj).longValue() != storeState.getMe().getId()) {
                        arrayList3.add(obj);
                    }
                }
                size = arrayList3.size();
            } else {
                size = 0;
            }
            this.activeStreamViewerCount = size;
        }
        String str2 = this.activeStreamKey;
        boolean z5 = str2 != null && C12238m.areEqual(str2, str);
        List<Long> list3 = this.streamingUserIds;
        if (!(list3 instanceof Collection) || !list3.isEmpty()) {
            Iterator<T> it3 = list3.iterator();
            while (true) {
                if (it3.hasNext()) {
                    if (!list.contains(Long.valueOf(((Number) it3.next()).longValue()))) {
                        z3 = true;
                        break;
                    }
                } else {
                    z3 = false;
                    break;
                }
            }
        } else {
            z3 = false;
            break;
        }
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it4 = list.iterator();
            while (true) {
                if (!it4.hasNext()) {
                    z4 = false;
                    break;
                }
                long jLongValue = ((Number) it4.next()).longValue();
                if (!this.streamingUserIds.contains(Long.valueOf(jLongValue)) && (jLongValue == storeState.getMe().getId() || (l2 != null && jLongValue == l2.longValue()))) {
                    z4 = true;
                    break;
                }
            }
        } else {
            z4 = false;
            break;
        }
        boolean z6 = z5 && i <= 25 && this.activeStreamViewerCount > i;
        if (z5 && i <= 25 && this.activeStreamViewerCount < i) {
            z2 = true;
        }
        if (C12238m.areEqual(this.voiceChannelId, l)) {
            if (z3) {
                this.appSoundManager.play(AppSound.INSTANCE.getSOUND_STREAM_STARTED());
            } else if (z4) {
                this.appSoundManager.play(AppSound.INSTANCE.getSOUND_STREAM_ENDED());
            } else if (z6) {
                this.appSoundManager.play(AppSound.INSTANCE.getSOUND_STREAM_USER_JOINED());
            } else if (z2) {
                this.appSoundManager.play(AppSound.INSTANCE.getSOUND_STREAM_USER_LEFT());
            }
        }
        Map<Long, StoreVoiceParticipants.VoiceUser> voiceParticipants = storeState.getVoiceParticipants();
        boolean zAreEqual = C12238m.areEqual(storeState.getRtcConnectionState(), RtcConnection.State.C5612f.f18814a);
        Collection<StoreVoiceParticipants.VoiceUser> collectionValues2 = voiceParticipants.values();
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : collectionValues2) {
            if (((StoreVoiceParticipants.VoiceUser) obj2).isConnected()) {
                arrayList4.add(obj2);
            }
        }
        this.numConnectedParticipants = arrayList4.size();
        Collection<StoreVoiceParticipants.VoiceUser> collectionValues3 = voiceParticipants.values();
        ArrayList arrayList5 = new ArrayList();
        for (Object obj3 : collectionValues3) {
            if (((StoreVoiceParticipants.VoiceUser) obj3).isRinging()) {
                arrayList5.add(obj3);
            }
        }
        int size2 = arrayList5.size();
        if (zAreEqual && (selectedVoiceChannel = storeState.getSelectedVoiceChannel()) != null && ChannelUtils.m7676K(selectedVoiceChannel) && i2 <= 25) {
            int i3 = this.numConnectedParticipants;
            if (i3 > i2) {
                this.appSoundManager.play(AppSound.INSTANCE.getSOUND_USER_JOINED());
            } else if (i3 < i2) {
                this.appSoundManager.play(AppSound.INSTANCE.getSOUND_USER_LEFT());
            }
        }
        if (this.numConnectedParticipants < 2 && size2 > 0) {
            AppSoundManager appSoundManager = this.appSoundManager;
            AppSound.Companion companion = AppSound.INSTANCE;
            if (!appSoundManager.isPlaying(companion.getSOUND_CALL_CALLING()) && zAreEqual) {
                this.appSoundManager.play(companion.getSOUND_CALL_CALLING());
                return;
            }
        }
        if (!zAreEqual || size2 == 0 || this.numConnectedParticipants >= 2) {
            this.appSoundManager.stop(AppSound.INSTANCE.getSOUND_CALL_CALLING());
        }
    }

    public final void subscribeToStoreState(long voiceChannelId) {
        Subscription subscription = this.storeStateSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Observable<StoreState> observableM11112r = this.storeStateGenerator.observeStoreState(voiceChannelId).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "storeStateGenerator\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableM11112r), this.appComponent, null, 2, null), (Class<?>) CallSoundManager.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C70281()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : new C70292()), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C70303(voiceChannelId));
    }

    public /* synthetic */ CallSoundManager(AppComponent appComponent, AppSoundManager appSoundManager, IStoreStateGenerator iStoreStateGenerator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appComponent, (i & 2) != 0 ? AppSoundManager.Provider.INSTANCE.get() : appSoundManager, (i & 4) != 0 ? new StoreStateGenerator(null, null, null, null, null, 31, null) : iStoreStateGenerator);
    }
}
