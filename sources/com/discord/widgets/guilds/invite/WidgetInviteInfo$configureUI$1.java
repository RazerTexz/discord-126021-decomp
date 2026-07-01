package com.discord.widgets.guilds.invite;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetInviteInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetInviteInfo$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ Function0 $onAcceptClick;

    public WidgetInviteInfo$configureUI$1(Function0 function0) {
        this.$onAcceptClick = function0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onAcceptClick.invoke();
    }
}
