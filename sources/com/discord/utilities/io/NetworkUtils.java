package com.discord.utilities.io;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import androidx.annotation.MainThread;
import androidx.annotation.RequiresPermission;
import androidx.core.app.NotificationCompat;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.string.StringUtils2;
import d0.t._ArraysJvm;
import d0.y.Closeable;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.IOException;
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

    /* JADX INFO: compiled from: NetworkUtils.kt */
    public static final class DownloadManagerEnqueueFailure extends Throwable {
    }

    /* JADX INFO: compiled from: NetworkUtils.kt */
    public static final class DownloadManagerFileNoFound extends Throwable {
    }

    /* JADX INFO: compiled from: NetworkUtils.kt */
    public static final class DownloadManagerNotFound extends Throwable {
    }

    /* JADX INFO: compiled from: NetworkUtils.kt */
    public static final class NetworkDownloadReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics3.checkNotNullParameter(context, "context");
            String action = intent != null ? intent.getAction() : null;
            if (action != null && action.hashCode() == 1248865515 && action.equals("android.intent.action.DOWNLOAD_COMPLETE")) {
                Function0 function0 = (Function0) NetworkUtils.access$getOnDownloadListeners$p(NetworkUtils.INSTANCE).get(Long.valueOf(intent.getLongExtra("extra_download_id", 0L)));
                if (function0 != null) {
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.io.NetworkUtils$downloadFile$1, reason: invalid class name */
    /* JADX INFO: compiled from: NetworkUtils.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $downloadId;
        public final /* synthetic */ DownloadManager $manager;
        public final /* synthetic */ Function1 $onError;
        public final /* synthetic */ Function1 $onSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, DownloadManager downloadManager, Function1 function1, Function1 function2) {
            super(0);
            this.$downloadId = j;
            this.$manager = downloadManager;
            this.$onSuccess = function1;
            this.$onError = function2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws IOException {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws IOException {
            Cursor cursorQuery;
            NetworkUtils.access$getOnDownloadListeners$p(NetworkUtils.INSTANCE).remove(Long.valueOf(this.$downloadId));
            DownloadManager downloadManager = this.$manager;
            if (downloadManager == null || (cursorQuery = downloadManager.query(new DownloadManager.Query().setFilterById(this.$downloadId))) == null) {
                return;
            }
            try {
                if (cursorQuery.moveToFirst()) {
                    int columnIndex = cursorQuery.getColumnIndex("title");
                    String string = columnIndex > 0 ? cursorQuery.getString(columnIndex) : "";
                    Function1 function1 = this.$onSuccess;
                    Intrinsics3.checkNotNullExpressionValue(string, "downloadedFileName");
                    function1.invoke(string);
                } else {
                    this.$onError.invoke(new DownloadManagerFileNoFound());
                }
                Closeable.closeFinally(cursorQuery, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    Closeable.closeFinally(cursorQuery, th);
                    throw th2;
                }
            }
        }
    }

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
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics3.checkNotNullParameter(onError, "onError");
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
            DownloadManager.Request notificationVisibility = new DownloadManager.Request(uri).setTitle(fileName).setDescription(desc).setNotificationVisibility(1);
            String str = Environment.DIRECTORY_DOWNLOADS;
            if (fileName == null || (strFilenameSanitized = StringUtils2.filenameSanitized(fileName)) == null) {
                strFilenameSanitized = "file";
            }
            DownloadManager.Request destinationInExternalPublicDir = notificationVisibility.setDestinationInExternalPublicDir(str, strFilenameSanitized);
            destinationInExternalPublicDir.allowScanningByMediaScanner();
            jEnqueue = downloadManager.enqueue(destinationInExternalPublicDir);
        } else {
            jEnqueue = 1;
        }
        if (jEnqueue == 1) {
            onError.invoke(new DownloadManagerNotFound());
        } else if (jEnqueue == 0) {
            onError.invoke(new DownloadManagerEnqueueFailure());
        } else {
            onDownloadListeners.put(Long.valueOf(jEnqueue), new AnonymousClass1(jEnqueue, downloadManager, onSuccess, onError));
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
        Intrinsics3.checkNotNullParameter(context, "context");
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
        Intrinsics3.checkNotNullParameter(context, "context");
        return Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
    }

    public final boolean isDeviceConnected(Context context, Intent intent, Logger logger) {
        Intrinsics3.checkNotNullParameter(context, "context");
        try {
            Object systemService = context.getSystemService("connectivity");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            Object obj = null;
            if (Build.VERSION.SDK_INT >= 23) {
                Network[] allNetworks = connectivityManager.getAllNetworks();
                Intrinsics3.checkNotNullExpressionValue(allNetworks, "connectivityManager.allNetworks");
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
                Intrinsics3.checkNotNullExpressionValue(allNetworks2, "connectivityManager.allNetworks");
                ArrayList arrayList = new ArrayList(allNetworks2.length);
                for (Network network2 : allNetworks2) {
                    arrayList.add(connectivityManager.getNetworkInfo(network2));
                }
                Object[] objArrPlus = _ArraysJvm.plus(networkInfoArr, arrayList);
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
