package b.i.a.f.e.o.j;

import androidx.annotation.RecentlyNonNull;
import b.c.a.a0.AnimatableValueParser;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class a implements ThreadFactory {
    public final String j;
    public final ThreadFactory k = Executors.defaultThreadFactory();

    public a(@RecentlyNonNull String str) {
        AnimatableValueParser.z(str, "Name must not be null");
        this.j = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    @RecentlyNonNull
    public final Thread newThread(@RecentlyNonNull Runnable runnable) {
        Thread threadNewThread = this.k.newThread(new b(runnable));
        threadNewThread.setName(this.j);
        return threadNewThread;
    }
}
