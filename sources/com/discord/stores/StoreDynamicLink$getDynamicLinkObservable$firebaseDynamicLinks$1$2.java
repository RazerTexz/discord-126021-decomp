package com.discord.stores;

import android.net.Uri;
import b.i.a.f.n.e;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import com.google.firebase.dynamiclinks.internal.DynamicLinkData;
import rx.Emitter;

/* JADX INFO: compiled from: StoreDynamicLink.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreDynamicLink$getDynamicLinkObservable$firebaseDynamicLinks$1$2<TResult> implements e<PendingDynamicLinkData> {
    public final /* synthetic */ Emitter $it;

    public StoreDynamicLink$getDynamicLinkObservable$firebaseDynamicLinks$1$2(Emitter emitter) {
        this.$it = emitter;
    }

    @Override // b.i.a.f.n.e
    public /* bridge */ /* synthetic */ void onSuccess(PendingDynamicLinkData pendingDynamicLinkData) {
        onSuccess2(pendingDynamicLinkData);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0015  */
    /* JADX INFO: renamed from: onSuccess, reason: avoid collision after fix types in other method */
    public final void onSuccess2(PendingDynamicLinkData pendingDynamicLinkData) {
        Uri uri;
        String str;
        Emitter emitter = this.$it;
        if (pendingDynamicLinkData != null) {
            DynamicLinkData dynamicLinkData = pendingDynamicLinkData.a;
            uri = null;
            if (dynamicLinkData != null && (str = dynamicLinkData.k) != null) {
                uri = Uri.parse(str);
            }
            if (uri == null) {
                uri = Uri.EMPTY;
            }
        } else {
            uri = Uri.EMPTY;
        }
        emitter.onNext(uri);
        this.$it.onCompleted();
    }
}
