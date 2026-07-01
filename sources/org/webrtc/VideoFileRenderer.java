package org.webrtc;

import android.os.Handler;
import android.os.HandlerThread;
import h0.c.d0;
import h0.c.e0;
import h0.c.f0;
import h0.c.g0;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes3.dex */
public class VideoFileRenderer implements VideoSink {
    private static final String TAG = "VideoFileRenderer";
    private EglBase eglBase;
    private final HandlerThread fileThread;
    private final Handler fileThreadHandler;
    private int frameCount;
    private final int outputFileHeight;
    private final String outputFileName;
    private final int outputFileWidth;
    private final ByteBuffer outputFrameBuffer;
    private final int outputFrameSize;
    private final HandlerThread renderThread;
    private final Handler renderThreadHandler;
    private final FileOutputStream videoOutFile;
    private YuvConverter yuvConverter;

    public VideoFileRenderer(String str, int i, int i2, EglBase$Context eglBase$Context) throws IOException {
        if (i % 2 == 1 || i2 % 2 == 1) {
            throw new IllegalArgumentException("Does not support uneven width or height");
        }
        this.outputFileName = str;
        this.outputFileWidth = i;
        this.outputFileHeight = i2;
        int i3 = ((i * i2) * 3) / 2;
        this.outputFrameSize = i3;
        this.outputFrameBuffer = ByteBuffer.allocateDirect(i3);
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        this.videoOutFile = fileOutputStream;
        fileOutputStream.write(("YUV4MPEG2 C420 W" + i + " H" + i2 + " Ip F30:1 A1:1\n").getBytes(Charset.forName("US-ASCII")));
        HandlerThread handlerThread = new HandlerThread("VideoFileRendererRenderThread");
        this.renderThread = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.renderThreadHandler = handler;
        HandlerThread handlerThread2 = new HandlerThread("VideoFileRendererFileThread");
        this.fileThread = handlerThread2;
        handlerThread2.start();
        this.fileThreadHandler = new Handler(handlerThread2.getLooper());
        ThreadUtils.invokeAtFrontUninterruptibly(handler, new VideoFileRenderer$1(this, eglBase$Context));
    }

    public static /* synthetic */ EglBase access$000(VideoFileRenderer videoFileRenderer) {
        return videoFileRenderer.eglBase;
    }

    public static /* synthetic */ EglBase access$002(VideoFileRenderer videoFileRenderer, EglBase eglBase) {
        videoFileRenderer.eglBase = eglBase;
        return eglBase;
    }

    public static /* synthetic */ YuvConverter access$102(VideoFileRenderer videoFileRenderer, YuvConverter yuvConverter) {
        videoFileRenderer.yuvConverter = yuvConverter;
        return yuvConverter;
    }

    private void renderFrameOnRenderThread(VideoFrame videoFrame) {
        VideoFrame$Buffer buffer = videoFrame.getBuffer();
        int i = videoFrame.getRotation() % 180 == 0 ? this.outputFileWidth : this.outputFileHeight;
        int i2 = videoFrame.getRotation() % 180 == 0 ? this.outputFileHeight : this.outputFileWidth;
        float width = buffer.getWidth() / buffer.getHeight();
        float f = i / i2;
        int width2 = buffer.getWidth();
        int height = buffer.getHeight();
        if (f > width) {
            height = (int) ((width / f) * height);
        } else {
            width2 = (int) ((f / width) * width2);
        }
        VideoFrame$Buffer videoFrame$BufferCropAndScale = buffer.cropAndScale((buffer.getWidth() - width2) / 2, (buffer.getHeight() - height) / 2, width2, height, i, i2);
        videoFrame.release();
        VideoFrame$I420Buffer i420 = videoFrame$BufferCropAndScale.toI420();
        videoFrame$BufferCropAndScale.release();
        this.fileThreadHandler.post(new g0(this, i420, videoFrame));
    }

    public /* synthetic */ void a(VideoFrame videoFrame) {
        renderFrameOnRenderThread(videoFrame);
    }

    public /* synthetic */ void b(CountDownLatch countDownLatch) {
        this.yuvConverter.release();
        this.eglBase.release();
        this.renderThread.quit();
        countDownLatch.countDown();
    }

    public /* synthetic */ void c() {
        try {
            this.videoOutFile.close();
            Logging.d(TAG, "Video written to disk as " + this.outputFileName + ". The number of frames is " + this.frameCount + " and the dimensions of the frames are " + this.outputFileWidth + "x" + this.outputFileHeight + ".");
            this.fileThread.quit();
        } catch (IOException e) {
            throw new RuntimeException("Error closing output file", e);
        }
    }

    public /* synthetic */ void d(VideoFrame$I420Buffer videoFrame$I420Buffer, VideoFrame videoFrame) {
        YuvHelper.I420Rotate(videoFrame$I420Buffer.getDataY(), videoFrame$I420Buffer.getStrideY(), videoFrame$I420Buffer.getDataU(), videoFrame$I420Buffer.getStrideU(), videoFrame$I420Buffer.getDataV(), videoFrame$I420Buffer.getStrideV(), this.outputFrameBuffer, videoFrame$I420Buffer.getWidth(), videoFrame$I420Buffer.getHeight(), videoFrame.getRotation());
        videoFrame$I420Buffer.release();
        try {
            this.videoOutFile.write("FRAME\n".getBytes(Charset.forName("US-ASCII")));
            this.videoOutFile.write(this.outputFrameBuffer.array(), this.outputFrameBuffer.arrayOffset(), this.outputFrameSize);
            this.frameCount++;
        } catch (IOException e) {
            throw new RuntimeException("Error writing video to disk", e);
        }
    }

    @Override // org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        videoFrame.retain();
        this.renderThreadHandler.post(new e0(this, videoFrame));
    }

    public void release() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.renderThreadHandler.post(new f0(this, countDownLatch));
        ThreadUtils.awaitUninterruptibly(countDownLatch);
        this.fileThreadHandler.post(new d0(this));
        try {
            this.fileThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            Logging.e(TAG, "Interrupted while waiting for the write to disk to complete.", e);
        }
    }
}
