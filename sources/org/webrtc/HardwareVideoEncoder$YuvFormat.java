package org.webrtc;

import b.d.b.a.a;
import java.nio.ByteBuffer;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes3.dex */
public abstract class HardwareVideoEncoder$YuvFormat {
    private static final /* synthetic */ HardwareVideoEncoder$YuvFormat[] $VALUES;
    public static final HardwareVideoEncoder$YuvFormat I420;
    public static final HardwareVideoEncoder$YuvFormat NV12;

    static {
        HardwareVideoEncoder$YuvFormat$1 hardwareVideoEncoder$YuvFormat$1 = new HardwareVideoEncoder$YuvFormat$1("I420", 0);
        I420 = hardwareVideoEncoder$YuvFormat$1;
        HardwareVideoEncoder$YuvFormat$2 hardwareVideoEncoder$YuvFormat$2 = new HardwareVideoEncoder$YuvFormat$2("NV12", 1);
        NV12 = hardwareVideoEncoder$YuvFormat$2;
        $VALUES = new HardwareVideoEncoder$YuvFormat[]{hardwareVideoEncoder$YuvFormat$1, hardwareVideoEncoder$YuvFormat$2};
    }

    private HardwareVideoEncoder$YuvFormat(String str, int i) {
        super(str, i);
    }

    public static HardwareVideoEncoder$YuvFormat valueOf(String str) {
        return (HardwareVideoEncoder$YuvFormat) Enum.valueOf(HardwareVideoEncoder$YuvFormat.class, str);
    }

    public static HardwareVideoEncoder$YuvFormat[] values() {
        return (HardwareVideoEncoder$YuvFormat[]) $VALUES.clone();
    }

    public abstract void fillBuffer(ByteBuffer byteBuffer, VideoFrame$Buffer videoFrame$Buffer);

    public /* synthetic */ HardwareVideoEncoder$YuvFormat(String str, int i, HardwareVideoEncoder$1 hardwareVideoEncoder$1) {
        this(str, i);
    }

    public static HardwareVideoEncoder$YuvFormat valueOf(int i) {
        if (i == 19) {
            return I420;
        }
        if (i == 21 || i == 2141391872 || i == 2141391876) {
            return NV12;
        }
        throw new IllegalArgumentException(a.q("Unsupported colorFormat: ", i));
    }
}
