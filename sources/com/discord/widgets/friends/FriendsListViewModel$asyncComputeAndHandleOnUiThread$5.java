package com.discord.widgets.friends;

import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.Subscription;
import rx.functions.Cancellable;

/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FriendsListViewModel$asyncComputeAndHandleOnUiThread$5 implements Cancellable {
    public final /* synthetic */ Ref$ObjectRef $subscription;

    public FriendsListViewModel$asyncComputeAndHandleOnUiThread$5(Ref$ObjectRef ref$ObjectRef) {
        this.$subscription = ref$ObjectRef;
    }

    @Override // rx.functions.Cancellable
    public final void cancel() {
        Subscription subscription = (Subscription) this.$subscription.element;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }
}
