package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public enum VideoFrame$TextureBuffer$Type {
    OES(36197),
    RGB(3553);

    private final int glTarget;

    VideoFrame$TextureBuffer$Type(int i) {
        this.glTarget = i;
    }

    public int getGlTarget() {
        return this.glTarget;
    }
}
