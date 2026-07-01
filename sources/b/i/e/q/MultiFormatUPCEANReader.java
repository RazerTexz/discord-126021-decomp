package b.i.e.q;

import b.i.e.BarcodeFormat;
import b.i.e.DecodeHintType;
import b.i.e.n.BitArray;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.e.q.j, reason: use source file name */
/* JADX INFO: compiled from: MultiFormatUPCEANReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class MultiFormatUPCEANReader extends OneDReader {
    public final UPCEANReader[] a;

    public MultiFormatUPCEANReader(Map<DecodeHintType, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13)) {
                arrayList.add(new EAN13Reader());
            } else if (collection.contains(BarcodeFormat.UPC_A)) {
                arrayList.add(new UPCAReader());
            }
            if (collection.contains(BarcodeFormat.EAN_8)) {
                arrayList.add(new EAN8Reader());
            }
            if (collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new UPCEReader());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new EAN13Reader());
            arrayList.add(new EAN8Reader());
            arrayList.add(new UPCEReader());
        }
        this.a = (UPCEANReader[]) arrayList.toArray(new UPCEANReader[arrayList.size()]);
    }

    @Override // b.i.e.q.OneDReader
    public Result b(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException {
        BarcodeFormat barcodeFormat = BarcodeFormat.UPC_A;
        int[] iArrM = UPCEANReader.m(bitArray);
        for (UPCEANReader uPCEANReader : this.a) {
            try {
                Result resultK = uPCEANReader.k(i, bitArray, iArrM, map);
                boolean z2 = resultK.d == BarcodeFormat.EAN_13 && resultK.a.charAt(0) == '0';
                Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
                boolean z3 = collection == null || collection.contains(barcodeFormat);
                if (!z2 || !z3) {
                    return resultK;
                }
                Result result = new Result(resultK.a.substring(1), resultK.f3140b, resultK.c, barcodeFormat);
                result.a(resultK.e);
                return result;
            } catch (ReaderException unused) {
            }
        }
        throw NotFoundException.l;
    }

    @Override // b.i.e.q.OneDReader, b.i.e.Reader
    public void reset() {
        for (UPCEANReader uPCEANReader : this.a) {
            Objects.requireNonNull(uPCEANReader);
        }
    }
}
