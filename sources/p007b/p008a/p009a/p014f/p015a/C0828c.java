package p007b.p008a.p009a.p014f.p015a;

import com.discord.rtcconnection.audio.DiscordAudioManager;
import com.discord.stores.StoreAudioManagerV2;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.a.f.a.c */
/* JADX INFO: compiled from: AudioOutputSelectionDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0828c extends AbstractC12240o implements Function1<StoreAudioManagerV2.State, Unit> {
    public final /* synthetic */ C0829d this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0828c(C0829d c0829d) {
        super(1);
        this.this$0 = c0829d;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(StoreAudioManagerV2.State state) {
        StoreAudioManagerV2.State state2 = state;
        C12238m.checkNotNullParameter(state2, "storeState");
        C0829d c0829d = this.this$0;
        Objects.requireNonNull(c0829d);
        List<DiscordAudioManager.AudioDevice> audioDevices = state2.getAudioDevices();
        DiscordAudioManager.DeviceTypes activeAudioDevice = state2.getActiveAudioDevice();
        DiscordAudioManager.DeviceTypes deviceTypes = DiscordAudioManager.DeviceTypes.BLUETOOTH_HEADSET;
        c0829d.updateViewState(new C0829d.a.C13208a(activeAudioDevice, audioDevices.get(deviceTypes.getValue()).isAvailable, audioDevices.get(deviceTypes.getValue()).com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_NAME java.lang.String, audioDevices.get(DiscordAudioManager.DeviceTypes.SPEAKERPHONE.getValue()).isAvailable, audioDevices.get(DiscordAudioManager.DeviceTypes.WIRED_HEADSET.getValue()).isAvailable, audioDevices.get(DiscordAudioManager.DeviceTypes.EARPIECE.getValue()).isAvailable));
        return Unit.f27425a;
    }
}
