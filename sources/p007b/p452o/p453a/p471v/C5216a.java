package p007b.p452o.p453a.p471v;

import android.hardware.Camera;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import p007b.p452o.p453a.C5103b;
import p007b.p452o.p453a.C5113l;
import p007b.p452o.p453a.p455n.C5128b;
import p007b.p452o.p453a.p455n.p461t.EnumC5171b;
import p007b.p452o.p453a.p455n.p463v.EnumC5178e;
import p007b.p452o.p453a.p465p.C5188a;
import p007b.p452o.p453a.p473x.C5236b;

/* JADX INFO: renamed from: b.o.a.v.a */
/* JADX INFO: compiled from: Full1PictureRecorder.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5216a extends AbstractC5218c {

    /* JADX INFO: renamed from: n */
    public final Camera f14161n;

    /* JADX INFO: renamed from: o */
    public final C5128b f14162o;

    /* JADX INFO: renamed from: b.o.a.v.a$a */
    /* JADX INFO: compiled from: Full1PictureRecorder.java */
    public class a implements Camera.ShutterCallback {
        public a() {
        }

        @Override // android.hardware.Camera.ShutterCallback
        public void onShutter() {
            AbstractC5218c.f14171m.m7159a(1, "take(): got onShutter callback.");
            C5216a.this.m7420a(true);
        }
    }

    /* JADX INFO: renamed from: b.o.a.v.a$b */
    /* JADX INFO: compiled from: Full1PictureRecorder.java */
    public class b implements Camera.PictureCallback {
        public b() {
        }

        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] bArr, Camera camera) {
            int i;
            AbstractC5218c.f14171m.m7159a(1, "take(): got picture callback.");
            try {
                switch (new ExifInterface(new ByteArrayInputStream(bArr)).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1)) {
                    case 3:
                    case 4:
                        i = 180;
                        break;
                    case 5:
                    case 6:
                        i = 90;
                        break;
                    case 7:
                    case 8:
                        i = 270;
                        break;
                    default:
                        i = 0;
                        break;
                }
            } catch (IOException unused) {
            }
            C5113l.a aVar = C5216a.this.f14172j;
            aVar.f13720f = bArr;
            aVar.f13717c = i;
            AbstractC5218c.f14171m.m7159a(1, "take(): starting preview again. ", Thread.currentThread());
            if (C5216a.this.f14162o.f13922n.f14028f.m7367f(EnumC5178e.PREVIEW)) {
                camera.setPreviewCallbackWithBuffer(C5216a.this.f14162o);
                C5236b c5236bMo7254C = C5216a.this.f14162o.mo7254C(EnumC5171b.SENSOR);
                if (c5236bMo7254C == null) {
                    throw new IllegalStateException("Preview stream size should never be null here.");
                }
                C5188a c5188aM7220l1 = C5216a.this.f14162o.m7220l1();
                C5128b c5128b = C5216a.this.f14162o;
                c5188aM7220l1.mo7382e(c5128b.f13901u, c5236bMo7254C, c5128b.f13877L);
                camera.startPreview();
            }
            C5216a.this.mo7416b();
        }
    }

    public C5216a(@NonNull C5113l.a aVar, @NonNull C5128b c5128b, @NonNull Camera camera) {
        super(aVar, c5128b);
        this.f14162o = c5128b;
        this.f14161n = camera;
        Camera.Parameters parameters = camera.getParameters();
        parameters.setRotation(this.f14172j.f13717c);
        camera.setParameters(parameters);
    }

    @Override // p007b.p452o.p453a.p471v.AbstractC5219d
    /* JADX INFO: renamed from: b */
    public void mo7416b() {
        AbstractC5218c.f14171m.m7159a(1, "dispatching result. Thread:", Thread.currentThread());
        super.mo7416b();
    }

    @Override // p007b.p452o.p453a.p471v.AbstractC5219d
    /* JADX INFO: renamed from: c */
    public void mo7417c() {
        C5103b c5103b = AbstractC5218c.f14171m;
        c5103b.m7159a(1, "take() called.");
        this.f14161n.setPreviewCallbackWithBuffer(null);
        this.f14162o.m7220l1().mo7381d();
        try {
            this.f14161n.takePicture(new a(), null, null, new b());
            c5103b.m7159a(1, "take() returned.");
        } catch (Exception e) {
            this.f14174l = e;
            mo7416b();
        }
    }
}
