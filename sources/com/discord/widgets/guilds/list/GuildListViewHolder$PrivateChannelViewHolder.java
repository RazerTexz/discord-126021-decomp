package com.discord.widgets.guilds.list;

import android.view.View;
import android.widget.TextView;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$plurals;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.WidgetGuildsListItemDmBinding;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildListViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildListViewHolder$PrivateChannelViewHolder extends GuildListViewHolder {
    private final WidgetGuildsListItemDmBinding binding;
    private final Function1<GuildListItem$PrivateChannelItem, Unit> onClicked;
    private final Function1<GuildListItem$PrivateChannelItem, Unit> onLongPressed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildListViewHolder$PrivateChannelViewHolder(View view, Function1<? super GuildListItem$PrivateChannelItem, Unit> function1, Function1<? super GuildListItem$PrivateChannelItem, Unit> function2) {
        super(view, null);
        m.checkNotNullParameter(view, "view");
        m.checkNotNullParameter(function1, "onClicked");
        m.checkNotNullParameter(function2, "onLongPressed");
        this.onClicked = function1;
        this.onLongPressed = function2;
        WidgetGuildsListItemDmBinding widgetGuildsListItemDmBindingA = WidgetGuildsListItemDmBinding.a(view);
        m.checkNotNullExpressionValue(widgetGuildsListItemDmBindingA, "WidgetGuildsListItemDmBinding.bind(view)");
        this.binding = widgetGuildsListItemDmBindingA;
    }

    public static final /* synthetic */ Function1 access$getOnClicked$p(GuildListViewHolder$PrivateChannelViewHolder guildListViewHolder$PrivateChannelViewHolder) {
        return guildListViewHolder$PrivateChannelViewHolder.onClicked;
    }

    public static final /* synthetic */ Function1 access$getOnLongPressed$p(GuildListViewHolder$PrivateChannelViewHolder guildListViewHolder$PrivateChannelViewHolder) {
        return guildListViewHolder$PrivateChannelViewHolder.onLongPressed;
    }

    public final void configure(GuildListItem$PrivateChannelItem data) {
        m.checkNotNullParameter(data, "data");
        int mentionCount = data.getMentionCount();
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.guildsItemDmCount");
        configureMentionsCount(textView, mentionCount);
        Object i18nPluralString = mentionCount > 0 ? StringResourceUtilsKt.getI18nPluralString(a.x(this.itemView, "itemView", "itemView.context"), R$plurals.dm_tooltip_a11y_label_mentions, mentionCount, Integer.valueOf(mentionCount)) : "";
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        View view2 = this.itemView;
        m.checkNotNullExpressionValue(view2, "itemView");
        view.setContentDescription(b.j(view2, 2131888575, new Object[]{ChannelUtils.c(data.getChannel()), i18nPluralString}, null, 4));
        SimpleDraweeView simpleDraweeView = this.binding.f2459b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildsItemDmAvatar");
        IconUtils.setIcon$default(simpleDraweeView, data.getChannel(), 2131165293, (MGImages$ChangeDetector) null, 8, (Object) null);
        this.itemView.setOnClickListener(new GuildListViewHolder$PrivateChannelViewHolder$configure$1(this, data));
        View view3 = this.itemView;
        m.checkNotNullExpressionValue(view3, "itemView");
        ViewExtensions.setOnLongClickListenerConsumeClick(view3, new GuildListViewHolder$PrivateChannelViewHolder$configure$2(this, data));
    }
}
