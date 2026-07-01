package androidx.media;

import android.media.AudioManager$OnAudioFocusChangeListener;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import b.d.b.a.a;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class AudioFocusRequestCompat$Builder {
    private AudioAttributesCompat mAudioAttributesCompat;
    private Handler mFocusChangeHandler;
    private int mFocusGain;
    private AudioManager$OnAudioFocusChangeListener mOnAudioFocusChangeListener;
    private boolean mPauseOnDuck;

    public AudioFocusRequestCompat$Builder(int i) {
        this.mAudioAttributesCompat = AudioFocusRequestCompat.FOCUS_DEFAULT_ATTR;
        setFocusGain(i);
    }

    private static boolean isValidFocusGain(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    public AudioFocusRequestCompat build() {
        if (this.mOnAudioFocusChangeListener != null) {
            return new AudioFocusRequestCompat(this.mFocusGain, this.mOnAudioFocusChangeListener, this.mFocusChangeHandler, this.mAudioAttributesCompat, this.mPauseOnDuck);
        }
        throw new IllegalStateException("Can't build an AudioFocusRequestCompat instance without a listener");
    }

    @NonNull
    public AudioFocusRequestCompat$Builder setAudioAttributes(@NonNull AudioAttributesCompat audioAttributesCompat) {
        Objects.requireNonNull(audioAttributesCompat, "Illegal null AudioAttributes");
        this.mAudioAttributesCompat = audioAttributesCompat;
        return this;
    }

    @NonNull
    public AudioFocusRequestCompat$Builder setFocusGain(int i) {
        if (!isValidFocusGain(i)) {
            throw new IllegalArgumentException(a.q("Illegal audio focus gain type ", i));
        }
        this.mFocusGain = i;
        return this;
    }

    @NonNull
    public AudioFocusRequestCompat$Builder setOnAudioFocusChangeListener(@NonNull AudioManager$OnAudioFocusChangeListener audioManager$OnAudioFocusChangeListener) {
        return setOnAudioFocusChangeListener(audioManager$OnAudioFocusChangeListener, new Handler(Looper.getMainLooper()));
    }

    @NonNull
    public AudioFocusRequestCompat$Builder setWillPauseWhenDucked(boolean z2) {
        this.mPauseOnDuck = z2;
        return this;
    }

    @NonNull
    public AudioFocusRequestCompat$Builder setOnAudioFocusChangeListener(@NonNull AudioManager$OnAudioFocusChangeListener audioManager$OnAudioFocusChangeListener, @NonNull Handler handler) {
        if (audioManager$OnAudioFocusChangeListener == null) {
            throw new IllegalArgumentException("OnAudioFocusChangeListener must not be null");
        }
        if (handler == null) {
            throw new IllegalArgumentException("Handler must not be null");
        }
        this.mOnAudioFocusChangeListener = audioManager$OnAudioFocusChangeListener;
        this.mFocusChangeHandler = handler;
        return this;
    }

    public AudioFocusRequestCompat$Builder(@NonNull AudioFocusRequestCompat audioFocusRequestCompat) {
        this.mAudioAttributesCompat = AudioFocusRequestCompat.FOCUS_DEFAULT_ATTR;
        if (audioFocusRequestCompat != null) {
            this.mFocusGain = audioFocusRequestCompat.getFocusGain();
            this.mOnAudioFocusChangeListener = audioFocusRequestCompat.getOnAudioFocusChangeListener();
            this.mFocusChangeHandler = audioFocusRequestCompat.getFocusChangeHandler();
            this.mAudioAttributesCompat = audioFocusRequestCompat.getAudioAttributesCompat();
            this.mPauseOnDuck = audioFocusRequestCompat.willPauseWhenDucked();
            return;
        }
        throw new IllegalArgumentException("AudioFocusRequestCompat to copy must not be null");
    }
}
