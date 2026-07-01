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
import b.o.a.c;
import b.o.a.m.e;
import b.o.a.m.f;
import b.o.a.m.h;
import b.o.a.m.j;
import b.o.a.m.m;
import java.util.HashSet;
import java.util.Objects;

/* JADX INFO: compiled from: Camera2Options.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class b extends c {
    /* JADX WARN: Code duplicated, block: B:35:0x00ad  */
    public b(@NonNull CameraManager cameraManager, @NonNull String str, boolean z2, int i) throws CameraAccessException {
        f fVar = f.OFF;
        if (b.o.a.n.q.b.a == null) {
            b.o.a.n.q.b.a = new b.o.a.n.q.b();
        }
        b.o.a.n.q.b bVar = b.o.a.n.q.b.a;
        CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
        for (String str2 : cameraManager.getCameraIdList()) {
            Integer num = (Integer) cameraManager.getCameraCharacteristics(str2).get(CameraCharacteristics.LENS_FACING);
            if (num != null) {
                e eVar = (e) bVar.a(b.o.a.n.q.b.f1937b, Integer.valueOf(num.intValue()));
                if (eVar != null) {
                    this.f1911b.add(eVar);
                }
            }
        }
        for (int i2 : (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES)) {
            m mVar = (m) bVar.a(b.o.a.n.q.b.c, Integer.valueOf(i2));
            if (mVar != null) {
                this.a.add(mVar);
            }
        }
        this.c.add(fVar);
        Boolean bool = (Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        boolean z3 = true;
        if (bool != null && bool.booleanValue()) {
            for (int i3 : (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES)) {
                Objects.requireNonNull(bVar);
                HashSet hashSet = new HashSet();
                if (i3 == 0 || i3 == 1) {
                    hashSet.add(fVar);
                    hashSet.add(f.TORCH);
                } else if (i3 == 2) {
                    hashSet.add(f.AUTO);
                } else if (i3 == 3) {
                    hashSet.add(f.ON);
                } else if (i3 == 4) {
                    hashSet.add(f.AUTO);
                }
                this.c.addAll(hashSet);
            }
        }
        this.d.add(h.OFF);
        for (int i4 : (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AVAILABLE_SCENE_MODES)) {
            h hVar = (h) bVar.a(b.o.a.n.q.b.d, Integer.valueOf(i4));
            if (hVar != null) {
                this.d.add(hVar);
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
            throw new IllegalStateException(b.d.b.a.a.q("Picture format not supported: ", i));
        }
        for (Size size : streamConfigurationMap.getOutputSizes(i)) {
            int height = z2 ? size.getHeight() : size.getWidth();
            int width = z2 ? size.getWidth() : size.getHeight();
            this.e.add(new b.o.a.x.b(height, width));
            this.g.add(b.o.a.x.a.f(height, width));
        }
        CamcorderProfile camcorderProfileB = b.o.a.r.a.b(str, new b.o.a.x.b(Integer.MAX_VALUE, Integer.MAX_VALUE));
        int i6 = camcorderProfileB.videoFrameWidth;
        int i7 = camcorderProfileB.videoFrameHeight;
        for (Size size2 : streamConfigurationMap.getOutputSizes(MediaRecorder.class)) {
            if (size2.getWidth() <= i6 && size2.getHeight() <= i7) {
                int height2 = z2 ? size2.getHeight() : size2.getWidth();
                int width2 = z2 ? size2.getWidth() : size2.getHeight();
                this.f.add(new b.o.a.x.b(height2, width2));
                this.h.add(b.o.a.x.a.f(height2, width2));
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
        this.i.add(j.JPEG);
        int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        if (iArr != null) {
            for (int i8 : iArr) {
                if (i8 == 3) {
                    this.i.add(j.DNG);
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
