package com.discord.widgets.guilds.list;

import android.content.res.ColorStateList;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import b.a.i.h3;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$anim;
import com.discord.R$attr;
import com.discord.R$id;
import com.discord.R$plurals;
import com.discord.databinding.WidgetGuildsListItemFolderBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.GuildView;
import com.discord.views.ServerFolderView;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildListViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildListViewHolder$FolderViewHolder extends GuildListViewHolder implements GuildsDragAndDropCallback$DraggableViewHolder {
    private final WidgetGuildsListItemFolderBinding binding;

    @ColorInt
    private Integer color;
    private GuildListItem$FolderItem data;
    private boolean isDragging;
    private int numChildren;
    private final Function1<GuildListItem$FolderItem, Unit> onClicked;
    private final Function1<GuildListItem$FolderItem, Unit> onLongPressed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildListViewHolder$FolderViewHolder(View view, Function1<? super GuildListItem$FolderItem, Unit> function1, Function1<? super GuildListItem$FolderItem, Unit> function2) {
        super(view, null);
        m.checkNotNullParameter(view, "view");
        m.checkNotNullParameter(function1, "onClicked");
        m.checkNotNullParameter(function2, "onLongPressed");
        this.onClicked = function1;
        this.onLongPressed = function2;
        int i = R$id.guilds_item_folder;
        ServerFolderView serverFolderView = (ServerFolderView) view.findViewById(R$id.guilds_item_folder);
        if (serverFolderView != null) {
            i = R$id.guilds_item_folder_container;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R$id.guilds_item_folder_container);
            if (frameLayout != null) {
                i = R$id.guilds_item_highlight;
                View viewFindViewById = view.findViewById(R$id.guilds_item_highlight);
                if (viewFindViewById != null) {
                    i = R$id.guilds_item_mentions;
                    TextView textView = (TextView) view.findViewById(R$id.guilds_item_mentions);
                    if (textView != null) {
                        i = R$id.guilds_item_selected;
                        View viewFindViewById2 = view.findViewById(R$id.guilds_item_selected);
                        if (viewFindViewById2 != null) {
                            i = R$id.guilds_item_unread;
                            ImageView imageView = (ImageView) view.findViewById(R$id.guilds_item_unread);
                            if (imageView != null) {
                                i = R$id.guilds_item_voice;
                                ImageView imageView2 = (ImageView) view.findViewById(R$id.guilds_item_voice);
                                if (imageView2 != null) {
                                    WidgetGuildsListItemFolderBinding widgetGuildsListItemFolderBinding = new WidgetGuildsListItemFolderBinding((RelativeLayout) view, serverFolderView, frameLayout, viewFindViewById, textView, viewFindViewById2, imageView, imageView2);
                                    m.checkNotNullExpressionValue(widgetGuildsListItemFolderBinding, "WidgetGuildsListItemFolderBinding.bind(view)");
                                    this.binding = widgetGuildsListItemFolderBinding;
                                    m.checkNotNullExpressionValue(frameLayout, "binding.guildsItemFolderContainer");
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

    public static final /* synthetic */ Function1 access$getOnClicked$p(GuildListViewHolder$FolderViewHolder guildListViewHolder$FolderViewHolder) {
        return guildListViewHolder$FolderViewHolder.onClicked;
    }

    public static final /* synthetic */ Function1 access$getOnLongPressed$p(GuildListViewHolder$FolderViewHolder guildListViewHolder$FolderViewHolder) {
        return guildListViewHolder$FolderViewHolder.onLongPressed;
    }

    @Override // com.discord.widgets.guilds.list.GuildsDragAndDropCallback$DraggableViewHolder
    public boolean canDrag() {
        GuildListItem$FolderItem guildListItem$FolderItem;
        GuildListItem$FolderItem guildListItem$FolderItem2 = this.data;
        return (guildListItem$FolderItem2 == null || guildListItem$FolderItem2.isOpen() || ((guildListItem$FolderItem = this.data) != null && guildListItem$FolderItem.getIsPendingGuildsFolder())) ? false : true;
    }

    public final void configure(GuildListItem$FolderItem data) {
        m.checkNotNullParameter(data, "data");
        this.data = data;
        Integer color = data.getColor();
        this.color = color != null ? Integer.valueOf((int) (((long) color.intValue()) + 4278190080L)) : null;
        this.numChildren = data.isOpen() ? data.getGuilds().size() : 0;
        this.binding.a.setOnClickListener(new GuildListViewHolder$FolderViewHolder$configure$2(this, data));
        ServerFolderView serverFolderView = this.binding.f2460b;
        boolean isPendingGuildsFolder = data.getIsPendingGuildsFolder();
        long folderId = data.getFolderId();
        boolean zIsOpen = data.isOpen();
        List<Guild> guilds = data.getGuilds();
        Integer color2 = data.getColor();
        Objects.requireNonNull(serverFolderView);
        m.checkNotNullParameter(guilds, "guilds");
        if (isPendingGuildsFolder) {
            serverFolderView.folderId = Long.valueOf(folderId);
            serverFolderView.isOpen = zIsOpen;
            GridLayout gridLayout = serverFolderView.binding.g;
            m.checkNotNullExpressionValue(gridLayout, "binding.guildViews");
            gridLayout.setVisibility(zIsOpen ? 0 : 8);
            serverFolderView.binding.f126b.setImageDrawable(ContextCompat.getDrawable(serverFolderView.getContext(), 2131231838));
        } else {
            Long l = serverFolderView.folderId;
            boolean z2 = (l == null || l.longValue() != folderId || serverFolderView.isOpen == zIsOpen) ? false : true;
            serverFolderView.folderId = Long.valueOf(folderId);
            if (zIsOpen) {
                serverFolderView.isOpen = true;
                if (z2) {
                    serverFolderView.b(R$anim.anim_folder_slide_in_down);
                } else {
                    serverFolderView.a();
                }
                ImageViewCompat.setImageTintList(serverFolderView.binding.f126b, ColorStateList.valueOf((int) (((long) (color2 != null ? color2.intValue() : ColorCompat.getThemedColor(serverFolderView.getContext(), R$attr.color_brand_500))) + 4278190080L)));
            } else {
                serverFolderView.isOpen = false;
                if (z2) {
                    serverFolderView.b(R$anim.anim_folder_slide_out_up);
                } else {
                    serverFolderView.a();
                }
                h3 h3Var = serverFolderView.binding;
                int i = 0;
                for (Object obj : n.listOf((Object[]) new GuildView[]{h3Var.c, h3Var.d, h3Var.e, h3Var.f})) {
                    int i2 = i + 1;
                    if (i < 0) {
                        n.throwIndexOverflow();
                    }
                    GuildView guildView = (GuildView) obj;
                    if (n.getLastIndex(guilds) >= i) {
                        Guild guild = guilds.get(i);
                        String forGuild$default = guild.hasIcon() ? IconUtils.getForGuild$default(guild, IconUtils.DEFAULT_ICON, false, null, 12, null) : null;
                        m.checkNotNullExpressionValue(guildView, "guildView");
                        guildView.setVisibility(0);
                        guildView.a(forGuild$default, guild.getShortName());
                    } else {
                        m.checkNotNullExpressionValue(guildView, "guildView");
                        guildView.setVisibility(8);
                    }
                    i = i2;
                }
            }
        }
        View view = this.binding.f;
        m.checkNotNullExpressionValue(view, "binding.guildsItemSelected");
        view.setVisibility(!data.isOpen() && data.isAnyGuildSelected() ? 0 : 8);
        ImageView imageView = this.binding.g;
        m.checkNotNullExpressionValue(imageView, "binding.guildsItemUnread");
        imageView.setVisibility(!data.isOpen() && data.getIsUnread() ? 0 : 8);
        ImageView imageView2 = this.binding.h;
        imageView2.setActivated(data.isAnyGuildConnectedToVoice());
        imageView2.setVisibility(!data.isOpen() && data.isAnyGuildConnectedToVoice() ? 0 : 8);
        imageView2.setImageResource(data.isAnyGuildConnectedToStageChannel() ? 2131231627 : 2131232262);
        View view2 = this.binding.d;
        m.checkNotNullExpressionValue(view2, "binding.guildsItemHighlight");
        view2.setVisibility(data.isTargetedForFolderAddition() ? 0 : 8);
        int mentionCount = data.getMentionCount();
        Object i18nPluralString = mentionCount > 0 ? StringResourceUtilsKt.getI18nPluralString(a.x(this.itemView, "itemView", "itemView.context"), R$plurals.guild_folder_tooltip_a11y_label_mentions, mentionCount, Integer.valueOf(mentionCount)) : "";
        View view3 = this.itemView;
        m.checkNotNullExpressionValue(view3, "itemView");
        CharSequence charSequenceJ = b.j(view3, data.isOpen() ? 2131888963 : 2131887705, new Object[0], null, 4);
        View view4 = this.itemView;
        m.checkNotNullExpressionValue(view4, "itemView");
        View view5 = this.itemView;
        m.checkNotNullExpressionValue(view5, "itemView");
        view4.setContentDescription(b.j(view5, 2131890229, new Object[]{data.getName(), i18nPluralString, charSequenceJ}, null, 4));
        View view6 = this.itemView;
        m.checkNotNullExpressionValue(view6, "itemView");
        ViewExtensions.setOnLongClickListenerConsumeClick(view6, new GuildListViewHolder$FolderViewHolder$configure$4(this, data));
        TextView textView = this.binding.e;
        m.checkNotNullExpressionValue(textView, "binding.guildsItemMentions");
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
        ServerFolderView serverFolderView = this.binding.f2460b;
        m.checkNotNullExpressionValue(serverFolderView, "binding.guildsItemFolder");
        serverFolderView.setBackground(null);
    }

    @Override // com.discord.widgets.guilds.list.GuildListViewHolder
    public void onDragStarted() {
        this.isDragging = true;
        ServerFolderView serverFolderView = this.binding.f2460b;
        m.checkNotNullExpressionValue(serverFolderView, "binding.guildsItemFolder");
        ServerFolderView serverFolderView2 = this.binding.f2460b;
        m.checkNotNullExpressionValue(serverFolderView2, "binding.guildsItemFolder");
        serverFolderView.setBackground(ContextCompat.getDrawable(serverFolderView2.getContext(), 2131231315));
    }

    public final void setColor(Integer num) {
        this.color = num;
    }

    public final boolean shouldDrawDecoration() {
        return !this.isDragging;
    }
}
