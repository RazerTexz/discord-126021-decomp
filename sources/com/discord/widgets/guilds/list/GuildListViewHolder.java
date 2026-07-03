package com.discord.widgets.guilds.list;

import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetGuildsListItemDmBinding;
import com.discord.databinding.WidgetGuildsListItemFolderBinding;
import com.discord.databinding.WidgetGuildsListItemGuildBinding;
import com.discord.databinding.WidgetGuildsListItemGuildVerticalBinding;
import com.discord.databinding.WidgetGuildsListItemHubVerificationBinding;
import com.discord.databinding.WidgetGuildsListItemProfileBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.tooltips.SparkleView;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.GuildView;
import com.discord.views.ServerFolderView;
import com.discord.widgets.guilds.list.GuildListItem;
import com.discord.widgets.guilds.list.GuildsDragAndDropCallback;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p025i.C0971h3;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p109f.p132g.p142e.C1770f;
import p507d0.C12116o;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildListViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class GuildListViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: compiled from: GuildListViewHolder.kt */
    public static final class DiscordHubViewHolder extends GuildListViewHolder {
        private final WidgetGuildsListItemHubVerificationBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DiscordHubViewHolder(View view) {
            super(view, null);
            C12238m.checkNotNullParameter(view, "view");
            SparkleView sparkleView = (SparkleView) view.findViewById(C5419R.id.guild_item_sparkle);
            if (sparkleView == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.guild_item_sparkle)));
            }
            WidgetGuildsListItemHubVerificationBinding widgetGuildsListItemHubVerificationBinding = new WidgetGuildsListItemHubVerificationBinding((FrameLayout) view, sparkleView);
            C12238m.checkNotNullExpressionValue(widgetGuildsListItemHubVerificationBinding, "WidgetGuildsListItemHubV…icationBinding.bind(view)");
            this.binding = widgetGuildsListItemHubVerificationBinding;
        }

        public final void configure(GuildListItem.HubItem item) {
            C12238m.checkNotNullParameter(item, "item");
            SparkleView sparkleView = this.binding.f17119b;
            if (!item.getShowSparkle()) {
                sparkleView.m8511b();
            }
            sparkleView.setVisibility(item.getShowSparkle() ? 0 : 8);
        }

        public final WidgetGuildsListItemHubVerificationBinding getBinding() {
            return this.binding;
        }
    }

    /* JADX INFO: compiled from: GuildListViewHolder.kt */
    public static final class FolderViewHolder extends GuildListViewHolder implements GuildsDragAndDropCallback.DraggableViewHolder {
        private final WidgetGuildsListItemFolderBinding binding;

        @ColorInt
        private Integer color;
        private GuildListItem.FolderItem data;
        private boolean isDragging;
        private int numChildren;
        private final Function1<GuildListItem.FolderItem, Unit> onClicked;
        private final Function1<GuildListItem.FolderItem, Unit> onLongPressed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public FolderViewHolder(View view, Function1<? super GuildListItem.FolderItem, Unit> function1, Function1<? super GuildListItem.FolderItem, Unit> function2) {
            super(view, null);
            C12238m.checkNotNullParameter(view, "view");
            C12238m.checkNotNullParameter(function1, "onClicked");
            C12238m.checkNotNullParameter(function2, "onLongPressed");
            this.onClicked = function1;
            this.onLongPressed = function2;
            int i = C5419R.id.guilds_item_folder;
            ServerFolderView serverFolderView = (ServerFolderView) view.findViewById(C5419R.id.guilds_item_folder);
            if (serverFolderView != null) {
                i = C5419R.id.guilds_item_folder_container;
                FrameLayout frameLayout = (FrameLayout) view.findViewById(C5419R.id.guilds_item_folder_container);
                if (frameLayout != null) {
                    i = C5419R.id.guilds_item_highlight;
                    View viewFindViewById = view.findViewById(C5419R.id.guilds_item_highlight);
                    if (viewFindViewById != null) {
                        i = C5419R.id.guilds_item_mentions;
                        TextView textView = (TextView) view.findViewById(C5419R.id.guilds_item_mentions);
                        if (textView != null) {
                            i = C5419R.id.guilds_item_selected;
                            View viewFindViewById2 = view.findViewById(C5419R.id.guilds_item_selected);
                            if (viewFindViewById2 != null) {
                                i = C5419R.id.guilds_item_unread;
                                ImageView imageView = (ImageView) view.findViewById(C5419R.id.guilds_item_unread);
                                if (imageView != null) {
                                    i = C5419R.id.guilds_item_voice;
                                    ImageView imageView2 = (ImageView) view.findViewById(C5419R.id.guilds_item_voice);
                                    if (imageView2 != null) {
                                        WidgetGuildsListItemFolderBinding widgetGuildsListItemFolderBinding = new WidgetGuildsListItemFolderBinding((RelativeLayout) view, serverFolderView, frameLayout, viewFindViewById, textView, viewFindViewById2, imageView, imageView2);
                                        C12238m.checkNotNullExpressionValue(widgetGuildsListItemFolderBinding, "WidgetGuildsListItemFolderBinding.bind(view)");
                                        this.binding = widgetGuildsListItemFolderBinding;
                                        C12238m.checkNotNullExpressionValue(frameLayout, "binding.guildsItemFolderContainer");
                                        frameLayout.setClipToOutline(true);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        @Override // com.discord.widgets.guilds.list.GuildsDragAndDropCallback.DraggableViewHolder
        public boolean canDrag() {
            GuildListItem.FolderItem folderItem;
            GuildListItem.FolderItem folderItem2 = this.data;
            return (folderItem2 == null || folderItem2.isOpen() || ((folderItem = this.data) != null && folderItem.getIsPendingGuildsFolder())) ? false : true;
        }

        public final void configure(final GuildListItem.FolderItem data) {
            C12238m.checkNotNullParameter(data, "data");
            this.data = data;
            Integer color = data.getColor();
            this.color = color != null ? Integer.valueOf((int) (((long) color.intValue()) + 4278190080L)) : null;
            this.numChildren = data.isOpen() ? data.getGuilds().size() : 0;
            this.binding.f17098a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.list.GuildListViewHolder$FolderViewHolder$configure$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.this$0.onClicked.invoke(data);
                }
            });
            ServerFolderView serverFolderView = this.binding.f17099b;
            boolean isPendingGuildsFolder = data.getIsPendingGuildsFolder();
            long folderId = data.getFolderId();
            boolean zIsOpen = data.isOpen();
            List<Guild> guilds = data.getGuilds();
            Integer color2 = data.getColor();
            Objects.requireNonNull(serverFolderView);
            C12238m.checkNotNullParameter(guilds, "guilds");
            if (isPendingGuildsFolder) {
                serverFolderView.folderId = Long.valueOf(folderId);
                serverFolderView.isOpen = zIsOpen;
                GridLayout gridLayout = serverFolderView.binding.f911g;
                C12238m.checkNotNullExpressionValue(gridLayout, "binding.guildViews");
                gridLayout.setVisibility(zIsOpen ? 0 : 8);
                serverFolderView.binding.f906b.setImageDrawable(ContextCompat.getDrawable(serverFolderView.getContext(), C5419R.drawable.ic_guild_list_pending_folder));
            } else {
                Long l = serverFolderView.folderId;
                boolean z2 = (l == null || l.longValue() != folderId || serverFolderView.isOpen == zIsOpen) ? false : true;
                serverFolderView.folderId = Long.valueOf(folderId);
                if (zIsOpen) {
                    serverFolderView.isOpen = true;
                    if (z2) {
                        serverFolderView.m8556b(C5419R.anim.anim_folder_slide_in_down);
                    } else {
                        serverFolderView.m8555a();
                    }
                    ImageViewCompat.setImageTintList(serverFolderView.binding.f906b, ColorStateList.valueOf((int) (((long) (color2 != null ? color2.intValue() : ColorCompat.getThemedColor(serverFolderView.getContext(), C5419R.attr.color_brand_500))) + 4278190080L)));
                } else {
                    serverFolderView.isOpen = false;
                    if (z2) {
                        serverFolderView.m8556b(C5419R.anim.anim_folder_slide_out_up);
                    } else {
                        serverFolderView.m8555a();
                    }
                    C0971h3 c0971h3 = serverFolderView.binding;
                    int i = 0;
                    for (Object obj : C12147n.listOf((Object[]) new GuildView[]{c0971h3.f907c, c0971h3.f908d, c0971h3.f909e, c0971h3.f910f})) {
                        int i2 = i + 1;
                        if (i < 0) {
                            C12147n.throwIndexOverflow();
                        }
                        GuildView guildView = (GuildView) obj;
                        if (C12147n.getLastIndex(guilds) >= i) {
                            Guild guild = guilds.get(i);
                            String forGuild$default = guild.hasIcon() ? IconUtils.getForGuild$default(guild, IconUtils.DEFAULT_ICON, false, null, 12, null) : null;
                            C12238m.checkNotNullExpressionValue(guildView, "guildView");
                            guildView.setVisibility(0);
                            guildView.m8545a(forGuild$default, guild.getShortName());
                        } else {
                            C12238m.checkNotNullExpressionValue(guildView, "guildView");
                            guildView.setVisibility(8);
                        }
                        i = i2;
                    }
                }
            }
            View view = this.binding.f17103f;
            C12238m.checkNotNullExpressionValue(view, "binding.guildsItemSelected");
            view.setVisibility(!data.isOpen() && data.isAnyGuildSelected() ? 0 : 8);
            ImageView imageView = this.binding.f17104g;
            C12238m.checkNotNullExpressionValue(imageView, "binding.guildsItemUnread");
            imageView.setVisibility(!data.isOpen() && data.getIsUnread() ? 0 : 8);
            ImageView imageView2 = this.binding.f17105h;
            imageView2.setActivated(data.isAnyGuildConnectedToVoice());
            imageView2.setVisibility(!data.isOpen() && data.isAnyGuildConnectedToVoice() ? 0 : 8);
            imageView2.setImageResource(data.isAnyGuildConnectedToStageChannel() ? C5419R.drawable.ic_channel_stage_24dp_white : C5419R.drawable.ic_volume_up_white_24dp);
            View view2 = this.binding.f17101d;
            C12238m.checkNotNullExpressionValue(view2, "binding.guildsItemHighlight");
            view2.setVisibility(data.isTargetedForFolderAddition() ? 0 : 8);
            int mentionCount = data.getMentionCount();
            Object i18nPluralString = mentionCount > 0 ? StringResourceUtilsKt.getI18nPluralString(C1643a.m885x(this.itemView, "itemView", "itemView.context"), C5419R.plurals.guild_folder_tooltip_a11y_label_mentions, mentionCount, Integer.valueOf(mentionCount)) : "";
            View view3 = this.itemView;
            C12238m.checkNotNullExpressionValue(view3, "itemView");
            CharSequence charSequenceM212d = C1107b.m212d(view3, data.isOpen() ? C5419R.string.expanded : C5419R.string.collapsed, new Object[0], (4 & 4) != 0 ? C1107b.c.f1492j : null);
            View view4 = this.itemView;
            C12238m.checkNotNullExpressionValue(view4, "itemView");
            View view5 = this.itemView;
            C12238m.checkNotNullExpressionValue(view5, "itemView");
            view4.setContentDescription(C1107b.m212d(view5, C5419R.string.guild_folder_tooltip_a11y_label_with_expanded_state, new Object[]{data.getName(), i18nPluralString, charSequenceM212d}, (4 & 4) != 0 ? C1107b.c.f1492j : null));
            View view6 = this.itemView;
            C12238m.checkNotNullExpressionValue(view6, "itemView");
            ViewExtensions.setOnLongClickListenerConsumeClick(view6, new GuildListViewHolder$FolderViewHolder$configure$4(this, data));
            TextView textView = this.binding.f17102e;
            C12238m.checkNotNullExpressionValue(textView, "binding.guildsItemMentions");
            configureMentionsCount(textView, data.isOpen() ? 0 : data.getMentionCount());
        }

        public final Integer getColor() {
            return this.color;
        }

        public final int getNumChildren() {
            return this.numChildren;
        }

        @Override // com.discord.widgets.guilds.list.GuildListViewHolder
        public void onDragEnded(boolean wasMerge) {
            this.isDragging = false;
            ServerFolderView serverFolderView = this.binding.f17099b;
            C12238m.checkNotNullExpressionValue(serverFolderView, "binding.guildsItemFolder");
            serverFolderView.setBackground(null);
        }

        @Override // com.discord.widgets.guilds.list.GuildListViewHolder
        public void onDragStarted() {
            this.isDragging = true;
            ServerFolderView serverFolderView = this.binding.f17099b;
            C12238m.checkNotNullExpressionValue(serverFolderView, "binding.guildsItemFolder");
            ServerFolderView serverFolderView2 = this.binding.f17099b;
            C12238m.checkNotNullExpressionValue(serverFolderView2, "binding.guildsItemFolder");
            serverFolderView.setBackground(ContextCompat.getDrawable(serverFolderView2.getContext(), C5419R.drawable.drawable_squircle_primary_600));
        }

        public final void setColor(Integer num) {
            this.color = num;
        }

        public final boolean shouldDrawDecoration() {
            return !this.isDragging;
        }
    }

    /* JADX INFO: compiled from: GuildListViewHolder.kt */
    public static final class FriendsViewHolder extends GuildListViewHolder {
        private final WidgetGuildsListItemProfileBinding binding;
        private final Function1<GuildListItem.FriendsItem, Unit> onClicked;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public FriendsViewHolder(View view, Function1<? super GuildListItem.FriendsItem, Unit> function1) {
            super(view, null);
            C12238m.checkNotNullParameter(view, "view");
            C12238m.checkNotNullParameter(function1, "onClicked");
            this.onClicked = function1;
            int i = C5419R.id.guilds_item_profile_avatar;
            ImageView imageView = (ImageView) view.findViewById(C5419R.id.guilds_item_profile_avatar);
            if (imageView != null) {
                i = C5419R.id.guilds_item_profile_avatar_wrap;
                FrameLayout frameLayout = (FrameLayout) view.findViewById(C5419R.id.guilds_item_profile_avatar_wrap);
                if (frameLayout != null) {
                    i = C5419R.id.guilds_item_profile_selected;
                    ImageView imageView2 = (ImageView) view.findViewById(C5419R.id.guilds_item_profile_selected);
                    if (imageView2 != null) {
                        WidgetGuildsListItemProfileBinding widgetGuildsListItemProfileBinding = new WidgetGuildsListItemProfileBinding((RelativeLayout) view, imageView, frameLayout, imageView2);
                        C12238m.checkNotNullExpressionValue(widgetGuildsListItemProfileBinding, "WidgetGuildsListItemProfileBinding.bind(view)");
                        this.binding = widgetGuildsListItemProfileBinding;
                        return;
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public final void configure(final GuildListItem.FriendsItem data) {
            C12238m.checkNotNullParameter(data, "data");
            ImageView imageView = this.binding.f17123d;
            C12238m.checkNotNullExpressionValue(imageView, "binding.guildsItemProfileSelected");
            imageView.setVisibility(data.isSelected() ? 0 : 8);
            this.binding.f17120a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.list.GuildListViewHolder$FriendsViewHolder$configure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.this$0.onClicked.invoke(data);
                }
            });
            if (data.isSelected()) {
                this.binding.f17122c.setBackgroundResource(C5419R.drawable.drawable_squircle_brand_500);
                FrameLayout frameLayout = this.binding.f17122c;
                C12238m.checkNotNullExpressionValue(frameLayout, "binding.guildsItemProfileAvatarWrap");
                frameLayout.setBackgroundTintList(null);
            } else {
                this.binding.f17122c.setBackgroundResource(C5419R.drawable.drawable_circle_black);
                FrameLayout frameLayout2 = this.binding.f17122c;
                C12238m.checkNotNullExpressionValue(frameLayout2, "binding.guildsItemProfileAvatarWrap");
                int themedColor = ColorCompat.getThemedColor(frameLayout2, C5419R.attr.colorBackgroundSecondary);
                FrameLayout frameLayout3 = this.binding.f17122c;
                C12238m.checkNotNullExpressionValue(frameLayout3, "binding.guildsItemProfileAvatarWrap");
                frameLayout3.setBackgroundTintList(ColorStateList.valueOf(themedColor));
            }
            if (data.isSelected()) {
                ImageView imageView2 = this.binding.f17121b;
                C12238m.checkNotNullExpressionValue(imageView2, "binding.guildsItemProfileAvatar");
                View view = this.itemView;
                C12238m.checkNotNullExpressionValue(view, "itemView");
                imageView2.setImageTintList(ColorStateList.valueOf(ColorCompat.getColor(view, C5419R.color.white)));
                return;
            }
            ImageView imageView3 = this.binding.f17121b;
            C12238m.checkNotNullExpressionValue(imageView3, "binding.guildsItemProfileAvatar");
            View view2 = this.itemView;
            C12238m.checkNotNullExpressionValue(view2, "itemView");
            imageView3.setImageTintList(ColorStateList.valueOf(ColorCompat.getThemedColor(view2, C5419R.attr.primary_300)));
        }
    }

    /* JADX INFO: compiled from: GuildListViewHolder.kt */
    public static final class GuildViewHolder extends GuildListViewHolder implements GuildsDragAndDropCallback.DraggableViewHolder {
        private static final float DEFAULT_AVATAR_TEXT_SIZE_SP = 14.0f;
        private static final float TARGETED_AVATAR_TEXT_SIZE_DP = 8.0f;
        private final WidgetGuildsListItemGuildVerticalBinding binding;
        private final WidgetGuildsListItemGuildBinding bindingGuild;
        private GuildListItem.GuildItem data;
        private final int defaultAvatarSize;
        private final int imageRequestSize;
        private boolean isDragging;
        private final Function1<GuildListItem.GuildItem, Unit> onClicked;
        private final Function1<GuildListItem.GuildItem, Unit> onLongPressed;
        private final int overlayColor;
        private final int overlayColorInFolder;
        private final int targetedAvatarMargin;
        private final int targetedAvatarSize;

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                ApplicationStatus.values();
                int[] iArr = new int[5];
                $EnumSwitchMapping$0 = iArr;
                iArr[ApplicationStatus.APPROVED.ordinal()] = 1;
                iArr[ApplicationStatus.REJECTED.ordinal()] = 2;
                iArr[ApplicationStatus.PENDING.ordinal()] = 3;
                iArr[ApplicationStatus.STARTED.ordinal()] = 4;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public GuildViewHolder(View view, @ColorInt int i, @ColorInt int i2, Function1<? super GuildListItem.GuildItem, Unit> function1, Function1<? super GuildListItem.GuildItem, Unit> function2) {
            super(view, null);
            C12238m.checkNotNullParameter(view, "itemView");
            C12238m.checkNotNullParameter(function1, "onClicked");
            C12238m.checkNotNullParameter(function2, "onLongPressed");
            this.overlayColor = i;
            this.overlayColorInFolder = i2;
            this.onClicked = function1;
            this.onLongPressed = function2;
            int i3 = C5419R.id.guilds_item_selected;
            ImageView imageView = (ImageView) view.findViewById(C5419R.id.guilds_item_selected);
            if (imageView != null) {
                i3 = C5419R.id.guilds_item_unread;
                ImageView imageView2 = (ImageView) view.findViewById(C5419R.id.guilds_item_unread);
                if (imageView2 != null) {
                    WidgetGuildsListItemGuildVerticalBinding widgetGuildsListItemGuildVerticalBinding = new WidgetGuildsListItemGuildVerticalBinding((RelativeLayout) view, imageView, imageView2);
                    C12238m.checkNotNullExpressionValue(widgetGuildsListItemGuildVerticalBinding, "WidgetGuildsListItemGuil…calBinding.bind(itemView)");
                    this.binding = widgetGuildsListItemGuildVerticalBinding;
                    WidgetGuildsListItemGuildBinding widgetGuildsListItemGuildBindingM8419a = WidgetGuildsListItemGuildBinding.m8419a(view);
                    C12238m.checkNotNullExpressionValue(widgetGuildsListItemGuildBindingM8419a, "WidgetGuildsListItemGuildBinding.bind(itemView)");
                    this.bindingGuild = widgetGuildsListItemGuildBindingM8419a;
                    this.defaultAvatarSize = view.getResources().getDimensionPixelSize(C5419R.dimen.avatar_size_large);
                    this.targetedAvatarSize = view.getResources().getDimensionPixelSize(C5419R.dimen.folder_guild_size);
                    this.targetedAvatarMargin = view.getResources().getDimensionPixelSize(C5419R.dimen.folder_guild_outer_margin);
                    FrameLayout frameLayout = widgetGuildsListItemGuildBindingM8419a.f17111f;
                    C12238m.checkNotNullExpressionValue(frameLayout, "bindingGuild.guildsItemAvatarWrap");
                    frameLayout.setClipToOutline(true);
                    SimpleDraweeView simpleDraweeView = widgetGuildsListItemGuildBindingM8419a.f17109d;
                    C12238m.checkNotNullExpressionValue(simpleDraweeView, "bindingGuild.guildsItemAvatar");
                    this.imageRequestSize = IconUtils.getMediaProxySize(simpleDraweeView.getLayoutParams().height);
                    return;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
        }

        private final void configureApplicationStatus(ApplicationStatus applicationStatus, boolean isInFolder, boolean hasMentions) {
            if (applicationStatus == null || hasMentions) {
                ImageView imageView = this.bindingGuild.f17107b;
                C12238m.checkNotNullExpressionValue(imageView, "bindingGuild.guildsItemApplicationStatus");
                imageView.setVisibility(8);
                return;
            }
            int i = isInFolder ? C5419R.attr.colorBackgroundSecondary : C5419R.attr.colorBackgroundTertiary;
            ImageView imageView2 = this.bindingGuild.f17107b;
            C12238m.checkNotNullExpressionValue(imageView2, "bindingGuild.guildsItemApplicationStatus");
            int themedColor = ColorCompat.getThemedColor(imageView2, i);
            ImageView imageView3 = this.bindingGuild.f17107b;
            C12238m.checkNotNullExpressionValue(imageView3, "bindingGuild.guildsItemApplicationStatus");
            imageView3.setBackgroundTintList(ColorStateList.valueOf(themedColor));
            ImageView imageView4 = this.bindingGuild.f17107b;
            C12238m.checkNotNullExpressionValue(imageView4, "bindingGuild.guildsItemApplicationStatus");
            imageView4.setVisibility(0);
            int iOrdinal = applicationStatus.ordinal();
            if (iOrdinal == 0) {
                this.bindingGuild.f17107b.setImageResource(C5419R.drawable.ic_application_status_started);
                return;
            }
            if (iOrdinal == 1) {
                this.bindingGuild.f17107b.setImageResource(C5419R.drawable.ic_application_status_pending);
                return;
            }
            if (iOrdinal == 2) {
                this.bindingGuild.f17107b.setImageResource(C5419R.drawable.ic_application_status_rejected);
            } else {
                if (iOrdinal == 3) {
                    this.bindingGuild.f17107b.setImageResource(C5419R.drawable.ic_application_status_approved);
                    return;
                }
                ImageView imageView5 = this.bindingGuild.f17107b;
                C12238m.checkNotNullExpressionValue(imageView5, "bindingGuild.guildsItemApplicationStatus");
                imageView5.setVisibility(8);
            }
        }

        private final void configureDraggingAlpha() {
            if (this.isDragging) {
                FrameLayout frameLayout = this.bindingGuild.f17111f;
                C12238m.checkNotNullExpressionValue(frameLayout, "bindingGuild.guildsItemAvatarWrap");
                frameLayout.setAlpha(0.5f);
            } else {
                FrameLayout frameLayout2 = this.bindingGuild.f17111f;
                C12238m.checkNotNullExpressionValue(frameLayout2, "bindingGuild.guildsItemAvatarWrap");
                frameLayout2.setAlpha(1.0f);
            }
        }

        private final void configureGuildIconBackground(boolean isSelected, boolean isInFolder, boolean guildHasIcon) {
            SimpleDraweeView simpleDraweeView = this.bindingGuild.f17109d;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "bindingGuild.guildsItemAvatar");
            float dimensionPixelSize = simpleDraweeView.getResources().getDimensionPixelSize(C5419R.dimen.guild_icon_radius);
            SimpleDraweeView simpleDraweeView2 = this.bindingGuild.f17109d;
            C12238m.checkNotNullExpressionValue(simpleDraweeView2, "bindingGuild.guildsItemAvatar");
            MGImages.setRoundingParams(simpleDraweeView2, dimensionPixelSize, !isSelected, (48 & 8) != 0 ? null : Integer.valueOf(isInFolder ? this.overlayColorInFolder : this.overlayColor), (48 & 16) != 0 ? null : null, (48 & 32) != 0 ? null : null);
            if (guildHasIcon) {
                if (isSelected) {
                    this.bindingGuild.f17111f.setBackgroundResource(C5419R.drawable.drawable_squircle_transparent);
                } else {
                    this.bindingGuild.f17111f.setBackgroundResource(C5419R.drawable.drawable_circle_transparent);
                }
                FrameLayout frameLayout = this.bindingGuild.f17111f;
                C12238m.checkNotNullExpressionValue(frameLayout, "bindingGuild.guildsItemAvatarWrap");
                frameLayout.setBackgroundTintList(null);
                return;
            }
            if (isSelected) {
                this.bindingGuild.f17111f.setBackgroundResource(C5419R.drawable.drawable_squircle_brand_500);
                FrameLayout frameLayout2 = this.bindingGuild.f17111f;
                C12238m.checkNotNullExpressionValue(frameLayout2, "bindingGuild.guildsItemAvatarWrap");
                frameLayout2.setBackgroundTintList(null);
                return;
            }
            this.bindingGuild.f17111f.setBackgroundResource(C5419R.drawable.drawable_circle_black);
            int i = isInFolder ? C5419R.attr.colorBackgroundSecondary : C5419R.attr.colorBackgroundPrimary;
            FrameLayout frameLayout3 = this.bindingGuild.f17111f;
            C12238m.checkNotNullExpressionValue(frameLayout3, "bindingGuild.guildsItemAvatarWrap");
            int themedColor = ColorCompat.getThemedColor(frameLayout3, i);
            FrameLayout frameLayout4 = this.bindingGuild.f17111f;
            C12238m.checkNotNullExpressionValue(frameLayout4, "bindingGuild.guildsItemAvatarWrap");
            frameLayout4.setBackgroundTintList(ColorStateList.valueOf(themedColor));
        }

        private final void configureGuildIconImage(Guild guild, boolean isSelected) {
            boolean zContains;
            String icon;
            try {
                zContains = guild.getFeatures().contains(GuildFeature.ANIMATED_ICON);
            } catch (Exception e) {
                AppLog.f14950g.mo8364e("Guild is missing feature set", e, C12134g0.mapOf(C12116o.m10073to(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, String.valueOf(guild.getId()))));
                zContains = false;
            }
            if (zContains && (icon = guild.getIcon()) != null && C12103t.startsWith$default(icon, "a", false, 2, null)) {
                SimpleDraweeView simpleDraweeView = this.bindingGuild.f17109d;
                C12238m.checkNotNullExpressionValue(simpleDraweeView, "bindingGuild.guildsItemAvatar");
                simpleDraweeView.getHierarchy().m8679o(1, null);
                SimpleDraweeView simpleDraweeView2 = this.bindingGuild.f17109d;
                C12238m.checkNotNullExpressionValue(simpleDraweeView2, "bindingGuild.guildsItemAvatar");
                GenericDraweeHierarchy hierarchy = simpleDraweeView2.getHierarchy();
                C12238m.checkNotNullExpressionValue(hierarchy, "bindingGuild.guildsItemAvatar.hierarchy");
                C1770f c1770f = hierarchy.f19510e;
                c1770f.f3355w = 0;
                if (c1770f.f3354v == 1) {
                    c1770f.f3354v = 0;
                }
            } else {
                SimpleDraweeView simpleDraweeView3 = this.bindingGuild.f17109d;
                C12238m.checkNotNullExpressionValue(simpleDraweeView3, "bindingGuild.guildsItemAvatar");
                simpleDraweeView3.getHierarchy().m8680p(C5419R.drawable.asset_default_avatar_64dp);
                SimpleDraweeView simpleDraweeView4 = this.bindingGuild.f17109d;
                C12238m.checkNotNullExpressionValue(simpleDraweeView4, "bindingGuild.guildsItemAvatar");
                GenericDraweeHierarchy hierarchy2 = simpleDraweeView4.getHierarchy();
                C12238m.checkNotNullExpressionValue(hierarchy2, "bindingGuild.guildsItemAvatar.hierarchy");
                C1770f c1770f2 = hierarchy2.f19510e;
                c1770f2.f3355w = 50;
                if (c1770f2.f3354v == 1) {
                    c1770f2.f3354v = 0;
                }
            }
            if (!guild.hasIcon()) {
                SimpleDraweeView simpleDraweeView5 = this.bindingGuild.f17109d;
                C12238m.checkNotNullExpressionValue(simpleDraweeView5, "bindingGuild.guildsItemAvatar");
                simpleDraweeView5.setVisibility(8);
                return;
            }
            String forGuild$default = IconUtils.getForGuild$default(guild, null, isSelected, null, 10, null);
            StringBuilder sbM833U = C1643a.m833U("?size=");
            sbM833U.append(this.imageRequestSize);
            String strStringPlus = C12238m.stringPlus(forGuild$default, sbM833U.toString());
            SimpleDraweeView simpleDraweeView6 = this.bindingGuild.f17109d;
            C12238m.checkNotNullExpressionValue(simpleDraweeView6, "bindingGuild.guildsItemAvatar");
            int i = this.imageRequestSize;
            MGImages.setImage$default(simpleDraweeView6, strStringPlus, i, i, false, null, null, 112, null);
            SimpleDraweeView simpleDraweeView7 = this.bindingGuild.f17109d;
            C12238m.checkNotNullExpressionValue(simpleDraweeView7, "bindingGuild.guildsItemAvatar");
            simpleDraweeView7.setVisibility(0);
        }

        private final void configureGuildIconPositioning(boolean isTargetedForFolderCreation) {
            SimpleDraweeView simpleDraweeView = this.bindingGuild.f17109d;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "bindingGuild.guildsItemAvatar");
            ViewGroup.LayoutParams layoutParams = simpleDraweeView.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            SimpleDraweeView simpleDraweeView2 = this.bindingGuild.f17109d;
            C12238m.checkNotNullExpressionValue(simpleDraweeView2, "bindingGuild.guildsItemAvatar");
            ViewGroup.LayoutParams layoutParams3 = simpleDraweeView2.getLayoutParams();
            Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
            if (isTargetedForFolderCreation) {
                int i = this.targetedAvatarMargin;
                layoutParams2.setMargins(i, i, 0, 0);
                int i2 = this.targetedAvatarSize;
                layoutParams2.height = i2;
                layoutParams2.width = i2;
            } else {
                layoutParams2.setMargins(0, 0, 0, 0);
                int i3 = this.defaultAvatarSize;
                layoutParams2.height = i3;
                layoutParams2.width = i3;
            }
            if (isTargetedForFolderCreation) {
                this.bindingGuild.f17110e.setTextSize(1, TARGETED_AVATAR_TEXT_SIZE_DP);
                int i4 = this.targetedAvatarMargin;
                layoutParams4.setMargins(i4, i4, 0, 0);
                int i5 = this.targetedAvatarSize;
                layoutParams4.height = i5;
                layoutParams4.width = i5;
            } else {
                this.bindingGuild.f17110e.setTextSize(2, DEFAULT_AVATAR_TEXT_SIZE_SP);
                layoutParams4.setMargins(0, 0, 0, 0);
                layoutParams4.height = -1;
                layoutParams4.width = -1;
            }
            SimpleDraweeView simpleDraweeView3 = this.bindingGuild.f17109d;
            C12238m.checkNotNullExpressionValue(simpleDraweeView3, "bindingGuild.guildsItemAvatar");
            simpleDraweeView3.setLayoutParams(layoutParams2);
            TextView textView = this.bindingGuild.f17110e;
            C12238m.checkNotNullExpressionValue(textView, "bindingGuild.guildsItemAvatarText");
            textView.setLayoutParams(layoutParams4);
        }

        @Override // com.discord.widgets.guilds.list.GuildsDragAndDropCallback.DraggableViewHolder
        public boolean canDrag() {
            GuildListItem.GuildItem guildItem;
            GuildListItem.GuildItem guildItem2 = this.data;
            return (guildItem2 == null || guildItem2.isLurkingGuild() || ((guildItem = this.data) != null && guildItem.isPendingGuild())) ? false : true;
        }

        public final void configure(final GuildListItem.GuildItem data) {
            int themedColor;
            GuildListItem.GuildItem guildItem;
            Guild guild;
            C12238m.checkNotNullParameter(data, "data");
            GuildListItem.GuildItem guildItem2 = this.data;
            String icon = (guildItem2 == null || (guild = guildItem2.getGuild()) == null) ? null : guild.getIcon();
            GuildListItem.GuildItem guildItem3 = this.data;
            boolean z2 = guildItem3 == null || guildItem3.isSelected() != data.isSelected();
            boolean z3 = icon == null || (C12238m.areEqual(icon, data.getGuild().getIcon()) ^ true);
            GuildListItem.GuildItem guildItem4 = this.data;
            boolean z4 = (guildItem4 != null ? Boolean.valueOf(guildItem4.isTargetedForFolderCreation()) : null) != null && ((guildItem = this.data) == null || guildItem.isTargetedForFolderCreation() != data.isTargetedForFolderCreation());
            this.data = data;
            View view = this.itemView;
            C12238m.checkNotNullExpressionValue(view, "itemView");
            view.setVisibility(0);
            View view2 = this.itemView;
            C12238m.checkNotNullExpressionValue(view2, "itemView");
            view2.setSelected(data.isSelected());
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.list.GuildListViewHolder$GuildViewHolder$configure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    this.this$0.onClicked.invoke(data);
                }
            });
            View view3 = this.itemView;
            C12238m.checkNotNullExpressionValue(view3, "itemView");
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
            TextView textView = this.bindingGuild.f17110e;
            C12238m.checkNotNullExpressionValue(textView, "bindingGuild.guildsItemAvatarText");
            textView.setText(data.getGuild().hasIcon() ? null : data.getGuild().getShortName());
            if (z2) {
                if (data.isSelected()) {
                    TextView textView2 = this.bindingGuild.f17110e;
                    C12238m.checkNotNullExpressionValue(textView2, "bindingGuild.guildsItemAvatarText");
                    themedColor = ColorCompat.getColor(textView2.getContext(), C5419R.color.white);
                } else {
                    TextView textView3 = this.bindingGuild.f17110e;
                    C12238m.checkNotNullExpressionValue(textView3, "bindingGuild.guildsItemAvatarText");
                    themedColor = ColorCompat.getThemedColor(textView3.getContext(), C5419R.attr.colorHeaderPrimary);
                }
                this.bindingGuild.f17110e.setTextColor(themedColor);
            }
            TextView textView4 = this.bindingGuild.f17113h;
            C12238m.checkNotNullExpressionValue(textView4, "bindingGuild.guildsItemMentions");
            configureMentionsCount(textView4, data.getMentionCount());
            int mentionCount = data.getMentionCount();
            Object i18nPluralString = mentionCount > 0 ? StringResourceUtilsKt.getI18nPluralString(C1643a.m885x(this.itemView, "itemView", "itemView.context"), C5419R.plurals.guild_tooltip_a11y_label_mentions, mentionCount, Integer.valueOf(mentionCount)) : "";
            View view4 = this.itemView;
            C12238m.checkNotNullExpressionValue(view4, "itemView");
            View view5 = this.itemView;
            C12238m.checkNotNullExpressionValue(view5, "itemView");
            view4.setContentDescription(C1107b.m212d(view5, C5419R.string.guild_tooltip_a11y_label, new Object[]{i18nPluralString, data.getGuild().getName()}, (4 & 4) != 0 ? C1107b.c.f1492j : null));
            ImageView imageView = this.bindingGuild.f17114i;
            imageView.setVisibility(data.isConnectedToVoice() || (data.getHasActiveStageChannel() && !data.getHasActiveScheduledEvent()) ? 0 : 8);
            imageView.setActivated(data.isConnectedToVoice());
            imageView.setImageResource((!data.isConnectedToVoice() || data.isConnectedToStageChannel()) ? C5419R.drawable.ic_channel_stage_24dp_white : C5419R.drawable.ic_volume_up_white_24dp);
            ImageView imageView2 = this.bindingGuild.f17112g;
            C12238m.checkNotNullExpressionValue(imageView2, "bindingGuild.guildsItemEventStatus");
            imageView2.setVisibility(!data.isConnectedToVoice() && data.getHasActiveScheduledEvent() ? 0 : 8);
            ImageView imageView3 = this.bindingGuild.f17108c;
            C12238m.checkNotNullExpressionValue(imageView3, "bindingGuild.guildsItemApplicationStream");
            imageView3.setVisibility(!data.isConnectedToVoice() && data.getHasOngoingApplicationStream() ? 0 : 8);
            ImageView imageView4 = this.binding.f17117c;
            C12238m.checkNotNullExpressionValue(imageView4, "binding.guildsItemUnread");
            imageView4.setVisibility(data.getIsUnread() ? 0 : 8);
            ImageView imageView5 = this.binding.f17116b;
            C12238m.checkNotNullExpressionValue(imageView5, "binding.guildsItemSelected");
            imageView5.setVisibility(data.isSelected() ? 0 : 8);
            configureApplicationStatus(null, z5, mentionCount > 0);
        }

        public final Long getFolderId() {
            GuildListItem.GuildItem guildItem = this.data;
            if (guildItem != null) {
                return guildItem.getFolderId();
            }
            return null;
        }

        public final Boolean isLastGuildInFolder() {
            GuildListItem.GuildItem guildItem = this.data;
            if (guildItem != null) {
                return guildItem.isLastGuildInFolder();
            }
            return null;
        }

        public final boolean isTargetedForFolderCreation() {
            GuildListItem.GuildItem guildItem = this.data;
            return guildItem != null && guildItem.isTargetedForFolderCreation();
        }

        @Override // com.discord.widgets.guilds.list.GuildListViewHolder
        public void onDragEnded(boolean wasMerge) {
            super.onDragEnded(wasMerge);
            if (wasMerge) {
                View view = this.itemView;
                C12238m.checkNotNullExpressionValue(view, "itemView");
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

    /* JADX INFO: compiled from: GuildListViewHolder.kt */
    public static final class PrivateChannelViewHolder extends GuildListViewHolder {
        private final WidgetGuildsListItemDmBinding binding;
        private final Function1<GuildListItem.PrivateChannelItem, Unit> onClicked;
        private final Function1<GuildListItem.PrivateChannelItem, Unit> onLongPressed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public PrivateChannelViewHolder(View view, Function1<? super GuildListItem.PrivateChannelItem, Unit> function1, Function1<? super GuildListItem.PrivateChannelItem, Unit> function2) {
            super(view, null);
            C12238m.checkNotNullParameter(view, "view");
            C12238m.checkNotNullParameter(function1, "onClicked");
            C12238m.checkNotNullParameter(function2, "onLongPressed");
            this.onClicked = function1;
            this.onLongPressed = function2;
            WidgetGuildsListItemDmBinding widgetGuildsListItemDmBindingM8418a = WidgetGuildsListItemDmBinding.m8418a(view);
            C12238m.checkNotNullExpressionValue(widgetGuildsListItemDmBindingM8418a, "WidgetGuildsListItemDmBinding.bind(view)");
            this.binding = widgetGuildsListItemDmBindingM8418a;
        }

        public final void configure(final GuildListItem.PrivateChannelItem data) {
            C12238m.checkNotNullParameter(data, "data");
            int mentionCount = data.getMentionCount();
            TextView textView = this.binding.f17097c;
            C12238m.checkNotNullExpressionValue(textView, "binding.guildsItemDmCount");
            configureMentionsCount(textView, mentionCount);
            Object i18nPluralString = mentionCount > 0 ? StringResourceUtilsKt.getI18nPluralString(C1643a.m885x(this.itemView, "itemView", "itemView.context"), C5419R.plurals.dm_tooltip_a11y_label_mentions, mentionCount, Integer.valueOf(mentionCount)) : "";
            View view = this.itemView;
            C12238m.checkNotNullExpressionValue(view, "itemView");
            View view2 = this.itemView;
            C12238m.checkNotNullExpressionValue(view2, "itemView");
            view.setContentDescription(C1107b.m212d(view2, C5419R.string.dm_tooltip_a11y_label, new Object[]{ChannelUtils.m7679c(data.getChannel()), i18nPluralString}, (4 & 4) != 0 ? C1107b.c.f1492j : null));
            SimpleDraweeView simpleDraweeView = this.binding.f17096b;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildsItemDmAvatar");
            IconUtils.setIcon$default(simpleDraweeView, data.getChannel(), C5419R.dimen.avatar_size_large, (MGImages.ChangeDetector) null, 8, (Object) null);
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.list.GuildListViewHolder$PrivateChannelViewHolder$configure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    this.this$0.onClicked.invoke(data);
                }
            });
            View view3 = this.itemView;
            C12238m.checkNotNullExpressionValue(view3, "itemView");
            ViewExtensions.setOnLongClickListenerConsumeClick(view3, new GuildListViewHolder$PrivateChannelViewHolder$configure$2(this, data));
        }
    }

    /* JADX INFO: compiled from: GuildListViewHolder.kt */
    public static final class SimpleViewHolder extends GuildListViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SimpleViewHolder(View view) {
            super(view, null);
            C12238m.checkNotNullParameter(view, "view");
        }
    }

    /* JADX INFO: compiled from: GuildListViewHolder.kt */
    public static final class SpaceViewHolder extends GuildListViewHolder {
        private final View view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SpaceViewHolder(View view) {
            super(view, null);
            C12238m.checkNotNullParameter(view, "view");
            this.view = view;
        }

        public final void configure(int height) {
            ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
            layoutParams.height = height;
            this.view.setLayoutParams(layoutParams);
        }

        public final View getView() {
            return this.view;
        }
    }

    public /* synthetic */ GuildListViewHolder(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }

    public final void configureMentionsCount(TextView textView, int count) {
        C12238m.checkNotNullParameter(textView, "textView");
        if (count < 1) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(String.valueOf(count));
        }
    }

    public void onDragEnded(boolean wasMerge) {
    }

    public void onDragStarted() {
    }

    private GuildListViewHolder(View view) {
        super(view);
    }
}
