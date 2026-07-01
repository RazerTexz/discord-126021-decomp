package com.discord.widgets.chat.pins;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetChannelPinnedMessagesBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.chat.pins.WidgetChannelPinnedMessages$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelPinnedMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelPinnedMessages3 extends FunctionReferenceImpl implements Function1<View, WidgetChannelPinnedMessagesBinding> {
    public static final WidgetChannelPinnedMessages3 INSTANCE = new WidgetChannelPinnedMessages3();

    public WidgetChannelPinnedMessages3() {
        super(1, WidgetChannelPinnedMessagesBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelPinnedMessagesBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetChannelPinnedMessagesBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.channel_pinned_messages_recycler);
        if (recyclerView != null) {
            return new WidgetChannelPinnedMessagesBinding((CoordinatorLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.channel_pinned_messages_recycler)));
    }
}
