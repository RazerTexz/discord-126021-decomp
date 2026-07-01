package com.discord.widgets.settings.profile;

import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: EditUserOrGuildMemberProfileViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsUserProfileViewModel$saveGuildMemberChanges$1 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ SettingsUserProfileViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsUserProfileViewModel$saveGuildMemberChanges$1(SettingsUserProfileViewModel settingsUserProfileViewModel) {
        super(1);
        this.this$0 = settingsUserProfileViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        SettingsUserProfileViewModel.access$getEventSubject$p(this.this$0).k.onNext((T) SettingsUserProfileViewModel$Event$UserUpdateRequestCompleted.INSTANCE);
    }
}
