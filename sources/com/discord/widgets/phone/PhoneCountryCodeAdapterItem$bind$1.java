package com.discord.widgets.phone;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.phone.PhoneCountryCode;

/* JADX INFO: compiled from: PhoneCountryCodeAdapterItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PhoneCountryCodeAdapterItem$bind$1 implements View$OnClickListener {
    public final /* synthetic */ PhoneCountryCode $data;
    public final /* synthetic */ PhoneCountryCodeAdapterItem this$0;

    public PhoneCountryCodeAdapterItem$bind$1(PhoneCountryCodeAdapterItem phoneCountryCodeAdapterItem, PhoneCountryCode phoneCountryCode) {
        this.this$0 = phoneCountryCodeAdapterItem;
        this.$data = phoneCountryCode;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        OnCountryCodeSelectedListener onCountryCodeSelectedListener = PhoneCountryCodeAdapterItem.access$getAdapter$p(this.this$0).getOnCountryCodeSelectedListener();
        if (onCountryCodeSelectedListener != null) {
            onCountryCodeSelectedListener.onCountryCodeSelected(this.$data);
        }
    }
}
