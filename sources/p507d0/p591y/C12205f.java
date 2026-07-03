package p507d0.p591y;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import p507d0.p579g0.C12086c;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.y.f */
/* JADX INFO: compiled from: FileReadWrite.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12205f {
    public static final String readText(File file, Charset charset) throws IOException {
        C12238m.checkNotNullParameter(file, "$this$readText");
        C12238m.checkNotNullParameter(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String text = C12208i.readText(inputStreamReader);
            C12201b.closeFinally(inputStreamReader, null);
            return text;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                C12201b.closeFinally(inputStreamReader, th);
                throw th2;
            }
        }
    }

    public static /* synthetic */ String readText$default(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = C12086c.f25136a;
        }
        return readText(file, charset);
    }
}
