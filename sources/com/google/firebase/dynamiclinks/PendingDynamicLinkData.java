package com.google.firebase.dynamiclinks;

import com.google.firebase.dynamiclinks.internal.DynamicLinkData;

/* JADX INFO: compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* JADX INFO: loaded from: classes3.dex */
public class PendingDynamicLinkData {
    public final DynamicLinkData a;

    public PendingDynamicLinkData(DynamicLinkData dynamicLinkData) {
        if (dynamicLinkData.m == 0) {
            dynamicLinkData.m = System.currentTimeMillis();
        }
        this.a = dynamicLinkData;
    }
}
