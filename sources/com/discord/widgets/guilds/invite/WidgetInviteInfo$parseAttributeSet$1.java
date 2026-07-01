package com.discord.widgets.guilds.invite;

import android.view.ViewGroup$LayoutParams;
import com.discord.views.GuildView;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetInviteInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetInviteInfo$parseAttributeSet$1 implements Runnable {
    public final /* synthetic */ int $size;
    public final /* synthetic */ int $userSize;
    public final /* synthetic */ WidgetInviteInfo this$0;

    public WidgetInviteInfo$parseAttributeSet$1(WidgetInviteInfo widgetInviteInfo, int i, int i2) {
        this.this$0 = widgetInviteInfo;
        this.$size = i;
        this.$userSize = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.$size != 0) {
            GuildView guildView = WidgetInviteInfo.access$getBinding$p(this.this$0).c;
            m.checkNotNullExpressionValue(guildView, "binding.inviteAvatar");
            ViewGroup$LayoutParams layoutParams = guildView.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            int i = this.$size;
            layoutParams.height = i;
            layoutParams.width = i;
            guildView.setLayoutParams(layoutParams);
        }
        if (this.$userSize != 0) {
            SimpleDraweeView simpleDraweeView = WidgetInviteInfo.access$getBinding$p(this.this$0).d;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.inviteAvatarSmall");
            ViewGroup$LayoutParams layoutParams2 = simpleDraweeView.getLayoutParams();
            Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            int i2 = this.$userSize;
            layoutParams2.height = i2;
            layoutParams2.width = i2;
            simpleDraweeView.setLayoutParams(layoutParams2);
        }
    }
}
