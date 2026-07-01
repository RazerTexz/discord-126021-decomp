package com.discord.stores;

import com.discord.api.application.Application;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplication$observeApplication$1 extends o implements Function0<Application> {
    public final /* synthetic */ Long $appId;
    public final /* synthetic */ StoreApplication this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplication$observeApplication$1(StoreApplication storeApplication, Long l) {
        super(0);
        this.this$0 = storeApplication;
        this.$appId = l;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Application invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Application invoke() {
        return (Application) StoreApplication.access$getApplicationsSnapshot$p(this.this$0).get(this.$appId);
    }
}
