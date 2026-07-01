package com.linecorp.apng.decoder;

import android.os.Trace;
import d0.z.d.m;
import java.io.InputStream;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Apng.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Apng$Companion {
    public Apng$Companion() {
    }

    public final Apng copy(Apng apng) throws ApngException {
        m.checkNotNullParameter(apng, "apng");
        Apng$DecodeResult apng$DecodeResult = new Apng$DecodeResult();
        Trace.beginSection("Apng#copy");
        try {
            int iCopy = ApngDecoderJni.copy(Apng.access$getId$p(apng), apng$DecodeResult);
            Trace.endSection();
            if (iCopy < 0) {
                throw new ApngException(ApngException$ErrorCode.Companion.fromErrorCode$apng_drawable_release(iCopy), null, 2, null);
            }
            try {
                return new Apng(iCopy, apng$DecodeResult.getWidth(), apng$DecodeResult.getHeight(), apng$DecodeResult.getFrameCount(), apng$DecodeResult.getFrameDurations(), apng$DecodeResult.getLoopCount(), apng$DecodeResult.getAllFrameByteCount());
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

    public final Apng decode(InputStream stream) throws ApngException {
        m.checkNotNullParameter(stream, "stream");
        Apng$DecodeResult apng$DecodeResult = new Apng$DecodeResult();
        Trace.beginSection("Apng#decode");
        try {
            int iDecode = ApngDecoderJni.decode(stream, apng$DecodeResult);
            Trace.endSection();
            if (iDecode < 0) {
                throw new ApngException(ApngException$ErrorCode.Companion.fromErrorCode$apng_drawable_release(iDecode), null, 2, null);
            }
            try {
                return new Apng(iDecode, apng$DecodeResult.getWidth(), apng$DecodeResult.getHeight(), apng$DecodeResult.getFrameCount(), apng$DecodeResult.getFrameDurations(), apng$DecodeResult.getLoopCount(), apng$DecodeResult.getAllFrameByteCount());
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
        m.checkNotNullParameter(stream, "stream");
        try {
            return ApngDecoderJni.isApng(stream);
        } catch (Throwable th) {
            throw new ApngException(th);
        }
    }

    public Apng$Companion(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
