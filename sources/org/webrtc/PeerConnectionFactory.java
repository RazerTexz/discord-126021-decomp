package org.webrtc;

import android.content.Context;
import android.os.Process;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PeerConnectionFactory {
    private static final String TAG = "PeerConnectionFactory";
    public static final String TRIAL_ENABLED = "Enabled";
    private static final String VIDEO_CAPTURER_THREAD_NAME = "VideoCapturerThread";

    @Deprecated
    public static final String VIDEO_FRAME_EMIT_TRIAL = "VideoFrameEmit";
    private static volatile boolean internalTracerInitialized;

    @Nullable
    private static PeerConnectionFactory$ThreadInfo staticNetworkThread;

    @Nullable
    private static PeerConnectionFactory$ThreadInfo staticSignalingThread;

    @Nullable
    private static PeerConnectionFactory$ThreadInfo staticWorkerThread;
    private long nativeFactory;

    @Nullable
    private volatile PeerConnectionFactory$ThreadInfo networkThread;

    @Nullable
    private volatile PeerConnectionFactory$ThreadInfo signalingThread;

    @Nullable
    private volatile PeerConnectionFactory$ThreadInfo workerThread;

    @CalledByNative
    public PeerConnectionFactory(long j) {
        checkInitializeHasBeenCalled();
        if (j == 0) {
            throw new RuntimeException("Failed to initialize PeerConnectionFactory!");
        }
        this.nativeFactory = j;
    }

    public static /* synthetic */ void access$100() {
        checkInitializeHasBeenCalled();
    }

    public static /* synthetic */ PeerConnectionFactory access$200(Context context, PeerConnectionFactory$Options peerConnectionFactory$Options, long j, long j2, long j3, VideoEncoderFactory videoEncoderFactory, VideoDecoderFactory videoDecoderFactory, long j4, long j5, long j6, long j7, long j8) {
        return nativeCreatePeerConnectionFactory(context, peerConnectionFactory$Options, j, j2, j3, videoEncoderFactory, videoDecoderFactory, j4, j5, j6, j7, j8);
    }

    public static PeerConnectionFactory$Builder builder() {
        return new PeerConnectionFactory$Builder(null);
    }

    private static void checkInitializeHasBeenCalled() {
        if (!NativeLibrary.isLoaded() || ContextUtils.getApplicationContext() == null) {
            throw new IllegalStateException("PeerConnectionFactory.initialize was not called before creating a PeerConnectionFactory.");
        }
    }

    private void checkPeerConnectionFactoryExists() {
        if (this.nativeFactory == 0) {
            throw new IllegalStateException("PeerConnectionFactory has been disposed.");
        }
    }

    public static String fieldTrialsFindFullName(String str) {
        return NativeLibrary.isLoaded() ? nativeFindFieldTrialsFullName(str) : "";
    }

    public static void initialize(PeerConnectionFactory$InitializationOptions peerConnectionFactory$InitializationOptions) {
        ContextUtils.initialize(peerConnectionFactory$InitializationOptions.applicationContext);
        NativeLibrary.initialize(peerConnectionFactory$InitializationOptions.nativeLibraryLoader, peerConnectionFactory$InitializationOptions.nativeLibraryName);
        nativeInitializeAndroidGlobals();
        nativeInitializeFieldTrials(peerConnectionFactory$InitializationOptions.fieldTrials);
        if (peerConnectionFactory$InitializationOptions.enableInternalTracer && !internalTracerInitialized) {
            initializeInternalTracer();
        }
        Loggable loggable = peerConnectionFactory$InitializationOptions.loggable;
        if (loggable != null) {
            Logging.injectLoggable(loggable, peerConnectionFactory$InitializationOptions.loggableSeverity);
            nativeInjectLoggable(new JNILogging(peerConnectionFactory$InitializationOptions.loggable), peerConnectionFactory$InitializationOptions.loggableSeverity.ordinal());
        } else {
            Logging.d(TAG, "PeerConnectionFactory was initialized without an injected Loggable. Any existing Loggable will be deleted.");
            Logging.deleteInjectedLoggable();
            nativeDeleteLoggable();
        }
    }

    @Deprecated
    public static void initializeFieldTrials(String str) {
        nativeInitializeFieldTrials(str);
    }

    private static void initializeInternalTracer() {
        internalTracerInitialized = true;
        nativeInitializeInternalTracer();
    }

    private static native long nativeCreateAudioSource(long j, MediaConstraints mediaConstraints);

    private static native long nativeCreateAudioTrack(long j, String str, long j2);

    private static native long nativeCreateLocalMediaStream(long j, String str);

    private static native long nativeCreatePeerConnection(long j, PeerConnection$RTCConfiguration peerConnection$RTCConfiguration, MediaConstraints mediaConstraints, long j2, SSLCertificateVerifier sSLCertificateVerifier);

    private static native PeerConnectionFactory nativeCreatePeerConnectionFactory(Context context, PeerConnectionFactory$Options peerConnectionFactory$Options, long j, long j2, long j3, VideoEncoderFactory videoEncoderFactory, VideoDecoderFactory videoDecoderFactory, long j4, long j5, long j6, long j7, long j8);

    private static native long nativeCreateVideoSource(long j, boolean z2, boolean z3);

    private static native long nativeCreateVideoTrack(long j, String str, long j2);

    private static native void nativeDeleteLoggable();

    private static native String nativeFindFieldTrialsFullName(String str);

    private static native void nativeFreeFactory(long j);

    private static native long nativeGetNativePeerConnectionFactory(long j);

    private static native void nativeInitializeAndroidGlobals();

    private static native void nativeInitializeFieldTrials(String str);

    private static native void nativeInitializeInternalTracer();

    private static native void nativeInjectLoggable(JNILogging jNILogging, int i);

    private static native void nativePrintStackTrace(int i);

    private static native void nativePrintStackTracesOfRegisteredThreads();

    private static native void nativeShutdownInternalTracer();

    private static native boolean nativeStartAecDump(long j, int i, int i2);

    private static native boolean nativeStartInternalTracingCapture(String str);

    private static native void nativeStopAecDump(long j);

    private static native void nativeStopInternalTracingCapture();

    @CalledByNative
    private void onNetworkThreadReady() {
        this.networkThread = PeerConnectionFactory$ThreadInfo.getCurrent();
        staticNetworkThread = this.networkThread;
        Logging.d(TAG, "onNetworkThreadReady");
    }

    @CalledByNative
    private void onSignalingThreadReady() {
        this.signalingThread = PeerConnectionFactory$ThreadInfo.getCurrent();
        staticSignalingThread = this.signalingThread;
        Logging.d(TAG, "onSignalingThreadReady");
    }

    @CalledByNative
    private void onWorkerThreadReady() {
        this.workerThread = PeerConnectionFactory$ThreadInfo.getCurrent();
        staticWorkerThread = this.workerThread;
        Logging.d(TAG, "onWorkerThreadReady");
    }

    private static void printStackTrace(@Nullable PeerConnectionFactory$ThreadInfo peerConnectionFactory$ThreadInfo, boolean z2) {
        if (peerConnectionFactory$ThreadInfo == null) {
            return;
        }
        String name = peerConnectionFactory$ThreadInfo.thread.getName();
        StackTraceElement[] stackTrace = peerConnectionFactory$ThreadInfo.thread.getStackTrace();
        if (stackTrace.length > 0) {
            Logging.w(TAG, name + " stacktrace:");
            for (StackTraceElement stackTraceElement : stackTrace) {
                Logging.w(TAG, stackTraceElement.toString());
            }
        }
        if (z2) {
            Logging.w(TAG, "*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***");
            Logging.w(TAG, "pid: " + Process.myPid() + ", tid: " + peerConnectionFactory$ThreadInfo.tid + ", name: " + name + "  >>> WebRTC <<<");
            nativePrintStackTrace(peerConnectionFactory$ThreadInfo.tid);
        }
    }

    @Deprecated
    public static void printStackTraces() {
        printStackTrace(staticNetworkThread, false);
        printStackTrace(staticWorkerThread, false);
        printStackTrace(staticSignalingThread, false);
    }

    public static void shutdownInternalTracer() {
        internalTracerInitialized = false;
        nativeShutdownInternalTracer();
    }

    public static boolean startInternalTracingCapture(String str) {
        return nativeStartInternalTracingCapture(str);
    }

    public static void stopInternalTracingCapture() {
        nativeStopInternalTracingCapture();
    }

    public AudioSource createAudioSource(MediaConstraints mediaConstraints) {
        checkPeerConnectionFactoryExists();
        return new AudioSource(nativeCreateAudioSource(this.nativeFactory, mediaConstraints));
    }

    public AudioTrack createAudioTrack(String str, AudioSource audioSource) {
        checkPeerConnectionFactoryExists();
        return new AudioTrack(nativeCreateAudioTrack(this.nativeFactory, str, audioSource.getNativeAudioSource()));
    }

    public MediaStream createLocalMediaStream(String str) {
        checkPeerConnectionFactoryExists();
        return new MediaStream(nativeCreateLocalMediaStream(this.nativeFactory, str));
    }

    @Nullable
    @Deprecated
    public PeerConnection createPeerConnection(PeerConnection$RTCConfiguration peerConnection$RTCConfiguration, MediaConstraints mediaConstraints, PeerConnection$Observer peerConnection$Observer) {
        return createPeerConnectionInternal(peerConnection$RTCConfiguration, mediaConstraints, peerConnection$Observer, null);
    }

    @Nullable
    public PeerConnection createPeerConnectionInternal(PeerConnection$RTCConfiguration peerConnection$RTCConfiguration, MediaConstraints mediaConstraints, PeerConnection$Observer peerConnection$Observer, SSLCertificateVerifier sSLCertificateVerifier) {
        checkPeerConnectionFactoryExists();
        long jCreateNativePeerConnectionObserver = PeerConnection.createNativePeerConnectionObserver(peerConnection$Observer);
        if (jCreateNativePeerConnectionObserver == 0) {
            return null;
        }
        long jNativeCreatePeerConnection = nativeCreatePeerConnection(this.nativeFactory, peerConnection$RTCConfiguration, mediaConstraints, jCreateNativePeerConnectionObserver, sSLCertificateVerifier);
        if (jNativeCreatePeerConnection == 0) {
            return null;
        }
        return new PeerConnection(jNativeCreatePeerConnection);
    }

    public VideoSource createVideoSource(boolean z2, boolean z3) {
        checkPeerConnectionFactoryExists();
        return new VideoSource(nativeCreateVideoSource(this.nativeFactory, z2, z3));
    }

    public VideoTrack createVideoTrack(String str, VideoSource videoSource) {
        checkPeerConnectionFactoryExists();
        return new VideoTrack(nativeCreateVideoTrack(this.nativeFactory, str, videoSource.getNativeVideoTrackSource()));
    }

    public void dispose() {
        checkPeerConnectionFactoryExists();
        nativeFreeFactory(this.nativeFactory);
        this.networkThread = null;
        this.workerThread = null;
        this.signalingThread = null;
        this.nativeFactory = 0L;
    }

    public long getNativeOwnedFactoryAndThreads() {
        checkPeerConnectionFactoryExists();
        return this.nativeFactory;
    }

    public long getNativePeerConnectionFactory() {
        checkPeerConnectionFactoryExists();
        return nativeGetNativePeerConnectionFactory(this.nativeFactory);
    }

    public void printInternalStackTraces(boolean z2) {
        printStackTrace(this.signalingThread, z2);
        printStackTrace(this.workerThread, z2);
        printStackTrace(this.networkThread, z2);
        if (z2) {
            nativePrintStackTracesOfRegisteredThreads();
        }
    }

    public boolean startAecDump(int i, int i2) {
        checkPeerConnectionFactoryExists();
        return nativeStartAecDump(this.nativeFactory, i, i2);
    }

    public void stopAecDump() {
        checkPeerConnectionFactoryExists();
        nativeStopAecDump(this.nativeFactory);
    }

    @Nullable
    @Deprecated
    public PeerConnection createPeerConnection(List<PeerConnection$IceServer> list, MediaConstraints mediaConstraints, PeerConnection$Observer peerConnection$Observer) {
        return createPeerConnection(new PeerConnection$RTCConfiguration(list), mediaConstraints, peerConnection$Observer);
    }

    public VideoSource createVideoSource(boolean z2) {
        return createVideoSource(z2, true);
    }

    @Nullable
    public PeerConnection createPeerConnection(List<PeerConnection$IceServer> list, PeerConnection$Observer peerConnection$Observer) {
        return createPeerConnection(new PeerConnection$RTCConfiguration(list), peerConnection$Observer);
    }

    @Nullable
    public PeerConnection createPeerConnection(PeerConnection$RTCConfiguration peerConnection$RTCConfiguration, PeerConnection$Observer peerConnection$Observer) {
        return createPeerConnection(peerConnection$RTCConfiguration, (MediaConstraints) null, peerConnection$Observer);
    }

    @Nullable
    public PeerConnection createPeerConnection(PeerConnection$RTCConfiguration peerConnection$RTCConfiguration, PeerConnectionDependencies peerConnectionDependencies) {
        return createPeerConnectionInternal(peerConnection$RTCConfiguration, null, peerConnectionDependencies.getObserver(), peerConnectionDependencies.getSSLCertificateVerifier());
    }
}
