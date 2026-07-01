package com.discord.stores.utilities;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: compiled from: RestCallState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestCallStateKt$handleResponse$2$1 implements Runnable {
    public final /* synthetic */ Failure $failure;
    public final /* synthetic */ RestCallStateKt$handleResponse$2 this$0;

    public RestCallStateKt$handleResponse$2$1(RestCallStateKt$handleResponse$2 restCallStateKt$handleResponse$2, Failure failure) {
        this.this$0 = restCallStateKt$handleResponse$2;
        this.$failure = failure;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$failure.getError().showToasts(this.this$0.$context);
    }
}
