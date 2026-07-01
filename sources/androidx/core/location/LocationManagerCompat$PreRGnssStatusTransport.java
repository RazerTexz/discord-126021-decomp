package androidx.core.location;

import android.location.GnssStatus;
import android.location.GnssStatus$Callback;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
public class LocationManagerCompat$PreRGnssStatusTransport extends GnssStatus$Callback {
    public final GnssStatusCompat$Callback mCallback;

    @Nullable
    public volatile Executor mExecutor;

    public LocationManagerCompat$PreRGnssStatusTransport(GnssStatusCompat$Callback gnssStatusCompat$Callback) {
        Preconditions.checkArgument(gnssStatusCompat$Callback != null, "invalid null callback");
        this.mCallback = gnssStatusCompat$Callback;
    }

    @Override // android.location.GnssStatus$Callback
    public void onFirstFix(int i) {
        Executor executor = this.mExecutor;
        if (executor == null) {
            return;
        }
        executor.execute(new LocationManagerCompat$PreRGnssStatusTransport$3(this, executor, i));
    }

    @Override // android.location.GnssStatus$Callback
    public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
        Executor executor = this.mExecutor;
        if (executor == null) {
            return;
        }
        executor.execute(new LocationManagerCompat$PreRGnssStatusTransport$4(this, executor, gnssStatus));
    }

    @Override // android.location.GnssStatus$Callback
    public void onStarted() {
        Executor executor = this.mExecutor;
        if (executor == null) {
            return;
        }
        executor.execute(new LocationManagerCompat$PreRGnssStatusTransport$1(this, executor));
    }

    @Override // android.location.GnssStatus$Callback
    public void onStopped() {
        Executor executor = this.mExecutor;
        if (executor == null) {
            return;
        }
        executor.execute(new LocationManagerCompat$PreRGnssStatusTransport$2(this, executor));
    }

    public void register(Executor executor) {
        Preconditions.checkArgument(executor != null, "invalid null executor");
        Preconditions.checkState(this.mExecutor == null);
        this.mExecutor = executor;
    }

    public void unregister() {
        this.mExecutor = null;
    }
}
