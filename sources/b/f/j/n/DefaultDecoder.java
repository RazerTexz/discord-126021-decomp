package b.f.j.n;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import androidx.exifinterface.media.ExifInterface;
import b.f.d.e.FLog;
import b.f.d.j.LimitedInputStream;
import b.f.d.j.TailAppendingInputStream;
import b.f.i.DefaultImageFormats;
import b.f.i.ImageFormat;
import b.f.j.b.SimpleBitmapReleaser;
import b.f.j.j.EncodedImage2;
import b.f.j.l.BitmapPool;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.platform.PreverificationHelper;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.j.n.b, reason: use source file name */
/* JADX INFO: compiled from: DefaultDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
@TargetApi(11)
public abstract class DefaultDecoder implements PlatformDecoder {
    public static final byte[] a = {-1, ExifInterface.MARKER_EOI};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BitmapPool f603b;
    public final PreverificationHelper c;

    @VisibleForTesting
    public final Pools.SynchronizedPool<ByteBuffer> d;

    public DefaultDecoder(BitmapPool bitmapPool, int i, Pools.SynchronizedPool synchronizedPool) {
        this.c = Build.VERSION.SDK_INT >= 26 ? new PreverificationHelper() : null;
        this.f603b = bitmapPool;
        this.d = synchronizedPool;
        for (int i2 = 0; i2 < i; i2++) {
            this.d.release(ByteBuffer.allocate(16384));
        }
    }

    public static BitmapFactory.Options e(EncodedImage2 encodedImage2, Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = encodedImage2.q;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(encodedImage2.e(), null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            throw new IllegalArgumentException();
        }
        options.inJustDecodeBounds = false;
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inMutable = true;
        return options;
    }

    @Override // b.f.j.n.PlatformDecoder
    public CloseableReference<Bitmap> a(EncodedImage2 encodedImage2, Bitmap.Config config, Rect rect, ColorSpace colorSpace) {
        BitmapFactory.Options optionsE = e(encodedImage2, config);
        boolean z2 = optionsE.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            InputStream inputStreamE = encodedImage2.e();
            Objects.requireNonNull(inputStreamE);
            return c(inputStreamE, optionsE, rect, colorSpace);
        } catch (RuntimeException e) {
            if (z2) {
                return a(encodedImage2, Bitmap.Config.ARGB_8888, rect, colorSpace);
            }
            throw e;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0032  */
    @Override // b.f.j.n.PlatformDecoder
    public CloseableReference<Bitmap> b(EncodedImage2 encodedImage2, Bitmap.Config config, Rect rect, int i, ColorSpace colorSpace) {
        boolean z2;
        ImageFormat imageFormat = encodedImage2.l;
        if ((imageFormat == DefaultImageFormats.a || imageFormat == DefaultImageFormats.l) && encodedImage2.k == null) {
            Objects.requireNonNull(encodedImage2.j);
            PooledByteBuffer pooledByteBufferU = encodedImage2.j.u();
            if (pooledByteBufferU.h(i - 2) == -1 && pooledByteBufferU.h(i - 1) == -39) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = true;
        }
        BitmapFactory.Options optionsE = e(encodedImage2, config);
        InputStream inputStreamE = encodedImage2.e();
        Objects.requireNonNull(inputStreamE);
        if (encodedImage2.n() > i) {
            inputStreamE = new LimitedInputStream(inputStreamE, i);
        }
        if (!z2) {
            inputStreamE = new TailAppendingInputStream(inputStreamE, a);
        }
        boolean z3 = optionsE.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            try {
                CloseableReference<Bitmap> closeableReferenceC = c(inputStreamE, optionsE, rect, colorSpace);
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
            CloseableReference<Bitmap> closeableReferenceB = b(encodedImage2, Bitmap.Config.ARGB_8888, rect, i, colorSpace);
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
    public final CloseableReference<Bitmap> c(InputStream inputStream, BitmapFactory.Options options, Rect rect, ColorSpace colorSpace) {
        Bitmap bitmap;
        Bitmap bitmapDecodeStream;
        BitmapRegionDecoder bitmapRegionDecoderNewInstance;
        PreverificationHelper preverificationHelper;
        int iWidth = options.outWidth;
        int iHeight = options.outHeight;
        if (rect != null) {
            iWidth = rect.width() / options.inSampleSize;
            iHeight = rect.height() / options.inSampleSize;
        }
        int i = Build.VERSION.SDK_INT;
        boolean z2 = i >= 26 && (preverificationHelper = this.c) != null && preverificationHelper.shouldUseHardwareBitmapConfig(options.inPreferredConfig);
        BitmapRegionDecoder bitmapRegionDecoder = null;
        if (rect == null && z2) {
            options.inMutable = false;
            bitmap = null;
        } else {
            if (rect != null && z2) {
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            }
            bitmap = this.f603b.get(d(iWidth, iHeight, options));
            Objects.requireNonNull(bitmap, "BitmapPool.get returned null");
        }
        options.inBitmap = bitmap;
        if (i >= 26) {
            if (colorSpace == null) {
                colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            }
            options.inPreferredColorSpace = colorSpace;
        }
        ByteBuffer byteBufferAcquire = this.d.acquire();
        if (byteBufferAcquire == null) {
            byteBufferAcquire = ByteBuffer.allocate(16384);
        }
        try {
            try {
                options.inTempStorage = byteBufferAcquire.array();
                if (rect == null || bitmap == null) {
                    bitmapDecodeStream = null;
                } else {
                    try {
                        bitmap.reconfigure(iWidth, iHeight, options.inPreferredConfig);
                        bitmapRegionDecoderNewInstance = BitmapRegionDecoder.newInstance(inputStream, true);
                        try {
                            try {
                                bitmapDecodeStream = bitmapRegionDecoderNewInstance.decodeRegion(rect, options);
                                bitmapRegionDecoderNewInstance.recycle();
                            } catch (IOException unused) {
                                FLog.c(DefaultDecoder.class, "Could not decode region %s, decoding full bitmap instead.", rect);
                                if (bitmapRegionDecoderNewInstance != null) {
                                    bitmapRegionDecoderNewInstance.recycle();
                                }
                                bitmapDecodeStream = null;
                                if (bitmapDecodeStream == null) {
                                    bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, null, options);
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
                    bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, null, options);
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
                CloseableReference<Bitmap> closeableReferenceD = CloseableReference.D(bitmapDecodeStream2, SimpleBitmapReleaser.a());
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

    public abstract int d(int i, int i2, BitmapFactory.Options options);
}
