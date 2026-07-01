package androidx.core.util;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import d0.g0.Charsets2;
import d0.z.d.InlineMarker;
import d0.z.d.Intrinsics3;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: androidx.core.util.AtomicFileKt, reason: use source file name */
/* JADX INFO: compiled from: AtomicFile.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AtomicFile2 {
    @RequiresApi(17)
    public static final byte[] readBytes(android.util.AtomicFile atomicFile) throws IOException {
        Intrinsics3.checkNotNullParameter(atomicFile, "<this>");
        byte[] fully = atomicFile.readFully();
        Intrinsics3.checkNotNullExpressionValue(fully, "readFully()");
        return fully;
    }

    @RequiresApi(17)
    public static final String readText(android.util.AtomicFile atomicFile, Charset charset) throws IOException {
        Intrinsics3.checkNotNullParameter(atomicFile, "<this>");
        Intrinsics3.checkNotNullParameter(charset, "charset");
        byte[] fully = atomicFile.readFully();
        Intrinsics3.checkNotNullExpressionValue(fully, "readFully()");
        return new String(fully, charset);
    }

    public static /* synthetic */ String readText$default(android.util.AtomicFile atomicFile, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets2.a;
        }
        return readText(atomicFile, charset);
    }

    @RequiresApi(17)
    public static final void tryWrite(android.util.AtomicFile atomicFile, Function1<? super FileOutputStream, Unit> function1) throws IOException {
        Intrinsics3.checkNotNullParameter(atomicFile, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "block");
        FileOutputStream fileOutputStreamStartWrite = atomicFile.startWrite();
        try {
            Intrinsics3.checkNotNullExpressionValue(fileOutputStreamStartWrite, "stream");
            function1.invoke(fileOutputStreamStartWrite);
            InlineMarker.finallyStart(1);
            atomicFile.finishWrite(fileOutputStreamStartWrite);
        } finally {
            InlineMarker.finallyStart(1);
            atomicFile.failWrite(fileOutputStreamStartWrite);
            InlineMarker.finallyEnd(1);
        }
    }

    @RequiresApi(17)
    public static final void writeBytes(android.util.AtomicFile atomicFile, byte[] bArr) throws IOException {
        Intrinsics3.checkNotNullParameter(atomicFile, "<this>");
        Intrinsics3.checkNotNullParameter(bArr, "array");
        FileOutputStream fileOutputStreamStartWrite = atomicFile.startWrite();
        try {
            Intrinsics3.checkNotNullExpressionValue(fileOutputStreamStartWrite, "stream");
            fileOutputStreamStartWrite.write(bArr);
            atomicFile.finishWrite(fileOutputStreamStartWrite);
        } catch (Throwable th) {
            atomicFile.failWrite(fileOutputStreamStartWrite);
            throw th;
        }
    }

    @RequiresApi(17)
    public static final void writeText(android.util.AtomicFile atomicFile, String str, Charset charset) throws IOException {
        Intrinsics3.checkNotNullParameter(atomicFile, "<this>");
        Intrinsics3.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        Intrinsics3.checkNotNullParameter(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        Intrinsics3.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        writeBytes(atomicFile, bytes);
    }

    public static /* synthetic */ void writeText$default(android.util.AtomicFile atomicFile, String str, Charset charset, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            charset = Charsets2.a;
        }
        writeText(atomicFile, str, charset);
    }
}
