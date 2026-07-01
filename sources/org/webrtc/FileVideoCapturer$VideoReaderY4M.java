package org.webrtc;

import android.os.SystemClock;
import b.d.b.a.a;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class FileVideoCapturer$VideoReaderY4M implements FileVideoCapturer$VideoReader {
    private static final int FRAME_DELIMETER_LENGTH = 6;
    private static final String TAG = "VideoReaderY4M";
    private static final String Y4M_FRAME_DELIMETER = "FRAME";
    private final int frameHeight;
    private final int frameWidth;
    private final RandomAccessFile mediaFile;
    private final FileChannel mediaFileChannel;
    private final long videoStart;

    public FileVideoCapturer$VideoReaderY4M(String str) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        this.mediaFile = randomAccessFile;
        this.mediaFileChannel = randomAccessFile.getChannel();
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i = this.mediaFile.read();
            if (i == -1) {
                throw new RuntimeException(a.w("Found end of file before end of header for file: ", str));
            }
            if (i == 10) {
                this.videoStart = this.mediaFileChannel.position();
                String strSubstring = "";
                int i2 = 0;
                int i3 = 0;
                for (String str2 : sb.toString().split("[ ]")) {
                    char cCharAt = str2.charAt(0);
                    if (cCharAt == 'C') {
                        strSubstring = str2.substring(1);
                    } else if (cCharAt == 'H') {
                        i3 = Integer.parseInt(str2.substring(1));
                    } else if (cCharAt == 'W') {
                        i2 = Integer.parseInt(str2.substring(1));
                    }
                }
                Logging.d(TAG, "Color space: " + strSubstring);
                if (!strSubstring.equals("420") && !strSubstring.equals("420mpeg2")) {
                    throw new IllegalArgumentException("Does not support any other color space than I420 or I420mpeg2");
                }
                if (i2 % 2 == 1 || i3 % 2 == 1) {
                    throw new IllegalArgumentException("Does not support odd width or height");
                }
                this.frameWidth = i2;
                this.frameHeight = i3;
                Logging.d(TAG, "frame dim: (" + i2 + ", " + i3 + ")");
                return;
            }
            sb.append((char) i);
        }
    }

    @Override // org.webrtc.FileVideoCapturer$VideoReader
    public void close() {
        try {
            this.mediaFile.close();
        } catch (IOException e) {
            Logging.e(TAG, "Problem closing file", e);
        }
    }

    @Override // org.webrtc.FileVideoCapturer$VideoReader
    public VideoFrame getNextFrame() {
        long nanos = TimeUnit.MILLISECONDS.toNanos(SystemClock.elapsedRealtime());
        JavaI420Buffer javaI420BufferAllocate = JavaI420Buffer.allocate(this.frameWidth, this.frameHeight);
        ByteBuffer dataY = javaI420BufferAllocate.getDataY();
        ByteBuffer dataU = javaI420BufferAllocate.getDataU();
        ByteBuffer dataV = javaI420BufferAllocate.getDataV();
        int i = (this.frameHeight + 1) / 2;
        javaI420BufferAllocate.getStrideY();
        javaI420BufferAllocate.getStrideU();
        javaI420BufferAllocate.getStrideV();
        try {
            int i2 = FRAME_DELIMETER_LENGTH;
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i2);
            if (this.mediaFileChannel.read(byteBufferAllocate) < i2) {
                this.mediaFileChannel.position(this.videoStart);
                if (this.mediaFileChannel.read(byteBufferAllocate) < i2) {
                    throw new RuntimeException("Error looping video");
                }
            }
            String str = new String(byteBufferAllocate.array(), Charset.forName("US-ASCII"));
            if (str.equals("FRAME\n")) {
                this.mediaFileChannel.read(dataY);
                this.mediaFileChannel.read(dataU);
                this.mediaFileChannel.read(dataV);
                return new VideoFrame(javaI420BufferAllocate, 0, nanos);
            }
            throw new RuntimeException("Frames should be delimited by FRAME plus newline, found delimter was: '" + str + "'");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
