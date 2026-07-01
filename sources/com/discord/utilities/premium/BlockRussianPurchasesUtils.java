package com.discord.utilities.premium;

import b.a.a.r;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreNotices$Notice;
import com.discord.stores.StoreStream;
import d0.g;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Lazy;

/* JADX INFO: compiled from: BlockRussianPurchasesUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BlockRussianPurchasesUtils {
    public static final BlockRussianPurchasesUtils$Companion Companion = new BlockRussianPurchasesUtils$Companion(null);
    private static final Lazy INSTANCE$delegate = g.lazy(BlockRussianPurchasesUtils$Companion$INSTANCE$2.INSTANCE);
    private Boolean isBlockedFromPurchases;

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public final boolean isBlockedFromPurchases() {
        if (this.isBlockedFromPurchases == null) {
            Experiment userExperiment = StoreStream.Companion.getExperiments().getUserExperiment("2022-03_block_russian_purchases", true);
            this.isBlockedFromPurchases = Boolean.valueOf(userExperiment != null && userExperiment.getBucket() == 1);
        }
        Boolean bool = this.isBlockedFromPurchases;
        m.checkNotNull(bool);
        return bool.booleanValue();
    }

    public final boolean showDialog() {
        if (!isBlockedFromPurchases()) {
            return false;
        }
        Objects.requireNonNull(r.k);
        StoreStream.Companion.getNotices().requestToShow(new StoreNotices$Notice("Block Russian Purchases Dialog", null, 0L, 0, false, null, 0L, true, 0L, BlockRussianPurchasesUtils$showDialog$blockRussianPurchasesNotice$1.INSTANCE, 54, null));
        return true;
    }
}
