package d0.y;

import d0.g0.Charsets2;
import d0.z.d.Intrinsics3;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/* JADX INFO: renamed from: d0.y.f, reason: use source file name */
/* JADX INFO: compiled from: FileReadWrite.kt */
/* JADX INFO: loaded from: classes3.dex */
public class FileReadWrite {
    public static final String readText(File file, Charset charset) throws IOException {
        Intrinsics3.checkNotNullParameter(file, "$this$readText");
        Intrinsics3.checkNotNullParameter(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String text = ReadWrite.readText(inputStreamReader);
            Closeable.closeFinally(inputStreamReader, null);
            return text;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                Closeable.closeFinally(inputStreamReader, th);
                throw th2;
            }
        }
    }

    public static /* synthetic */ String readText$default(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets2.a;
        }
        return readText(file, charset);
    }
}
