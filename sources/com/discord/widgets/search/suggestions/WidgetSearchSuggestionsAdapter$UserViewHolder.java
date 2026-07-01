package com.discord.widgets.search.suggestions;

import android.view.View;
import android.widget.TextView;
import com.discord.R$layout;
import com.discord.databinding.WidgetSearchSuggestionsItemUserBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.mg_recycler.SingleTypePayload;
import com.discord.utilities.search.suggestion.entries.UserSuggestion;
import com.discord.utilities.user.UserUtils;
import com.discord.views.StatusView;
import com.discord.views.UserListItemView;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetSearchSuggestionsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchSuggestionsAdapter$UserViewHolder extends MGRecyclerViewHolder<WidgetSearchSuggestionsAdapter, MGRecyclerDataPayload> {
    private final WidgetSearchSuggestionsItemUserBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSearchSuggestionsAdapter$UserViewHolder(WidgetSearchSuggestionsAdapter widgetSearchSuggestionsAdapter) {
        super(R$layout.widget_search_suggestions_item_user, widgetSearchSuggestionsAdapter);
        m.checkNotNullParameter(widgetSearchSuggestionsAdapter, "searchSuggestionsAdapter");
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        UserListItemView userListItemView = (UserListItemView) view;
        WidgetSearchSuggestionsItemUserBinding widgetSearchSuggestionsItemUserBinding = new WidgetSearchSuggestionsItemUserBinding(userListItemView, userListItemView);
        m.checkNotNullExpressionValue(widgetSearchSuggestionsItemUserBinding, "WidgetSearchSuggestionsI…serBinding.bind(itemView)");
        this.binding = widgetSearchSuggestionsItemUserBinding;
    }

    public static final /* synthetic */ WidgetSearchSuggestionsAdapter access$getAdapter$p(WidgetSearchSuggestionsAdapter$UserViewHolder widgetSearchSuggestionsAdapter$UserViewHolder) {
        return (WidgetSearchSuggestionsAdapter) widgetSearchSuggestionsAdapter$UserViewHolder.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
        onConfigure2(i, mGRecyclerDataPayload);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, MGRecyclerDataPayload data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        UserSuggestion userSuggestion = (UserSuggestion) ((SingleTypePayload) data).getData();
        UserListItemView userListItemView = this.binding.f2531b;
        User user = userSuggestion.getUser();
        GuildMember guildMember = userSuggestion.getGuildMember();
        int i = UserListItemView.j;
        Objects.requireNonNull(userListItemView);
        m.checkNotNullParameter(user, "user");
        StringBuilder sb = new StringBuilder();
        sb.append(user.getUsername());
        UserUtils userUtils = UserUtils.INSTANCE;
        sb.append(userUtils.getDiscriminatorWithPadding(user));
        String string = sb.toString();
        String nick = guildMember != null ? guildMember.getNick() : null;
        if (nick == null || nick.length() == 0) {
            TextView textView = userListItemView.binding.c;
            m.checkNotNullExpressionValue(textView, "binding.userListItemName");
            textView.setText(string);
            TextView textView2 = userListItemView.binding.d;
            m.checkNotNullExpressionValue(textView2, "binding.userListItemNameSecondary");
            textView2.setText("");
        } else {
            TextView textView3 = userListItemView.binding.c;
            m.checkNotNullExpressionValue(textView3, "binding.userListItemName");
            textView3.setText(nick);
            TextView textView4 = userListItemView.binding.d;
            m.checkNotNullExpressionValue(textView4, "binding.userListItemNameSecondary");
            textView4.setText(string);
        }
        SimpleDraweeView simpleDraweeView = userListItemView.binding.f99b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.userListItemAvatar");
        IconUtils.setIcon$default(simpleDraweeView, user, 2131165300, null, null, guildMember, 24, null);
        userListItemView.binding.e.setPresence(null);
        StatusView statusView = userListItemView.binding.e;
        m.checkNotNullExpressionValue(statusView, "binding.userListItemStatus");
        statusView.setVisibility(userUtils.isStatusVisible(user, (Presence) null, false) ? 0 : 8);
        this.binding.f2531b.setOnClickListener(new WidgetSearchSuggestionsAdapter$UserViewHolder$onConfigure$1(this, userSuggestion));
    }
}
