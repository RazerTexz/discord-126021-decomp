package b.o.a.v;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.DngCreator;
import android.hardware.camera2.TotalCaptureResult;
import android.location.Location;
import androidx.annotation.NonNull;
import b.o.a.l$a;
import b.o.a.m.j;

/* JADX INFO: compiled from: Full2PictureRecorder.java */
/* JADX INFO: loaded from: classes3.dex */
public class b$a extends b.o.a.n.o.e {
    public final /* synthetic */ b e;

    public b$a(b bVar) {
        this.e = bVar;
    }

    @Override // b.o.a.n.o.e, b.o.a.n.o.a
    public void b(@NonNull b.o.a.n.o.c cVar, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        int i;
        b bVar = this.e;
        if (bVar.j.g == j.DNG) {
            bVar.r = new DngCreator(((b.o.a.n.d) cVar).f1919g0, totalCaptureResult);
            b bVar2 = this.e;
            DngCreator dngCreator = bVar2.r;
            int i2 = bVar2.j.c;
            int i3 = (i2 + 360) % 360;
            if (i3 == 0) {
                i = 1;
            } else if (i3 == 90) {
                i = 6;
            } else if (i3 == 180) {
                i = 3;
            } else {
                if (i3 != 270) {
                    throw new IllegalArgumentException(b.d.b.a.a.q("Invalid orientation: ", i2));
                }
                i = 8;
            }
            dngCreator.setOrientation(i);
            b bVar3 = this.e;
            Location location = bVar3.j.f1912b;
            if (location != null) {
                bVar3.r.setLocation(location);
            }
        }
    }

    @Override // b.o.a.n.o.e, b.o.a.n.o.a
    public void c(@NonNull b.o.a.n.o.c cVar, @NonNull CaptureRequest captureRequest) {
        if (this.d) {
            j(cVar);
            this.d = false;
        }
        if (captureRequest.getTag() == 2) {
            c.m.a(1, "onCaptureStarted:", "Dispatching picture shutter.");
            this.e.a(false);
            l(Integer.MAX_VALUE);
        }
    }

    @Override // b.o.a.n.o.e
    public void j(@NonNull b.o.a.n.o.c cVar) {
        this.c = cVar;
        b bVar = this.e;
        bVar.q.addTarget(bVar.p.getSurface());
        b bVar2 = this.e;
        l$a l_a = bVar2.j;
        if (l_a.g == j.JPEG) {
            bVar2.q.set(CaptureRequest.JPEG_ORIENTATION, Integer.valueOf(l_a.c));
        }
        this.e.q.setTag(2);
        try {
            ((b.o.a.n.d) cVar).e1(this, this.e.q);
        } catch (CameraAccessException e) {
            b bVar3 = this.e;
            bVar3.j = null;
            bVar3.l = e;
            bVar3.b();
            l(Integer.MAX_VALUE);
        }
    }
}
