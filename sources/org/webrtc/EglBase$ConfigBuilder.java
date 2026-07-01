package org.webrtc;

import b.d.b.a.a;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class EglBase$ConfigBuilder {
    private boolean hasAlphaChannel;
    private boolean isRecordable;
    private int openGlesVersion = 2;
    private boolean supportsPixelBuffer;

    public int[] createConfigAttributes() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(12324);
        arrayList.add(8);
        arrayList.add(12323);
        arrayList.add(8);
        arrayList.add(12322);
        arrayList.add(8);
        if (this.hasAlphaChannel) {
            arrayList.add(12321);
            arrayList.add(8);
        }
        int i = this.openGlesVersion;
        if (i == 2 || i == 3) {
            arrayList.add(12352);
            arrayList.add(Integer.valueOf(this.openGlesVersion == 3 ? 64 : 4));
        }
        if (this.supportsPixelBuffer) {
            arrayList.add(12339);
            arrayList.add(1);
        }
        if (this.isRecordable) {
            arrayList.add(Integer.valueOf(EglBase.EGL_RECORDABLE_ANDROID));
            arrayList.add(1);
        }
        arrayList.add(12344);
        int[] iArr = new int[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        return iArr;
    }

    public EglBase$ConfigBuilder setHasAlphaChannel(boolean z2) {
        this.hasAlphaChannel = z2;
        return this;
    }

    public EglBase$ConfigBuilder setIsRecordable(boolean z2) {
        this.isRecordable = z2;
        return this;
    }

    public EglBase$ConfigBuilder setOpenGlesVersion(int i) {
        if (i < 1 || i > 3) {
            throw new IllegalArgumentException(a.r("OpenGL ES version ", i, " not supported"));
        }
        this.openGlesVersion = i;
        return this;
    }

    public EglBase$ConfigBuilder setSupportsPixelBuffer(boolean z2) {
        this.supportsPixelBuffer = z2;
        return this;
    }
}
