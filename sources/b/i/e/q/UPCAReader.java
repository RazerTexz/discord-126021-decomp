package b.i.e.q;

import b.i.e.BarcodeFormat;
import b.i.e.BinaryBitmap;
import b.i.e.DecodeHintType;
import b.i.e.ResultMetadataType;
import b.i.e.n.BitArray;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.Map;

/* JADX INFO: renamed from: b.i.e.q.l, reason: use source file name */
/* JADX INFO: compiled from: UPCAReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class UPCAReader extends UPCEANReader {
    public final UPCEANReader h = new EAN13Reader();

    public static Result o(Result result) throws FormatException {
        String str = result.a;
        if (str.charAt(0) != '0') {
            throw FormatException.a();
        }
        Result result2 = new Result(str.substring(1), null, result.c, BarcodeFormat.UPC_A);
        Map<ResultMetadataType, Object> map = result.e;
        if (map != null) {
            result2.a(map);
        }
        return result2;
    }

    @Override // b.i.e.q.OneDReader, b.i.e.Reader
    public Result a(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        return o(this.h.a(binaryBitmap, map));
    }

    @Override // b.i.e.q.UPCEANReader, b.i.e.q.OneDReader
    public Result b(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return o(this.h.b(i, bitArray, map));
    }

    @Override // b.i.e.q.UPCEANReader
    public int j(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException {
        return this.h.j(bitArray, iArr, sb);
    }

    @Override // b.i.e.q.UPCEANReader
    public Result k(int i, BitArray bitArray, int[] iArr, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return o(this.h.k(i, bitArray, iArr, map));
    }

    @Override // b.i.e.q.UPCEANReader
    public BarcodeFormat n() {
        return BarcodeFormat.UPC_A;
    }
}
