package com.discord.widgets.chat.list;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.WidgetChatListBinding;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChatList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatList$binding$2 extends C12236k implements Function1<View, WidgetChatListBinding> {
    public static final WidgetChatList$binding$2 INSTANCE = new WidgetChatList$binding$2();

    public WidgetChatList$binding$2() {
        super(1, WidgetChatListBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChatListBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetChatListBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        Objects.requireNonNull(view, "rootView");
        RecyclerView recyclerView = (RecyclerView) view;
        return new WidgetChatListBinding(recyclerView, recyclerView);
    }
}
