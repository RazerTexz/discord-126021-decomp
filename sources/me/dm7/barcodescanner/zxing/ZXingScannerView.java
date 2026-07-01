package me.dm7.barcodescanner.zxing;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import b.i.a.f.e.o.f;
import b.i.e.BarcodeFormat;
import b.i.e.BinaryBitmap;
import b.i.e.DecodeHintType;
import b.i.e.InvertedLuminanceSource;
import b.i.e.MultiFormatReader;
import b.i.e.PlanarYUVLuminanceSource;
import b.i.e.n.HybridBinarizer;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import e0.a.a.a.BarcodeScannerView;
import e0.a.a.a.CameraPreview2;
import e0.a.a.a.ViewFinderView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ZXingScannerView extends BarcodeScannerView {
    public static final List<BarcodeFormat> D;
    public MultiFormatReader E;
    public List<BarcodeFormat> F;
    public b G;

    public class a implements Runnable {
        public final /* synthetic */ Result j;

        public a(Result result) {
            this.j = result;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZXingScannerView zXingScannerView = ZXingScannerView.this;
            b bVar = zXingScannerView.G;
            zXingScannerView.G = null;
            CameraPreview2 cameraPreview2 = zXingScannerView.k;
            if (cameraPreview2 != null) {
                cameraPreview2.e();
            }
            if (bVar != null) {
                bVar.handleResult(this.j);
            }
        }
    }

    public interface b {
        void handleResult(Result result);
    }

    static {
        ArrayList arrayList = new ArrayList();
        D = arrayList;
        arrayList.add(BarcodeFormat.AZTEC);
        arrayList.add(BarcodeFormat.CODABAR);
        arrayList.add(BarcodeFormat.CODE_39);
        arrayList.add(BarcodeFormat.CODE_93);
        arrayList.add(BarcodeFormat.CODE_128);
        arrayList.add(BarcodeFormat.DATA_MATRIX);
        arrayList.add(BarcodeFormat.EAN_8);
        arrayList.add(BarcodeFormat.EAN_13);
        arrayList.add(BarcodeFormat.ITF);
        arrayList.add(BarcodeFormat.MAXICODE);
        arrayList.add(BarcodeFormat.PDF_417);
        arrayList.add(BarcodeFormat.QR_CODE);
        arrayList.add(BarcodeFormat.RSS_14);
        arrayList.add(BarcodeFormat.RSS_EXPANDED);
        arrayList.add(BarcodeFormat.UPC_A);
        arrayList.add(BarcodeFormat.UPC_E);
        arrayList.add(BarcodeFormat.UPC_EAN_EXTENSION);
    }

    public ZXingScannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public PlanarYUVLuminanceSource b(byte[] bArr, int i, int i2) {
        Rect rect;
        synchronized (this) {
            if (this.m == null) {
                Rect framingRect = ((ViewFinderView) this.l).getFramingRect();
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
            return new PlanarYUVLuminanceSource(bArr, i, i2, rect.left, rect.top, rect.width(), rect.height(), false);
        } catch (Exception unused) {
            return null;
        }
    }

    public final void c() {
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        enumMap.put(DecodeHintType.POSSIBLE_FORMATS, getFormats());
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        this.E = multiFormatReader;
        multiFormatReader.c(enumMap);
    }

    public Collection<BarcodeFormat> getFormats() {
        List<BarcodeFormat> list = this.F;
        return list == null ? D : list;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        byte[] bArr2;
        Result resultB;
        if (this.G == null) {
            return;
        }
        try {
            Camera.Size previewSize = camera.getParameters().getPreviewSize();
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
            PlanarYUVLuminanceSource planarYUVLuminanceSourceB = b(bArr2, i2, i);
            Result resultB2 = null;
            if (planarYUVLuminanceSourceB != null) {
                BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(planarYUVLuminanceSourceB));
                try {
                    MultiFormatReader multiFormatReader = this.E;
                    if (multiFormatReader.f1824b == null) {
                        multiFormatReader.c(null);
                    }
                    resultB = multiFormatReader.b(binaryBitmap);
                    this.E.reset();
                } catch (ReaderException | ArrayIndexOutOfBoundsException | NullPointerException unused) {
                    this.E.reset();
                    resultB = null;
                } catch (Throwable th) {
                    this.E.reset();
                    throw th;
                }
                if (resultB == null) {
                    BinaryBitmap binaryBitmap2 = new BinaryBitmap(new HybridBinarizer(new InvertedLuminanceSource(planarYUVLuminanceSourceB)));
                    try {
                        MultiFormatReader multiFormatReader2 = this.E;
                        if (multiFormatReader2.f1824b == null) {
                            multiFormatReader2.c(null);
                        }
                        resultB2 = multiFormatReader2.b(binaryBitmap2);
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
                new Handler(Looper.getMainLooper()).post(new a(resultB2));
            } else {
                camera.setOneShotPreviewCallback(this);
            }
        } catch (RuntimeException e) {
            Log.e("ZXingScannerView", e.toString(), e);
        }
    }

    public void setFormats(List<BarcodeFormat> list) {
        this.F = list;
        c();
    }

    public void setResultHandler(b bVar) {
        this.G = bVar;
    }
}
