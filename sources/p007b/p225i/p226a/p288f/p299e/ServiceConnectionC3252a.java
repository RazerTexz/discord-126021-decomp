package p007b.p225i.p226a.p288f.p299e;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.RecentlyNonNull;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.e.a */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class ServiceConnectionC3252a implements ServiceConnection {

    /* JADX INFO: renamed from: j */
    public boolean f9296j = false;

    /* JADX INFO: renamed from: k */
    public final BlockingQueue<IBinder> f9297k = new LinkedBlockingQueue();

    @RecentlyNonNull
    /* JADX INFO: renamed from: a */
    public IBinder m4014a(long j, @RecentlyNonNull TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        C1460d.m587x("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f9296j) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f9296j = true;
        IBinder iBinderPoll = this.f9297k.poll(j, timeUnit);
        if (iBinderPoll != null) {
            return iBinderPoll;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(@RecentlyNonNull ComponentName componentName, @RecentlyNonNull IBinder iBinder) {
        this.f9297k.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(@RecentlyNonNull ComponentName componentName) {
    }
}
