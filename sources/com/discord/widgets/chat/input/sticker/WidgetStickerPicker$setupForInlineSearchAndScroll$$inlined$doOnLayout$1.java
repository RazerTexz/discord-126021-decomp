package com.discord.widgets.chat.input.sticker;

import android.view.View;
import android.view.View$OnLayoutChangeListener;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import d0.z.d.m;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStickerPicker$setupForInlineSearchAndScroll$$inlined$doOnLayout$1 implements View$OnLayoutChangeListener {
    public final /* synthetic */ long $packId$inlined;
    public final /* synthetic */ String $searchText$inlined;
    public final /* synthetic */ WidgetStickerPicker this$0;

    public WidgetStickerPicker$setupForInlineSearchAndScroll$$inlined$doOnLayout$1(WidgetStickerPicker widgetStickerPicker, String str, long j) {
        this.this$0 = widgetStickerPicker;
        this.$searchText$inlined = str;
        this.$packId$inlined = j;
    }

    @Override // android.view.View$OnLayoutChangeListener
    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        m.checkNotNullParameter(view, "view");
        view.removeOnLayoutChangeListener(this);
        WidgetStickerPicker.access$getViewModel$p(this.this$0).setSearchText(this.$searchText$inlined);
        WidgetStickerPicker.access$getViewModel$p(this.this$0).setSelectedCategoryId(this.$packId$inlined);
        RecyclerView recyclerView = WidgetStickerPicker.access$getBinding$p(this.this$0).k;
        m.checkNotNullExpressionValue(recyclerView, "binding.chatInputStickerPickerRecycler");
        if (!ViewCompat.isLaidOut(recyclerView) || recyclerView.isLayoutRequested()) {
            recyclerView.addOnLayoutChangeListener(new WidgetStickerPicker$setupForInlineSearchAndScroll$$inlined$doOnLayout$1$lambda$1(this));
        } else {
            this.this$0.scrollToPack(Long.valueOf(this.$packId$inlined));
        }
    }
}
