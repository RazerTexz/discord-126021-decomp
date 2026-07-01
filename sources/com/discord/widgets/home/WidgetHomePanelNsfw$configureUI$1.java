package com.discord.widgets.home;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetHomePanelNsfw.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHomePanelNsfw$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ Function0 $onDenyNsfw;
    public final /* synthetic */ WidgetHomePanelNsfw this$0;

    public WidgetHomePanelNsfw$configureUI$1(WidgetHomePanelNsfw widgetHomePanelNsfw, long j, Function0 function0) {
        this.this$0 = widgetHomePanelNsfw;
        this.$guildId = j;
        this.$onDenyNsfw = function0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetHomePanelNsfw.access$getGuildsNsfwStore$p(this.this$0).deny(this.$guildId);
        Function0 function0 = this.$onDenyNsfw;
        if (function0 != null) {
        }
    }
}
