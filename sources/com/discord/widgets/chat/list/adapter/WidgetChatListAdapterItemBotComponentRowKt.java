package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.discord.models.botuikit.MessageComponent;
import com.discord.widgets.botuikit.views.ComponentView;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetChatListAdapterItemBotComponentRow.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemBotComponentRowKt {
    public static final void replaceViews(ViewGroup viewGroup, List<? extends ComponentView<? extends MessageComponent>> list) {
        m.checkNotNullParameter(viewGroup, "$this$replaceViews");
        m.checkNotNullParameter(list, "views");
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                n.throwIndexOverflow();
            }
            Object obj2 = (ComponentView) obj;
            if (i >= viewGroup.getChildCount()) {
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type android.view.View");
                viewGroup.addView((View) obj2, i);
            } else if (viewGroup.getChildAt(i) != obj2) {
                viewGroup.removeViewAt(i);
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type android.view.View");
                viewGroup.addView((View) obj2, i);
            }
            i = i2;
        }
        if (list.size() < viewGroup.getChildCount()) {
            viewGroup.removeViews(list.size(), viewGroup.getChildCount() - list.size());
        }
    }
}
