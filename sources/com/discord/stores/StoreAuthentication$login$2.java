package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.auth.ModelLoginResult;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: StoreAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuthentication$login$2<T> implements Action1<ModelLoginResult> {
    public final /* synthetic */ StoreAuthentication this$0;

    public StoreAuthentication$login$2(StoreAuthentication storeAuthentication) {
        this.this$0 = storeAuthentication;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(ModelLoginResult modelLoginResult) {
        call2(modelLoginResult);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(ModelLoginResult modelLoginResult) {
        if (modelLoginResult.getMfa()) {
            return;
        }
        StoreAuthentication storeAuthentication = this.this$0;
        m.checkNotNullExpressionValue(modelLoginResult, "loginResult");
        StoreAuthentication.access$dispatchLogin(storeAuthentication, modelLoginResult);
    }
}
