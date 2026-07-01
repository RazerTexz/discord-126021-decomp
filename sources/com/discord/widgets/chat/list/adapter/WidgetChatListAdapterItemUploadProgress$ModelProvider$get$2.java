package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreMessageUploads$MessageUploadState;
import com.discord.stores.StoreMessageUploads$MessageUploadState$None;
import com.discord.stores.StoreMessageUploads$MessageUploadState$Preprocessing;
import com.discord.stores.StoreMessageUploads$MessageUploadState$Uploading;
import com.discord.utilities.rest.SendUtils$FileUpload;
import d0.t.u;
import j0.k.b;
import j0.l.e.k;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChatListAdapterItemUploadProgress.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemUploadProgress$ModelProvider$get$2<T, R> implements b<StoreMessageUploads$MessageUploadState, Observable<? extends WidgetChatListAdapterItemUploadProgress$Model>> {
    public final /* synthetic */ long $throttleIntervalMs;

    public WidgetChatListAdapterItemUploadProgress$ModelProvider$get$2(long j) {
        this.$throttleIntervalMs = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListAdapterItemUploadProgress$Model> call(StoreMessageUploads$MessageUploadState storeMessageUploads$MessageUploadState) {
        return call2(storeMessageUploads$MessageUploadState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChatListAdapterItemUploadProgress$Model> call2(StoreMessageUploads$MessageUploadState storeMessageUploads$MessageUploadState) {
        if (storeMessageUploads$MessageUploadState instanceof StoreMessageUploads$MessageUploadState$None) {
            return new k(WidgetChatListAdapterItemUploadProgress$Model$None.INSTANCE);
        }
        if (storeMessageUploads$MessageUploadState instanceof StoreMessageUploads$MessageUploadState$Preprocessing) {
            StoreMessageUploads$MessageUploadState$Preprocessing storeMessageUploads$MessageUploadState$Preprocessing = (StoreMessageUploads$MessageUploadState$Preprocessing) storeMessageUploads$MessageUploadState;
            return new k(new WidgetChatListAdapterItemUploadProgress$Model$Preprocessing(storeMessageUploads$MessageUploadState$Preprocessing.getNumFiles(), storeMessageUploads$MessageUploadState$Preprocessing.getDisplayName(), storeMessageUploads$MessageUploadState$Preprocessing.getMimeType()));
        }
        if (!(storeMessageUploads$MessageUploadState instanceof StoreMessageUploads$MessageUploadState$Uploading)) {
            throw new NoWhenBranchMatchedException();
        }
        List<SendUtils$FileUpload> uploads = ((StoreMessageUploads$MessageUploadState$Uploading) storeMessageUploads$MessageUploadState).getUploads();
        if (uploads.size() == 1) {
            return WidgetChatListAdapterItemUploadProgress$ModelProvider.access$getSingleUploadObservable(WidgetChatListAdapterItemUploadProgress$ModelProvider.INSTANCE, (SendUtils$FileUpload) u.first((List) uploads), this.$throttleIntervalMs);
        }
        return uploads.size() <= 3 ? WidgetChatListAdapterItemUploadProgress$ModelProvider.access$getFewUploadsObservable(WidgetChatListAdapterItemUploadProgress$ModelProvider.INSTANCE, uploads, this.$throttleIntervalMs) : WidgetChatListAdapterItemUploadProgress$ModelProvider.access$getManyUploadsObservable(WidgetChatListAdapterItemUploadProgress$ModelProvider.INSTANCE, uploads, this.$throttleIntervalMs);
    }
}
