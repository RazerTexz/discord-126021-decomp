package com.discord.widgets.chat.input.emoji;

import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreStream;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: EmojiAutocompletePremiumUpsellFeatureFlag.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiAutocompletePremiumUpsellFeatureFlag {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(EmojiAutocompletePremiumUpsellFeatureFlag2.INSTANCE);
    private final StoreExperiments storeExperiments;

    /* JADX INFO: compiled from: EmojiAutocompletePremiumUpsellFeatureFlag.kt */
    public static final class Companion {
        private Companion() {
        }

        public final EmojiAutocompletePremiumUpsellFeatureFlag getINSTANCE() {
            Lazy lazy = EmojiAutocompletePremiumUpsellFeatureFlag.INSTANCE$delegate;
            Companion companion = EmojiAutocompletePremiumUpsellFeatureFlag.INSTANCE;
            return (EmojiAutocompletePremiumUpsellFeatureFlag) lazy.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EmojiAutocompletePremiumUpsellFeatureFlag() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public EmojiAutocompletePremiumUpsellFeatureFlag(StoreExperiments storeExperiments) {
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        this.storeExperiments = storeExperiments;
    }

    public final boolean isEnabled() {
        Experiment userExperiment = this.storeExperiments.getUserExperiment("2021-03_nitro_emoji_autocomplete_upsell_android", true);
        return (userExperiment != null ? userExperiment.getBucket() : 0) != 0;
    }

    public /* synthetic */ EmojiAutocompletePremiumUpsellFeatureFlag(StoreExperiments storeExperiments, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments);
    }
}
