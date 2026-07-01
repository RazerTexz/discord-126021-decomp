package com.discord.widgets.settings.profile;

import com.discord.api.user.UserProfile;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserProfile;
import com.discord.widgets.settings.profile.EditProfileBannerSheetViewModel;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.settings.profile.EditProfileBannerSheetViewModel$Companion$observeStoreState$1, reason: use source file name */
/* JADX INFO: compiled from: EditProfileBannerSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EditProfileBannerSheetViewModel2 extends Lambda implements Function0<EditProfileBannerSheetViewModel.StoreState> {
    public final /* synthetic */ StoreUser $storeUser;
    public final /* synthetic */ StoreUserProfile $storeUserProfile;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditProfileBannerSheetViewModel2(StoreUser storeUser, StoreUserProfile storeUserProfile) {
        super(0);
        this.$storeUser = storeUser;
        this.$storeUserProfile = storeUserProfile;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final EditProfileBannerSheetViewModel.StoreState invoke() {
        MeUser meSnapshot = this.$storeUser.getMeSnapshot();
        UserProfile userProfile = this.$storeUserProfile.getUserProfile(meSnapshot.getId());
        return new EditProfileBannerSheetViewModel.StoreState(MeUser.INSTANCE.merge(meSnapshot, userProfile.getUser()), userProfile);
    }
}
