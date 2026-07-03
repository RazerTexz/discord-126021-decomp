package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.databinding.GuildEventPromptViewBinding;
import com.discord.utilities.color.ColorCompatKt;
import com.google.android.material.textview.MaterialTextView;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildEventPromptView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildEventPromptView extends ConstraintLayout {
    private final GuildEventPromptViewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildEventPromptView(Context context) {
        super(context);
        C12238m.checkNotNullParameter(context, "context");
        GuildEventPromptViewBinding guildEventPromptViewBindingM8385a = GuildEventPromptViewBinding.m8385a(LayoutInflater.from(getContext()), this, true);
        C12238m.checkNotNullExpressionValue(guildEventPromptViewBindingM8385a, "GuildEventPromptViewBind…rom(context), this, true)");
        this.binding = guildEventPromptViewBindingM8385a;
    }

    public final void configure(@DrawableRes int iconRes, @ColorRes int iconBackgroundColorRes, CharSequence title, CharSequence subtitle) {
        C12238m.checkNotNullParameter(title, "title");
        C12238m.checkNotNullParameter(subtitle, "subtitle");
        this.binding.f15122b.setImageResource(iconRes);
        ImageView imageView = this.binding.f15123c;
        C12238m.checkNotNullExpressionValue(imageView, "binding.iconBg");
        ColorCompatKt.tintWithColorResource(imageView, iconBackgroundColorRes);
        MaterialTextView materialTextView = this.binding.f15125e;
        C12238m.checkNotNullExpressionValue(materialTextView, "binding.title");
        materialTextView.setText(title);
        MaterialTextView materialTextView2 = this.binding.f15124d;
        C12238m.checkNotNullExpressionValue(materialTextView2, "binding.subtitle");
        materialTextView2.setText(subtitle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildEventPromptView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        GuildEventPromptViewBinding guildEventPromptViewBindingM8385a = GuildEventPromptViewBinding.m8385a(LayoutInflater.from(getContext()), this, true);
        C12238m.checkNotNullExpressionValue(guildEventPromptViewBindingM8385a, "GuildEventPromptViewBind…rom(context), this, true)");
        this.binding = guildEventPromptViewBindingM8385a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildEventPromptView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C12238m.checkNotNullParameter(context, "context");
        GuildEventPromptViewBinding guildEventPromptViewBindingM8385a = GuildEventPromptViewBinding.m8385a(LayoutInflater.from(getContext()), this, true);
        C12238m.checkNotNullExpressionValue(guildEventPromptViewBindingM8385a, "GuildEventPromptViewBind…rom(context), this, true)");
        this.binding = guildEventPromptViewBindingM8385a;
    }
}
