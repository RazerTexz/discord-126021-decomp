package p007b.p452o.p475b.p480e;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.GLES20;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Objects;
import p007b.p452o.p475b.p476a.C5249a;
import p007b.p452o.p475b.p476a.C5252d;
import p007b.p452o.p475b.p478c.C5257b;
import p007b.p452o.p475b.p478c.C5259d;
import p007b.p452o.p475b.p478c.C5260e;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.o.b.e.a */
/* JADX INFO: compiled from: EglSurface.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC5266a {

    /* JADX INFO: renamed from: a */
    public C5249a f14327a;

    /* JADX INFO: renamed from: b */
    public C5260e f14328b;

    /* JADX INFO: renamed from: c */
    public int f14329c;

    /* JADX INFO: renamed from: d */
    public int f14330d;

    public AbstractC5266a(C5249a c5249a, C5260e c5260e) {
        C12238m.checkNotNullParameter(c5249a, "eglCore");
        C12238m.checkNotNullParameter(c5260e, "eglSurface");
        C12238m.checkNotNullParameter(c5249a, "eglCore");
        C12238m.checkNotNullParameter(c5260e, "eglSurface");
        this.f14327a = c5249a;
        this.f14328b = c5260e;
        this.f14329c = -1;
        this.f14330d = -1;
    }

    /* JADX INFO: renamed from: a */
    public final void m7460a(OutputStream outputStream, Bitmap.CompressFormat compressFormat) {
        C12238m.checkNotNullParameter(outputStream, "stream");
        C12238m.checkNotNullParameter(compressFormat, "format");
        C5249a c5249a = this.f14327a;
        C5260e c5260e = this.f14328b;
        Objects.requireNonNull(c5249a);
        C12238m.checkNotNullParameter(c5260e, "eglSurface");
        if (!(C12238m.areEqual(c5249a.f14261b, new C5257b(EGL14.eglGetCurrentContext())) && C12238m.areEqual(c5260e, new C5260e(EGL14.eglGetCurrentSurface(C5259d.f14278h))))) {
            throw new RuntimeException("Expected EGL context/surface is not current");
        }
        int iM7455a = this.f14329c;
        if (iM7455a < 0) {
            iM7455a = this.f14327a.m7455a(this.f14328b, C5259d.f14276f);
        }
        int iM7455a2 = this.f14330d;
        if (iM7455a2 < 0) {
            iM7455a2 = this.f14327a.m7455a(this.f14328b, C5259d.f14277g);
        }
        int i = iM7455a2;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(iM7455a * i * 4);
        byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        GLES20.glReadPixels(0, 0, iM7455a, i, 6408, 5121, byteBufferAllocateDirect);
        C5252d.m7457b("glReadPixels");
        byteBufferAllocateDirect.rewind();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iM7455a, i, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.copyPixelsFromBuffer(byteBufferAllocateDirect);
        bitmapCreateBitmap.compress(compressFormat, 90, outputStream);
        bitmapCreateBitmap.recycle();
    }
}
