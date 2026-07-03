package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p119d.InterfaceC1680c;
import p007b.p109f.p161j.p177l.C1942n;

/* JADX INFO: loaded from: classes3.dex */
@InterfaceC1680c
@TargetApi(19)
public class KitKatPurgeableDecoder extends DalvikPurgeableDecoder {

    /* JADX INFO: renamed from: c */
    public final C1942n f19576c;

    @InterfaceC1680c
    public KitKatPurgeableDecoder(C1942n c1942n) {
        this.f19576c = c1942n;
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    /* JADX INFO: renamed from: c */
    public Bitmap mo8710c(CloseableReference<PooledByteBuffer> closeableReference, BitmapFactory.Options options) {
        PooledByteBuffer pooledByteBufferM8642u = closeableReference.m8642u();
        int size = pooledByteBufferM8642u.size();
        CloseableReference<byte[]> closeableReferenceM1391a = this.f19576c.m1391a(size);
        try {
            byte[] bArrM8642u = closeableReferenceM1391a.m8642u();
            pooledByteBufferM8642u.mo1396i(0, bArrM8642u, 0, size);
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrM8642u, 0, size, options);
            C1460d.m591y(bitmapDecodeByteArray, "BitmapFactory returned null");
            closeableReferenceM1391a.close();
            return bitmapDecodeByteArray;
        } catch (Throwable th) {
            if (closeableReferenceM1391a != null) {
                closeableReferenceM1391a.close();
            }
            throw th;
        }
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    /* JADX INFO: renamed from: d */
    public Bitmap mo8711d(CloseableReference<PooledByteBuffer> closeableReference, int i, BitmapFactory.Options options) {
        byte[] bArr = DalvikPurgeableDecoder.m8709e(closeableReference, i) ? null : DalvikPurgeableDecoder.f19566a;
        PooledByteBuffer pooledByteBufferM8642u = closeableReference.m8642u();
        C1460d.m527i(Boolean.valueOf(i <= pooledByteBufferM8642u.size()));
        int i2 = i + 2;
        CloseableReference<byte[]> closeableReferenceM1391a = this.f19576c.m1391a(i2);
        try {
            byte[] bArrM8642u = closeableReferenceM1391a.m8642u();
            pooledByteBufferM8642u.mo1396i(0, bArrM8642u, 0, i);
            if (bArr != null) {
                bArrM8642u[i] = -1;
                bArrM8642u[i + 1] = ExifInterface.MARKER_EOI;
                i = i2;
            }
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrM8642u, 0, i, options);
            C1460d.m591y(bitmapDecodeByteArray, "BitmapFactory returned null");
            closeableReferenceM1391a.close();
            return bitmapDecodeByteArray;
        } catch (Throwable th) {
            if (closeableReferenceM1391a != null) {
                closeableReferenceM1391a.close();
            }
            throw th;
        }
    }
}
