package com.discord.widgets.guildscheduledevent;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.GuildScheduledEventRsvpUserListAdapterItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.user.UserUtils;
import com.discord.views.StatusView;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildScheduledEventRsvpUserListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventRsvpUserListAdapter extends MGRecyclerAdapterSimple<GuildScheduledEventRsvpUserListItem> {
    private final Function1<Long, Unit> onItemClick;

    /* JADX INFO: compiled from: GuildScheduledEventRsvpUserListAdapter.kt */
    public final class UserViewHolder extends MGRecyclerViewHolder<GuildScheduledEventRsvpUserListAdapter, GuildScheduledEventRsvpUserListItem> {
        private final GuildScheduledEventRsvpUserListAdapterItemBinding binding;

        public UserViewHolder() {
            super(C5419R.layout.guild_scheduled_event_rsvp_user_list_adapter_item, GuildScheduledEventRsvpUserListAdapter.this);
            View view = this.itemView;
            int i = C5419R.id.user_profile_adapter_item_avatar;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.user_profile_adapter_item_avatar);
            if (simpleDraweeView != null) {
                i = C5419R.id.user_profile_adapter_item_discriminator;
                TextView textView = (TextView) view.findViewById(C5419R.id.user_profile_adapter_item_discriminator);
                if (textView != null) {
                    i = C5419R.id.user_profile_adapter_item_status;
                    StatusView statusView = (StatusView) view.findViewById(C5419R.id.user_profile_adapter_item_status);
                    if (statusView != null) {
                        i = C5419R.id.user_profile_adapter_item_user_name;
                        TextView textView2 = (TextView) view.findViewById(C5419R.id.user_profile_adapter_item_user_name);
                        if (textView2 != null) {
                            GuildScheduledEventRsvpUserListAdapterItemBinding guildScheduledEventRsvpUserListAdapterItemBinding = new GuildScheduledEventRsvpUserListAdapterItemBinding((RelativeLayout) view, simpleDraweeView, textView, statusView, textView2);
                            C12238m.checkNotNullExpressionValue(guildScheduledEventRsvpUserListAdapterItemBinding, "GuildScheduledEventRsvpU…temBinding.bind(itemView)");
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
        @SuppressLint({"SetTextI18n"})
        public void onConfigure(int position, GuildScheduledEventRsvpUserListItem data) {
            C12238m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            final GuildScheduledEventRsvpUserListItem.RsvpUser rsvpUser = (GuildScheduledEventRsvpUserListItem.RsvpUser) data;
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.GuildScheduledEventRsvpUserListAdapter$UserViewHolder$onConfigure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildScheduledEventRsvpUserListAdapter.this.onItemClick.invoke(Long.valueOf(rsvpUser.getUserId()));
                }
            });
            TextView textView = this.binding.f15155d;
            C12238m.checkNotNullExpressionValue(textView, "binding.userProfileAdapterItemUserName");
            textView.setText(rsvpUser.getDisplayName());
            if (rsvpUser.getNickname() == null) {
                TextView textView2 = this.binding.f15154c;
                C12238m.checkNotNullExpressionValue(textView2, "binding.userProfileAdapterItemDiscriminator");
                textView2.setText(UserUtils.INSTANCE.padDiscriminator(rsvpUser.getDiscriminator()));
            }
            String forGuildMember = rsvpUser.getGuildAvatar() != null ? IconUtils.INSTANCE.getForGuildMember(rsvpUser.getGuildAvatar(), rsvpUser.getGuildId(), rsvpUser.getUserId(), (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? false : false) : IconUtils.getForUser$default(Long.valueOf(rsvpUser.getUserId()), rsvpUser.getUserAvatar(), null, false, null, 28, null);
            if (forGuildMember != null) {
                SimpleDraweeView simpleDraweeView = this.binding.f15153b;
                C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.userProfileAdapterItemAvatar");
                IconUtils.setIcon$default(simpleDraweeView, forGuildMember, C5419R.dimen.avatar_size_standard, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildScheduledEventRsvpUserListAdapter(RecyclerView recyclerView, Function1<? super Long, Unit> function1) {
        super(recyclerView, false, 2, null);
        C12238m.checkNotNullParameter(recyclerView, "recyclerView");
        C12238m.checkNotNullParameter(function1, "onItemClick");
        this.onItemClick = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, GuildScheduledEventRsvpUserListItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        C12238m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new UserViewHolder();
        }
        throw invalidViewTypeException(viewType);
    }
}
