package com.discord.utilities.images;

import android.graphics.Bitmap;
import b.f.j.f.c;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import d0.g0.w;
import d0.z.d.m;
import rx.Subscriber;

/* JADX INFO: compiled from: MGImagesBitmap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MGImagesBitmap$getBitmap$1$1 extends c {
    public final /* synthetic */ Subscriber $emitter;
    public final /* synthetic */ MGImagesBitmap$getBitmap$1 this$0;

    public MGImagesBitmap$getBitmap$1$1(MGImagesBitmap$getBitmap$1 mGImagesBitmap$getBitmap$1, Subscriber subscriber) {
        this.this$0 = mGImagesBitmap$getBitmap$1;
        this.$emitter = subscriber;
    }

    @Override // b.f.e.d
    public void onFailureImpl(DataSource<CloseableReference<b.f.j.j.c>> dataSource) {
        String message;
        m.checkNotNullParameter(dataSource, "dataSource");
        Throwable thD = dataSource.d();
        if (thD != null && (message = thD.getMessage()) != null && w.contains$default((CharSequence) message, (CharSequence) "404", false, 2, (Object) null)) {
            this.$emitter.onError(new MGImagesBitmap$ImageNotFoundException(this.this$0.$imageUri));
            return;
        }
        Subscriber subscriber = this.$emitter;
        Throwable thD2 = dataSource.d();
        if (thD2 == null) {
            thD2 = new MGImagesBitmap$DecodeException(this.this$0.$imageUri);
        }
        subscriber.onError(thD2);
    }

    @Override // b.f.j.f.c
    public void onNewResultImpl(Bitmap bitmap) {
        if (bitmap == null) {
            this.$emitter.onError(new MGImagesBitmap$MissingBitmapException(this.this$0.$imageUri));
        } else {
            this.$emitter.onNext(Bitmap.createBitmap(bitmap));
            this.$emitter.onCompleted();
        }
    }
}
