package com.discord.widgets.chat.managereactions;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetManageReactionsResultUserBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;

/* JADX INFO: compiled from: ManageReactionsResultsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageReactionsResultsAdapter$ReactionUserViewHolder extends MGRecyclerViewHolder<ManageReactionsResultsAdapter, MGRecyclerDataPayload> {
    private final WidgetManageReactionsResultUserBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManageReactionsResultsAdapter$ReactionUserViewHolder(ManageReactionsResultsAdapter manageReactionsResultsAdapter) {
        super(R$layout.widget_manage_reactions_result_user, manageReactionsResultsAdapter);
        m.checkNotNullParameter(manageReactionsResultsAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.manage_reactions_result_remove_reaction;
        ImageView imageView = (ImageView) view.findViewById(R$id.manage_reactions_result_remove_reaction);
        if (imageView != null) {
            i = R$id.manage_reactions_result_user_avatar;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.manage_reactions_result_user_avatar);
            if (simpleDraweeView != null) {
                i = R$id.manage_reactions_result_user_name;
                TextView textView = (TextView) view.findViewById(R$id.manage_reactions_result_user_name);
                if (textView != null) {
                    WidgetManageReactionsResultUserBinding widgetManageReactionsResultUserBinding = new WidgetManageReactionsResultUserBinding((RelativeLayout) view, imageView, simpleDraweeView, textView);
                    m.checkNotNullExpressionValue(widgetManageReactionsResultUserBinding, "WidgetManageReactionsRes…serBinding.bind(itemView)");
                    this.binding = widgetManageReactionsResultUserBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
        onConfigure2(i, mGRecyclerDataPayload);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, MGRecyclerDataPayload data) {
        String username;
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (data instanceof ManageReactionsResultsAdapter$ReactionUserItem) {
            TextView textView = this.binding.d;
            m.checkNotNullExpressionValue(textView, "binding.manageReactionsResultUserName");
            ManageReactionsResultsAdapter$ReactionUserItem manageReactionsResultsAdapter$ReactionUserItem = (ManageReactionsResultsAdapter$ReactionUserItem) data;
            GuildMember guildMember = manageReactionsResultsAdapter$ReactionUserItem.getGuildMember();
            if (guildMember == null || (username = guildMember.getNick()) == null) {
                username = manageReactionsResultsAdapter$ReactionUserItem.getUser().getUsername();
            }
            textView.setText(username);
            SimpleDraweeView simpleDraweeView = this.binding.c;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.manageReactionsResultUserAvatar");
            IconUtils.setIcon$default(simpleDraweeView, manageReactionsResultsAdapter$ReactionUserItem.getUser(), 2131165300, null, null, manageReactionsResultsAdapter$ReactionUserItem.getGuildMember(), 24, null);
            ImageView imageView = this.binding.f2485b;
            m.checkNotNullExpressionValue(imageView, "binding.manageReactionsResultRemoveReaction");
            imageView.setVisibility(manageReactionsResultsAdapter$ReactionUserItem.getCanDelete() ? 0 : 8);
            this.binding.f2485b.setOnClickListener(new ManageReactionsResultsAdapter$ReactionUserViewHolder$onConfigure$1(data));
        }
    }
}
