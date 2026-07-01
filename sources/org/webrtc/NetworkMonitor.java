package org.webrtc;

import android.content.Context;
import android.os.Build$VERSION;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkMonitor {
    private static final String TAG = "NetworkMonitor";
    private volatile NetworkChangeDetector$ConnectionType currentConnectionType;
    private final ArrayList<Long> nativeNetworkObservers;

    @Nullable
    private NetworkChangeDetector networkChangeDetector;
    private NetworkChangeDetectorFactory networkChangeDetectorFactory;
    private final Object networkChangeDetectorLock;
    private final ArrayList<NetworkMonitor$NetworkObserver> networkObservers;
    private int numObservers;

    public /* synthetic */ NetworkMonitor(NetworkMonitor$1 networkMonitor$1) {
        this();
    }

    public static /* synthetic */ void access$100(NetworkMonitor networkMonitor, NetworkChangeDetector$ConnectionType networkChangeDetector$ConnectionType) {
        networkMonitor.updateCurrentConnectionType(networkChangeDetector$ConnectionType);
    }

    public static /* synthetic */ void access$200(NetworkMonitor networkMonitor, NetworkChangeDetector$NetworkInformation networkChangeDetector$NetworkInformation) {
        networkMonitor.notifyObserversOfNetworkConnect(networkChangeDetector$NetworkInformation);
    }

    public static /* synthetic */ void access$300(NetworkMonitor networkMonitor, long j) {
        networkMonitor.notifyObserversOfNetworkDisconnect(j);
    }

    public static /* synthetic */ void access$400(NetworkMonitor networkMonitor, List list, int i) {
        networkMonitor.notifyObserversOfNetworkPreference(list, i);
    }

    @Deprecated
    public static void addNetworkObserver(NetworkMonitor$NetworkObserver networkMonitor$NetworkObserver) {
        getInstance().addObserver(networkMonitor$NetworkObserver);
    }

    @CalledByNative
    private static int androidSdkInt() {
        return Build$VERSION.SDK_INT;
    }

    private static void assertIsTrue(boolean z2) {
        if (!z2) {
            throw new AssertionError("Expected to be true");
        }
    }

    public static NetworkMonitorAutoDetect createAndSetAutoDetectForTest(Context context) {
        NetworkMonitor networkMonitor = getInstance();
        NetworkChangeDetector networkChangeDetectorCreateNetworkChangeDetector = networkMonitor.createNetworkChangeDetector(context);
        networkMonitor.networkChangeDetector = networkChangeDetectorCreateNetworkChangeDetector;
        return (NetworkMonitorAutoDetect) networkChangeDetectorCreateNetworkChangeDetector;
    }

    private NetworkChangeDetector createNetworkChangeDetector(Context context) {
        return this.networkChangeDetectorFactory.create(new NetworkMonitor$2(this), context);
    }

    private NetworkChangeDetector$ConnectionType getCurrentConnectionType() {
        return this.currentConnectionType;
    }

    @CalledByNative
    public static NetworkMonitor getInstance() {
        return NetworkMonitor$InstanceHolder.instance;
    }

    private List<Long> getNativeNetworkObserversSync() {
        ArrayList arrayList;
        synchronized (this.nativeNetworkObservers) {
            arrayList = new ArrayList(this.nativeNetworkObservers);
        }
        return arrayList;
    }

    @Deprecated
    public static void init(Context context) {
    }

    public static boolean isOnline() {
        return getInstance().getCurrentConnectionType() != NetworkChangeDetector$ConnectionType.CONNECTION_NONE;
    }

    private native void nativeNotifyConnectionTypeChanged(long j);

    private native void nativeNotifyOfActiveNetworkList(long j, NetworkChangeDetector$NetworkInformation[] networkChangeDetector$NetworkInformationArr);

    private native void nativeNotifyOfNetworkConnect(long j, NetworkChangeDetector$NetworkInformation networkChangeDetector$NetworkInformation);

    private native void nativeNotifyOfNetworkDisconnect(long j, long j2);

    private native void nativeNotifyOfNetworkPreference(long j, NetworkChangeDetector$ConnectionType networkChangeDetector$ConnectionType, int i);

    @CalledByNative
    private boolean networkBindingSupported() {
        boolean z2;
        synchronized (this.networkChangeDetectorLock) {
            NetworkChangeDetector networkChangeDetector = this.networkChangeDetector;
            z2 = networkChangeDetector != null && networkChangeDetector.supportNetworkCallback();
        }
        return z2;
    }

    private void notifyObserversOfConnectionTypeChange(NetworkChangeDetector$ConnectionType networkChangeDetector$ConnectionType) {
        ArrayList arrayList;
        Iterator<Long> it = getNativeNetworkObserversSync().iterator();
        while (it.hasNext()) {
            nativeNotifyConnectionTypeChanged(it.next().longValue());
        }
        synchronized (this.networkObservers) {
            arrayList = new ArrayList(this.networkObservers);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((NetworkMonitor$NetworkObserver) it2.next()).onConnectionTypeChanged(networkChangeDetector$ConnectionType);
        }
    }

    private void notifyObserversOfNetworkConnect(NetworkChangeDetector$NetworkInformation networkChangeDetector$NetworkInformation) {
        Iterator<Long> it = getNativeNetworkObserversSync().iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkConnect(it.next().longValue(), networkChangeDetector$NetworkInformation);
        }
    }

    private void notifyObserversOfNetworkDisconnect(long j) {
        Iterator<Long> it = getNativeNetworkObserversSync().iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkDisconnect(it.next().longValue(), j);
        }
    }

    private void notifyObserversOfNetworkPreference(List<NetworkChangeDetector$ConnectionType> list, int i) {
        List<Long> nativeNetworkObserversSync = getNativeNetworkObserversSync();
        for (NetworkChangeDetector$ConnectionType networkChangeDetector$ConnectionType : list) {
            Iterator<Long> it = nativeNetworkObserversSync.iterator();
            while (it.hasNext()) {
                nativeNotifyOfNetworkPreference(it.next().longValue(), networkChangeDetector$ConnectionType, i);
            }
        }
    }

    @Deprecated
    public static void removeNetworkObserver(NetworkMonitor$NetworkObserver networkMonitor$NetworkObserver) {
        getInstance().removeObserver(networkMonitor$NetworkObserver);
    }

    private void updateCurrentConnectionType(NetworkChangeDetector$ConnectionType networkChangeDetector$ConnectionType) {
        this.currentConnectionType = networkChangeDetector$ConnectionType;
        notifyObserversOfConnectionTypeChange(networkChangeDetector$ConnectionType);
    }

    private void updateObserverActiveNetworkList(long j) {
        List<NetworkChangeDetector$NetworkInformation> activeNetworkList;
        synchronized (this.networkChangeDetectorLock) {
            NetworkChangeDetector networkChangeDetector = this.networkChangeDetector;
            activeNetworkList = networkChangeDetector == null ? null : networkChangeDetector.getActiveNetworkList();
        }
        if (activeNetworkList == null || activeNetworkList.size() == 0) {
            return;
        }
        nativeNotifyOfActiveNetworkList(j, (NetworkChangeDetector$NetworkInformation[]) activeNetworkList.toArray(new NetworkChangeDetector$NetworkInformation[activeNetworkList.size()]));
    }

    public void addObserver(NetworkMonitor$NetworkObserver networkMonitor$NetworkObserver) {
        synchronized (this.networkObservers) {
            this.networkObservers.add(networkMonitor$NetworkObserver);
        }
    }

    @Nullable
    public NetworkChangeDetector getNetworkChangeDetector() {
        NetworkChangeDetector networkChangeDetector;
        synchronized (this.networkChangeDetectorLock) {
            networkChangeDetector = this.networkChangeDetector;
        }
        return networkChangeDetector;
    }

    public int getNumObservers() {
        int i;
        synchronized (this.networkChangeDetectorLock) {
            i = this.numObservers;
        }
        return i;
    }

    public void removeObserver(NetworkMonitor$NetworkObserver networkMonitor$NetworkObserver) {
        synchronized (this.networkObservers) {
            this.networkObservers.remove(networkMonitor$NetworkObserver);
        }
    }

    public void setNetworkChangeDetectorFactory(NetworkChangeDetectorFactory networkChangeDetectorFactory) {
        assertIsTrue(this.numObservers == 0);
        this.networkChangeDetectorFactory = networkChangeDetectorFactory;
    }

    public void startMonitoring(Context context) {
        synchronized (this.networkChangeDetectorLock) {
            this.numObservers++;
            if (this.networkChangeDetector == null) {
                this.networkChangeDetector = createNetworkChangeDetector(context);
            }
            this.currentConnectionType = this.networkChangeDetector.getCurrentConnectionType();
        }
    }

    public void stopMonitoring() {
        synchronized (this.networkChangeDetectorLock) {
            int i = this.numObservers - 1;
            this.numObservers = i;
            if (i == 0) {
                this.networkChangeDetector.destroy();
                this.networkChangeDetector = null;
            }
        }
    }

    private NetworkMonitor() {
        this.networkChangeDetectorFactory = new NetworkMonitor$1(this);
        this.networkChangeDetectorLock = new Object();
        this.nativeNetworkObservers = new ArrayList<>();
        this.networkObservers = new ArrayList<>();
        this.numObservers = 0;
        this.currentConnectionType = NetworkChangeDetector$ConnectionType.CONNECTION_UNKNOWN;
    }

    @CalledByNative
    private void stopMonitoring(long j) {
        Logging.d(TAG, "Stop monitoring with native observer " + j);
        stopMonitoring();
        synchronized (this.nativeNetworkObservers) {
            this.nativeNetworkObservers.remove(Long.valueOf(j));
        }
    }

    @Deprecated
    public void startMonitoring() {
        startMonitoring(ContextUtils.getApplicationContext());
    }

    @CalledByNative
    private void startMonitoring(@Nullable Context context, long j) {
        Logging.d(TAG, "Start monitoring with native observer " + j);
        if (context == null) {
            context = ContextUtils.getApplicationContext();
        }
        startMonitoring(context);
        synchronized (this.nativeNetworkObservers) {
            this.nativeNetworkObservers.add(Long.valueOf(j));
        }
        updateObserverActiveNetworkList(j);
        notifyObserversOfConnectionTypeChange(this.currentConnectionType);
    }
}
