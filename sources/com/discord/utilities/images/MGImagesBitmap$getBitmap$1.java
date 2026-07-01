package com.discord.utilities.images;

import android.graphics.Bitmap;
import androidx.core.app.NotificationCompat;
import com.facebook.datasource.DataSource;
import rx.Observable$a;
import rx.Subscriber;

/* JADX INFO: compiled from: MGImagesBitmap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MGImagesBitmap$getBitmap$1<T> implements Observable$a<Bitmap> {
    public final /* synthetic */ DataSource $dataSource;
    public final /* synthetic */ String $imageUri;

    public MGImagesBitmap$getBitmap$1(DataSource dataSource, String str) {
        this.$dataSource = dataSource;
        this.$imageUri = str;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber<? super Bitmap>) obj);
    }

    public final void call(Subscriber<? super Bitmap> subscriber) {
        this.$dataSource.f(new MGImagesBitmap$getBitmap$1$1(this, subscriber), MGImagesBitmap$getBitmap$1$2.INSTANCE);
    }
}
