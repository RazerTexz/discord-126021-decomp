package org.webrtc;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.Objects;
import org.webrtc.audio.AudioDeviceModule;
import org.webrtc.audio.JavaAudioDeviceModule;

/* JADX INFO: loaded from: classes3.dex */
public class PeerConnectionFactory$Builder {
    private AudioDecoderFactoryFactory audioDecoderFactoryFactory;

    @Nullable
    private AudioDeviceModule audioDeviceModule;
    private AudioEncoderFactoryFactory audioEncoderFactoryFactory;

    @Nullable
    private AudioProcessingFactory audioProcessingFactory;

    @Nullable
    private FecControllerFactoryFactoryInterface fecControllerFactoryFactory;

    @Nullable
    private NetEqFactoryFactory neteqFactoryFactory;

    @Nullable
    private NetworkControllerFactoryFactory networkControllerFactoryFactory;

    @Nullable
    private NetworkStatePredictorFactoryFactory networkStatePredictorFactoryFactory;

    @Nullable
    private PeerConnectionFactory$Options options;

    @Nullable
    private VideoDecoderFactory videoDecoderFactory;

    @Nullable
    private VideoEncoderFactory videoEncoderFactory;

    public /* synthetic */ PeerConnectionFactory$Builder(PeerConnectionFactory$1 peerConnectionFactory$1) {
        this();
    }

    public PeerConnectionFactory createPeerConnectionFactory() {
        PeerConnectionFactory.access$100();
        if (this.audioDeviceModule == null) {
            this.audioDeviceModule = JavaAudioDeviceModule.builder(ContextUtils.getApplicationContext()).createAudioDeviceModule();
        }
        Context applicationContext = ContextUtils.getApplicationContext();
        PeerConnectionFactory$Options peerConnectionFactory$Options = this.options;
        long nativeAudioDeviceModulePointer = this.audioDeviceModule.getNativeAudioDeviceModulePointer();
        long jCreateNativeAudioEncoderFactory = this.audioEncoderFactoryFactory.createNativeAudioEncoderFactory();
        long jCreateNativeAudioDecoderFactory = this.audioDecoderFactoryFactory.createNativeAudioDecoderFactory();
        VideoEncoderFactory videoEncoderFactory = this.videoEncoderFactory;
        VideoDecoderFactory videoDecoderFactory = this.videoDecoderFactory;
        AudioProcessingFactory audioProcessingFactory = this.audioProcessingFactory;
        long jCreateNative = audioProcessingFactory == null ? 0L : audioProcessingFactory.createNative();
        FecControllerFactoryFactoryInterface fecControllerFactoryFactoryInterface = this.fecControllerFactoryFactory;
        long jCreateNative2 = fecControllerFactoryFactoryInterface == null ? 0L : fecControllerFactoryFactoryInterface.createNative();
        NetworkControllerFactoryFactory networkControllerFactoryFactory = this.networkControllerFactoryFactory;
        long jCreateNativeNetworkControllerFactory = networkControllerFactoryFactory == null ? 0L : networkControllerFactoryFactory.createNativeNetworkControllerFactory();
        NetworkStatePredictorFactoryFactory networkStatePredictorFactoryFactory = this.networkStatePredictorFactoryFactory;
        long jCreateNativeNetworkStatePredictorFactory = networkStatePredictorFactoryFactory == null ? 0L : networkStatePredictorFactoryFactory.createNativeNetworkStatePredictorFactory();
        NetEqFactoryFactory netEqFactoryFactory = this.neteqFactoryFactory;
        return PeerConnectionFactory.access$200(applicationContext, peerConnectionFactory$Options, nativeAudioDeviceModulePointer, jCreateNativeAudioEncoderFactory, jCreateNativeAudioDecoderFactory, videoEncoderFactory, videoDecoderFactory, jCreateNative, jCreateNative2, jCreateNativeNetworkControllerFactory, jCreateNativeNetworkStatePredictorFactory, netEqFactoryFactory != null ? netEqFactoryFactory.createNativeNetEqFactory() : 0L);
    }

    public PeerConnectionFactory$Builder setAudioDecoderFactoryFactory(AudioDecoderFactoryFactory audioDecoderFactoryFactory) {
        if (audioDecoderFactoryFactory == null) {
            throw new IllegalArgumentException("PeerConnectionFactory.Builder does not accept a null AudioDecoderFactoryFactory.");
        }
        this.audioDecoderFactoryFactory = audioDecoderFactoryFactory;
        return this;
    }

    public PeerConnectionFactory$Builder setAudioDeviceModule(AudioDeviceModule audioDeviceModule) {
        this.audioDeviceModule = audioDeviceModule;
        return this;
    }

    public PeerConnectionFactory$Builder setAudioEncoderFactoryFactory(AudioEncoderFactoryFactory audioEncoderFactoryFactory) {
        if (audioEncoderFactoryFactory == null) {
            throw new IllegalArgumentException("PeerConnectionFactory.Builder does not accept a null AudioEncoderFactoryFactory.");
        }
        this.audioEncoderFactoryFactory = audioEncoderFactoryFactory;
        return this;
    }

    public PeerConnectionFactory$Builder setAudioProcessingFactory(AudioProcessingFactory audioProcessingFactory) {
        Objects.requireNonNull(audioProcessingFactory, "PeerConnectionFactory builder does not accept a null AudioProcessingFactory.");
        this.audioProcessingFactory = audioProcessingFactory;
        return this;
    }

    public PeerConnectionFactory$Builder setFecControllerFactoryFactoryInterface(FecControllerFactoryFactoryInterface fecControllerFactoryFactoryInterface) {
        this.fecControllerFactoryFactory = fecControllerFactoryFactoryInterface;
        return this;
    }

    public PeerConnectionFactory$Builder setNetEqFactoryFactory(NetEqFactoryFactory netEqFactoryFactory) {
        this.neteqFactoryFactory = netEqFactoryFactory;
        return this;
    }

    public PeerConnectionFactory$Builder setNetworkControllerFactoryFactory(NetworkControllerFactoryFactory networkControllerFactoryFactory) {
        this.networkControllerFactoryFactory = networkControllerFactoryFactory;
        return this;
    }

    public PeerConnectionFactory$Builder setNetworkStatePredictorFactoryFactory(NetworkStatePredictorFactoryFactory networkStatePredictorFactoryFactory) {
        this.networkStatePredictorFactoryFactory = networkStatePredictorFactoryFactory;
        return this;
    }

    public PeerConnectionFactory$Builder setOptions(PeerConnectionFactory$Options peerConnectionFactory$Options) {
        this.options = peerConnectionFactory$Options;
        return this;
    }

    public PeerConnectionFactory$Builder setVideoDecoderFactory(VideoDecoderFactory videoDecoderFactory) {
        this.videoDecoderFactory = videoDecoderFactory;
        return this;
    }

    public PeerConnectionFactory$Builder setVideoEncoderFactory(VideoEncoderFactory videoEncoderFactory) {
        this.videoEncoderFactory = videoEncoderFactory;
        return this;
    }

    private PeerConnectionFactory$Builder() {
        this.audioEncoderFactoryFactory = new BuiltinAudioEncoderFactoryFactory();
        this.audioDecoderFactoryFactory = new BuiltinAudioDecoderFactoryFactory();
    }
}
