package com.linecorp.apng.decoder;

import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Trace;
import androidx.annotation.IntRange;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.k;
import d0.z.d.m;

/* JADX INFO: compiled from: Apng.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Apng {
    public static final Apng$Companion Companion = new Apng$Companion(null);

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

    public Apng(int i, int i2, int i3, @IntRange(from = 1, to = 2147483647L) int i4, int[] iArr, @IntRange(from = 0, to = 2147483647L) int i5, @IntRange(from = 0, to = 2147483647L) long j) {
        m.checkNotNullParameter(iArr, "frameDurations");
        this.id = i;
        this.width = i2;
        this.height = i3;
        this.frameCount = i4;
        this.frameDurations = iArr;
        this.loopCount = i5;
        this.allFrameByteCount = j;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, Bitmap$Config.ARGB_8888);
        m.checkNotNullExpressionValue(bitmapCreateBitmap, "Bitmap.createBitmap(widt… Bitmap.Config.ARGB_8888)");
        this.bitmap = bitmapCreateBitmap;
        Trace.beginSection("Apng#draw");
        ApngDecoderJni.draw(i, 0, bitmapCreateBitmap);
        Trace.endSection();
        this.duration = k.sum(iArr);
    }

    public static final /* synthetic */ int access$getId$p(Apng apng) {
        return apng.id;
    }

    public final Apng copy() {
        return Companion.copy(this);
    }

    public final void drawWithIndex(int frameIndex, Canvas canvas, Rect src, Rect dst, Paint paint) {
        m.checkNotNullParameter(canvas, "canvas");
        m.checkNotNullParameter(dst, "dst");
        m.checkNotNullParameter(paint, "paint");
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

    public final Bitmap$Config getConfig() {
        Bitmap$Config config = this.bitmap.getConfig();
        m.checkNotNullExpressionValue(config, "bitmap.config");
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
