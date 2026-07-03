package com.discord.widgets.chat.input.sticker;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPicker$setupForInlineSearchAndScroll$$inlined$doOnLayout$1 */
/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewOnLayoutChangeListenerC7928xcd11d8b4 implements View.OnLayoutChangeListener {
    public final /* synthetic */ long $packId$inlined;
    public final /* synthetic */ String $searchText$inlined;
    public final /* synthetic */ WidgetStickerPicker this$0;

    public ViewOnLayoutChangeListenerC7928xcd11d8b4(WidgetStickerPicker widgetStickerPicker, String str, long j) {
        this.this$0 = widgetStickerPicker;
        this.$searchText$inlined = str;
        this.$packId$inlined = j;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        C12238m.checkNotNullParameter(view, "view");
        view.removeOnLayoutChangeListener(this);
        this.this$0.getViewModel().setSearchText(this.$searchText$inlined);
        this.this$0.getViewModel().setSelectedCategoryId(this.$packId$inlined);
        RecyclerView recyclerView = this.this$0.getBinding().f18198k;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.chatInputStickerPickerRecycler");
        if (!ViewCompat.isLaidOut(recyclerView) || recyclerView.isLayoutRequested()) {
            recyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.discord.widgets.chat.input.sticker.WidgetStickerPicker$setupForInlineSearchAndScroll$$inlined$doOnLayout$1$lambda$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int left2, int top2, int right2, int bottom2, int oldLeft2, int oldTop2, int oldRight2, int oldBottom2) {
                    C12238m.checkNotNullParameter(view2, "view");
                    view2.removeOnLayoutChangeListener(this);
                    ViewOnLayoutChangeListenerC7928xcd11d8b4 viewOnLayoutChangeListenerC7928xcd11d8b4 = this.this$0;
                    viewOnLayoutChangeListenerC7928xcd11d8b4.this$0.scrollToPack(Long.valueOf(viewOnLayoutChangeListenerC7928xcd11d8b4.$packId$inlined));
                }
            });
        } else {
            this.this$0.scrollToPack(Long.valueOf(this.$packId$inlined));
        }
    }
}
