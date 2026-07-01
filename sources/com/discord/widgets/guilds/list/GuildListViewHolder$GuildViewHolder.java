package com.discord.widgets.guilds.list;

import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout$LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import b.a.k.b;
import b.d.b.a.a;
import b.f.g.e.f;
import com.discord.R$id;
import com.discord.R$plurals;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetGuildsListItemGuildBinding;
import com.discord.databinding.WidgetGuildsListItemGuildVerticalBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.t;
import d0.o;
import d0.t.g0;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildListViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildListViewHolder$GuildViewHolder extends GuildListViewHolder implements GuildsDragAndDropCallback$DraggableViewHolder {
    public static final GuildListViewHolder$GuildViewHolder$Companion Companion = new GuildListViewHolder$GuildViewHolder$Companion(null);
    private static final float DEFAULT_AVATAR_TEXT_SIZE_SP = 14.0f;
    private static final float TARGETED_AVATAR_TEXT_SIZE_DP = 8.0f;
    private final WidgetGuildsListItemGuildVerticalBinding binding;
    private final WidgetGuildsListItemGuildBinding bindingGuild;
    private GuildListItem$GuildItem data;
    private final int defaultAvatarSize;
    private final int imageRequestSize;
    private boolean isDragging;
    private final Function1<GuildListItem$GuildItem, Unit> onClicked;
    private final Function1<GuildListItem$GuildItem, Unit> onLongPressed;
    private final int overlayColor;
    private final int overlayColorInFolder;
    private final int targetedAvatarMargin;
    private final int targetedAvatarSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildListViewHolder$GuildViewHolder(View view, @ColorInt int i, @ColorInt int i2, Function1<? super GuildListItem$GuildItem, Unit> function1, Function1<? super GuildListItem$GuildItem, Unit> function2) {
        super(view, null);
        m.checkNotNullParameter(view, "itemView");
        m.checkNotNullParameter(function1, "onClicked");
        m.checkNotNullParameter(function2, "onLongPressed");
        this.overlayColor = i;
        this.overlayColorInFolder = i2;
        this.onClicked = function1;
        this.onLongPressed = function2;
        int i3 = R$id.guilds_item_selected;
        ImageView imageView = (ImageView) view.findViewById(R$id.guilds_item_selected);
        if (imageView != null) {
            i3 = R$id.guilds_item_unread;
            ImageView imageView2 = (ImageView) view.findViewById(R$id.guilds_item_unread);
            if (imageView2 != null) {
                WidgetGuildsListItemGuildVerticalBinding widgetGuildsListItemGuildVerticalBinding = new WidgetGuildsListItemGuildVerticalBinding((RelativeLayout) view, imageView, imageView2);
                m.checkNotNullExpressionValue(widgetGuildsListItemGuildVerticalBinding, "WidgetGuildsListItemGuil…calBinding.bind(itemView)");
                this.binding = widgetGuildsListItemGuildVerticalBinding;
                WidgetGuildsListItemGuildBinding widgetGuildsListItemGuildBindingA = WidgetGuildsListItemGuildBinding.a(view);
                m.checkNotNullExpressionValue(widgetGuildsListItemGuildBindingA, "WidgetGuildsListItemGuildBinding.bind(itemView)");
                this.bindingGuild = widgetGuildsListItemGuildBindingA;
                this.defaultAvatarSize = view.getResources().getDimensionPixelSize(2131165293);
                this.targetedAvatarSize = view.getResources().getDimensionPixelSize(2131165447);
                this.targetedAvatarMargin = view.getResources().getDimensionPixelSize(2131165446);
                FrameLayout frameLayout = widgetGuildsListItemGuildBindingA.f;
                m.checkNotNullExpressionValue(frameLayout, "bindingGuild.guildsItemAvatarWrap");
                frameLayout.setClipToOutline(true);
                SimpleDraweeView simpleDraweeView = widgetGuildsListItemGuildBindingA.d;
                m.checkNotNullExpressionValue(simpleDraweeView, "bindingGuild.guildsItemAvatar");
                this.imageRequestSize = IconUtils.getMediaProxySize(simpleDraweeView.getLayoutParams().height);
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static final /* synthetic */ Function1 access$getOnClicked$p(GuildListViewHolder$GuildViewHolder guildListViewHolder$GuildViewHolder) {
        return guildListViewHolder$GuildViewHolder.onClicked;
    }

    public static final /* synthetic */ Function1 access$getOnLongPressed$p(GuildListViewHolder$GuildViewHolder guildListViewHolder$GuildViewHolder) {
        return guildListViewHolder$GuildViewHolder.onLongPressed;
    }

    private final void configureApplicationStatus(ApplicationStatus applicationStatus, boolean isInFolder, boolean hasMentions) {
        if (applicationStatus == null || hasMentions) {
            ImageView imageView = this.bindingGuild.f2461b;
            m.checkNotNullExpressionValue(imageView, "bindingGuild.guildsItemApplicationStatus");
            imageView.setVisibility(8);
            return;
        }
        int i = isInFolder ? 2130968912 : 2130968914;
        ImageView imageView2 = this.bindingGuild.f2461b;
        m.checkNotNullExpressionValue(imageView2, "bindingGuild.guildsItemApplicationStatus");
        int themedColor = ColorCompat.getThemedColor(imageView2, i);
        ImageView imageView3 = this.bindingGuild.f2461b;
        m.checkNotNullExpressionValue(imageView3, "bindingGuild.guildsItemApplicationStatus");
        imageView3.setBackgroundTintList(ColorStateList.valueOf(themedColor));
        ImageView imageView4 = this.bindingGuild.f2461b;
        m.checkNotNullExpressionValue(imageView4, "bindingGuild.guildsItemApplicationStatus");
        imageView4.setVisibility(0);
        int iOrdinal = applicationStatus.ordinal();
        if (iOrdinal == 0) {
            this.bindingGuild.f2461b.setImageResource(2131231518);
            return;
        }
        if (iOrdinal == 1) {
            this.bindingGuild.f2461b.setImageResource(2131231516);
            return;
        }
        if (iOrdinal == 2) {
            this.bindingGuild.f2461b.setImageResource(2131231517);
        } else {
            if (iOrdinal == 3) {
                this.bindingGuild.f2461b.setImageResource(2131231515);
                return;
            }
            ImageView imageView5 = this.bindingGuild.f2461b;
            m.checkNotNullExpressionValue(imageView5, "bindingGuild.guildsItemApplicationStatus");
            imageView5.setVisibility(8);
        }
    }

    private final void configureDraggingAlpha() {
        if (this.isDragging) {
            FrameLayout frameLayout = this.bindingGuild.f;
            m.checkNotNullExpressionValue(frameLayout, "bindingGuild.guildsItemAvatarWrap");
            frameLayout.setAlpha(0.5f);
        } else {
            FrameLayout frameLayout2 = this.bindingGuild.f;
            m.checkNotNullExpressionValue(frameLayout2, "bindingGuild.guildsItemAvatarWrap");
            frameLayout2.setAlpha(1.0f);
        }
    }

    private final void configureGuildIconBackground(boolean isSelected, boolean isInFolder, boolean guildHasIcon) {
        SimpleDraweeView simpleDraweeView = this.bindingGuild.d;
        m.checkNotNullExpressionValue(simpleDraweeView, "bindingGuild.guildsItemAvatar");
        float dimensionPixelSize = simpleDraweeView.getResources().getDimensionPixelSize(2131165449);
        SimpleDraweeView simpleDraweeView2 = this.bindingGuild.d;
        m.checkNotNullExpressionValue(simpleDraweeView2, "bindingGuild.guildsItemAvatar");
        MGImages.setRoundingParams$default(simpleDraweeView2, dimensionPixelSize, !isSelected, Integer.valueOf(isInFolder ? this.overlayColorInFolder : this.overlayColor), null, null, 48, null);
        if (guildHasIcon) {
            if (isSelected) {
                this.bindingGuild.f.setBackgroundResource(2131231317);
            } else {
                this.bindingGuild.f.setBackgroundResource(2131231190);
            }
            FrameLayout frameLayout = this.bindingGuild.f;
            m.checkNotNullExpressionValue(frameLayout, "bindingGuild.guildsItemAvatarWrap");
            frameLayout.setBackgroundTintList(null);
            return;
        }
        if (isSelected) {
            this.bindingGuild.f.setBackgroundResource(2131231314);
            FrameLayout frameLayout2 = this.bindingGuild.f;
            m.checkNotNullExpressionValue(frameLayout2, "bindingGuild.guildsItemAvatarWrap");
            frameLayout2.setBackgroundTintList(null);
            return;
        }
        this.bindingGuild.f.setBackgroundResource(2131231172);
        int i = isInFolder ? 2130968912 : 2130968911;
        FrameLayout frameLayout3 = this.bindingGuild.f;
        m.checkNotNullExpressionValue(frameLayout3, "bindingGuild.guildsItemAvatarWrap");
        int themedColor = ColorCompat.getThemedColor(frameLayout3, i);
        FrameLayout frameLayout4 = this.bindingGuild.f;
        m.checkNotNullExpressionValue(frameLayout4, "bindingGuild.guildsItemAvatarWrap");
        frameLayout4.setBackgroundTintList(ColorStateList.valueOf(themedColor));
    }

    private final void configureGuildIconImage(Guild guild, boolean isSelected) {
        boolean zContains;
        String icon;
        try {
            zContains = guild.getFeatures().contains(GuildFeature.ANIMATED_ICON);
        } catch (Exception e) {
            AppLog.g.e("Guild is missing feature set", e, g0.mapOf(o.to(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, String.valueOf(guild.getId()))));
            zContains = false;
        }
        if (zContains && (icon = guild.getIcon()) != null && t.startsWith$default(icon, "a", false, 2, null)) {
            SimpleDraweeView simpleDraweeView = this.bindingGuild.d;
            m.checkNotNullExpressionValue(simpleDraweeView, "bindingGuild.guildsItemAvatar");
            simpleDraweeView.getHierarchy().o(1, null);
            SimpleDraweeView simpleDraweeView2 = this.bindingGuild.d;
            m.checkNotNullExpressionValue(simpleDraweeView2, "bindingGuild.guildsItemAvatar");
            GenericDraweeHierarchy hierarchy = simpleDraweeView2.getHierarchy();
            m.checkNotNullExpressionValue(hierarchy, "bindingGuild.guildsItemAvatar.hierarchy");
            f fVar = hierarchy.e;
            fVar.w = 0;
            if (fVar.v == 1) {
                fVar.v = 0;
            }
        } else {
            SimpleDraweeView simpleDraweeView3 = this.bindingGuild.d;
            m.checkNotNullExpressionValue(simpleDraweeView3, "bindingGuild.guildsItemAvatar");
            simpleDraweeView3.getHierarchy().p(2131230954);
            SimpleDraweeView simpleDraweeView4 = this.bindingGuild.d;
            m.checkNotNullExpressionValue(simpleDraweeView4, "bindingGuild.guildsItemAvatar");
            GenericDraweeHierarchy hierarchy2 = simpleDraweeView4.getHierarchy();
            m.checkNotNullExpressionValue(hierarchy2, "bindingGuild.guildsItemAvatar.hierarchy");
            f fVar2 = hierarchy2.e;
            fVar2.w = 50;
            if (fVar2.v == 1) {
                fVar2.v = 0;
            }
        }
        if (!guild.hasIcon()) {
            SimpleDraweeView simpleDraweeView5 = this.bindingGuild.d;
            m.checkNotNullExpressionValue(simpleDraweeView5, "bindingGuild.guildsItemAvatar");
            simpleDraweeView5.setVisibility(8);
            return;
        }
        String forGuild$default = IconUtils.getForGuild$default(guild, null, isSelected, null, 10, null);
        StringBuilder sbU = a.U("?size=");
        sbU.append(this.imageRequestSize);
        String strStringPlus = m.stringPlus(forGuild$default, sbU.toString());
        SimpleDraweeView simpleDraweeView6 = this.bindingGuild.d;
        m.checkNotNullExpressionValue(simpleDraweeView6, "bindingGuild.guildsItemAvatar");
        int i = this.imageRequestSize;
        MGImages.setImage$default(simpleDraweeView6, strStringPlus, i, i, false, null, null, 112, null);
        SimpleDraweeView simpleDraweeView7 = this.bindingGuild.d;
        m.checkNotNullExpressionValue(simpleDraweeView7, "bindingGuild.guildsItemAvatar");
        simpleDraweeView7.setVisibility(0);
    }

    private final void configureGuildIconPositioning(boolean isTargetedForFolderCreation) {
        SimpleDraweeView simpleDraweeView = this.bindingGuild.d;
        m.checkNotNullExpressionValue(simpleDraweeView, "bindingGuild.guildsItemAvatar");
        ViewGroup$LayoutParams layoutParams = simpleDraweeView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout$LayoutParams frameLayout$LayoutParams = (FrameLayout$LayoutParams) layoutParams;
        SimpleDraweeView simpleDraweeView2 = this.bindingGuild.d;
        m.checkNotNullExpressionValue(simpleDraweeView2, "bindingGuild.guildsItemAvatar");
        ViewGroup$LayoutParams layoutParams2 = simpleDraweeView2.getLayoutParams();
        Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout$LayoutParams frameLayout$LayoutParams2 = (FrameLayout$LayoutParams) layoutParams2;
        if (isTargetedForFolderCreation) {
            int i = this.targetedAvatarMargin;
            frameLayout$LayoutParams.setMargins(i, i, 0, 0);
            int i2 = this.targetedAvatarSize;
            frameLayout$LayoutParams.height = i2;
            frameLayout$LayoutParams.width = i2;
        } else {
            frameLayout$LayoutParams.setMargins(0, 0, 0, 0);
            int i3 = this.defaultAvatarSize;
            frameLayout$LayoutParams.height = i3;
            frameLayout$LayoutParams.width = i3;
        }
        if (isTargetedForFolderCreation) {
            this.bindingGuild.e.setTextSize(1, TARGETED_AVATAR_TEXT_SIZE_DP);
            int i4 = this.targetedAvatarMargin;
            frameLayout$LayoutParams2.setMargins(i4, i4, 0, 0);
            int i5 = this.targetedAvatarSize;
            frameLayout$LayoutParams2.height = i5;
            frameLayout$LayoutParams2.width = i5;
        } else {
            this.bindingGuild.e.setTextSize(2, DEFAULT_AVATAR_TEXT_SIZE_SP);
            frameLayout$LayoutParams2.setMargins(0, 0, 0, 0);
            frameLayout$LayoutParams2.height = -1;
            frameLayout$LayoutParams2.width = -1;
        }
        SimpleDraweeView simpleDraweeView3 = this.bindingGuild.d;
        m.checkNotNullExpressionValue(simpleDraweeView3, "bindingGuild.guildsItemAvatar");
        simpleDraweeView3.setLayoutParams(frameLayout$LayoutParams);
        TextView textView = this.bindingGuild.e;
        m.checkNotNullExpressionValue(textView, "bindingGuild.guildsItemAvatarText");
        textView.setLayoutParams(frameLayout$LayoutParams2);
    }

    @Override // com.discord.widgets.guilds.list.GuildsDragAndDropCallback$DraggableViewHolder
    public boolean canDrag() {
        GuildListItem$GuildItem guildListItem$GuildItem;
        GuildListItem$GuildItem guildListItem$GuildItem2 = this.data;
        return (guildListItem$GuildItem2 == null || guildListItem$GuildItem2.isLurkingGuild() || ((guildListItem$GuildItem = this.data) != null && guildListItem$GuildItem.isPendingGuild())) ? false : true;
    }

    public final void configure(GuildListItem$GuildItem data) {
        int themedColor;
        GuildListItem$GuildItem guildListItem$GuildItem;
        Guild guild;
        m.checkNotNullParameter(data, "data");
        GuildListItem$GuildItem guildListItem$GuildItem2 = this.data;
        String icon = (guildListItem$GuildItem2 == null || (guild = guildListItem$GuildItem2.getGuild()) == null) ? null : guild.getIcon();
        GuildListItem$GuildItem guildListItem$GuildItem3 = this.data;
        boolean z2 = guildListItem$GuildItem3 == null || guildListItem$GuildItem3.isSelected() != data.isSelected();
        boolean z3 = icon == null || (m.areEqual(icon, data.getGuild().getIcon()) ^ true);
        GuildListItem$GuildItem guildListItem$GuildItem4 = this.data;
        boolean z4 = (guildListItem$GuildItem4 != null ? Boolean.valueOf(guildListItem$GuildItem4.isTargetedForFolderCreation()) : null) != null && ((guildListItem$GuildItem = this.data) == null || guildListItem$GuildItem.isTargetedForFolderCreation() != data.isTargetedForFolderCreation());
        this.data = data;
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        view.setVisibility(0);
        View view2 = this.itemView;
        m.checkNotNullExpressionValue(view2, "itemView");
        view2.setSelected(data.isSelected());
        this.itemView.setOnClickListener(new GuildListViewHolder$GuildViewHolder$configure$1(this, data));
        View view3 = this.itemView;
        m.checkNotNullExpressionValue(view3, "itemView");
        ViewExtensions.setOnLongClickListenerConsumeClick(view3, new GuildListViewHolder$GuildViewHolder$configure$2(this, data));
        boolean z5 = data.getFolderId() != null || data.isTargetedForFolderCreation();
        configureGuildIconBackground(data.isSelected(), z5, data.getGuild().hasIcon());
        if (z4) {
            configureGuildIconPositioning(data.isTargetedForFolderCreation());
        }
        if (z3 || z2) {
            configureGuildIconImage(data.getGuild(), data.isSelected());
        }
        configureDraggingAlpha();
        TextView textView = this.bindingGuild.e;
        m.checkNotNullExpressionValue(textView, "bindingGuild.guildsItemAvatarText");
        textView.setText(data.getGuild().hasIcon() ? null : data.getGuild().getShortName());
        if (z2) {
            if (data.isSelected()) {
                TextView textView2 = this.bindingGuild.e;
                m.checkNotNullExpressionValue(textView2, "bindingGuild.guildsItemAvatarText");
                themedColor = ColorCompat.getColor(textView2.getContext(), 2131100487);
            } else {
                TextView textView3 = this.bindingGuild.e;
                m.checkNotNullExpressionValue(textView3, "bindingGuild.guildsItemAvatarText");
                themedColor = ColorCompat.getThemedColor(textView3.getContext(), 2130968989);
            }
            this.bindingGuild.e.setTextColor(themedColor);
        }
        TextView textView4 = this.bindingGuild.h;
        m.checkNotNullExpressionValue(textView4, "bindingGuild.guildsItemMentions");
        configureMentionsCount(textView4, data.getMentionCount());
        int mentionCount = data.getMentionCount();
        Object i18nPluralString = mentionCount > 0 ? StringResourceUtilsKt.getI18nPluralString(a.x(this.itemView, "itemView", "itemView.context"), R$plurals.guild_tooltip_a11y_label_mentions, mentionCount, Integer.valueOf(mentionCount)) : "";
        View view4 = this.itemView;
        m.checkNotNullExpressionValue(view4, "itemView");
        View view5 = this.itemView;
        m.checkNotNullExpressionValue(view5, "itemView");
        view4.setContentDescription(b.j(view5, 2131891676, new Object[]{i18nPluralString, data.getGuild().getName()}, null, 4));
        ImageView imageView = this.bindingGuild.i;
        imageView.setVisibility(data.isConnectedToVoice() || (data.getHasActiveStageChannel() && !data.getHasActiveScheduledEvent()) ? 0 : 8);
        imageView.setActivated(data.isConnectedToVoice());
        imageView.setImageResource((!data.isConnectedToVoice() || data.isConnectedToStageChannel()) ? 2131231627 : 2131232262);
        ImageView imageView2 = this.bindingGuild.g;
        m.checkNotNullExpressionValue(imageView2, "bindingGuild.guildsItemEventStatus");
        imageView2.setVisibility(!data.isConnectedToVoice() && data.getHasActiveScheduledEvent() ? 0 : 8);
        ImageView imageView3 = this.bindingGuild.c;
        m.checkNotNullExpressionValue(imageView3, "bindingGuild.guildsItemApplicationStream");
        imageView3.setVisibility(!data.isConnectedToVoice() && data.getHasOngoingApplicationStream() ? 0 : 8);
        ImageView imageView4 = this.binding.c;
        m.checkNotNullExpressionValue(imageView4, "binding.guildsItemUnread");
        imageView4.setVisibility(data.getIsUnread() ? 0 : 8);
        ImageView imageView5 = this.binding.f2462b;
        m.checkNotNullExpressionValue(imageView5, "binding.guildsItemSelected");
        imageView5.setVisibility(data.isSelected() ? 0 : 8);
        configureApplicationStatus(null, z5, mentionCount > 0);
    }

    public final Long getFolderId() {
        GuildListItem$GuildItem guildListItem$GuildItem = this.data;
        if (guildListItem$GuildItem != null) {
            return guildListItem$GuildItem.getFolderId();
        }
        return null;
    }

    public final Boolean isLastGuildInFolder() {
        GuildListItem$GuildItem guildListItem$GuildItem = this.data;
        if (guildListItem$GuildItem != null) {
            return guildListItem$GuildItem.isLastGuildInFolder();
        }
        return null;
    }

    public final boolean isTargetedForFolderCreation() {
        GuildListItem$GuildItem guildListItem$GuildItem = this.data;
        return guildListItem$GuildItem != null && guildListItem$GuildItem.isTargetedForFolderCreation();
    }

    @Override // com.discord.widgets.guilds.list.GuildListViewHolder
    public void onDragEnded(boolean wasMerge) {
        super.onDragEnded(wasMerge);
        if (wasMerge) {
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            view.setVisibility(8);
        }
        this.isDragging = false;
        configureDraggingAlpha();
    }

    @Override // com.discord.widgets.guilds.list.GuildListViewHolder
    public void onDragStarted() {
        super.onDragStarted();
        this.isDragging = true;
        configureDraggingAlpha();
    }
}
