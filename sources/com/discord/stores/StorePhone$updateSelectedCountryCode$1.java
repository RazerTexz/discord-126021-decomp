package com.discord.stores;

import com.discord.models.phone.PhoneCountryCode;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StorePhone.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StorePhone$updateSelectedCountryCode$1 extends o implements Function0<Unit> {
    public final /* synthetic */ PhoneCountryCode $newSelectedCountryCode;
    public final /* synthetic */ StorePhone this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StorePhone$updateSelectedCountryCode$1(StorePhone storePhone, PhoneCountryCode phoneCountryCode) {
        super(0);
        this.this$0 = storePhone;
        this.$newSelectedCountryCode = phoneCountryCode;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StorePhone.access$setSelectedCountryCode$p(this.this$0, this.$newSelectedCountryCode);
        this.this$0.markChanged();
    }
}
