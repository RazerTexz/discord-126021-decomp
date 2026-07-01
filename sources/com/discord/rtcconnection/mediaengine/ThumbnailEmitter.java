package com.discord.rtcconnection.mediaengine;

import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import android.graphics.Matrix;
import android.opengl.GLES20;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import d0.a0.a;
import d0.z.d.m;
import java.nio.ByteBuffer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.webrtc.GlRectDrawer;
import org.webrtc.GlTextureFrameBuffer;
import org.webrtc.GlUtil;
import org.webrtc.JniCommon;
import org.webrtc.VideoFrame;
import org.webrtc.VideoFrameDrawer;

/* JADX INFO: compiled from: ThumbnailEmitter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ThumbnailEmitter {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public long lastTimestampNs;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final ByteBuffer outputByteBuffer;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final GlRectDrawer rectDrawer;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final VideoFrameDrawer frameDrawer;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final long initializationTimeMs;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final Matrix renderMatrix;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final int width;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final int height;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final long periodMs;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final long initialDelayMs;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final Clock clock;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final Function1<Bitmap, Unit> onNextThumbnail;

    public ThumbnailEmitter(int i, int i2, long j, long j2, Clock clock, Function1 function1, int i3) {
        j2 = (i3 & 8) != 0 ? 0L : j2;
        Clock clock2 = (i3 & 16) != 0 ? ClockFactory.get() : null;
        m.checkNotNullParameter(clock2, "clock");
        m.checkNotNullParameter(function1, "onNextThumbnail");
        this.width = i;
        this.height = i2;
        this.periodMs = j;
        this.initialDelayMs = j2;
        this.clock = clock2;
        this.onNextThumbnail = function1;
        long j3 = 1000;
        this.lastTimestampNs = -(j * j3 * j3);
        this.outputByteBuffer = JniCommon.nativeAllocateByteBuffer(i * i2 * 4);
        this.rectDrawer = new GlRectDrawer();
        this.frameDrawer = new VideoFrameDrawer();
        this.initializationTimeMs = clock2.currentTimeMillis();
        Matrix matrix = new Matrix();
        matrix.preTranslate(0.5f, 0.5f);
        matrix.preScale(1.0f, -1.0f);
        matrix.preTranslate(-0.5f, -0.5f);
        this.renderMatrix = matrix;
    }

    public final Bitmap a(VideoFrame frame) {
        GlTextureFrameBuffer glTextureFrameBuffer = new GlTextureFrameBuffer(6408);
        glTextureFrameBuffer.setSize(this.width, this.height);
        GLES20.glBindFramebuffer(36160, glTextureFrameBuffer.getFrameBufferId());
        GlUtil.checkNoGLES2Error("glBindFramebuffer");
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16384);
        if (frame.getRotatedWidth() / frame.getRotatedHeight() < this.width / this.height) {
            float rotatedHeight = (this.height / frame.getRotatedHeight()) * frame.getRotatedWidth();
            this.frameDrawer.drawFrame(frame, this.rectDrawer, this.renderMatrix, a.roundToInt((this.width - rotatedHeight) / 2.0f), 0, a.roundToInt(rotatedHeight), this.height);
        } else {
            float rotatedWidth = (this.width / frame.getRotatedWidth()) * frame.getRotatedHeight();
            this.frameDrawer.drawFrame(frame, this.rectDrawer, this.renderMatrix, 0, a.roundToInt((this.height - rotatedWidth) / 2.0f), this.width, a.roundToInt(rotatedWidth));
        }
        this.outputByteBuffer.rewind();
        GLES20.glReadPixels(0, 0, glTextureFrameBuffer.getWidth(), glTextureFrameBuffer.getHeight(), 6408, 5121, this.outputByteBuffer);
        GlUtil.checkNoGLES2Error("ThumbnailEmitter.createThumbnail");
        glTextureFrameBuffer.release();
        this.outputByteBuffer.rewind();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap$Config.ARGB_8888);
        bitmapCreateBitmap.copyPixelsFromBuffer(this.outputByteBuffer);
        m.checkNotNullExpressionValue(bitmapCreateBitmap, "bitmap");
        return bitmapCreateBitmap;
    }
}
