package com.discord.widgets.guilds.profile;

import android.view.View;
import com.discord.databinding.WidgetGuildProfileEmojiItemBinding;
import com.discord.models.domain.emoji.Emoji;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.facebook.drawee.view.SimpleDraweeView;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildProfileSheetEmojisAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiViewHolder extends BaseEmojiViewHolder {
    private final WidgetGuildProfileEmojiItemBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    public EmojiViewHolder(WidgetGuildProfileEmojiItemBinding widgetGuildProfileEmojiItemBinding) {
        C12238m.checkNotNullParameter(widgetGuildProfileEmojiItemBinding, "binding");
        SimpleDraweeView simpleDraweeView = widgetGuildProfileEmojiItemBinding.f16887a;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.root");
        super(simpleDraweeView);
        this.binding = widgetGuildProfileEmojiItemBinding;
    }

    @Override // com.discord.widgets.guilds.profile.BaseEmojiViewHolder
    public void bind(EmojiItem data) {
        C12238m.checkNotNullParameter(data, "data");
        super.bind(data);
        SimpleDraweeView simpleDraweeView = this.binding.f16888b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildProfileSheetEmojiImageview");
        int mediaProxySize = IconUtils.getMediaProxySize(simpleDraweeView.getLayoutParams().width);
        SimpleDraweeView simpleDraweeView2 = this.binding.f16888b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.guildProfileSheetEmojiImageview");
        Emoji emoji = ((EmojiItem.EmojiData) data).getEmoji();
        View view = this.itemView;
        C12238m.checkNotNullExpressionValue(view, "itemView");
        MGImages.setImage$default(simpleDraweeView2, emoji.getImageUri(true, mediaProxySize, view.getContext()), 0, 0, false, null, null, 124, null);
    }
}
