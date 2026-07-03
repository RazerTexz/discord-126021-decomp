package me.dm7.barcodescanner.zxing;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.List;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p414e.C4948c;
import p007b.p225i.p414e.C4950e;
import p007b.p225i.p414e.C4952g;
import p007b.p225i.p414e.C4953h;
import p007b.p225i.p414e.EnumC4946a;
import p007b.p225i.p414e.EnumC4949d;
import p007b.p225i.p414e.p418n.C4969h;
import p596e0.p597a.p598a.p599a.AbstractC12253a;
import p596e0.p597a.p598a.p599a.C12259g;
import p596e0.p597a.p598a.p599a.SurfaceHolderCallbackC12256d;

/* JADX INFO: loaded from: classes3.dex */
public class ZXingScannerView extends AbstractC12253a {

    /* JADX INFO: renamed from: D */
    public static final List<EnumC4946a> f27495D;

    /* JADX INFO: renamed from: E */
    public C4952g f27496E;

    /* JADX INFO: renamed from: F */
    public List<EnumC4946a> f27497F;

    /* JADX INFO: renamed from: G */
    public InterfaceC12927b f27498G;

    /* JADX INFO: renamed from: me.dm7.barcodescanner.zxing.ZXingScannerView$a */
    public class RunnableC12926a implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Result f27499j;

        public RunnableC12926a(Result result) {
            this.f27499j = result;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZXingScannerView zXingScannerView = ZXingScannerView.this;
            InterfaceC12927b interfaceC12927b = zXingScannerView.f27498G;
            zXingScannerView.f27498G = null;
            SurfaceHolderCallbackC12256d surfaceHolderCallbackC12256d = zXingScannerView.f25300k;
            if (surfaceHolderCallbackC12256d != null) {
                surfaceHolderCallbackC12256d.m10099e();
            }
            if (interfaceC12927b != null) {
                interfaceC12927b.handleResult(this.f27499j);
            }
        }
    }

    /* JADX INFO: renamed from: me.dm7.barcodescanner.zxing.ZXingScannerView$b */
    public interface InterfaceC12927b {
        void handleResult(Result result);
    }

    static {
        ArrayList arrayList = new ArrayList();
        f27495D = arrayList;
        arrayList.add(EnumC4946a.AZTEC);
        arrayList.add(EnumC4946a.CODABAR);
        arrayList.add(EnumC4946a.CODE_39);
        arrayList.add(EnumC4946a.CODE_93);
        arrayList.add(EnumC4946a.CODE_128);
        arrayList.add(EnumC4946a.DATA_MATRIX);
        arrayList.add(EnumC4946a.EAN_8);
        arrayList.add(EnumC4946a.EAN_13);
        arrayList.add(EnumC4946a.ITF);
        arrayList.add(EnumC4946a.MAXICODE);
        arrayList.add(EnumC4946a.PDF_417);
        arrayList.add(EnumC4946a.QR_CODE);
        arrayList.add(EnumC4946a.RSS_14);
        arrayList.add(EnumC4946a.RSS_EXPANDED);
        arrayList.add(EnumC4946a.UPC_A);
        arrayList.add(EnumC4946a.UPC_E);
        arrayList.add(EnumC4946a.UPC_EAN_EXTENSION);
    }

    public ZXingScannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10953c();
    }

    /* JADX INFO: renamed from: b */
    public C4953h m10952b(byte[] bArr, int i, int i2) {
        Rect rect;
        synchronized (this) {
            if (this.f25302m == null) {
                Rect framingRect = ((C12259g) this.f25301l).getFramingRect();
                int width = this.f25301l.getWidth();
                int height = this.f25301l.getHeight();
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
                    this.f25302m = rect2;
                    rect = this.f25302m;
                }
            } else {
                rect = this.f25302m;
            }
        }
        if (rect == null) {
            return null;
        }
        try {
            return new C4953h(bArr, i, i2, rect.left, rect.top, rect.width(), rect.height(), false);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m10953c() {
        EnumMap enumMap = new EnumMap(EnumC4949d.class);
        enumMap.put(EnumC4949d.POSSIBLE_FORMATS, getFormats());
        C4952g c4952g = new C4952g();
        this.f27496E = c4952g;
        c4952g.m6921c(enumMap);
    }

    public Collection<EnumC4946a> getFormats() {
        List<EnumC4946a> list = this.f27497F;
        return list == null ? f27495D : list;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        byte[] bArr2;
        Result resultM6920b;
        if (this.f27498G == null) {
            return;
        }
        try {
            Camera.Size previewSize = camera.getParameters().getPreviewSize();
            int i = previewSize.width;
            int i2 = previewSize.height;
            if (C3404f.m4332q0(getContext()) != 1) {
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
                Camera.Size previewSize2 = camera.getParameters().getPreviewSize();
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
            C4953h c4953hM10952b = m10952b(bArr2, i2, i);
            Result resultM6920b2 = null;
            if (c4953hM10952b != null) {
                C4948c c4948c = new C4948c(new C4969h(c4953hM10952b));
                try {
                    C4952g c4952g = this.f27496E;
                    if (c4952g.f13189b == null) {
                        c4952g.m6921c(null);
                    }
                    resultM6920b = c4952g.m6920b(c4948c);
                    this.f27496E.reset();
                } catch (ReaderException | ArrayIndexOutOfBoundsException | NullPointerException unused) {
                    this.f27496E.reset();
                    resultM6920b = null;
                } catch (Throwable th) {
                    this.f27496E.reset();
                    throw th;
                }
                if (resultM6920b == null) {
                    C4948c c4948c2 = new C4948c(new C4969h(new C4950e(c4953hM10952b)));
                    try {
                        C4952g c4952g2 = this.f27496E;
                        if (c4952g2.f13189b == null) {
                            c4952g2.m6921c(null);
                        }
                        resultM6920b2 = c4952g2.m6920b(c4948c2);
                        this.f27496E.reset();
                    } catch (NotFoundException unused2) {
                        this.f27496E.reset();
                        resultM6920b2 = resultM6920b;
                    } catch (Throwable th2) {
                        this.f27496E.reset();
                        throw th2;
                    }
                } else {
                    resultM6920b2 = resultM6920b;
                }
            }
            if (resultM6920b2 != null) {
                new Handler(Looper.getMainLooper()).post(new RunnableC12926a(resultM6920b2));
            } else {
                camera.setOneShotPreviewCallback(this);
            }
        } catch (RuntimeException e) {
            Log.e("ZXingScannerView", e.toString(), e);
        }
    }

    public void setFormats(List<EnumC4946a> list) {
        this.f27497F = list;
        m10953c();
    }

    public void setResultHandler(InterfaceC12927b interfaceC12927b) {
        this.f27498G = interfaceC12927b;
    }
}
