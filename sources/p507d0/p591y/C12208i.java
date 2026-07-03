package p507d0.p591y;

import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.y.i */
/* JADX INFO: compiled from: ReadWrite.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12208i {
    public static final long copyTo(Reader reader, Writer writer, int i) throws IOException {
        C12238m.checkNotNullParameter(reader, "$this$copyTo");
        C12238m.checkNotNullParameter(writer, "out");
        char[] cArr = new char[i];
        int i2 = reader.read(cArr);
        long j = 0;
        while (i2 >= 0) {
            writer.write(cArr, 0, i2);
            j += (long) i2;
            i2 = reader.read(cArr);
        }
        return j;
    }

    public static /* synthetic */ long copyTo$default(Reader reader, Writer writer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        return copyTo(reader, writer, i);
    }

    public static final String readText(Reader reader) {
        C12238m.checkNotNullParameter(reader, "$this$readText");
        StringWriter stringWriter = new StringWriter();
        copyTo$default(reader, stringWriter, 0, 2, null);
        String string = stringWriter.toString();
        C12238m.checkNotNullExpressionValue(string, "buffer.toString()");
        return string;
    }
}
