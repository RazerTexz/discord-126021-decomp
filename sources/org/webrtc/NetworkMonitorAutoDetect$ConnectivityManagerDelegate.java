package org.webrtc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager$NetworkCallback;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest$Builder;
import android.os.Build$VERSION;
import androidx.annotation.Nullable;
import b.d.b.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkMonitorAutoDetect$ConnectivityManagerDelegate {

    @Nullable
    private final ConnectivityManager connectivityManager;

    public NetworkMonitorAutoDetect$ConnectivityManagerDelegate(Context context) {
        this.connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
    }

    public static /* synthetic */ NetworkChangeDetector$NetworkInformation access$300(NetworkMonitorAutoDetect$ConnectivityManagerDelegate networkMonitorAutoDetect$ConnectivityManagerDelegate, Network network) {
        return networkMonitorAutoDetect$ConnectivityManagerDelegate.networkToInfo(network);
    }

    @Nullable
    @SuppressLint({"NewApi"})
    private NetworkChangeDetector$NetworkInformation networkToInfo(@Nullable Network network) {
        ConnectivityManager connectivityManager;
        if (network == null || (connectivityManager = this.connectivityManager) == null) {
            return null;
        }
        LinkProperties linkProperties = connectivityManager.getLinkProperties(network);
        if (linkProperties == null) {
            StringBuilder sbU = a.U("Detected unknown network: ");
            sbU.append(network.toString());
            Logging.w("NetworkMonitorAutoDetect", sbU.toString());
            return null;
        }
        if (linkProperties.getInterfaceName() == null) {
            StringBuilder sbU2 = a.U("Null interface name for network ");
            sbU2.append(network.toString());
            Logging.w("NetworkMonitorAutoDetect", sbU2.toString());
            return null;
        }
        NetworkMonitorAutoDetect$NetworkState networkState = getNetworkState(network);
        NetworkChangeDetector$ConnectionType connectionType = NetworkMonitorAutoDetect.getConnectionType(networkState);
        if (connectionType == NetworkChangeDetector$ConnectionType.CONNECTION_NONE) {
            StringBuilder sbU3 = a.U("Network ");
            sbU3.append(network.toString());
            sbU3.append(" is disconnected");
            Logging.d("NetworkMonitorAutoDetect", sbU3.toString());
            return null;
        }
        if (connectionType == NetworkChangeDetector$ConnectionType.CONNECTION_UNKNOWN || connectionType == NetworkChangeDetector$ConnectionType.CONNECTION_UNKNOWN_CELLULAR) {
            StringBuilder sbU4 = a.U("Network ");
            sbU4.append(network.toString());
            sbU4.append(" connection type is ");
            sbU4.append(connectionType);
            sbU4.append(" because it has type ");
            sbU4.append(networkState.getNetworkType());
            sbU4.append(" and subtype ");
            sbU4.append(networkState.getNetworkSubType());
            Logging.d("NetworkMonitorAutoDetect", sbU4.toString());
        }
        return new NetworkChangeDetector$NetworkInformation(linkProperties.getInterfaceName(), connectionType, NetworkMonitorAutoDetect.access$400(networkState), NetworkMonitorAutoDetect.access$000(network), getIPAddresses(linkProperties));
    }

    @Nullable
    public List<NetworkChangeDetector$NetworkInformation> getActiveNetworkList() {
        if (!supportNetworkCallback()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Network network : getAllNetworks()) {
            NetworkChangeDetector$NetworkInformation networkChangeDetector$NetworkInformationNetworkToInfo = networkToInfo(network);
            if (networkChangeDetector$NetworkInformationNetworkToInfo != null) {
                arrayList.add(networkChangeDetector$NetworkInformationNetworkToInfo);
            }
        }
        return arrayList;
    }

    @SuppressLint({"NewApi"})
    public Network[] getAllNetworks() {
        ConnectivityManager connectivityManager = this.connectivityManager;
        return connectivityManager == null ? new Network[0] : connectivityManager.getAllNetworks();
    }

    @SuppressLint({"NewApi"})
    public long getDefaultNetId() {
        NetworkInfo activeNetworkInfo;
        NetworkInfo networkInfo;
        if (!supportNetworkCallback() || (activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo()) == null) {
            return -1L;
        }
        long jAccess$000 = -1;
        for (Network network : getAllNetworks()) {
            if (hasInternetCapability(network) && (networkInfo = this.connectivityManager.getNetworkInfo(network)) != null && networkInfo.getType() == activeNetworkInfo.getType()) {
                if (jAccess$000 != -1) {
                    throw new RuntimeException("Multiple connected networks of same type are not supported.");
                }
                jAccess$000 = NetworkMonitorAutoDetect.access$000(network);
            }
        }
        return jAccess$000;
    }

    @SuppressLint({"NewApi"})
    public NetworkChangeDetector$IPAddress[] getIPAddresses(LinkProperties linkProperties) {
        NetworkChangeDetector$IPAddress[] networkChangeDetector$IPAddressArr = new NetworkChangeDetector$IPAddress[linkProperties.getLinkAddresses().size()];
        Iterator<LinkAddress> it = linkProperties.getLinkAddresses().iterator();
        int i = 0;
        while (it.hasNext()) {
            networkChangeDetector$IPAddressArr[i] = new NetworkChangeDetector$IPAddress(it.next().getAddress().getAddress());
            i++;
        }
        return networkChangeDetector$IPAddressArr;
    }

    public NetworkMonitorAutoDetect$NetworkState getNetworkState() {
        ConnectivityManager connectivityManager = this.connectivityManager;
        return connectivityManager == null ? new NetworkMonitorAutoDetect$NetworkState(false, -1, -1, -1, -1) : getNetworkState(connectivityManager.getActiveNetworkInfo());
    }

    @SuppressLint({"NewApi"})
    public boolean hasInternetCapability(Network network) {
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = this.connectivityManager;
        return (connectivityManager == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(network)) == null || !networkCapabilities.hasCapability(12)) ? false : true;
    }

    @SuppressLint({"NewApi"})
    public void registerNetworkCallback(ConnectivityManager$NetworkCallback connectivityManager$NetworkCallback) {
        this.connectivityManager.registerNetworkCallback(new NetworkRequest$Builder().addCapability(12).build(), connectivityManager$NetworkCallback);
    }

    @SuppressLint({"NewApi"})
    public void releaseCallback(ConnectivityManager$NetworkCallback connectivityManager$NetworkCallback) {
        if (supportNetworkCallback()) {
            Logging.d("NetworkMonitorAutoDetect", "Unregister network callback");
            this.connectivityManager.unregisterNetworkCallback(connectivityManager$NetworkCallback);
        }
    }

    @SuppressLint({"NewApi"})
    public void requestMobileNetwork(ConnectivityManager$NetworkCallback connectivityManager$NetworkCallback) {
        NetworkRequest$Builder networkRequest$Builder = new NetworkRequest$Builder();
        networkRequest$Builder.addCapability(12).addTransportType(0);
        this.connectivityManager.requestNetwork(networkRequest$Builder.build(), connectivityManager$NetworkCallback);
    }

    public boolean supportNetworkCallback() {
        return this.connectivityManager != null;
    }

    public NetworkMonitorAutoDetect$ConnectivityManagerDelegate() {
        this.connectivityManager = null;
    }

    @SuppressLint({"NewApi"})
    public NetworkMonitorAutoDetect$NetworkState getNetworkState(@Nullable Network network) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (network != null && (connectivityManager = this.connectivityManager) != null) {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(network);
            if (networkInfo == null) {
                StringBuilder sbU = a.U("Couldn't retrieve information from network ");
                sbU.append(network.toString());
                Logging.w("NetworkMonitorAutoDetect", sbU.toString());
                return new NetworkMonitorAutoDetect$NetworkState(false, -1, -1, -1, -1);
            }
            if (networkInfo.getType() != 17) {
                NetworkCapabilities networkCapabilities = this.connectivityManager.getNetworkCapabilities(network);
                if (networkCapabilities != null && networkCapabilities.hasTransport(4)) {
                    return new NetworkMonitorAutoDetect$NetworkState(networkInfo.isConnected(), 17, -1, networkInfo.getType(), networkInfo.getSubtype());
                }
                return getNetworkState(networkInfo);
            }
            if (networkInfo.getType() == 17) {
                if (Build$VERSION.SDK_INT >= 23 && network.equals(this.connectivityManager.getActiveNetwork()) && (activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.getType() != 17) {
                    return new NetworkMonitorAutoDetect$NetworkState(networkInfo.isConnected(), 17, -1, activeNetworkInfo.getType(), activeNetworkInfo.getSubtype());
                }
                return new NetworkMonitorAutoDetect$NetworkState(networkInfo.isConnected(), 17, -1, -1, -1);
            }
            return getNetworkState(networkInfo);
        }
        return new NetworkMonitorAutoDetect$NetworkState(false, -1, -1, -1, -1);
    }

    private NetworkMonitorAutoDetect$NetworkState getNetworkState(@Nullable NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isConnected()) {
            return new NetworkMonitorAutoDetect$NetworkState(true, networkInfo.getType(), networkInfo.getSubtype(), -1, -1);
        }
        return new NetworkMonitorAutoDetect$NetworkState(false, -1, -1, -1, -1);
    }
}
