package com.discord.models.domain;

import b.d.b.a.a;
import com.discord.api.application.Application;
import d0.z.d.m;

/* JADX INFO: compiled from: ModelLibraryApplication.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelLibraryApplication {
    private final Application application;
    private final long branchId;
    private final String createdAt;
    private final int flags;
    private final long skuId;

    public ModelLibraryApplication(Application application, String str, long j, int i, long j2) {
        m.checkNotNullParameter(application, "application");
        m.checkNotNullParameter(str, "createdAt");
        this.application = application;
        this.createdAt = str;
        this.skuId = j;
        this.flags = i;
        this.branchId = j2;
    }

    public static /* synthetic */ ModelLibraryApplication copy$default(ModelLibraryApplication modelLibraryApplication, Application application, String str, long j, int i, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            application = modelLibraryApplication.application;
        }
        if ((i2 & 2) != 0) {
            str = modelLibraryApplication.createdAt;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            j = modelLibraryApplication.skuId;
        }
        long j3 = j;
        if ((i2 & 8) != 0) {
            i = modelLibraryApplication.flags;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            j2 = modelLibraryApplication.branchId;
        }
        return modelLibraryApplication.copy(application, str2, j3, i3, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getSkuId() {
        return this.skuId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getFlags() {
        return this.flags;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getBranchId() {
        return this.branchId;
    }

    public final ModelLibraryApplication copy(Application application, String createdAt, long skuId, int flags, long branchId) {
        m.checkNotNullParameter(application, "application");
        m.checkNotNullParameter(createdAt, "createdAt");
        return new ModelLibraryApplication(application, createdAt, skuId, flags, branchId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelLibraryApplication)) {
            return false;
        }
        ModelLibraryApplication modelLibraryApplication = (ModelLibraryApplication) other;
        return m.areEqual(this.application, modelLibraryApplication.application) && m.areEqual(this.createdAt, modelLibraryApplication.createdAt) && this.skuId == modelLibraryApplication.skuId && this.flags == modelLibraryApplication.flags && this.branchId == modelLibraryApplication.branchId;
    }

    public final Application getApplication() {
        return this.application;
    }

    public final long getBranchId() {
        return this.branchId;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final int getFlags() {
        return this.flags;
    }

    public final long getSkuId() {
        return this.skuId;
    }

    public int hashCode() {
        Application application = this.application;
        int iHashCode = (application != null ? application.hashCode() : 0) * 31;
        String str = this.createdAt;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        long j = this.skuId;
        int i = (((iHashCode2 + ((int) (j ^ (j >>> 32)))) * 31) + this.flags) * 31;
        long j2 = this.branchId;
        return i + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelLibraryApplication(application=");
        sbU.append(this.application);
        sbU.append(", createdAt=");
        sbU.append(this.createdAt);
        sbU.append(", skuId=");
        sbU.append(this.skuId);
        sbU.append(", flags=");
        sbU.append(this.flags);
        sbU.append(", branchId=");
        return a.C(sbU, this.branchId, ")");
    }
}
