package b.o.a.v;

import android.hardware.Camera;
import android.hardware.Camera$PictureCallback;
import androidx.exifinterface.media.ExifInterface;
import b.o.a.l$a;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/* JADX INFO: compiled from: Full1PictureRecorder.java */
/* JADX INFO: loaded from: classes3.dex */
public class a$b implements Camera$PictureCallback {
    public final /* synthetic */ a a;

    public a$b(a aVar) {
        this.a = aVar;
    }

    @Override // android.hardware.Camera$PictureCallback
    public void onPictureTaken(byte[] bArr, Camera camera) {
        int i;
        c.m.a(1, "take(): got picture callback.");
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
        l$a l_a = this.a.j;
        l_a.f = bArr;
        l_a.c = i;
        c.m.a(1, "take(): starting preview again. ", Thread.currentThread());
        if (this.a.o.n.f.f(b.o.a.n.v.e.PREVIEW)) {
            camera.setPreviewCallbackWithBuffer(this.a.o);
            b.o.a.x.b bVarC = this.a.o.C(b.o.a.n.t.b.SENSOR);
            if (bVarC == null) {
                throw new IllegalStateException("Preview stream size should never be null here.");
            }
            b.o.a.p.a aVarL1 = this.a.o.l1();
            b.o.a.n.b bVar = this.a.o;
            aVarL1.e(bVar.u, bVarC, bVar.L);
            camera.startPreview();
        }
        this.a.b();
    }
}
