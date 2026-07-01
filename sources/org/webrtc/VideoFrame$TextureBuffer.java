package org.webrtc;

import android.graphics.Matrix;

/* JADX INFO: loaded from: classes3.dex */
public interface VideoFrame$TextureBuffer extends VideoFrame$Buffer {
    int getTextureId();

    Matrix getTransformMatrix();

    VideoFrame$TextureBuffer$Type getType();
}
