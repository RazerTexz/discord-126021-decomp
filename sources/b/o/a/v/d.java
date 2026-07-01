package b.o.a.v;

import android.media.MediaActionSound;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import b.o.a.l$a;
import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.CameraView$b;

/* JADX INFO: compiled from: PictureRecorder.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d {

    @VisibleForTesting(otherwise = 4)
    public l$a j;

    @VisibleForTesting
    public d$a k;
    public Exception l;

    public d(@NonNull l$a l_a, @Nullable d$a d_a) {
        this.j = l_a;
        this.k = d_a;
    }

    public void a(boolean z2) {
        CameraView cameraView;
        boolean z3;
        d$a d_a = this.k;
        if (d_a != null) {
            boolean z4 = !z2;
            CameraView$b cameraView$b = (CameraView$b) ((b.o.a.n.g) d_a).m;
            if (z4 && (z3 = (cameraView = cameraView$b.c).l) && z3) {
                if (cameraView.B == null) {
                    cameraView.B = new MediaActionSound();
                }
                cameraView.B.play(0);
            }
            cameraView$b.c.u.post(new b.o.a.h(cameraView$b));
        }
    }

    public void b() {
        d$a d_a = this.k;
        if (d_a != null) {
            d_a.a(this.j, this.l);
            this.k = null;
            this.j = null;
        }
    }

    public abstract void c();
}
