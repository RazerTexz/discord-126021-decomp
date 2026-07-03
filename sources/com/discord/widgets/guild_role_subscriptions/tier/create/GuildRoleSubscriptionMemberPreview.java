package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import com.discord.C5419R;
import com.discord.api.role.GuildRole;
import com.discord.databinding.WidgetChatListAdapterItemTextBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.C12083g;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildRoleSubscriptionMemberPreview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionMemberPreview extends FrameLayout {
    private final WidgetChatListAdapterItemTextBinding binding;

    /* JADX INFO: renamed from: defaultColor$delegate, reason: from kotlin metadata */
    private final Lazy defaultColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionMemberPreview(Context context) {
        super(context);
        C12238m.checkNotNullParameter(context, "context");
        WidgetChatListAdapterItemTextBinding widgetChatListAdapterItemTextBindingM8409b = WidgetChatListAdapterItemTextBinding.m8409b(LayoutInflater.from(getContext()), this, true);
        C12238m.checkNotNullExpressionValue(widgetChatListAdapterItemTextBindingM8409b, "WidgetChatListAdapterIte…rom(context), this, true)");
        this.binding = widgetChatListAdapterItemTextBindingM8409b;
        this.defaultColor = C12083g.lazy(new GuildRoleSubscriptionMemberPreview$defaultColor$2(this));
        if (isInEditMode()) {
            widgetChatListAdapterItemTextBindingM8409b.f16319c.setImageResource(C5419R.drawable.img_guild_role_subscription_default_avatar_40dp);
        } else {
            widgetChatListAdapterItemTextBindingM8409b.f16319c.setActualImageResource(C5419R.drawable.img_guild_role_subscription_default_avatar_40dp);
        }
        TextView textView = widgetChatListAdapterItemTextBindingM8409b.f16322f;
        C12238m.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemTextTag");
        textView.setVisibility(8);
        widgetChatListAdapterItemTextBindingM8409b.f16320d.setText(C5419R.string.wumpus);
        widgetChatListAdapterItemTextBindingM8409b.f16323g.setText(C5419R.string.sample_time_pm);
        widgetChatListAdapterItemTextBindingM8409b.f16318b.setText(C5419R.string.f14711xdb419408);
        setBackgroundColor(ColorCompat.getThemedColor(this, C5419R.attr.colorBackgroundPrimary));
        widgetChatListAdapterItemTextBindingM8409b.f16324h.setPadding(0, 0, 0, 0);
        widgetChatListAdapterItemTextBindingM8409b.f16321e.setRole((GuildRole) null, (Long) null);
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
        this.binding.f16320d.setTextColor(color != null ? color.intValue() : getDefaultColor());
        if (icon == null || C12103t.isBlank(icon)) {
            this.binding.f16321e.setRoleIconPreview(guildRole);
        } else {
            this.binding.f16321e.setRoleIconPreview(icon);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionMemberPreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        WidgetChatListAdapterItemTextBinding widgetChatListAdapterItemTextBindingM8409b = WidgetChatListAdapterItemTextBinding.m8409b(LayoutInflater.from(getContext()), this, true);
        C12238m.checkNotNullExpressionValue(widgetChatListAdapterItemTextBindingM8409b, "WidgetChatListAdapterIte…rom(context), this, true)");
        this.binding = widgetChatListAdapterItemTextBindingM8409b;
        this.defaultColor = C12083g.lazy(new GuildRoleSubscriptionMemberPreview$defaultColor$2(this));
        if (isInEditMode()) {
            widgetChatListAdapterItemTextBindingM8409b.f16319c.setImageResource(C5419R.drawable.img_guild_role_subscription_default_avatar_40dp);
        } else {
            widgetChatListAdapterItemTextBindingM8409b.f16319c.setActualImageResource(C5419R.drawable.img_guild_role_subscription_default_avatar_40dp);
        }
        TextView textView = widgetChatListAdapterItemTextBindingM8409b.f16322f;
        C12238m.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemTextTag");
        textView.setVisibility(8);
        widgetChatListAdapterItemTextBindingM8409b.f16320d.setText(C5419R.string.wumpus);
        widgetChatListAdapterItemTextBindingM8409b.f16323g.setText(C5419R.string.sample_time_pm);
        widgetChatListAdapterItemTextBindingM8409b.f16318b.setText(C5419R.string.f14711xdb419408);
        setBackgroundColor(ColorCompat.getThemedColor(this, C5419R.attr.colorBackgroundPrimary));
        widgetChatListAdapterItemTextBindingM8409b.f16324h.setPadding(0, 0, 0, 0);
        widgetChatListAdapterItemTextBindingM8409b.f16321e.setRole((GuildRole) null, (Long) null);
    }

    public /* synthetic */ GuildRoleSubscriptionMemberPreview(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionMemberPreview(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C12238m.checkNotNullParameter(context, "context");
        WidgetChatListAdapterItemTextBinding widgetChatListAdapterItemTextBindingM8409b = WidgetChatListAdapterItemTextBinding.m8409b(LayoutInflater.from(getContext()), this, true);
        C12238m.checkNotNullExpressionValue(widgetChatListAdapterItemTextBindingM8409b, "WidgetChatListAdapterIte…rom(context), this, true)");
        this.binding = widgetChatListAdapterItemTextBindingM8409b;
        this.defaultColor = C12083g.lazy(new GuildRoleSubscriptionMemberPreview$defaultColor$2(this));
        if (isInEditMode()) {
            widgetChatListAdapterItemTextBindingM8409b.f16319c.setImageResource(C5419R.drawable.img_guild_role_subscription_default_avatar_40dp);
        } else {
            widgetChatListAdapterItemTextBindingM8409b.f16319c.setActualImageResource(C5419R.drawable.img_guild_role_subscription_default_avatar_40dp);
        }
        TextView textView = widgetChatListAdapterItemTextBindingM8409b.f16322f;
        C12238m.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemTextTag");
        textView.setVisibility(8);
        widgetChatListAdapterItemTextBindingM8409b.f16320d.setText(C5419R.string.wumpus);
        widgetChatListAdapterItemTextBindingM8409b.f16323g.setText(C5419R.string.sample_time_pm);
        widgetChatListAdapterItemTextBindingM8409b.f16318b.setText(C5419R.string.f14711xdb419408);
        setBackgroundColor(ColorCompat.getThemedColor(this, C5419R.attr.colorBackgroundPrimary));
        widgetChatListAdapterItemTextBindingM8409b.f16324h.setPadding(0, 0, 0, 0);
        widgetChatListAdapterItemTextBindingM8409b.f16321e.setRole((GuildRole) null, (Long) null);
    }

    public /* synthetic */ GuildRoleSubscriptionMemberPreview(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
