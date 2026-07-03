package com.discord.widgets.servers;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.discord.C5419R;
import com.discord.databinding.NotificationMuteSettingsViewBinding;
import com.discord.utilities.time.TimeUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
            C12238m.checkNotNullParameter(charSequence, "rawMuteText");
            C12238m.checkNotNullParameter(charSequence3, "rawMutedStatusText");
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
            C12238m.checkNotNullParameter(rawMuteText, "rawMuteText");
            C12238m.checkNotNullParameter(rawMutedStatusText, "rawMutedStatusText");
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
            return this.isMuted == viewState.isMuted && C12238m.areEqual(this.muteEndTime, viewState.muteEndTime) && C12238m.areEqual(this.rawMuteText, viewState.rawMuteText) && C12238m.areEqual(this.rawUnmuteText, viewState.rawUnmuteText) && C12238m.areEqual(this.rawMutedStatusText, viewState.rawMutedStatusText) && this.rawMutedUntilStatusResId == viewState.rawMutedUntilStatusResId && C12238m.areEqual(this.muteDescriptionText, viewState.muteDescriptionText);
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
            StringBuilder sbM833U = C1643a.m833U("ViewState(isMuted=");
            sbM833U.append(this.isMuted);
            sbM833U.append(", muteEndTime=");
            sbM833U.append(this.muteEndTime);
            sbM833U.append(", rawMuteText=");
            sbM833U.append(this.rawMuteText);
            sbM833U.append(", rawUnmuteText=");
            sbM833U.append(this.rawUnmuteText);
            sbM833U.append(", rawMutedStatusText=");
            sbM833U.append(this.rawMutedStatusText);
            sbM833U.append(", rawMutedUntilStatusResId=");
            sbM833U.append(this.rawMutedUntilStatusResId);
            sbM833U.append(", muteDescriptionText=");
            return C1643a.m817E(sbM833U, this.muteDescriptionText, ")");
        }

        public /* synthetic */ ViewState(boolean z2, String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(z2, str, charSequence, charSequence2, charSequence3, i, (i2 & 64) != 0 ? null : charSequence4);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationMuteSettingsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(C5419R.layout.notification_mute_settings_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i = C5419R.id.notification_mute_settings_mute_item;
        TextView textView = (TextView) viewInflate.findViewById(C5419R.id.notification_mute_settings_mute_item);
        if (textView != null) {
            i = C5419R.id.notification_mute_settings_mute_item_description;
            TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.notification_mute_settings_mute_item_description);
            if (textView2 != null) {
                i = C5419R.id.notification_mute_settings_mute_item_status;
                TextView textView3 = (TextView) viewInflate.findViewById(C5419R.id.notification_mute_settings_mute_item_status);
                if (textView3 != null) {
                    NotificationMuteSettingsViewBinding notificationMuteSettingsViewBinding = new NotificationMuteSettingsViewBinding((LinearLayout) viewInflate, textView, textView2, textView3);
                    C12238m.checkNotNullExpressionValue(notificationMuteSettingsViewBinding, "NotificationMuteSettings…rom(context), this, true)");
                    this.binding = notificationMuteSettingsViewBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void updateView(ViewState viewState, final Function0<Unit> onMute, final Function0<Unit> onUnmute) {
        CharSequence rawMutedStatusText;
        C12238m.checkNotNullParameter(viewState, "viewState");
        C12238m.checkNotNullParameter(onMute, "onMute");
        C12238m.checkNotNullParameter(onUnmute, "onUnmute");
        CharSequence rawMuteText = viewState.getRawMuteText();
        final boolean zIsMuted = viewState.isMuted();
        String muteEndTime = viewState.getMuteEndTime();
        CharSequence muteDescriptionText = viewState.getMuteDescriptionText();
        if (zIsMuted) {
            rawMuteText = viewState.getRawUnmuteText();
        }
        TextView textView = this.binding.f15194b;
        C12238m.checkNotNullExpressionValue(textView, "binding.notificationMuteSettingsMuteItem");
        textView.setText(rawMuteText);
        this.binding.f15194b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.NotificationMuteSettingsView.updateView.1
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
            C12238m.checkNotNullExpressionValue(context, "context");
            rawMutedStatusText = C1107b.m212d(this, viewState.getRawMutedUntilStatusResId(), new Object[]{TimeUtils.renderUtcDateTime$default(timeUtils, muteEndTime, context, null, 2, 3, 4, null)}, new NotificationMuteSettingsView$updateView$rawMuteStatusText$1(this));
        } else {
            rawMutedStatusText = viewState.getRawMutedStatusText();
        }
        TextView textView2 = this.binding.f15196d;
        C12238m.checkNotNullExpressionValue(textView2, "binding.notificationMuteSettingsMuteItemStatus");
        textView2.setText(rawMutedStatusText);
        TextView textView3 = this.binding.f15196d;
        C12238m.checkNotNullExpressionValue(textView3, "binding.notificationMuteSettingsMuteItemStatus");
        textView3.setVisibility(zIsMuted ? 0 : 8);
        TextView textView4 = this.binding.f15195c;
        C12238m.checkNotNullExpressionValue(textView4, "binding.notificationMute…ttingsMuteItemDescription");
        textView4.setVisibility(muteDescriptionText != null ? 0 : 8);
        TextView textView5 = this.binding.f15195c;
        C12238m.checkNotNullExpressionValue(textView5, "binding.notificationMute…ttingsMuteItemDescription");
        textView5.setText(muteDescriptionText);
    }
}
