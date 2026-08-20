package com.discord.widgets.guilds.profile;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetGuildProfileEmojiExtraBinding;
import p007b.p008a.p027k.C1107b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildProfileSheetEmojisAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MoreEmojiViewHolder extends BaseEmojiViewHolder {
    private final WidgetGuildProfileEmojiExtraBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    public MoreEmojiViewHolder(WidgetGuildProfileEmojiExtraBinding widgetGuildProfileEmojiExtraBinding) {
        C12238m.checkNotNullParameter(widgetGuildProfileEmojiExtraBinding, "binding");
        TextView textView = widgetGuildProfileEmojiExtraBinding.f16886a;
        C12238m.checkNotNullExpressionValue(textView, "binding.root");
        super(textView);
        this.binding = widgetGuildProfileEmojiExtraBinding;
    }

    @Override // com.discord.widgets.guilds.profile.BaseEmojiViewHolder
    public void bind(EmojiItem data) {
        C12238m.checkNotNullParameter(data, "data");
        super.bind(data);
        TextView textView = this.binding.f16886a;
        C12238m.checkNotNullExpressionValue(textView, "binding.root");
        View view = this.itemView;
        C12238m.checkNotNullExpressionValue(view, "itemView");
        Resources resources = view.getResources();
        C12238m.checkNotNullExpressionValue(resources, "itemView.resources");
        textView.setText(C1107b.m211c(resources, C5419R.string.extra_emoji_count, new Object[]{String.valueOf(((EmojiItem.MoreEmoji) data).getExtraEmojiCount())}, (4 & 4) != 0 ? C1107b.d.f1493j : null));
    }
}
