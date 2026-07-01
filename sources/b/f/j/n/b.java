package b.f.j.n;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory$Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.ColorSpace;
import android.graphics.ColorSpace$Named;
import android.graphics.Rect;
import android.os.Build$VERSION;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools$SynchronizedPool;
import androidx.exifinterface.media.ExifInterface;
import b.f.j.j.e;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.platform.PreverificationHelper;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: compiled from: DefaultDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
@TargetApi(11)
public abstract class b implements d {
    public static final byte[] a = {-1, ExifInterface.MARKER_EOI};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.f.j.l.d f603b;
    public final PreverificationHelper c;

    @VisibleForTesting
    public final Pools$SynchronizedPool<ByteBuffer> d;

    public b(b.f.j.l.d dVar, int i, Pools$SynchronizedPool pools$SynchronizedPool) {
        this.c = Build$VERSION.SDK_INT >= 26 ? new PreverificationHelper() : null;
        this.f603b = dVar;
        this.d = pools$SynchronizedPool;
        for (int i2 = 0; i2 < i; i2++) {
            this.d.release(ByteBuffer.allocate(16384));
        }
    }

    public static BitmapFactory$Options e(e eVar, Bitmap$Config bitmap$Config) {
        BitmapFactory$Options bitmapFactory$Options = new BitmapFactory$Options();
        bitmapFactory$Options.inSampleSize = eVar.q;
        bitmapFactory$Options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(eVar.e(), null, bitmapFactory$Options);
        if (bitmapFactory$Options.outWidth == -1 || bitmapFactory$Options.outHeight == -1) {
            throw new IllegalArgumentException();
        }
        bitmapFactory$Options.inJustDecodeBounds = false;
        bitmapFactory$Options.inDither = true;
        bitmapFactory$Options.inPreferredConfig = bitmap$Config;
        bitmapFactory$Options.inMutable = true;
        return bitmapFactory$Options;
    }

    @Override // b.f.j.n.d
    public CloseableReference<Bitmap> a(e eVar, Bitmap$Config bitmap$Config, Rect rect, ColorSpace colorSpace) {
        BitmapFactory$Options bitmapFactory$OptionsE = e(eVar, bitmap$Config);
        boolean z2 = bitmapFactory$OptionsE.inPreferredConfig != Bitmap$Config.ARGB_8888;
        try {
            InputStream inputStreamE = eVar.e();
            Objects.requireNonNull(inputStreamE);
            return c(inputStreamE, bitmapFactory$OptionsE, rect, colorSpace);
        } catch (RuntimeException e) {
            if (z2) {
                return a(eVar, Bitmap$Config.ARGB_8888, rect, colorSpace);
            }
            throw e;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0032  */
    @Override // b.f.j.n.d
    public CloseableReference<Bitmap> b(e eVar, Bitmap$Config bitmap$Config, Rect rect, int i, ColorSpace colorSpace) {
        boolean z2;
        b.f.i.c cVar = eVar.l;
        if ((cVar == b.f.i.b.a || cVar == b.f.i.b.l) && eVar.k == null) {
            Objects.requireNonNull(eVar.j);
            PooledByteBuffer pooledByteBufferU = eVar.j.u();
            if (pooledByteBufferU.h(i - 2) == -1 && pooledByteBufferU.h(i - 1) == -39) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = true;
        }
        BitmapFactory$Options bitmapFactory$OptionsE = e(eVar, bitmap$Config);
        InputStream inputStreamE = eVar.e();
        Objects.requireNonNull(inputStreamE);
        if (eVar.n() > i) {
            inputStreamE = new b.f.d.j.a(inputStreamE, i);
        }
        if (!z2) {
            inputStreamE = new b.f.d.j.b(inputStreamE, a);
        }
        boolean z3 = bitmapFactory$OptionsE.inPreferredConfig != Bitmap$Config.ARGB_8888;
        try {
            try {
                CloseableReference<Bitmap> closeableReferenceC = c(inputStreamE, bitmapFactory$OptionsE, rect, colorSpace);
                try {
                    inputStreamE.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return closeableReferenceC;
            } catch (Throwable th) {
                try {
                    inputStreamE.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                throw th;
            }
        } catch (RuntimeException e3) {
            if (!z3) {
                throw e3;
            }
            CloseableReference<Bitmap> closeableReferenceB = b(eVar, Bitmap$Config.ARGB_8888, rect, i, colorSpace);
            try {
                inputStreamE.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            return closeableReferenceB;
        }
    }

    /* JADX WARN: Code duplicated, block: B:45:0x009e A[Catch: all -> 0x00c8, RuntimeException -> 0x00ca, IllegalArgumentException -> 0x00d3, TryCatch #8 {IllegalArgumentException -> 0x00d3, RuntimeException -> 0x00ca, blocks: (B:29:0x006b, B:34:0x0082, B:49:0x00a5, B:41:0x0096, B:45:0x009e, B:46:0x00a1), top: B:80:0x006b, outer: #5 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00a5 A[Catch: all -> 0x00c8, RuntimeException -> 0x00ca, IllegalArgumentException -> 0x00d3, TRY_LEAVE, TryCatch #8 {IllegalArgumentException -> 0x00d3, RuntimeException -> 0x00ca, blocks: (B:29:0x006b, B:34:0x0082, B:49:0x00a5, B:41:0x0096, B:45:0x009e, B:46:0x00a1), top: B:80:0x006b, outer: #5 }] */
    public final CloseableReference<Bitmap> c(InputStream inputStream, BitmapFactory$Options bitmapFactory$Options, Rect rect, ColorSpace colorSpace) {
        Bitmap bitmap;
        Bitmap bitmapDecodeStream;
        BitmapRegionDecoder bitmapRegionDecoderNewInstance;
        PreverificationHelper preverificationHelper;
        int iWidth = bitmapFactory$Options.outWidth;
        int iHeight = bitmapFactory$Options.outHeight;
        if (rect != null) {
            iWidth = rect.width() / bitmapFactory$Options.inSampleSize;
            iHeight = rect.height() / bitmapFactory$Options.inSampleSize;
        }
        int i = Build$VERSION.SDK_INT;
        boolean z2 = i >= 26 && (preverificationHelper = this.c) != null && preverificationHelper.shouldUseHardwareBitmapConfig(bitmapFactory$Options.inPreferredConfig);
        BitmapRegionDecoder bitmapRegionDecoder = null;
        if (rect == null && z2) {
            bitmapFactory$Options.inMutable = false;
            bitmap = null;
        } else {
            if (rect != null && z2) {
                bitmapFactory$Options.inPreferredConfig = Bitmap$Config.ARGB_8888;
            }
            bitmap = this.f603b.get(d(iWidth, iHeight, bitmapFactory$Options));
            Objects.requireNonNull(bitmap, "BitmapPool.get returned null");
        }
        bitmapFactory$Options.inBitmap = bitmap;
        if (i >= 26) {
            if (colorSpace == null) {
                colorSpace = ColorSpace.get(ColorSpace$Named.SRGB);
            }
            bitmapFactory$Options.inPreferredColorSpace = colorSpace;
        }
        ByteBuffer byteBufferAcquire = this.d.acquire();
        if (byteBufferAcquire == null) {
            byteBufferAcquire = ByteBuffer.allocate(16384);
        }
        try {
            try {
                bitmapFactory$Options.inTempStorage = byteBufferAcquire.array();
                if (rect == null || bitmap == null) {
                    bitmapDecodeStream = null;
                } else {
                    try {
                        bitmap.reconfigure(iWidth, iHeight, bitmapFactory$Options.inPreferredConfig);
                        bitmapRegionDecoderNewInstance = BitmapRegionDecoder.newInstance(inputStream, true);
                        try {
                            try {
                                bitmapDecodeStream = bitmapRegionDecoderNewInstance.decodeRegion(rect, bitmapFactory$Options);
                                bitmapRegionDecoderNewInstance.recycle();
                            } catch (IOException unused) {
                                b.f.d.e.a.c(b.class, "Could not decode region %s, decoding full bitmap instead.", rect);
                                if (bitmapRegionDecoderNewInstance != null) {
                                    bitmapRegionDecoderNewInstance.recycle();
                                }
                                bitmapDecodeStream = null;
                                if (bitmapDecodeStream == null) {
                                    bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, null, bitmapFactory$Options);
                                }
                                this.d.release(byteBufferAcquire);
                                if (bitmap != null) {
                                }
                                return CloseableReference.D(bitmapDecodeStream, this.f603b);
                            }
                        } catch (Throwable th) {
                            th = th;
                            bitmapRegionDecoder = bitmapRegionDecoderNewInstance;
                            if (bitmapRegionDecoder != null) {
                                bitmapRegionDecoder.recycle();
                            }
                            throw th;
                        }
                    } catch (IOException unused2) {
                        bitmapRegionDecoderNewInstance = null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bitmapRegionDecoder != null) {
                            bitmapRegionDecoder.recycle();
                        }
                        throw th;
                    }
                }
                if (bitmapDecodeStream == null) {
                    bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, null, bitmapFactory$Options);
                }
                this.d.release(byteBufferAcquire);
                if (bitmap != null || bitmap == bitmapDecodeStream) {
                    return CloseableReference.D(bitmapDecodeStream, this.f603b);
                }
                this.f603b.release(bitmap);
                bitmapDecodeStream.recycle();
                throw new IllegalStateException();
            } catch (Throwable th3) {
                this.d.release(byteBufferAcquire);
                throw th3;
            }
        } catch (IllegalArgumentException e) {
            if (bitmap != null) {
                this.f603b.release(bitmap);
            }
            try {
                inputStream.reset();
                Bitmap bitmapDecodeStream2 = BitmapFactory.decodeStream(inputStream);
                if (bitmapDecodeStream2 == null) {
                    throw e;
                }
                CloseableReference<Bitmap> closeableReferenceD = CloseableReference.D(bitmapDecodeStream2, b.f.j.b.b.a());
                this.d.release(byteBufferAcquire);
                return closeableReferenceD;
            } catch (IOException unused3) {
                throw e;
            }
        } catch (RuntimeException e2) {
            if (bitmap != null) {
                this.f603b.release(bitmap);
            }
            throw e2;
        }
    }

    public abstract int d(int i, int i2, BitmapFactory$Options bitmapFactory$Options);
}
