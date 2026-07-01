package b.i.a.f.e;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.RecentlyNonNull;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class a implements ServiceConnection {
    public boolean j = false;
    public final BlockingQueue<IBinder> k = new LinkedBlockingQueue();

    @RecentlyNonNull
    public IBinder a(long j, @RecentlyNonNull TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        b.c.a.a0.d.x("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.j) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.j = true;
        IBinder iBinderPoll = this.k.poll(j, timeUnit);
        if (iBinderPoll != null) {
            return iBinderPoll;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(@RecentlyNonNull ComponentName componentName, @RecentlyNonNull IBinder iBinder) {
        this.k.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(@RecentlyNonNull ComponentName componentName) {
    }
}
