package com.discord.widgets.chat.list;

import android.view.View;
import android.view.View$OnClickListener;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ViewEmbedGameInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewEmbedGameInvite$onConfigureActionButton$1 implements View$OnClickListener {
    public final /* synthetic */ ViewEmbedGameInvite$Model $this_onConfigureActionButton;
    public final /* synthetic */ ViewEmbedGameInvite this$0;

    public ViewEmbedGameInvite$onConfigureActionButton$1(ViewEmbedGameInvite viewEmbedGameInvite, ViewEmbedGameInvite$Model viewEmbedGameInvite$Model) {
        this.this$0 = viewEmbedGameInvite;
        this.$this_onConfigureActionButton = viewEmbedGameInvite$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Function2<View, ViewEmbedGameInvite$Model, Unit> onActionButtonClick = this.this$0.getOnActionButtonClick();
        if (onActionButtonClick != null) {
            m.checkNotNullExpressionValue(view, "it");
            onActionButtonClick.invoke(view, this.$this_onConfigureActionButton);
        }
    }
}
