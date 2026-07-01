package com.discord.widgets.auth;

import com.discord.models.phone.PhoneCountryCode;
import com.discord.stores.StorePhone;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetAuthLogin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLogin$onViewBound$8 extends o implements Function0<PhoneCountryCode> {
    public final /* synthetic */ StorePhone $phoneStore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthLogin$onViewBound$8(StorePhone storePhone) {
        super(0);
        this.$phoneStore = storePhone;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ PhoneCountryCode invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final PhoneCountryCode invoke() {
        return this.$phoneStore.getCountryCode();
    }
}
