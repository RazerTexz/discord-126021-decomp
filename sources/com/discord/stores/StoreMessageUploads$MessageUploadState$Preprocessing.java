package com.discord.stores;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreMessageUploads.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreMessageUploads$MessageUploadState$Preprocessing extends StoreMessageUploads$MessageUploadState {
    private final String displayName;
    private final String mimeType;
    private final int numFiles;

    public StoreMessageUploads$MessageUploadState$Preprocessing(int i, String str, String str2) {
        super(null);
        this.numFiles = i;
        this.displayName = str;
        this.mimeType = str2;
    }

    public static /* synthetic */ StoreMessageUploads$MessageUploadState$Preprocessing copy$default(StoreMessageUploads$MessageUploadState$Preprocessing storeMessageUploads$MessageUploadState$Preprocessing, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = storeMessageUploads$MessageUploadState$Preprocessing.numFiles;
        }
        if ((i2 & 2) != 0) {
            str = storeMessageUploads$MessageUploadState$Preprocessing.displayName;
        }
        if ((i2 & 4) != 0) {
            str2 = storeMessageUploads$MessageUploadState$Preprocessing.mimeType;
        }
        return storeMessageUploads$MessageUploadState$Preprocessing.copy(i, str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getNumFiles() {
        return this.numFiles;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    public final StoreMessageUploads$MessageUploadState$Preprocessing copy(int numFiles, String displayName, String mimeType) {
        return new StoreMessageUploads$MessageUploadState$Preprocessing(numFiles, displayName, mimeType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreMessageUploads$MessageUploadState$Preprocessing)) {
            return false;
        }
        StoreMessageUploads$MessageUploadState$Preprocessing storeMessageUploads$MessageUploadState$Preprocessing = (StoreMessageUploads$MessageUploadState$Preprocessing) other;
        return this.numFiles == storeMessageUploads$MessageUploadState$Preprocessing.numFiles && m.areEqual(this.displayName, storeMessageUploads$MessageUploadState$Preprocessing.displayName) && m.areEqual(this.mimeType, storeMessageUploads$MessageUploadState$Preprocessing.mimeType);
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final int getNumFiles() {
        return this.numFiles;
    }

    public int hashCode() {
        int i = this.numFiles * 31;
        String str = this.displayName;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.mimeType;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Preprocessing(numFiles=");
        sbU.append(this.numFiles);
        sbU.append(", displayName=");
        sbU.append(this.displayName);
        sbU.append(", mimeType=");
        return a.J(sbU, this.mimeType, ")");
    }
}
