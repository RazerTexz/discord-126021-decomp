package com.discord.widgets.chat.input.emoji;

import android.view.View;
import android.view.View$OnClickListener;
import b.i.a.f.e.o.f;
import com.discord.utilities.views.ViewCoroutineScopeKt;
import d0.z.d.m;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: WidgetEmojiPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiPicker$initializeSearchBar$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetEmojiPicker this$0;

    public WidgetEmojiPicker$initializeSearchBar$1(WidgetEmojiPicker widgetEmojiPicker) {
        this.this$0 = widgetEmojiPicker;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        m.checkNotNullExpressionValue(view, "view");
        CoroutineScope coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(view);
        if (coroutineScope != null) {
            f.H0(coroutineScope, null, null, new WidgetEmojiPicker$initializeSearchBar$1$1(this, null), 3, null);
        }
        WidgetEmojiPicker.access$launchBottomSheet(this.this$0);
    }
}
