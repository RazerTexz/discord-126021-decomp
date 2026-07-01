package b.i.e;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.Map;

/* JADX INFO: renamed from: b.i.e.i, reason: use source file name */
/* JADX INFO: compiled from: Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public interface Reader {
    Result a(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException;

    void reset();
}
