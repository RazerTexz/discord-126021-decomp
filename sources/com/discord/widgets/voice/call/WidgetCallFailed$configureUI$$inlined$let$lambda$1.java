package com.discord.widgets.voice.call;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.user.User;

/* JADX INFO: compiled from: WidgetCallFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFailed$configureUI$$inlined$let$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ User $this_configureUI$inlined;
    public final /* synthetic */ WidgetCallFailed this$0;

    public WidgetCallFailed$configureUI$$inlined$let$lambda$1(WidgetCallFailed widgetCallFailed, User user) {
        this.this$0 = widgetCallFailed;
        this.$this_configureUI$inlined = user;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetCallFailed.sendFriendRequest$default(this.this$0, this.$this_configureUI$inlined.getId(), this.$this_configureUI$inlined.getUsername(), null, 4, null);
    }
}
