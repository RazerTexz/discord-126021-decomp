package b.i.a.c;

import android.media.AudioManager$OnAudioFocusChangeListener;
import android.os.Handler;

/* JADX INFO: compiled from: AudioFocusManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class t0$a implements AudioManager$OnAudioFocusChangeListener {
    public final Handler j;
    public final /* synthetic */ t0 k;

    public t0$a(t0 t0Var, Handler handler) {
        this.k = t0Var;
        this.j = handler;
    }

    @Override // android.media.AudioManager$OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
        this.j.post(new c(this, i));
    }
}
