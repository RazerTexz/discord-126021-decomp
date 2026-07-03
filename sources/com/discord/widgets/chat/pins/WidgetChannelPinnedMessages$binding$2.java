package com.discord.widgets.chat.pins;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetChannelPinnedMessagesBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChannelPinnedMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelPinnedMessages$binding$2 extends C12236k implements Function1<View, WidgetChannelPinnedMessagesBinding> {
    public static final WidgetChannelPinnedMessages$binding$2 INSTANCE = new WidgetChannelPinnedMessages$binding$2();

    public WidgetChannelPinnedMessages$binding$2() {
        super(1, WidgetChannelPinnedMessagesBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelPinnedMessagesBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetChannelPinnedMessagesBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.channel_pinned_messages_recycler);
        if (recyclerView != null) {
            return new WidgetChannelPinnedMessagesBinding((CoordinatorLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.channel_pinned_messages_recycler)));
    }
}
