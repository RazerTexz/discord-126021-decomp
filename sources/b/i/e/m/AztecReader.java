package b.i.e.m;

import b.i.e.BarcodeFormat;
import b.i.e.BinaryBitmap;
import b.i.e.DecodeHintType;
import b.i.e.Reader;
import b.i.e.ResultMetadataType;
import b.i.e.ResultPoint;
import b.i.e.ResultPointCallback;
import b.i.e.m.c.Decoder2;
import b.i.e.m.d.Detector;
import b.i.e.n.DecoderResult;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: b.i.e.m.b, reason: use source file name */
/* JADX INFO: compiled from: AztecReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AztecReader implements Reader {
    @Override // b.i.e.Reader
    public Result a(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        ResultPoint[] resultPointArr;
        ResultPoint[] resultPointArr2;
        FormatException formatException;
        ResultPointCallback resultPointCallback;
        Detector detector = new Detector(binaryBitmap.a());
        DecoderResult decoderResultA = null;
        try {
            AztecDetectorResult aztecDetectorResultA = detector.a(false);
            resultPointArr = aztecDetectorResultA.f1836b;
            try {
                resultPointArr2 = resultPointArr;
                formatException = null;
                decoderResultA = new Decoder2().a(aztecDetectorResultA);
                e = null;
            } catch (FormatException e) {
                e = e;
                resultPointArr2 = resultPointArr;
                formatException = e;
                e = null;
            } catch (NotFoundException e2) {
                e = e2;
                resultPointArr2 = resultPointArr;
                formatException = null;
            }
        } catch (FormatException e3) {
            e = e3;
            resultPointArr = null;
        } catch (NotFoundException e4) {
            e = e4;
            resultPointArr = null;
        }
        if (decoderResultA == null) {
            try {
                AztecDetectorResult aztecDetectorResultA2 = detector.a(true);
                resultPointArr2 = aztecDetectorResultA2.f1836b;
                decoderResultA = new Decoder2().a(aztecDetectorResultA2);
            } catch (FormatException | NotFoundException e5) {
                if (e != null) {
                    throw e;
                }
                if (formatException != null) {
                    throw formatException;
                }
                throw e5;
            }
        }
        ResultPoint[] resultPointArr3 = resultPointArr2;
        if (map != null && (resultPointCallback = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) != null) {
            for (ResultPoint resultPoint : resultPointArr3) {
                resultPointCallback.a(resultPoint);
            }
        }
        Result result = new Result(decoderResultA.c, decoderResultA.a, decoderResultA.f1835b, resultPointArr3, BarcodeFormat.AZTEC, System.currentTimeMillis());
        List<byte[]> list = decoderResultA.d;
        if (list != null) {
            result.b(ResultMetadataType.BYTE_SEGMENTS, list);
        }
        String str = decoderResultA.e;
        if (str != null) {
            result.b(ResultMetadataType.ERROR_CORRECTION_LEVEL, str);
        }
        return result;
    }

    @Override // b.i.e.Reader
    public void reset() {
    }
}
