package com.discord.widgets.settings.profile;

import com.discord.api.user.User;
import com.discord.models.user.MeUser;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: EditUserOrGuildMemberProfileViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsUserProfileViewModel$saveUserChanges$2 extends o implements Function1<User, Unit> {
    public final /* synthetic */ MeUser $meUser;
    public final /* synthetic */ SettingsUserProfileViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ SettingsUserProfileViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsUserProfileViewModel$saveUserChanges$2(SettingsUserProfileViewModel settingsUserProfileViewModel, MeUser meUser, SettingsUserProfileViewModel$ViewState$Loaded settingsUserProfileViewModel$ViewState$Loaded) {
        super(1);
        this.this$0 = settingsUserProfileViewModel;
        this.$meUser = meUser;
        this.$viewState = settingsUserProfileViewModel$ViewState$Loaded;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(User user) {
        invoke2(user);
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(User user) {
        m.checkNotNullParameter(user, "apiUser");
        SettingsUserProfileViewModel.access$getStoreUserProfile$p(this.this$0).updateUser(user);
        SettingsUserProfileViewModel.access$updateViewState(this.this$0, SettingsUserProfileViewModel$ViewState$Loaded.copy$default(this.$viewState, MeUser.Companion.merge(this.$meUser, user), null, null, null, null, null, null, null, null, null, false, false, 3982, null));
        SettingsUserProfileViewModel.access$getEventSubject$p(this.this$0).k.onNext((T) SettingsUserProfileViewModel$Event$UserUpdateRequestCompleted.INSTANCE);
    }
}
