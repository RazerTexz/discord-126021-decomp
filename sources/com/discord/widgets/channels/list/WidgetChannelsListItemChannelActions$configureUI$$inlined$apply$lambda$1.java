package com.discord.widgets.channels.list;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import com.discord.models.user.User;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.user.usersheet.WidgetUserSheet$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelsListItemChannelActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ User $dmRecipient$inlined;
    public final /* synthetic */ WidgetChannelsListItemChannelActions this$0;

    public WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$1(WidgetChannelsListItemChannelActions widgetChannelsListItemChannelActions, User user) {
        this.this$0 = widgetChannelsListItemChannelActions;
        this.$dmRecipient$inlined = user;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        User user = this.$dmRecipient$inlined;
        if (user != null) {
            WidgetUserSheet$Companion widgetUserSheet$Companion = WidgetUserSheet.Companion;
            long id2 = user.getId();
            FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetUserSheet$Companion.show$default(widgetUserSheet$Companion, id2, null, parentFragmentManager, null, null, null, null, 122, null);
        }
    }
}
