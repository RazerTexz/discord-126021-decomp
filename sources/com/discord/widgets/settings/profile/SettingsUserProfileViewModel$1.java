package com.discord.widgets.settings.profile;

import com.discord.models.user.MeUser;
import com.discord.stores.StoreUserProfile;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: EditUserOrGuildMemberProfileViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsUserProfileViewModel$1 extends o implements Function1<MeUser, Unit> {
    public final /* synthetic */ SettingsUserProfileViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsUserProfileViewModel$1(SettingsUserProfileViewModel settingsUserProfileViewModel) {
        super(1);
        this.this$0 = settingsUserProfileViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MeUser meUser) {
        invoke2(meUser);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MeUser meUser) {
        StoreUserProfile.fetchProfile$default(SettingsUserProfileViewModel.access$getStoreUserProfile$p(this.this$0), meUser.getId(), SettingsUserProfileViewModel.access$getGuildId$p(this.this$0), false, null, 12, null);
    }
}
