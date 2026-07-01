package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.databinding.GuildEventPromptViewBinding;
import com.discord.utilities.color.ColorCompat2;
import com.google.android.material.textview.MaterialTextView;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: GuildEventPromptView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildEventPromptView extends ConstraintLayout {
    private final GuildEventPromptViewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildEventPromptView(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        GuildEventPromptViewBinding guildEventPromptViewBindingA = GuildEventPromptViewBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(guildEventPromptViewBindingA, "GuildEventPromptViewBind…rom(context), this, true)");
        this.binding = guildEventPromptViewBindingA;
    }

    public final void configure(@DrawableRes int iconRes, @ColorRes int iconBackgroundColorRes, CharSequence title, CharSequence subtitle) {
        Intrinsics3.checkNotNullParameter(title, "title");
        Intrinsics3.checkNotNullParameter(subtitle, "subtitle");
        this.binding.f2117b.setImageResource(iconRes);
        ImageView imageView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.iconBg");
        ColorCompat2.tintWithColorResource(imageView, iconBackgroundColorRes);
        MaterialTextView materialTextView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(materialTextView, "binding.title");
        materialTextView.setText(title);
        MaterialTextView materialTextView2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(materialTextView2, "binding.subtitle");
        materialTextView2.setText(subtitle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildEventPromptView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        GuildEventPromptViewBinding guildEventPromptViewBindingA = GuildEventPromptViewBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(guildEventPromptViewBindingA, "GuildEventPromptViewBind…rom(context), this, true)");
        this.binding = guildEventPromptViewBindingA;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildEventPromptView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        GuildEventPromptViewBinding guildEventPromptViewBindingA = GuildEventPromptViewBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(guildEventPromptViewBindingA, "GuildEventPromptViewBind…rom(context), this, true)");
        this.binding = guildEventPromptViewBindingA;
    }
}
