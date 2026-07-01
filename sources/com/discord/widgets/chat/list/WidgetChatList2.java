package com.discord.widgets.chat.list;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.WidgetChatListBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.WidgetChatList$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatList2 extends FunctionReferenceImpl implements Function1<View, WidgetChatListBinding> {
    public static final WidgetChatList2 INSTANCE = new WidgetChatList2();

    public WidgetChatList2() {
        super(1, WidgetChatListBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChatListBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetChatListBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        Objects.requireNonNull(view, "rootView");
        RecyclerView recyclerView = (RecyclerView) view;
        return new WidgetChatListBinding(recyclerView, recyclerView);
    }
}
