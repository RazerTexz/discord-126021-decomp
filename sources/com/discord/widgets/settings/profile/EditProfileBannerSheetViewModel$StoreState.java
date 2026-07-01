package com.discord.widgets.settings.profile;

import b.d.b.a.a;
import com.discord.api.user.UserProfile;
import com.discord.models.user.User;
import d0.z.d.m;

/* JADX INFO: compiled from: EditProfileBannerSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class EditProfileBannerSheetViewModel$StoreState {
    private final User user;
    private final UserProfile userProfile;

    public EditProfileBannerSheetViewModel$StoreState(User user, UserProfile userProfile) {
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(userProfile, "userProfile");
        this.user = user;
        this.userProfile = userProfile;
    }

    public static /* synthetic */ EditProfileBannerSheetViewModel$StoreState copy$default(EditProfileBannerSheetViewModel$StoreState editProfileBannerSheetViewModel$StoreState, User user, UserProfile userProfile, int i, Object obj) {
        if ((i & 1) != 0) {
            user = editProfileBannerSheetViewModel$StoreState.user;
        }
        if ((i & 2) != 0) {
            userProfile = editProfileBannerSheetViewModel$StoreState.userProfile;
        }
        return editProfileBannerSheetViewModel$StoreState.copy(user, userProfile);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final UserProfile getUserProfile() {
        return this.userProfile;
    }

    public final EditProfileBannerSheetViewModel$StoreState copy(User user, UserProfile userProfile) {
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(userProfile, "userProfile");
        return new EditProfileBannerSheetViewModel$StoreState(user, userProfile);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EditProfileBannerSheetViewModel$StoreState)) {
            return false;
        }
        EditProfileBannerSheetViewModel$StoreState editProfileBannerSheetViewModel$StoreState = (EditProfileBannerSheetViewModel$StoreState) other;
        return m.areEqual(this.user, editProfileBannerSheetViewModel$StoreState.user) && m.areEqual(this.userProfile, editProfileBannerSheetViewModel$StoreState.userProfile);
    }

    public final User getUser() {
        return this.user;
    }

    public final UserProfile getUserProfile() {
        return this.userProfile;
    }

    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        UserProfile userProfile = this.userProfile;
        return iHashCode + (userProfile != null ? userProfile.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(user=");
        sbU.append(this.user);
        sbU.append(", userProfile=");
        sbU.append(this.userProfile);
        sbU.append(")");
        return sbU.toString();
    }
}
