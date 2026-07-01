package com.discord.utilities.io;

import android.app.DownloadManager;
import android.app.DownloadManager$Request;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build$VERSION;
import android.os.Environment;
import android.provider.Settings$Global;
import androidx.annotation.MainThread;
import androidx.annotation.RequiresPermission;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.string.StringUtilsKt;
import d0.t.j;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: NetworkUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NetworkUtils {
    public static final NetworkUtils INSTANCE = new NetworkUtils();
    private static final Map<Long, Function0<Unit>> onDownloadListeners = new LinkedHashMap();

    private NetworkUtils() {
    }

    public static final /* synthetic */ Map access$getOnDownloadListeners$p(NetworkUtils networkUtils) {
        return onDownloadListeners;
    }

    @RequiresPermission(conditional = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, value = "android.permission.WRITE_EXTERNAL_STORAGE")
    @MainThread
    public static final void downloadFile(Context context, Uri uri, String fileName, String desc, Function1<? super String, Unit> onSuccess, Function1<? super Throwable, Unit> onError) {
        long jEnqueue;
        String strFilenameSanitized;
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(onSuccess, "onSuccess");
        m.checkNotNullParameter(onError, "onError");
        Object systemService = context != null ? context.getSystemService("download") : null;
        DownloadManager downloadManager = (DownloadManager) (systemService instanceof DownloadManager ? systemService : null);
        if (downloadManager != null) {
            if (fileName == null) {
                try {
                    fileName = uri.getLastPathSegment();
                } catch (Exception e) {
                    onError.invoke(e);
                    return;
                }
            }
            DownloadManager$Request notificationVisibility = new DownloadManager$Request(uri).setTitle(fileName).setDescription(desc).setNotificationVisibility(1);
            String str = Environment.DIRECTORY_DOWNLOADS;
            if (fileName == null || (strFilenameSanitized = StringUtilsKt.filenameSanitized(fileName)) == null) {
                strFilenameSanitized = "file";
            }
            DownloadManager$Request destinationInExternalPublicDir = notificationVisibility.setDestinationInExternalPublicDir(str, strFilenameSanitized);
            destinationInExternalPublicDir.allowScanningByMediaScanner();
            jEnqueue = downloadManager.enqueue(destinationInExternalPublicDir);
        } else {
            jEnqueue = 1;
        }
        if (jEnqueue == 1) {
            onError.invoke(new NetworkUtils$DownloadManagerNotFound());
        } else if (jEnqueue == 0) {
            onError.invoke(new NetworkUtils$DownloadManagerEnqueueFailure());
        } else {
            onDownloadListeners.put(Long.valueOf(jEnqueue), new NetworkUtils$downloadFile$1(jEnqueue, downloadManager, onSuccess, onError));
        }
    }

    public static /* synthetic */ boolean isDeviceConnected$default(NetworkUtils networkUtils, Context context, Intent intent, Logger logger, int i, Object obj) {
        if ((i & 2) != 0) {
            intent = null;
        }
        if ((i & 4) != 0) {
            logger = null;
        }
        return networkUtils.isDeviceConnected(context, intent, logger);
    }

    public final Integer getNetworkType(Context context) {
        m.checkNotNullParameter(context, "context");
        try {
            Object systemService = context.getSystemService("connectivity");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return Integer.valueOf(activeNetworkInfo.getType());
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public final boolean isAirplaneModeOn(Context context) {
        m.checkNotNullParameter(context, "context");
        return Settings$Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
    }

    public final boolean isDeviceConnected(Context context, Intent intent, Logger logger) {
        m.checkNotNullParameter(context, "context");
        try {
            Object systemService = context.getSystemService("connectivity");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            Object obj = null;
            if (Build$VERSION.SDK_INT >= 23) {
                Network[] allNetworks = connectivityManager.getAllNetworks();
                m.checkNotNullExpressionValue(allNetworks, "connectivityManager.allNetworks");
                for (Network network : allNetworks) {
                    NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
                    if ((networkCapabilities != null && networkCapabilities.hasCapability(12)) || (networkCapabilities != null && networkCapabilities.hasTransport(1)) || ((networkCapabilities != null && networkCapabilities.hasTransport(0)) || ((networkCapabilities != null && networkCapabilities.hasTransport(3)) || (networkCapabilities != null && networkCapabilities.hasTransport(4))))) {
                        obj = network;
                        break;
                    }
                }
                if (obj != null) {
                    return true;
                }
            } else {
                NetworkInfo[] networkInfoArr = {connectivityManager.getActiveNetworkInfo(), intent != null ? (NetworkInfo) intent.getParcelableExtra("networkInfo") : null};
                Network[] allNetworks2 = connectivityManager.getAllNetworks();
                m.checkNotNullExpressionValue(allNetworks2, "connectivityManager.allNetworks");
                ArrayList arrayList = new ArrayList(allNetworks2.length);
                for (Network network2 : allNetworks2) {
                    arrayList.add(connectivityManager.getNetworkInfo(network2));
                }
                Object[] objArrPlus = j.plus(networkInfoArr, arrayList);
                for (Object obj2 : objArrPlus) {
                    NetworkInfo networkInfo = (NetworkInfo) obj2;
                    if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
                        obj = obj2;
                        break;
                    }
                }
                if (((NetworkInfo) obj) != null) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }
}
