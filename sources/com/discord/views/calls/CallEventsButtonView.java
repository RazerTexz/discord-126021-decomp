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
import com.discord.C5419R;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilitiesKt;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet;
import java.util.List;
import p007b.p008a.p025i.C0914a2;
import p007b.p008a.p027k.C1107b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: CallEventsButtonView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CallEventsButtonView extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final C0914a2 binding;

    /* JADX INFO: renamed from: com.discord.views.calls.CallEventsButtonView$a */
    /* JADX INFO: compiled from: CallEventsButtonView.kt */
    public static final class ViewOnClickListenerC7100a implements View.OnClickListener {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ FragmentManager f19207j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ long f19208k;

        /* JADX INFO: renamed from: l */
        public final /* synthetic */ long f19209l;

        public ViewOnClickListenerC7100a(FragmentManager fragmentManager, long j, long j2) {
            this.f19207j = fragmentManager;
            this.f19208k = j;
            this.f19209l = j2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventListBottomSheet.INSTANCE.show(this.f19207j, this.f19208k, Long.valueOf(this.f19209l));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallEventsButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(C5419R.layout.view_call_events_button, (ViewGroup) this, false);
        addView(viewInflate);
        int i = C5419R.id.icon;
        ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.icon);
        if (imageView != null) {
            i = C5419R.id.text;
            TextView textView = (TextView) viewInflate.findViewById(C5419R.id.text);
            if (textView != null) {
                C0914a2 c0914a2 = new C0914a2((ConstraintLayout) viewInflate, imageView, textView);
                C12238m.checkNotNullExpressionValue(c0914a2, "ViewCallEventsButtonBind…rom(context), this, true)");
                this.binding = c0914a2;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    private final void setContentColor(int color) {
        this.binding.f665c.setTextColor(color);
        ImageView imageView = this.binding.f664b;
        C12238m.checkNotNullExpressionValue(imageView, "binding.icon");
        ColorCompatKt.tintWithColor(imageView, color);
    }

    /* JADX INFO: renamed from: a */
    public final void m8573a(FragmentManager fragmentManager, long guildId, long channelId, List<GuildScheduledEvent> events) {
        C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
        C12238m.checkNotNullParameter(events, "events");
        this.binding.f663a.setOnClickListener(new ViewOnClickListenerC7100a(fragmentManager, guildId, channelId));
        boolean zHasLiveEvent = GuildScheduledEventUtilitiesKt.hasLiveEvent(events);
        if (zHasLiveEvent) {
            TextView textView = this.binding.f665c;
            C12238m.checkNotNullExpressionValue(textView, "binding.text");
            textView.setText(getContext().getString(C5419R.string.live_event));
            setContentColor(ContextCompat.getColor(getContext(), C5419R.color.status_green_560));
            return;
        }
        if (zHasLiveEvent) {
            return;
        }
        int size = events.size();
        Context context = getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        CharSequence i18nPluralString = StringResourceUtilsKt.getI18nPluralString(context, C5419R.plurals.guild_events_plural_number, size, Integer.valueOf(size));
        TextView textView2 = this.binding.f665c;
        C12238m.checkNotNullExpressionValue(textView2, "binding.text");
        Context context2 = getContext();
        C12238m.checkNotNullExpressionValue(context2, "context");
        textView2.setText(C1107b.m216h(context2, C5419R.string.guild_events_plural, new Object[]{i18nPluralString}, null, 4));
        setContentColor(ContextCompat.getColor(getContext(), C5419R.color.white));
    }
}
