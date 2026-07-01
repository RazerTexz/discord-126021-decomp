package com.discord.widgets.chat.input.sticker;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStickerPicker$setupForInlineSearchAndScroll$$inlined$doOnLayout$1 implements View.OnLayoutChangeListener {
    public final /* synthetic */ long $packId$inlined;
    public final /* synthetic */ String $searchText$inlined;
    public final /* synthetic */ WidgetStickerPicker this$0;

    public WidgetStickerPicker$setupForInlineSearchAndScroll$$inlined$doOnLayout$1(WidgetStickerPicker widgetStickerPicker, String str, long j) {
        this.this$0 = widgetStickerPicker;
        this.$searchText$inlined = str;
        this.$packId$inlined = j;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        Intrinsics3.checkNotNullParameter(view, "view");
        view.removeOnLayoutChangeListener(this);
        this.this$0.getViewModel().setSearchText(this.$searchText$inlined);
        this.this$0.getViewModel().setSelectedCategoryId(this.$packId$inlined);
        RecyclerView recyclerView = this.this$0.getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.chatInputStickerPickerRecycler");
        if (!ViewCompat.isLaidOut(recyclerView) || recyclerView.isLayoutRequested()) {
            recyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.discord.widgets.chat.input.sticker.WidgetStickerPicker$setupForInlineSearchAndScroll$$inlined$doOnLayout$1$lambda$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int left2, int top2, int right2, int bottom2, int oldLeft2, int oldTop2, int oldRight2, int oldBottom2) {
                    Intrinsics3.checkNotNullParameter(view2, "view");
                    view2.removeOnLayoutChangeListener(this);
                    WidgetStickerPicker$setupForInlineSearchAndScroll$$inlined$doOnLayout$1 widgetStickerPicker$setupForInlineSearchAndScroll$$inlined$doOnLayout$1 = this.this$0;
                    widgetStickerPicker$setupForInlineSearchAndScroll$$inlined$doOnLayout$1.this$0.scrollToPack(Long.valueOf(widgetStickerPicker$setupForInlineSearchAndScroll$$inlined$doOnLayout$1.$packId$inlined));
                }
            });
        } else {
            this.this$0.scrollToPack(Long.valueOf(this.$packId$inlined));
        }
    }
}
