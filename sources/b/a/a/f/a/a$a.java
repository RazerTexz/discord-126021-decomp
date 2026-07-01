package b.a.a.f.a;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.rtcconnection.audio.DiscordAudioManager$DeviceTypes;

/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class a$a implements View$OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    public a$a(int i, Object obj) {
        this.j = i;
        this.k = obj;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        int i = this.j;
        if (i == 0) {
            a.h((a) this.k).j.selectOutputDevice(DiscordAudioManager$DeviceTypes.BLUETOOTH_HEADSET);
            a.g((a) this.k);
            return;
        }
        if (i == 1) {
            a.h((a) this.k).j.selectOutputDevice(DiscordAudioManager$DeviceTypes.SPEAKERPHONE);
            a.g((a) this.k);
        } else if (i == 2) {
            a.h((a) this.k).j.selectOutputDevice(DiscordAudioManager$DeviceTypes.WIRED_HEADSET);
            a.g((a) this.k);
        } else {
            if (i != 3) {
                throw null;
            }
            a.h((a) this.k).j.selectOutputDevice(DiscordAudioManager$DeviceTypes.EARPIECE);
            a.g((a) this.k);
        }
    }
}
