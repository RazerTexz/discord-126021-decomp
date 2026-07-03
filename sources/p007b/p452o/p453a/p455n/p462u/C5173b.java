package p007b.p452o.p453a.p455n.p462u;

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
import java.util.HashSet;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p452o.p453a.AbstractC5104c;
import p007b.p452o.p453a.p454m.EnumC5118e;
import p007b.p452o.p453a.p454m.EnumC5119f;
import p007b.p452o.p453a.p454m.EnumC5121h;
import p007b.p452o.p453a.p454m.EnumC5123j;
import p007b.p452o.p453a.p454m.EnumC5126m;
import p007b.p452o.p453a.p455n.p458q.C5157b;
import p007b.p452o.p453a.p467r.C5200a;
import p007b.p452o.p453a.p473x.C5235a;
import p007b.p452o.p453a.p473x.C5236b;

/* JADX INFO: renamed from: b.o.a.n.u.b */
/* JADX INFO: compiled from: Camera2Options.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class C5173b extends AbstractC5104c {
    /* JADX WARN: Code duplicated, block: B:35:0x00ad  */
    public C5173b(@NonNull CameraManager cameraManager, @NonNull String str, boolean z2, int i) throws CameraAccessException {
        EnumC5119f enumC5119f = EnumC5119f.OFF;
        if (C5157b.f13961a == null) {
            C5157b.f13961a = new C5157b();
        }
        C5157b c5157b = C5157b.f13961a;
        CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
        for (String str2 : cameraManager.getCameraIdList()) {
            Integer num = (Integer) cameraManager.getCameraCharacteristics(str2).get(CameraCharacteristics.LENS_FACING);
            if (num != null) {
                EnumC5118e enumC5118e = (EnumC5118e) c5157b.m7348a(C5157b.f13962b, Integer.valueOf(num.intValue()));
                if (enumC5118e != null) {
                    this.f13683b.add(enumC5118e);
                }
            }
        }
        for (int i2 : (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES)) {
            EnumC5126m enumC5126m = (EnumC5126m) c5157b.m7348a(C5157b.f13963c, Integer.valueOf(i2));
            if (enumC5126m != null) {
                this.f13682a.add(enumC5126m);
            }
        }
        this.f13684c.add(enumC5119f);
        Boolean bool = (Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        boolean z3 = true;
        if (bool != null && bool.booleanValue()) {
            for (int i3 : (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES)) {
                Objects.requireNonNull(c5157b);
                HashSet hashSet = new HashSet();
                if (i3 == 0 || i3 == 1) {
                    hashSet.add(enumC5119f);
                    hashSet.add(EnumC5119f.TORCH);
                } else if (i3 == 2) {
                    hashSet.add(EnumC5119f.AUTO);
                } else if (i3 == 3) {
                    hashSet.add(EnumC5119f.ON);
                } else if (i3 == 4) {
                    hashSet.add(EnumC5119f.AUTO);
                }
                this.f13684c.addAll(hashSet);
            }
        }
        this.f13685d.add(EnumC5121h.OFF);
        for (int i4 : (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AVAILABLE_SCENE_MODES)) {
            EnumC5121h enumC5121h = (EnumC5121h) c5157b.m7348a(C5157b.f13964d, Integer.valueOf(i4));
            if (enumC5121h != null) {
                this.f13685d.add(enumC5121h);
            }
        }
        Float f = (Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        if (f != null) {
            this.f13692k = f.floatValue() > 1.0f;
        }
        Integer num2 = (Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
        Integer num3 = (Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE);
        Integer num4 = (Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB);
        this.f13696o = (num2 != null && num2.intValue() > 0) || (num3 != null && num3.intValue() > 0) || (num4 != null && num4.intValue() > 0);
        Range range = (Range) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
        Rational rational = (Rational) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP);
        if (range != null && rational != null && rational.floatValue() != 0.0f) {
            this.f13694m = ((Integer) range.getLower()).intValue() / rational.floatValue();
            this.f13695n = ((Integer) range.getUpper()).intValue() / rational.floatValue();
        }
        this.f13693l = (this.f13694m == 0.0f || this.f13695n == 0.0f) ? false : true;
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
            throw new IllegalStateException(C1643a.m871q("Picture format not supported: ", i));
        }
        for (Size size : streamConfigurationMap.getOutputSizes(i)) {
            int height = z2 ? size.getHeight() : size.getWidth();
            int width = z2 ? size.getWidth() : size.getHeight();
            this.f13686e.add(new C5236b(height, width));
            this.f13688g.add(C5235a.m7447f(height, width));
        }
        CamcorderProfile camcorderProfileM7398b = C5200a.m7398b(str, new C5236b(Integer.MAX_VALUE, Integer.MAX_VALUE));
        int i6 = camcorderProfileM7398b.videoFrameWidth;
        int i7 = camcorderProfileM7398b.videoFrameHeight;
        for (Size size2 : streamConfigurationMap.getOutputSizes(MediaRecorder.class)) {
            if (size2.getWidth() <= i6 && size2.getHeight() <= i7) {
                int height2 = z2 ? size2.getHeight() : size2.getWidth();
                int width2 = z2 ? size2.getWidth() : size2.getHeight();
                this.f13687f.add(new C5236b(height2, width2));
                this.f13689h.add(C5235a.m7447f(height2, width2));
            }
        }
        Range[] rangeArr = (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        if (rangeArr != null) {
            this.f13697p = Float.MAX_VALUE;
            this.f13698q = -3.4028235E38f;
            for (Range range2 : rangeArr) {
                this.f13697p = Math.min(this.f13697p, ((Integer) range2.getLower()).intValue());
                this.f13698q = Math.max(this.f13698q, ((Integer) range2.getUpper()).intValue());
            }
        } else {
            this.f13697p = 0.0f;
            this.f13698q = 0.0f;
        }
        this.f13690i.add(EnumC5123j.JPEG);
        int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        if (iArr != null) {
            for (int i8 : iArr) {
                if (i8 == 3) {
                    this.f13690i.add(EnumC5123j.DNG);
                }
            }
        }
        this.f13691j.add(35);
        for (int i9 : streamConfigurationMap.getOutputFormats()) {
            if (ImageFormat.getBitsPerPixel(i9) > 0) {
                this.f13691j.add(Integer.valueOf(i9));
            }
        }
    }
}
