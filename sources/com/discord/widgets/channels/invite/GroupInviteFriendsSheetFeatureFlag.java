package com.discord.widgets.channels.invite;

import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreStream;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GroupInviteFriendsSheetFeatureFlag.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GroupInviteFriendsSheetFeatureFlag {
    public static final GroupInviteFriendsSheetFeatureFlag$Companion Companion = new GroupInviteFriendsSheetFeatureFlag$Companion(null);
    private static final Lazy INSTANCE$delegate = g.lazy(GroupInviteFriendsSheetFeatureFlag$Companion$INSTANCE$2.INSTANCE);
    private final StoreExperiments storeExperiments;

    public GroupInviteFriendsSheetFeatureFlag() {
        this(null, 1, null);
    }

    public GroupInviteFriendsSheetFeatureFlag(StoreExperiments storeExperiments) {
        m.checkNotNullParameter(storeExperiments, "storeExperiments");
        this.storeExperiments = storeExperiments;
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public final boolean isEnabled() {
        Experiment userExperiment = this.storeExperiments.getUserExperiment("2020-12_invite_to_gdm", true);
        return userExperiment != null && userExperiment.getBucket() == 1;
    }

    public /* synthetic */ GroupInviteFriendsSheetFeatureFlag(StoreExperiments storeExperiments, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.Companion.getExperiments() : storeExperiments);
    }
}
