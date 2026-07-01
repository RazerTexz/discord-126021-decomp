package d0.y;

import d0.z.d.Intrinsics3;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: renamed from: d0.y.a, reason: use source file name */
/* JADX INFO: compiled from: IOStreams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class IOStreams {
    public static final long copyTo(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        Intrinsics3.checkNotNullParameter(inputStream, "$this$copyTo");
        Intrinsics3.checkNotNullParameter(outputStream, "out");
        byte[] bArr = new byte[i];
        int i2 = inputStream.read(bArr);
        long j = 0;
        while (i2 >= 0) {
            outputStream.write(bArr, 0, i2);
            j += (long) i2;
            i2 = inputStream.read(bArr);
        }
        return j;
    }

    public static /* synthetic */ long copyTo$default(InputStream inputStream, OutputStream outputStream, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        return copyTo(inputStream, outputStream, i);
    }

    public static final byte[] readBytes(InputStream inputStream) {
        Intrinsics3.checkNotNullParameter(inputStream, "$this$readBytes");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, inputStream.available()));
        copyTo$default(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics3.checkNotNullExpressionValue(byteArray, "buffer.toByteArray()");
        return byteArray;
    }
}
