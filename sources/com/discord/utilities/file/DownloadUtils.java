package com.discord.utilities.file;

import android.content.Context;
import androidx.annotation.RequiresPermission;
import com.discord.utilities.auth.GoogleSmartLockManager;
import d0.z.d.m;
import java.io.File;
import rx.Emitter$BackpressureMode;
import rx.Observable;

/* JADX INFO: compiled from: DownloadUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DownloadUtils {
    public static final DownloadUtils INSTANCE = new DownloadUtils();

    private DownloadUtils() {
    }

    @RequiresPermission(conditional = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, value = "android.permission.WRITE_EXTERNAL_STORAGE")
    public static final Observable<DownloadUtils$DownloadState> downloadFile(Context context, String fileUrl, String fileName, File downloadDirectory) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(fileUrl, "fileUrl");
        m.checkNotNullParameter(fileName, "fileName");
        m.checkNotNullParameter(downloadDirectory, "downloadDirectory");
        Observable<DownloadUtils$DownloadState> observableO = Observable.o(new DownloadUtils$downloadFile$1(fileUrl, downloadDirectory, fileName), Emitter$BackpressureMode.BUFFER);
        m.checkNotNullExpressionValue(observableO, "Observable.create({ emit….BackpressureMode.BUFFER)");
        return observableO;
    }

    public static /* synthetic */ Observable downloadFile$default(Context context, String str, String str2, File file, int i, Object obj) {
        if ((i & 8) != 0) {
            file = context.getCacheDir();
            m.checkNotNullExpressionValue(file, "context.cacheDir");
        }
        return downloadFile(context, str, str2, file);
    }
}
