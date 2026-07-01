package com.discord.widgets.guildscheduledevent;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.GuildScheduledEventRsvpUserListAdapterItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.user.UserUtils;
import com.discord.views.StatusView;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildScheduledEventRsvpUserListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventRsvpUserListAdapter$UserViewHolder extends MGRecyclerViewHolder<GuildScheduledEventRsvpUserListAdapter, GuildScheduledEventRsvpUserListItem> {
    private final GuildScheduledEventRsvpUserListAdapterItemBinding binding;
    public final /* synthetic */ GuildScheduledEventRsvpUserListAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventRsvpUserListAdapter$UserViewHolder(GuildScheduledEventRsvpUserListAdapter guildScheduledEventRsvpUserListAdapter) {
        super(R$layout.guild_scheduled_event_rsvp_user_list_adapter_item, guildScheduledEventRsvpUserListAdapter);
        this.this$0 = guildScheduledEventRsvpUserListAdapter;
        View view = this.itemView;
        int i = R$id.user_profile_adapter_item_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.user_profile_adapter_item_avatar);
        if (simpleDraweeView != null) {
            i = R$id.user_profile_adapter_item_discriminator;
            TextView textView = (TextView) view.findViewById(R$id.user_profile_adapter_item_discriminator);
            if (textView != null) {
                i = R$id.user_profile_adapter_item_status;
                StatusView statusView = (StatusView) view.findViewById(R$id.user_profile_adapter_item_status);
                if (statusView != null) {
                    i = R$id.user_profile_adapter_item_user_name;
                    TextView textView2 = (TextView) view.findViewById(R$id.user_profile_adapter_item_user_name);
                    if (textView2 != null) {
                        GuildScheduledEventRsvpUserListAdapterItemBinding guildScheduledEventRsvpUserListAdapterItemBinding = new GuildScheduledEventRsvpUserListAdapterItemBinding((RelativeLayout) view, simpleDraweeView, textView, statusView, textView2);
                        m.checkNotNullExpressionValue(guildScheduledEventRsvpUserListAdapterItemBinding, "GuildScheduledEventRsvpU…temBinding.bind(itemView)");
                        this.binding = guildScheduledEventRsvpUserListAdapterItemBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public final GuildScheduledEventRsvpUserListAdapterItemBinding getBinding() {
        return this.binding;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, GuildScheduledEventRsvpUserListItem guildScheduledEventRsvpUserListItem) {
        onConfigure2(i, guildScheduledEventRsvpUserListItem);
    }

    @SuppressLint({"SetTextI18n"})
    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, GuildScheduledEventRsvpUserListItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        GuildScheduledEventRsvpUserListItem$RsvpUser guildScheduledEventRsvpUserListItem$RsvpUser = (GuildScheduledEventRsvpUserListItem$RsvpUser) data;
        this.itemView.setOnClickListener(new GuildScheduledEventRsvpUserListAdapter$UserViewHolder$onConfigure$1(this, guildScheduledEventRsvpUserListItem$RsvpUser));
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.userProfileAdapterItemUserName");
        textView.setText(guildScheduledEventRsvpUserListItem$RsvpUser.getDisplayName());
        if (guildScheduledEventRsvpUserListItem$RsvpUser.getNickname() == null) {
            TextView textView2 = this.binding.c;
            m.checkNotNullExpressionValue(textView2, "binding.userProfileAdapterItemDiscriminator");
            textView2.setText(UserUtils.INSTANCE.padDiscriminator(guildScheduledEventRsvpUserListItem$RsvpUser.getDiscriminator()));
        }
        String forGuildMember$default = guildScheduledEventRsvpUserListItem$RsvpUser.getGuildAvatar() != null ? IconUtils.getForGuildMember$default(IconUtils.INSTANCE, guildScheduledEventRsvpUserListItem$RsvpUser.getGuildAvatar(), guildScheduledEventRsvpUserListItem$RsvpUser.getGuildId(), guildScheduledEventRsvpUserListItem$RsvpUser.getUserId(), null, false, 24, null) : IconUtils.getForUser$default(Long.valueOf(guildScheduledEventRsvpUserListItem$RsvpUser.getUserId()), guildScheduledEventRsvpUserListItem$RsvpUser.getUserAvatar(), null, false, null, 28, null);
        if (forGuildMember$default != null) {
            SimpleDraweeView simpleDraweeView = this.binding.f2122b;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.userProfileAdapterItemAvatar");
            IconUtils.setIcon$default(simpleDraweeView, forGuildMember$default, 2131165300, (Function1) null, (MGImages$ChangeDetector) null, 24, (Object) null);
        }
    }
}
