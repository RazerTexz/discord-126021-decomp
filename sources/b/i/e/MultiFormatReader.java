package b.i.e;

import b.i.e.m.AztecReader;
import b.i.e.o.DataMatrixReader;
import b.i.e.p.MaxiCodeReader;
import b.i.e.q.MultiFormatOneDReader;
import b.i.e.r.PDF417Reader;
import b.i.e.s.QRCodeReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: renamed from: b.i.e.g, reason: use source file name */
/* JADX INFO: compiled from: MultiFormatReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class MultiFormatReader implements Reader {
    public Map<DecodeHintType, ?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Reader[] f1824b;

    @Override // b.i.e.Reader
    public Result a(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        c(map);
        return b(binaryBitmap);
    }

    public final Result b(BinaryBitmap binaryBitmap) throws NotFoundException {
        Reader[] readerArr = this.f1824b;
        if (readerArr != null) {
            for (Reader reader : readerArr) {
                try {
                    return reader.a(binaryBitmap, this.a);
                } catch (ReaderException unused) {
                }
            }
        }
        throw NotFoundException.l;
    }

    public void c(Map<DecodeHintType, ?> map) {
        this.a = map;
        boolean z2 = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            boolean z3 = collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.UPC_E) || collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.CODABAR) || collection.contains(BarcodeFormat.CODE_39) || collection.contains(BarcodeFormat.CODE_93) || collection.contains(BarcodeFormat.CODE_128) || collection.contains(BarcodeFormat.ITF) || collection.contains(BarcodeFormat.RSS_14) || collection.contains(BarcodeFormat.RSS_EXPANDED);
            if (z3 && !z2) {
                arrayList.add(new MultiFormatOneDReader(map));
            }
            if (collection.contains(BarcodeFormat.QR_CODE)) {
                arrayList.add(new QRCodeReader());
            }
            if (collection.contains(BarcodeFormat.DATA_MATRIX)) {
                arrayList.add(new DataMatrixReader());
            }
            if (collection.contains(BarcodeFormat.AZTEC)) {
                arrayList.add(new AztecReader());
            }
            if (collection.contains(BarcodeFormat.PDF_417)) {
                arrayList.add(new PDF417Reader());
            }
            if (collection.contains(BarcodeFormat.MAXICODE)) {
                arrayList.add(new MaxiCodeReader());
            }
            if (z3 && z2) {
                arrayList.add(new MultiFormatOneDReader(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z2) {
                arrayList.add(new MultiFormatOneDReader(map));
            }
            arrayList.add(new QRCodeReader());
            arrayList.add(new DataMatrixReader());
            arrayList.add(new AztecReader());
            arrayList.add(new PDF417Reader());
            arrayList.add(new MaxiCodeReader());
            if (z2) {
                arrayList.add(new MultiFormatOneDReader(map));
            }
        }
        this.f1824b = (Reader[]) arrayList.toArray(new Reader[arrayList.size()]);
    }

    @Override // b.i.e.Reader
    public void reset() {
        Reader[] readerArr = this.f1824b;
        if (readerArr != null) {
            for (Reader reader : readerArr) {
                reader.reset();
            }
        }
    }
}
