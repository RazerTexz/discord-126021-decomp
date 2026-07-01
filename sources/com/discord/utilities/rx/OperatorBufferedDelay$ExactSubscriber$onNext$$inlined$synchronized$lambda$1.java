package com.discord.utilities.rx;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import rx.functions.Action0;

/* JADX INFO: compiled from: OperatorBufferedDelay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OperatorBufferedDelay$ExactSubscriber$onNext$$inlined$synchronized$lambda$1 implements Action0 {
    public final /* synthetic */ Object $t$inlined;
    public final /* synthetic */ OperatorBufferedDelay$ExactSubscriber this$0;

    public OperatorBufferedDelay$ExactSubscriber$onNext$$inlined$synchronized$lambda$1(OperatorBufferedDelay$ExactSubscriber operatorBufferedDelay$ExactSubscriber, Object obj) {
        this.this$0 = operatorBufferedDelay$ExactSubscriber;
        this.$t$inlined = obj;
    }

    @Override // rx.functions.Action0
    public final void call() {
        OperatorBufferedDelay$ExactSubscriber.tryEmit$default(this.this$0, null, 1, null);
    }
}
