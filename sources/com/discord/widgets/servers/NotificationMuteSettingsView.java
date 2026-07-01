package com.discord.widgets.servers;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.NotificationMuteSettingsViewBinding;
import com.discord.utilities.time.TimeUtils;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: NotificationMuteSettingsView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationMuteSettingsView extends LinearLayout {
    private final NotificationMuteSettingsViewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationMuteSettingsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.notification_mute_settings_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R$id.notification_mute_settings_mute_item;
        TextView textView = (TextView) viewInflate.findViewById(R$id.notification_mute_settings_mute_item);
        if (textView != null) {
            i = R$id.notification_mute_settings_mute_item_description;
            TextView textView2 = (TextView) viewInflate.findViewById(R$id.notification_mute_settings_mute_item_description);
            if (textView2 != null) {
                i = R$id.notification_mute_settings_mute_item_status;
                TextView textView3 = (TextView) viewInflate.findViewById(R$id.notification_mute_settings_mute_item_status);
                if (textView3 != null) {
                    NotificationMuteSettingsViewBinding notificationMuteSettingsViewBinding = new NotificationMuteSettingsViewBinding((LinearLayout) viewInflate, textView, textView2, textView3);
                    m.checkNotNullExpressionValue(notificationMuteSettingsViewBinding, "NotificationMuteSettings…rom(context), this, true)");
                    this.binding = notificationMuteSettingsViewBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void updateView(NotificationMuteSettingsView$ViewState viewState, Function0<Unit> onMute, Function0<Unit> onUnmute) {
        CharSequence rawMutedStatusText;
        m.checkNotNullParameter(viewState, "viewState");
        m.checkNotNullParameter(onMute, "onMute");
        m.checkNotNullParameter(onUnmute, "onUnmute");
        CharSequence rawMuteText = viewState.getRawMuteText();
        boolean zIsMuted = viewState.isMuted();
        String muteEndTime = viewState.getMuteEndTime();
        CharSequence muteDescriptionText = viewState.getMuteDescriptionText();
        if (zIsMuted) {
            rawMuteText = viewState.getRawUnmuteText();
        }
        TextView textView = this.binding.f2131b;
        m.checkNotNullExpressionValue(textView, "binding.notificationMuteSettingsMuteItem");
        textView.setText(rawMuteText);
        this.binding.f2131b.setOnClickListener(new NotificationMuteSettingsView$updateView$1(zIsMuted, onUnmute, onMute));
        if (!zIsMuted) {
            rawMutedStatusText = "";
        } else if (muteEndTime != null) {
            TimeUtils timeUtils = TimeUtils.INSTANCE;
            Context context = getContext();
            m.checkNotNullExpressionValue(context, "context");
            rawMutedStatusText = b.d(this, viewState.getRawMutedUntilStatusResId(), new Object[]{TimeUtils.renderUtcDateTime$default(timeUtils, muteEndTime, context, null, 2, 3, 4, null)}, new NotificationMuteSettingsView$updateView$rawMuteStatusText$1(this));
        } else {
            rawMutedStatusText = viewState.getRawMutedStatusText();
        }
        TextView textView2 = this.binding.d;
        m.checkNotNullExpressionValue(textView2, "binding.notificationMuteSettingsMuteItemStatus");
        textView2.setText(rawMutedStatusText);
        TextView textView3 = this.binding.d;
        m.checkNotNullExpressionValue(textView3, "binding.notificationMuteSettingsMuteItemStatus");
        textView3.setVisibility(zIsMuted ? 0 : 8);
        TextView textView4 = this.binding.c;
        m.checkNotNullExpressionValue(textView4, "binding.notificationMute…ttingsMuteItemDescription");
        textView4.setVisibility(muteDescriptionText != null ? 0 : 8);
        TextView textView5 = this.binding.c;
        m.checkNotNullExpressionValue(textView5, "binding.notificationMute…ttingsMuteItemDescription");
        textView5.setText(muteDescriptionText);
    }
}
