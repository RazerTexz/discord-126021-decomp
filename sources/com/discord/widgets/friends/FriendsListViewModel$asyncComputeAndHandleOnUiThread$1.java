package com.discord.widgets.friends;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.functions.Function0;
import rx.Emitter;
import rx.functions.Action1;

/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FriendsListViewModel$asyncComputeAndHandleOnUiThread$1<T> implements Action1<Emitter<T>> {
    public final /* synthetic */ Function0 $compute;

    public FriendsListViewModel$asyncComputeAndHandleOnUiThread$1(Function0 function0) {
        this.$compute = function0;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Emitter) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void call(Emitter<T> emitter) {
        emitter.onNext(this.$compute.invoke());
    }
}
