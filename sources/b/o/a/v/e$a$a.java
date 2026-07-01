package b.o.a.v;

import android.graphics.Rect;
import android.graphics.YuvImage;
import b.o.a.l$a;
import java.io.ByteArrayOutputStream;

/* JADX INFO: compiled from: Snapshot1PictureRecorder.java */
/* JADX INFO: loaded from: classes3.dex */
public class e$a$a implements Runnable {
    public final /* synthetic */ byte[] j;
    public final /* synthetic */ b.o.a.x.b k;
    public final /* synthetic */ int l;
    public final /* synthetic */ b.o.a.x.b m;
    public final /* synthetic */ e$a n;

    public e$a$a(e$a e_a, byte[] bArr, b.o.a.x.b bVar, int i, b.o.a.x.b bVar2) {
        this.n = e_a;
        this.j = bArr;
        this.k = bVar;
        this.l = i;
        this.m = bVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        byte[] bArr;
        byte[] bArr2 = this.j;
        b.o.a.x.b bVar = this.k;
        int i = this.l;
        if (i == 0) {
            bArr = bArr2;
        } else {
            if (i % 90 != 0 || i < 0 || i > 270) {
                throw new IllegalArgumentException("0 <= rotation < 360, rotation % 90 == 0");
            }
            int i2 = bVar.j;
            int i3 = bVar.k;
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
        int i16 = this.n.j.q;
        b.o.a.x.b bVar2 = this.m;
        YuvImage yuvImage = new YuvImage(bArr, i16, bVar2.j, bVar2.k, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Rect rectL = b.i.a.f.e.o.f.L(this.m, this.n.j.p);
        yuvImage.compressToJpeg(rectL, 90, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        l$a l_a = this.n.j.j;
        l_a.f = byteArray;
        l_a.d = new b.o.a.x.b(rectL.width(), rectL.height());
        e eVar = this.n.j;
        eVar.j.c = 0;
        eVar.b();
    }
}
