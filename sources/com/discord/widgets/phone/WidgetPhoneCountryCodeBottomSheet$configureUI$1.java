package com.discord.widgets.phone;

import com.discord.models.phone.PhoneCountryCode;
import com.discord.stores.StorePhone;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetPhoneCountryCodeBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPhoneCountryCodeBottomSheet$configureUI$1 implements OnCountryCodeSelectedListener {
    public final /* synthetic */ StorePhone $phoneStore;
    public final /* synthetic */ WidgetPhoneCountryCodeBottomSheet this$0;

    public WidgetPhoneCountryCodeBottomSheet$configureUI$1(WidgetPhoneCountryCodeBottomSheet widgetPhoneCountryCodeBottomSheet, StorePhone storePhone) {
        this.this$0 = widgetPhoneCountryCodeBottomSheet;
        this.$phoneStore = storePhone;
    }

    @Override // com.discord.widgets.phone.OnCountryCodeSelectedListener
    public final void onCountryCodeSelected(PhoneCountryCode phoneCountryCode) {
        m.checkNotNullParameter(phoneCountryCode, "it");
        this.$phoneStore.updateSelectedCountryCode(phoneCountryCode);
        this.this$0.dismiss();
    }
}
