package com.discord.widgets.chat.input.sticker;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import d0.z.d.m;
import kotlin.Unit;

/* JADX INFO: compiled from: WidgetStickerPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStickerPicker$setUpCategoryRecycler$5 extends RecyclerView$OnScrollListener {
    public final /* synthetic */ WidgetStickerPicker this$0;

    public WidgetStickerPicker$setUpCategoryRecycler$5(WidgetStickerPicker widgetStickerPicker) {
        this.this$0 = widgetStickerPicker;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // androidx.recyclerview.widget.RecyclerView$OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, dx, dy);
        WidgetStickerPicker.access$getStickerCategoryScrollSubject$p(this.this$0).k.onNext((T) Unit.a);
    }
}
