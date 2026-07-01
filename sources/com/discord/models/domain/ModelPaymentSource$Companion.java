package com.discord.models.domain;

import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModelPaymentSource.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelPaymentSource$Companion {
    private ModelPaymentSource$Companion() {
    }

    public final ModelPaymentSource wrap(PaymentSourceRaw raw) throws ModelPaymentSource$UnableToWrapException {
        m.checkNotNullParameter(raw, "raw");
        try {
            int type = raw.getType();
            if (type == 1) {
                String brand = raw.getBrand();
                m.checkNotNull(brand);
                String last_4 = raw.getLast_4();
                m.checkNotNull(last_4);
                return new ModelPaymentSource$ModelPaymentSourceCard(brand, last_4, raw.getExpiresMonth(), raw.getExpiresYear(), raw.getId(), raw.getInvalid(), raw.getBillingAddress(), raw.getDefault());
            }
            if (type == 2) {
                String email = raw.getEmail();
                m.checkNotNull(email);
                return new ModelPaymentSource$ModelPaymentSourcePaypal(email, raw.getId(), raw.getInvalid(), raw.getBillingAddress(), raw.getDefault());
            }
            throw new IllegalArgumentException("unsupported payment source type: " + raw.getType());
        } catch (Throwable th) {
            throw new ModelPaymentSource$UnableToWrapException(th);
        }
    }

    public /* synthetic */ ModelPaymentSource$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
