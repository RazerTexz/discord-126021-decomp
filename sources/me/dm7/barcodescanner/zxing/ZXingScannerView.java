package me.dm7.barcodescanner.zxing;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera$Size;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import b.i.a.f.e.o.f;
import b.i.e.c;
import b.i.e.d;
import b.i.e.e;
import b.i.e.g;
import b.i.e.h;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import e0.a.a.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ZXingScannerView extends a {
    public static final List<b.i.e.a> D;
    public g E;
    public List<b.i.e.a> F;
    public ZXingScannerView$b G;

    static {
        ArrayList arrayList = new ArrayList();
        D = arrayList;
        arrayList.add(b.i.e.a.AZTEC);
        arrayList.add(b.i.e.a.CODABAR);
        arrayList.add(b.i.e.a.CODE_39);
        arrayList.add(b.i.e.a.CODE_93);
        arrayList.add(b.i.e.a.CODE_128);
        arrayList.add(b.i.e.a.DATA_MATRIX);
        arrayList.add(b.i.e.a.EAN_8);
        arrayList.add(b.i.e.a.EAN_13);
        arrayList.add(b.i.e.a.ITF);
        arrayList.add(b.i.e.a.MAXICODE);
        arrayList.add(b.i.e.a.PDF_417);
        arrayList.add(b.i.e.a.QR_CODE);
        arrayList.add(b.i.e.a.RSS_14);
        arrayList.add(b.i.e.a.RSS_EXPANDED);
        arrayList.add(b.i.e.a.UPC_A);
        arrayList.add(b.i.e.a.UPC_E);
        arrayList.add(b.i.e.a.UPC_EAN_EXTENSION);
    }

    public ZXingScannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public h b(byte[] bArr, int i, int i2) {
        Rect rect;
        synchronized (this) {
            if (this.m == null) {
                Rect framingRect = ((e0.a.a.a.g) this.l).getFramingRect();
                int width = this.l.getWidth();
                int height = this.l.getHeight();
                if (framingRect == null || width == 0 || height == 0) {
                    rect = null;
                } else {
                    Rect rect2 = new Rect(framingRect);
                    if (i < width) {
                        rect2.left = (rect2.left * i) / width;
                        rect2.right = (rect2.right * i) / width;
                    }
                    if (i2 < height) {
                        rect2.top = (rect2.top * i2) / height;
                        rect2.bottom = (rect2.bottom * i2) / height;
                    }
                    this.m = rect2;
                    rect = this.m;
                }
            } else {
                rect = this.m;
            }
        }
        if (rect == null) {
            return null;
        }
        try {
            return new h(bArr, i, i2, rect.left, rect.top, rect.width(), rect.height(), false);
        } catch (Exception unused) {
            return null;
        }
    }

    public final void c() {
        EnumMap enumMap = new EnumMap(d.class);
        enumMap.put(d.POSSIBLE_FORMATS, getFormats());
        g gVar = new g();
        this.E = gVar;
        gVar.c(enumMap);
    }

    public Collection<b.i.e.a> getFormats() {
        List<b.i.e.a> list = this.F;
        return list == null ? D : list;
    }

    @Override // android.hardware.Camera$PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        byte[] bArr2;
        Result resultB;
        if (this.G == null) {
            return;
        }
        try {
            Camera$Size previewSize = camera.getParameters().getPreviewSize();
            int i = previewSize.width;
            int i2 = previewSize.height;
            if (f.q0(getContext()) != 1) {
                bArr2 = bArr;
                int i3 = i;
                i = i2;
                i2 = i3;
            } else {
                int rotationCount = getRotationCount();
                if (rotationCount != 1 && rotationCount != 3) {
                    i = i2;
                    i2 = i;
                }
                Camera$Size previewSize2 = camera.getParameters().getPreviewSize();
                int i4 = previewSize2.width;
                int i5 = previewSize2.height;
                int rotationCount2 = getRotationCount();
                if (rotationCount2 == 1 || rotationCount2 == 3) {
                    int i6 = i5;
                    int i7 = 0;
                    bArr2 = bArr;
                    while (i7 < rotationCount2) {
                        byte[] bArr3 = new byte[bArr2.length];
                        for (int i8 = 0; i8 < i6; i8++) {
                            for (int i9 = 0; i9 < i4; i9++) {
                                bArr3[(((i9 * i6) + i6) - i8) - 1] = bArr2[(i8 * i4) + i9];
                            }
                        }
                        i7++;
                        bArr2 = bArr3;
                        int i10 = i6;
                        i6 = i4;
                        i4 = i10;
                    }
                } else {
                    int i11 = i;
                    i = i2;
                    i2 = i11;
                    bArr2 = bArr;
                    int i12 = i;
                    i = i2;
                    i2 = i12;
                }
            }
            h hVarB = b(bArr2, i2, i);
            Result resultB2 = null;
            if (hVarB != null) {
                c cVar = new c(new b.i.e.n.h(hVarB));
                try {
                    g gVar = this.E;
                    if (gVar.f1824b == null) {
                        gVar.c(null);
                    }
                    resultB = gVar.b(cVar);
                    this.E.reset();
                } catch (ReaderException | ArrayIndexOutOfBoundsException | NullPointerException unused) {
                    this.E.reset();
                    resultB = null;
                } catch (Throwable th) {
                    this.E.reset();
                    throw th;
                }
                if (resultB == null) {
                    c cVar2 = new c(new b.i.e.n.h(new e(hVarB)));
                    try {
                        g gVar2 = this.E;
                        if (gVar2.f1824b == null) {
                            gVar2.c(null);
                        }
                        resultB2 = gVar2.b(cVar2);
                        this.E.reset();
                    } catch (NotFoundException unused2) {
                        this.E.reset();
                        resultB2 = resultB;
                    } catch (Throwable th2) {
                        this.E.reset();
                        throw th2;
                    }
                } else {
                    resultB2 = resultB;
                }
            }
            if (resultB2 != null) {
                new Handler(Looper.getMainLooper()).post(new ZXingScannerView$a(this, resultB2));
            } else {
                camera.setOneShotPreviewCallback(this);
            }
        } catch (RuntimeException e) {
            Log.e("ZXingScannerView", e.toString(), e);
        }
    }

    public void setFormats(List<b.i.e.a> list) {
        this.F = list;
        c();
    }

    public void setResultHandler(ZXingScannerView$b zXingScannerView$b) {
        this.G = zXingScannerView$b;
    }
}
