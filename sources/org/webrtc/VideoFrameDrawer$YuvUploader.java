package org.webrtc;

import android.opengl.GLES20;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class VideoFrameDrawer$YuvUploader {

    @Nullable
    private ByteBuffer copyBuffer;

    @Nullable
    private int[] yuvTextures;

    private VideoFrameDrawer$YuvUploader() {
    }

    @Nullable
    public int[] getYuvTextures() {
        return this.yuvTextures;
    }

    public void release() {
        this.copyBuffer = null;
        int[] iArr = this.yuvTextures;
        if (iArr != null) {
            GLES20.glDeleteTextures(3, iArr, 0);
            this.yuvTextures = null;
        }
    }

    @Nullable
    public int[] uploadFromBuffer(VideoFrame$I420Buffer videoFrame$I420Buffer) {
        return uploadYuvData(videoFrame$I420Buffer.getWidth(), videoFrame$I420Buffer.getHeight(), new int[]{videoFrame$I420Buffer.getStrideY(), videoFrame$I420Buffer.getStrideU(), videoFrame$I420Buffer.getStrideV()}, new ByteBuffer[]{videoFrame$I420Buffer.getDataY(), videoFrame$I420Buffer.getDataU(), videoFrame$I420Buffer.getDataV()});
    }

    @Nullable
    public int[] uploadYuvData(int i, int i2, int[] iArr, ByteBuffer[] byteBufferArr) {
        ByteBuffer byteBuffer;
        ByteBuffer byteBuffer2;
        int i3 = i / 2;
        int[] iArr2 = {i, i3, i3};
        int i4 = i2 / 2;
        int[] iArr3 = {i2, i4, i4};
        int iMax = 0;
        for (int i5 = 0; i5 < 3; i5++) {
            if (iArr[i5] > iArr2[i5]) {
                iMax = Math.max(iMax, iArr2[i5] * iArr3[i5]);
            }
        }
        if (iMax > 0 && ((byteBuffer2 = this.copyBuffer) == null || byteBuffer2.capacity() < iMax)) {
            this.copyBuffer = ByteBuffer.allocateDirect(iMax);
        }
        if (this.yuvTextures == null) {
            this.yuvTextures = new int[3];
            for (int i6 = 0; i6 < 3; i6++) {
                this.yuvTextures[i6] = GlUtil.generateTexture(3553);
            }
        }
        for (int i7 = 0; i7 < 3; i7++) {
            GLES20.glActiveTexture(33984 + i7);
            GLES20.glBindTexture(3553, this.yuvTextures[i7]);
            if (iArr[i7] == iArr2[i7]) {
                byteBuffer = byteBufferArr[i7];
            } else {
                YuvHelper.copyPlane(byteBufferArr[i7], iArr[i7], this.copyBuffer, iArr2[i7], iArr2[i7], iArr3[i7]);
                byteBuffer = this.copyBuffer;
            }
            GLES20.glTexImage2D(3553, 0, 6409, iArr2[i7], iArr3[i7], 0, 6409, 5121, byteBuffer);
        }
        return this.yuvTextures;
    }

    public /* synthetic */ VideoFrameDrawer$YuvUploader(VideoFrameDrawer$1 videoFrameDrawer$1) {
        this();
    }
}
