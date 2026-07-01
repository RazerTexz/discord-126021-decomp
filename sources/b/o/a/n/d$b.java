package b.o.a.n;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest$Builder;
import android.location.Location;

/* JADX INFO: compiled from: Camera2Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$b implements Runnable {
    public final /* synthetic */ Location j;
    public final /* synthetic */ d k;

    public d$b(d dVar, Location location) {
        this.k = dVar;
        this.j = location;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar = this.k;
        CaptureRequest$Builder captureRequest$Builder = dVar.f1921i0;
        Location location = dVar.C;
        if (location != null) {
            captureRequest$Builder.set(CaptureRequest.JPEG_GPS_LOCATION, location);
        }
        this.k.k1();
    }
}
