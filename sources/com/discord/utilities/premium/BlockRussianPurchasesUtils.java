package com.discord.utilities.premium;

import b.a.a.WidgetBlockRussianPurchasesDialog;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BlockRussianPurchasesUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BlockRussianPurchasesUtils {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(BlockRussianPurchasesUtils2.INSTANCE);
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
        Intrinsics3.checkNotNull(bool);
        return bool.booleanValue();
    }

    public final boolean showDialog() {
        if (!isBlockedFromPurchases()) {
            return false;
        }
        Objects.requireNonNull(WidgetBlockRussianPurchasesDialog.INSTANCE);
        String str = "Block Russian Purchases Dialog";
        StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice(str, null, 0L, 0, false, null, 0L, true, 0L, BlockRussianPurchasesUtils3.INSTANCE, 54, null));
        return true;
    }
}
