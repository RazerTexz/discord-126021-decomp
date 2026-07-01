package androidx.media;

import android.media.AudioManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(28)
public class AudioManagerCompat$Api28Impl {
    private AudioManagerCompat$Api28Impl() {
    }

    @DoNotInline
    public static int getStreamMinVolume(AudioManager audioManager, int i) {
        return audioManager.getStreamMinVolume(i);
    }
}
