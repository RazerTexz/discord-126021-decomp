package b.o.a.n.u;

import android.graphics.ImageFormat;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import b.d.b.a.outline;
import b.o.a.CameraOptions;
import b.o.a.m.Facing;
import b.o.a.m.Flash;
import b.o.a.m.Hdr;
import b.o.a.m.PictureFormat;
import b.o.a.m.WhiteBalance;
import b.o.a.n.q.Camera2Mapper;
import b.o.a.r.CamcorderProfiles;
import b.o.a.x.AspectRatio2;
import b.o.a.x.Size3;
import java.util.HashSet;
import java.util.Objects;

/* JADX INFO: renamed from: b.o.a.n.u.b, reason: use source file name */
/* JADX INFO: compiled from: Camera2Options.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class Camera2Options extends CameraOptions {
    /* JADX WARN: Code duplicated, block: B:35:0x00ad  */
    public Camera2Options(@NonNull CameraManager cameraManager, @NonNull String str, boolean z2, int i) throws CameraAccessException {
        Flash flash = Flash.OFF;
        if (Camera2Mapper.a == null) {
            Camera2Mapper.a = new Camera2Mapper();
        }
        Camera2Mapper camera2Mapper = Camera2Mapper.a;
        CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
        for (String str2 : cameraManager.getCameraIdList()) {
            Integer num = (Integer) cameraManager.getCameraCharacteristics(str2).get(CameraCharacteristics.LENS_FACING);
            if (num != null) {
                Facing facing = (Facing) camera2Mapper.a(Camera2Mapper.f1937b, Integer.valueOf(num.intValue()));
                if (facing != null) {
                    this.f1911b.add(facing);
                }
            }
        }
        for (int i2 : (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES)) {
            WhiteBalance whiteBalance = (WhiteBalance) camera2Mapper.a(Camera2Mapper.c, Integer.valueOf(i2));
            if (whiteBalance != null) {
                this.a.add(whiteBalance);
            }
        }
        this.c.add(flash);
        Boolean bool = (Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        boolean z3 = true;
        if (bool != null && bool.booleanValue()) {
            for (int i3 : (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES)) {
                Objects.requireNonNull(camera2Mapper);
                HashSet hashSet = new HashSet();
                if (i3 == 0 || i3 == 1) {
                    hashSet.add(flash);
                    hashSet.add(Flash.TORCH);
                } else if (i3 == 2) {
                    hashSet.add(Flash.AUTO);
                } else if (i3 == 3) {
                    hashSet.add(Flash.ON);
                } else if (i3 == 4) {
                    hashSet.add(Flash.AUTO);
                }
                this.c.addAll(hashSet);
            }
        }
        this.d.add(Hdr.OFF);
        for (int i4 : (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AVAILABLE_SCENE_MODES)) {
            Hdr hdr = (Hdr) camera2Mapper.a(Camera2Mapper.d, Integer.valueOf(i4));
            if (hdr != null) {
                this.d.add(hdr);
            }
        }
        Float f = (Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        if (f != null) {
            this.k = f.floatValue() > 1.0f;
        }
        Integer num2 = (Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
        Integer num3 = (Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE);
        Integer num4 = (Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB);
        this.o = (num2 != null && num2.intValue() > 0) || (num3 != null && num3.intValue() > 0) || (num4 != null && num4.intValue() > 0);
        Range range = (Range) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
        Rational rational = (Rational) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP);
        if (range != null && rational != null && rational.floatValue() != 0.0f) {
            this.m = ((Integer) range.getLower()).intValue() / rational.floatValue();
            this.n = ((Integer) range.getUpper()).intValue() / rational.floatValue();
        }
        this.l = (this.m == 0.0f || this.n == 0.0f) ? false : true;
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null) {
            throw new RuntimeException("StreamConfigurationMap is null. Should not happen.");
        }
        int[] outputFormats = streamConfigurationMap.getOutputFormats();
        int length = outputFormats.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                z3 = false;
                break;
            } else if (outputFormats[i5] == i) {
                break;
            } else {
                i5++;
            }
        }
        if (!z3) {
            throw new IllegalStateException(outline.q("Picture format not supported: ", i));
        }
        for (Size size : streamConfigurationMap.getOutputSizes(i)) {
            int height = z2 ? size.getHeight() : size.getWidth();
            int width = z2 ? size.getWidth() : size.getHeight();
            this.e.add(new Size3(height, width));
            this.g.add(AspectRatio2.f(height, width));
        }
        CamcorderProfile camcorderProfileB = CamcorderProfiles.b(str, new Size3(Integer.MAX_VALUE, Integer.MAX_VALUE));
        int i6 = camcorderProfileB.videoFrameWidth;
        int i7 = camcorderProfileB.videoFrameHeight;
        for (Size size2 : streamConfigurationMap.getOutputSizes(MediaRecorder.class)) {
            if (size2.getWidth() <= i6 && size2.getHeight() <= i7) {
                int height2 = z2 ? size2.getHeight() : size2.getWidth();
                int width2 = z2 ? size2.getWidth() : size2.getHeight();
                this.f.add(new Size3(height2, width2));
                this.h.add(AspectRatio2.f(height2, width2));
            }
        }
        Range[] rangeArr = (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        if (rangeArr != null) {
            this.p = Float.MAX_VALUE;
            this.q = -3.4028235E38f;
            for (Range range2 : rangeArr) {
                this.p = Math.min(this.p, ((Integer) range2.getLower()).intValue());
                this.q = Math.max(this.q, ((Integer) range2.getUpper()).intValue());
            }
        } else {
            this.p = 0.0f;
            this.q = 0.0f;
        }
        this.i.add(PictureFormat.JPEG);
        int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        if (iArr != null) {
            for (int i8 : iArr) {
                if (i8 == 3) {
                    this.i.add(PictureFormat.DNG);
                }
            }
        }
        this.j.add(35);
        for (int i9 : streamConfigurationMap.getOutputFormats()) {
            if (ImageFormat.getBitsPerPixel(i9) > 0) {
                this.j.add(Integer.valueOf(i9));
            }
        }
    }
}
