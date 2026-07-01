package com.discord.stores;

import com.discord.utilities.rest.SendUtils$FileUpload;
import d0.z.d.m;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: StoreMessageUploads.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageUploads extends StoreV2 {
    private final HashMap<String, StoreMessageUploads$MessageUploadState> uploads = new HashMap<>();

    @StoreThread
    private final void updateState(String nonce, StoreMessageUploads$MessageUploadState uploadState) {
        this.uploads.put(nonce, uploadState);
        markChanged();
    }

    @StoreThread
    public final void bindUpload(String nonce, List<SendUtils$FileUpload> uploads) {
        m.checkNotNullParameter(nonce, "nonce");
        m.checkNotNullParameter(uploads, "uploads");
        updateState(nonce, new StoreMessageUploads$MessageUploadState$Uploading(uploads));
    }

    public final StoreMessageUploads$MessageUploadState getUploadProgress(String nonce) {
        m.checkNotNullParameter(nonce, "nonce");
        StoreMessageUploads$MessageUploadState storeMessageUploads$MessageUploadState = this.uploads.get(nonce);
        return storeMessageUploads$MessageUploadState != null ? storeMessageUploads$MessageUploadState : StoreMessageUploads$MessageUploadState$None.INSTANCE;
    }

    @StoreThread
    public final void onPreprocessing(String nonce, int numFiles, String displayName, String mimeType) {
        m.checkNotNullParameter(nonce, "nonce");
        updateState(nonce, new StoreMessageUploads$MessageUploadState$Preprocessing(numFiles, displayName, mimeType));
    }
}
