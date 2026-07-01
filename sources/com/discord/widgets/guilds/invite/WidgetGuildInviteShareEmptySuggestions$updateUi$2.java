package com.discord.widgets.guilds.invite;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.domain.ModelInvite;

/* JADX INFO: compiled from: WidgetGuildInviteShareEmptySuggestions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareEmptySuggestions$updateUi$2 implements View$OnClickListener {
    public final /* synthetic */ ModelInvite $invite;
    public final /* synthetic */ WidgetGuildInviteShareEmptySuggestions this$0;

    public WidgetGuildInviteShareEmptySuggestions$updateUi$2(WidgetGuildInviteShareEmptySuggestions widgetGuildInviteShareEmptySuggestions, ModelInvite modelInvite) {
        this.this$0 = widgetGuildInviteShareEmptySuggestions;
        this.$invite = modelInvite;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ModelInvite modelInvite = this.$invite;
        if (modelInvite != null) {
            GuildInviteUiHelperKt.shareLinkClick(this.this$0.getContext(), modelInvite);
        }
    }
}
