package com.discord.utilities.file;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.io.File;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Emitter;
import rx.functions.Action1;

/* JADX INFO: compiled from: DownloadUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DownloadUtils$downloadFile$1<T> implements Action1<Emitter<DownloadUtils$DownloadState>> {
    public final /* synthetic */ File $downloadDirectory;
    public final /* synthetic */ String $fileName;
    public final /* synthetic */ String $fileUrl;

    public DownloadUtils$downloadFile$1(String str, File file, String str2) {
        this.$fileUrl = str;
        this.$downloadDirectory = file;
        this.$fileName = str2;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Emitter<DownloadUtils$DownloadState> emitter) {
        call2(emitter);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Emitter<DownloadUtils$DownloadState> emitter) {
        m.checkNotNullParameter(emitter, "emitter");
        emitter.onNext(new DownloadUtils$DownloadState$InProgress(0.0f));
        ObservableExtensionsKt.appSubscribe$default(RestAPI.Companion.getApiFiles().getFile(this.$fileUrl), DownloadUtils.INSTANCE.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new DownloadUtils$downloadFile$1$1(this, emitter), 62, (Object) null);
    }
}
