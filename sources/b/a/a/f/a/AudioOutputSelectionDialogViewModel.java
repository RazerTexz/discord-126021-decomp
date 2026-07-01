package b.a.a.f.a;

import b.a.a.f.a.AudioOutputSelectionDialogViewModel2;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import com.discord.stores.StoreAudioManagerV2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.a.f.a.c, reason: use source file name */
/* JADX INFO: compiled from: AudioOutputSelectionDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AudioOutputSelectionDialogViewModel extends Lambda implements Function1<StoreAudioManagerV2.State, Unit> {
    public final /* synthetic */ AudioOutputSelectionDialogViewModel2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioOutputSelectionDialogViewModel(AudioOutputSelectionDialogViewModel2 audioOutputSelectionDialogViewModel2) {
        super(1);
        this.this$0 = audioOutputSelectionDialogViewModel2;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(StoreAudioManagerV2.State state) {
        StoreAudioManagerV2.State state2 = state;
        Intrinsics3.checkNotNullParameter(state2, "storeState");
        AudioOutputSelectionDialogViewModel2 audioOutputSelectionDialogViewModel2 = this.this$0;
        Objects.requireNonNull(audioOutputSelectionDialogViewModel2);
        List<DiscordAudioManager.AudioDevice> audioDevices = state2.getAudioDevices();
        DiscordAudioManager.DeviceTypes activeAudioDevice = state2.getActiveAudioDevice();
        DiscordAudioManager.DeviceTypes deviceTypes = DiscordAudioManager.DeviceTypes.BLUETOOTH_HEADSET;
        audioOutputSelectionDialogViewModel2.updateViewState(new AudioOutputSelectionDialogViewModel2.a.C0012a(activeAudioDevice, audioDevices.get(deviceTypes.getValue()).isAvailable, audioDevices.get(deviceTypes.getValue()).com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_NAME java.lang.String, audioDevices.get(DiscordAudioManager.DeviceTypes.SPEAKERPHONE.getValue()).isAvailable, audioDevices.get(DiscordAudioManager.DeviceTypes.WIRED_HEADSET.getValue()).isAvailable, audioDevices.get(DiscordAudioManager.DeviceTypes.EARPIECE.getValue()).isAvailable));
        return Unit.a;
    }
}
