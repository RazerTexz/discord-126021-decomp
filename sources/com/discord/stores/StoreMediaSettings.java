package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.media.AppSound;
import com.discord.utilities.media.AppSoundManager;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.webrtc.PeerConnectionFactory;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12141k;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: StoreMediaSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMediaSettings extends Store {
    private final AppSoundManager appSoundManager;
    private boolean canUseVad;
    private SelfMuteFailure forceSelfMuteReason;
    private final StoreChannels storeChannels;
    private final StorePermissions storePermissions;
    private final StoreVoiceChannelSelected storeVoiceChannelSelected;
    private VoiceConfiguration voiceConfiguration;
    private final VoiceConfigurationCache voiceConfigurationCache;
    private final SerializedSubject<VoiceConfiguration, VoiceConfiguration> voiceConfigurationSubject;

    /* JADX INFO: compiled from: StoreMediaSettings.kt */
    public enum NoiseProcessing {
        None,
        Suppression,
        Cancellation,
        CancellationTemporarilyDisabled
    }

    /* JADX INFO: compiled from: StoreMediaSettings.kt */
    public enum SelfMuteFailure {
        CANNOT_USE_VAD
    }

    /* JADX INFO: compiled from: StoreMediaSettings.kt */
    public enum VadUseKrisp {
        Disabled,
        Enabled,
        TemporarilyDisabled
    }

    /* JADX INFO: compiled from: StoreMediaSettings.kt */
    public static final /* data */ class VoiceConfiguration {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int DEFAULT_NOISE_PROCESSING;
        public static final float DEFAULT_OUTPUT_VOLUME = 100.0f;
        public static final float DEFAULT_SENSITIVITY = -50.0f;
        private static final VoiceConfiguration DEFAULT_VOICE_CONFIG;
        private final boolean automaticGainControl;
        private final boolean automaticVad;
        private final boolean echoCancellation;
        private final boolean enableVideoHardwareScaling;
        private final MediaEngineConnection.InputMode inputMode;
        private final boolean isSelfDeafened;
        private final boolean isSelfMuted;
        private final Map<Long, Boolean> mutedUsers;
        private final NoiseProcessing noiseProcessing;
        private final Map<Long, Boolean> offScreenUsers;
        private final float outputVolume;
        private final float sensitivity;
        private final Map<Long, Float> userOutputVolumes;
        private final VadUseKrisp vadUseKrisp;
        private final boolean voiceParticipantsHidden;

        /* JADX INFO: compiled from: StoreMediaSettings.kt */
        public static final class Companion {
            private Companion() {
            }

            public final int getDEFAULT_NOISE_PROCESSING() {
                return VoiceConfiguration.DEFAULT_NOISE_PROCESSING;
            }

            public final VoiceConfiguration getDEFAULT_VOICE_CONFIG() {
                return VoiceConfiguration.DEFAULT_VOICE_CONFIG;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        static {
            VoiceConfiguration voiceConfiguration = new VoiceConfiguration(false, false, false, null, false, false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32767, null);
            DEFAULT_VOICE_CONFIG = voiceConfiguration;
            DEFAULT_NOISE_PROCESSING = voiceConfiguration.noiseProcessing.ordinal();
        }

        public VoiceConfiguration() {
            this(false, false, false, null, false, false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32767, null);
        }

        public VoiceConfiguration(boolean z2, boolean z3, boolean z4, VadUseKrisp vadUseKrisp, boolean z5, boolean z6, NoiseProcessing noiseProcessing, float f, MediaEngineConnection.InputMode inputMode, float f2, Map<Long, Boolean> map, Map<Long, Float> map2, Map<Long, Boolean> map3, boolean z7, boolean z8) {
            C12238m.checkNotNullParameter(vadUseKrisp, "vadUseKrisp");
            C12238m.checkNotNullParameter(noiseProcessing, "noiseProcessing");
            C12238m.checkNotNullParameter(inputMode, "inputMode");
            C12238m.checkNotNullParameter(map, "mutedUsers");
            C12238m.checkNotNullParameter(map2, "userOutputVolumes");
            C12238m.checkNotNullParameter(map3, "offScreenUsers");
            this.isSelfMuted = z2;
            this.isSelfDeafened = z3;
            this.automaticVad = z4;
            this.vadUseKrisp = vadUseKrisp;
            this.automaticGainControl = z5;
            this.echoCancellation = z6;
            this.noiseProcessing = noiseProcessing;
            this.sensitivity = f;
            this.inputMode = inputMode;
            this.outputVolume = f2;
            this.mutedUsers = map;
            this.userOutputVolumes = map2;
            this.offScreenUsers = map3;
            this.enableVideoHardwareScaling = z7;
            this.voiceParticipantsHidden = z8;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        private final boolean getIsSelfMuted() {
            return this.isSelfMuted;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ VoiceConfiguration copy$default(VoiceConfiguration voiceConfiguration, boolean z2, boolean z3, boolean z4, VadUseKrisp vadUseKrisp, boolean z5, boolean z6, NoiseProcessing noiseProcessing, float f, MediaEngineConnection.InputMode inputMode, float f2, Map map, Map map2, Map map3, boolean z7, boolean z8, int i, Object obj) {
            return voiceConfiguration.copy((i & 1) != 0 ? voiceConfiguration.isSelfMuted : z2, (i & 2) != 0 ? voiceConfiguration.isSelfDeafened : z3, (i & 4) != 0 ? voiceConfiguration.automaticVad : z4, (i & 8) != 0 ? voiceConfiguration.vadUseKrisp : vadUseKrisp, (i & 16) != 0 ? voiceConfiguration.automaticGainControl : z5, (i & 32) != 0 ? voiceConfiguration.echoCancellation : z6, (i & 64) != 0 ? voiceConfiguration.noiseProcessing : noiseProcessing, (i & 128) != 0 ? voiceConfiguration.sensitivity : f, (i & 256) != 0 ? voiceConfiguration.inputMode : inputMode, (i & 512) != 0 ? voiceConfiguration.outputVolume : f2, (i & 1024) != 0 ? voiceConfiguration.mutedUsers : map, (i & 2048) != 0 ? voiceConfiguration.userOutputVolumes : map2, (i & 4096) != 0 ? voiceConfiguration.offScreenUsers : map3, (i & 8192) != 0 ? voiceConfiguration.enableVideoHardwareScaling : z7, (i & 16384) != 0 ? voiceConfiguration.voiceParticipantsHidden : z8);
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final float getOutputVolume() {
            return this.outputVolume;
        }

        public final Map<Long, Boolean> component11() {
            return this.mutedUsers;
        }

        public final Map<Long, Float> component12() {
            return this.userOutputVolumes;
        }

        public final Map<Long, Boolean> component13() {
            return this.offScreenUsers;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final boolean getEnableVideoHardwareScaling() {
            return this.enableVideoHardwareScaling;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final boolean getVoiceParticipantsHidden() {
            return this.voiceParticipantsHidden;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsSelfDeafened() {
            return this.isSelfDeafened;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getAutomaticVad() {
            return this.automaticVad;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final VadUseKrisp getVadUseKrisp() {
            return this.vadUseKrisp;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getAutomaticGainControl() {
            return this.automaticGainControl;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getEchoCancellation() {
            return this.echoCancellation;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final NoiseProcessing getNoiseProcessing() {
            return this.noiseProcessing;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final float getSensitivity() {
            return this.sensitivity;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final MediaEngineConnection.InputMode getInputMode() {
            return this.inputMode;
        }

        public final VoiceConfiguration copy(boolean isSelfMuted, boolean isSelfDeafened, boolean automaticVad, VadUseKrisp vadUseKrisp, boolean automaticGainControl, boolean echoCancellation, NoiseProcessing noiseProcessing, float sensitivity, MediaEngineConnection.InputMode inputMode, float outputVolume, Map<Long, Boolean> mutedUsers, Map<Long, Float> userOutputVolumes, Map<Long, Boolean> offScreenUsers, boolean enableVideoHardwareScaling, boolean voiceParticipantsHidden) {
            C12238m.checkNotNullParameter(vadUseKrisp, "vadUseKrisp");
            C12238m.checkNotNullParameter(noiseProcessing, "noiseProcessing");
            C12238m.checkNotNullParameter(inputMode, "inputMode");
            C12238m.checkNotNullParameter(mutedUsers, "mutedUsers");
            C12238m.checkNotNullParameter(userOutputVolumes, "userOutputVolumes");
            C12238m.checkNotNullParameter(offScreenUsers, "offScreenUsers");
            return new VoiceConfiguration(isSelfMuted, isSelfDeafened, automaticVad, vadUseKrisp, automaticGainControl, echoCancellation, noiseProcessing, sensitivity, inputMode, outputVolume, mutedUsers, userOutputVolumes, offScreenUsers, enableVideoHardwareScaling, voiceParticipantsHidden);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VoiceConfiguration)) {
                return false;
            }
            VoiceConfiguration voiceConfiguration = (VoiceConfiguration) other;
            return this.isSelfMuted == voiceConfiguration.isSelfMuted && this.isSelfDeafened == voiceConfiguration.isSelfDeafened && this.automaticVad == voiceConfiguration.automaticVad && C12238m.areEqual(this.vadUseKrisp, voiceConfiguration.vadUseKrisp) && this.automaticGainControl == voiceConfiguration.automaticGainControl && this.echoCancellation == voiceConfiguration.echoCancellation && C12238m.areEqual(this.noiseProcessing, voiceConfiguration.noiseProcessing) && Float.compare(this.sensitivity, voiceConfiguration.sensitivity) == 0 && C12238m.areEqual(this.inputMode, voiceConfiguration.inputMode) && Float.compare(this.outputVolume, voiceConfiguration.outputVolume) == 0 && C12238m.areEqual(this.mutedUsers, voiceConfiguration.mutedUsers) && C12238m.areEqual(this.userOutputVolumes, voiceConfiguration.userOutputVolumes) && C12238m.areEqual(this.offScreenUsers, voiceConfiguration.offScreenUsers) && this.enableVideoHardwareScaling == voiceConfiguration.enableVideoHardwareScaling && this.voiceParticipantsHidden == voiceConfiguration.voiceParticipantsHidden;
        }

        public final boolean getAutomaticGainControl() {
            return this.automaticGainControl;
        }

        public final boolean getAutomaticVad() {
            return this.automaticVad;
        }

        public final boolean getEchoCancellation() {
            return this.echoCancellation;
        }

        public final boolean getEnableVideoHardwareScaling() {
            return this.enableVideoHardwareScaling;
        }

        public final MediaEngineConnection.InputMode getInputMode() {
            return this.inputMode;
        }

        public final Map<Long, Boolean> getMutedUsers() {
            return this.mutedUsers;
        }

        public final NoiseProcessing getNoiseProcessing() {
            return this.noiseProcessing;
        }

        public final Map<Long, Boolean> getOffScreenUsers() {
            return this.offScreenUsers;
        }

        public final float getOutputVolume() {
            return this.outputVolume;
        }

        public final float getSensitivity() {
            return this.sensitivity;
        }

        public final Map<Long, Float> getUserOutputVolumes() {
            return this.userOutputVolumes;
        }

        public final VadUseKrisp getVadUseKrisp() {
            return this.vadUseKrisp;
        }

        public final boolean getVoiceParticipantsHidden() {
            return this.voiceParticipantsHidden;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v28, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v30, types: [int] */
        /* JADX WARN: Type inference failed for: r0v32 */
        /* JADX WARN: Type inference failed for: r0v33 */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v10, types: [int] */
        /* JADX WARN: Type inference failed for: r2v28, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3, types: [int] */
        /* JADX WARN: Type inference failed for: r2v30 */
        /* JADX WARN: Type inference failed for: r2v34 */
        /* JADX WARN: Type inference failed for: r2v35 */
        /* JADX WARN: Type inference failed for: r2v37 */
        /* JADX WARN: Type inference failed for: r2v38 */
        /* JADX WARN: Type inference failed for: r2v39 */
        /* JADX WARN: Type inference failed for: r2v40 */
        /* JADX WARN: Type inference failed for: r2v41 */
        /* JADX WARN: Type inference failed for: r2v42 */
        /* JADX WARN: Type inference failed for: r2v43 */
        /* JADX WARN: Type inference failed for: r2v8, types: [int] */
        public int hashCode() {
            boolean z2 = this.isSelfMuted;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z3 = this.isSelfDeafened;
            ?? r2 = z3;
            if (z3) {
                r2 = 1;
            }
            int i2 = (i + r2) * 31;
            boolean z4 = this.automaticVad;
            ?? r3 = z4;
            if (z4) {
                r3 = 1;
            }
            int i3 = (i2 + r3) * 31;
            VadUseKrisp vadUseKrisp = this.vadUseKrisp;
            int iHashCode = (i3 + (vadUseKrisp != null ? vadUseKrisp.hashCode() : 0)) * 31;
            boolean z5 = this.automaticGainControl;
            ?? r4 = z5;
            if (z5) {
                r4 = 1;
            }
            int i4 = (iHashCode + r4) * 31;
            boolean z6 = this.echoCancellation;
            ?? r5 = z6;
            if (z6) {
                r5 = 1;
            }
            int i5 = (i4 + r5) * 31;
            NoiseProcessing noiseProcessing = this.noiseProcessing;
            int iFloatToIntBits = (Float.floatToIntBits(this.sensitivity) + ((i5 + (noiseProcessing != null ? noiseProcessing.hashCode() : 0)) * 31)) * 31;
            MediaEngineConnection.InputMode inputMode = this.inputMode;
            int iFloatToIntBits2 = (Float.floatToIntBits(this.outputVolume) + ((iFloatToIntBits + (inputMode != null ? inputMode.hashCode() : 0)) * 31)) * 31;
            Map<Long, Boolean> map = this.mutedUsers;
            int iHashCode2 = (iFloatToIntBits2 + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, Float> map2 = this.userOutputVolumes;
            int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<Long, Boolean> map3 = this.offScreenUsers;
            int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
            boolean z7 = this.enableVideoHardwareScaling;
            ?? r6 = z7;
            if (z7) {
                r6 = 1;
            }
            int i6 = (iHashCode4 + r6) * 31;
            boolean z8 = this.voiceParticipantsHidden;
            return i6 + (z8 ? 1 : z8);
        }

        public final boolean isSelfDeafened() {
            return this.isSelfDeafened;
        }

        public final boolean isSelfMuted() {
            return this.isSelfMuted || this.isSelfDeafened;
        }

        public final MediaEngine.VoiceConfig toMediaEngineVoiceConfig() {
            int i = 63 & 1;
            int i2 = 63 & 8;
            int i3 = 63 & 16;
            return new MediaEngine.VoiceConfig(this.outputVolume, this.echoCancellation, C12141k.contains(new NoiseProcessing[]{NoiseProcessing.Suppression, NoiseProcessing.CancellationTemporarilyDisabled}, this.noiseProcessing), this.noiseProcessing == NoiseProcessing.Cancellation, this.automaticGainControl, this.inputMode, new MediaEngineConnection.C5647c((int) this.sensitivity, (2 & 63) != 0 ? 10 : 0, (63 & 4) != 0 ? 40 : 0, this.automaticVad, this.vadUseKrisp == VadUseKrisp.Enabled, (63 & 32) != 0 ? 5 : 0), this.isSelfDeafened, isSelfMuted());
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("VoiceConfiguration(isSelfMuted=");
            sbM833U.append(this.isSelfMuted);
            sbM833U.append(", isSelfDeafened=");
            sbM833U.append(this.isSelfDeafened);
            sbM833U.append(", automaticVad=");
            sbM833U.append(this.automaticVad);
            sbM833U.append(", vadUseKrisp=");
            sbM833U.append(this.vadUseKrisp);
            sbM833U.append(", automaticGainControl=");
            sbM833U.append(this.automaticGainControl);
            sbM833U.append(", echoCancellation=");
            sbM833U.append(this.echoCancellation);
            sbM833U.append(", noiseProcessing=");
            sbM833U.append(this.noiseProcessing);
            sbM833U.append(", sensitivity=");
            sbM833U.append(this.sensitivity);
            sbM833U.append(", inputMode=");
            sbM833U.append(this.inputMode);
            sbM833U.append(", outputVolume=");
            sbM833U.append(this.outputVolume);
            sbM833U.append(", mutedUsers=");
            sbM833U.append(this.mutedUsers);
            sbM833U.append(", userOutputVolumes=");
            sbM833U.append(this.userOutputVolumes);
            sbM833U.append(", offScreenUsers=");
            sbM833U.append(this.offScreenUsers);
            sbM833U.append(", enableVideoHardwareScaling=");
            sbM833U.append(this.enableVideoHardwareScaling);
            sbM833U.append(", voiceParticipantsHidden=");
            return C1643a.m827O(sbM833U, this.voiceParticipantsHidden, ")");
        }

        public /* synthetic */ VoiceConfiguration(boolean z2, boolean z3, boolean z4, VadUseKrisp vadUseKrisp, boolean z5, boolean z6, NoiseProcessing noiseProcessing, float f, MediaEngineConnection.InputMode inputMode, float f2, Map map, Map map2, Map map3, boolean z7, boolean z8, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? false : z3, (i & 4) != 0 ? true : z4, (i & 8) != 0 ? VadUseKrisp.Enabled : vadUseKrisp, (i & 16) != 0 ? true : z5, (i & 32) == 0 ? z6 : true, (i & 64) != 0 ? NoiseProcessing.Cancellation : noiseProcessing, (i & 128) != 0 ? -50.0f : f, (i & 256) != 0 ? MediaEngineConnection.InputMode.VOICE_ACTIVITY : inputMode, (i & 512) != 0 ? 100.0f : f2, (i & 1024) != 0 ? C12136h0.emptyMap() : map, (i & 2048) != 0 ? C12136h0.emptyMap() : map2, (i & 4096) != 0 ? C12136h0.emptyMap() : map3, (i & 8192) != 0 ? false : z7, (i & 16384) == 0 ? z8 : false);
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            VadUseKrisp.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[VadUseKrisp.TemporarilyDisabled.ordinal()] = 1;
            NoiseProcessing.values();
            int[] iArr2 = new int[4];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[NoiseProcessing.CancellationTemporarilyDisabled.ordinal()] = 1;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaSettings$init$2 */
    /* JADX INFO: compiled from: StoreMediaSettings.kt */
    public static final /* synthetic */ class C61892 extends C12236k implements Function1<Boolean, Unit> {
        public C61892(StoreMediaSettings storeMediaSettings) {
            super(1, storeMediaSettings, StoreMediaSettings.class, "handleCanUseVad", "handleCanUseVad(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
            ((StoreMediaSettings) this.receiver).handleCanUseVad(z2);
        }
    }

    public /* synthetic */ StoreMediaSettings(StoreVoiceChannelSelected storeVoiceChannelSelected, StoreChannels storeChannels, StorePermissions storePermissions, VoiceConfigurationCache voiceConfigurationCache, AppSoundManager appSoundManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeVoiceChannelSelected, storeChannels, storePermissions, (i & 8) != 0 ? new VoiceConfigurationCache(SharedPreferencesProvider.INSTANCE.get()) : voiceConfigurationCache, (i & 16) != 0 ? AppSoundManager.Provider.INSTANCE.get() : appSoundManager);
    }

    private final synchronized void handleCanUseVad(boolean canUseVad) {
        this.canUseVad = canUseVad;
        updateForceMute();
    }

    private final void setVoiceConfiguration(VoiceConfiguration voiceConfiguration) {
        this.voiceConfiguration = voiceConfiguration;
        this.voiceConfigurationSubject.f27653k.onNext(voiceConfiguration);
        this.voiceConfigurationCache.write(voiceConfiguration);
    }

    private final void updateForceMute() {
        this.forceSelfMuteReason = null;
        if (!this.canUseVad && this.voiceConfiguration.getInputMode() == MediaEngineConnection.InputMode.VOICE_ACTIVITY) {
            this.forceSelfMuteReason = SelfMuteFailure.CANNOT_USE_VAD;
        }
        if (this.forceSelfMuteReason != null) {
            setVoiceConfiguration(VoiceConfiguration.copy$default(this.voiceConfiguration, true, false, false, null, false, false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32766, null));
        }
    }

    public final Observable<MediaEngineConnection.InputMode> getInputMode() {
        Observable<R> observableM11083G = this.voiceConfigurationSubject.m11083G(new InterfaceC12589b<VoiceConfiguration, MediaEngineConnection.InputMode>() { // from class: com.discord.stores.StoreMediaSettings.getInputMode.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final MediaEngineConnection.InputMode call(VoiceConfiguration voiceConfiguration) {
                return voiceConfiguration.getInputMode();
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "voiceConfigurationSubjec…    .map { it.inputMode }");
        Observable<MediaEngineConnection.InputMode> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11083G).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "voiceConfigurationSubjec…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final synchronized Map<Long, Boolean> getMutedUsers() {
        return this.voiceConfiguration.getMutedUsers();
    }

    public final Observable<Map<Long, Boolean>> getUsersMuted() {
        Observable<R> observableM11083G = this.voiceConfigurationSubject.m11083G(new InterfaceC12589b<VoiceConfiguration, Map<Long, ? extends Boolean>>() { // from class: com.discord.stores.StoreMediaSettings.getUsersMuted.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Map<Long, Boolean> call(VoiceConfiguration voiceConfiguration) {
                return voiceConfiguration.getMutedUsers();
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "voiceConfigurationSubjec…   .map { it.mutedUsers }");
        Observable<Map<Long, Boolean>> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11083G).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "voiceConfigurationSubjec…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Map<Long, Boolean>> getUsersOffScreen() {
        Observable<R> observableM11083G = this.voiceConfigurationSubject.m11083G(new InterfaceC12589b<VoiceConfiguration, Map<Long, ? extends Boolean>>() { // from class: com.discord.stores.StoreMediaSettings.getUsersOffScreen.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Map<Long, Boolean> call(VoiceConfiguration voiceConfiguration) {
                return voiceConfiguration.getOffScreenUsers();
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "voiceConfigurationSubjec…map { it.offScreenUsers }");
        Observable<Map<Long, Boolean>> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11083G).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "voiceConfigurationSubjec…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Map<Long, Float>> getUsersVolume() {
        Observable<R> observableM11083G = this.voiceConfigurationSubject.m11083G(new InterfaceC12589b<VoiceConfiguration, Map<Long, ? extends Float>>() { // from class: com.discord.stores.StoreMediaSettings.getUsersVolume.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Map<Long, Float> call(VoiceConfiguration voiceConfiguration) {
                return voiceConfiguration.getUserOutputVolumes();
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "voiceConfigurationSubjec… { it.userOutputVolumes }");
        Observable<Map<Long, Float>> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11083G).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "voiceConfigurationSubjec…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final synchronized boolean getVideoHardwareScalingBlocking() {
        return this.voiceConfiguration.getEnableVideoHardwareScaling();
    }

    public final Observable<VoiceConfiguration> getVoiceConfig() {
        Observable<VoiceConfiguration> observableM11112r = ObservableExtensionsKt.computationLatest(this.voiceConfigurationSubject).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "voiceConfigurationSubjec…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<VoiceConfiguration> getVoiceConfiguration() {
        return this.voiceConfigurationSubject;
    }

    public final synchronized VoiceConfiguration getVoiceConfigurationBlocking() {
        return this.voiceConfiguration;
    }

    @StoreThread
    public final void handleVoiceChannelSelected(long channelId) {
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease = this.storeChannels.findChannelByIdInternal$app_productionGoogleRelease(channelId);
        if (channelFindChannelByIdInternal$app_productionGoogleRelease == null || !ChannelUtils.m7667B(channelFindChannelByIdInternal$app_productionGoogleRelease)) {
            return;
        }
        setSelfDeafen(false);
    }

    public final void init() {
        setVoiceConfiguration(this.voiceConfigurationCache.read());
        Observable<R> observableM11099Y = this.storeVoiceChannelSelected.observeSelectedVoiceChannelId().m11099Y(new InterfaceC12589b<Long, Observable<? extends Boolean>>() { // from class: com.discord.stores.StoreMediaSettings.init.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends Boolean> call(final Long l) {
                StoreChannels storeChannels = StoreMediaSettings.this.storeChannels;
                C12238m.checkNotNullExpressionValue(l, ModelAuditLogEntry.CHANGE_KEY_ID);
                return storeChannels.observeChannel(l.longValue()).m11099Y(new InterfaceC12589b<Channel, Observable<? extends Boolean>>() { // from class: com.discord.stores.StoreMediaSettings.init.1.1
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final Observable<? extends Boolean> call(Channel channel) {
                        if (channel == null || ChannelUtils.m7667B(channel) || ChannelUtils.m7669D(channel)) {
                            return new C12721k(Boolean.TRUE);
                        }
                        StorePermissions storePermissions = StoreMediaSettings.this.storePermissions;
                        Long l2 = l;
                        C12238m.checkNotNullExpressionValue(l2, ModelAuditLogEntry.CHANGE_KEY_ID);
                        return storePermissions.observePermissionsForChannel(l2.longValue()).m11083G(new InterfaceC12589b<Long, Boolean>() { // from class: com.discord.stores.StoreMediaSettings.init.1.1.1
                            @Override // p637j0.p641k.InterfaceC12589b
                            public final Boolean call(Long l3) {
                                return Boolean.valueOf(PermissionUtils.can(Permission.USE_VAD, l3));
                            }
                        });
                    }
                });
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11099Y, "storeVoiceChannelSelecte…              }\n        }");
        ObservableExtensionsKt.appSubscribe(observableM11099Y, (Class<?>) StoreMediaSettings.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C61892(this));
    }

    public final Observable<Boolean> isSelfDeafened() {
        Observable<R> observableM11083G = this.voiceConfigurationSubject.m11083G(new InterfaceC12589b<VoiceConfiguration, Boolean>() { // from class: com.discord.stores.StoreMediaSettings.isSelfDeafened.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(VoiceConfiguration voiceConfiguration) {
                return Boolean.valueOf(voiceConfiguration.isSelfDeafened());
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "voiceConfigurationSubjec…map { it.isSelfDeafened }");
        Observable<Boolean> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11083G).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "voiceConfigurationSubjec…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Boolean> isSelfMuted() {
        Observable<R> observableM11083G = this.voiceConfigurationSubject.m11083G(new InterfaceC12589b<VoiceConfiguration, Boolean>() { // from class: com.discord.stores.StoreMediaSettings.isSelfMuted.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(VoiceConfiguration voiceConfiguration) {
                return Boolean.valueOf(voiceConfiguration.isSelfMuted());
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "voiceConfigurationSubjec….map { it.isSelfMuted() }");
        Observable<Boolean> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11083G).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "voiceConfigurationSubjec…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final synchronized void revertTemporaryDisableKrisp() {
        VadUseKrisp vadUseKrisp = this.voiceConfiguration.getVadUseKrisp().ordinal() != 2 ? this.voiceConfiguration.getVadUseKrisp() : VadUseKrisp.Enabled;
        NoiseProcessing noiseProcessing = this.voiceConfiguration.getNoiseProcessing().ordinal() != 3 ? this.voiceConfiguration.getNoiseProcessing() : NoiseProcessing.Cancellation;
        if (noiseProcessing != this.voiceConfiguration.getNoiseProcessing() || vadUseKrisp != this.voiceConfiguration.getVadUseKrisp()) {
            setVoiceConfiguration(VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, vadUseKrisp, false, false, noiseProcessing, 0.0f, null, 0.0f, null, null, null, false, false, 32695, null));
        }
    }

    public final synchronized void setNoiseProcessing(NoiseProcessing noiseProcessing) {
        C12238m.checkNotNullParameter(noiseProcessing, "noiseProcessing");
        if (noiseProcessing != this.voiceConfiguration.getNoiseProcessing()) {
            setVoiceConfiguration(VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, null, false, false, noiseProcessing, 0.0f, null, 0.0f, null, null, null, false, false, 32703, null));
        }
    }

    public final synchronized void setOutputVolume(float outputVolume) {
        setVoiceConfiguration(VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, null, false, false, null, 0.0f, null, outputVolume, null, null, null, false, false, 32255, null));
    }

    public final synchronized void setSelfDeafen(boolean isDeafened) {
        if (this.voiceConfiguration.isSelfDeafened() == isDeafened) {
            return;
        }
        setVoiceConfiguration(VoiceConfiguration.copy$default(this.voiceConfiguration, false, isDeafened, false, null, false, false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32765, null));
        this.appSoundManager.play(isDeafened ? AppSound.INSTANCE.getSOUND_DEAFEN() : AppSound.INSTANCE.getSOUND_UNDEAFEN());
    }

    public final synchronized SelfMuteFailure setSelfMuted(boolean isMuted) {
        if (this.voiceConfiguration.isSelfMuted() == isMuted) {
            return null;
        }
        SelfMuteFailure selfMuteFailure = this.forceSelfMuteReason;
        if (selfMuteFailure != null) {
            return selfMuteFailure;
        }
        VoiceConfiguration voiceConfiguration = this.voiceConfiguration;
        setVoiceConfiguration(VoiceConfiguration.copy$default(voiceConfiguration, isMuted, voiceConfiguration.isSelfDeafened() && isMuted, false, null, false, false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32764, null));
        this.appSoundManager.play(isMuted ? AppSound.INSTANCE.getSOUND_MUTE() : AppSound.INSTANCE.getSOUND_UNMUTE());
        return null;
    }

    public final synchronized void setSensitivity(float sensitivity) {
        setVoiceConfiguration(VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, null, false, false, null, sensitivity, null, 0.0f, null, null, null, false, false, 32639, null));
    }

    public final synchronized void setUserOffScreen(long userId, boolean offScreen) {
        VoiceConfiguration voiceConfiguration = this.voiceConfiguration;
        HashMap map = new HashMap(this.voiceConfiguration.getOffScreenUsers());
        map.put(Long.valueOf(userId), Boolean.valueOf(offScreen));
        setVoiceConfiguration(VoiceConfiguration.copy$default(voiceConfiguration, false, false, false, null, false, false, null, 0.0f, null, 0.0f, null, null, map, false, false, 28671, null));
    }

    public final synchronized void setUserOutputVolume(long userId, float volume) {
        VoiceConfiguration voiceConfiguration = this.voiceConfiguration;
        HashMap map = new HashMap(this.voiceConfiguration.getUserOutputVolumes());
        map.put(Long.valueOf(userId), Float.valueOf(volume));
        setVoiceConfiguration(VoiceConfiguration.copy$default(voiceConfiguration, false, false, false, null, false, false, null, 0.0f, null, 0.0f, null, map, null, false, false, 30719, null));
    }

    public final synchronized void setVADUseKrisp(VadUseKrisp status) {
        C12238m.checkNotNullParameter(status, "status");
        if (status != this.voiceConfiguration.getVadUseKrisp()) {
            setVoiceConfiguration(VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, status, false, false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32759, null));
        }
    }

    public final synchronized void setVoiceInputMode(MediaEngineConnection.InputMode inputMode) {
        C12238m.checkNotNullParameter(inputMode, "inputMode");
        setVoiceConfiguration(VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, null, false, false, null, 0.0f, inputMode, 0.0f, null, null, null, false, false, 32511, null));
        updateForceMute();
    }

    public final synchronized void toggleAutomaticGainControl() {
        VoiceConfiguration voiceConfiguration = this.voiceConfiguration;
        setVoiceConfiguration(VoiceConfiguration.copy$default(voiceConfiguration, false, false, false, null, !voiceConfiguration.getAutomaticGainControl(), false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32751, null));
    }

    public final synchronized void toggleAutomaticVAD() {
        VoiceConfiguration voiceConfiguration = this.voiceConfiguration;
        setVoiceConfiguration(VoiceConfiguration.copy$default(voiceConfiguration, false, false, !voiceConfiguration.getAutomaticVad(), null, false, false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32763, null));
    }

    public final synchronized void toggleEchoCancellation() {
        VoiceConfiguration voiceConfiguration = this.voiceConfiguration;
        setVoiceConfiguration(VoiceConfiguration.copy$default(voiceConfiguration, false, false, false, null, false, !voiceConfiguration.getEchoCancellation(), null, 0.0f, null, 0.0f, null, null, null, false, false, 32735, null));
    }

    public final synchronized void toggleEnableVideoHardwareScaling() {
        VoiceConfiguration voiceConfiguration = this.voiceConfiguration;
        setVoiceConfiguration(VoiceConfiguration.copy$default(voiceConfiguration, false, false, false, null, false, false, null, 0.0f, null, 0.0f, null, null, null, !voiceConfiguration.getEnableVideoHardwareScaling(), false, 24575, null));
    }

    public final synchronized void toggleNoiseCancellation() {
        NoiseProcessing noiseProcessing = this.voiceConfiguration.getNoiseProcessing();
        NoiseProcessing noiseProcessing2 = NoiseProcessing.Cancellation;
        if (noiseProcessing == noiseProcessing2) {
            setVoiceConfiguration(NoiseProcessing.Suppression);
        } else {
            setVoiceConfiguration(noiseProcessing2);
        }
    }

    public final synchronized void toggleNoiseSuppression() {
        NoiseProcessing noiseProcessing = this.voiceConfiguration.getNoiseProcessing();
        NoiseProcessing noiseProcessing2 = NoiseProcessing.Suppression;
        if (noiseProcessing == noiseProcessing2) {
            setVoiceConfiguration(NoiseProcessing.None);
        } else {
            setVoiceConfiguration(noiseProcessing2);
        }
    }

    public final synchronized void toggleSelfDeafened() {
        setSelfDeafen(!this.voiceConfiguration.isSelfDeafened());
    }

    public final synchronized SelfMuteFailure toggleSelfMuted() {
        return setSelfMuted(!this.voiceConfiguration.isSelfMuted());
    }

    public final synchronized void toggleUserMuted(long userId) {
        VoiceConfiguration voiceConfiguration = this.voiceConfiguration;
        HashMap map = new HashMap(this.voiceConfiguration.getMutedUsers());
        Boolean bool = (Boolean) map.get(Long.valueOf(userId));
        if (bool == null) {
            bool = Boolean.FALSE;
        }
        C12238m.checkNotNullExpressionValue(bool, "get(userId) ?: false");
        map.put(Long.valueOf(userId), Boolean.valueOf(!bool.booleanValue()));
        setVoiceConfiguration(VoiceConfiguration.copy$default(voiceConfiguration, false, false, false, null, false, false, null, 0.0f, null, 0.0f, map, null, null, false, false, 31743, null));
    }

    public final synchronized void toggleVADUseKrisp() {
        VadUseKrisp vadUseKrisp = this.voiceConfiguration.getVadUseKrisp();
        VadUseKrisp vadUseKrisp2 = VadUseKrisp.Enabled;
        if (vadUseKrisp == vadUseKrisp2) {
            vadUseKrisp2 = VadUseKrisp.Disabled;
        }
        setVoiceConfiguration(VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, vadUseKrisp2, false, false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32759, null));
    }

    public final synchronized void updateVoiceParticipantsHidden(boolean hidden) {
        if (this.voiceConfiguration.getVoiceParticipantsHidden() != hidden) {
            setVoiceConfiguration(VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, null, false, false, null, 0.0f, null, 0.0f, null, null, null, false, hidden, 16383, null));
        }
    }

    public StoreMediaSettings(StoreVoiceChannelSelected storeVoiceChannelSelected, StoreChannels storeChannels, StorePermissions storePermissions, VoiceConfigurationCache voiceConfigurationCache, AppSoundManager appSoundManager) {
        C12238m.checkNotNullParameter(storeVoiceChannelSelected, "storeVoiceChannelSelected");
        C12238m.checkNotNullParameter(storeChannels, "storeChannels");
        C12238m.checkNotNullParameter(storePermissions, "storePermissions");
        C12238m.checkNotNullParameter(voiceConfigurationCache, "voiceConfigurationCache");
        C12238m.checkNotNullParameter(appSoundManager, "appSoundManager");
        this.storeVoiceChannelSelected = storeVoiceChannelSelected;
        this.storeChannels = storeChannels;
        this.storePermissions = storePermissions;
        this.voiceConfigurationCache = voiceConfigurationCache;
        this.appSoundManager = appSoundManager;
        VoiceConfiguration default_voice_config = VoiceConfiguration.INSTANCE.getDEFAULT_VOICE_CONFIG();
        this.voiceConfiguration = default_voice_config;
        this.voiceConfigurationSubject = new SerializedSubject<>(BehaviorSubject.m11130l0(default_voice_config));
        this.canUseVad = true;
    }

    public final synchronized void setVoiceConfiguration(NoiseProcessing noiseProcessing) {
        C12238m.checkNotNullParameter(noiseProcessing, "noiseProcessing");
        if (noiseProcessing != this.voiceConfiguration.getNoiseProcessing()) {
            setVoiceConfiguration(VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, null, false, false, noiseProcessing, 0.0f, null, 0.0f, null, null, null, false, false, 32703, null));
        }
    }
}
