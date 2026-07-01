package org.webrtc;

import com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes3.dex */
public class CameraEnumerationAndroid {
    public static final ArrayList<Size> COMMON_RESOLUTIONS = new ArrayList<>(Arrays.asList(new Size(Opcodes.IF_ICMPNE, 120), new Size(240, Opcodes.IF_ICMPNE), new Size(320, 240), new Size(400, 240), new Size(480, 320), new Size(640, 360), new Size(640, 480), new Size(768, 480), new Size(854, 480), new Size(800, 600), new Size(960, 540), new Size(960, 640), new Size(1024, 576), new Size(1024, 600), new Size(1280, 720), new Size(1280, 1024), new Size(1920, WidgetEditUserOrGuildMemberProfile.MAX_BANNER_IMAGE_SIZE), new Size(1920, 1440), new Size(2560, 1440), new Size(3840, 2160)));
    private static final String TAG = "CameraEnumerationAndroid";

    public static CameraEnumerationAndroid$CaptureFormat$FramerateRange getClosestSupportedFramerateRange(List<CameraEnumerationAndroid$CaptureFormat$FramerateRange> list, int i) {
        return (CameraEnumerationAndroid$CaptureFormat$FramerateRange) Collections.min(list, new CameraEnumerationAndroid$1(i));
    }

    public static Size getClosestSupportedSize(List<Size> list, int i, int i2) {
        return (Size) Collections.min(list, new CameraEnumerationAndroid$2(i, i2));
    }

    public static void reportCameraResolution(Histogram histogram, Size size) {
        histogram.addSample(COMMON_RESOLUTIONS.indexOf(size) + 1);
    }
}
