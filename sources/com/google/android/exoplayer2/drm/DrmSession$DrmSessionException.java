package com.google.android.exoplayer2.drm;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class DrmSession$DrmSessionException extends IOException {
    public final int errorCode;

    public DrmSession$DrmSessionException(Throwable th, int i) {
        super(th);
        this.errorCode = i;
    }
}
