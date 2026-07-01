package com.discord.widgets.chat.input.emoji;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import d0.z.d.m;
import kotlin.Unit;

/* JADX INFO: compiled from: WidgetEmojiPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiPicker$setUpCategoryRecycler$3 extends RecyclerView$OnScrollListener {
    public final /* synthetic */ WidgetEmojiPicker this$0;

    public WidgetEmojiPicker$setUpCategoryRecycler$3(WidgetEmojiPicker widgetEmojiPicker) {
        this.this$0 = widgetEmojiPicker;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // androidx.recyclerview.widget.RecyclerView$OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, dx, dy);
        WidgetEmojiPicker.access$getEmojiCategoryScrollSubject$p(this.this$0).k.onNext((T) Unit.a);
    }
}
