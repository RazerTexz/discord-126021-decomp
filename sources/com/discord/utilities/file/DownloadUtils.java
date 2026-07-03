package com.discord.utilities.file;

import android.content.Context;
import androidx.annotation.RequiresPermission;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.ResponseBody;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Emitter;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;

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
                C12238m.checkNotNullParameter(file, "file");
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
                C12238m.checkNotNullParameter(exc, "exception");
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
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(fileUrl, "fileUrl");
        C12238m.checkNotNullParameter(fileName, "fileName");
        C12238m.checkNotNullParameter(downloadDirectory, "downloadDirectory");
        Observable<DownloadState> observableM11080o = Observable.m11080o(new Action1<Emitter<DownloadState>>() { // from class: com.discord.utilities.file.DownloadUtils.downloadFile.1

            /* JADX INFO: renamed from: com.discord.utilities.file.DownloadUtils$downloadFile$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: DownloadUtils.kt */
            public static final class AnonymousClass1 extends AbstractC12240o implements Function1<ResponseBody, Unit> {
                public final /* synthetic */ Emitter $emitter;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(Emitter emitter) {
                    super(1);
                    this.$emitter = emitter;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ResponseBody responseBody) {
                    invoke2(responseBody);
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ResponseBody responseBody) {
                    C12238m.checkNotNullParameter(responseBody, "responseBody");
                    try {
                        try {
                            C67551 c67551 = C67551.this;
                            File file = new File(downloadDirectory, fileName);
                            byte[] bArr = new byte[8192];
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            float fMo10103a = responseBody.mo10103a();
                            int i = 0;
                            while (true) {
                                int i2 = responseBody.mo10105c().mo10470u0().read(bArr);
                                if (i2 == -1) {
                                    break;
                                }
                                i += i2;
                                this.$emitter.onNext(new DownloadState.InProgress(i / fMo10103a));
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

            @Override // p658rx.functions.Action1
            public final void call(Emitter<DownloadState> emitter) {
                C12238m.checkNotNullParameter(emitter, "emitter");
                emitter.onNext(new DownloadState.InProgress(0.0f));
                ObservableExtensionsKt.appSubscribe(RestAPI.INSTANCE.getApiFiles().getFile(fileUrl), (Class<?>) DownloadUtils.INSTANCE.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new AnonymousClass1(emitter));
            }
        }, Emitter.BackpressureMode.BUFFER);
        C12238m.checkNotNullExpressionValue(observableM11080o, "Observable.create({ emit….BackpressureMode.BUFFER)");
        return observableM11080o;
    }

    public static /* synthetic */ Observable downloadFile$default(Context context, String str, String str2, File file, int i, Object obj) {
        if ((i & 8) != 0) {
            file = context.getCacheDir();
            C12238m.checkNotNullExpressionValue(file, "context.cacheDir");
        }
        return downloadFile(context, str, str2, file);
    }
}
