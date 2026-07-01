package b.o.a.n.u;

import android.hardware.Camera;
import android.hardware.Camera$CameraInfo;
import android.hardware.Camera$Parameters;
import android.hardware.Camera$Size;
import android.media.CamcorderProfile;
import androidx.annotation.NonNull;
import b.o.a.c;
import b.o.a.m.e;
import b.o.a.m.f;
import b.o.a.m.h;
import b.o.a.m.j;
import b.o.a.m.m;
import b.o.a.r.a$a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: Camera1Options.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends c {
    public a(@NonNull Camera$Parameters camera$Parameters, int i, boolean z2) {
        CamcorderProfile camcorderProfile;
        int i2;
        int i3;
        b.o.a.n.q.a aVarA = b.o.a.n.q.a.a();
        Camera$CameraInfo camera$CameraInfo = new Camera$CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i4 = 0; i4 < numberOfCameras; i4++) {
            Camera.getCameraInfo(i4, camera$CameraInfo);
            e eVar = (e) aVarA.b(b.o.a.n.q.a.d, Integer.valueOf(camera$CameraInfo.facing));
            if (eVar != null) {
                this.f1911b.add(eVar);
            }
        }
        List<String> supportedWhiteBalance = camera$Parameters.getSupportedWhiteBalance();
        if (supportedWhiteBalance != null) {
            Iterator<String> it = supportedWhiteBalance.iterator();
            while (it.hasNext()) {
                m mVar = (m) aVarA.b(b.o.a.n.q.a.c, it.next());
                if (mVar != null) {
                    this.a.add(mVar);
                }
            }
        }
        this.c.add(f.OFF);
        List<String> supportedFlashModes = camera$Parameters.getSupportedFlashModes();
        if (supportedFlashModes != null) {
            Iterator<String> it2 = supportedFlashModes.iterator();
            while (it2.hasNext()) {
                f fVar = (f) aVarA.b(b.o.a.n.q.a.f1936b, it2.next());
                if (fVar != null) {
                    this.c.add(fVar);
                }
            }
        }
        this.d.add(h.OFF);
        List<String> supportedSceneModes = camera$Parameters.getSupportedSceneModes();
        if (supportedSceneModes != null) {
            Iterator<String> it3 = supportedSceneModes.iterator();
            while (it3.hasNext()) {
                h hVar = (h) aVarA.b(b.o.a.n.q.a.e, it3.next());
                if (hVar != null) {
                    this.d.add(hVar);
                }
            }
        }
        this.k = camera$Parameters.isZoomSupported();
        this.o = camera$Parameters.getSupportedFocusModes().contains("auto");
        float exposureCompensationStep = camera$Parameters.getExposureCompensationStep();
        this.m = camera$Parameters.getMinExposureCompensation() * exposureCompensationStep;
        this.n = camera$Parameters.getMaxExposureCompensation() * exposureCompensationStep;
        this.l = (camera$Parameters.getMinExposureCompensation() == 0 && camera$Parameters.getMaxExposureCompensation() == 0) ? false : true;
        for (Camera$Size camera$Size : camera$Parameters.getSupportedPictureSizes()) {
            int i5 = z2 ? camera$Size.height : camera$Size.width;
            int i6 = z2 ? camera$Size.width : camera$Size.height;
            this.e.add(new b.o.a.x.b(i5, i6));
            this.g.add(b.o.a.x.a.f(i5, i6));
        }
        ArrayList arrayList = new ArrayList(b.o.a.r.a.f1948b.keySet());
        Collections.sort(arrayList, new a$a(((long) Integer.MAX_VALUE) * ((long) Integer.MAX_VALUE)));
        while (true) {
            if (arrayList.size() <= 0) {
                camcorderProfile = CamcorderProfile.get(i, 0);
                break;
            }
            int iIntValue = b.o.a.r.a.f1948b.get((b.o.a.x.b) arrayList.remove(0)).intValue();
            if (CamcorderProfile.hasProfile(i, iIntValue)) {
                camcorderProfile = CamcorderProfile.get(i, iIntValue);
                break;
            }
        }
        int i7 = camcorderProfile.videoFrameWidth;
        int i8 = camcorderProfile.videoFrameHeight;
        List<Camera$Size> supportedVideoSizes = camera$Parameters.getSupportedVideoSizes();
        if (supportedVideoSizes != null) {
            for (Camera$Size camera$Size2 : supportedVideoSizes) {
                int i9 = camera$Size2.width;
                if (i9 <= i7 && (i3 = camera$Size2.height) <= i8) {
                    int i10 = z2 ? i3 : i9;
                    i9 = z2 ? i9 : i3;
                    this.f.add(new b.o.a.x.b(i10, i9));
                    this.h.add(b.o.a.x.a.f(i10, i9));
                }
            }
        } else {
            for (Camera$Size camera$Size3 : camera$Parameters.getSupportedPreviewSizes()) {
                int i11 = camera$Size3.width;
                if (i11 <= i7 && (i2 = camera$Size3.height) <= i8) {
                    int i12 = z2 ? i2 : i11;
                    i11 = z2 ? i11 : i2;
                    this.f.add(new b.o.a.x.b(i12, i11));
                    this.h.add(b.o.a.x.a.f(i12, i11));
                }
            }
        }
        this.p = Float.MAX_VALUE;
        this.q = -3.4028235E38f;
        for (int[] iArr : camera$Parameters.getSupportedPreviewFpsRange()) {
            float f = iArr[0] / 1000.0f;
            float f2 = iArr[1] / 1000.0f;
            this.p = Math.min(this.p, f);
            this.q = Math.max(this.q, f2);
        }
        this.i.add(j.JPEG);
        this.j.add(17);
    }
}
