package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import com.discord.api.role.GuildRole;
import com.discord.databinding.WidgetChatListAdapterItemTextBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import d0.g;
import d0.g0.t;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildRoleSubscriptionMemberPreview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionMemberPreview extends FrameLayout {
    private final WidgetChatListAdapterItemTextBinding binding;

    /* JADX INFO: renamed from: defaultColor$delegate, reason: from kotlin metadata */
    private final Lazy defaultColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionMemberPreview(Context context) {
        super(context);
        m.checkNotNullParameter(context, "context");
        WidgetChatListAdapterItemTextBinding widgetChatListAdapterItemTextBindingB = WidgetChatListAdapterItemTextBinding.b(LayoutInflater.from(getContext()), this, true);
        m.checkNotNullExpressionValue(widgetChatListAdapterItemTextBindingB, "WidgetChatListAdapterIte…rom(context), this, true)");
        this.binding = widgetChatListAdapterItemTextBindingB;
        this.defaultColor = g.lazy(new GuildRoleSubscriptionMemberPreview$defaultColor$2(this));
        if (isInEditMode()) {
            widgetChatListAdapterItemTextBindingB.c.setImageResource(2131232372);
        } else {
            widgetChatListAdapterItemTextBindingB.c.setActualImageResource(2131232372);
        }
        TextView textView = widgetChatListAdapterItemTextBindingB.f;
        m.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemTextTag");
        textView.setVisibility(8);
        widgetChatListAdapterItemTextBindingB.d.setText(2131897265);
        widgetChatListAdapterItemTextBindingB.g.setText(2131895216);
        widgetChatListAdapterItemTextBindingB.f2338b.setText(2131890662);
        setBackgroundColor(ColorCompat.getThemedColor(this, 2130968911));
        widgetChatListAdapterItemTextBindingB.h.setPadding(0, 0, 0, 0);
        widgetChatListAdapterItemTextBindingB.e.setRole((GuildRole) null, (Long) null);
    }

    private final int getDefaultColor() {
        return ((Number) this.defaultColor.getValue()).intValue();
    }

    public static /* synthetic */ void setMemberDesign$default(GuildRoleSubscriptionMemberPreview guildRoleSubscriptionMemberPreview, Integer num, String str, GuildRole guildRole, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            guildRole = null;
        }
        guildRoleSubscriptionMemberPreview.setMemberDesign(num, str, guildRole);
    }

    public final void setMemberDesign(@ColorInt Integer color, String icon, GuildRole guildRole) {
        this.binding.d.setTextColor(color != null ? color.intValue() : getDefaultColor());
        if (icon == null || t.isBlank(icon)) {
            this.binding.e.setRoleIconPreview(guildRole);
        } else {
            this.binding.e.setRoleIconPreview(icon);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionMemberPreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        WidgetChatListAdapterItemTextBinding widgetChatListAdapterItemTextBindingB = WidgetChatListAdapterItemTextBinding.b(LayoutInflater.from(getContext()), this, true);
        m.checkNotNullExpressionValue(widgetChatListAdapterItemTextBindingB, "WidgetChatListAdapterIte…rom(context), this, true)");
        this.binding = widgetChatListAdapterItemTextBindingB;
        this.defaultColor = g.lazy(new GuildRoleSubscriptionMemberPreview$defaultColor$2(this));
        if (isInEditMode()) {
            widgetChatListAdapterItemTextBindingB.c.setImageResource(2131232372);
        } else {
            widgetChatListAdapterItemTextBindingB.c.setActualImageResource(2131232372);
        }
        TextView textView = widgetChatListAdapterItemTextBindingB.f;
        m.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemTextTag");
        textView.setVisibility(8);
        widgetChatListAdapterItemTextBindingB.d.setText(2131897265);
        widgetChatListAdapterItemTextBindingB.g.setText(2131895216);
        widgetChatListAdapterItemTextBindingB.f2338b.setText(2131890662);
        setBackgroundColor(ColorCompat.getThemedColor(this, 2130968911));
        widgetChatListAdapterItemTextBindingB.h.setPadding(0, 0, 0, 0);
        widgetChatListAdapterItemTextBindingB.e.setRole((GuildRole) null, (Long) null);
    }

    public /* synthetic */ GuildRoleSubscriptionMemberPreview(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionMemberPreview(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "context");
        WidgetChatListAdapterItemTextBinding widgetChatListAdapterItemTextBindingB = WidgetChatListAdapterItemTextBinding.b(LayoutInflater.from(getContext()), this, true);
        m.checkNotNullExpressionValue(widgetChatListAdapterItemTextBindingB, "WidgetChatListAdapterIte…rom(context), this, true)");
        this.binding = widgetChatListAdapterItemTextBindingB;
        this.defaultColor = g.lazy(new GuildRoleSubscriptionMemberPreview$defaultColor$2(this));
        if (isInEditMode()) {
            widgetChatListAdapterItemTextBindingB.c.setImageResource(2131232372);
        } else {
            widgetChatListAdapterItemTextBindingB.c.setActualImageResource(2131232372);
        }
        TextView textView = widgetChatListAdapterItemTextBindingB.f;
        m.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemTextTag");
        textView.setVisibility(8);
        widgetChatListAdapterItemTextBindingB.d.setText(2131897265);
        widgetChatListAdapterItemTextBindingB.g.setText(2131895216);
        widgetChatListAdapterItemTextBindingB.f2338b.setText(2131890662);
        setBackgroundColor(ColorCompat.getThemedColor(this, 2130968911));
        widgetChatListAdapterItemTextBindingB.h.setPadding(0, 0, 0, 0);
        widgetChatListAdapterItemTextBindingB.e.setRole((GuildRole) null, (Long) null);
    }

    public /* synthetic */ GuildRoleSubscriptionMemberPreview(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
