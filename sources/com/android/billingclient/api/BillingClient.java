package com.android.billingclient.api;

import android.app.Activity;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import p007b.p100d.p101a.p102a.C1619d;
import p007b.p100d.p101a.p102a.C1623h;
import p007b.p100d.p101a.p102a.InterfaceC1616b;
import p007b.p100d.p101a.p102a.InterfaceC1620e;
import p007b.p100d.p101a.p102a.InterfaceC1621f;
import p007b.p100d.p101a.p102a.InterfaceC1624i;

/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BillingClient {
    @AnyThread
    /* JADX INFO: renamed from: a */
    public abstract void mo799a(@NonNull C1619d c1619d, @NonNull InterfaceC1620e interfaceC1620e);

    @AnyThread
    /* JADX INFO: renamed from: b */
    public abstract void mo800b();

    @AnyThread
    /* JADX INFO: renamed from: c */
    public abstract int mo801c();

    @AnyThread
    /* JADX INFO: renamed from: d */
    public abstract boolean mo802d();

    @NonNull
    @UiThread
    /* JADX INFO: renamed from: e */
    public abstract BillingResult mo803e(@NonNull Activity activity, @NonNull BillingFlowParams billingFlowParams);

    @AnyThread
    /* JADX INFO: renamed from: f */
    public abstract void mo804f(@NonNull String str, @NonNull InterfaceC1621f interfaceC1621f);

    @AnyThread
    /* JADX INFO: renamed from: g */
    public abstract void mo805g(@NonNull C1623h c1623h, @NonNull InterfaceC1624i interfaceC1624i);

    @AnyThread
    /* JADX INFO: renamed from: h */
    public abstract void mo806h(@NonNull InterfaceC1616b interfaceC1616b);
}
