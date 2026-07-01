package com.discord.widgets.guilds.profile;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.databinding.WidgetGuildProfileEmojiExtraBinding;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheetEmojisAdapter3;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.guilds.profile.MoreEmojiViewHolder, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildProfileSheetEmojisAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildProfileSheetEmojisAdapter5 extends WidgetGuildProfileSheetEmojisAdapter2 {
    private final WidgetGuildProfileEmojiExtraBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetGuildProfileSheetEmojisAdapter5(WidgetGuildProfileEmojiExtraBinding widgetGuildProfileEmojiExtraBinding) {
        Intrinsics3.checkNotNullParameter(widgetGuildProfileEmojiExtraBinding, "binding");
        TextView textView = widgetGuildProfileEmojiExtraBinding.a;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.root");
        super(textView);
        this.binding = widgetGuildProfileEmojiExtraBinding;
    }

    @Override // com.discord.widgets.guilds.profile.WidgetGuildProfileSheetEmojisAdapter2
    public void bind(WidgetGuildProfileSheetEmojisAdapter3 data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.bind(data);
        TextView textView = this.binding.a;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.root");
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        Resources resources = view.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "itemView.resources");
        textView.setText(FormatUtils.c(resources, R.string.extra_emoji_count, new Object[]{String.valueOf(((WidgetGuildProfileSheetEmojisAdapter3.MoreEmoji) data).getExtraEmojiCount())}, (4 & 4) != 0 ? FormatUtils.d.j : null));
    }
}
