package p007b.p225i.p361c.p406w;

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
import p007b.p225i.p226a.p288f.p313h.p322i.C3489c;

/* JADX INFO: renamed from: b.i.c.w.o */
/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C4877o implements Closeable {

    /* JADX INFO: renamed from: j */
    public final URL f13034j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public Task<Bitmap> f13035k;

    /* JADX INFO: renamed from: l */
    @Nullable
    public volatile InputStream f13036l;

    public C4877o(URL url) {
        this.f13034j = url;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            InputStream inputStream = this.f13036l;
            Logger logger = C3489c.f9653a;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    try {
                        C3489c.f9653a.logp(Level.WARNING, "com.google.common.io.Closeables", "close", "IOException thrown while closing Closeable.", (Throwable) e);
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
