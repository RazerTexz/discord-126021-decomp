package com.google.android.gms.nearby.messages;

import androidx.annotation.Nullable;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p333j.p334b.C4267d;

/* JADX INFO: loaded from: classes3.dex */
public final class SubscribeOptions {

    /* JADX INFO: renamed from: a */
    public final Strategy f20737a;

    /* JADX INFO: renamed from: b */
    public final MessageFilter f20738b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public final C4267d f20739c = null;

    /* JADX INFO: renamed from: d */
    public final boolean f20740d = false;

    static {
        Strategy strategy = Strategy.f20727j;
        MessageFilter messageFilter = MessageFilter.f20718j;
    }

    public SubscribeOptions(Strategy strategy, MessageFilter messageFilter, C4267d c4267d) {
        this.f20737a = strategy;
        this.f20738b = messageFilter;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f20737a);
        String strValueOf2 = String.valueOf(this.f20738b);
        StringBuilder sbM831S = C1643a.m831S(strValueOf2.length() + strValueOf.length() + 36, "SubscribeOptions{strategy=", strValueOf, ", filter=", strValueOf2);
        sbM831S.append('}');
        return sbM831S.toString();
    }
}
