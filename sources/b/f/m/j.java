package b.f.m;

import android.util.Log;
import com.facebook.soloader.SoLoader;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: NativeLoaderToSoLoaderDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class j implements b.f.m.n.b {
    /* JADX WARN: Bottom block not found for handler: all -> 0x00cd */
    @Override // b.f.m.n.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, int i) {
        boolean z2;
        boolean zContains;
        int i2 = ((i & 1) != 0 ? 16 : 0) | 0;
        ReentrantReadWriteLock reentrantReadWriteLock = SoLoader.c;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (SoLoader.d == null) {
                if (!"http://www.android.com/".equals(System.getProperty("java.vendor.url"))) {
                    synchronized (SoLoader.class) {
                        zContains = true ^ SoLoader.h.contains(str);
                        if (zContains) {
                            System.loadLibrary(str);
                        }
                    }
                    reentrantReadWriteLock.readLock().unlock();
                    return zContains;
                }
                reentrantReadWriteLock.readLock().lock();
                try {
                    boolean z3 = SoLoader.d != null;
                    reentrantReadWriteLock.readLock().unlock();
                    if (!z3) {
                        throw new IllegalStateException("SoLoader.init() not yet called");
                    }
                } catch (Throwable th) {
                    SoLoader.c.readLock().unlock();
                    throw th;
                }
                SoLoader.c.readLock().unlock();
                throw th;
            }
            reentrantReadWriteLock.readLock().unlock();
            boolean z4 = SoLoader.l;
            String strMapLibraryName = System.mapLibraryName(str);
            boolean zD = false;
            do {
                try {
                    zD = SoLoader.d(strMapLibraryName, str, null, i2, null);
                    z2 = false;
                } catch (UnsatisfiedLinkError e) {
                    int i3 = SoLoader.e;
                    SoLoader.c.writeLock().lock();
                    try {
                        if (SoLoader.g == null || !SoLoader.g.c()) {
                            z2 = false;
                        } else {
                            Log.w("SoLoader", "sApplicationSoSource updated during load: " + strMapLibraryName + ", attempting load again.");
                            SoLoader.e = SoLoader.e + 1;
                            z2 = true;
                        }
                        SoLoader.c.writeLock().unlock();
                        if (SoLoader.e == i3) {
                            throw e;
                        }
                    } catch (IOException e2) {
                        throw new RuntimeException(e2);
                    }
                }
            } while (z2);
            return zD;
        } catch (Throwable th2) {
            SoLoader.c.readLock().unlock();
            throw th2;
        }
    }
}
