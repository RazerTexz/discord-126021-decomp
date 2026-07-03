package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.databinding.GuildScheduledEventBottomButtonViewBinding;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildScheduledEventBottomButtonView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventBottomButtonView extends ConstraintLayout {
    private final GuildScheduledEventBottomButtonViewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventBottomButtonView(Context context) {
        super(context);
        C12238m.checkNotNullParameter(context, "context");
        GuildScheduledEventBottomButtonViewBinding guildScheduledEventBottomButtonViewBindingM8386a = GuildScheduledEventBottomButtonViewBinding.m8386a(LayoutInflater.from(getContext()), this, true);
        C12238m.checkNotNullExpressionValue(guildScheduledEventBottomButtonViewBindingM8386a, "GuildScheduledEventBotto…rom(context), this, true)");
        this.binding = guildScheduledEventBottomButtonViewBindingM8386a;
    }

    private final void configureInterestedButton(ButtonConfiguration buttonConfiguration) {
        ImageView imageView = this.binding.f15130e;
        imageView.setVisibility(buttonConfiguration.getSecondaryButtonVisible() ? 0 : 8);
        imageView.setImageResource(buttonConfiguration.getSecondaryButtonBackground());
        imageView.setOnClickListener(buttonConfiguration.getSecondaryButtonOnClickListener());
        imageView.setEnabled(buttonConfiguration.getSecondaryButtonEnabled());
        TextView textView = this.binding.f15131f;
        textView.setVisibility(buttonConfiguration.getSecondaryButtonVisible() ? 0 : 8);
        DrawableCompat.setCompoundDrawablesCompat$default(textView, buttonConfiguration.getSecondaryButtonTextDrawableRes(), 0, 0, 0, 14, (Object) null);
        Context context = textView.getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        textView.setTextColor(buttonConfiguration.secondaryButtonTextColor(context));
        Context context2 = textView.getContext();
        C12238m.checkNotNullExpressionValue(context2, "context");
        textView.setText(buttonConfiguration.secondaryButtonText(context2));
    }

    private final void configureShareButton(ButtonConfiguration buttonConfiguration) {
        ImageView imageView = this.binding.f15132g;
        C12238m.checkNotNullExpressionValue(imageView, "this");
        imageView.setVisibility(buttonConfiguration.getIsShareVisible() ? 0 : 8);
        imageView.setOnClickListener(buttonConfiguration.getShareButtonOnClickListener());
    }

    private final void configureStartEventButton(ButtonConfiguration buttonConfiguration) {
        TextView textView = this.binding.f15129d;
        Context context = textView.getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        ViewExtensions.setTextAndVisibilityBy(textView, buttonConfiguration.primaryButtonText(context));
        textView.setVisibility(buttonConfiguration.getPrimaryButtonVisible() ? 0 : 8);
        ImageView imageView = this.binding.f15128c;
        imageView.setVisibility(buttonConfiguration.getPrimaryButtonVisible() ? 0 : 8);
        imageView.setOnClickListener(buttonConfiguration.getPrimaryButtonOnClickListener());
    }

    public final void configure(ButtonConfiguration buttonConfiguration) {
        C12238m.checkNotNullParameter(buttonConfiguration, "buttonConfiguration");
        configureStartEventButton(buttonConfiguration);
        configureInterestedButton(buttonConfiguration);
        configureShareButton(buttonConfiguration);
    }

    public final void configureForDetails(ButtonConfiguration buttonConfiguration) {
        C12238m.checkNotNullParameter(buttonConfiguration, "buttonConfiguration");
        configureStartEventButton(buttonConfiguration);
        if (buttonConfiguration.getPrimaryButtonVisible()) {
            ImageView imageView = this.binding.f15130e;
            C12238m.checkNotNullExpressionValue(imageView, "binding.secondaryButton");
            imageView.setVisibility(8);
            TextView textView = this.binding.f15131f;
            C12238m.checkNotNullExpressionValue(textView, "binding.secondaryButtonText");
            textView.setVisibility(8);
        } else {
            configureInterestedButton(buttonConfiguration);
        }
        configureShareButton(buttonConfiguration);
        ImageView imageView2 = this.binding.f15127b;
        imageView2.setVisibility(buttonConfiguration.getExtrasButtonOnClickListener() != null && buttonConfiguration.getIsExtrasVisible() ? 0 : 8);
        imageView2.setOnClickListener(buttonConfiguration.getExtrasButtonOnClickListener());
    }

    public final GuildScheduledEventBottomButtonViewBinding getBinding() {
        return this.binding;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventBottomButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(attributeSet, "attrs");
        GuildScheduledEventBottomButtonViewBinding guildScheduledEventBottomButtonViewBindingM8386a = GuildScheduledEventBottomButtonViewBinding.m8386a(LayoutInflater.from(getContext()), this, true);
        C12238m.checkNotNullExpressionValue(guildScheduledEventBottomButtonViewBindingM8386a, "GuildScheduledEventBotto…rom(context), this, true)");
        this.binding = guildScheduledEventBottomButtonViewBindingM8386a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventBottomButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(attributeSet, "attrs");
        GuildScheduledEventBottomButtonViewBinding guildScheduledEventBottomButtonViewBindingM8386a = GuildScheduledEventBottomButtonViewBinding.m8386a(LayoutInflater.from(getContext()), this, true);
        C12238m.checkNotNullExpressionValue(guildScheduledEventBottomButtonViewBindingM8386a, "GuildScheduledEventBotto…rom(context), this, true)");
        this.binding = guildScheduledEventBottomButtonViewBindingM8386a;
    }
}
