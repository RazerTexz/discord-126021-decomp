package com.discord.restapi;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$InvoicePreviewBody {
    private final boolean applyEntitlements;
    private final boolean renewal;
    private final String subscriptionId;

    public RestAPIParams$InvoicePreviewBody(String str, boolean z2, boolean z3) {
        m.checkNotNullParameter(str, "subscriptionId");
        this.subscriptionId = str;
        this.renewal = z2;
        this.applyEntitlements = z3;
    }

    public static /* synthetic */ RestAPIParams$InvoicePreviewBody copy$default(RestAPIParams$InvoicePreviewBody restAPIParams$InvoicePreviewBody, String str, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = restAPIParams$InvoicePreviewBody.subscriptionId;
        }
        if ((i & 2) != 0) {
            z2 = restAPIParams$InvoicePreviewBody.renewal;
        }
        if ((i & 4) != 0) {
            z3 = restAPIParams$InvoicePreviewBody.applyEntitlements;
        }
        return restAPIParams$InvoicePreviewBody.copy(str, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getRenewal() {
        return this.renewal;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getApplyEntitlements() {
        return this.applyEntitlements;
    }

    public final RestAPIParams$InvoicePreviewBody copy(String subscriptionId, boolean renewal, boolean applyEntitlements) {
        m.checkNotNullParameter(subscriptionId, "subscriptionId");
        return new RestAPIParams$InvoicePreviewBody(subscriptionId, renewal, applyEntitlements);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestAPIParams$InvoicePreviewBody)) {
            return false;
        }
        RestAPIParams$InvoicePreviewBody restAPIParams$InvoicePreviewBody = (RestAPIParams$InvoicePreviewBody) other;
        return m.areEqual(this.subscriptionId, restAPIParams$InvoicePreviewBody.subscriptionId) && this.renewal == restAPIParams$InvoicePreviewBody.renewal && this.applyEntitlements == restAPIParams$InvoicePreviewBody.applyEntitlements;
    }

    public final boolean getApplyEntitlements() {
        return this.applyEntitlements;
    }

    public final boolean getRenewal() {
        return this.renewal;
    }

    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        String str = this.subscriptionId;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z2 = this.renewal;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z3 = this.applyEntitlements;
        return i + (z3 ? 1 : z3);
    }

    public String toString() {
        StringBuilder sbU = a.U("InvoicePreviewBody(subscriptionId=");
        sbU.append(this.subscriptionId);
        sbU.append(", renewal=");
        sbU.append(this.renewal);
        sbU.append(", applyEntitlements=");
        return a.O(sbU, this.applyEntitlements, ")");
    }
}
