package com.discord.widgets.chat.list.adapter;

import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGift.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGift$configureResolvedUI$1 extends o implements Function1<ImageRequestBuilder, Unit> {
    public static final WidgetChatListAdapterItemGift$configureResolvedUI$1 INSTANCE = new WidgetChatListAdapterItemGift$configureResolvedUI$1();

    public WidgetChatListAdapterItemGift$configureResolvedUI$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ImageRequestBuilder imageRequestBuilder) {
        invoke2(imageRequestBuilder);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ImageRequestBuilder imageRequestBuilder) {
        m.checkNotNullParameter(imageRequestBuilder, "it");
        imageRequestBuilder.l = WidgetChatListAdapterItemGift.access$getSPLASH_IMAGE_POSTPROCESSOR$cp();
    }
}
