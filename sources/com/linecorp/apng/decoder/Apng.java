package com.linecorp.apng.decoder;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Trace;
import androidx.annotation.IntRange;
import com.discord.models.domain.ModelAuditLogEntry;
import com.linecorp.apng.decoder.ApngException;
import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import java.io.InputStream;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Apng.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Apng {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final Bitmap bitmap;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @IntRange(from = 0, to = 2147483647L)
    public final int duration;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final int id;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final int width;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final int height;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final int frameCount;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final int[] frameDurations;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final int loopCount;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final long allFrameByteCount;

    /* JADX INFO: compiled from: Apng.kt */
    public static final class Companion {
        public Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Apng copy(Apng apng) throws ApngException {
            Intrinsics3.checkNotNullParameter(apng, "apng");
            DecodeResult decodeResult = new DecodeResult();
            Trace.beginSection("Apng#copy");
            try {
                int iCopy = ApngDecoderJni.copy(apng.id, decodeResult);
                Trace.endSection();
                if (iCopy < 0) {
                    throw new ApngException(ApngException.ErrorCode.INSTANCE.fromErrorCode$apng_drawable_release(iCopy), null, 2, 0 == true ? 1 : 0);
                }
                try {
                    return new Apng(iCopy, decodeResult.getWidth(), decodeResult.getHeight(), decodeResult.getFrameCount(), decodeResult.getFrameDurations(), decodeResult.getLoopCount(), decodeResult.getAllFrameByteCount());
                } catch (Throwable th) {
                    throw new ApngException(th);
                }
            } catch (Throwable th2) {
                try {
                    throw new ApngException(th2);
                } catch (Throwable th3) {
                    Trace.endSection();
                    throw th3;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Apng decode(InputStream stream) throws ApngException {
            Intrinsics3.checkNotNullParameter(stream, "stream");
            DecodeResult decodeResult = new DecodeResult();
            Trace.beginSection("Apng#decode");
            try {
                int iDecode = ApngDecoderJni.decode(stream, decodeResult);
                Trace.endSection();
                if (iDecode < 0) {
                    throw new ApngException(ApngException.ErrorCode.INSTANCE.fromErrorCode$apng_drawable_release(iDecode), null, 2, 0 == true ? 1 : 0);
                }
                try {
                    return new Apng(iDecode, decodeResult.getWidth(), decodeResult.getHeight(), decodeResult.getFrameCount(), decodeResult.getFrameDurations(), decodeResult.getLoopCount(), decodeResult.getAllFrameByteCount());
                } catch (Throwable th) {
                    throw new ApngException(th);
                }
            } catch (Throwable th2) {
                try {
                    throw new ApngException(th2);
                } catch (Throwable th3) {
                    Trace.endSection();
                    throw th3;
                }
            }
        }

        public final boolean isApng(InputStream stream) throws ApngException {
            Intrinsics3.checkNotNullParameter(stream, "stream");
            try {
                return ApngDecoderJni.isApng(stream);
            } catch (Throwable th) {
                throw new ApngException(th);
            }
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: compiled from: Apng.kt */
    public static final class DecodeResult {
        private long allFrameByteCount;
        private int frameCount;
        private int[] frameDurations = new int[0];
        private int height;
        private int loopCount;
        private int width;

        public final long getAllFrameByteCount() {
            return this.allFrameByteCount;
        }

        public final int getFrameCount() {
            return this.frameCount;
        }

        public final int[] getFrameDurations() {
            return this.frameDurations;
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getLoopCount() {
            return this.loopCount;
        }

        public final int getWidth() {
            return this.width;
        }

        public final void setAllFrameByteCount(long j) {
            this.allFrameByteCount = j;
        }

        public final void setFrameCount(int i) {
            this.frameCount = i;
        }

        public final void setFrameDurations(int[] iArr) {
            Intrinsics3.checkNotNullParameter(iArr, "<set-?>");
            this.frameDurations = iArr;
        }

        public final void setHeight(int i) {
            this.height = i;
        }

        public final void setLoopCount(int i) {
            this.loopCount = i;
        }

        public final void setWidth(int i) {
            this.width = i;
        }
    }

    public Apng(int i, int i2, int i3, @IntRange(from = 1, to = 2147483647L) int i4, int[] iArr, @IntRange(from = 0, to = 2147483647L) int i5, @IntRange(from = 0, to = 2147483647L) long j) {
        Intrinsics3.checkNotNullParameter(iArr, "frameDurations");
        this.id = i;
        this.width = i2;
        this.height = i3;
        this.frameCount = i4;
        this.frameDurations = iArr;
        this.loopCount = i5;
        this.allFrameByteCount = j;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Intrinsics3.checkNotNullExpressionValue(bitmapCreateBitmap, "Bitmap.createBitmap(widt… Bitmap.Config.ARGB_8888)");
        this.bitmap = bitmapCreateBitmap;
        Trace.beginSection("Apng#draw");
        ApngDecoderJni.draw(i, 0, bitmapCreateBitmap);
        Trace.endSection();
        this.duration = _Arrays.sum(iArr);
    }

    public final Apng copy() {
        return INSTANCE.copy(this);
    }

    public final void drawWithIndex(int frameIndex, Canvas canvas, Rect src, Rect dst, Paint paint) {
        Intrinsics3.checkNotNullParameter(canvas, "canvas");
        Intrinsics3.checkNotNullParameter(dst, "dst");
        Intrinsics3.checkNotNullParameter(paint, "paint");
        Trace.beginSection("Apng#draw");
        ApngDecoderJni.draw(this.id, frameIndex, this.bitmap);
        Trace.endSection();
        canvas.drawBitmap(this.bitmap, src, dst, paint);
    }

    public final void finalize() {
        recycle();
    }

    public final long getAllFrameByteCount() {
        return this.allFrameByteCount;
    }

    public final int getByteCount() {
        return this.bitmap.getAllocationByteCount();
    }

    public final Bitmap.Config getConfig() {
        Bitmap.Config config = this.bitmap.getConfig();
        Intrinsics3.checkNotNullExpressionValue(config, "bitmap.config");
        return config;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final int getFrameCount() {
        return this.frameCount;
    }

    public final int[] getFrameDurations() {
        return this.frameDurations;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getLoopCount() {
        return this.loopCount;
    }

    public final int getWidth() {
        return this.width;
    }

    public final boolean isRecycled() {
        return this.bitmap.isRecycled();
    }

    public final void recycle() {
        ApngDecoderJni.recycle(this.id);
    }
}
