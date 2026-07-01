package com.discord.widgets.channels.memberlist;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersList$recycler$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelMembersList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelMembersList2 extends Lambda implements Function0<RecyclerView> {
    public final /* synthetic */ WidgetChannelMembersList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelMembersList2(WidgetChannelMembersList widgetChannelMembersList) {
        super(0);
        this.this$0 = widgetChannelMembersList;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final RecyclerView invoke() {
        View view = this.this$0.getView();
        Objects.requireNonNull(view, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        return (RecyclerView) view;
    }
}
