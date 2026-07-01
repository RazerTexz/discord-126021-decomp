package com.discord.utilities.viewcontroller;

import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import j0.k.b;

/* JADX INFO: compiled from: RxViewController.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RxViewController$connectViewRx$1<T, R> implements b<T, Boolean> {
    public final /* synthetic */ View $view;

    public RxViewController$connectViewRx$1(View view) {
        this.$view = view;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(Object obj) {
        return call(obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // j0.k.b
    public final Boolean call(T t) {
        return Boolean.valueOf(this.$view.isAttachedToWindow());
    }
}
