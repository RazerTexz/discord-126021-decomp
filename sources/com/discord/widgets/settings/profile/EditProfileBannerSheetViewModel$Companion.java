package com.discord.widgets.settings.profile;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserProfile;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: EditProfileBannerSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EditProfileBannerSheetViewModel$Companion {
    private EditProfileBannerSheetViewModel$Companion() {
    }

    private final Observable<EditProfileBannerSheetViewModel$StoreState> observeStoreState(StoreUser storeUser, StoreUserProfile storeUserProfile) {
        return ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck$UpdateSource[]{StoreUser.Companion.getMeUpdate(), storeUserProfile}, false, null, null, new EditProfileBannerSheetViewModel$Companion$observeStoreState$1(storeUser, storeUserProfile), 14, null);
    }

    public static /* synthetic */ Observable observeStoreState$default(EditProfileBannerSheetViewModel$Companion editProfileBannerSheetViewModel$Companion, StoreUser storeUser, StoreUserProfile storeUserProfile, int i, Object obj) {
        if ((i & 1) != 0) {
            storeUser = StoreStream.Companion.getUsers();
        }
        if ((i & 2) != 0) {
            storeUserProfile = StoreStream.Companion.getUserProfile();
        }
        return editProfileBannerSheetViewModel$Companion.observeStoreState(storeUser, storeUserProfile);
    }

    public /* synthetic */ EditProfileBannerSheetViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
