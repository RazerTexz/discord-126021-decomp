package com.discord.widgets.channels.memberlist.adapter;

import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.databinding.WidgetChannelMembersListItemUserBinding;
import com.discord.models.presence.Presence;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.StatusView;
import com.discord.views.UsernameView;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ChannelMembersListViewHolderMember.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMembersListViewHolderMember extends RecyclerView$ViewHolder {
    private final WidgetChannelMembersListItemUserBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelMembersListViewHolderMember(WidgetChannelMembersListItemUserBinding widgetChannelMembersListItemUserBinding) {
        super(widgetChannelMembersListItemUserBinding.a);
        m.checkNotNullParameter(widgetChannelMembersListItemUserBinding, "binding");
        this.binding = widgetChannelMembersListItemUserBinding;
    }

    public final void bind(ChannelMembersListAdapter$Item$Member data, Function0<Unit> onClicked) {
        int themedColor;
        m.checkNotNullParameter(data, "data");
        m.checkNotNullParameter(onClicked, "onClicked");
        this.binding.a.setOnClickListener(new ChannelMembersListViewHolderMember$bind$1(onClicked));
        UsernameView usernameView = this.binding.f;
        UsernameView.c(usernameView, data.getName(), null, false, null, null, 30);
        Integer color = data.getColor();
        if (color != null) {
            themedColor = color.intValue();
        } else {
            m.checkNotNullExpressionValue(usernameView, "this");
            themedColor = ColorCompat.getThemedColor(usernameView, 2130969970);
        }
        usernameView.setUsernameColor(themedColor);
        boolean z2 = data.getPremiumSince() != null;
        UsernameView usernameView2 = this.binding.f;
        boolean zIsBot = data.isBot();
        Integer tagText = data.getTagText();
        usernameView2.a(zIsBot, tagText != null ? tagText.intValue() : 2131887282, data.getTagVerified());
        ImageView imageView = this.binding.e;
        m.checkNotNullExpressionValue(imageView, "binding.channelMembersListItemGroupOwnerIndicator");
        imageView.setVisibility(data.getShowOwnerIndicator() ? 0 : 8);
        ImageView imageView2 = this.binding.c;
        m.checkNotNullExpressionValue(imageView2, "binding.channelMembersListItemBoostedIndicator");
        imageView2.setVisibility(z2 ? 0 : 8);
        this.binding.c.setOnClickListener(new ChannelMembersListViewHolderMember$bind$3(z2, data));
        this.binding.g.setPresence(data.getPresence());
        StatusView statusView = this.binding.g;
        m.checkNotNullExpressionValue(statusView, "binding.channelMembersListItemPresence");
        statusView.setVisibility(UserUtils.INSTANCE.isStatusVisible(data.getUserFlags(), data.getPresence(), true) ? 0 : 8);
        ImageView imageView3 = this.binding.h;
        m.checkNotNullExpressionValue(imageView3, "binding.channelMembersListItemRichPresenceIv");
        imageView3.setVisibility(PresenceUtils.INSTANCE.shouldShowRichPresenceIcon(data.getPresence()) ? 0 : 8);
        Presence presence = data.getPresence();
        boolean zIsApplicationStreaming = data.isApplicationStreaming();
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.d;
        m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.channelMembersListItemGame");
        PresenceUtils.setPresenceText$default(presence, zIsApplicationStreaming, simpleDraweeSpanTextView, false, !data.getCanDisplayStatusEmoji(), 8, null);
        SimpleDraweeView simpleDraweeView = this.binding.f2261b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.channelMembersListItemAvatar");
        IconUtils.setIcon$default(simpleDraweeView, data.getAvatarUrl(), 2131165300, (Function1) null, (MGImages$ChangeDetector) null, 24, (Object) null);
    }
}
