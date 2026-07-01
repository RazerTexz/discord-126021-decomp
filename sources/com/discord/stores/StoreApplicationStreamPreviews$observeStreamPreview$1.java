package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationStreamPreviews$observeStreamPreview$1 extends o implements Function0<StoreApplicationStreamPreviews$StreamPreview> {
    public final /* synthetic */ String $streamKey;
    public final /* synthetic */ StoreApplicationStreamPreviews this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationStreamPreviews$observeStreamPreview$1(StoreApplicationStreamPreviews storeApplicationStreamPreviews, String str) {
        super(0);
        this.this$0 = storeApplicationStreamPreviews;
        this.$streamKey = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StoreApplicationStreamPreviews$StreamPreview invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StoreApplicationStreamPreviews$StreamPreview invoke() {
        return this.this$0.getStreamKeyToPreviewMap().get(this.$streamKey);
    }
}
