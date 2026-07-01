package b.a.a.f.a;

import com.discord.rtcconnection.audio.DiscordAudioManager$AudioDevice;
import com.discord.rtcconnection.audio.DiscordAudioManager$DeviceTypes;
import com.discord.stores.StoreAudioManagerV2$State;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AudioOutputSelectionDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c extends o implements Function1<StoreAudioManagerV2$State, Unit> {
    public final /* synthetic */ d this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar) {
        super(1);
        this.this$0 = dVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(StoreAudioManagerV2$State storeAudioManagerV2$State) {
        StoreAudioManagerV2$State storeAudioManagerV2$State2 = storeAudioManagerV2$State;
        m.checkNotNullParameter(storeAudioManagerV2$State2, "storeState");
        d dVar = this.this$0;
        Objects.requireNonNull(dVar);
        List<DiscordAudioManager$AudioDevice> audioDevices = storeAudioManagerV2$State2.getAudioDevices();
        DiscordAudioManager$DeviceTypes activeAudioDevice = storeAudioManagerV2$State2.getActiveAudioDevice();
        DiscordAudioManager$DeviceTypes discordAudioManager$DeviceTypes = DiscordAudioManager$DeviceTypes.BLUETOOTH_HEADSET;
        dVar.updateViewState(new d$a$a(activeAudioDevice, audioDevices.get(discordAudioManager$DeviceTypes.getValue()).isAvailable, audioDevices.get(discordAudioManager$DeviceTypes.getValue()).com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_NAME java.lang.String, audioDevices.get(DiscordAudioManager$DeviceTypes.SPEAKERPHONE.getValue()).isAvailable, audioDevices.get(DiscordAudioManager$DeviceTypes.WIRED_HEADSET.getValue()).isAvailable, audioDevices.get(DiscordAudioManager$DeviceTypes.EARPIECE.getValue()).isAvailable));
        return Unit.a;
    }
}
