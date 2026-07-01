package androidx.exifinterface.media;

import android.system.ErrnoException;
import android.system.Os;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.io.FileDescriptor;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class ExifInterfaceUtils$Api21Impl {
    private ExifInterfaceUtils$Api21Impl() {
    }

    @DoNotInline
    public static void close(FileDescriptor fileDescriptor) throws ErrnoException {
        Os.close(fileDescriptor);
    }

    @DoNotInline
    public static FileDescriptor dup(FileDescriptor fileDescriptor) throws ErrnoException {
        return Os.dup(fileDescriptor);
    }

    @DoNotInline
    public static long lseek(FileDescriptor fileDescriptor, long j, int i) throws ErrnoException {
        return Os.lseek(fileDescriptor, j, i);
    }
}
