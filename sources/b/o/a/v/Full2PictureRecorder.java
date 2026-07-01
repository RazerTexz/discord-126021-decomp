package b.o.a.v;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.DngCreator;
import android.hardware.camera2.TotalCaptureResult;
import android.location.Location;
import android.media.Image;
import android.media.ImageReader;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import b.o.a.CameraLogger;
import b.o.a.PictureResult;
import b.o.a.m.PictureFormat;
import b.o.a.n.Camera2Engine;
import b.o.a.n.o.Action2;
import b.o.a.n.o.ActionHolder;
import b.o.a.n.o.BaseAction;
import b.o.a.r.WorkerHandler;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: b.o.a.v.b, reason: use source file name */
/* JADX INFO: compiled from: Full2PictureRecorder.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class Full2PictureRecorder extends FullPictureRecorder implements ImageReader.OnImageAvailableListener {
    public final ActionHolder n;
    public final Action2 o;
    public final ImageReader p;
    public final CaptureRequest.Builder q;
    public DngCreator r;

    /* JADX INFO: renamed from: b.o.a.v.b$a */
    /* JADX INFO: compiled from: Full2PictureRecorder.java */
    public class a extends BaseAction {
        public a() {
        }

        @Override // b.o.a.n.o.BaseAction, b.o.a.n.o.Action2
        public void b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            int i;
            Full2PictureRecorder full2PictureRecorder = Full2PictureRecorder.this;
            if (full2PictureRecorder.j.g == PictureFormat.DNG) {
                full2PictureRecorder.r = new DngCreator(((Camera2Engine) actionHolder).f1919g0, totalCaptureResult);
                Full2PictureRecorder full2PictureRecorder2 = Full2PictureRecorder.this;
                DngCreator dngCreator = full2PictureRecorder2.r;
                int i2 = full2PictureRecorder2.j.c;
                int i3 = (i2 + 360) % 360;
                if (i3 == 0) {
                    i = 1;
                } else if (i3 == 90) {
                    i = 6;
                } else if (i3 == 180) {
                    i = 3;
                } else {
                    if (i3 != 270) {
                        throw new IllegalArgumentException(outline.q("Invalid orientation: ", i2));
                    }
                    i = 8;
                }
                dngCreator.setOrientation(i);
                Full2PictureRecorder full2PictureRecorder3 = Full2PictureRecorder.this;
                Location location = full2PictureRecorder3.j.f1912b;
                if (location != null) {
                    full2PictureRecorder3.r.setLocation(location);
                }
            }
        }

        @Override // b.o.a.n.o.BaseAction, b.o.a.n.o.Action2
        public void c(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest) {
            if (this.d) {
                j(actionHolder);
                this.d = false;
            }
            if (captureRequest.getTag() == 2) {
                FullPictureRecorder.m.a(1, "onCaptureStarted:", "Dispatching picture shutter.");
                Full2PictureRecorder.this.a(false);
                l(Integer.MAX_VALUE);
            }
        }

        @Override // b.o.a.n.o.BaseAction
        public void j(@NonNull ActionHolder actionHolder) {
            this.c = actionHolder;
            Full2PictureRecorder full2PictureRecorder = Full2PictureRecorder.this;
            full2PictureRecorder.q.addTarget(full2PictureRecorder.p.getSurface());
            Full2PictureRecorder full2PictureRecorder2 = Full2PictureRecorder.this;
            PictureResult.a aVar = full2PictureRecorder2.j;
            if (aVar.g == PictureFormat.JPEG) {
                full2PictureRecorder2.q.set(CaptureRequest.JPEG_ORIENTATION, Integer.valueOf(aVar.c));
            }
            Full2PictureRecorder.this.q.setTag(2);
            try {
                ((Camera2Engine) actionHolder).e1(this, Full2PictureRecorder.this.q);
            } catch (CameraAccessException e) {
                Full2PictureRecorder full2PictureRecorder3 = Full2PictureRecorder.this;
                full2PictureRecorder3.j = null;
                full2PictureRecorder3.l = e;
                full2PictureRecorder3.b();
                l(Integer.MAX_VALUE);
            }
        }
    }

    public Full2PictureRecorder(@NonNull PictureResult.a aVar, @NonNull Camera2Engine camera2Engine, @NonNull CaptureRequest.Builder builder, @NonNull ImageReader imageReader) {
        super(aVar, camera2Engine);
        this.n = camera2Engine;
        this.q = builder;
        this.p = imageReader;
        WorkerHandler workerHandlerB = WorkerHandler.b("FallbackCameraThread");
        WorkerHandler.c = workerHandlerB;
        imageReader.setOnImageAvailableListener(this, workerHandlerB.f);
        this.o = new a();
    }

    @Override // b.o.a.v.PictureRecorder
    public void c() {
        this.o.e(this.n);
    }

    public final void d(@NonNull Image image) {
        int i = 0;
        ByteBuffer buffer = image.getPlanes()[0].getBuffer();
        byte[] bArr = new byte[buffer.remaining()];
        buffer.get(bArr);
        PictureResult.a aVar = this.j;
        aVar.f = bArr;
        aVar.c = 0;
        try {
            int attributeInt = new ExifInterface(new ByteArrayInputStream(this.j.f)).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
            PictureResult.a aVar2 = this.j;
            switch (attributeInt) {
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
            }
            aVar2.c = i;
        } catch (IOException unused) {
        }
    }

    public final void e(@NonNull Image image) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
        try {
            this.r.writeImage(bufferedOutputStream, image);
            bufferedOutputStream.flush();
            this.j.f = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            this.r.close();
            try {
                bufferedOutputStream.close();
            } catch (IOException unused) {
            }
            throw new RuntimeException(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0069  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.media.ImageReader.OnImageAvailableListener
    public void onImageAvailable(ImageReader imageReader) throws Throwable {
        Image imageAcquireNextImage;
        CameraLogger cameraLogger = FullPictureRecorder.m;
        cameraLogger.a(1, "onImageAvailable started.");
        Image image = 0;
        try {
            try {
                imageAcquireNextImage = imageReader.acquireNextImage();
                try {
                    int iOrdinal = this.j.g.ordinal();
                    if (iOrdinal == 0) {
                        d(imageAcquireNextImage);
                    } else {
                        if (iOrdinal != 1) {
                            throw new IllegalStateException("Unknown format: " + this.j.g);
                        }
                        e(imageAcquireNextImage);
                    }
                    if (imageAcquireNextImage != null) {
                        imageAcquireNextImage.close();
                    }
                    cameraLogger.a(1, "onImageAvailable ended.");
                    b();
                } catch (Exception e) {
                    e = e;
                    this.j = null;
                    this.l = e;
                    b();
                    if (imageAcquireNextImage != null) {
                        imageAcquireNextImage.close();
                    }
                }
            } catch (Throwable th) {
                th = th;
                image = imageReader;
                if (image != 0) {
                    image.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            imageAcquireNextImage = null;
        } catch (Throwable th2) {
            th = th2;
            if (image != 0) {
                image.close();
            }
            throw th;
        }
    }
}
