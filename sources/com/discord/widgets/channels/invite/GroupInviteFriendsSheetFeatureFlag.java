package com.discord.widgets.channels.invite;

import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreStream;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GroupInviteFriendsSheetFeatureFlag.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GroupInviteFriendsSheetFeatureFlag {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(GroupInviteFriendsSheetFeatureFlag2.INSTANCE);
    private final StoreExperiments storeExperiments;

    /* JADX INFO: compiled from: GroupInviteFriendsSheetFeatureFlag.kt */
    public static final class Companion {
        private Companion() {
        }

        public final GroupInviteFriendsSheetFeatureFlag getINSTANCE() {
            Lazy lazy = GroupInviteFriendsSheetFeatureFlag.INSTANCE$delegate;
            Companion companion = GroupInviteFriendsSheetFeatureFlag.INSTANCE;
            return (GroupInviteFriendsSheetFeatureFlag) lazy.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GroupInviteFriendsSheetFeatureFlag() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public GroupInviteFriendsSheetFeatureFlag(StoreExperiments storeExperiments) {
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        this.storeExperiments = storeExperiments;
    }

    public final boolean isEnabled() {
        Experiment userExperiment = this.storeExperiments.getUserExperiment("2020-12_invite_to_gdm", true);
        return userExperiment != null && userExperiment.getBucket() == 1;
    }

    public /* synthetic */ GroupInviteFriendsSheetFeatureFlag(StoreExperiments storeExperiments, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments);
    }
}
