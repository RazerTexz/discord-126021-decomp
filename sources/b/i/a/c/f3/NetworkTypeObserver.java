package b.i.a.c.f3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: renamed from: b.i.a.c.f3.v, reason: use source file name */
/* JADX INFO: compiled from: NetworkTypeObserver.java */
/* JADX INFO: loaded from: classes3.dex */
public final class NetworkTypeObserver {

    @Nullable
    public static NetworkTypeObserver a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f982b = new Handler(Looper.getMainLooper());
    public final CopyOnWriteArrayList<WeakReference<b>> c = new CopyOnWriteArrayList<>();
    public final Object d = new Object();

    @GuardedBy("networkTypeLock")
    public int e = 0;

    /* JADX INFO: renamed from: b.i.a.c.f3.v$b */
    /* JADX INFO: compiled from: NetworkTypeObserver.java */
    public interface b {
        void a(int i);
    }

    /* JADX INFO: renamed from: b.i.a.c.f3.v$c */
    /* JADX INFO: compiled from: NetworkTypeObserver.java */
    public final class c extends BroadcastReceiver {
        public c(a aVar) {
        }

        /* JADX WARN: Code duplicated, block: B:19:0x0036  */
        /* JADX WARN: Code duplicated, block: B:21:0x003d  */
        /* JADX WARN: Code duplicated, block: B:22:0x003f  */
        /* JADX WARN: Code duplicated, block: B:25:0x0044  */
        /* JADX WARN: Code duplicated, block: B:26:0x0046  */
        /* JADX WARN: Code duplicated, block: B:27:0x0048  */
        /* JADX WARN: Code duplicated, block: B:28:0x004a  */
        /* JADX WARN: Code duplicated, block: B:30:0x004e  */
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            int i = 9;
            if (connectivityManager == null) {
                i = 0;
            } else {
                try {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                        i = 1;
                    } else {
                        int type = activeNetworkInfo.getType();
                        if (type == 0) {
                            switch (activeNetworkInfo.getSubtype()) {
                                case 1:
                                case 2:
                                    i = 3;
                                    break;
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 14:
                                case 15:
                                case 17:
                                    i = 4;
                                    break;
                                case 13:
                                    i = 5;
                                    break;
                                case 16:
                                case 19:
                                default:
                                    i = 6;
                                    break;
                                case 18:
                                    i = 2;
                                    break;
                                case 20:
                                    if (Util2.a < 29) {
                                        i = 0;
                                    }
                                    break;
                            }
                        } else if (type == 1) {
                            i = 2;
                        } else if (type == 4 || type == 5) {
                            switch (activeNetworkInfo.getSubtype()) {
                                case 1:
                                case 2:
                                    i = 3;
                                    break;
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 14:
                                case 15:
                                case 17:
                                    i = 4;
                                    break;
                                case 13:
                                    i = 5;
                                    break;
                                case 16:
                                case 19:
                                default:
                                    i = 6;
                                    break;
                                case 18:
                                    i = 2;
                                    break;
                                case 20:
                                    if (Util2.a < 29) {
                                        i = 0;
                                    }
                                    break;
                            }
                        } else if (type != 6) {
                            i = type != 9 ? 8 : 7;
                        } else {
                            i = 5;
                        }
                    }
                } catch (SecurityException unused) {
                }
            }
            int i2 = Util2.a;
            if (i2 >= 29 && i == 5) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    Objects.requireNonNull(telephonyManager);
                    d dVar = NetworkTypeObserver.this.new d(null);
                    if (i2 < 31) {
                        telephonyManager.listen(dVar, 1);
                    } else {
                        telephonyManager.listen(dVar, 1048576);
                    }
                    telephonyManager.listen(dVar, 0);
                    return;
                } catch (RuntimeException unused2) {
                }
            }
            NetworkTypeObserver.a(NetworkTypeObserver.this, i);
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.f3.v$d */
    /* JADX INFO: compiled from: NetworkTypeObserver.java */
    public class d extends PhoneStateListener {
        public d(a aVar) {
        }

        @Override // android.telephony.PhoneStateListener
        @RequiresApi(31)
        public void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
            int overrideNetworkType = telephonyDisplayInfo.getOverrideNetworkType();
            NetworkTypeObserver.a(NetworkTypeObserver.this, overrideNetworkType == 3 || overrideNetworkType == 4 ? 10 : 5);
        }

        @Override // android.telephony.PhoneStateListener
        public void onServiceStateChanged(@Nullable ServiceState serviceState) {
            String string = serviceState == null ? "" : serviceState.toString();
            NetworkTypeObserver.a(NetworkTypeObserver.this, string.contains("nrState=CONNECTED") || string.contains("nrState=NOT_RESTRICTED") ? 10 : 5);
        }
    }

    public NetworkTypeObserver(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(new c(null), intentFilter);
    }

    public static void a(NetworkTypeObserver networkTypeObserver, int i) {
        synchronized (networkTypeObserver.d) {
            if (networkTypeObserver.e == i) {
                return;
            }
            networkTypeObserver.e = i;
            for (WeakReference<b> weakReference : networkTypeObserver.c) {
                b bVar = weakReference.get();
                if (bVar != null) {
                    bVar.a(i);
                } else {
                    networkTypeObserver.c.remove(weakReference);
                }
            }
        }
    }
}
