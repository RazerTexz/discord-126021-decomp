package com.discord.widgets.guilds.invite;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.models.domain.ModelInvite;

/* JADX INFO: compiled from: WidgetGuildInviteShareEmptySuggestions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareEmptySuggestions$updateUi$1 implements View$OnClickListener {
    public final /* synthetic */ ModelInvite $invite;
    public final /* synthetic */ WidgetGuildInviteShareEmptySuggestions this$0;

    public WidgetGuildInviteShareEmptySuggestions$updateUi$1(WidgetGuildInviteShareEmptySuggestions widgetGuildInviteShareEmptySuggestions, ModelInvite modelInvite) {
        this.this$0 = widgetGuildInviteShareEmptySuggestions;
        this.$invite = modelInvite;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        GuildInviteUiHelperKt.copyLinkClick(a.x(view, "it", "it.context"), this.$invite, this.this$0.getMostRecentIntent());
    }
}
