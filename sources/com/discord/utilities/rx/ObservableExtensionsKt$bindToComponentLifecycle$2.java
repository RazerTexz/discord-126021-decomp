package com.discord.utilities.rx;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import rx.functions.Action0;

/* JADX INFO: compiled from: ObservableExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservableExtensionsKt$bindToComponentLifecycle$2 implements Action0 {
    public final /* synthetic */ MGRecyclerAdapterSimple $adapter;

    public ObservableExtensionsKt$bindToComponentLifecycle$2(MGRecyclerAdapterSimple mGRecyclerAdapterSimple) {
        this.$adapter = mGRecyclerAdapterSimple;
    }

    @Override // rx.functions.Action0
    public final void call() {
        MGRecyclerAdapterSimple mGRecyclerAdapterSimple = this.$adapter;
        if (mGRecyclerAdapterSimple != null) {
            mGRecyclerAdapterSimple.unsubscribeFromUpdates();
        }
    }
}
