package p007b.p452o.p453a.p455n.p462u;

import android.hardware.Camera;
import android.media.CamcorderProfile;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p007b.p452o.p453a.AbstractC5104c;
import p007b.p452o.p453a.p454m.EnumC5118e;
import p007b.p452o.p453a.p454m.EnumC5119f;
import p007b.p452o.p453a.p454m.EnumC5121h;
import p007b.p452o.p453a.p454m.EnumC5123j;
import p007b.p452o.p453a.p454m.EnumC5126m;
import p007b.p452o.p453a.p455n.p458q.C5156a;
import p007b.p452o.p453a.p467r.C5200a;
import p007b.p452o.p453a.p473x.C5235a;
import p007b.p452o.p453a.p473x.C5236b;

/* JADX INFO: renamed from: b.o.a.n.u.a */
/* JADX INFO: compiled from: Camera1Options.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5172a extends AbstractC5104c {
    public C5172a(@NonNull Camera.Parameters parameters, int i, boolean z2) {
        CamcorderProfile camcorderProfile;
        int i2;
        int i3;
        C5156a c5156aM7346a = C5156a.m7346a();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i4 = 0; i4 < numberOfCameras; i4++) {
            Camera.getCameraInfo(i4, cameraInfo);
            EnumC5118e enumC5118e = (EnumC5118e) c5156aM7346a.m7347b(C5156a.f13959d, Integer.valueOf(cameraInfo.facing));
            if (enumC5118e != null) {
                this.f13683b.add(enumC5118e);
            }
        }
        List<String> supportedWhiteBalance = parameters.getSupportedWhiteBalance();
        if (supportedWhiteBalance != null) {
            Iterator<String> it = supportedWhiteBalance.iterator();
            while (it.hasNext()) {
                EnumC5126m enumC5126m = (EnumC5126m) c5156aM7346a.m7347b(C5156a.f13958c, it.next());
                if (enumC5126m != null) {
                    this.f13682a.add(enumC5126m);
                }
            }
        }
        this.f13684c.add(EnumC5119f.OFF);
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (supportedFlashModes != null) {
            Iterator<String> it2 = supportedFlashModes.iterator();
            while (it2.hasNext()) {
                EnumC5119f enumC5119f = (EnumC5119f) c5156aM7346a.m7347b(C5156a.f13957b, it2.next());
                if (enumC5119f != null) {
                    this.f13684c.add(enumC5119f);
                }
            }
        }
        this.f13685d.add(EnumC5121h.OFF);
        List<String> supportedSceneModes = parameters.getSupportedSceneModes();
        if (supportedSceneModes != null) {
            Iterator<String> it3 = supportedSceneModes.iterator();
            while (it3.hasNext()) {
                EnumC5121h enumC5121h = (EnumC5121h) c5156aM7346a.m7347b(C5156a.f13960e, it3.next());
                if (enumC5121h != null) {
                    this.f13685d.add(enumC5121h);
                }
            }
        }
        this.f13692k = parameters.isZoomSupported();
        this.f13696o = parameters.getSupportedFocusModes().contains("auto");
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        this.f13694m = parameters.getMinExposureCompensation() * exposureCompensationStep;
        this.f13695n = parameters.getMaxExposureCompensation() * exposureCompensationStep;
        this.f13693l = (parameters.getMinExposureCompensation() == 0 && parameters.getMaxExposureCompensation() == 0) ? false : true;
        for (Camera.Size size : parameters.getSupportedPictureSizes()) {
            int i5 = z2 ? size.height : size.width;
            int i6 = z2 ? size.width : size.height;
            this.f13686e.add(new C5236b(i5, i6));
            this.f13688g.add(C5235a.m7447f(i5, i6));
        }
        ArrayList arrayList = new ArrayList(C5200a.f14101b.keySet());
        Collections.sort(arrayList, new C5200a.a(((long) Integer.MAX_VALUE) * ((long) Integer.MAX_VALUE)));
        while (true) {
            if (arrayList.size() <= 0) {
                camcorderProfile = CamcorderProfile.get(i, 0);
                break;
            }
            int iIntValue = C5200a.f14101b.get((C5236b) arrayList.remove(0)).intValue();
            if (CamcorderProfile.hasProfile(i, iIntValue)) {
                camcorderProfile = CamcorderProfile.get(i, iIntValue);
                break;
            }
        }
        int i7 = camcorderProfile.videoFrameWidth;
        int i8 = camcorderProfile.videoFrameHeight;
        List<Camera.Size> supportedVideoSizes = parameters.getSupportedVideoSizes();
        if (supportedVideoSizes != null) {
            for (Camera.Size size2 : supportedVideoSizes) {
                int i9 = size2.width;
                if (i9 <= i7 && (i3 = size2.height) <= i8) {
                    int i10 = z2 ? i3 : i9;
                    i9 = z2 ? i9 : i3;
                    this.f13687f.add(new C5236b(i10, i9));
                    this.f13689h.add(C5235a.m7447f(i10, i9));
                }
            }
        } else {
            for (Camera.Size size3 : parameters.getSupportedPreviewSizes()) {
                int i11 = size3.width;
                if (i11 <= i7 && (i2 = size3.height) <= i8) {
                    int i12 = z2 ? i2 : i11;
                    i11 = z2 ? i11 : i2;
                    this.f13687f.add(new C5236b(i12, i11));
                    this.f13689h.add(C5235a.m7447f(i12, i11));
                }
            }
        }
        this.f13697p = Float.MAX_VALUE;
        this.f13698q = -3.4028235E38f;
        for (int[] iArr : parameters.getSupportedPreviewFpsRange()) {
            float f = iArr[0] / 1000.0f;
            float f2 = iArr[1] / 1000.0f;
            this.f13697p = Math.min(this.f13697p, f);
            this.f13698q = Math.max(this.f13698q, f2);
        }
        this.f13690i.add(EnumC5123j.JPEG);
        this.f13691j.add(17);
    }
}
