package org.webrtc;

import android.graphics.Matrix;
import android.opengl.GLES20;
import h0.c.j0;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class YuvConverter {
    private static final String FRAGMENT_SHADER = "uniform vec2 xUnit;\nuniform vec4 coeffs;\n\nvoid main() {\n  gl_FragColor.r = coeffs.a + dot(coeffs.rgb,\n      sample(tc - 1.5 * xUnit).rgb);\n  gl_FragColor.g = coeffs.a + dot(coeffs.rgb,\n      sample(tc - 0.5 * xUnit).rgb);\n  gl_FragColor.b = coeffs.a + dot(coeffs.rgb,\n      sample(tc + 0.5 * xUnit).rgb);\n  gl_FragColor.a = coeffs.a + dot(coeffs.rgb,\n      sample(tc + 1.5 * xUnit).rgb);\n}\n";
    private final GlGenericDrawer drawer;
    private final GlTextureFrameBuffer i420TextureFrameBuffer;
    private final YuvConverter$ShaderCallbacks shaderCallbacks;
    private final ThreadUtils$ThreadChecker threadChecker;
    private final VideoFrameDrawer videoFrameDrawer;

    public YuvConverter() {
        this(new VideoFrameDrawer());
    }

    public VideoFrame$I420Buffer convert(VideoFrame$TextureBuffer videoFrame$TextureBuffer) {
        this.threadChecker.checkIsOnValidThread();
        VideoFrame$TextureBuffer videoFrame$TextureBuffer2 = (VideoFrame$TextureBuffer) this.videoFrameDrawer.prepareBufferForViewportSize(videoFrame$TextureBuffer, videoFrame$TextureBuffer.getWidth(), videoFrame$TextureBuffer.getHeight());
        int width = videoFrame$TextureBuffer2.getWidth();
        int height = videoFrame$TextureBuffer2.getHeight();
        int i = ((width + 7) / 8) * 8;
        int i2 = (height + 1) / 2;
        int i3 = height + i2;
        ByteBuffer byteBufferNativeAllocateByteBuffer = JniCommon.nativeAllocateByteBuffer(i * i3);
        int i4 = i / 4;
        Matrix matrix = new Matrix();
        matrix.preTranslate(0.5f, 0.5f);
        matrix.preScale(1.0f, -1.0f);
        matrix.preTranslate(-0.5f, -0.5f);
        this.i420TextureFrameBuffer.setSize(i4, i3);
        GLES20.glBindFramebuffer(36160, this.i420TextureFrameBuffer.getFrameBufferId());
        GlUtil.checkNoGLES2Error("glBindFramebuffer");
        this.shaderCallbacks.setPlaneY();
        VideoFrameDrawer.drawTexture(this.drawer, videoFrame$TextureBuffer2, matrix, width, height, 0, 0, i4, height);
        this.shaderCallbacks.setPlaneU();
        int i5 = i4 / 2;
        VideoFrameDrawer.drawTexture(this.drawer, videoFrame$TextureBuffer2, matrix, width, height, 0, height, i5, i2);
        this.shaderCallbacks.setPlaneV();
        VideoFrameDrawer.drawTexture(this.drawer, videoFrame$TextureBuffer2, matrix, width, height, i5, height, i5, i2);
        GLES20.glReadPixels(0, 0, this.i420TextureFrameBuffer.getWidth(), this.i420TextureFrameBuffer.getHeight(), 6408, 5121, byteBufferNativeAllocateByteBuffer);
        GlUtil.checkNoGLES2Error("YuvConverter.convert");
        GLES20.glBindFramebuffer(36160, 0);
        int i6 = (i * height) + 0;
        int i7 = i / 2;
        int i8 = i6 + i7;
        byteBufferNativeAllocateByteBuffer.position(0);
        byteBufferNativeAllocateByteBuffer.limit(i6);
        ByteBuffer byteBufferSlice = byteBufferNativeAllocateByteBuffer.slice();
        byteBufferNativeAllocateByteBuffer.position(i6);
        int i9 = ((i2 - 1) * i) + i7;
        byteBufferNativeAllocateByteBuffer.limit(i6 + i9);
        ByteBuffer byteBufferSlice2 = byteBufferNativeAllocateByteBuffer.slice();
        byteBufferNativeAllocateByteBuffer.position(i8);
        byteBufferNativeAllocateByteBuffer.limit(i8 + i9);
        ByteBuffer byteBufferSlice3 = byteBufferNativeAllocateByteBuffer.slice();
        videoFrame$TextureBuffer2.release();
        return JavaI420Buffer.wrap(width, height, byteBufferSlice, i, byteBufferSlice2, i, byteBufferSlice3, i, new j0(byteBufferNativeAllocateByteBuffer));
    }

    public void release() {
        this.threadChecker.checkIsOnValidThread();
        this.drawer.release();
        this.i420TextureFrameBuffer.release();
        this.videoFrameDrawer.release();
        this.threadChecker.detachThread();
    }

    public YuvConverter(VideoFrameDrawer videoFrameDrawer) {
        ThreadUtils$ThreadChecker threadUtils$ThreadChecker = new ThreadUtils$ThreadChecker();
        this.threadChecker = threadUtils$ThreadChecker;
        this.i420TextureFrameBuffer = new GlTextureFrameBuffer(6408);
        YuvConverter$ShaderCallbacks yuvConverter$ShaderCallbacks = new YuvConverter$ShaderCallbacks(null);
        this.shaderCallbacks = yuvConverter$ShaderCallbacks;
        this.drawer = new GlGenericDrawer(FRAGMENT_SHADER, yuvConverter$ShaderCallbacks);
        this.videoFrameDrawer = videoFrameDrawer;
        threadUtils$ThreadChecker.detachThread();
    }
}
