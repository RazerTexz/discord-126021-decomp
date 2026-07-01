package com.discord.widgets.servers;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.NotificationMuteSettingsViewBinding;
import com.discord.utilities.time.TimeUtils;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: NotificationMuteSettingsView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationMuteSettingsView extends LinearLayout {
    private final NotificationMuteSettingsViewBinding binding;

    /* JADX INFO: compiled from: NotificationMuteSettingsView.kt */
    public static final /* data */ class ViewState {
        private final boolean isMuted;
        private final CharSequence muteDescriptionText;
        private final String muteEndTime;
        private final CharSequence rawMuteText;
        private final CharSequence rawMutedStatusText;
        private final int rawMutedUntilStatusResId;
        private final CharSequence rawUnmuteText;

        public ViewState(boolean z2, String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, @StringRes int i, CharSequence charSequence4) {
            Intrinsics3.checkNotNullParameter(charSequence, "rawMuteText");
            Intrinsics3.checkNotNullParameter(charSequence3, "rawMutedStatusText");
            this.isMuted = z2;
            this.muteEndTime = str;
            this.rawMuteText = charSequence;
            this.rawUnmuteText = charSequence2;
            this.rawMutedStatusText = charSequence3;
            this.rawMutedUntilStatusResId = i;
            this.muteDescriptionText = charSequence4;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z2, String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z2 = viewState.isMuted;
            }
            if ((i2 & 2) != 0) {
                str = viewState.muteEndTime;
            }
            String str2 = str;
            if ((i2 & 4) != 0) {
                charSequence = viewState.rawMuteText;
            }
            CharSequence charSequence5 = charSequence;
            if ((i2 & 8) != 0) {
                charSequence2 = viewState.rawUnmuteText;
            }
            CharSequence charSequence6 = charSequence2;
            if ((i2 & 16) != 0) {
                charSequence3 = viewState.rawMutedStatusText;
            }
            CharSequence charSequence7 = charSequence3;
            if ((i2 & 32) != 0) {
                i = viewState.rawMutedUntilStatusResId;
            }
            int i3 = i;
            if ((i2 & 64) != 0) {
                charSequence4 = viewState.muteDescriptionText;
            }
            return viewState.copy(z2, str2, charSequence5, charSequence6, charSequence7, i3, charSequence4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsMuted() {
            return this.isMuted;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMuteEndTime() {
            return this.muteEndTime;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final CharSequence getRawMuteText() {
            return this.rawMuteText;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final CharSequence getRawUnmuteText() {
            return this.rawUnmuteText;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final CharSequence getRawMutedStatusText() {
            return this.rawMutedStatusText;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final int getRawMutedUntilStatusResId() {
            return this.rawMutedUntilStatusResId;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final CharSequence getMuteDescriptionText() {
            return this.muteDescriptionText;
        }

        public final ViewState copy(boolean isMuted, String muteEndTime, CharSequence rawMuteText, CharSequence rawUnmuteText, CharSequence rawMutedStatusText, @StringRes int rawMutedUntilStatusResId, CharSequence muteDescriptionText) {
            Intrinsics3.checkNotNullParameter(rawMuteText, "rawMuteText");
            Intrinsics3.checkNotNullParameter(rawMutedStatusText, "rawMutedStatusText");
            return new ViewState(isMuted, muteEndTime, rawMuteText, rawUnmuteText, rawMutedStatusText, rawMutedUntilStatusResId, muteDescriptionText);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isMuted == viewState.isMuted && Intrinsics3.areEqual(this.muteEndTime, viewState.muteEndTime) && Intrinsics3.areEqual(this.rawMuteText, viewState.rawMuteText) && Intrinsics3.areEqual(this.rawUnmuteText, viewState.rawUnmuteText) && Intrinsics3.areEqual(this.rawMutedStatusText, viewState.rawMutedStatusText) && this.rawMutedUntilStatusResId == viewState.rawMutedUntilStatusResId && Intrinsics3.areEqual(this.muteDescriptionText, viewState.muteDescriptionText);
        }

        public final CharSequence getMuteDescriptionText() {
            return this.muteDescriptionText;
        }

        public final String getMuteEndTime() {
            return this.muteEndTime;
        }

        public final CharSequence getRawMuteText() {
            return this.rawMuteText;
        }

        public final CharSequence getRawMutedStatusText() {
            return this.rawMutedStatusText;
        }

        public final int getRawMutedUntilStatusResId() {
            return this.rawMutedUntilStatusResId;
        }

        public final CharSequence getRawUnmuteText() {
            return this.rawUnmuteText;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r0v15 */
        public int hashCode() {
            boolean z2 = this.isMuted;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            String str = this.muteEndTime;
            int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            CharSequence charSequence = this.rawMuteText;
            int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
            CharSequence charSequence2 = this.rawUnmuteText;
            int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
            CharSequence charSequence3 = this.rawMutedStatusText;
            int iHashCode4 = (((iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31) + this.rawMutedUntilStatusResId) * 31;
            CharSequence charSequence4 = this.muteDescriptionText;
            return iHashCode4 + (charSequence4 != null ? charSequence4.hashCode() : 0);
        }

        public final boolean isMuted() {
            return this.isMuted;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(isMuted=");
            sbU.append(this.isMuted);
            sbU.append(", muteEndTime=");
            sbU.append(this.muteEndTime);
            sbU.append(", rawMuteText=");
            sbU.append(this.rawMuteText);
            sbU.append(", rawUnmuteText=");
            sbU.append(this.rawUnmuteText);
            sbU.append(", rawMutedStatusText=");
            sbU.append(this.rawMutedStatusText);
            sbU.append(", rawMutedUntilStatusResId=");
            sbU.append(this.rawMutedUntilStatusResId);
            sbU.append(", muteDescriptionText=");
            return outline.E(sbU, this.muteDescriptionText, ")");
        }

        public /* synthetic */ ViewState(boolean z2, String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(z2, str, charSequence, charSequence2, charSequence3, i, (i2 & 64) != 0 ? null : charSequence4);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationMuteSettingsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.notification_mute_settings_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.notification_mute_settings_mute_item;
        TextView textView = (TextView) viewInflate.findViewById(R.id.notification_mute_settings_mute_item);
        if (textView != null) {
            i = R.id.notification_mute_settings_mute_item_description;
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.notification_mute_settings_mute_item_description);
            if (textView2 != null) {
                i = R.id.notification_mute_settings_mute_item_status;
                TextView textView3 = (TextView) viewInflate.findViewById(R.id.notification_mute_settings_mute_item_status);
                if (textView3 != null) {
                    NotificationMuteSettingsViewBinding notificationMuteSettingsViewBinding = new NotificationMuteSettingsViewBinding((LinearLayout) viewInflate, textView, textView2, textView3);
                    Intrinsics3.checkNotNullExpressionValue(notificationMuteSettingsViewBinding, "NotificationMuteSettings…rom(context), this, true)");
                    this.binding = notificationMuteSettingsViewBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void updateView(ViewState viewState, final Function0<Unit> onMute, final Function0<Unit> onUnmute) {
        CharSequence rawMutedStatusText;
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        Intrinsics3.checkNotNullParameter(onMute, "onMute");
        Intrinsics3.checkNotNullParameter(onUnmute, "onUnmute");
        CharSequence rawMuteText = viewState.getRawMuteText();
        final boolean zIsMuted = viewState.isMuted();
        String muteEndTime = viewState.getMuteEndTime();
        CharSequence muteDescriptionText = viewState.getMuteDescriptionText();
        if (zIsMuted) {
            rawMuteText = viewState.getRawUnmuteText();
        }
        TextView textView = this.binding.f2131b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.notificationMuteSettingsMuteItem");
        textView.setText(rawMuteText);
        this.binding.f2131b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.NotificationMuteSettingsView.updateView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (zIsMuted) {
                    onUnmute.invoke();
                } else {
                    onMute.invoke();
                }
            }
        });
        if (!zIsMuted) {
            rawMutedStatusText = "";
        } else if (muteEndTime != null) {
            TimeUtils timeUtils = TimeUtils.INSTANCE;
            Context context = getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            rawMutedStatusText = FormatUtils.d(this, viewState.getRawMutedUntilStatusResId(), new Object[]{TimeUtils.renderUtcDateTime$default(timeUtils, muteEndTime, context, null, 2, 3, 4, null)}, new NotificationMuteSettingsView2(this));
        } else {
            rawMutedStatusText = viewState.getRawMutedStatusText();
        }
        TextView textView2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.notificationMuteSettingsMuteItemStatus");
        textView2.setText(rawMutedStatusText);
        TextView textView3 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.notificationMuteSettingsMuteItemStatus");
        textView3.setVisibility(zIsMuted ? 0 : 8);
        TextView textView4 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.notificationMute…ttingsMuteItemDescription");
        textView4.setVisibility(muteDescriptionText != null ? 0 : 8);
        TextView textView5 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.notificationMute…ttingsMuteItemDescription");
        textView5.setText(muteDescriptionText);
    }
}
