package com.discord.utilities.rx;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.functions.Function0;
import rx.functions.Action0;

/* JADX INFO: compiled from: ObservableExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservableExtensionsKt$appSubscribe$subscription$2 implements Action0 {
    public final /* synthetic */ Function0 $onCompleted;
    public final /* synthetic */ Function0 $onTerminated;

    public ObservableExtensionsKt$appSubscribe$subscription$2(Function0 function0, Function0 function1) {
        this.$onCompleted = function0;
        this.$onTerminated = function1;
    }

    @Override // rx.functions.Action0
    public final void call() {
        this.$onCompleted.invoke();
        this.$onTerminated.invoke();
    }
}
