package com.discord.rtcconnection.mediaengine;

import androidx.annotation.AnyThread;
import androidx.core.app.FrameMetricsAggregator;
import co.discord.media_engine.RtcRegion;
import co.discord.media_engine.StreamParameters;
import co.discord.media_engine.VideoInputDeviceDescription;
import com.hammerandchisel.libdiscord.Discord;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p041q.ExecutorServiceC1192c;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;

/* JADX INFO: compiled from: MediaEngine.kt */
/* JADX INFO: loaded from: classes.dex */
public interface MediaEngine {

    /* JADX INFO: compiled from: MediaEngine.kt */
    public static final /* data */ class AudioInfo {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        public final String audioSubsystem;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public final String audioLayer;

        public AudioInfo(String str, String str2) {
            C12238m.checkNotNullParameter(str, "audioSubsystem");
            C12238m.checkNotNullParameter(str2, "audioLayer");
            this.audioSubsystem = str;
            this.audioLayer = str2;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AudioInfo)) {
                return false;
            }
            AudioInfo audioInfo = (AudioInfo) other;
            return C12238m.areEqual(this.audioSubsystem, audioInfo.audioSubsystem) && C12238m.areEqual(this.audioLayer, audioInfo.audioLayer);
        }

        public int hashCode() {
            String str = this.audioSubsystem;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.audioLayer;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("AudioInfo(audioSubsystem=");
            sbM833U.append(this.audioSubsystem);
            sbM833U.append(", audioLayer=");
            return C1643a.m822J(sbM833U, this.audioLayer, ")");
        }
    }

    /* JADX INFO: compiled from: MediaEngine.kt */
    public static final /* data */ class EchoCancellationInfo {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        public final boolean builtinAecRequested;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public final boolean builtinAecSupportedNative;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        public final boolean builtinAecSupportedJava;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        public final boolean builtinAecEnabled;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        public final boolean aecEnabledInSettings;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        public final boolean aecEnabledInNativeConfig;

        /* JADX INFO: renamed from: g, reason: from kotlin metadata */
        public final boolean aecMobileMode;

        /* JADX INFO: renamed from: h, reason: from kotlin metadata */
        public final boolean aecEnabledByDefault;

        /* JADX INFO: renamed from: i, reason: from kotlin metadata */
        public final boolean aecMobileModeByDefault;

        public EchoCancellationInfo() {
            this(false, false, false, false, false, false, false, false, false, FrameMetricsAggregator.EVERY_DURATION);
        }

        public EchoCancellationInfo(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
            this.builtinAecRequested = z2;
            this.builtinAecSupportedNative = z3;
            this.builtinAecSupportedJava = z4;
            this.builtinAecEnabled = z5;
            this.aecEnabledInSettings = z6;
            this.aecEnabledInNativeConfig = z7;
            this.aecMobileMode = z8;
            this.aecEnabledByDefault = z9;
            this.aecMobileModeByDefault = z10;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EchoCancellationInfo)) {
                return false;
            }
            EchoCancellationInfo echoCancellationInfo = (EchoCancellationInfo) other;
            return this.builtinAecRequested == echoCancellationInfo.builtinAecRequested && this.builtinAecSupportedNative == echoCancellationInfo.builtinAecSupportedNative && this.builtinAecSupportedJava == echoCancellationInfo.builtinAecSupportedJava && this.builtinAecEnabled == echoCancellationInfo.builtinAecEnabled && this.aecEnabledInSettings == echoCancellationInfo.aecEnabledInSettings && this.aecEnabledInNativeConfig == echoCancellationInfo.aecEnabledInNativeConfig && this.aecMobileMode == echoCancellationInfo.aecMobileMode && this.aecEnabledByDefault == echoCancellationInfo.aecEnabledByDefault && this.aecMobileModeByDefault == echoCancellationInfo.aecMobileModeByDefault;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
        /* JADX WARN: Type inference failed for: r0v13, types: [int] */
        /* JADX WARN: Type inference failed for: r0v15, types: [int] */
        /* JADX WARN: Type inference failed for: r0v17, types: [int] */
        /* JADX WARN: Type inference failed for: r0v18 */
        /* JADX WARN: Type inference failed for: r0v19 */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v11, types: [int] */
        /* JADX WARN: Type inference failed for: r2v13, types: [int] */
        /* JADX WARN: Type inference failed for: r2v15 */
        /* JADX WARN: Type inference failed for: r2v16 */
        /* JADX WARN: Type inference failed for: r2v17 */
        /* JADX WARN: Type inference failed for: r2v18 */
        /* JADX WARN: Type inference failed for: r2v19 */
        /* JADX WARN: Type inference failed for: r2v20 */
        /* JADX WARN: Type inference failed for: r2v21 */
        /* JADX WARN: Type inference failed for: r2v22 */
        /* JADX WARN: Type inference failed for: r2v23 */
        /* JADX WARN: Type inference failed for: r2v24 */
        /* JADX WARN: Type inference failed for: r2v25 */
        /* JADX WARN: Type inference failed for: r2v26 */
        /* JADX WARN: Type inference failed for: r2v27 */
        /* JADX WARN: Type inference failed for: r2v28 */
        /* JADX WARN: Type inference failed for: r2v3, types: [int] */
        /* JADX WARN: Type inference failed for: r2v5, types: [int] */
        /* JADX WARN: Type inference failed for: r2v7, types: [int] */
        /* JADX WARN: Type inference failed for: r2v9, types: [int] */
        public int hashCode() {
            boolean z2 = this.builtinAecRequested;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z3 = this.builtinAecSupportedNative;
            ?? r2 = z3;
            if (z3) {
                r2 = 1;
            }
            int i2 = (i + r2) * 31;
            boolean z4 = this.builtinAecSupportedJava;
            ?? r3 = z4;
            if (z4) {
                r3 = 1;
            }
            int i3 = (i2 + r3) * 31;
            boolean z5 = this.builtinAecEnabled;
            ?? r4 = z5;
            if (z5) {
                r4 = 1;
            }
            int i4 = (i3 + r4) * 31;
            boolean z6 = this.aecEnabledInSettings;
            ?? r5 = z6;
            if (z6) {
                r5 = 1;
            }
            int i5 = (i4 + r5) * 31;
            boolean z7 = this.aecEnabledInNativeConfig;
            ?? r6 = z7;
            if (z7) {
                r6 = 1;
            }
            int i6 = (i5 + r6) * 31;
            boolean z8 = this.aecMobileMode;
            ?? r7 = z8;
            if (z8) {
                r7 = 1;
            }
            int i7 = (i6 + r7) * 31;
            boolean z9 = this.aecEnabledByDefault;
            ?? r8 = z9;
            if (z9) {
                r8 = 1;
            }
            int i8 = (i7 + r8) * 31;
            boolean z10 = this.aecMobileModeByDefault;
            return i8 + (z10 ? 1 : z10);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("EchoCancellationInfo(builtinAecRequested=");
            sbM833U.append(this.builtinAecRequested);
            sbM833U.append(", builtinAecSupportedNative=");
            sbM833U.append(this.builtinAecSupportedNative);
            sbM833U.append(", builtinAecSupportedJava=");
            sbM833U.append(this.builtinAecSupportedJava);
            sbM833U.append(", builtinAecEnabled=");
            sbM833U.append(this.builtinAecEnabled);
            sbM833U.append(", aecEnabledInSettings=");
            sbM833U.append(this.aecEnabledInSettings);
            sbM833U.append(", aecEnabledInNativeConfig=");
            sbM833U.append(this.aecEnabledInNativeConfig);
            sbM833U.append(", aecMobileMode=");
            sbM833U.append(this.aecMobileMode);
            sbM833U.append(", aecEnabledByDefault=");
            sbM833U.append(this.aecEnabledByDefault);
            sbM833U.append(", aecMobileModeByDefault=");
            return C1643a.m827O(sbM833U, this.aecMobileModeByDefault, ")");
        }

        public /* synthetic */ EchoCancellationInfo(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i) {
            this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? false : z3, (i & 4) != 0 ? false : z4, (i & 8) != 0 ? false : z5, (i & 16) != 0 ? false : z6, (i & 32) != 0 ? false : z7, (i & 64) != 0 ? false : z8, (i & 128) != 0 ? false : z9, (i & 256) == 0 ? z10 : false);
        }
    }

    /* JADX INFO: compiled from: MediaEngine.kt */
    public static final /* data */ class LocalVoiceStatus {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        public final float amplitude;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public final boolean isSpeaking;

        public LocalVoiceStatus(float f, boolean z2) {
            this.amplitude = f;
            this.isSpeaking = z2;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LocalVoiceStatus)) {
                return false;
            }
            LocalVoiceStatus localVoiceStatus = (LocalVoiceStatus) other;
            return Float.compare(this.amplitude, localVoiceStatus.amplitude) == 0 && this.isSpeaking == localVoiceStatus.isSpeaking;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            int iFloatToIntBits = Float.floatToIntBits(this.amplitude) * 31;
            boolean z2 = this.isSpeaking;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iFloatToIntBits + r1;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("LocalVoiceStatus(amplitude=");
            sbM833U.append(this.amplitude);
            sbM833U.append(", isSpeaking=");
            return C1643a.m827O(sbM833U, this.isSpeaking, ")");
        }
    }

    /* JADX INFO: compiled from: MediaEngine.kt */
    public enum OpenSLESConfig {
        DEFAULT,
        FORCE_ENABLED,
        FORCE_DISABLED
    }

    /* JADX INFO: compiled from: MediaEngine.kt */
    public enum OpenSLUsageMode {
        ALLOW_LIST,
        EXCLUDE_LIST
    }

    /* JADX INFO: compiled from: MediaEngine.kt */
    public static final /* data */ class VoiceConfig {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        public final float outputVolume;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public final boolean echoCancellation;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        public final boolean noiseSuppression;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        public final boolean noiseCancellation;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        public final boolean automaticGainControl;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        public final MediaEngineConnection.InputMode inputMode;

        /* JADX INFO: renamed from: g, reason: from kotlin metadata */
        public final MediaEngineConnection.C5647c inputModeOptions;

        /* JADX INFO: renamed from: h, reason: from kotlin metadata */
        public final boolean isSelfDeafened;

        /* JADX INFO: renamed from: i, reason: from kotlin metadata */
        public final boolean isSelfMuted;

        public VoiceConfig(float f, boolean z2, boolean z3, boolean z4, boolean z5, MediaEngineConnection.InputMode inputMode, MediaEngineConnection.C5647c c5647c, boolean z6, boolean z7) {
            C12238m.checkNotNullParameter(inputMode, "inputMode");
            C12238m.checkNotNullParameter(c5647c, "inputModeOptions");
            this.outputVolume = f;
            this.echoCancellation = z2;
            this.noiseSuppression = z3;
            this.noiseCancellation = z4;
            this.automaticGainControl = z5;
            this.inputMode = inputMode;
            this.inputModeOptions = c5647c;
            this.isSelfDeafened = z6;
            this.isSelfMuted = z7;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VoiceConfig)) {
                return false;
            }
            VoiceConfig voiceConfig = (VoiceConfig) other;
            return Float.compare(this.outputVolume, voiceConfig.outputVolume) == 0 && this.echoCancellation == voiceConfig.echoCancellation && this.noiseSuppression == voiceConfig.noiseSuppression && this.noiseCancellation == voiceConfig.noiseCancellation && this.automaticGainControl == voiceConfig.automaticGainControl && C12238m.areEqual(this.inputMode, voiceConfig.inputMode) && C12238m.areEqual(this.inputModeOptions, voiceConfig.inputModeOptions) && this.isSelfDeafened == voiceConfig.isSelfDeafened && this.isSelfMuted == voiceConfig.isSelfMuted;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v15, types: [int] */
        /* JADX WARN: Type inference failed for: r0v17, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v13, types: [int] */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v19 */
        /* JADX WARN: Type inference failed for: r1v20 */
        /* JADX WARN: Type inference failed for: r1v21 */
        /* JADX WARN: Type inference failed for: r1v22 */
        /* JADX WARN: Type inference failed for: r1v23 */
        /* JADX WARN: Type inference failed for: r1v24 */
        /* JADX WARN: Type inference failed for: r1v25 */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7, types: [int] */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public int hashCode() {
            int iFloatToIntBits = Float.floatToIntBits(this.outputVolume) * 31;
            boolean z2 = this.echoCancellation;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            int i = (iFloatToIntBits + r1) * 31;
            boolean z3 = this.noiseSuppression;
            ?? r2 = z3;
            if (z3) {
                r2 = 1;
            }
            int i2 = (i + r2) * 31;
            boolean z4 = this.noiseCancellation;
            ?? r3 = z4;
            if (z4) {
                r3 = 1;
            }
            int i3 = (i2 + r3) * 31;
            boolean z5 = this.automaticGainControl;
            ?? r4 = z5;
            if (z5) {
                r4 = 1;
            }
            int i4 = (i3 + r4) * 31;
            MediaEngineConnection.InputMode inputMode = this.inputMode;
            int iHashCode = (i4 + (inputMode != null ? inputMode.hashCode() : 0)) * 31;
            MediaEngineConnection.C5647c c5647c = this.inputModeOptions;
            int iHashCode2 = (iHashCode + (c5647c != null ? c5647c.hashCode() : 0)) * 31;
            boolean z6 = this.isSelfDeafened;
            ?? r5 = z6;
            if (z6) {
                r5 = 1;
            }
            int i5 = (iHashCode2 + r5) * 31;
            boolean z7 = this.isSelfMuted;
            return i5 + (z7 ? 1 : z7);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("VoiceConfig(outputVolume=");
            sbM833U.append(this.outputVolume);
            sbM833U.append(", echoCancellation=");
            sbM833U.append(this.echoCancellation);
            sbM833U.append(", noiseSuppression=");
            sbM833U.append(this.noiseSuppression);
            sbM833U.append(", noiseCancellation=");
            sbM833U.append(this.noiseCancellation);
            sbM833U.append(", automaticGainControl=");
            sbM833U.append(this.automaticGainControl);
            sbM833U.append(", inputMode=");
            sbM833U.append(this.inputMode);
            sbM833U.append(", inputModeOptions=");
            sbM833U.append(this.inputModeOptions);
            sbM833U.append(", isSelfDeafened=");
            sbM833U.append(this.isSelfDeafened);
            sbM833U.append(", isSelfMuted=");
            return C1643a.m827O(sbM833U, this.isSelfMuted, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.rtcconnection.mediaengine.MediaEngine$a */
    /* JADX INFO: compiled from: MediaEngine.kt */
    public static final class C5640a {

        /* JADX INFO: renamed from: a */
        public final int f18898a;

        /* JADX INFO: renamed from: b */
        public final String f18899b;

        /* JADX INFO: renamed from: c */
        public final int f18900c;

        /* JADX INFO: renamed from: d */
        public final List<StreamParameters> f18901d;

        public C5640a(int i, String str, int i2, List<StreamParameters> list) {
            C12238m.checkNotNullParameter(str, "ip");
            C12238m.checkNotNullParameter(list, "streams");
            this.f18898a = i;
            this.f18899b = str;
            this.f18900c = i2;
            this.f18901d = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C5640a)) {
                return false;
            }
            C5640a c5640a = (C5640a) obj;
            return this.f18898a == c5640a.f18898a && C12238m.areEqual(this.f18899b, c5640a.f18899b) && this.f18900c == c5640a.f18900c && C12238m.areEqual(this.f18901d, c5640a.f18901d);
        }

        public int hashCode() {
            int i = this.f18898a * 31;
            String str = this.f18899b;
            int iHashCode = (((i + (str != null ? str.hashCode() : 0)) * 31) + this.f18900c) * 31;
            List<StreamParameters> list = this.f18901d;
            return iHashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ConnectionOptions(ssrc=");
            sbM833U.append(this.f18898a);
            sbM833U.append(", ip=");
            sbM833U.append(this.f18899b);
            sbM833U.append(", port=");
            sbM833U.append(this.f18900c);
            sbM833U.append(", streams=");
            return C1643a.m824L(sbM833U, this.f18901d, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.rtcconnection.mediaengine.MediaEngine$b */
    /* JADX INFO: compiled from: MediaEngine.kt */
    public interface InterfaceC5641b {
        void onEchoCancellationUpdated(EchoCancellationInfo echoCancellationInfo);
    }

    /* JADX INFO: renamed from: com.discord.rtcconnection.mediaengine.MediaEngine$c */
    /* JADX INFO: compiled from: MediaEngine.kt */
    public interface InterfaceC5642c {
        void onConnected();

        void onConnecting();

        void onNativeEngineInitialized();

        void onNewConnection(MediaEngineConnection mediaEngineConnection);
    }

    /* JADX INFO: renamed from: a */
    Observable<Unit> mo321a();

    /* JADX INFO: renamed from: b */
    void mo322b(RtcRegion[] regionsWithIps, Function1<? super String[], Unit> callback);

    /* JADX INFO: renamed from: c */
    ExecutorServiceC1192c mo323c();

    @AnyThread
    /* JADX INFO: renamed from: d */
    void mo324d(VoiceConfig voiceConfig);

    /* JADX INFO: renamed from: e */
    Observable<AudioInfo> mo325e();

    /* JADX INFO: renamed from: f */
    void mo326f(int deviceIndex);

    /* JADX INFO: renamed from: g */
    MediaEngineConnection mo327g(long userId, C5640a options, MediaEngineConnection.Type type, Function1<? super Exception, Unit> onFailure);

    List<MediaEngineConnection> getConnections();

    /* JADX INFO: renamed from: h */
    void mo328h(OpenSLUsageMode openSLUsageMode);

    /* JADX INFO: renamed from: i */
    Discord mo329i();

    /* JADX INFO: renamed from: j */
    void mo330j(Function1<? super VideoInputDeviceDescription[], Unit> devicesCallback);

    /* JADX INFO: renamed from: k */
    void mo331k(boolean enabled);

    /* JADX INFO: renamed from: l */
    void mo332l(Function1<? super LocalVoiceStatus, Unit> voiceStatusListener);
}
