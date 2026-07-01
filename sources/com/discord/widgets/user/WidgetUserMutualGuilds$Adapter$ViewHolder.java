package com.discord.widgets.user;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetUserProfileAdapterItemServerBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserMutualGuilds.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMutualGuilds$Adapter$ViewHolder extends MGRecyclerViewHolder<WidgetUserMutualGuilds$Adapter, WidgetUserMutualGuilds$Model$Item> {
    private final WidgetUserProfileAdapterItemServerBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserMutualGuilds$Adapter$ViewHolder(@LayoutRes int i, WidgetUserMutualGuilds$Adapter widgetUserMutualGuilds$Adapter) {
        super(i, widgetUserMutualGuilds$Adapter);
        m.checkNotNullParameter(widgetUserMutualGuilds$Adapter, "adapter");
        View view = this.itemView;
        int i2 = R$id.guild_icon_barrier;
        Barrier barrier = (Barrier) view.findViewById(R$id.guild_icon_barrier);
        if (barrier != null) {
            i2 = R$id.guild_member_avatar;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.guild_member_avatar);
            if (simpleDraweeView != null) {
                i2 = R$id.guild_member_identity_barrier;
                Barrier barrier2 = (Barrier) view.findViewById(R$id.guild_member_identity_barrier);
                if (barrier2 != null) {
                    i2 = R$id.user_profile_adapter_item_server_image;
                    SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) view.findViewById(R$id.user_profile_adapter_item_server_image);
                    if (simpleDraweeView2 != null) {
                        i2 = R$id.user_profile_adapter_item_server_name;
                        TextView textView = (TextView) view.findViewById(R$id.user_profile_adapter_item_server_name);
                        if (textView != null) {
                            i2 = R$id.user_profile_adapter_item_server_text;
                            TextView textView2 = (TextView) view.findViewById(R$id.user_profile_adapter_item_server_text);
                            if (textView2 != null) {
                                i2 = R$id.user_profile_adapter_item_server_wrap;
                                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R$id.user_profile_adapter_item_server_wrap);
                                if (relativeLayout != null) {
                                    i2 = R$id.user_profile_adapter_item_user_display_name;
                                    TextView textView3 = (TextView) view.findViewById(R$id.user_profile_adapter_item_user_display_name);
                                    if (textView3 != null) {
                                        WidgetUserProfileAdapterItemServerBinding widgetUserProfileAdapterItemServerBinding = new WidgetUserProfileAdapterItemServerBinding((ConstraintLayout) view, barrier, simpleDraweeView, barrier2, simpleDraweeView2, textView, textView2, relativeLayout, textView3);
                                        m.checkNotNullExpressionValue(widgetUserProfileAdapterItemServerBinding, "WidgetUserProfileAdapter…verBinding.bind(itemView)");
                                        this.binding = widgetUserProfileAdapterItemServerBinding;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    public static final /* synthetic */ WidgetUserMutualGuilds$Adapter access$getAdapter$p(WidgetUserMutualGuilds$Adapter$ViewHolder widgetUserMutualGuilds$Adapter$ViewHolder) {
        return (WidgetUserMutualGuilds$Adapter) widgetUserMutualGuilds$Adapter$ViewHolder.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetUserMutualGuilds$Model$Item widgetUserMutualGuilds$Model$Item) {
        onConfigure2(i, widgetUserMutualGuilds$Model$Item);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetUserMutualGuilds$Model$Item data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        this.binding.a.setOnClickListener(new WidgetUserMutualGuilds$Adapter$ViewHolder$onConfigure$1(this, data));
        SimpleDraweeView simpleDraweeView = this.binding.c;
        Guild guild = data.getGuild();
        simpleDraweeView.setVisibility((guild != null ? guild.getIcon() : null) == null ? 8 : 0);
        m.checkNotNullExpressionValue(simpleDraweeView, "this");
        IconUtils.setIcon$default((ImageView) simpleDraweeView, data.getGuild(), 0, (MGImages$ChangeDetector) null, false, 28, (Object) null);
        TextView textView = this.binding.e;
        Guild guild2 = data.getGuild();
        textView.setVisibility((guild2 != null ? guild2.getIcon() : null) == null ? 0 : 8);
        Guild guild3 = data.getGuild();
        textView.setText(guild3 != null ? guild3.getShortName() : null);
        TextView textView2 = this.binding.d;
        Guild guild4 = data.getGuild();
        textView2.setText(guild4 != null ? guild4.getName() : null);
        GuildMember guildMember = data.getGuildMember();
        boolean z2 = true;
        boolean z3 = guildMember != null && guildMember.hasAvatar();
        TextView textView3 = this.binding.f;
        String nick = data.getNick();
        if (nick == null) {
            User user = data.getUser();
            nick = user != null ? user.getUsername() : null;
        }
        textView3.setText(nick);
        if (data.getNick() == null && !z3) {
            z2 = false;
        }
        textView3.setVisibility(z2 ? 0 : 8);
        SimpleDraweeView simpleDraweeView2 = this.binding.f2691b;
        simpleDraweeView2.setVisibility(z3 ? 0 : 8);
        if (guildMember != null) {
            String forGuildMember$default = IconUtils.getForGuildMember$default(IconUtils.INSTANCE, guildMember, Integer.valueOf(DimenUtils.dpToPixels(16)), false, 4, null);
            m.checkNotNullExpressionValue(simpleDraweeView2, "this");
            IconUtils.setIcon$default(simpleDraweeView2, forGuildMember$default, 0, (Function1) null, (MGImages$ChangeDetector) null, 28, (Object) null);
        }
    }
}
