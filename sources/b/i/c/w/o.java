package b.i.c.w;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class o implements Closeable {
    public final URL j;

    @Nullable
    public Task<Bitmap> k;

    @Nullable
    public volatile InputStream l;

    public o(URL url) {
        this.j = url;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            InputStream inputStream = this.l;
            Logger logger = b.i.a.f.h.i.c.a;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    try {
                        b.i.a.f.h.i.c.a.logp(Level.WARNING, "com.google.common.io.Closeables", "close", "IOException thrown while closing Closeable.", (Throwable) e);
                    } catch (IOException e2) {
                        throw new AssertionError(e2);
                    }
                }
            }
        } catch (NullPointerException e3) {
            Log.e("FirebaseMessaging", "Failed to close the image download stream.", e3);
        }
    }
}
