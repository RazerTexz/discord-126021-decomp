package b.i.e.q;

import b.i.e.BarcodeFormat;
import b.i.e.DecodeHintType;
import b.i.e.n.BitArray;
import b.i.e.q.r.RSS14Reader;
import b.i.e.q.r.f.RSSExpandedReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: renamed from: b.i.e.q.i, reason: use source file name */
/* JADX INFO: compiled from: MultiFormatOneDReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class MultiFormatOneDReader extends OneDReader {
    public final OneDReader[] a;

    public MultiFormatOneDReader(Map<DecodeHintType, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        boolean z2 = (map == null || map.get(DecodeHintType.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new MultiFormatUPCEANReader(map));
            }
            if (collection.contains(BarcodeFormat.CODE_39)) {
                arrayList.add(new Code39Reader(z2));
            }
            if (collection.contains(BarcodeFormat.CODE_93)) {
                arrayList.add(new Code93Reader());
            }
            if (collection.contains(BarcodeFormat.CODE_128)) {
                arrayList.add(new Code128Reader());
            }
            if (collection.contains(BarcodeFormat.ITF)) {
                arrayList.add(new ITFReader());
            }
            if (collection.contains(BarcodeFormat.CODABAR)) {
                arrayList.add(new CodaBarReader());
            }
            if (collection.contains(BarcodeFormat.RSS_14)) {
                arrayList.add(new RSS14Reader());
            }
            if (collection.contains(BarcodeFormat.RSS_EXPANDED)) {
                arrayList.add(new RSSExpandedReader());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new MultiFormatUPCEANReader(map));
            arrayList.add(new Code39Reader(false));
            arrayList.add(new CodaBarReader());
            arrayList.add(new Code93Reader());
            arrayList.add(new Code128Reader());
            arrayList.add(new ITFReader());
            arrayList.add(new RSS14Reader());
            arrayList.add(new RSSExpandedReader());
        }
        this.a = (OneDReader[]) arrayList.toArray(new OneDReader[arrayList.size()]);
    }

    @Override // b.i.e.q.OneDReader
    public Result b(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException {
        for (OneDReader oneDReader : this.a) {
            try {
                return oneDReader.b(i, bitArray, map);
            } catch (ReaderException unused) {
            }
        }
        throw NotFoundException.l;
    }

    @Override // b.i.e.q.OneDReader, b.i.e.Reader
    public void reset() {
        for (OneDReader oneDReader : this.a) {
            oneDReader.reset();
        }
    }
}
