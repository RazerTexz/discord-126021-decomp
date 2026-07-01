package com.discord.utilities.voice;

import android.content.Context;
import androidx.annotation.MainThread;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppComponent;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.rtcconnection.RtcConnection$State$f;
import com.discord.stores.StoreApplicationStreaming$ActiveApplicationStream;
import com.discord.stores.StoreApplicationStreaming$ActiveApplicationStream$State;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.utilities.media.AppSound;
import com.discord.utilities.media.AppSound$Companion;
import com.discord.utilities.media.AppSoundManager;
import com.discord.utilities.media.AppSoundManager$Provider;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.n;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: CallSoundManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CallSoundManager {
    public static final CallSoundManager$Companion Companion = new CallSoundManager$Companion(null);
    private static final int JOIN_LEAVE_USER_LIMIT = 25;
    private String activeStreamKey;
    private Long activeStreamUserId;
    private int activeStreamViewerCount;
    private final AppComponent appComponent;
    private final AppSoundManager appSoundManager;
    private int numConnectedParticipants;
    private final CallSoundManager$IStoreStateGenerator storeStateGenerator;
    private Subscription storeStateSubscription;
    private List<Long> streamingUserIds;
    private Long voiceChannelId;

    public CallSoundManager(AppComponent appComponent, AppSoundManager appSoundManager, CallSoundManager$IStoreStateGenerator callSoundManager$IStoreStateGenerator) {
        m.checkNotNullParameter(appComponent, "appComponent");
        m.checkNotNullParameter(appSoundManager, "appSoundManager");
        m.checkNotNullParameter(callSoundManager$IStoreStateGenerator, "storeStateGenerator");
        this.appComponent = appComponent;
        this.appSoundManager = appSoundManager;
        this.storeStateGenerator = callSoundManager$IStoreStateGenerator;
        this.streamingUserIds = n.emptyList();
    }

    public static final /* synthetic */ AppSoundManager access$getAppSoundManager$p(CallSoundManager callSoundManager) {
        return callSoundManager.appSoundManager;
    }

    public static final /* synthetic */ Subscription access$getStoreStateSubscription$p(CallSoundManager callSoundManager) {
        return callSoundManager.storeStateSubscription;
    }

    public static final /* synthetic */ void access$handleStoreState(CallSoundManager callSoundManager, long j, CallSoundManager$StoreState callSoundManager$StoreState) {
        callSoundManager.handleStoreState(j, callSoundManager$StoreState);
    }

    public static final /* synthetic */ void access$setStoreStateSubscription$p(CallSoundManager callSoundManager, Subscription subscription) {
        callSoundManager.storeStateSubscription = subscription;
    }

    @MainThread
    private final void handleStoreState(long channelId, CallSoundManager$StoreState storeState) {
        boolean z2;
        boolean z3;
        boolean z4;
        Channel selectedVoiceChannel;
        StoreApplicationStreaming$ActiveApplicationStream$State state;
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
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Long.valueOf(((ModelApplicationStream) it2.next()).getOwnerId()));
        }
        this.streamingUserIds = arrayList2;
        StoreApplicationStreaming$ActiveApplicationStream activeApplicationStream = storeState.getActiveApplicationStream();
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
        boolean z5 = str2 != null && m.areEqual(str2, str);
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
        if (m.areEqual(this.voiceChannelId, l)) {
            if (z3) {
                this.appSoundManager.play(AppSound.Companion.getSOUND_STREAM_STARTED());
            } else if (z4) {
                this.appSoundManager.play(AppSound.Companion.getSOUND_STREAM_ENDED());
            } else if (z6) {
                this.appSoundManager.play(AppSound.Companion.getSOUND_STREAM_USER_JOINED());
            } else if (z2) {
                this.appSoundManager.play(AppSound.Companion.getSOUND_STREAM_USER_LEFT());
            }
        }
        Map<Long, StoreVoiceParticipants$VoiceUser> voiceParticipants = storeState.getVoiceParticipants();
        boolean zAreEqual = m.areEqual(storeState.getRtcConnectionState(), RtcConnection$State$f.a);
        Collection<StoreVoiceParticipants$VoiceUser> collectionValues2 = voiceParticipants.values();
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : collectionValues2) {
            if (((StoreVoiceParticipants$VoiceUser) obj2).isConnected()) {
                arrayList4.add(obj2);
            }
        }
        this.numConnectedParticipants = arrayList4.size();
        Collection<StoreVoiceParticipants$VoiceUser> collectionValues3 = voiceParticipants.values();
        ArrayList arrayList5 = new ArrayList();
        for (Object obj3 : collectionValues3) {
            if (((StoreVoiceParticipants$VoiceUser) obj3).isRinging()) {
                arrayList5.add(obj3);
            }
        }
        int size2 = arrayList5.size();
        if (zAreEqual && (selectedVoiceChannel = storeState.getSelectedVoiceChannel()) != null && ChannelUtils.K(selectedVoiceChannel) && i2 <= 25) {
            int i3 = this.numConnectedParticipants;
            if (i3 > i2) {
                this.appSoundManager.play(AppSound.Companion.getSOUND_USER_JOINED());
            } else if (i3 < i2) {
                this.appSoundManager.play(AppSound.Companion.getSOUND_USER_LEFT());
            }
        }
        if (this.numConnectedParticipants < 2 && size2 > 0) {
            AppSoundManager appSoundManager = this.appSoundManager;
            AppSound$Companion appSound$Companion = AppSound.Companion;
            if (!appSoundManager.isPlaying(appSound$Companion.getSOUND_CALL_CALLING()) && zAreEqual) {
                this.appSoundManager.play(appSound$Companion.getSOUND_CALL_CALLING());
                return;
            }
        }
        if (!zAreEqual || size2 == 0 || this.numConnectedParticipants >= 2) {
            this.appSoundManager.stop(AppSound.Companion.getSOUND_CALL_CALLING());
        }
    }

    public final void subscribeToStoreState(long voiceChannelId) {
        Subscription subscription = this.storeStateSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Observable<CallSoundManager$StoreState> observableR = this.storeStateGenerator.observeStoreState(voiceChannelId).r();
        m.checkNotNullExpressionValue(observableR, "storeStateGenerator\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this.appComponent, null, 2, null), CallSoundManager.class, (Context) null, new CallSoundManager$subscribeToStoreState$1(this), (Function1) null, new CallSoundManager$subscribeToStoreState$2(this), (Function0) null, new CallSoundManager$subscribeToStoreState$3(this, voiceChannelId), 42, (Object) null);
    }

    public /* synthetic */ CallSoundManager(AppComponent appComponent, AppSoundManager appSoundManager, CallSoundManager$IStoreStateGenerator callSoundManager$IStoreStateGenerator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appComponent, (i & 2) != 0 ? AppSoundManager$Provider.INSTANCE.get() : appSoundManager, (i & 4) != 0 ? new CallSoundManager$StoreStateGenerator(null, null, null, null, null, 31, null) : callSoundManager$IStoreStateGenerator);
    }
}
