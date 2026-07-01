package com.discord.widgets.channels.memberlist.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppToast;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.WidgetChannelMembersListItemUserBinding;
import com.discord.models.presence.Presence;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.StatusView;
import com.discord.views.UsernameView;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ChannelMembersListViewHolderMember.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMembersListViewHolderMember extends RecyclerView.ViewHolder {
    private final WidgetChannelMembersListItemUserBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelMembersListViewHolderMember(WidgetChannelMembersListItemUserBinding widgetChannelMembersListItemUserBinding) {
        super(widgetChannelMembersListItemUserBinding.a);
        Intrinsics3.checkNotNullParameter(widgetChannelMembersListItemUserBinding, "binding");
        this.binding = widgetChannelMembersListItemUserBinding;
    }

    public final void bind(final ChannelMembersListAdapter.Item.Member data, final Function0<Unit> onClicked) {
        int themedColor;
        Intrinsics3.checkNotNullParameter(data, "data");
        Intrinsics3.checkNotNullParameter(onClicked, "onClicked");
        this.binding.a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListViewHolderMember.bind.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onClicked.invoke();
            }
        });
        UsernameView usernameView = this.binding.f;
        UsernameView.c(usernameView, data.getName(), null, false, null, null, 30);
        Integer color = data.getColor();
        if (color != null) {
            themedColor = color.intValue();
        } else {
            Intrinsics3.checkNotNullExpressionValue(usernameView, "this");
            themedColor = ColorCompat.getThemedColor(usernameView, R.attr.primary_000);
        }
        usernameView.setUsernameColor(themedColor);
        final boolean z2 = data.getPremiumSince() != null;
        UsernameView usernameView2 = this.binding.f;
        boolean zIsBot = data.isBot();
        Integer tagText = data.getTagText();
        usernameView2.a(zIsBot, tagText != null ? tagText.intValue() : R.string.bot_tag_bot, data.getTagVerified());
        ImageView imageView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.channelMembersListItemGroupOwnerIndicator");
        imageView.setVisibility(data.getShowOwnerIndicator() ? 0 : 8);
        ImageView imageView2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.channelMembersListItemBoostedIndicator");
        imageView2.setVisibility(z2 ? 0 : 8);
        this.binding.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListViewHolderMember.bind.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (z2) {
                    String readableTimeString = TimeUtils.getReadableTimeString(outline.x(view, "it", "it.context"), data.getPremiumSince());
                    Context context = view.getContext();
                    Context context2 = view.getContext();
                    Intrinsics3.checkNotNullExpressionValue(context2, "it.context");
                    AppToast.h(context, FormatUtils.b(context2, R.string.premium_guild_subscription_tooltip, new Object[]{readableTimeString}, (4 & 4) != 0 ? FormatUtils.b.j : null), 0, null, 12);
                }
            }
        });
        this.binding.g.setPresence(data.getPresence());
        StatusView statusView = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(statusView, "binding.channelMembersListItemPresence");
        statusView.setVisibility(UserUtils.INSTANCE.isStatusVisible(data.getUserFlags(), data.getPresence(), true) ? 0 : 8);
        ImageView imageView3 = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.channelMembersListItemRichPresenceIv");
        imageView3.setVisibility(PresenceUtils.INSTANCE.shouldShowRichPresenceIcon(data.getPresence()) ? 0 : 8);
        Presence presence = data.getPresence();
        boolean zIsApplicationStreaming = data.isApplicationStreaming();
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.channelMembersListItemGame");
        PresenceUtils.setPresenceText$default(presence, zIsApplicationStreaming, simpleDraweeSpanTextView, false, !data.getCanDisplayStatusEmoji(), 8, null);
        SimpleDraweeView simpleDraweeView = this.binding.f2261b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.channelMembersListItemAvatar");
        IconUtils.setIcon$default(simpleDraweeView, data.getAvatarUrl(), R.dimen.avatar_size_standard, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
    }
}
