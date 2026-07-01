package com.discord.models.domain;

import com.discord.models.domain.billing.ModelBillingAddress;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModelPaymentSource.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class ModelPaymentSource {
    public static final ModelPaymentSource$Companion Companion = new ModelPaymentSource$Companion(null);
    private static final int PAYMENT_SOURCE_TYPE_CARD = 1;
    private static final int PAYMENT_SOURCE_TYPE_PAYPAL = 2;
    private final ModelBillingAddress billingAddress;
    private final boolean default;
    private final String id;
    private final boolean invalid;

    private ModelPaymentSource(String str, boolean z2, ModelBillingAddress modelBillingAddress, boolean z3) {
        this.id = str;
        this.invalid = z2;
        this.billingAddress = modelBillingAddress;
        this.default = z3;
    }

    public ModelBillingAddress getBillingAddress() {
        return this.billingAddress;
    }

    public boolean getDefault() {
        return this.default;
    }

    public String getId() {
        return this.id;
    }

    public boolean getInvalid() {
        return this.invalid;
    }

    public /* synthetic */ ModelPaymentSource(String str, boolean z2, ModelBillingAddress modelBillingAddress, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z2, modelBillingAddress, z3);
    }
}
