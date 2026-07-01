package androidx.media;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioFocusRequest$Builder;
import android.media.AudioManager$OnAudioFocusChangeListener;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
public class AudioFocusRequestCompat$Api26Impl {
    private AudioFocusRequestCompat$Api26Impl() {
    }

    @DoNotInline
    public static AudioFocusRequest createInstance(int i, AudioAttributes audioAttributes, boolean z2, AudioManager$OnAudioFocusChangeListener audioManager$OnAudioFocusChangeListener, Handler handler) {
        return new AudioFocusRequest$Builder(i).setAudioAttributes(audioAttributes).setWillPauseWhenDucked(z2).setOnAudioFocusChangeListener(audioManager$OnAudioFocusChangeListener, handler).build();
    }
}
