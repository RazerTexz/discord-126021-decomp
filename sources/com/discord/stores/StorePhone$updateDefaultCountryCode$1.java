package com.discord.stores;

import com.discord.models.phone.PhoneCountryCode;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StorePhone.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StorePhone$updateDefaultCountryCode$1 extends o implements Function0<Unit> {
    public final /* synthetic */ String $alpha2;
    public final /* synthetic */ StorePhone this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StorePhone$updateDefaultCountryCode$1(StorePhone storePhone, String str) {
        super(0);
        this.this$0 = storePhone;
        this.$alpha2 = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Object next;
        Iterator<T> it = this.this$0.getCountryCodes().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!m.areEqual(((PhoneCountryCode) next).getAlpha2(), this.$alpha2));
        PhoneCountryCode phoneCountryCode = (PhoneCountryCode) next;
        if (phoneCountryCode != null) {
            StorePhone.access$setDefaultCountryCode$p(this.this$0, phoneCountryCode);
            this.this$0.markChanged();
        }
    }
}
