package com.discord.stores;

import b.d.b.a.a;
import com.discord.utilities.rest.SendUtils$FileUpload;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: StoreMessageUploads.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreMessageUploads$MessageUploadState$Uploading extends StoreMessageUploads$MessageUploadState {
    private final List<SendUtils$FileUpload> uploads;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessageUploads$MessageUploadState$Uploading(List<SendUtils$FileUpload> list) {
        super(null);
        m.checkNotNullParameter(list, "uploads");
        this.uploads = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StoreMessageUploads$MessageUploadState$Uploading copy$default(StoreMessageUploads$MessageUploadState$Uploading storeMessageUploads$MessageUploadState$Uploading, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = storeMessageUploads$MessageUploadState$Uploading.uploads;
        }
        return storeMessageUploads$MessageUploadState$Uploading.copy(list);
    }

    public final List<SendUtils$FileUpload> component1() {
        return this.uploads;
    }

    public final StoreMessageUploads$MessageUploadState$Uploading copy(List<SendUtils$FileUpload> uploads) {
        m.checkNotNullParameter(uploads, "uploads");
        return new StoreMessageUploads$MessageUploadState$Uploading(uploads);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StoreMessageUploads$MessageUploadState$Uploading) && m.areEqual(this.uploads, ((StoreMessageUploads$MessageUploadState$Uploading) other).uploads);
        }
        return true;
    }

    public final List<SendUtils$FileUpload> getUploads() {
        return this.uploads;
    }

    public int hashCode() {
        List<SendUtils$FileUpload> list = this.uploads;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.L(a.U("Uploading(uploads="), this.uploads, ")");
    }
}
