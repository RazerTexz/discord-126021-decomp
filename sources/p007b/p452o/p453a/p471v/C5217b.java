package p007b.p452o.p453a.p471v;

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
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p452o.p453a.C5103b;
import p007b.p452o.p453a.C5113l;
import p007b.p452o.p453a.p454m.EnumC5123j;
import p007b.p452o.p453a.p455n.C5130d;
import p007b.p452o.p453a.p455n.p456o.AbstractC5145e;
import p007b.p452o.p453a.p455n.p456o.InterfaceC5141a;
import p007b.p452o.p453a.p455n.p456o.InterfaceC5143c;
import p007b.p452o.p453a.p467r.C5206g;

/* JADX INFO: renamed from: b.o.a.v.b */
/* JADX INFO: compiled from: Full2PictureRecorder.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class C5217b extends AbstractC5218c implements ImageReader.OnImageAvailableListener {

    /* JADX INFO: renamed from: n */
    public final InterfaceC5143c f14165n;

    /* JADX INFO: renamed from: o */
    public final InterfaceC5141a f14166o;

    /* JADX INFO: renamed from: p */
    public final ImageReader f14167p;

    /* JADX INFO: renamed from: q */
    public final CaptureRequest.Builder f14168q;

    /* JADX INFO: renamed from: r */
    public DngCreator f14169r;

    /* JADX INFO: renamed from: b.o.a.v.b$a */
    /* JADX INFO: compiled from: Full2PictureRecorder.java */
    public class a extends AbstractC5145e {
        public a() {
        }

        @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e, p007b.p452o.p453a.p455n.p456o.InterfaceC5141a
        /* JADX INFO: renamed from: b */
        public void mo7248b(@NonNull InterfaceC5143c interfaceC5143c, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            int i;
            C5217b c5217b = C5217b.this;
            if (c5217b.f14172j.f13721g == EnumC5123j.DNG) {
                c5217b.f14169r = new DngCreator(((C5130d) interfaceC5143c).f13805g0, totalCaptureResult);
                C5217b c5217b2 = C5217b.this;
                DngCreator dngCreator = c5217b2.f14169r;
                int i2 = c5217b2.f14172j.f13717c;
                int i3 = (i2 + 360) % 360;
                if (i3 == 0) {
                    i = 1;
                } else if (i3 == 90) {
                    i = 6;
                } else if (i3 == 180) {
                    i = 3;
                } else {
                    if (i3 != 270) {
                        throw new IllegalArgumentException(C1643a.m871q("Invalid orientation: ", i2));
                    }
                    i = 8;
                }
                dngCreator.setOrientation(i);
                C5217b c5217b3 = C5217b.this;
                Location location = c5217b3.f14172j.f13716b;
                if (location != null) {
                    c5217b3.f14169r.setLocation(location);
                }
            }
        }

        @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e, p007b.p452o.p453a.p455n.p456o.InterfaceC5141a
        /* JADX INFO: renamed from: c */
        public void mo7331c(@NonNull InterfaceC5143c interfaceC5143c, @NonNull CaptureRequest captureRequest) {
            if (this.f13940d) {
                mo7249j(interfaceC5143c);
                this.f13940d = false;
            }
            if (captureRequest.getTag() == 2) {
                AbstractC5218c.f14171m.m7159a(1, "onCaptureStarted:", "Dispatching picture shutter.");
                C5217b.this.m7420a(false);
                m7341l(Integer.MAX_VALUE);
            }
        }

        @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e
        /* JADX INFO: renamed from: j */
        public void mo7249j(@NonNull InterfaceC5143c interfaceC5143c) {
            this.f13939c = interfaceC5143c;
            C5217b c5217b = C5217b.this;
            c5217b.f14168q.addTarget(c5217b.f14167p.getSurface());
            C5217b c5217b2 = C5217b.this;
            C5113l.a aVar = c5217b2.f14172j;
            if (aVar.f13721g == EnumC5123j.JPEG) {
                c5217b2.f14168q.set(CaptureRequest.JPEG_ORIENTATION, Integer.valueOf(aVar.f13717c));
            }
            C5217b.this.f14168q.setTag(2);
            try {
                ((C5130d) interfaceC5143c).m7230e1(this, C5217b.this.f14168q);
            } catch (CameraAccessException e) {
                C5217b c5217b3 = C5217b.this;
                c5217b3.f14172j = null;
                c5217b3.f14174l = e;
                c5217b3.mo7416b();
                m7341l(Integer.MAX_VALUE);
            }
        }
    }

    public C5217b(@NonNull C5113l.a aVar, @NonNull C5130d c5130d, @NonNull CaptureRequest.Builder builder, @NonNull ImageReader imageReader) {
        super(aVar, c5130d);
        this.f14165n = c5130d;
        this.f14168q = builder;
        this.f14167p = imageReader;
        C5206g c5206gM7403b = C5206g.m7403b("FallbackCameraThread");
        C5206g.f14129c = c5206gM7403b;
        imageReader.setOnImageAvailableListener(this, c5206gM7403b.f14132f);
        this.f14166o = new a();
    }

    @Override // p007b.p452o.p453a.p471v.AbstractC5219d
    /* JADX INFO: renamed from: c */
    public void mo7417c() {
        this.f14166o.mo7333e(this.f14165n);
    }

    /* JADX INFO: renamed from: d */
    public final void m7418d(@NonNull Image image) {
        int i = 0;
        ByteBuffer buffer = image.getPlanes()[0].getBuffer();
        byte[] bArr = new byte[buffer.remaining()];
        buffer.get(bArr);
        C5113l.a aVar = this.f14172j;
        aVar.f13720f = bArr;
        aVar.f13717c = 0;
        try {
            int attributeInt = new ExifInterface(new ByteArrayInputStream(this.f14172j.f13720f)).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
            C5113l.a aVar2 = this.f14172j;
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
            aVar2.f13717c = i;
        } catch (IOException unused) {
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m7419e(@NonNull Image image) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
        try {
            this.f14169r.writeImage(bufferedOutputStream, image);
            bufferedOutputStream.flush();
            this.f14172j.f13720f = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            this.f14169r.close();
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
        C5103b c5103b = AbstractC5218c.f14171m;
        c5103b.m7159a(1, "onImageAvailable started.");
        Image image = 0;
        try {
            try {
                imageAcquireNextImage = imageReader.acquireNextImage();
                try {
                    int iOrdinal = this.f14172j.f13721g.ordinal();
                    if (iOrdinal == 0) {
                        m7418d(imageAcquireNextImage);
                    } else {
                        if (iOrdinal != 1) {
                            throw new IllegalStateException("Unknown format: " + this.f14172j.f13721g);
                        }
                        m7419e(imageAcquireNextImage);
                    }
                    if (imageAcquireNextImage != null) {
                        imageAcquireNextImage.close();
                    }
                    c5103b.m7159a(1, "onImageAvailable ended.");
                    mo7416b();
                } catch (Exception e) {
                    e = e;
                    this.f14172j = null;
                    this.f14174l = e;
                    mo7416b();
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
