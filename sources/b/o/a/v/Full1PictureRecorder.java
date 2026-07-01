package b.o.a.v;

import android.hardware.Camera;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import b.o.a.CameraLogger;
import b.o.a.PictureResult;
import b.o.a.n.Camera1Engine2;
import b.o.a.n.t.Reference2;
import b.o.a.n.v.CameraState2;
import b.o.a.p.ByteBufferFrameManager;
import b.o.a.x.Size3;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/* JADX INFO: renamed from: b.o.a.v.a, reason: use source file name */
/* JADX INFO: compiled from: Full1PictureRecorder.java */
/* JADX INFO: loaded from: classes3.dex */
public class Full1PictureRecorder extends FullPictureRecorder {
    public final Camera n;
    public final Camera1Engine2 o;

    /* JADX INFO: renamed from: b.o.a.v.a$a */
    /* JADX INFO: compiled from: Full1PictureRecorder.java */
    public class a implements Camera.ShutterCallback {
        public a() {
        }

        @Override // android.hardware.Camera.ShutterCallback
        public void onShutter() {
            FullPictureRecorder.m.a(1, "take(): got onShutter callback.");
            Full1PictureRecorder.this.a(true);
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
            FullPictureRecorder.m.a(1, "take(): got picture callback.");
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
            PictureResult.a aVar = Full1PictureRecorder.this.j;
            aVar.f = bArr;
            aVar.c = i;
            FullPictureRecorder.m.a(1, "take(): starting preview again. ", Thread.currentThread());
            if (Full1PictureRecorder.this.o.n.f.f(CameraState2.PREVIEW)) {
                camera.setPreviewCallbackWithBuffer(Full1PictureRecorder.this.o);
                Size3 size3C = Full1PictureRecorder.this.o.C(Reference2.SENSOR);
                if (size3C == null) {
                    throw new IllegalStateException("Preview stream size should never be null here.");
                }
                ByteBufferFrameManager byteBufferFrameManagerL1 = Full1PictureRecorder.this.o.l1();
                Camera1Engine2 camera1Engine2 = Full1PictureRecorder.this.o;
                byteBufferFrameManagerL1.e(camera1Engine2.u, size3C, camera1Engine2.L);
                camera.startPreview();
            }
            Full1PictureRecorder.this.b();
        }
    }

    public Full1PictureRecorder(@NonNull PictureResult.a aVar, @NonNull Camera1Engine2 camera1Engine2, @NonNull Camera camera) {
        super(aVar, camera1Engine2);
        this.o = camera1Engine2;
        this.n = camera;
        Camera.Parameters parameters = camera.getParameters();
        parameters.setRotation(this.j.c);
        camera.setParameters(parameters);
    }

    @Override // b.o.a.v.PictureRecorder
    public void b() {
        FullPictureRecorder.m.a(1, "dispatching result. Thread:", Thread.currentThread());
        super.b();
    }

    @Override // b.o.a.v.PictureRecorder
    public void c() {
        CameraLogger cameraLogger = FullPictureRecorder.m;
        cameraLogger.a(1, "take() called.");
        this.n.setPreviewCallbackWithBuffer(null);
        this.o.l1().d();
        try {
            this.n.takePicture(new a(), null, null, new b());
            cameraLogger.a(1, "take() returned.");
        } catch (Exception e) {
            this.l = e;
            b();
        }
    }
}
