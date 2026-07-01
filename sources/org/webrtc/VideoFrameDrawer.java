package org.webrtc;

import android.graphics.Matrix;
import android.graphics.Point;
import androidx.annotation.Nullable;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes3.dex */
public class VideoFrameDrawer {
    public static final String TAG = "VideoFrameDrawer";
    public static final float[] srcPoints = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f};

    @Nullable
    private VideoFrame lastI420Frame;
    private int renderHeight;
    private int renderWidth;
    private final float[] dstPoints = new float[6];
    private final Point renderSize = new Point();
    private final VideoFrameDrawer$YuvUploader yuvUploader = new VideoFrameDrawer$YuvUploader(null);
    private final Matrix renderMatrix = new Matrix();

    private void calculateTransformedRenderSize(int i, int i2, @Nullable Matrix matrix) {
        if (matrix == null) {
            this.renderWidth = i;
            this.renderHeight = i2;
            return;
        }
        matrix.mapPoints(this.dstPoints, srcPoints);
        for (int i3 = 0; i3 < 3; i3++) {
            float[] fArr = this.dstPoints;
            int i4 = i3 * 2;
            int i5 = i4 + 0;
            fArr[i5] = fArr[i5] * i;
            int i6 = i4 + 1;
            fArr[i6] = fArr[i6] * i2;
        }
        float[] fArr2 = this.dstPoints;
        this.renderWidth = distance(fArr2[0], fArr2[1], fArr2[2], fArr2[3]);
        float[] fArr3 = this.dstPoints;
        this.renderHeight = distance(fArr3[0], fArr3[1], fArr3[4], fArr3[5]);
    }

    private static int distance(float f, float f2, float f3, float f4) {
        return (int) Math.round(Math.hypot(f3 - f, f4 - f2));
    }

    public static void drawTexture(RendererCommon$GlDrawer rendererCommon$GlDrawer, VideoFrame$TextureBuffer videoFrame$TextureBuffer, Matrix matrix, int i, int i2, int i3, int i4, int i5, int i6) {
        Matrix matrix2 = new Matrix(videoFrame$TextureBuffer.getTransformMatrix());
        matrix2.preConcat(matrix);
        float[] fArrConvertMatrixFromAndroidGraphicsMatrix = RendererCommon.convertMatrixFromAndroidGraphicsMatrix(matrix2);
        int iOrdinal = videoFrame$TextureBuffer.getType().ordinal();
        if (iOrdinal == 0) {
            rendererCommon$GlDrawer.drawOes(videoFrame$TextureBuffer.getTextureId(), fArrConvertMatrixFromAndroidGraphicsMatrix, i, i2, i3, i4, i5, i6);
        } else {
            if (iOrdinal != 1) {
                throw new RuntimeException("Unknown texture type.");
            }
            rendererCommon$GlDrawer.drawRgb(videoFrame$TextureBuffer.getTextureId(), fArrConvertMatrixFromAndroidGraphicsMatrix, i, i2, i3, i4, i5, i6);
        }
    }

    public void drawFrame(VideoFrame videoFrame, RendererCommon$GlDrawer rendererCommon$GlDrawer) {
        drawFrame(videoFrame, rendererCommon$GlDrawer, null);
    }

    public VideoFrame$Buffer prepareBufferForViewportSize(VideoFrame$Buffer videoFrame$Buffer, int i, int i2) {
        videoFrame$Buffer.retain();
        return videoFrame$Buffer;
    }

    public void release() {
        this.yuvUploader.release();
        this.lastI420Frame = null;
    }

    public void drawFrame(VideoFrame videoFrame, RendererCommon$GlDrawer rendererCommon$GlDrawer, Matrix matrix) {
        drawFrame(videoFrame, rendererCommon$GlDrawer, matrix, 0, 0, videoFrame.getRotatedWidth(), videoFrame.getRotatedHeight());
    }

    public void drawFrame(VideoFrame videoFrame, RendererCommon$GlDrawer rendererCommon$GlDrawer, @Nullable Matrix matrix, int i, int i2, int i3, int i4) {
        calculateTransformedRenderSize(videoFrame.getRotatedWidth(), videoFrame.getRotatedHeight(), matrix);
        if (this.renderWidth > 0 && this.renderHeight > 0) {
            boolean z2 = videoFrame.getBuffer() instanceof VideoFrame$TextureBuffer;
            this.renderMatrix.reset();
            this.renderMatrix.preTranslate(0.5f, 0.5f);
            if (!z2) {
                this.renderMatrix.preScale(1.0f, -1.0f);
            }
            this.renderMatrix.preRotate(videoFrame.getRotation());
            this.renderMatrix.preTranslate(-0.5f, -0.5f);
            if (matrix != null) {
                this.renderMatrix.preConcat(matrix);
            }
            if (z2) {
                this.lastI420Frame = null;
                drawTexture(rendererCommon$GlDrawer, (VideoFrame$TextureBuffer) videoFrame.getBuffer(), this.renderMatrix, this.renderWidth, this.renderHeight, i, i2, i3, i4);
                return;
            }
            if (videoFrame != this.lastI420Frame) {
                this.lastI420Frame = videoFrame;
                VideoFrame$I420Buffer i420 = videoFrame.getBuffer().toI420();
                this.yuvUploader.uploadFromBuffer(i420);
                i420.release();
            }
            rendererCommon$GlDrawer.drawYuv(this.yuvUploader.getYuvTextures(), RendererCommon.convertMatrixFromAndroidGraphicsMatrix(this.renderMatrix), this.renderWidth, this.renderHeight, i, i2, i3, i4);
            return;
        }
        StringBuilder sbU = a.U("Illegal frame size: ");
        sbU.append(this.renderWidth);
        sbU.append("x");
        sbU.append(this.renderHeight);
        Logging.w(TAG, sbU.toString());
    }
}
