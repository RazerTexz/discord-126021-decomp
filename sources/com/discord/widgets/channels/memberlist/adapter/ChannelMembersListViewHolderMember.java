package com.discord.widgets.channels.memberlist.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ChannelMembersListViewHolderMember.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMembersListViewHolderMember extends RecyclerView.ViewHolder {
    private final WidgetChannelMembersListItemUserBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelMembersListViewHolderMember(WidgetChannelMembersListItemUserBinding widgetChannelMembersListItemUserBinding) {
        super(widgetChannelMembersListItemUserBinding.f15862a);
        C12238m.checkNotNullParameter(widgetChannelMembersListItemUserBinding, "binding");
        this.binding = widgetChannelMembersListItemUserBinding;
    }

    public final void bind(final ChannelMembersListAdapter.Item.Member data, final Function0<Unit> onClicked) {
        int themedColor;
        C12238m.checkNotNullParameter(data, "data");
        C12238m.checkNotNullParameter(onClicked, "onClicked");
        this.binding.f15862a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListViewHolderMember.bind.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onClicked.invoke();
            }
        });
        UsernameView usernameView = this.binding.f15867f;
        UsernameView.m8566c(usernameView, data.getName(), null, false, null, null, 30);
        Integer color = data.getColor();
        if (color != null) {
            themedColor = color.intValue();
        } else {
            C12238m.checkNotNullExpressionValue(usernameView, "this");
            themedColor = ColorCompat.getThemedColor(usernameView, C5419R.attr.primary_000);
        }
        usernameView.setUsernameColor(themedColor);
        final boolean z2 = data.getPremiumSince() != null;
        UsernameView usernameView2 = this.binding.f15867f;
        boolean zIsBot = data.isBot();
        Integer tagText = data.getTagText();
        usernameView2.m8567a(zIsBot, tagText != null ? tagText.intValue() : C5419R.string.bot_tag_bot, data.getTagVerified());
        ImageView imageView = this.binding.f15866e;
        C12238m.checkNotNullExpressionValue(imageView, "binding.channelMembersListItemGroupOwnerIndicator");
        imageView.setVisibility(data.getShowOwnerIndicator() ? 0 : 8);
        ImageView imageView2 = this.binding.f15864c;
        C12238m.checkNotNullExpressionValue(imageView2, "binding.channelMembersListItemBoostedIndicator");
        imageView2.setVisibility(z2 ? 0 : 8);
        this.binding.f15864c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListViewHolderMember.bind.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (z2) {
                    String readableTimeString = TimeUtils.getReadableTimeString(C1643a.m885x(view, "it", "it.context"), data.getPremiumSince());
                    Context context = view.getContext();
                    Context context2 = view.getContext();
                    C12238m.checkNotNullExpressionValue(context2, "it.context");
                    C0876m.m170h(context, C1107b.m210b(context2, C5419R.string.premium_guild_subscription_tooltip, new Object[]{readableTimeString}, (4 & 4) != 0 ? C1107b.b.f1491j : null), 0, null, 12);
                }
            }
        });
        this.binding.f15868g.setPresence(data.getPresence());
        StatusView statusView = this.binding.f15868g;
        C12238m.checkNotNullExpressionValue(statusView, "binding.channelMembersListItemPresence");
        statusView.setVisibility(UserUtils.INSTANCE.isStatusVisible(data.getUserFlags(), data.getPresence(), true) ? 0 : 8);
        ImageView imageView3 = this.binding.f15869h;
        C12238m.checkNotNullExpressionValue(imageView3, "binding.channelMembersListItemRichPresenceIv");
        imageView3.setVisibility(PresenceUtils.INSTANCE.shouldShowRichPresenceIcon(data.getPresence()) ? 0 : 8);
        Presence presence = data.getPresence();
        boolean zIsApplicationStreaming = data.isApplicationStreaming();
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.f15865d;
        C12238m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.channelMembersListItemGame");
        PresenceUtils.setPresenceText$default(presence, zIsApplicationStreaming, simpleDraweeSpanTextView, false, !data.getCanDisplayStatusEmoji(), 8, null);
        SimpleDraweeView simpleDraweeView = this.binding.f15863b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.channelMembersListItemAvatar");
        IconUtils.setIcon$default(simpleDraweeView, data.getAvatarUrl(), C5419R.dimen.avatar_size_standard, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
    }
}
