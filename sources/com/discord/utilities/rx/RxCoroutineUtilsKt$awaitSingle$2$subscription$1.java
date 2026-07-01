package com.discord.utilities.rx;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import d0.k;
import d0.k$a;
import kotlinx.coroutines.CancellableContinuation;
import rx.functions.Action1;

/* JADX INFO: compiled from: RxCoroutineUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RxCoroutineUtilsKt$awaitSingle$2$subscription$1<T> implements Action1<T> {
    public final /* synthetic */ CancellableContinuation $cont;

    public RxCoroutineUtilsKt$awaitSingle$2$subscription$1(CancellableContinuation cancellableContinuation) {
        this.$cont = cancellableContinuation;
    }

    @Override // rx.functions.Action1
    public final void call(T t) {
        CancellableContinuation cancellableContinuation = this.$cont;
        k$a k_a = k.j;
        cancellableContinuation.resumeWith(k.m97constructorimpl(t));
    }
}
