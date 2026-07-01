package org.webrtc;

import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PeerConnection$RTCConfiguration {

    @Nullable
    public RtcCertificatePem certificate;
    public List<PeerConnection$IceServer> iceServers;

    @Nullable
    public TurnCustomizer turnCustomizer;
    public PeerConnection$IceTransportsType iceTransportsType = PeerConnection$IceTransportsType.ALL;
    public PeerConnection$BundlePolicy bundlePolicy = PeerConnection$BundlePolicy.BALANCED;
    public PeerConnection$RtcpMuxPolicy rtcpMuxPolicy = PeerConnection$RtcpMuxPolicy.REQUIRE;
    public PeerConnection$TcpCandidatePolicy tcpCandidatePolicy = PeerConnection$TcpCandidatePolicy.ENABLED;
    public PeerConnection$CandidateNetworkPolicy candidateNetworkPolicy = PeerConnection$CandidateNetworkPolicy.ALL;
    public int audioJitterBufferMaxPackets = 50;
    public boolean audioJitterBufferFastAccelerate = false;
    public int iceConnectionReceivingTimeout = -1;
    public int iceBackupCandidatePairPingInterval = -1;
    public PeerConnection$KeyType keyType = PeerConnection$KeyType.ECDSA;
    public PeerConnection$ContinualGatheringPolicy continualGatheringPolicy = PeerConnection$ContinualGatheringPolicy.GATHER_ONCE;
    public int iceCandidatePoolSize = 0;

    @Deprecated
    public boolean pruneTurnPorts = false;
    public PeerConnection$PortPrunePolicy turnPortPrunePolicy = PeerConnection$PortPrunePolicy.NO_PRUNE;
    public boolean presumeWritableWhenFullyRelayed = false;
    public boolean surfaceIceCandidatesOnIceTransportTypeChanged = false;

    @Nullable
    public Integer iceCheckIntervalStrongConnectivityMs = null;

    @Nullable
    public Integer iceCheckIntervalWeakConnectivityMs = null;

    @Nullable
    public Integer iceCheckMinInterval = null;

    @Nullable
    public Integer iceUnwritableTimeMs = null;

    @Nullable
    public Integer iceUnwritableMinChecks = null;

    @Nullable
    public Integer stunCandidateKeepaliveIntervalMs = null;
    public boolean disableIPv6OnWifi = false;
    public int maxIPv6Networks = 5;
    public boolean disableIpv6 = false;
    public boolean enableDscp = false;
    public boolean enableCpuOveruseDetection = true;
    public boolean enableRtpDataChannel = false;
    public boolean suspendBelowMinBitrate = false;

    @Nullable
    public Integer screencastMinBitrate = null;

    @Nullable
    public Boolean combinedAudioVideoBwe = null;

    @Nullable
    public Boolean enableDtlsSrtp = null;
    public PeerConnection$AdapterType networkPreference = PeerConnection$AdapterType.UNKNOWN;
    public PeerConnection$SdpSemantics sdpSemantics = PeerConnection$SdpSemantics.PLAN_B;
    public boolean activeResetSrtpParams = false;

    @Nullable
    public CryptoOptions cryptoOptions = null;

    @Nullable
    public String turnLoggingId = null;

    @Nullable
    public Boolean allowCodecSwitching = null;

    public PeerConnection$RTCConfiguration(List<PeerConnection$IceServer> list) {
        this.iceServers = list;
    }

    @CalledByNative("RTCConfiguration")
    public boolean getActiveResetSrtpParams() {
        return this.activeResetSrtpParams;
    }

    @Nullable
    @CalledByNative("RTCConfiguration")
    public Boolean getAllowCodecSwitching() {
        return this.allowCodecSwitching;
    }

    @CalledByNative("RTCConfiguration")
    public boolean getAudioJitterBufferFastAccelerate() {
        return this.audioJitterBufferFastAccelerate;
    }

    @CalledByNative("RTCConfiguration")
    public int getAudioJitterBufferMaxPackets() {
        return this.audioJitterBufferMaxPackets;
    }

    @CalledByNative("RTCConfiguration")
    public PeerConnection$BundlePolicy getBundlePolicy() {
        return this.bundlePolicy;
    }

    @CalledByNative("RTCConfiguration")
    public PeerConnection$CandidateNetworkPolicy getCandidateNetworkPolicy() {
        return this.candidateNetworkPolicy;
    }

    @Nullable
    @CalledByNative("RTCConfiguration")
    public RtcCertificatePem getCertificate() {
        return this.certificate;
    }

    @Nullable
    @CalledByNative("RTCConfiguration")
    public Boolean getCombinedAudioVideoBwe() {
        return this.combinedAudioVideoBwe;
    }

    @CalledByNative("RTCConfiguration")
    public PeerConnection$ContinualGatheringPolicy getContinualGatheringPolicy() {
        return this.continualGatheringPolicy;
    }

    @Nullable
    @CalledByNative("RTCConfiguration")
    public CryptoOptions getCryptoOptions() {
        return this.cryptoOptions;
    }

    @CalledByNative("RTCConfiguration")
    public boolean getDisableIPv6OnWifi() {
        return this.disableIPv6OnWifi;
    }

    @CalledByNative("RTCConfiguration")
    public boolean getDisableIpv6() {
        return this.disableIpv6;
    }

    @CalledByNative("RTCConfiguration")
    public boolean getEnableCpuOveruseDetection() {
        return this.enableCpuOveruseDetection;
    }

    @CalledByNative("RTCConfiguration")
    public boolean getEnableDscp() {
        return this.enableDscp;
    }

    @Nullable
    @CalledByNative("RTCConfiguration")
    public Boolean getEnableDtlsSrtp() {
        return this.enableDtlsSrtp;
    }

    @CalledByNative("RTCConfiguration")
    public boolean getEnableRtpDataChannel() {
        return this.enableRtpDataChannel;
    }

    @CalledByNative("RTCConfiguration")
    public int getIceBackupCandidatePairPingInterval() {
        return this.iceBackupCandidatePairPingInterval;
    }

    @CalledByNative("RTCConfiguration")
    public int getIceCandidatePoolSize() {
        return this.iceCandidatePoolSize;
    }

    @Nullable
    @CalledByNative("RTCConfiguration")
    public Integer getIceCheckIntervalStrongConnectivity() {
        return this.iceCheckIntervalStrongConnectivityMs;
    }

    @Nullable
    @CalledByNative("RTCConfiguration")
    public Integer getIceCheckIntervalWeakConnectivity() {
        return this.iceCheckIntervalWeakConnectivityMs;
    }

    @Nullable
    @CalledByNative("RTCConfiguration")
    public Integer getIceCheckMinInterval() {
        return this.iceCheckMinInterval;
    }

    @CalledByNative("RTCConfiguration")
    public int getIceConnectionReceivingTimeout() {
        return this.iceConnectionReceivingTimeout;
    }

    @CalledByNative("RTCConfiguration")
    public List<PeerConnection$IceServer> getIceServers() {
        return this.iceServers;
    }

    @CalledByNative("RTCConfiguration")
    public PeerConnection$IceTransportsType getIceTransportsType() {
        return this.iceTransportsType;
    }

    @Nullable
    @CalledByNative("RTCConfiguration")
    public Integer getIceUnwritableMinChecks() {
        return this.iceUnwritableMinChecks;
    }

    @Nullable
    @CalledByNative("RTCConfiguration")
    public Integer getIceUnwritableTimeout() {
        return this.iceUnwritableTimeMs;
    }

    @CalledByNative("RTCConfiguration")
    public PeerConnection$KeyType getKeyType() {
        return this.keyType;
    }

    @CalledByNative("RTCConfiguration")
    public int getMaxIPv6Networks() {
        return this.maxIPv6Networks;
    }

    @CalledByNative("RTCConfiguration")
    public PeerConnection$AdapterType getNetworkPreference() {
        return this.networkPreference;
    }

    @CalledByNative("RTCConfiguration")
    public boolean getPresumeWritableWhenFullyRelayed() {
        return this.presumeWritableWhenFullyRelayed;
    }

    @CalledByNative("RTCConfiguration")
    public boolean getPruneTurnPorts() {
        return this.pruneTurnPorts;
    }

    @CalledByNative("RTCConfiguration")
    public PeerConnection$RtcpMuxPolicy getRtcpMuxPolicy() {
        return this.rtcpMuxPolicy;
    }

    @Nullable
    @CalledByNative("RTCConfiguration")
    public Integer getScreencastMinBitrate() {
        return this.screencastMinBitrate;
    }

    @CalledByNative("RTCConfiguration")
    public PeerConnection$SdpSemantics getSdpSemantics() {
        return this.sdpSemantics;
    }

    @Nullable
    @CalledByNative("RTCConfiguration")
    public Integer getStunCandidateKeepaliveInterval() {
        return this.stunCandidateKeepaliveIntervalMs;
    }

    @CalledByNative("RTCConfiguration")
    public boolean getSurfaceIceCandidatesOnIceTransportTypeChanged() {
        return this.surfaceIceCandidatesOnIceTransportTypeChanged;
    }

    @CalledByNative("RTCConfiguration")
    public boolean getSuspendBelowMinBitrate() {
        return this.suspendBelowMinBitrate;
    }

    @CalledByNative("RTCConfiguration")
    public PeerConnection$TcpCandidatePolicy getTcpCandidatePolicy() {
        return this.tcpCandidatePolicy;
    }

    @Nullable
    @CalledByNative("RTCConfiguration")
    public TurnCustomizer getTurnCustomizer() {
        return this.turnCustomizer;
    }

    @Nullable
    @CalledByNative("RTCConfiguration")
    public String getTurnLoggingId() {
        return this.turnLoggingId;
    }

    @CalledByNative("RTCConfiguration")
    public PeerConnection$PortPrunePolicy getTurnPortPrunePolicy() {
        return this.turnPortPrunePolicy;
    }
}
