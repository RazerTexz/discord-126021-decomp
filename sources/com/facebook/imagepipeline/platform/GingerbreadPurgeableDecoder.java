package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.MemoryFile;
import b.c.a.a0.AnimatableValueParser;
import b.f.d.d.Closeables;
import b.f.d.d.DoNotStrip;
import b.f.d.d.Throwables;
import b.f.d.g.PooledByteBufferInputStream;
import b.f.d.j.LimitedInputStream;
import b.f.d.m.WebpBitmapFactory;
import b.f.d.m.WebpSupportStatus;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@DoNotStrip
public class GingerbreadPurgeableDecoder extends DalvikPurgeableDecoder {
    public static Method c;
    public final WebpBitmapFactory d = WebpSupportStatus.c();

    @DoNotStrip
    public GingerbreadPurgeableDecoder() {
    }

    public static MemoryFile g(CloseableReference<PooledByteBuffer> closeableReference, int i, byte[] bArr) throws Throwable {
        OutputStream outputStream;
        LimitedInputStream limitedInputStream;
        PooledByteBufferInputStream pooledByteBufferInputStream = null;
        OutputStream outputStream2 = null;
        MemoryFile memoryFile = new MemoryFile(null, (bArr == null ? 0 : bArr.length) + i);
        memoryFile.allowPurging(false);
        try {
            PooledByteBufferInputStream pooledByteBufferInputStream2 = new PooledByteBufferInputStream(closeableReference.u());
            try {
                limitedInputStream = new LimitedInputStream(pooledByteBufferInputStream2, i);
                try {
                    outputStream2 = memoryFile.getOutputStream();
                    Objects.requireNonNull(outputStream2);
                    byte[] bArr2 = new byte[4096];
                    while (true) {
                        int i2 = limitedInputStream.read(bArr2);
                        if (i2 == -1) {
                            break;
                        }
                        outputStream2.write(bArr2, 0, i2);
                    }
                    if (bArr != null) {
                        memoryFile.writeBytes(bArr, 0, i, bArr.length);
                    }
                    closeableReference.close();
                    Closeables.b(pooledByteBufferInputStream2);
                    Closeables.b(limitedInputStream);
                    Closeables.a(outputStream2, true);
                    return memoryFile;
                } catch (Throwable th) {
                    th = th;
                    outputStream = outputStream2;
                    pooledByteBufferInputStream = pooledByteBufferInputStream2;
                    Class<CloseableReference> cls = CloseableReference.j;
                    if (closeableReference != null) {
                        closeableReference.close();
                    }
                    Closeables.b(pooledByteBufferInputStream);
                    Closeables.b(limitedInputStream);
                    Closeables.a(outputStream, true);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
                limitedInputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
            limitedInputStream = null;
        }
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    public Bitmap c(CloseableReference<PooledByteBuffer> closeableReference, BitmapFactory.Options options) {
        return h(closeableReference, closeableReference.u().size(), null, options);
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    public Bitmap d(CloseableReference<PooledByteBuffer> closeableReference, int i, BitmapFactory.Options options) {
        return h(closeableReference, i, DalvikPurgeableDecoder.e(closeableReference, i) ? null : DalvikPurgeableDecoder.a, options);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x003c  */
    public final Bitmap h(CloseableReference<PooledByteBuffer> closeableReference, int i, byte[] bArr, BitmapFactory.Options options) throws Throwable {
        MemoryFile memoryFile = null;
        try {
            MemoryFile memoryFileG = g(closeableReference, i, bArr);
            try {
                FileDescriptor fileDescriptorJ = j(memoryFileG);
                WebpBitmapFactory webpBitmapFactory = this.d;
                if (webpBitmapFactory == null) {
                    throw new IllegalStateException("WebpBitmapFactory is null");
                }
                Bitmap bitmapA = webpBitmapFactory.a(fileDescriptorJ, null, options);
                AnimatableValueParser.y(bitmapA, "BitmapFactory returned null");
                Bitmap bitmap = bitmapA;
                memoryFileG.close();
                return bitmap;
            } catch (IOException e) {
                e = e;
                memoryFile = memoryFileG;
                try {
                    Throwables.a(e);
                    throw new RuntimeException(e);
                } catch (Throwable th) {
                    th = th;
                    if (memoryFile != null) {
                        memoryFile.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                memoryFile = memoryFileG;
                if (memoryFile != null) {
                    memoryFile.close();
                }
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final synchronized Method i() {
        if (c == null) {
            try {
                c = MemoryFile.class.getDeclaredMethod("getFileDescriptor", new Class[0]);
            } catch (Exception e) {
                Throwables.a(e);
                throw new RuntimeException(e);
            }
        }
        return c;
    }

    public final FileDescriptor j(MemoryFile memoryFile) throws Throwable {
        try {
            Object objInvoke = i().invoke(memoryFile, new Object[0]);
            Objects.requireNonNull(objInvoke);
            return (FileDescriptor) objInvoke;
        } catch (Exception e) {
            Throwables.a(e);
            throw new RuntimeException(e);
        }
    }
}
