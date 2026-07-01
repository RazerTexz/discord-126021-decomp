package b.o.a.v;

import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import androidx.annotation.NonNull;
import b.o.a.PictureResult;
import b.o.a.n.Camera1Engine2;
import b.o.a.n.t.Reference2;
import b.o.a.p.ByteBufferFrameManager;
import b.o.a.r.WorkerHandler;
import b.o.a.x.AspectRatio2;
import b.o.a.x.Size3;
import java.io.ByteArrayOutputStream;

/* JADX INFO: renamed from: b.o.a.v.e, reason: use source file name */
/* JADX INFO: compiled from: Snapshot1PictureRecorder.java */
/* JADX INFO: loaded from: classes3.dex */
public class Snapshot1PictureRecorder extends SnapshotPictureRecorder {
    public Camera1Engine2 n;
    public Camera o;
    public AspectRatio2 p;
    public int q;

    /* JADX INFO: renamed from: b.o.a.v.e$a */
    /* JADX INFO: compiled from: Snapshot1PictureRecorder.java */
    public class a implements Camera.PreviewCallback {

        /* JADX INFO: renamed from: b.o.a.v.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Snapshot1PictureRecorder.java */
        public class RunnableC0062a implements Runnable {
            public final /* synthetic */ byte[] j;
            public final /* synthetic */ Size3 k;
            public final /* synthetic */ int l;
            public final /* synthetic */ Size3 m;

            public RunnableC0062a(byte[] bArr, Size3 size3, int i, Size3 size4) {
                this.j = bArr;
                this.k = size3;
                this.l = i;
                this.m = size4;
            }

            @Override // java.lang.Runnable
            public void run() {
                byte[] bArr;
                byte[] bArr2 = this.j;
                Size3 size3 = this.k;
                int i = this.l;
                if (i == 0) {
                    bArr = bArr2;
                } else {
                    if (i % 90 != 0 || i < 0 || i > 270) {
                        throw new IllegalArgumentException("0 <= rotation < 360, rotation % 90 == 0");
                    }
                    int i2 = size3.j;
                    int i3 = size3.k;
                    byte[] bArr3 = new byte[bArr2.length];
                    int i4 = i2 * i3;
                    boolean z2 = i % 180 != 0;
                    boolean z3 = i % 270 != 0;
                    boolean z4 = i >= 180;
                    for (int i5 = 0; i5 < i3; i5++) {
                        for (int i6 = 0; i6 < i2; i6++) {
                            int i7 = (i5 * i2) + i6;
                            int i8 = ((i5 >> 1) * i2) + i4 + (i6 & (-2));
                            int i9 = i8 + 1;
                            int i10 = z2 ? i3 : i2;
                            int i11 = z2 ? i2 : i3;
                            int i12 = z2 ? i5 : i6;
                            int i13 = z2 ? i6 : i5;
                            if (z3) {
                                i12 = (i10 - i12) - 1;
                            }
                            if (z4) {
                                i13 = (i11 - i13) - 1;
                            }
                            int i14 = (i13 * i10) + i12;
                            int i15 = ((i13 >> 1) * i10) + i4 + (i12 & (-2));
                            bArr3[i14] = (byte) (bArr2[i7] & 255);
                            bArr3[i15] = (byte) (bArr2[i8] & 255);
                            bArr3[i15 + 1] = (byte) (bArr2[i9] & 255);
                        }
                    }
                    bArr = bArr3;
                }
                int i16 = Snapshot1PictureRecorder.this.q;
                Size3 size4 = this.m;
                YuvImage yuvImage = new YuvImage(bArr, i16, size4.j, size4.k, null);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Rect rectL = b.i.a.f.e.o.f.L(this.m, Snapshot1PictureRecorder.this.p);
                yuvImage.compressToJpeg(rectL, 90, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                PictureResult.a aVar = Snapshot1PictureRecorder.this.j;
                aVar.f = byteArray;
                aVar.d = new Size3(rectL.width(), rectL.height());
                Snapshot1PictureRecorder snapshot1PictureRecorder = Snapshot1PictureRecorder.this;
                snapshot1PictureRecorder.j.c = 0;
                snapshot1PictureRecorder.b();
            }
        }

        public a() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(@NonNull byte[] bArr, Camera camera) {
            Snapshot1PictureRecorder.this.a(false);
            Snapshot1PictureRecorder snapshot1PictureRecorder = Snapshot1PictureRecorder.this;
            PictureResult.a aVar = snapshot1PictureRecorder.j;
            int i = aVar.c;
            Size3 size3 = aVar.d;
            Size3 size3C = snapshot1PictureRecorder.n.C(Reference2.SENSOR);
            if (size3C == null) {
                throw new IllegalStateException("Preview stream size should never be null here.");
            }
            WorkerHandler.a(new RunnableC0062a(bArr, size3C, i, size3));
            camera.setPreviewCallbackWithBuffer(null);
            camera.setPreviewCallbackWithBuffer(Snapshot1PictureRecorder.this.n);
            ByteBufferFrameManager byteBufferFrameManagerL1 = Snapshot1PictureRecorder.this.n.l1();
            Snapshot1PictureRecorder snapshot1PictureRecorder2 = Snapshot1PictureRecorder.this;
            byteBufferFrameManagerL1.e(snapshot1PictureRecorder2.q, size3C, snapshot1PictureRecorder2.n.L);
        }
    }

    public Snapshot1PictureRecorder(@NonNull PictureResult.a aVar, @NonNull Camera1Engine2 camera1Engine2, @NonNull Camera camera, @NonNull AspectRatio2 aspectRatio2) {
        super(aVar, camera1Engine2);
        this.n = camera1Engine2;
        this.o = camera;
        this.p = aspectRatio2;
        this.q = camera.getParameters().getPreviewFormat();
    }

    @Override // b.o.a.v.PictureRecorder
    public void b() {
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = 0;
        super.b();
    }

    @Override // b.o.a.v.PictureRecorder
    public void c() {
        this.o.setOneShotPreviewCallback(new a());
    }
}
