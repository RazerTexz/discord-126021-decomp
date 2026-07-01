package com.discord.stores;

import android.content.Context;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$InputMode;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.media.AppSound;
import com.discord.utilities.media.AppSoundManager;
import com.discord.utilities.media.AppSoundManager$Provider;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: StoreMediaSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMediaSettings extends Store {
    private final AppSoundManager appSoundManager;
    private boolean canUseVad;
    private StoreMediaSettings$SelfMuteFailure forceSelfMuteReason;
    private final StoreChannels storeChannels;
    private final StorePermissions storePermissions;
    private final StoreVoiceChannelSelected storeVoiceChannelSelected;
    private StoreMediaSettings$VoiceConfiguration voiceConfiguration;
    private final VoiceConfigurationCache voiceConfigurationCache;
    private final SerializedSubject<StoreMediaSettings$VoiceConfiguration, StoreMediaSettings$VoiceConfiguration> voiceConfigurationSubject;

    public /* synthetic */ StoreMediaSettings(StoreVoiceChannelSelected storeVoiceChannelSelected, StoreChannels storeChannels, StorePermissions storePermissions, VoiceConfigurationCache voiceConfigurationCache, AppSoundManager appSoundManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeVoiceChannelSelected, storeChannels, storePermissions, (i & 8) != 0 ? new VoiceConfigurationCache(SharedPreferencesProvider.INSTANCE.get()) : voiceConfigurationCache, (i & 16) != 0 ? AppSoundManager$Provider.INSTANCE.get() : appSoundManager);
    }

    public static final /* synthetic */ StoreChannels access$getStoreChannels$p(StoreMediaSettings storeMediaSettings) {
        return storeMediaSettings.storeChannels;
    }

    public static final /* synthetic */ StorePermissions access$getStorePermissions$p(StoreMediaSettings storeMediaSettings) {
        return storeMediaSettings.storePermissions;
    }

    public static final /* synthetic */ void access$handleCanUseVad(StoreMediaSettings storeMediaSettings, boolean z2) {
        storeMediaSettings.handleCanUseVad(z2);
    }

    private final synchronized void handleCanUseVad(boolean canUseVad) {
        this.canUseVad = canUseVad;
        updateForceMute();
    }

    private final void setVoiceConfiguration(StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration) {
        this.voiceConfiguration = storeMediaSettings$VoiceConfiguration;
        this.voiceConfigurationSubject.k.onNext(storeMediaSettings$VoiceConfiguration);
        this.voiceConfigurationCache.write(storeMediaSettings$VoiceConfiguration);
    }

    private final void updateForceMute() {
        this.forceSelfMuteReason = null;
        if (!this.canUseVad && this.voiceConfiguration.getInputMode() == MediaEngineConnection$InputMode.VOICE_ACTIVITY) {
            this.forceSelfMuteReason = StoreMediaSettings$SelfMuteFailure.CANNOT_USE_VAD;
        }
        if (this.forceSelfMuteReason != null) {
            setVoiceConfiguration(StoreMediaSettings$VoiceConfiguration.copy$default(this.voiceConfiguration, true, false, false, null, false, false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32766, null));
        }
    }

    public final Observable<MediaEngineConnection$InputMode> getInputMode() {
        Observable<R> observableG = this.voiceConfigurationSubject.G(StoreMediaSettings$getInputMode$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "voiceConfigurationSubjec…    .map { it.inputMode }");
        Observable<MediaEngineConnection$InputMode> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
        m.checkNotNullExpressionValue(observableR, "voiceConfigurationSubjec…  .distinctUntilChanged()");
        return observableR;
    }

    public final synchronized Map<Long, Boolean> getMutedUsers() {
        return this.voiceConfiguration.getMutedUsers();
    }

    public final Observable<Map<Long, Boolean>> getUsersMuted() {
        Observable<R> observableG = this.voiceConfigurationSubject.G(StoreMediaSettings$getUsersMuted$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "voiceConfigurationSubjec…   .map { it.mutedUsers }");
        Observable<Map<Long, Boolean>> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
        m.checkNotNullExpressionValue(observableR, "voiceConfigurationSubjec…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Boolean>> getUsersOffScreen() {
        Observable<R> observableG = this.voiceConfigurationSubject.G(StoreMediaSettings$getUsersOffScreen$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "voiceConfigurationSubjec…map { it.offScreenUsers }");
        Observable<Map<Long, Boolean>> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
        m.checkNotNullExpressionValue(observableR, "voiceConfigurationSubjec…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Float>> getUsersVolume() {
        Observable<R> observableG = this.voiceConfigurationSubject.G(StoreMediaSettings$getUsersVolume$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "voiceConfigurationSubjec… { it.userOutputVolumes }");
        Observable<Map<Long, Float>> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
        m.checkNotNullExpressionValue(observableR, "voiceConfigurationSubjec…  .distinctUntilChanged()");
        return observableR;
    }

    public final synchronized boolean getVideoHardwareScalingBlocking() {
        return this.voiceConfiguration.getEnableVideoHardwareScaling();
    }

    public final Observable<StoreMediaSettings$VoiceConfiguration> getVoiceConfig() {
        Observable<StoreMediaSettings$VoiceConfiguration> observableR = ObservableExtensionsKt.computationLatest(this.voiceConfigurationSubject).r();
        m.checkNotNullExpressionValue(observableR, "voiceConfigurationSubjec…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<StoreMediaSettings$VoiceConfiguration> getVoiceConfiguration() {
        return this.voiceConfigurationSubject;
    }

    public final synchronized StoreMediaSettings$VoiceConfiguration getVoiceConfigurationBlocking() {
        return this.voiceConfiguration;
    }

    @StoreThread
    public final void handleVoiceChannelSelected(long channelId) {
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease = this.storeChannels.findChannelByIdInternal$app_productionGoogleRelease(channelId);
        if (channelFindChannelByIdInternal$app_productionGoogleRelease == null || !ChannelUtils.B(channelFindChannelByIdInternal$app_productionGoogleRelease)) {
            return;
        }
        setSelfDeafen(false);
    }

    public final void init() {
        setVoiceConfiguration(this.voiceConfigurationCache.read());
        Observable<R> observableY = this.storeVoiceChannelSelected.observeSelectedVoiceChannelId().Y(new StoreMediaSettings$init$1(this));
        m.checkNotNullExpressionValue(observableY, "storeVoiceChannelSelecte…              }\n        }");
        ObservableExtensionsKt.appSubscribe$default(observableY, StoreMediaSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreMediaSettings$init$2(this), 62, (Object) null);
    }

    public final Observable<Boolean> isSelfDeafened() {
        Observable<R> observableG = this.voiceConfigurationSubject.G(StoreMediaSettings$isSelfDeafened$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "voiceConfigurationSubjec…map { it.isSelfDeafened }");
        Observable<Boolean> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
        m.checkNotNullExpressionValue(observableR, "voiceConfigurationSubjec…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Boolean> isSelfMuted() {
        Observable<R> observableG = this.voiceConfigurationSubject.G(StoreMediaSettings$isSelfMuted$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "voiceConfigurationSubjec….map { it.isSelfMuted() }");
        Observable<Boolean> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
        m.checkNotNullExpressionValue(observableR, "voiceConfigurationSubjec…  .distinctUntilChanged()");
        return observableR;
    }

    public final synchronized void revertTemporaryDisableKrisp() {
        StoreMediaSettings$VadUseKrisp vadUseKrisp = this.voiceConfiguration.getVadUseKrisp().ordinal() != 2 ? this.voiceConfiguration.getVadUseKrisp() : StoreMediaSettings$VadUseKrisp.Enabled;
        StoreMediaSettings$NoiseProcessing noiseProcessing = this.voiceConfiguration.getNoiseProcessing().ordinal() != 3 ? this.voiceConfiguration.getNoiseProcessing() : StoreMediaSettings$NoiseProcessing.Cancellation;
        if (noiseProcessing != this.voiceConfiguration.getNoiseProcessing() || vadUseKrisp != this.voiceConfiguration.getVadUseKrisp()) {
            setVoiceConfiguration(StoreMediaSettings$VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, vadUseKrisp, false, false, noiseProcessing, 0.0f, null, 0.0f, null, null, null, false, false, 32695, null));
        }
    }

    public final synchronized void setNoiseProcessing(StoreMediaSettings$NoiseProcessing noiseProcessing) {
        m.checkNotNullParameter(noiseProcessing, "noiseProcessing");
        if (noiseProcessing != this.voiceConfiguration.getNoiseProcessing()) {
            setVoiceConfiguration(StoreMediaSettings$VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, null, false, false, noiseProcessing, 0.0f, null, 0.0f, null, null, null, false, false, 32703, null));
        }
    }

    public final synchronized void setOutputVolume(float outputVolume) {
        setVoiceConfiguration(StoreMediaSettings$VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, null, false, false, null, 0.0f, null, outputVolume, null, null, null, false, false, 32255, null));
    }

    public final synchronized void setSelfDeafen(boolean isDeafened) {
        if (this.voiceConfiguration.isSelfDeafened() == isDeafened) {
            return;
        }
        setVoiceConfiguration(StoreMediaSettings$VoiceConfiguration.copy$default(this.voiceConfiguration, false, isDeafened, false, null, false, false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32765, null));
        this.appSoundManager.play(isDeafened ? AppSound.Companion.getSOUND_DEAFEN() : AppSound.Companion.getSOUND_UNDEAFEN());
    }

    public final synchronized StoreMediaSettings$SelfMuteFailure setSelfMuted(boolean isMuted) {
        if (this.voiceConfiguration.isSelfMuted() == isMuted) {
            return null;
        }
        StoreMediaSettings$SelfMuteFailure storeMediaSettings$SelfMuteFailure = this.forceSelfMuteReason;
        if (storeMediaSettings$SelfMuteFailure != null) {
            return storeMediaSettings$SelfMuteFailure;
        }
        StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration = this.voiceConfiguration;
        setVoiceConfiguration(StoreMediaSettings$VoiceConfiguration.copy$default(storeMediaSettings$VoiceConfiguration, isMuted, storeMediaSettings$VoiceConfiguration.isSelfDeafened() && isMuted, false, null, false, false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32764, null));
        this.appSoundManager.play(isMuted ? AppSound.Companion.getSOUND_MUTE() : AppSound.Companion.getSOUND_UNMUTE());
        return null;
    }

    public final synchronized void setSensitivity(float sensitivity) {
        setVoiceConfiguration(StoreMediaSettings$VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, null, false, false, null, sensitivity, null, 0.0f, null, null, null, false, false, 32639, null));
    }

    public final synchronized void setUserOffScreen(long userId, boolean offScreen) {
        StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration = this.voiceConfiguration;
        HashMap map = new HashMap(this.voiceConfiguration.getOffScreenUsers());
        map.put(Long.valueOf(userId), Boolean.valueOf(offScreen));
        setVoiceConfiguration(StoreMediaSettings$VoiceConfiguration.copy$default(storeMediaSettings$VoiceConfiguration, false, false, false, null, false, false, null, 0.0f, null, 0.0f, null, null, map, false, false, 28671, null));
    }

    public final synchronized void setUserOutputVolume(long userId, float volume) {
        StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration = this.voiceConfiguration;
        HashMap map = new HashMap(this.voiceConfiguration.getUserOutputVolumes());
        map.put(Long.valueOf(userId), Float.valueOf(volume));
        setVoiceConfiguration(StoreMediaSettings$VoiceConfiguration.copy$default(storeMediaSettings$VoiceConfiguration, false, false, false, null, false, false, null, 0.0f, null, 0.0f, null, map, null, false, false, 30719, null));
    }

    public final synchronized void setVADUseKrisp(StoreMediaSettings$VadUseKrisp status) {
        m.checkNotNullParameter(status, "status");
        if (status != this.voiceConfiguration.getVadUseKrisp()) {
            setVoiceConfiguration(StoreMediaSettings$VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, status, false, false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32759, null));
        }
    }

    public final synchronized void setVoiceInputMode(MediaEngineConnection$InputMode inputMode) {
        m.checkNotNullParameter(inputMode, "inputMode");
        setVoiceConfiguration(StoreMediaSettings$VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, null, false, false, null, 0.0f, inputMode, 0.0f, null, null, null, false, false, 32511, null));
        updateForceMute();
    }

    public final synchronized void toggleAutomaticGainControl() {
        StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration = this.voiceConfiguration;
        setVoiceConfiguration(StoreMediaSettings$VoiceConfiguration.copy$default(storeMediaSettings$VoiceConfiguration, false, false, false, null, !storeMediaSettings$VoiceConfiguration.getAutomaticGainControl(), false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32751, null));
    }

    public final synchronized void toggleAutomaticVAD() {
        StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration = this.voiceConfiguration;
        setVoiceConfiguration(StoreMediaSettings$VoiceConfiguration.copy$default(storeMediaSettings$VoiceConfiguration, false, false, !storeMediaSettings$VoiceConfiguration.getAutomaticVad(), null, false, false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32763, null));
    }

    public final synchronized void toggleEchoCancellation() {
        StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration = this.voiceConfiguration;
        setVoiceConfiguration(StoreMediaSettings$VoiceConfiguration.copy$default(storeMediaSettings$VoiceConfiguration, false, false, false, null, false, !storeMediaSettings$VoiceConfiguration.getEchoCancellation(), null, 0.0f, null, 0.0f, null, null, null, false, false, 32735, null));
    }

    public final synchronized void toggleEnableVideoHardwareScaling() {
        StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration = this.voiceConfiguration;
        setVoiceConfiguration(StoreMediaSettings$VoiceConfiguration.copy$default(storeMediaSettings$VoiceConfiguration, false, false, false, null, false, false, null, 0.0f, null, 0.0f, null, null, null, !storeMediaSettings$VoiceConfiguration.getEnableVideoHardwareScaling(), false, 24575, null));
    }

    public final synchronized void toggleNoiseCancellation() {
        StoreMediaSettings$NoiseProcessing noiseProcessing = this.voiceConfiguration.getNoiseProcessing();
        StoreMediaSettings$NoiseProcessing storeMediaSettings$NoiseProcessing = StoreMediaSettings$NoiseProcessing.Cancellation;
        if (noiseProcessing == storeMediaSettings$NoiseProcessing) {
            setVoiceConfiguration(StoreMediaSettings$NoiseProcessing.Suppression);
        } else {
            setVoiceConfiguration(storeMediaSettings$NoiseProcessing);
        }
    }

    public final synchronized void toggleNoiseSuppression() {
        StoreMediaSettings$NoiseProcessing noiseProcessing = this.voiceConfiguration.getNoiseProcessing();
        StoreMediaSettings$NoiseProcessing storeMediaSettings$NoiseProcessing = StoreMediaSettings$NoiseProcessing.Suppression;
        if (noiseProcessing == storeMediaSettings$NoiseProcessing) {
            setVoiceConfiguration(StoreMediaSettings$NoiseProcessing.None);
        } else {
            setVoiceConfiguration(storeMediaSettings$NoiseProcessing);
        }
    }

    public final synchronized void toggleSelfDeafened() {
        setSelfDeafen(!this.voiceConfiguration.isSelfDeafened());
    }

    public final synchronized StoreMediaSettings$SelfMuteFailure toggleSelfMuted() {
        return setSelfMuted(!this.voiceConfiguration.isSelfMuted());
    }

    public final synchronized void toggleUserMuted(long userId) {
        StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration = this.voiceConfiguration;
        HashMap map = new HashMap(this.voiceConfiguration.getMutedUsers());
        Boolean bool = (Boolean) map.get(Long.valueOf(userId));
        if (bool == null) {
            bool = Boolean.FALSE;
        }
        m.checkNotNullExpressionValue(bool, "get(userId) ?: false");
        map.put(Long.valueOf(userId), Boolean.valueOf(!bool.booleanValue()));
        setVoiceConfiguration(StoreMediaSettings$VoiceConfiguration.copy$default(storeMediaSettings$VoiceConfiguration, false, false, false, null, false, false, null, 0.0f, null, 0.0f, map, null, null, false, false, 31743, null));
    }

    public final synchronized void toggleVADUseKrisp() {
        StoreMediaSettings$VadUseKrisp vadUseKrisp = this.voiceConfiguration.getVadUseKrisp();
        StoreMediaSettings$VadUseKrisp storeMediaSettings$VadUseKrisp = StoreMediaSettings$VadUseKrisp.Enabled;
        if (vadUseKrisp == storeMediaSettings$VadUseKrisp) {
            storeMediaSettings$VadUseKrisp = StoreMediaSettings$VadUseKrisp.Disabled;
        }
        setVoiceConfiguration(StoreMediaSettings$VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, storeMediaSettings$VadUseKrisp, false, false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32759, null));
    }

    public final synchronized void updateVoiceParticipantsHidden(boolean hidden) {
        if (this.voiceConfiguration.getVoiceParticipantsHidden() != hidden) {
            setVoiceConfiguration(StoreMediaSettings$VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, null, false, false, null, 0.0f, null, 0.0f, null, null, null, false, hidden, 16383, null));
        }
    }

    public StoreMediaSettings(StoreVoiceChannelSelected storeVoiceChannelSelected, StoreChannels storeChannels, StorePermissions storePermissions, VoiceConfigurationCache voiceConfigurationCache, AppSoundManager appSoundManager) {
        m.checkNotNullParameter(storeVoiceChannelSelected, "storeVoiceChannelSelected");
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(storePermissions, "storePermissions");
        m.checkNotNullParameter(voiceConfigurationCache, "voiceConfigurationCache");
        m.checkNotNullParameter(appSoundManager, "appSoundManager");
        this.storeVoiceChannelSelected = storeVoiceChannelSelected;
        this.storeChannels = storeChannels;
        this.storePermissions = storePermissions;
        this.voiceConfigurationCache = voiceConfigurationCache;
        this.appSoundManager = appSoundManager;
        StoreMediaSettings$VoiceConfiguration default_voice_config = StoreMediaSettings$VoiceConfiguration.Companion.getDEFAULT_VOICE_CONFIG();
        this.voiceConfiguration = default_voice_config;
        this.voiceConfigurationSubject = new SerializedSubject<>(BehaviorSubject.l0(default_voice_config));
        this.canUseVad = true;
    }

    public final synchronized void setVoiceConfiguration(StoreMediaSettings$NoiseProcessing noiseProcessing) {
        m.checkNotNullParameter(noiseProcessing, "noiseProcessing");
        if (noiseProcessing != this.voiceConfiguration.getNoiseProcessing()) {
            setVoiceConfiguration(StoreMediaSettings$VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, null, false, false, noiseProcessing, 0.0f, null, 0.0f, null, null, null, false, false, 32703, null));
        }
    }
}
