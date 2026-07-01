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
import b.a.i.ViewCallEventsButtonBinding;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities5;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: CallEventsButtonView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CallEventsButtonView extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final ViewCallEventsButtonBinding binding;

    /* JADX INFO: compiled from: CallEventsButtonView.kt */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ FragmentManager j;
        public final /* synthetic */ long k;
        public final /* synthetic */ long l;

        public a(FragmentManager fragmentManager, long j, long j2) {
            this.j = fragmentManager;
            this.k = j;
            this.l = j2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventListBottomSheet.INSTANCE.show(this.j, this.k, Long.valueOf(this.l));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallEventsButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.view_call_events_button, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.icon;
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.icon);
        if (imageView != null) {
            i = R.id.text;
            TextView textView = (TextView) viewInflate.findViewById(R.id.text);
            if (textView != null) {
                ViewCallEventsButtonBinding viewCallEventsButtonBinding = new ViewCallEventsButtonBinding((ConstraintLayout) viewInflate, imageView, textView);
                Intrinsics3.checkNotNullExpressionValue(viewCallEventsButtonBinding, "ViewCallEventsButtonBind…rom(context), this, true)");
                this.binding = viewCallEventsButtonBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    private final void setContentColor(int color) {
        this.binding.c.setTextColor(color);
        ImageView imageView = this.binding.f75b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.icon");
        ColorCompat2.tintWithColor(imageView, color);
    }

    public final void a(FragmentManager fragmentManager, long guildId, long channelId, List<GuildScheduledEvent> events) {
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(events, "events");
        this.binding.a.setOnClickListener(new a(fragmentManager, guildId, channelId));
        boolean zHasLiveEvent = GuildScheduledEventUtilities5.hasLiveEvent(events);
        if (zHasLiveEvent) {
            TextView textView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.text");
            textView.setText(getContext().getString(R.string.live_event));
            setContentColor(ContextCompat.getColor(getContext(), R.color.status_green_560));
            return;
        }
        if (zHasLiveEvent) {
            return;
        }
        int size = events.size();
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        CharSequence i18nPluralString = StringResourceUtils.getI18nPluralString(context, R.plurals.guild_events_plural_number, size, Integer.valueOf(size));
        TextView textView2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.text");
        Context context2 = getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        textView2.setText(FormatUtils.b(context2, R.string.guild_events_plural, new Object[]{i18nPluralString}, (4 & 4) != 0 ? FormatUtils.b.j : null));
        setContentColor(ContextCompat.getColor(getContext(), R.color.white));
    }
}
