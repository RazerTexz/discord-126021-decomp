package b.o.b.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap$CompressFormat;
import android.graphics.Bitmap$Config;
import android.opengl.EGL14;
import android.opengl.GLES20;
import b.o.b.c.d;
import b.o.b.c.e;
import d0.z.d.m;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Objects;

/* JADX INFO: compiled from: EglSurface.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public b.o.b.a.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f1967b;
    public int c;
    public int d;

    public a(b.o.b.a.a aVar, e eVar) {
        m.checkNotNullParameter(aVar, "eglCore");
        m.checkNotNullParameter(eVar, "eglSurface");
        m.checkNotNullParameter(aVar, "eglCore");
        m.checkNotNullParameter(eVar, "eglSurface");
        this.a = aVar;
        this.f1967b = eVar;
        this.c = -1;
        this.d = -1;
    }

    public final void a(OutputStream outputStream, Bitmap$CompressFormat bitmap$CompressFormat) {
        m.checkNotNullParameter(outputStream, "stream");
        m.checkNotNullParameter(bitmap$CompressFormat, "format");
        b.o.b.a.a aVar = this.a;
        e eVar = this.f1967b;
        Objects.requireNonNull(aVar);
        m.checkNotNullParameter(eVar, "eglSurface");
        if (!(m.areEqual(aVar.f1959b, new b.o.b.c.b(EGL14.eglGetCurrentContext())) && m.areEqual(eVar, new e(EGL14.eglGetCurrentSurface(d.h))))) {
            throw new RuntimeException("Expected EGL context/surface is not current");
        }
        int iA = this.c;
        if (iA < 0) {
            iA = this.a.a(this.f1967b, d.f);
        }
        int iA2 = this.d;
        if (iA2 < 0) {
            iA2 = this.a.a(this.f1967b, d.g);
        }
        int i = iA2;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(iA * i * 4);
        byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        GLES20.glReadPixels(0, 0, iA, i, 6408, 5121, byteBufferAllocateDirect);
        b.o.b.a.d.b("glReadPixels");
        byteBufferAllocateDirect.rewind();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iA, i, Bitmap$Config.ARGB_8888);
        bitmapCreateBitmap.copyPixelsFromBuffer(byteBufferAllocateDirect);
        bitmapCreateBitmap.compress(bitmap$CompressFormat, 90, outputStream);
        bitmapCreateBitmap.recycle();
    }
}
