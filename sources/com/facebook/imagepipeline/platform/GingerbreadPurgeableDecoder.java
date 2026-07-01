package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory$Options;
import android.os.MemoryFile;
import b.c.a.a0.d;
import b.f.d.d.c;
import b.f.d.d.m;
import b.f.d.g.h;
import b.f.d.j.a;
import b.f.d.m.b;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@c
public class GingerbreadPurgeableDecoder extends DalvikPurgeableDecoder {
    public static Method c;
    public final b d = b.f.d.m.c.c();

    @c
    public GingerbreadPurgeableDecoder() {
    }

    public static MemoryFile g(CloseableReference<PooledByteBuffer> closeableReference, int i, byte[] bArr) throws Throwable {
        OutputStream outputStream;
        a aVar;
        h hVar = null;
        OutputStream outputStream2 = null;
        MemoryFile memoryFile = new MemoryFile(null, (bArr == null ? 0 : bArr.length) + i);
        memoryFile.allowPurging(false);
        try {
            h hVar2 = new h(closeableReference.u());
            try {
                aVar = new a(hVar2, i);
                try {
                    outputStream2 = memoryFile.getOutputStream();
                    Objects.requireNonNull(outputStream2);
                    byte[] bArr2 = new byte[4096];
                    while (true) {
                        int i2 = aVar.read(bArr2);
                        if (i2 == -1) {
                            break;
                        }
                        outputStream2.write(bArr2, 0, i2);
                    }
                    if (bArr != null) {
                        memoryFile.writeBytes(bArr, 0, i, bArr.length);
                    }
                    closeableReference.close();
                    b.f.d.d.a.b(hVar2);
                    b.f.d.d.a.b(aVar);
                    b.f.d.d.a.a(outputStream2, true);
                    return memoryFile;
                } catch (Throwable th) {
                    th = th;
                    outputStream = outputStream2;
                    hVar = hVar2;
                    Class<CloseableReference> cls = CloseableReference.j;
                    if (closeableReference != null) {
                        closeableReference.close();
                    }
                    b.f.d.d.a.b(hVar);
                    b.f.d.d.a.b(aVar);
                    b.f.d.d.a.a(outputStream, true);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
                aVar = null;
            }
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
            aVar = null;
        }
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    public Bitmap c(CloseableReference<PooledByteBuffer> closeableReference, BitmapFactory$Options bitmapFactory$Options) {
        return h(closeableReference, closeableReference.u().size(), null, bitmapFactory$Options);
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    public Bitmap d(CloseableReference<PooledByteBuffer> closeableReference, int i, BitmapFactory$Options bitmapFactory$Options) {
        return h(closeableReference, i, DalvikPurgeableDecoder.e(closeableReference, i) ? null : DalvikPurgeableDecoder.a, bitmapFactory$Options);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x003c  */
    public final Bitmap h(CloseableReference<PooledByteBuffer> closeableReference, int i, byte[] bArr, BitmapFactory$Options bitmapFactory$Options) throws Throwable {
        MemoryFile memoryFile = null;
        try {
            MemoryFile memoryFileG = g(closeableReference, i, bArr);
            try {
                FileDescriptor fileDescriptorJ = j(memoryFileG);
                b bVar = this.d;
                if (bVar == null) {
                    throw new IllegalStateException("WebpBitmapFactory is null");
                }
                Bitmap bitmapA = bVar.a(fileDescriptorJ, null, bitmapFactory$Options);
                d.y(bitmapA, "BitmapFactory returned null");
                Bitmap bitmap = bitmapA;
                memoryFileG.close();
                return bitmap;
            } catch (IOException e) {
                e = e;
                memoryFile = memoryFileG;
                try {
                    m.a(e);
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
                m.a(e);
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
            m.a(e);
            throw new RuntimeException(e);
        }
    }
}
