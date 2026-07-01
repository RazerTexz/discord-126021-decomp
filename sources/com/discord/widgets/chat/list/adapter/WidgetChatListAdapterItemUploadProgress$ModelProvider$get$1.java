package com.discord.widgets.chat.list.adapter;

import com.discord.stores.StoreMessageUploads;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChatListAdapterItemUploadProgress.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemUploadProgress$ModelProvider$get$1 extends Lambda implements Function0<StoreMessageUploads.MessageUploadState> {
    public final /* synthetic */ StoreMessageUploads $messageUploadStore;
    public final /* synthetic */ String $nonce;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemUploadProgress$ModelProvider$get$1(StoreMessageUploads storeMessageUploads, String str) {
        super(0);
        this.$messageUploadStore = storeMessageUploads;
        this.$nonce = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StoreMessageUploads.MessageUploadState invoke() {
        return this.$messageUploadStore.getUploadProgress(this.$nonce);
    }
}
