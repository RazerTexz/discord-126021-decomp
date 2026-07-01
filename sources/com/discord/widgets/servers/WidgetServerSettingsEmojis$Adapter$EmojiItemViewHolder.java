package com.discord.widgets.servers;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetServerSettingsEmojisItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.member.GuildMember;
import com.discord.models.user.CoreUser;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.extensions.ImageViewExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmojis$Adapter$EmojiItemViewHolder extends MGRecyclerViewHolder<WidgetServerSettingsEmojis$Adapter, WidgetServerSettingsEmojis$Item> {
    private final WidgetServerSettingsEmojisItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEmojis$Adapter$EmojiItemViewHolder(WidgetServerSettingsEmojis$Adapter widgetServerSettingsEmojis$Adapter) {
        super(R$layout.widget_server_settings_emojis_item, widgetServerSettingsEmojis$Adapter);
        m.checkNotNullParameter(widgetServerSettingsEmojis$Adapter, "adapter");
        View view = this.itemView;
        int i = R$id.server_settings_emojis_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.server_settings_emojis_avatar);
        if (simpleDraweeView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R$id.server_settings_emojis_name;
            TextView textView = (TextView) view.findViewById(R$id.server_settings_emojis_name);
            if (textView != null) {
                i = R$id.server_settings_emojis_nickname;
                TextView textView2 = (TextView) view.findViewById(R$id.server_settings_emojis_nickname);
                if (textView2 != null) {
                    i = R$id.server_settings_emojis_overflow;
                    ImageView imageView = (ImageView) view.findViewById(R$id.server_settings_emojis_overflow);
                    if (imageView != null) {
                        i = R$id.server_settings_emojis_username;
                        TextView textView3 = (TextView) view.findViewById(R$id.server_settings_emojis_username);
                        if (textView3 != null) {
                            i = R$id.server_settings_emojis_username_avatar;
                            SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) view.findViewById(R$id.server_settings_emojis_username_avatar);
                            if (simpleDraweeView2 != null) {
                                WidgetServerSettingsEmojisItemBinding widgetServerSettingsEmojisItemBinding = new WidgetServerSettingsEmojisItemBinding(constraintLayout, simpleDraweeView, constraintLayout, textView, textView2, imageView, textView3, simpleDraweeView2);
                                m.checkNotNullExpressionValue(widgetServerSettingsEmojisItemBinding, "WidgetServerSettingsEmoj…temBinding.bind(itemView)");
                                this.binding = widgetServerSettingsEmojisItemBinding;
                                return;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetServerSettingsEmojis$Adapter access$getAdapter$p(WidgetServerSettingsEmojis$Adapter$EmojiItemViewHolder widgetServerSettingsEmojis$Adapter$EmojiItemViewHolder) {
        return (WidgetServerSettingsEmojis$Adapter) widgetServerSettingsEmojis$Adapter$EmojiItemViewHolder.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetServerSettingsEmojis$Item widgetServerSettingsEmojis$Item) {
        onConfigure2(i, widgetServerSettingsEmojis$Item);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetServerSettingsEmojis$Item data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        WidgetServerSettingsEmojis$Item$EmojiItem widgetServerSettingsEmojis$Item$EmojiItem = (WidgetServerSettingsEmojis$Item$EmojiItem) data;
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.serverSettingsEmojisName");
        textView.setText(widgetServerSettingsEmojis$Item$EmojiItem.getEmoji().getName());
        TextView textView2 = this.binding.f;
        m.checkNotNullExpressionValue(textView2, "binding.serverSettingsEmojisUsername");
        textView2.setText(UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, widgetServerSettingsEmojis$Item$EmojiItem.getUser(), null, null, 3, null));
        GuildMember guildMember = widgetServerSettingsEmojis$Item$EmojiItem.getGuildMember();
        String nick = guildMember != null ? guildMember.getNick() : null;
        TextView textView3 = this.binding.e;
        m.checkNotNullExpressionValue(textView3, "binding.serverSettingsEmojisNickname");
        ViewExtensions.setTextAndVisibilityBy(textView3, nick);
        SimpleDraweeView simpleDraweeView = this.binding.g;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.serverSettingsEmojisUsernameAvatar");
        IconUtils.setIcon$default(simpleDraweeView, new CoreUser(widgetServerSettingsEmojis$Item$EmojiItem.getEmoji().getUser()), 2131165300, null, null, guildMember, 24, null);
        String imageUri = ModelEmojiCustom.getImageUri(widgetServerSettingsEmojis$Item$EmojiItem.getEmoji().getId(), widgetServerSettingsEmojis$Item$EmojiItem.getEmoji().getAnimated(), 64);
        SimpleDraweeView simpleDraweeView2 = this.binding.f2565b;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.serverSettingsEmojisAvatar");
        MGImages.setImage$default(simpleDraweeView2, imageUri, 2131165401, 2131165401, true, null, null, 96, null);
        SimpleDraweeView simpleDraweeView3 = this.binding.f2565b;
        m.checkNotNullExpressionValue(simpleDraweeView3, "binding.serverSettingsEmojisAvatar");
        ImageViewExtensionsKt.setGrayscale(simpleDraweeView3, !widgetServerSettingsEmojis$Item$EmojiItem.getEmoji().getAvailable());
        SimpleDraweeView simpleDraweeView4 = this.binding.f2565b;
        m.checkNotNullExpressionValue(simpleDraweeView4, "binding.serverSettingsEmojisAvatar");
        simpleDraweeView4.setImageAlpha(widgetServerSettingsEmojis$Item$EmojiItem.getEmoji().getAvailable() ? 255 : 100);
        this.binding.c.setOnClickListener(new WidgetServerSettingsEmojis$Adapter$EmojiItemViewHolder$onConfigure$1(this, data));
    }
}
