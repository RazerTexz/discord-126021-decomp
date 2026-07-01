package com.discord.widgets.home;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHomePanelNsfw.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHomePanelNsfw$configureUI$2 implements View$OnClickListener {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ Function1 $onToggleNsfw;
    public final /* synthetic */ WidgetHomePanelNsfw this$0;

    public WidgetHomePanelNsfw$configureUI$2(WidgetHomePanelNsfw widgetHomePanelNsfw, long j, Function1 function1) {
        this.this$0 = widgetHomePanelNsfw;
        this.$guildId = j;
        this.$onToggleNsfw = function1;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetHomePanelNsfw.access$getGuildsNsfwStore$p(this.this$0).allow(this.$guildId);
        WidgetHomePanelNsfw.access$setContainerViewHidden(this.this$0, true, this.$onToggleNsfw);
    }
}
