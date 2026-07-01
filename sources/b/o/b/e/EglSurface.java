package b.o.b.e;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.GLES20;
import b.o.b.a.EglCore;
import b.o.b.a.Egloo;
import b.o.b.c.egl2;
import b.o.b.c.egl4;
import b.o.b.c.egl5;
import d0.z.d.Intrinsics3;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Objects;

/* JADX INFO: renamed from: b.o.b.e.a, reason: use source file name */
/* JADX INFO: compiled from: EglSurface.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class EglSurface {
    public EglCore a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public egl5 f1967b;
    public int c;
    public int d;

    public EglSurface(EglCore eglCore, egl5 egl5Var) {
        Intrinsics3.checkNotNullParameter(eglCore, "eglCore");
        Intrinsics3.checkNotNullParameter(egl5Var, "eglSurface");
        Intrinsics3.checkNotNullParameter(eglCore, "eglCore");
        Intrinsics3.checkNotNullParameter(egl5Var, "eglSurface");
        this.a = eglCore;
        this.f1967b = egl5Var;
        this.c = -1;
        this.d = -1;
    }

    public final void a(OutputStream outputStream, Bitmap.CompressFormat compressFormat) {
        Intrinsics3.checkNotNullParameter(outputStream, "stream");
        Intrinsics3.checkNotNullParameter(compressFormat, "format");
        EglCore eglCore = this.a;
        egl5 egl5Var = this.f1967b;
        Objects.requireNonNull(eglCore);
        Intrinsics3.checkNotNullParameter(egl5Var, "eglSurface");
        if (!(Intrinsics3.areEqual(eglCore.f1959b, new egl2(EGL14.eglGetCurrentContext())) && Intrinsics3.areEqual(egl5Var, new egl5(EGL14.eglGetCurrentSurface(egl4.h))))) {
            throw new RuntimeException("Expected EGL context/surface is not current");
        }
        int iA = this.c;
        if (iA < 0) {
            iA = this.a.a(this.f1967b, egl4.f);
        }
        int iA2 = this.d;
        if (iA2 < 0) {
            iA2 = this.a.a(this.f1967b, egl4.g);
        }
        int i = iA2;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(iA * i * 4);
        byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        GLES20.glReadPixels(0, 0, iA, i, 6408, 5121, byteBufferAllocateDirect);
        Egloo.b("glReadPixels");
        byteBufferAllocateDirect.rewind();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iA, i, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.copyPixelsFromBuffer(byteBufferAllocateDirect);
        bitmapCreateBitmap.compress(compressFormat, 90, outputStream);
        bitmapCreateBitmap.recycle();
    }
}
