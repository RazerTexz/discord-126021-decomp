package com.discord.utilities.premium;

import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p009a.C0841r;
import p507d0.C12083g;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: BlockRussianPurchasesUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BlockRussianPurchasesUtils {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = C12083g.lazy(BlockRussianPurchasesUtils$Companion$INSTANCE$2.INSTANCE);
    private Boolean isBlockedFromPurchases;

    /* JADX INFO: compiled from: BlockRussianPurchasesUtils.kt */
    public static final class Companion {
        private Companion() {
        }

        public final BlockRussianPurchasesUtils getINSTANCE() {
            Lazy lazy = BlockRussianPurchasesUtils.INSTANCE$delegate;
            Companion companion = BlockRussianPurchasesUtils.INSTANCE;
            return (BlockRussianPurchasesUtils) lazy.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final boolean isBlockedFromPurchases() {
        if (this.isBlockedFromPurchases == null) {
            Experiment userExperiment = StoreStream.INSTANCE.getExperiments().getUserExperiment("2022-03_block_russian_purchases", true);
            this.isBlockedFromPurchases = Boolean.valueOf(userExperiment != null && userExperiment.getBucket() == 1);
        }
        Boolean bool = this.isBlockedFromPurchases;
        C12238m.checkNotNull(bool);
        return bool.booleanValue();
    }

    public final boolean showDialog() {
        if (!isBlockedFromPurchases()) {
            return false;
        }
        Objects.requireNonNull(C0841r.INSTANCE);
        String str = "Block Russian Purchases Dialog";
        StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice(str, null, 0L, 0, false, null, 0L, true, 0L, C6835xa02d3131.INSTANCE, 54, null));
        return true;
    }
}
