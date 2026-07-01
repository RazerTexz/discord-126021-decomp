package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.exifinterface.media.ExifInterface;
import b.c.a.a0.AnimatableValueParser;
import b.f.d.d.DoNotStrip;
import b.f.j.l.FlexByteArrayPool;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder;

/* JADX INFO: loaded from: classes3.dex */
@DoNotStrip
@TargetApi(19)
public class KitKatPurgeableDecoder extends DalvikPurgeableDecoder {
    public final FlexByteArrayPool c;

    @DoNotStrip
    public KitKatPurgeableDecoder(FlexByteArrayPool flexByteArrayPool) {
        this.c = flexByteArrayPool;
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    public Bitmap c(CloseableReference<PooledByteBuffer> closeableReference, BitmapFactory.Options options) {
        PooledByteBuffer pooledByteBufferU = closeableReference.u();
        int size = pooledByteBufferU.size();
        CloseableReference<byte[]> closeableReferenceA = this.c.a(size);
        try {
            byte[] bArrU = closeableReferenceA.u();
            pooledByteBufferU.i(0, bArrU, 0, size);
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrU, 0, size, options);
            AnimatableValueParser.y(bitmapDecodeByteArray, "BitmapFactory returned null");
            closeableReferenceA.close();
            return bitmapDecodeByteArray;
        } catch (Throwable th) {
            if (closeableReferenceA != null) {
                closeableReferenceA.close();
            }
            throw th;
        }
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    public Bitmap d(CloseableReference<PooledByteBuffer> closeableReference, int i, BitmapFactory.Options options) {
        byte[] bArr = DalvikPurgeableDecoder.e(closeableReference, i) ? null : DalvikPurgeableDecoder.a;
        PooledByteBuffer pooledByteBufferU = closeableReference.u();
        AnimatableValueParser.i(Boolean.valueOf(i <= pooledByteBufferU.size()));
        int i2 = i + 2;
        CloseableReference<byte[]> closeableReferenceA = this.c.a(i2);
        try {
            byte[] bArrU = closeableReferenceA.u();
            pooledByteBufferU.i(0, bArrU, 0, i);
            if (bArr != null) {
                bArrU[i] = -1;
                bArrU[i + 1] = ExifInterface.MARKER_EOI;
                i = i2;
            }
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrU, 0, i, options);
            AnimatableValueParser.y(bitmapDecodeByteArray, "BitmapFactory returned null");
            closeableReferenceA.close();
            return bitmapDecodeByteArray;
        } catch (Throwable th) {
            if (closeableReferenceA != null) {
                closeableReferenceA.close();
            }
            throw th;
        }
    }
}
