package b.a.q.k0;

import android.media.AudioManager$OnAudioFocusChangeListener;
import com.discord.rtcconnection.audio.DiscordAudioManager;

/* JADX INFO: compiled from: DiscordAudioManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e implements AudioManager$OnAudioFocusChangeListener {
    public final /* synthetic */ DiscordAudioManager j;

    public e(DiscordAudioManager discordAudioManager) {
        this.j = discordAudioManager;
    }

    @Override // android.media.AudioManager$OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i) {
        b.c.a.a0.d.b1("DiscordAudioManager", "[AudioFocus] new focus: " + i);
        if (i == -3 || i == -2) {
            this.j.i(false);
        } else {
            if (i != 1) {
                return;
            }
            this.j.i(true);
            this.j.l();
        }
    }
}
