package com.android.billingclient.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public class Purchase$a {

    @Nullable
    public final List<Purchase> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BillingResult f2005b;

    public Purchase$a(@NonNull BillingResult billingResult, @Nullable List<Purchase> list) {
        this.a = list;
        this.f2005b = billingResult;
    }
}
