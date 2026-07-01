package androidx.core.util;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import d0.g0.c;
import d0.z.d.l;
import d0.z.d.m;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AtomicFile.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AtomicFileKt {
    @RequiresApi(17)
    public static final byte[] readBytes(android.util.AtomicFile atomicFile) throws IOException {
        m.checkNotNullParameter(atomicFile, "<this>");
        byte[] fully = atomicFile.readFully();
        m.checkNotNullExpressionValue(fully, "readFully()");
        return fully;
    }

    @RequiresApi(17)
    public static final String readText(android.util.AtomicFile atomicFile, Charset charset) throws IOException {
        m.checkNotNullParameter(atomicFile, "<this>");
        m.checkNotNullParameter(charset, "charset");
        byte[] fully = atomicFile.readFully();
        m.checkNotNullExpressionValue(fully, "readFully()");
        return new String(fully, charset);
    }

    public static /* synthetic */ String readText$default(android.util.AtomicFile atomicFile, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = c.a;
        }
        return readText(atomicFile, charset);
    }

    @RequiresApi(17)
    public static final void tryWrite(android.util.AtomicFile atomicFile, Function1<? super FileOutputStream, Unit> function1) throws IOException {
        m.checkNotNullParameter(atomicFile, "<this>");
        m.checkNotNullParameter(function1, "block");
        FileOutputStream fileOutputStreamStartWrite = atomicFile.startWrite();
        try {
            m.checkNotNullExpressionValue(fileOutputStreamStartWrite, "stream");
            function1.invoke(fileOutputStreamStartWrite);
            l.finallyStart(1);
            atomicFile.finishWrite(fileOutputStreamStartWrite);
        } finally {
            l.finallyStart(1);
            atomicFile.failWrite(fileOutputStreamStartWrite);
            l.finallyEnd(1);
        }
    }

    @RequiresApi(17)
    public static final void writeBytes(android.util.AtomicFile atomicFile, byte[] bArr) throws IOException {
        m.checkNotNullParameter(atomicFile, "<this>");
        m.checkNotNullParameter(bArr, "array");
        FileOutputStream fileOutputStreamStartWrite = atomicFile.startWrite();
        try {
            m.checkNotNullExpressionValue(fileOutputStreamStartWrite, "stream");
            fileOutputStreamStartWrite.write(bArr);
            atomicFile.finishWrite(fileOutputStreamStartWrite);
        } catch (Throwable th) {
            atomicFile.failWrite(fileOutputStreamStartWrite);
            throw th;
        }
    }

    @RequiresApi(17)
    public static final void writeText(android.util.AtomicFile atomicFile, String str, Charset charset) throws IOException {
        m.checkNotNullParameter(atomicFile, "<this>");
        m.checkNotNullParameter(str, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        m.checkNotNullParameter(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        m.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        writeBytes(atomicFile, bytes);
    }

    public static /* synthetic */ void writeText$default(android.util.AtomicFile atomicFile, String str, Charset charset, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            charset = c.a;
        }
        writeText(atomicFile, str, charset);
    }
}
