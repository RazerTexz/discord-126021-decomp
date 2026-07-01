package com.discord.widgets.guilds.invite;

import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreStream;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildInviteShareSheetFeatureFlag.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildInviteShareSheetFeatureFlag {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(GuildInviteShareSheetFeatureFlag2.INSTANCE);
    private final StoreExperiments storeExperiments;

    /* JADX INFO: compiled from: GuildInviteShareSheetFeatureFlag.kt */
    public static final class Companion {
        private Companion() {
        }

        public final GuildInviteShareSheetFeatureFlag getINSTANCE() {
            Lazy lazy = GuildInviteShareSheetFeatureFlag.INSTANCE$delegate;
            Companion companion = GuildInviteShareSheetFeatureFlag.INSTANCE;
            return (GuildInviteShareSheetFeatureFlag) lazy.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuildInviteShareSheetFeatureFlag() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public GuildInviteShareSheetFeatureFlag(StoreExperiments storeExperiments) {
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        this.storeExperiments = storeExperiments;
    }

    public final boolean isEnabled() {
        Experiment userExperiment = this.storeExperiments.getUserExperiment("2020-12_android_guild_channel_invite_sheet", true);
        return userExperiment != null && userExperiment.getBucket() == 1;
    }

    public /* synthetic */ GuildInviteShareSheetFeatureFlag(StoreExperiments storeExperiments, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments);
    }
}
