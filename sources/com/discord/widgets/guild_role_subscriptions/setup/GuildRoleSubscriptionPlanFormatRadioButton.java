package com.discord.widgets.guild_role_subscriptions.setup;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Checkable;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.discord.R$a;
import com.discord.databinding.ViewGuildRoleSubscriptionPlanFormatRadioButtonBinding;
import com.google.android.material.radiobutton.MaterialRadioButton;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildRoleSubscriptionPlanFormatRadioButton.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionPlanFormatRadioButton extends ConstraintLayout implements Checkable {
    public static final GuildRoleSubscriptionPlanFormatRadioButton$Companion Companion = new GuildRoleSubscriptionPlanFormatRadioButton$Companion(null);
    private static final int ENTIRE_SERVER_FORMAT_TYPE = 0;
    private static final int SOME_CHANNELS_FORMAT_TYPE = 1;
    private final ViewGuildRoleSubscriptionPlanFormatRadioButtonBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionPlanFormatRadioButton(Context context) {
        super(context);
        m.checkNotNullParameter(context, "context");
        ViewGuildRoleSubscriptionPlanFormatRadioButtonBinding viewGuildRoleSubscriptionPlanFormatRadioButtonBindingA = ViewGuildRoleSubscriptionPlanFormatRadioButtonBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(viewGuildRoleSubscriptionPlanFormatRadioButtonBindingA, "ViewGuildRoleSubscriptio…ater.from(context), this)");
        this.binding = viewGuildRoleSubscriptionPlanFormatRadioButtonBindingA;
        initialize$default(this, null, 1, null);
    }

    private final void configureUI(int formatType) {
        if (formatType == 0) {
            this.binding.d.setText(2131890499);
            this.binding.c.setText(2131890498);
            this.binding.e.setImageResource(2131231892);
        } else {
            if (formatType != 1) {
                return;
            }
            this.binding.d.setText(2131890502);
            this.binding.c.setText(2131890501);
            this.binding.e.setImageResource(2131231630);
        }
    }

    private final void initialize(AttributeSet attrs) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131165456);
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        setBackground(ContextCompat.getDrawable(getContext(), 2131230999));
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        int[] iArr = R$a.GuildRoleSubscriptionPlanFormatRadioButton;
        m.checkNotNullExpressionValue(iArr, "R.styleable.GuildRoleSub…tionPlanFormatRadioButton");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, iArr);
        m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(attrs, styleable)");
        configureUI(typedArrayObtainStyledAttributes.getInt(0, 0));
        typedArrayObtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void initialize$default(GuildRoleSubscriptionPlanFormatRadioButton guildRoleSubscriptionPlanFormatRadioButton, AttributeSet attributeSet, int i, Object obj) {
        if ((i & 1) != 0) {
            attributeSet = null;
        }
        guildRoleSubscriptionPlanFormatRadioButton.initialize(attributeSet);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        MaterialRadioButton materialRadioButton = this.binding.f2197b;
        m.checkNotNullExpressionValue(materialRadioButton, "binding.guildRoleSubscriptionPlanFormatButton");
        return materialRadioButton.isChecked();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean checked) {
        setSelected(checked);
        ImageView imageView = this.binding.e;
        m.checkNotNullExpressionValue(imageView, "binding.guildRoleSubscriptionPlanFormatImage");
        imageView.setSelected(checked);
        MaterialRadioButton materialRadioButton = this.binding.f2197b;
        m.checkNotNullExpressionValue(materialRadioButton, "binding.guildRoleSubscriptionPlanFormatButton");
        materialRadioButton.setChecked(checked);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!isSelected());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionPlanFormatRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        ViewGuildRoleSubscriptionPlanFormatRadioButtonBinding viewGuildRoleSubscriptionPlanFormatRadioButtonBindingA = ViewGuildRoleSubscriptionPlanFormatRadioButtonBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(viewGuildRoleSubscriptionPlanFormatRadioButtonBindingA, "ViewGuildRoleSubscriptio…ater.from(context), this)");
        this.binding = viewGuildRoleSubscriptionPlanFormatRadioButtonBindingA;
        initialize(attributeSet);
    }

    public /* synthetic */ GuildRoleSubscriptionPlanFormatRadioButton(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionPlanFormatRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "context");
        ViewGuildRoleSubscriptionPlanFormatRadioButtonBinding viewGuildRoleSubscriptionPlanFormatRadioButtonBindingA = ViewGuildRoleSubscriptionPlanFormatRadioButtonBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(viewGuildRoleSubscriptionPlanFormatRadioButtonBindingA, "ViewGuildRoleSubscriptio…ater.from(context), this)");
        this.binding = viewGuildRoleSubscriptionPlanFormatRadioButtonBindingA;
        initialize(attributeSet);
    }

    public /* synthetic */ GuildRoleSubscriptionPlanFormatRadioButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
