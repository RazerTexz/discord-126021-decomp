package com.discord.models.domain;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: ModelLocationMetadata.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelLocationMetadata {
    private final boolean consentRequired;
    private final String countryCode;

    public ModelLocationMetadata(boolean z2, String str) {
        this.consentRequired = z2;
        this.countryCode = str;
    }

    public static /* synthetic */ ModelLocationMetadata copy$default(ModelLocationMetadata modelLocationMetadata, boolean z2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = modelLocationMetadata.consentRequired;
        }
        if ((i & 2) != 0) {
            str = modelLocationMetadata.countryCode;
        }
        return modelLocationMetadata.copy(z2, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getConsentRequired() {
        return this.consentRequired;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCountryCode() {
        return this.countryCode;
    }

    public final ModelLocationMetadata copy(boolean consentRequired, String countryCode) {
        return new ModelLocationMetadata(consentRequired, countryCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelLocationMetadata)) {
            return false;
        }
        ModelLocationMetadata modelLocationMetadata = (ModelLocationMetadata) other;
        return this.consentRequired == modelLocationMetadata.consentRequired && m.areEqual(this.countryCode, modelLocationMetadata.countryCode);
    }

    public final boolean getConsentRequired() {
        return this.consentRequired;
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z2 = this.consentRequired;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        String str = this.countryCode;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelLocationMetadata(consentRequired=");
        sbU.append(this.consentRequired);
        sbU.append(", countryCode=");
        return a.J(sbU, this.countryCode, ")");
    }
}
