package b.o.a.n.u;

import android.hardware.Camera;
import android.media.CamcorderProfile;
import androidx.annotation.NonNull;
import b.o.a.CameraOptions;
import b.o.a.m.Facing;
import b.o.a.m.Flash;
import b.o.a.m.Hdr;
import b.o.a.m.PictureFormat;
import b.o.a.m.WhiteBalance;
import b.o.a.n.q.Camera1Mapper;
import b.o.a.r.CamcorderProfiles;
import b.o.a.x.AspectRatio2;
import b.o.a.x.Size3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: b.o.a.n.u.a, reason: use source file name */
/* JADX INFO: compiled from: Camera1Options.java */
/* JADX INFO: loaded from: classes3.dex */
public class Camera1Options extends CameraOptions {
    public Camera1Options(@NonNull Camera.Parameters parameters, int i, boolean z2) {
        CamcorderProfile camcorderProfile;
        int i2;
        int i3;
        Camera1Mapper camera1MapperA = Camera1Mapper.a();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i4 = 0; i4 < numberOfCameras; i4++) {
            Camera.getCameraInfo(i4, cameraInfo);
            Facing facing = (Facing) camera1MapperA.b(Camera1Mapper.d, Integer.valueOf(cameraInfo.facing));
            if (facing != null) {
                this.f1911b.add(facing);
            }
        }
        List<String> supportedWhiteBalance = parameters.getSupportedWhiteBalance();
        if (supportedWhiteBalance != null) {
            Iterator<String> it = supportedWhiteBalance.iterator();
            while (it.hasNext()) {
                WhiteBalance whiteBalance = (WhiteBalance) camera1MapperA.b(Camera1Mapper.c, it.next());
                if (whiteBalance != null) {
                    this.a.add(whiteBalance);
                }
            }
        }
        this.c.add(Flash.OFF);
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (supportedFlashModes != null) {
            Iterator<String> it2 = supportedFlashModes.iterator();
            while (it2.hasNext()) {
                Flash flash = (Flash) camera1MapperA.b(Camera1Mapper.f1936b, it2.next());
                if (flash != null) {
                    this.c.add(flash);
                }
            }
        }
        this.d.add(Hdr.OFF);
        List<String> supportedSceneModes = parameters.getSupportedSceneModes();
        if (supportedSceneModes != null) {
            Iterator<String> it3 = supportedSceneModes.iterator();
            while (it3.hasNext()) {
                Hdr hdr = (Hdr) camera1MapperA.b(Camera1Mapper.e, it3.next());
                if (hdr != null) {
                    this.d.add(hdr);
                }
            }
        }
        this.k = parameters.isZoomSupported();
        this.o = parameters.getSupportedFocusModes().contains("auto");
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        this.m = parameters.getMinExposureCompensation() * exposureCompensationStep;
        this.n = parameters.getMaxExposureCompensation() * exposureCompensationStep;
        this.l = (parameters.getMinExposureCompensation() == 0 && parameters.getMaxExposureCompensation() == 0) ? false : true;
        for (Camera.Size size : parameters.getSupportedPictureSizes()) {
            int i5 = z2 ? size.height : size.width;
            int i6 = z2 ? size.width : size.height;
            this.e.add(new Size3(i5, i6));
            this.g.add(AspectRatio2.f(i5, i6));
        }
        ArrayList arrayList = new ArrayList(CamcorderProfiles.f1948b.keySet());
        Collections.sort(arrayList, new CamcorderProfiles.a(((long) Integer.MAX_VALUE) * ((long) Integer.MAX_VALUE)));
        while (true) {
            if (arrayList.size() <= 0) {
                camcorderProfile = CamcorderProfile.get(i, 0);
                break;
            }
            int iIntValue = CamcorderProfiles.f1948b.get((Size3) arrayList.remove(0)).intValue();
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
                    this.f.add(new Size3(i10, i9));
                    this.h.add(AspectRatio2.f(i10, i9));
                }
            }
        } else {
            for (Camera.Size size3 : parameters.getSupportedPreviewSizes()) {
                int i11 = size3.width;
                if (i11 <= i7 && (i2 = size3.height) <= i8) {
                    int i12 = z2 ? i2 : i11;
                    i11 = z2 ? i11 : i2;
                    this.f.add(new Size3(i12, i11));
                    this.h.add(AspectRatio2.f(i12, i11));
                }
            }
        }
        this.p = Float.MAX_VALUE;
        this.q = -3.4028235E38f;
        for (int[] iArr : parameters.getSupportedPreviewFpsRange()) {
            float f = iArr[0] / 1000.0f;
            float f2 = iArr[1] / 1000.0f;
            this.p = Math.min(this.p, f);
            this.q = Math.max(this.q, f2);
        }
        this.i.add(PictureFormat.JPEG);
        this.j.add(17);
    }
}
