package p007b.p225i.p226a.p242c;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.Objects;
import org.webrtc.MediaStreamTrack;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.C2816k2;
import p007b.p225i.p226a.p242c.C2909t0;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p263t2.C2931o;

/* JADX INFO: renamed from: b.i.a.c.t0 */
/* JADX INFO: compiled from: AudioFocusManager.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2909t0 {

    /* JADX INFO: renamed from: a */
    public final AudioManager f7658a;

    /* JADX INFO: renamed from: b */
    public final a f7659b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public b f7660c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public C2931o f7661d;

    /* JADX INFO: renamed from: e */
    public int f7662e;

    /* JADX INFO: renamed from: f */
    public int f7663f;

    /* JADX INFO: renamed from: g */
    public float f7664g = 1.0f;

    /* JADX INFO: renamed from: h */
    public AudioFocusRequest f7665h;

    /* JADX INFO: renamed from: b.i.a.c.t0$a */
    /* JADX INFO: compiled from: AudioFocusManager.java */
    public class a implements AudioManager.OnAudioFocusChangeListener {

        /* JADX INFO: renamed from: j */
        public final Handler f7666j;

        public a(Handler handler) {
            this.f7666j = handler;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            this.f7666j.post(new Runnable() { // from class: b.i.a.c.c
                @Override // java.lang.Runnable
                public final void run() {
                    C2909t0.a aVar = this.f6163j;
                    int i2 = i;
                    C2909t0 c2909t0 = C2909t0.this;
                    Objects.requireNonNull(c2909t0);
                    if (i2 == -3 || i2 == -2) {
                        if (i2 != -2) {
                            C2931o c2931o = c2909t0.f7661d;
                            if (!(c2931o != null && c2931o.f7780k == 1)) {
                                c2909t0.m3463d(3);
                                return;
                            }
                        }
                        c2909t0.m3461b(0);
                        c2909t0.m3463d(2);
                        return;
                    }
                    if (i2 == -1) {
                        c2909t0.m3461b(-1);
                        c2909t0.m3460a();
                    } else if (i2 != 1) {
                        C1643a.m852g0(38, "Unknown focus change type: ", i2, "AudioFocusManager");
                    } else {
                        c2909t0.m3463d(1);
                        c2909t0.m3461b(1);
                    }
                }
            });
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.t0$b */
    /* JADX INFO: compiled from: AudioFocusManager.java */
    public interface b {
    }

    public C2909t0(Context context, Handler handler, b bVar) {
        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        Objects.requireNonNull(audioManager);
        this.f7658a = audioManager;
        this.f7660c = bVar;
        this.f7659b = new a(handler);
        this.f7662e = 0;
    }

    /* JADX INFO: renamed from: a */
    public final void m3460a() {
        if (this.f7662e == 0) {
            return;
        }
        if (C2738e0.f6708a >= 26) {
            AudioFocusRequest audioFocusRequest = this.f7665h;
            if (audioFocusRequest != null) {
                this.f7658a.abandonAudioFocusRequest(audioFocusRequest);
            }
        } else {
            this.f7658a.abandonAudioFocus(this.f7659b);
        }
        m3463d(0);
    }

    /* JADX INFO: renamed from: b */
    public final void m3461b(int i) {
        b bVar = this.f7660c;
        if (bVar != null) {
            C2816k2.b bVar2 = (C2816k2.b) bVar;
            boolean zMo2908j = C2816k2.this.mo2908j();
            C2816k2.this.m3289m0(zMo2908j, i, C2816k2.m3282g0(zMo2908j, i));
        }
    }

    /* JADX INFO: renamed from: c */
    public void m3462c(@Nullable C2931o c2931o) {
        if (C2738e0.m2993a(this.f7661d, null)) {
            return;
        }
        this.f7661d = null;
        this.f7663f = 0;
        C1460d.m543m(true, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
    }

    /* JADX INFO: renamed from: d */
    public final void m3463d(int i) {
        if (this.f7662e == i) {
            return;
        }
        this.f7662e = i;
        float f = i == 3 ? 0.2f : 1.0f;
        if (this.f7664g == f) {
            return;
        }
        this.f7664g = f;
        b bVar = this.f7660c;
        if (bVar != null) {
            C2816k2 c2816k2 = C2816k2.this;
            c2816k2.m3286j0(1, 2, Float.valueOf(c2816k2.f7198B * c2816k2.f7215k.f7664g));
        }
    }

    /* JADX INFO: renamed from: e */
    public int m3464e(boolean z2, int i) {
        int iRequestAudioFocus;
        int i2 = 1;
        if (i == 1 || this.f7663f != 1) {
            m3460a();
            return z2 ? 1 : -1;
        }
        if (!z2) {
            return -1;
        }
        if (this.f7662e != 1) {
            if (C2738e0.f6708a >= 26) {
                AudioFocusRequest audioFocusRequest = this.f7665h;
                if (audioFocusRequest == null) {
                    AudioFocusRequest.Builder builder = audioFocusRequest == null ? new AudioFocusRequest.Builder(this.f7663f) : new AudioFocusRequest.Builder(this.f7665h);
                    C2931o c2931o = this.f7661d;
                    boolean z3 = c2931o != null && c2931o.f7780k == 1;
                    Objects.requireNonNull(c2931o);
                    this.f7665h = builder.setAudioAttributes(c2931o.m3494a()).setWillPauseWhenDucked(z3).setOnAudioFocusChangeListener(this.f7659b).build();
                }
                iRequestAudioFocus = this.f7658a.requestAudioFocus(this.f7665h);
            } else {
                AudioManager audioManager = this.f7658a;
                a aVar = this.f7659b;
                C2931o c2931o2 = this.f7661d;
                Objects.requireNonNull(c2931o2);
                iRequestAudioFocus = audioManager.requestAudioFocus(aVar, C2738e0.m3012t(c2931o2.f7782m), this.f7663f);
            }
            if (iRequestAudioFocus == 1) {
                m3463d(1);
            } else {
                m3463d(0);
                i2 = -1;
            }
        }
        return i2;
    }
}
