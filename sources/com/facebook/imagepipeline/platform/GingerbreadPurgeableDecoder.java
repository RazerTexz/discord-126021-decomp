package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.MemoryFile;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p119d.C1678a;
import p007b.p109f.p115d.p119d.C1690m;
import p007b.p109f.p115d.p119d.InterfaceC1680c;
import p007b.p109f.p115d.p122g.C1701h;
import p007b.p109f.p115d.p125j.C1711a;
import p007b.p109f.p115d.p128m.C1720c;
import p007b.p109f.p115d.p128m.InterfaceC1719b;

/* JADX INFO: loaded from: classes3.dex */
@InterfaceC1680c
public class GingerbreadPurgeableDecoder extends DalvikPurgeableDecoder {

    /* JADX INFO: renamed from: c */
    public static Method f19574c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC1719b f19575d = C1720c.m1015c();

    @InterfaceC1680c
    public GingerbreadPurgeableDecoder() {
    }

    /* JADX INFO: renamed from: g */
    public static MemoryFile m8715g(CloseableReference<PooledByteBuffer> closeableReference, int i, byte[] bArr) throws Throwable {
        OutputStream outputStream;
        C1711a c1711a;
        C1701h c1701h = null;
        OutputStream outputStream2 = null;
        MemoryFile memoryFile = new MemoryFile(null, (bArr == null ? 0 : bArr.length) + i);
        memoryFile.allowPurging(false);
        try {
            C1701h c1701h2 = new C1701h(closeableReference.m8642u());
            try {
                c1711a = new C1711a(c1701h2, i);
                try {
                    outputStream2 = memoryFile.getOutputStream();
                    Objects.requireNonNull(outputStream2);
                    byte[] bArr2 = new byte[4096];
                    while (true) {
                        int i2 = c1711a.read(bArr2);
                        if (i2 == -1) {
                            break;
                        }
                        outputStream2.write(bArr2, 0, i2);
                    }
                    if (bArr != null) {
                        memoryFile.writeBytes(bArr, 0, i, bArr.length);
                    }
                    closeableReference.close();
                    C1678a.m966b(c1701h2);
                    C1678a.m966b(c1711a);
                    C1678a.m965a(outputStream2, true);
                    return memoryFile;
                } catch (Throwable th) {
                    th = th;
                    outputStream = outputStream2;
                    c1701h = c1701h2;
                    Class<CloseableReference> cls = CloseableReference.f19438j;
                    if (closeableReference != null) {
                        closeableReference.close();
                    }
                    C1678a.m966b(c1701h);
                    C1678a.m966b(c1711a);
                    C1678a.m965a(outputStream, true);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
                c1711a = null;
            }
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
            c1711a = null;
        }
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    /* JADX INFO: renamed from: c */
    public Bitmap mo8710c(CloseableReference<PooledByteBuffer> closeableReference, BitmapFactory.Options options) {
        return m8716h(closeableReference, closeableReference.m8642u().size(), null, options);
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    /* JADX INFO: renamed from: d */
    public Bitmap mo8711d(CloseableReference<PooledByteBuffer> closeableReference, int i, BitmapFactory.Options options) {
        return m8716h(closeableReference, i, DalvikPurgeableDecoder.m8709e(closeableReference, i) ? null : DalvikPurgeableDecoder.f19566a, options);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x003c  */
    /* JADX INFO: renamed from: h */
    public final Bitmap m8716h(CloseableReference<PooledByteBuffer> closeableReference, int i, byte[] bArr, BitmapFactory.Options options) throws Throwable {
        MemoryFile memoryFile = null;
        try {
            MemoryFile memoryFileM8715g = m8715g(closeableReference, i, bArr);
            try {
                FileDescriptor fileDescriptorM8718j = m8718j(memoryFileM8715g);
                InterfaceC1719b interfaceC1719b = this.f19575d;
                if (interfaceC1719b == null) {
                    throw new IllegalStateException("WebpBitmapFactory is null");
                }
                Bitmap bitmapMo1011a = interfaceC1719b.mo1011a(fileDescriptorM8718j, null, options);
                C1460d.m591y(bitmapMo1011a, "BitmapFactory returned null");
                Bitmap bitmap = bitmapMo1011a;
                memoryFileM8715g.close();
                return bitmap;
            } catch (IOException e) {
                e = e;
                memoryFile = memoryFileM8715g;
                try {
                    C1690m.m972a(e);
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
                memoryFile = memoryFileM8715g;
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

    /* JADX INFO: renamed from: i */
    public final synchronized Method m8717i() {
        if (f19574c == null) {
            try {
                f19574c = MemoryFile.class.getDeclaredMethod("getFileDescriptor", new Class[0]);
            } catch (Exception e) {
                C1690m.m972a(e);
                throw new RuntimeException(e);
            }
        }
        return f19574c;
    }

    /* JADX INFO: renamed from: j */
    public final FileDescriptor m8718j(MemoryFile memoryFile) throws Throwable {
        try {
            Object objInvoke = m8717i().invoke(memoryFile, new Object[0]);
            Objects.requireNonNull(objInvoke);
            return (FileDescriptor) objInvoke;
        } catch (Exception e) {
            C1690m.m972a(e);
            throw new RuntimeException(e);
        }
    }
}
