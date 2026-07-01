package com.discord.widgets.chat.overlay;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.sticker.Sticker;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.views.sticker.StickerView;
import com.discord.widgets.chat.MessageManager;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetChatOverlay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatOverlay$configureStickerSuggestions$$inlined$forEachIndexed$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ Sticker $matchedSticker$inlined;
    public final /* synthetic */ boolean $shouldClearTextOnSend$inlined;
    public final /* synthetic */ Sticker $sticker;
    public final /* synthetic */ List $stickerMatches$inlined;
    public final /* synthetic */ StickerView $stickerView$inlined;
    public final /* synthetic */ WidgetChatOverlay this$0;

    public WidgetChatOverlay$configureStickerSuggestions$$inlined$forEachIndexed$lambda$1(Sticker sticker, StickerView stickerView, Sticker sticker2, WidgetChatOverlay widgetChatOverlay, List list, boolean z2) {
        this.$sticker = sticker;
        this.$stickerView$inlined = stickerView;
        this.$matchedSticker$inlined = sticker2;
        this.this$0 = widgetChatOverlay;
        this.$stickerMatches$inlined = list;
        this.$shouldClearTextOnSend$inlined = z2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        AnalyticsTracker.INSTANCE.expressionSuggestionsSelected(this.$matchedSticker$inlined.getId(), StoreStream.Companion.getExpressionSuggestions().getLastSuggestionTrigger());
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        WidgetChatOverlay.access$getChatInputViewModel$p(this.this$0).sendSticker(this.$sticker, new MessageManager(context, null, null, null, null, null, null, null, null, 510, null));
        WidgetChatOverlay.access$getFlexInputViewModel$p(this.this$0).onStickerSuggestionSent(this.$shouldClearTextOnSend$inlined);
    }
}
