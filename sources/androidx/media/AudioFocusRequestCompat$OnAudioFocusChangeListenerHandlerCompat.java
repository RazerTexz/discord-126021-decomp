package androidx.media;

import android.media.AudioManager$OnAudioFocusChangeListener;
import android.os.Handler;
import android.os.Handler$Callback;
import android.os.Message;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class AudioFocusRequestCompat$OnAudioFocusChangeListenerHandlerCompat implements Handler$Callback, AudioManager$OnAudioFocusChangeListener {
    private static final int FOCUS_CHANGE = 2782386;
    private final Handler mHandler;
    private final AudioManager$OnAudioFocusChangeListener mListener;

    public AudioFocusRequestCompat$OnAudioFocusChangeListenerHandlerCompat(@NonNull AudioManager$OnAudioFocusChangeListener audioManager$OnAudioFocusChangeListener, @NonNull Handler handler) {
        this.mListener = audioManager$OnAudioFocusChangeListener;
        this.mHandler = new Handler(handler.getLooper(), this);
    }

    @Override // android.os.Handler$Callback
    public boolean handleMessage(Message message) {
        if (message.what != FOCUS_CHANGE) {
            return false;
        }
        this.mListener.onAudioFocusChange(message.arg1);
        return true;
    }

    @Override // android.media.AudioManager$OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
        Handler handler = this.mHandler;
        handler.sendMessage(Message.obtain(handler, FOCUS_CHANGE, i, 0));
    }
}
