package com.discord.utilities.file;

import d0.z.d.m;
import d0.z.d.o;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import okhttp3.ResponseBody;
import rx.Emitter;

/* JADX INFO: compiled from: DownloadUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DownloadUtils$downloadFile$1$1 extends o implements Function1<ResponseBody, Unit> {
    public final /* synthetic */ Emitter $emitter;
    public final /* synthetic */ DownloadUtils$downloadFile$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadUtils$downloadFile$1$1(DownloadUtils$downloadFile$1 downloadUtils$downloadFile$1, Emitter emitter) {
        super(1);
        this.this$0 = downloadUtils$downloadFile$1;
        this.$emitter = emitter;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ResponseBody responseBody) {
        invoke2(responseBody);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ResponseBody responseBody) {
        m.checkNotNullParameter(responseBody, "responseBody");
        try {
            try {
                DownloadUtils$downloadFile$1 downloadUtils$downloadFile$1 = this.this$0;
                File file = new File(downloadUtils$downloadFile$1.$downloadDirectory, downloadUtils$downloadFile$1.$fileName);
                byte[] bArr = new byte[8192];
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                float fA = responseBody.a();
                int i = 0;
                while (true) {
                    int i2 = responseBody.c().u0().read(bArr);
                    if (i2 == -1) {
                        break;
                    }
                    i += i2;
                    this.$emitter.onNext(new DownloadUtils$DownloadState$InProgress(i / fA));
                    fileOutputStream.write(bArr, 0, i2);
                }
                this.$emitter.onNext(new DownloadUtils$DownloadState$Completed(file));
                this.$emitter.onCompleted();
            } catch (IOException e) {
                e.printStackTrace();
                this.$emitter.onNext(new DownloadUtils$DownloadState$Failure(e));
            }
        } finally {
            responseBody.close();
        }
    }
}
