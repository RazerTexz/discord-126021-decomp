package com.discord.widgets.settings.profile;

import androidx.core.app.NotificationCompat;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditUserOrGuildMemberProfile$configureUI$3<R> implements Func0<Boolean> {
    public final /* synthetic */ SettingsUserProfileViewModel$ViewState $viewState;
    public final /* synthetic */ WidgetEditUserOrGuildMemberProfile this$0;

    public WidgetEditUserOrGuildMemberProfile$configureUI$3(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile, SettingsUserProfileViewModel$ViewState settingsUserProfileViewModel$ViewState) {
        this.this$0 = widgetEditUserOrGuildMemberProfile;
        this.$viewState = settingsUserProfileViewModel$ViewState;
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public final Boolean call() {
        return Boolean.valueOf(WidgetEditUserOrGuildMemberProfile.access$handleBackPressed(this.this$0, (SettingsUserProfileViewModel$ViewState$Loaded) this.$viewState));
    }
}
