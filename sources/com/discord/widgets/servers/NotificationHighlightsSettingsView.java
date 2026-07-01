package com.discord.widgets.servers;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.d.AppHelpDesk;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.NotificationHighlightsSettingsViewBinding;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.utilities.uri.UriHandler;
import com.discord.views.CheckedSetting;
import com.google.android.material.card.MaterialCardView;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: NotificationHighlightsSettingsView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationHighlightsSettingsView extends LinearLayout {
    private final NotificationHighlightsSettingsViewBinding binding;

    /* JADX INFO: compiled from: NotificationHighlightsSettingsView.kt */
    public static final /* data */ class ViewState {
        private final boolean isMuted;
        private final int notifyHighlights;
        private final boolean serverTooLarge;

        public ViewState(boolean z2, int i, boolean z3) {
            this.isMuted = z2;
            this.notifyHighlights = i;
            this.serverTooLarge = z3;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z2, int i, boolean z3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z2 = viewState.isMuted;
            }
            if ((i2 & 2) != 0) {
                i = viewState.notifyHighlights;
            }
            if ((i2 & 4) != 0) {
                z3 = viewState.serverTooLarge;
            }
            return viewState.copy(z2, i, z3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsMuted() {
            return this.isMuted;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getNotifyHighlights() {
            return this.notifyHighlights;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getServerTooLarge() {
            return this.serverTooLarge;
        }

        public final ViewState copy(boolean isMuted, int notifyHighlights, boolean serverTooLarge) {
            return new ViewState(isMuted, notifyHighlights, serverTooLarge);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isMuted == viewState.isMuted && this.notifyHighlights == viewState.notifyHighlights && this.serverTooLarge == viewState.serverTooLarge;
        }

        public final int getNotifyHighlights() {
            return this.notifyHighlights;
        }

        public final boolean getServerTooLarge() {
            return this.serverTooLarge;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        public int hashCode() {
            boolean z2 = this.isMuted;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = ((r0 * 31) + this.notifyHighlights) * 31;
            boolean z3 = this.serverTooLarge;
            return i + (z3 ? 1 : z3);
        }

        public final boolean isMuted() {
            return this.isMuted;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(isMuted=");
            sbU.append(this.isMuted);
            sbU.append(", notifyHighlights=");
            sbU.append(this.notifyHighlights);
            sbU.append(", serverTooLarge=");
            return outline.O(sbU, this.serverTooLarge, ")");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationHighlightsSettingsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.notification_highlights_settings_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.highlights_learn_more;
        TextView textView = (TextView) viewInflate.findViewById(R.id.highlights_learn_more);
        if (textView != null) {
            i = R.id.highlights_switch;
            CheckedSetting checkedSetting = (CheckedSetting) viewInflate.findViewById(R.id.highlights_switch);
            if (checkedSetting != null) {
                i = R.id.highlights_warning;
                MaterialCardView materialCardView = (MaterialCardView) viewInflate.findViewById(R.id.highlights_warning);
                if (materialCardView != null) {
                    NotificationHighlightsSettingsViewBinding notificationHighlightsSettingsViewBinding = new NotificationHighlightsSettingsViewBinding((LinearLayout) viewInflate, textView, checkedSetting, materialCardView);
                    Intrinsics3.checkNotNullExpressionValue(notificationHighlightsSettingsViewBinding, "NotificationHighlightsSe…rom(context), this, true)");
                    this.binding = notificationHighlightsSettingsViewBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void updateView(ViewState viewState, final Function1<? super Integer, Unit> onToggled) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        Intrinsics3.checkNotNullParameter(onToggled, "onToggled");
        boolean zIsMuted = viewState.isMuted();
        final int notifyHighlights = viewState.getNotifyHighlights();
        boolean serverTooLarge = viewState.getServerTooLarge();
        this.binding.c.setLabelTagText(R.string.beta);
        this.binding.c.setLabelTagVisibility(true);
        CheckedSetting checkedSetting = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.highlightsSwitch");
        checkedSetting.setChecked((notifyHighlights == ModelNotificationSettings.HIGHLIGHTS_DISABLED || zIsMuted) ? false : true);
        if (zIsMuted) {
            CheckedSetting.d(this.binding.c, null, 1);
        } else {
            this.binding.c.e(new View.OnClickListener() { // from class: com.discord.widgets.servers.NotificationHighlightsSettingsView.updateView.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NotificationHighlightsSettingsView.this.binding.c.toggle();
                    int i = notifyHighlights;
                    int i2 = ModelNotificationSettings.HIGHLIGHTS_DISABLED;
                    if (i == i2) {
                        i2 = ModelNotificationSettings.HIGHLIGHTS_ENABLED;
                    }
                    onToggled.invoke(Integer.valueOf(i2));
                }
            });
        }
        this.binding.f2130b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.NotificationHighlightsSettingsView.updateView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UriHandler.handle$default(UriHandler.INSTANCE, outline.I(NotificationHighlightsSettingsView.this.binding.f2130b, "binding.highlightsLearnMore", "binding.highlightsLearnMore.context"), AppHelpDesk.a.a(5304469213079L, null), false, false, null, 28, null);
            }
        });
        MaterialCardView materialCardView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(materialCardView, "binding.highlightsWarning");
        materialCardView.setVisibility((!serverTooLarge || zIsMuted || notifyHighlights == ModelNotificationSettings.HIGHLIGHTS_DISABLED) ? false : true ? 0 : 8);
    }
}
