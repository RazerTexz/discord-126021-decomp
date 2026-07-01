package b.a.q.k0;

import android.media.AudioManager;
import b.c.a.a0.AnimatableValueParser;
import com.discord.rtcconnection.audio.DiscordAudioManager;

/* JADX INFO: renamed from: b.a.q.k0.e, reason: use source file name */
/* JADX INFO: compiled from: DiscordAudioManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DiscordAudioManager2 implements AudioManager.OnAudioFocusChangeListener {
    public final /* synthetic */ DiscordAudioManager j;

    public DiscordAudioManager2(DiscordAudioManager discordAudioManager) {
        this.j = discordAudioManager;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i) {
        AnimatableValueParser.b1("DiscordAudioManager", "[AudioFocus] new focus: " + i);
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
