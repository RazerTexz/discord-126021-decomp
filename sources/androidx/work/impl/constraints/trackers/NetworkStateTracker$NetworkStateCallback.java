package androidx.work.impl.constraints.trackers;

import android.net.ConnectivityManager$NetworkCallback;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.work.Logger;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
public class NetworkStateTracker$NetworkStateCallback extends ConnectivityManager$NetworkCallback {
    public final /* synthetic */ NetworkStateTracker this$0;

    public NetworkStateTracker$NetworkStateCallback(NetworkStateTracker networkStateTracker) {
        this.this$0 = networkStateTracker;
    }

    @Override // android.net.ConnectivityManager$NetworkCallback
    public void onCapabilitiesChanged(@NonNull Network network, @NonNull NetworkCapabilities networkCapabilities) {
        Logger.get().debug(NetworkStateTracker.TAG, String.format("Network capabilities changed: %s", networkCapabilities), new Throwable[0]);
        NetworkStateTracker networkStateTracker = this.this$0;
        networkStateTracker.setState(networkStateTracker.getActiveNetworkState());
    }

    @Override // android.net.ConnectivityManager$NetworkCallback
    public void onLost(@NonNull Network network) {
        Logger.get().debug(NetworkStateTracker.TAG, "Network connection lost", new Throwable[0]);
        NetworkStateTracker networkStateTracker = this.this$0;
        networkStateTracker.setState(networkStateTracker.getActiveNetworkState());
    }
}
