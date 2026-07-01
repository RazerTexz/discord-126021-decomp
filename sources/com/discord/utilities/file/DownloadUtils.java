package com.discord.utilities.file;

import android.content.Context;
import androidx.annotation.RequiresPermission;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.ResponseBody;
import rx.Emitter;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

/* JADX INFO: compiled from: DownloadUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DownloadUtils {
    public static final DownloadUtils INSTANCE = new DownloadUtils();

    /* JADX INFO: compiled from: DownloadUtils.kt */
    public static abstract class DownloadState {

        /* JADX INFO: compiled from: DownloadUtils.kt */
        public static final class Completed extends DownloadState {
            private final File file;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Completed(File file) {
                super(null);
                Intrinsics3.checkNotNullParameter(file, "file");
                this.file = file;
            }

            public final File getFile() {
                return this.file;
            }
        }

        /* JADX INFO: compiled from: DownloadUtils.kt */
        public static final class Failure extends DownloadState {
            private final Exception exception;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Failure(Exception exc) {
                super(null);
                Intrinsics3.checkNotNullParameter(exc, "exception");
                this.exception = exc;
            }

            public final Exception getException() {
                return this.exception;
            }
        }

        /* JADX INFO: compiled from: DownloadUtils.kt */
        public static final class InProgress extends DownloadState {
            private final float progress;

            public InProgress(float f) {
                super(null);
                this.progress = f;
            }

            public final float getProgress() {
                return this.progress;
            }
        }

        private DownloadState() {
        }

        public /* synthetic */ DownloadState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private DownloadUtils() {
    }

    @RequiresPermission(conditional = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS, value = "android.permission.WRITE_EXTERNAL_STORAGE")
    public static final Observable<DownloadState> downloadFile(Context context, final String fileUrl, final String fileName, final File downloadDirectory) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(fileUrl, "fileUrl");
        Intrinsics3.checkNotNullParameter(fileName, "fileName");
        Intrinsics3.checkNotNullParameter(downloadDirectory, "downloadDirectory");
        Observable<DownloadState> observableO = Observable.o(new Action1<Emitter<DownloadState>>() { // from class: com.discord.utilities.file.DownloadUtils.downloadFile.1

            /* JADX INFO: renamed from: com.discord.utilities.file.DownloadUtils$downloadFile$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: DownloadUtils.kt */
            public static final class C02131 extends Lambda implements Function1<ResponseBody, Unit> {
                public final /* synthetic */ Emitter $emitter;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C02131(Emitter emitter) {
                    super(1);
                    this.$emitter = emitter;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ResponseBody responseBody) {
                    invoke2(responseBody);
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ResponseBody responseBody) {
                    Intrinsics3.checkNotNullParameter(responseBody, "responseBody");
                    try {
                        try {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            File file = new File(downloadDirectory, fileName);
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
                                this.$emitter.onNext(new DownloadState.InProgress(i / fA));
                                fileOutputStream.write(bArr, 0, i2);
                            }
                            this.$emitter.onNext(new DownloadState.Completed(file));
                            this.$emitter.onCompleted();
                        } catch (IOException e) {
                            e.printStackTrace();
                            this.$emitter.onNext(new DownloadState.Failure(e));
                        }
                    } finally {
                        responseBody.close();
                    }
                }
            }

            @Override // rx.functions.Action1
            public final void call(Emitter<DownloadState> emitter) {
                Intrinsics3.checkNotNullParameter(emitter, "emitter");
                emitter.onNext(new DownloadState.InProgress(0.0f));
                ObservableExtensionsKt.appSubscribe(RestAPI.INSTANCE.getApiFiles().getFile(fileUrl), (Class<?>) DownloadUtils.INSTANCE.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new C02131(emitter));
            }
        }, Emitter.BackpressureMode.BUFFER);
        Intrinsics3.checkNotNullExpressionValue(observableO, "Observable.create({ emit….BackpressureMode.BUFFER)");
        return observableO;
    }

    public static /* synthetic */ Observable downloadFile$default(Context context, String str, String str2, File file, int i, Object obj) {
        if ((i & 8) != 0) {
            file = context.getCacheDir();
            Intrinsics3.checkNotNullExpressionValue(file, "context.cacheDir");
        }
        return downloadFile(context, str, str2, file);
    }
}
