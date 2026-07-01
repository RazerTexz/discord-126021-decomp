package b.o.a.v;

import android.hardware.camera2.CaptureRequest$Builder;
import android.hardware.camera2.DngCreator;
import android.media.Image;
import android.media.ImageReader;
import android.media.ImageReader$OnImageAvailableListener;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import b.o.a.l$a;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: Full2PictureRecorder.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class b extends c implements ImageReader$OnImageAvailableListener {
    public final b.o.a.n.o.c n;
    public final b.o.a.n.o.a o;
    public final ImageReader p;
    public final CaptureRequest$Builder q;
    public DngCreator r;

    public b(@NonNull l$a l_a, @NonNull b.o.a.n.d dVar, @NonNull CaptureRequest$Builder captureRequest$Builder, @NonNull ImageReader imageReader) {
        super(l_a, dVar);
        this.n = dVar;
        this.q = captureRequest$Builder;
        this.p = imageReader;
        b.o.a.r.g gVarB = b.o.a.r.g.b("FallbackCameraThread");
        b.o.a.r.g.c = gVarB;
        imageReader.setOnImageAvailableListener(this, gVarB.f);
        this.o = new b$a(this);
    }

    @Override // b.o.a.v.d
    public void c() {
        this.o.e(this.n);
    }

    public final void d(@NonNull Image image) {
        int i = 0;
        ByteBuffer buffer = image.getPlanes()[0].getBuffer();
        byte[] bArr = new byte[buffer.remaining()];
        buffer.get(bArr);
        l$a l_a = this.j;
        l_a.f = bArr;
        l_a.c = 0;
        try {
            int attributeInt = new ExifInterface(new ByteArrayInputStream(this.j.f)).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
            l$a l_a2 = this.j;
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
            l_a2.c = i;
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
    @Override // android.media.ImageReader$OnImageAvailableListener
    public void onImageAvailable(ImageReader imageReader) throws Throwable {
        Image imageAcquireNextImage;
        b.o.a.b bVar = c.m;
        bVar.a(1, "onImageAvailable started.");
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
                    bVar.a(1, "onImageAvailable ended.");
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
