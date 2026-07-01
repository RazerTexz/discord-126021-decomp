package h0.c;

import androidx.annotation.Nullable;
import org.webrtc.EglBase;
import org.webrtc.EglBase$Context;
import org.webrtc.EglBase10$Context;
import org.webrtc.EglBase10Impl;
import org.webrtc.EglBase14$Context;
import org.webrtc.EglBase14Impl;

/* JADX INFO: compiled from: EglBase.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class n0 {
    public static EglBase a() {
        return b(null, EglBase.CONFIG_PLAIN);
    }

    public static EglBase b(@Nullable EglBase$Context eglBase$Context, int[] iArr) {
        if (eglBase$Context == null) {
            return EglBase14Impl.isEGL14Supported() ? new EglBase14Impl(null, iArr) : new EglBase10Impl(null, iArr);
        }
        if (eglBase$Context instanceof EglBase14$Context) {
            return new EglBase14Impl(((EglBase14$Context) eglBase$Context).getRawContext(), iArr);
        }
        if (eglBase$Context instanceof EglBase10$Context) {
            return new EglBase10Impl(((EglBase10$Context) eglBase$Context).getRawContext(), iArr);
        }
        throw new IllegalArgumentException("Unrecognized Context");
    }

    public static int c(int[] iArr) {
        for (int i = 0; i < iArr.length - 1; i++) {
            if (iArr[i] == 12352) {
                int i2 = iArr[i + 1];
                if (i2 != 4) {
                    return i2 != 64 ? 1 : 3;
                }
                return 2;
            }
        }
        return 1;
    }
}
