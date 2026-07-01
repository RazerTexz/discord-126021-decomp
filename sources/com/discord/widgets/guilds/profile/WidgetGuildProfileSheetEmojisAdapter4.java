package com.discord.widgets.guilds.profile;

import android.view.View;
import com.discord.databinding.WidgetGuildProfileEmojiItemBinding;
import com.discord.models.domain.emoji.Emoji;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheetEmojisAdapter3;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.guilds.profile.EmojiViewHolder, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildProfileSheetEmojisAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildProfileSheetEmojisAdapter4 extends WidgetGuildProfileSheetEmojisAdapter2 {
    private final WidgetGuildProfileEmojiItemBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetGuildProfileSheetEmojisAdapter4(WidgetGuildProfileEmojiItemBinding widgetGuildProfileEmojiItemBinding) {
        Intrinsics3.checkNotNullParameter(widgetGuildProfileEmojiItemBinding, "binding");
        SimpleDraweeView simpleDraweeView = widgetGuildProfileEmojiItemBinding.a;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.root");
        super(simpleDraweeView);
        this.binding = widgetGuildProfileEmojiItemBinding;
    }

    @Override // com.discord.widgets.guilds.profile.WidgetGuildProfileSheetEmojisAdapter2
    public void bind(WidgetGuildProfileSheetEmojisAdapter3 data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.bind(data);
        SimpleDraweeView simpleDraweeView = this.binding.f2430b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildProfileSheetEmojiImageview");
        int mediaProxySize = IconUtils.getMediaProxySize(simpleDraweeView.getLayoutParams().width);
        SimpleDraweeView simpleDraweeView2 = this.binding.f2430b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.guildProfileSheetEmojiImageview");
        Emoji emoji = ((WidgetGuildProfileSheetEmojisAdapter3.EmojiData) data).getEmoji();
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        MGImages.setImage$default(simpleDraweeView2, emoji.getImageUri(true, mediaProxySize, view.getContext()), 0, 0, false, null, null, 124, null);
    }
}
