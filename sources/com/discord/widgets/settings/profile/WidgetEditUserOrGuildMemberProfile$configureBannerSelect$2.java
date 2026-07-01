package com.discord.widgets.settings.profile;

import android.content.Context;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2 extends o implements Function0<Unit> {
    public final /* synthetic */ SettingsUserProfileViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ WidgetEditUserOrGuildMemberProfile this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile, SettingsUserProfileViewModel$ViewState$Loaded settingsUserProfileViewModel$ViewState$Loaded) {
        super(0);
        this.this$0 = widgetEditUserOrGuildMemberProfile;
        this.$viewState = settingsUserProfileViewModel$ViewState$Loaded;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Observable observableL = WidgetEditUserOrGuildMemberProfile.access$getAvatarRepresentativeColorHexSubject$p(this.this$0).Z(1).L();
        m.checkNotNullExpressionValue(observableL, "avatarRepresentativeColo…  .onBackpressureLatest()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableL, this.this$0, null, 2, null), this.this$0.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1(this), 62, (Object) null);
    }
}
