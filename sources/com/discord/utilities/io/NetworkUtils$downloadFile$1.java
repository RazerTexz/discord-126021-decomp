package com.discord.utilities.io;

import android.app.DownloadManager;
import android.app.DownloadManager$Query;
import android.database.Cursor;
import d0.y.b;
import d0.z.d.m;
import d0.z.d.o;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: NetworkUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NetworkUtils$downloadFile$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $downloadId;
    public final /* synthetic */ DownloadManager $manager;
    public final /* synthetic */ Function1 $onError;
    public final /* synthetic */ Function1 $onSuccess;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkUtils$downloadFile$1(long j, DownloadManager downloadManager, Function1 function1, Function1 function2) {
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
        if (downloadManager == null || (cursorQuery = downloadManager.query(new DownloadManager$Query().setFilterById(this.$downloadId))) == null) {
            return;
        }
        try {
            if (cursorQuery.moveToFirst()) {
                int columnIndex = cursorQuery.getColumnIndex("title");
                String string = columnIndex > 0 ? cursorQuery.getString(columnIndex) : "";
                Function1 function1 = this.$onSuccess;
                m.checkNotNullExpressionValue(string, "downloadedFileName");
                function1.invoke(string);
            } else {
                this.$onError.invoke(new NetworkUtils$DownloadManagerFileNoFound());
            }
            b.closeFinally(cursorQuery, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                b.closeFinally(cursorQuery, th);
                throw th2;
            }
        }
    }
}
