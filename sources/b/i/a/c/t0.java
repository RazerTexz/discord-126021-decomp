package b.i.a.c;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioFocusRequest$Builder;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.Objects;
import org.webrtc.MediaStreamTrack;

/* JADX INFO: compiled from: AudioFocusManager.java */
/* JADX INFO: loaded from: classes3.dex */
public final class t0 {
    public final AudioManager a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t0$a f1114b;

    @Nullable
    public t0$b c;

    @Nullable
    public b.i.a.c.t2.o d;
    public int e;
    public int f;
    public float g = 1.0f;
    public AudioFocusRequest h;

    public t0(Context context, Handler handler, t0$b t0_b) {
        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        Objects.requireNonNull(audioManager);
        this.a = audioManager;
        this.c = t0_b;
        this.f1114b = new t0$a(this, handler);
        this.e = 0;
    }

    public final void a() {
        if (this.e == 0) {
            return;
        }
        if (b.i.a.c.f3.e0.a >= 26) {
            AudioFocusRequest audioFocusRequest = this.h;
            if (audioFocusRequest != null) {
                this.a.abandonAudioFocusRequest(audioFocusRequest);
            }
        } else {
            this.a.abandonAudioFocus(this.f1114b);
        }
        d(0);
    }

    public final void b(int i) {
        t0$b t0_b = this.c;
        if (t0_b != null) {
            k2$b k2_b = (k2$b) t0_b;
            boolean zJ = k2_b.j.j();
            k2_b.j.m0(zJ, i, k2.g0(zJ, i));
        }
    }

    public void c(@Nullable b.i.a.c.t2.o oVar) {
        if (b.i.a.c.f3.e0.a(this.d, null)) {
            return;
        }
        this.d = null;
        this.f = 0;
        b.c.a.a0.d.m(true, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
    }

    public final void d(int i) {
        if (this.e == i) {
            return;
        }
        this.e = i;
        float f = i == 3 ? 0.2f : 1.0f;
        if (this.g == f) {
            return;
        }
        this.g = f;
        t0$b t0_b = this.c;
        if (t0_b != null) {
            k2 k2Var = ((k2$b) t0_b).j;
            k2Var.j0(1, 2, Float.valueOf(k2Var.B * k2Var.k.g));
        }
    }

    public int e(boolean z2, int i) {
        int iRequestAudioFocus;
        int i2 = 1;
        if (i == 1 || this.f != 1) {
            a();
            return z2 ? 1 : -1;
        }
        if (!z2) {
            return -1;
        }
        if (this.e != 1) {
            if (b.i.a.c.f3.e0.a >= 26) {
                AudioFocusRequest audioFocusRequest = this.h;
                if (audioFocusRequest == null) {
                    AudioFocusRequest$Builder audioFocusRequest$Builder = audioFocusRequest == null ? new AudioFocusRequest$Builder(this.f) : new AudioFocusRequest$Builder(this.h);
                    b.i.a.c.t2.o oVar = this.d;
                    boolean z3 = oVar != null && oVar.k == 1;
                    Objects.requireNonNull(oVar);
                    this.h = audioFocusRequest$Builder.setAudioAttributes(oVar.a()).setWillPauseWhenDucked(z3).setOnAudioFocusChangeListener(this.f1114b).build();
                }
                iRequestAudioFocus = this.a.requestAudioFocus(this.h);
            } else {
                AudioManager audioManager = this.a;
                t0$a t0_a = this.f1114b;
                b.i.a.c.t2.o oVar2 = this.d;
                Objects.requireNonNull(oVar2);
                iRequestAudioFocus = audioManager.requestAudioFocus(t0_a, b.i.a.c.f3.e0.t(oVar2.m), this.f);
            }
            if (iRequestAudioFocus == 1) {
                d(1);
            } else {
                d(0);
                i2 = -1;
            }
        }
        return i2;
    }
}
