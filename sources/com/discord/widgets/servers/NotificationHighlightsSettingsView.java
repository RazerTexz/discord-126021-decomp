package com.discord.widgets.servers;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.NotificationHighlightsSettingsViewBinding;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.views.CheckedSetting;
import com.google.android.material.card.MaterialCardView;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: NotificationHighlightsSettingsView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationHighlightsSettingsView extends LinearLayout {
    private final NotificationHighlightsSettingsViewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationHighlightsSettingsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.notification_highlights_settings_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R$id.highlights_learn_more;
        TextView textView = (TextView) viewInflate.findViewById(R$id.highlights_learn_more);
        if (textView != null) {
            i = R$id.highlights_switch;
            CheckedSetting checkedSetting = (CheckedSetting) viewInflate.findViewById(R$id.highlights_switch);
            if (checkedSetting != null) {
                i = R$id.highlights_warning;
                MaterialCardView materialCardView = (MaterialCardView) viewInflate.findViewById(R$id.highlights_warning);
                if (materialCardView != null) {
                    NotificationHighlightsSettingsViewBinding notificationHighlightsSettingsViewBinding = new NotificationHighlightsSettingsViewBinding((LinearLayout) viewInflate, textView, checkedSetting, materialCardView);
                    m.checkNotNullExpressionValue(notificationHighlightsSettingsViewBinding, "NotificationHighlightsSe…rom(context), this, true)");
                    this.binding = notificationHighlightsSettingsViewBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ NotificationHighlightsSettingsViewBinding access$getBinding$p(NotificationHighlightsSettingsView notificationHighlightsSettingsView) {
        return notificationHighlightsSettingsView.binding;
    }

    public final void updateView(NotificationHighlightsSettingsView$ViewState viewState, Function1<? super Integer, Unit> onToggled) {
        m.checkNotNullParameter(viewState, "viewState");
        m.checkNotNullParameter(onToggled, "onToggled");
        boolean zIsMuted = viewState.isMuted();
        int notifyHighlights = viewState.getNotifyHighlights();
        boolean serverTooLarge = viewState.getServerTooLarge();
        this.binding.c.setLabelTagText(2131887026);
        this.binding.c.setLabelTagVisibility(true);
        CheckedSetting checkedSetting = this.binding.c;
        m.checkNotNullExpressionValue(checkedSetting, "binding.highlightsSwitch");
        checkedSetting.setChecked((notifyHighlights == ModelNotificationSettings.HIGHLIGHTS_DISABLED || zIsMuted) ? false : true);
        if (zIsMuted) {
            CheckedSetting.d(this.binding.c, null, 1);
        } else {
            this.binding.c.e(new NotificationHighlightsSettingsView$updateView$1(this, notifyHighlights, onToggled));
        }
        this.binding.f2130b.setOnClickListener(new NotificationHighlightsSettingsView$updateView$2(this));
        MaterialCardView materialCardView = this.binding.d;
        m.checkNotNullExpressionValue(materialCardView, "binding.highlightsWarning");
        materialCardView.setVisibility((!serverTooLarge || zIsMuted || notifyHighlights == ModelNotificationSettings.HIGHLIGHTS_DISABLED) ? false : true ? 0 : 8);
    }
}
