package com.discord.rtcconnection.mediaengine;

import androidx.annotation.AnyThread;
import androidx.core.app.FrameMetricsAggregator;
import b.a.q.MediaEngineExecutorService;
import b.d.b.a.outline;
import co.discord.media_engine.DeviceDescription4;
import co.discord.media_engine.RtcRegion;
import co.discord.media_engine.StreamParameters;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.hammerandchisel.libdiscord.Discord;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: MediaEngine.kt */
/* JADX INFO: loaded from: classes.dex */
public interface MediaEngine {

    /* JADX INFO: compiled from: MediaEngine.kt */
    public static final /* data */ class AudioInfo {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        public final String audioSubsystem;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final String audioLayer;

        public AudioInfo(String str, String str2) {
            Intrinsics3.checkNotNullParameter(str, "audioSubsystem");
            Intrinsics3.checkNotNullParameter(str2, "audioLayer");
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
            return Intrinsics3.areEqual(this.audioSubsystem, audioInfo.audioSubsystem) && Intrinsics3.areEqual(this.audioLayer, audioInfo.audioLayer);
        }

        public int hashCode() {
            String str = this.audioSubsystem;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.audioLayer;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("AudioInfo(audioSubsystem=");
            sbU.append(this.audioSubsystem);
            sbU.append(", audioLayer=");
            return outline.J(sbU, this.audioLayer, ")");
        }
    }

    /* JADX INFO: compiled from: MediaEngine.kt */
    public static final /* data */ class EchoCancellationInfo {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        public final boolean builtinAecRequested;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
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
            StringBuilder sbU = outline.U("EchoCancellationInfo(builtinAecRequested=");
            sbU.append(this.builtinAecRequested);
            sbU.append(", builtinAecSupportedNative=");
            sbU.append(this.builtinAecSupportedNative);
            sbU.append(", builtinAecSupportedJava=");
            sbU.append(this.builtinAecSupportedJava);
            sbU.append(", builtinAecEnabled=");
            sbU.append(this.builtinAecEnabled);
            sbU.append(", aecEnabledInSettings=");
            sbU.append(this.aecEnabledInSettings);
            sbU.append(", aecEnabledInNativeConfig=");
            sbU.append(this.aecEnabledInNativeConfig);
            sbU.append(", aecMobileMode=");
            sbU.append(this.aecMobileMode);
            sbU.append(", aecEnabledByDefault=");
            sbU.append(this.aecEnabledByDefault);
            sbU.append(", aecMobileModeByDefault=");
            return outline.O(sbU, this.aecMobileModeByDefault, ")");
        }

        public /* synthetic */ EchoCancellationInfo(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i) {
            this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? false : z3, (i & 4) != 0 ? false : z4, (i & 8) != 0 ? false : z5, (i & 16) != 0 ? false : z6, (i & 32) != 0 ? false : z7, (i & 64) != 0 ? false : z8, (i & 128) != 0 ? false : z9, (i & 256) == 0 ? z10 : false);
        }
    }

    /* JADX INFO: compiled from: MediaEngine.kt */
    public static final /* data */ class LocalVoiceStatus {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        public final float amplitude;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
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
            StringBuilder sbU = outline.U("LocalVoiceStatus(amplitude=");
            sbU.append(this.amplitude);
            sbU.append(", isSpeaking=");
            return outline.O(sbU, this.isSpeaking, ")");
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

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
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
        public final MediaEngineConnection.c inputModeOptions;

        /* JADX INFO: renamed from: h, reason: from kotlin metadata */
        public final boolean isSelfDeafened;

        /* JADX INFO: renamed from: i, reason: from kotlin metadata */
        public final boolean isSelfMuted;

        public VoiceConfig(float f, boolean z2, boolean z3, boolean z4, boolean z5, MediaEngineConnection.InputMode inputMode, MediaEngineConnection.c cVar, boolean z6, boolean z7) {
            Intrinsics3.checkNotNullParameter(inputMode, "inputMode");
            Intrinsics3.checkNotNullParameter(cVar, "inputModeOptions");
            this.outputVolume = f;
            this.echoCancellation = z2;
            this.noiseSuppression = z3;
            this.noiseCancellation = z4;
            this.automaticGainControl = z5;
            this.inputMode = inputMode;
            this.inputModeOptions = cVar;
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
            return Float.compare(this.outputVolume, voiceConfig.outputVolume) == 0 && this.echoCancellation == voiceConfig.echoCancellation && this.noiseSuppression == voiceConfig.noiseSuppression && this.noiseCancellation == voiceConfig.noiseCancellation && this.automaticGainControl == voiceConfig.automaticGainControl && Intrinsics3.areEqual(this.inputMode, voiceConfig.inputMode) && Intrinsics3.areEqual(this.inputModeOptions, voiceConfig.inputModeOptions) && this.isSelfDeafened == voiceConfig.isSelfDeafened && this.isSelfMuted == voiceConfig.isSelfMuted;
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
            MediaEngineConnection.c cVar = this.inputModeOptions;
            int iHashCode2 = (iHashCode + (cVar != null ? cVar.hashCode() : 0)) * 31;
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
            StringBuilder sbU = outline.U("VoiceConfig(outputVolume=");
            sbU.append(this.outputVolume);
            sbU.append(", echoCancellation=");
            sbU.append(this.echoCancellation);
            sbU.append(", noiseSuppression=");
            sbU.append(this.noiseSuppression);
            sbU.append(", noiseCancellation=");
            sbU.append(this.noiseCancellation);
            sbU.append(", automaticGainControl=");
            sbU.append(this.automaticGainControl);
            sbU.append(", inputMode=");
            sbU.append(this.inputMode);
            sbU.append(", inputModeOptions=");
            sbU.append(this.inputModeOptions);
            sbU.append(", isSelfDeafened=");
            sbU.append(this.isSelfDeafened);
            sbU.append(", isSelfMuted=");
            return outline.O(sbU, this.isSelfMuted, ")");
        }
    }

    /* JADX INFO: compiled from: MediaEngine.kt */
    public static final class a {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f2797b;
        public final int c;
        public final List<StreamParameters> d;

        public a(int i, String str, int i2, List<StreamParameters> list) {
            Intrinsics3.checkNotNullParameter(str, "ip");
            Intrinsics3.checkNotNullParameter(list, "streams");
            this.a = i;
            this.f2797b = str;
            this.c = i2;
            this.d = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && Intrinsics3.areEqual(this.f2797b, aVar.f2797b) && this.c == aVar.c && Intrinsics3.areEqual(this.d, aVar.d);
        }

        public int hashCode() {
            int i = this.a * 31;
            String str = this.f2797b;
            int iHashCode = (((i + (str != null ? str.hashCode() : 0)) * 31) + this.c) * 31;
            List<StreamParameters> list = this.d;
            return iHashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ConnectionOptions(ssrc=");
            sbU.append(this.a);
            sbU.append(", ip=");
            sbU.append(this.f2797b);
            sbU.append(", port=");
            sbU.append(this.c);
            sbU.append(", streams=");
            return outline.L(sbU, this.d, ")");
        }
    }

    /* JADX INFO: compiled from: MediaEngine.kt */
    public interface b {
        void onEchoCancellationUpdated(EchoCancellationInfo echoCancellationInfo);
    }

    /* JADX INFO: compiled from: MediaEngine.kt */
    public interface c {
        void onConnected();

        void onConnecting();

        void onNativeEngineInitialized();

        void onNewConnection(MediaEngineConnection mediaEngineConnection);
    }

    Observable<Unit> a();

    void b(RtcRegion[] regionsWithIps, Function1<? super String[], Unit> callback);

    MediaEngineExecutorService c();

    @AnyThread
    void d(VoiceConfig voiceConfig);

    Observable<AudioInfo> e();

    void f(int deviceIndex);

    MediaEngineConnection g(long userId, a options, MediaEngineConnection.Type type, Function1<? super Exception, Unit> onFailure);

    List<MediaEngineConnection> getConnections();

    void h(OpenSLUsageMode openSLUsageMode);

    Discord i();

    void j(Function1<? super DeviceDescription4[], Unit> devicesCallback);

    void k(boolean enabled);

    void l(Function1<? super LocalVoiceStatus, Unit> voiceStatusListener);
}
