package com.discord.utilities.rx;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import kotlinx.coroutines.CancellableContinuation;
import rx.functions.Action1;

/* JADX INFO: compiled from: RxCoroutineUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RxCoroutineUtilsKt$awaitSingle$2$subscription$2<T> implements Action1<Throwable> {
    public final /* synthetic */ CancellableContinuation $cont;

    public RxCoroutineUtilsKt$awaitSingle$2$subscription$2(CancellableContinuation cancellableContinuation) {
        this.$cont = cancellableContinuation;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Throwable th) {
        call2(th);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Throwable th) {
        this.$cont.k(th);
    }
}
