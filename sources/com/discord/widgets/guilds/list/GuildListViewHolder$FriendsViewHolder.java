package com.discord.widgets.guilds.list;

import android.content.res.ColorStateList;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetGuildsListItemProfileBinding;
import com.discord.utilities.color.ColorCompat;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildListViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildListViewHolder$FriendsViewHolder extends GuildListViewHolder {
    private final WidgetGuildsListItemProfileBinding binding;
    private final Function1<GuildListItem$FriendsItem, Unit> onClicked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildListViewHolder$FriendsViewHolder(View view, Function1<? super GuildListItem$FriendsItem, Unit> function1) {
        super(view, null);
        m.checkNotNullParameter(view, "view");
        m.checkNotNullParameter(function1, "onClicked");
        this.onClicked = function1;
        int i = R$id.guilds_item_profile_avatar;
        ImageView imageView = (ImageView) view.findViewById(R$id.guilds_item_profile_avatar);
        if (imageView != null) {
            i = R$id.guilds_item_profile_avatar_wrap;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R$id.guilds_item_profile_avatar_wrap);
            if (frameLayout != null) {
                i = R$id.guilds_item_profile_selected;
                ImageView imageView2 = (ImageView) view.findViewById(R$id.guilds_item_profile_selected);
                if (imageView2 != null) {
                    WidgetGuildsListItemProfileBinding widgetGuildsListItemProfileBinding = new WidgetGuildsListItemProfileBinding((RelativeLayout) view, imageView, frameLayout, imageView2);
                    m.checkNotNullExpressionValue(widgetGuildsListItemProfileBinding, "WidgetGuildsListItemProfileBinding.bind(view)");
                    this.binding = widgetGuildsListItemProfileBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ Function1 access$getOnClicked$p(GuildListViewHolder$FriendsViewHolder guildListViewHolder$FriendsViewHolder) {
        return guildListViewHolder$FriendsViewHolder.onClicked;
    }

    public final void configure(GuildListItem$FriendsItem data) {
        m.checkNotNullParameter(data, "data");
        ImageView imageView = this.binding.d;
        m.checkNotNullExpressionValue(imageView, "binding.guildsItemProfileSelected");
        imageView.setVisibility(data.isSelected() ? 0 : 8);
        this.binding.a.setOnClickListener(new GuildListViewHolder$FriendsViewHolder$configure$1(this, data));
        if (data.isSelected()) {
            this.binding.c.setBackgroundResource(2131231314);
            FrameLayout frameLayout = this.binding.c;
            m.checkNotNullExpressionValue(frameLayout, "binding.guildsItemProfileAvatarWrap");
            frameLayout.setBackgroundTintList(null);
        } else {
            this.binding.c.setBackgroundResource(2131231172);
            FrameLayout frameLayout2 = this.binding.c;
            m.checkNotNullExpressionValue(frameLayout2, "binding.guildsItemProfileAvatarWrap");
            int themedColor = ColorCompat.getThemedColor(frameLayout2, 2130968912);
            FrameLayout frameLayout3 = this.binding.c;
            m.checkNotNullExpressionValue(frameLayout3, "binding.guildsItemProfileAvatarWrap");
            frameLayout3.setBackgroundTintList(ColorStateList.valueOf(themedColor));
        }
        if (data.isSelected()) {
            ImageView imageView2 = this.binding.f2464b;
            m.checkNotNullExpressionValue(imageView2, "binding.guildsItemProfileAvatar");
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            imageView2.setImageTintList(ColorStateList.valueOf(ColorCompat.getColor(view, 2131100487)));
            return;
        }
        ImageView imageView3 = this.binding.f2464b;
        m.checkNotNullExpressionValue(imageView3, "binding.guildsItemProfileAvatar");
        View view2 = this.itemView;
        m.checkNotNullExpressionValue(view2, "itemView");
        imageView3.setImageTintList(ColorStateList.valueOf(ColorCompat.getThemedColor(view2, 2130969978)));
    }
}
