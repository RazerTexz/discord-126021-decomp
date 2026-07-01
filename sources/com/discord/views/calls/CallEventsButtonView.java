package com.discord.views.calls;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import b.a.i.a2;
import b.a.k.b;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilitiesKt;
import com.discord.utilities.resources.StringResourceUtilsKt;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: CallEventsButtonView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CallEventsButtonView extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final a2 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallEventsButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.view_call_events_button, (ViewGroup) this, false);
        addView(viewInflate);
        int i = 2131364017;
        ImageView imageView = (ImageView) viewInflate.findViewById(2131364017);
        if (imageView != null) {
            i = 2131365767;
            TextView textView = (TextView) viewInflate.findViewById(2131365767);
            if (textView != null) {
                a2 a2Var = new a2((ConstraintLayout) viewInflate, imageView, textView);
                m.checkNotNullExpressionValue(a2Var, "ViewCallEventsButtonBind…rom(context), this, true)");
                this.binding = a2Var;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    private final void setContentColor(int color) {
        this.binding.c.setTextColor(color);
        ImageView imageView = this.binding.f75b;
        m.checkNotNullExpressionValue(imageView, "binding.icon");
        ColorCompatKt.tintWithColor(imageView, color);
    }

    public final void a(FragmentManager fragmentManager, long guildId, long channelId, List<GuildScheduledEvent> events) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(events, "events");
        this.binding.a.setOnClickListener(new CallEventsButtonView$a(fragmentManager, guildId, channelId));
        boolean zHasLiveEvent = GuildScheduledEventUtilitiesKt.hasLiveEvent(events);
        if (zHasLiveEvent) {
            TextView textView = this.binding.c;
            m.checkNotNullExpressionValue(textView, "binding.text");
            textView.setText(getContext().getString(2131892561));
            setContentColor(ContextCompat.getColor(getContext(), 2131100303));
            return;
        }
        if (zHasLiveEvent) {
            return;
        }
        int size = events.size();
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        CharSequence i18nPluralString = StringResourceUtilsKt.getI18nPluralString(context, R$plurals.guild_events_plural_number, size, Integer.valueOf(size));
        TextView textView2 = this.binding.c;
        m.checkNotNullExpressionValue(textView2, "binding.text");
        Context context2 = getContext();
        m.checkNotNullExpressionValue(context2, "context");
        textView2.setText(b.h(context2, 2131890145, new Object[]{i18nPluralString}, null, 4));
        setContentColor(ContextCompat.getColor(getContext(), 2131100487));
    }
}
