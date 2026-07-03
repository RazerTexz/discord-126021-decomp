package p007b.p225i.p361c.p401u;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

/* JADX INFO: renamed from: b.i.c.u.b */
/* JADX INFO: compiled from: CrossProcessLock.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4838b {

    /* JADX INFO: renamed from: a */
    public final FileChannel f12921a;

    /* JADX INFO: renamed from: b */
    public final FileLock f12922b;

    public C4838b(FileChannel fileChannel, FileLock fileLock) {
        this.f12921a = fileChannel;
        this.f12922b = fileLock;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    public static C4838b m6753a(Context context, String str) {
        Throwable e;
        FileChannel channel;
        FileLock fileLockLock;
        try {
            channel = new RandomAccessFile(new File(context.getFilesDir(), str), "rw").getChannel();
            try {
                fileLockLock = channel.lock();
                try {
                    return new C4838b(channel, fileLockLock);
                } catch (IOException e2) {
                    e = e2;
                    Log.e("CrossProcessLock", "encountered error while creating and acquiring the lock, ignoring", e);
                    if (fileLockLock != null) {
                        try {
                            fileLockLock.release();
                        } catch (IOException unused) {
                        }
                    }
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return null;
                } catch (Error e3) {
                    e = e3;
                    Log.e("CrossProcessLock", "encountered error while creating and acquiring the lock, ignoring", e);
                    if (fileLockLock != null) {
                        fileLockLock.release();
                    }
                    if (channel != null) {
                        channel.close();
                    }
                    return null;
                } catch (OverlappingFileLockException e4) {
                    e = e4;
                    Log.e("CrossProcessLock", "encountered error while creating and acquiring the lock, ignoring", e);
                    if (fileLockLock != null) {
                        fileLockLock.release();
                    }
                    if (channel != null) {
                        channel.close();
                    }
                    return null;
                }
            } catch (IOException | Error | OverlappingFileLockException e5) {
                e = e5;
                fileLockLock = null;
            }
        } catch (IOException | Error | OverlappingFileLockException e6) {
            e = e6;
            channel = null;
            fileLockLock = null;
        }
    }

    /* JADX INFO: renamed from: b */
    public void m6754b() {
        try {
            this.f12922b.release();
            this.f12921a.close();
        } catch (IOException e) {
            Log.e("CrossProcessLock", "encountered error while releasing, ignoring", e);
        }
    }
}
