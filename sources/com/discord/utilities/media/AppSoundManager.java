package com.discord.utilities.media;

import android.app.Application;
import android.content.Context;
import d0.z.d.m;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: AppSoundManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppSoundManager {
    private final Context context;
    private Map<Integer, AppSoundManager$SoundPlayer> soundPlayers;

    public AppSoundManager(Application application) {
        m.checkNotNullParameter(application, "application");
        this.context = application;
        this.soundPlayers = new LinkedHashMap();
    }

    public final boolean isPlaying(AppSound sound) {
        m.checkNotNullParameter(sound, "sound");
        return this.soundPlayers.containsKey(Integer.valueOf(sound.getResId()));
    }

    public final void play(AppSound sound) {
        m.checkNotNullParameter(sound, "sound");
        if (isPlaying(sound)) {
            AppSoundManager$SoundPlayer appSoundManager$SoundPlayer = this.soundPlayers.get(Integer.valueOf(sound.getResId()));
            if (appSoundManager$SoundPlayer != null) {
                appSoundManager$SoundPlayer.stop();
            }
            AppSoundManager$SoundPlayer appSoundManager$SoundPlayer2 = this.soundPlayers.get(Integer.valueOf(sound.getResId()));
            if (appSoundManager$SoundPlayer2 != null) {
                appSoundManager$SoundPlayer2.release();
            }
        }
        this.soundPlayers.put(Integer.valueOf(sound.getResId()), new AppSoundManager$SoundPlayer(this.context, sound, new AppSoundManager$play$1(this, sound)));
        AppSoundManager$SoundPlayer appSoundManager$SoundPlayer3 = this.soundPlayers.get(Integer.valueOf(sound.getResId()));
        if (appSoundManager$SoundPlayer3 != null) {
            appSoundManager$SoundPlayer3.start();
        }
    }

    public final void stop(AppSound sound) {
        AppSoundManager$SoundPlayer appSoundManager$SoundPlayer;
        m.checkNotNullParameter(sound, "sound");
        AppSoundManager$SoundPlayer appSoundManager$SoundPlayer2 = this.soundPlayers.get(Integer.valueOf(sound.getResId()));
        if (appSoundManager$SoundPlayer2 != null && appSoundManager$SoundPlayer2.isPlaying() && (appSoundManager$SoundPlayer = this.soundPlayers.get(Integer.valueOf(sound.getResId()))) != null) {
            appSoundManager$SoundPlayer.stop();
        }
        AppSoundManager$SoundPlayer appSoundManager$SoundPlayer3 = this.soundPlayers.get(Integer.valueOf(sound.getResId()));
        if (appSoundManager$SoundPlayer3 != null) {
            appSoundManager$SoundPlayer3.release();
        }
        this.soundPlayers.remove(Integer.valueOf(sound.getResId()));
    }
}
