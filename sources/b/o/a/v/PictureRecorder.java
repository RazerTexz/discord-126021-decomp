package b.o.a.v;

import android.media.MediaActionSound;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import b.o.a.CameraView4;
import b.o.a.PictureResult;
import b.o.a.n.CameraBaseEngine;
import com.otaliastudios.cameraview.CameraView;

/* JADX INFO: renamed from: b.o.a.v.d, reason: use source file name */
/* JADX INFO: compiled from: PictureRecorder.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class PictureRecorder {

    @VisibleForTesting(otherwise = 4)
    public PictureResult.a j;

    @VisibleForTesting
    public a k;
    public Exception l;

    /* JADX INFO: renamed from: b.o.a.v.d$a */
    /* JADX INFO: compiled from: PictureRecorder.java */
    public interface a {
        void a(@Nullable PictureResult.a aVar, @Nullable Exception exc);
    }

    public PictureRecorder(@NonNull PictureResult.a aVar, @Nullable a aVar2) {
        this.j = aVar;
        this.k = aVar2;
    }

    public void a(boolean z2) {
        CameraView cameraView;
        boolean z3;
        a aVar = this.k;
        if (aVar != null) {
            boolean z4 = !z2;
            CameraView.b bVar = (CameraView.b) ((CameraBaseEngine) aVar).m;
            if (z4 && (z3 = (cameraView = CameraView.this).l) && z3) {
                if (cameraView.B == null) {
                    cameraView.B = new MediaActionSound();
                }
                cameraView.B.play(0);
            }
            CameraView.this.u.post(new CameraView4(bVar));
        }
    }

    public void b() {
        a aVar = this.k;
        if (aVar != null) {
            aVar.a(this.j, this.l);
            this.k = null;
            this.j = null;
        }
    }

    public abstract void c();
}
