package com.discord.models.domain;

import d0.z.d.m;

/* JADX INFO: compiled from: ModelPaymentSource.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelPaymentSource$UnableToWrapException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelPaymentSource$UnableToWrapException(Throwable th) {
        super(th);
        m.checkNotNullParameter(th, "cause");
    }
}
