package com.google.firebase.dynamiclinks;

import com.google.firebase.dynamiclinks.internal.DynamicLinkData;

/* JADX INFO: compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* JADX INFO: loaded from: classes3.dex */
public class PendingDynamicLinkData {

    /* JADX INFO: renamed from: a */
    public final DynamicLinkData f21421a;

    public PendingDynamicLinkData(DynamicLinkData dynamicLinkData) {
        if (dynamicLinkData.f21425m == 0) {
            dynamicLinkData.f21425m = System.currentTimeMillis();
        }
        this.f21421a = dynamicLinkData;
    }
}
