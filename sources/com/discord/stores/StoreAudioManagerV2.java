package com.discord.stores;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.discord.rtcconnection.RtcConnection$State;
import com.discord.rtcconnection.RtcConnection$State$d;
import com.discord.rtcconnection.RtcConnection$State$f;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import com.discord.rtcconnection.audio.DiscordAudioManager$AudioDevice;
import com.discord.rtcconnection.audio.DiscordAudioManager$DeviceTypes;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.utilities.voice.PerceptualVolumeUtils;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rx.Observable;

/* JADX INFO: compiled from: StoreAudioManagerV2.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAudioManagerV2 extends StoreV2 {
    public static final StoreAudioManagerV2$Companion Companion = new StoreAudioManagerV2$Companion(null);
    private static final StoreAudioManagerV2$State DEFAULT_STATE;
    private Handler audioManagerHandler;
    private final HandlerThread audioManagerThread;
    private final StoreChannels channelsStore;
    private Context context;
    private final Dispatcher dispatcher;
    private final StoreExperiments experimentsStore;
    private DiscordAudioManager$AudioDevice lastActiveAudioDevice;
    private final ObservationDeck observationDeck;
    private boolean prevMyVideoOn;
    private StoreAudioManagerV2$State state;
    private StoreAudioManagerV2$State stateSnapshot;
    private final StoreStreamRtcConnection streamRtcConnectionStore;
    private final StoreAudioManagerV2$VideoUseDetector videoUseDetector;
    private final StoreVoiceChannelSelected voiceChannelSelectedStore;

    static {
        DiscordAudioManager discordAudioManager = DiscordAudioManager.d;
        DEFAULT_STATE = new StoreAudioManagerV2$State(DiscordAudioManager.f(), DiscordAudioManager$DeviceTypes.EARPIECE);
    }

    public StoreAudioManagerV2(ObservationDeck observationDeck, Dispatcher dispatcher, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreChannels storeChannels, StoreStreamRtcConnection storeStreamRtcConnection, StoreAudioManagerV2$VideoUseDetector storeAudioManagerV2$VideoUseDetector, StoreExperiments storeExperiments) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelectedStore");
        m.checkNotNullParameter(storeChannels, "channelsStore");
        m.checkNotNullParameter(storeStreamRtcConnection, "streamRtcConnectionStore");
        m.checkNotNullParameter(storeAudioManagerV2$VideoUseDetector, "videoUseDetector");
        m.checkNotNullParameter(storeExperiments, "experimentsStore");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.voiceChannelSelectedStore = storeVoiceChannelSelected;
        this.channelsStore = storeChannels;
        this.streamRtcConnectionStore = storeStreamRtcConnection;
        this.videoUseDetector = storeAudioManagerV2$VideoUseDetector;
        this.experimentsStore = storeExperiments;
        StoreAudioManagerV2$State storeAudioManagerV2$State = new StoreAudioManagerV2$State(null, null, 3, null);
        this.state = storeAudioManagerV2$State;
        this.stateSnapshot = storeAudioManagerV2$State;
        DiscordAudioManager discordAudioManager = DiscordAudioManager.d;
        this.lastActiveAudioDevice = DiscordAudioManager.f2784b;
        this.audioManagerThread = new HandlerThread("AudioManagerThread", -1);
    }

    public static final /* synthetic */ StoreAudioManagerV2$State access$getAudioManagerState(StoreAudioManagerV2 storeAudioManagerV2) {
        return storeAudioManagerV2.getStateSnapshot();
    }

    public static final /* synthetic */ StoreAudioManagerV2$State access$getDEFAULT_STATE$cp() {
        return DEFAULT_STATE;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreAudioManagerV2 storeAudioManagerV2) {
        return storeAudioManagerV2.dispatcher;
    }

    public static final /* synthetic */ void access$updateActiveAudioDevice(StoreAudioManagerV2 storeAudioManagerV2, DiscordAudioManager$DeviceTypes discordAudioManager$DeviceTypes) {
        storeAudioManagerV2.updateActiveAudioDevice(discordAudioManager$DeviceTypes);
    }

    public static final /* synthetic */ void access$updateAudioDevices(StoreAudioManagerV2 storeAudioManagerV2, List list) {
        storeAudioManagerV2.updateAudioDevices(list);
    }

    public static final /* synthetic */ void access$updateCurrentMediaVolume(StoreAudioManagerV2 storeAudioManagerV2, int i) {
        storeAudioManagerV2.updateCurrentMediaVolume(i);
    }

    /* JADX INFO: renamed from: getAudioManagerState, reason: from getter */
    private final StoreAudioManagerV2$State getStateSnapshot() {
        return this.stateSnapshot;
    }

    @StoreThread
    private final void updateActiveAudioDevice(DiscordAudioManager$DeviceTypes device) {
        StoreAudioManagerV2$State storeAudioManagerV2$StateCopy$default = StoreAudioManagerV2$State.copy$default(this.state, null, device, 1, null);
        this.state = storeAudioManagerV2$StateCopy$default;
        if (device != DiscordAudioManager$DeviceTypes.INVALID && device != DiscordAudioManager$DeviceTypes.DEFAULT) {
            this.lastActiveAudioDevice = storeAudioManagerV2$StateCopy$default.getAudioDevices().get(device.getValue());
        }
        markChanged();
    }

    @StoreThread
    private final void updateAudioDevices(List<DiscordAudioManager$AudioDevice> devices) {
        this.state = StoreAudioManagerV2$State.copy$default(this.state, devices, null, 2, null);
        markChanged();
    }

    private final void updateCurrentMediaVolume(int currentMediaVolumeIndex) {
        DiscordAudioManager discordAudioManager = DiscordAudioManager.d;
        this.streamRtcConnectionStore.updateStreamVolume(PerceptualVolumeUtils.INSTANCE.perceptualToAmplitude((currentMediaVolumeIndex / DiscordAudioManager.d().f2786x) * 300.0f, 300.0f));
    }

    /* JADX INFO: renamed from: getLastActiveAudioDevice$app_productionGoogleRelease, reason: from getter */
    public final DiscordAudioManager$AudioDevice getLastActiveAudioDevice() {
        return this.lastActiveAudioDevice;
    }

    /* JADX INFO: renamed from: getState$app_productionGoogleRelease, reason: from getter */
    public final StoreAudioManagerV2$State getState() {
        return this.state;
    }

    @StoreThread
    public final void handleRtcConnectionState(RtcConnection$State state) {
        m.checkNotNullParameter(state, "state");
        if (m.areEqual(state, RtcConnection$State$f.a)) {
            Handler handler = this.audioManagerHandler;
            if (handler == null) {
                m.throwUninitializedPropertyAccessException("audioManagerHandler");
            }
            handler.post(StoreAudioManagerV2$handleRtcConnectionState$1.INSTANCE);
            return;
        }
        if (!(state instanceof RtcConnection$State$d) || ((RtcConnection$State$d) state).a) {
            return;
        }
        Handler handler2 = this.audioManagerHandler;
        if (handler2 == null) {
            m.throwUninitializedPropertyAccessException("audioManagerHandler");
        }
        handler2.post(StoreAudioManagerV2$handleRtcConnectionState$2.INSTANCE);
    }

    @StoreThread
    public final void handleVoiceStatesUpdated() {
        boolean zIsMyVideoOn = this.videoUseDetector.isMyVideoOn(this.voiceChannelSelectedStore.getSelectedVoiceChannelId());
        if (zIsMyVideoOn == this.prevMyVideoOn) {
            return;
        }
        if (zIsMyVideoOn) {
            DiscordAudioManager discordAudioManager = DiscordAudioManager.d;
            DiscordAudioManager discordAudioManagerD = DiscordAudioManager.d();
            synchronized (discordAudioManagerD) {
                if (discordAudioManagerD.r.get(DiscordAudioManager$DeviceTypes.EARPIECE.getValue()).isAvailable) {
                    List<DiscordAudioManager$AudioDevice> list = discordAudioManagerD.r;
                    ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
                    for (DiscordAudioManager$AudioDevice discordAudioManager$AudioDevice : list) {
                        arrayList.add(discordAudioManager$AudioDevice.type.ordinal() != 4 ? DiscordAudioManager$AudioDevice.a(discordAudioManager$AudioDevice, null, false, null, null, 15) : DiscordAudioManager$AudioDevice.a(discordAudioManager$AudioDevice, null, false, null, null, 13));
                    }
                    discordAudioManagerD.r = arrayList;
                    discordAudioManagerD.f2785s.k.onNext(arrayList);
                    discordAudioManagerD.l();
                }
            }
        } else {
            DiscordAudioManager discordAudioManager2 = DiscordAudioManager.d;
            DiscordAudioManager discordAudioManagerD2 = DiscordAudioManager.d();
            synchronized (discordAudioManagerD2) {
                if (discordAudioManagerD2.r.get(DiscordAudioManager$DeviceTypes.EARPIECE.getValue()).isAvailable != discordAudioManagerD2.h) {
                    List<DiscordAudioManager$AudioDevice> list2 = discordAudioManagerD2.r;
                    ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(list2, 10));
                    for (DiscordAudioManager$AudioDevice discordAudioManager$AudioDevice2 : list2) {
                        arrayList2.add(discordAudioManager$AudioDevice2.type.ordinal() != 4 ? DiscordAudioManager$AudioDevice.a(discordAudioManager$AudioDevice2, null, false, null, null, 15) : DiscordAudioManager$AudioDevice.a(discordAudioManager$AudioDevice2, null, discordAudioManagerD2.h, null, null, 13));
                    }
                    discordAudioManagerD2.r = arrayList2;
                    discordAudioManagerD2.f2785s.k.onNext(arrayList2);
                    discordAudioManagerD2.l();
                }
            }
        }
        this.prevMyVideoOn = zIsMyVideoOn;
    }

    public final void init(Application context) {
        m.checkNotNullParameter(context, "context");
        this.context = context;
        if (!this.audioManagerThread.isAlive()) {
            this.audioManagerThread.start();
        }
        Handler handler = new Handler(this.audioManagerThread.getLooper());
        this.audioManagerHandler = handler;
        if (handler == null) {
            m.throwUninitializedPropertyAccessException("audioManagerHandler");
        }
        handler.post(new StoreAudioManagerV2$init$1(this));
    }

    public final Observable<StoreAudioManagerV2$State> observeAudioManagerState() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreAudioManagerV2$observeAudioManagerState$1(this), 14, null);
    }

    public final void selectOutputDevice(DiscordAudioManager$DeviceTypes device) {
        m.checkNotNullParameter(device, "device");
        Handler handler = this.audioManagerHandler;
        if (handler == null) {
            m.throwUninitializedPropertyAccessException("audioManagerHandler");
        }
        handler.post(new StoreAudioManagerV2$selectOutputDevice$1(device));
    }

    public final void setState$app_productionGoogleRelease(StoreAudioManagerV2$State storeAudioManagerV2$State) {
        m.checkNotNullParameter(storeAudioManagerV2$State, "<set-?>");
        this.state = storeAudioManagerV2$State;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        List<DiscordAudioManager$AudioDevice> audioDevices = this.state.getAudioDevices();
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(audioDevices, 10));
        Iterator<T> it = audioDevices.iterator();
        while (it.hasNext()) {
            arrayList.add(DiscordAudioManager$AudioDevice.a((DiscordAudioManager$AudioDevice) it.next(), null, false, null, null, 15));
        }
        this.stateSnapshot = this.state.copy(arrayList, this.state.getActiveAudioDevice());
    }

    public final void toggleSpeakerOutput() {
        this.dispatcher.schedule(new StoreAudioManagerV2$toggleSpeakerOutput$1(this));
    }

    public final void updateMediaVolume(float ratio) {
        Handler handler = this.audioManagerHandler;
        if (handler == null) {
            m.throwUninitializedPropertyAccessException("audioManagerHandler");
        }
        handler.post(new StoreAudioManagerV2$updateMediaVolume$1(ratio));
    }
}
