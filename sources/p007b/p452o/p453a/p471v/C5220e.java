package p007b.p452o.p453a.p471v;

import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import androidx.annotation.NonNull;
import java.io.ByteArrayOutputStream;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p452o.p453a.C5113l;
import p007b.p452o.p453a.p455n.C5128b;
import p007b.p452o.p453a.p455n.p461t.EnumC5171b;
import p007b.p452o.p453a.p465p.C5188a;
import p007b.p452o.p453a.p467r.C5206g;
import p007b.p452o.p453a.p473x.C5235a;
import p007b.p452o.p453a.p473x.C5236b;

/* JADX INFO: renamed from: b.o.a.v.e */
/* JADX INFO: compiled from: Snapshot1PictureRecorder.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5220e extends AbstractC5224i {

    /* JADX INFO: renamed from: n */
    public C5128b f14175n;

    /* JADX INFO: renamed from: o */
    public Camera f14176o;

    /* JADX INFO: renamed from: p */
    public C5235a f14177p;

    /* JADX INFO: renamed from: q */
    public int f14178q;

    /* JADX INFO: renamed from: b.o.a.v.e$a */
    /* JADX INFO: compiled from: Snapshot1PictureRecorder.java */
    public class a implements Camera.PreviewCallback {

        /* JADX INFO: renamed from: b.o.a.v.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Snapshot1PictureRecorder.java */
        public class RunnableC13245a implements Runnable {

            /* JADX INFO: renamed from: j */
            public final /* synthetic */ byte[] f14180j;

            /* JADX INFO: renamed from: k */
            public final /* synthetic */ C5236b f14181k;

            /* JADX INFO: renamed from: l */
            public final /* synthetic */ int f14182l;

            /* JADX INFO: renamed from: m */
            public final /* synthetic */ C5236b f14183m;

            public RunnableC13245a(byte[] bArr, C5236b c5236b, int i, C5236b c5236b2) {
                this.f14180j = bArr;
                this.f14181k = c5236b;
                this.f14182l = i;
                this.f14183m = c5236b2;
            }

            @Override // java.lang.Runnable
            public void run() {
                byte[] bArr;
                byte[] bArr2 = this.f14180j;
                C5236b c5236b = this.f14181k;
                int i = this.f14182l;
                if (i == 0) {
                    bArr = bArr2;
                } else {
                    if (i % 90 != 0 || i < 0 || i > 270) {
                        throw new IllegalArgumentException("0 <= rotation < 360, rotation % 90 == 0");
                    }
                    int i2 = c5236b.f14251j;
                    int i3 = c5236b.f14252k;
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
                int i16 = C5220e.this.f14178q;
                C5236b c5236b2 = this.f14183m;
                YuvImage yuvImage = new YuvImage(bArr, i16, c5236b2.f14251j, c5236b2.f14252k, null);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Rect rectM4222L = C3404f.m4222L(this.f14183m, C5220e.this.f14177p);
                yuvImage.compressToJpeg(rectM4222L, 90, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                C5113l.a aVar = C5220e.this.f14172j;
                aVar.f13720f = byteArray;
                aVar.f13718d = new C5236b(rectM4222L.width(), rectM4222L.height());
                C5220e c5220e = C5220e.this;
                c5220e.f14172j.f13717c = 0;
                c5220e.mo7416b();
            }
        }

        public a() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(@NonNull byte[] bArr, Camera camera) {
            C5220e.this.m7420a(false);
            C5220e c5220e = C5220e.this;
            C5113l.a aVar = c5220e.f14172j;
            int i = aVar.f13717c;
            C5236b c5236b = aVar.f13718d;
            C5236b c5236bMo7254C = c5220e.f14175n.mo7254C(EnumC5171b.SENSOR);
            if (c5236bMo7254C == null) {
                throw new IllegalStateException("Preview stream size should never be null here.");
            }
            C5206g.m7402a(new RunnableC13245a(bArr, c5236bMo7254C, i, c5236b));
            camera.setPreviewCallbackWithBuffer(null);
            camera.setPreviewCallbackWithBuffer(C5220e.this.f14175n);
            C5188a c5188aM7220l1 = C5220e.this.f14175n.m7220l1();
            C5220e c5220e2 = C5220e.this;
            c5188aM7220l1.mo7382e(c5220e2.f14178q, c5236bMo7254C, c5220e2.f14175n.f13877L);
        }
    }

    public C5220e(@NonNull C5113l.a aVar, @NonNull C5128b c5128b, @NonNull Camera camera, @NonNull C5235a c5235a) {
        super(aVar, c5128b);
        this.f14175n = c5128b;
        this.f14176o = camera;
        this.f14177p = c5235a;
        this.f14178q = camera.getParameters().getPreviewFormat();
    }

    @Override // p007b.p452o.p453a.p471v.AbstractC5219d
    /* JADX INFO: renamed from: b */
    public void mo7416b() {
        this.f14175n = null;
        this.f14176o = null;
        this.f14177p = null;
        this.f14178q = 0;
        super.mo7416b();
    }

    @Override // p007b.p452o.p453a.p471v.AbstractC5219d
    /* JADX INFO: renamed from: c */
    public void mo7417c() {
        this.f14176o.setOneShotPreviewCallback(new a());
    }
}
