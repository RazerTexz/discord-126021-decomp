package com.discord.utilities.gifting;

import androidx.annotation.RawRes;
import com.discord.R$raw;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.g;
import kotlin.Lazy;

/* JADX INFO: compiled from: GiftStyle.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum GiftStyle {
    WumpusGlobe(1, 2131231459, R$raw.anim_gift_wumpus_globe),
    WumpusBox(2, 2131231457, R$raw.anim_gift_wumpus_box),
    WumpusLatte(3, 2131231458, R$raw.anim_gift_wumpus_latte);

    private final int animRes;
    private final int id;
    private final int staticRes;
    public static final GiftStyle$Companion Companion = new GiftStyle$Companion(null);
    private static final Lazy values$delegate = g.lazy(GiftStyle$Companion$values$2.INSTANCE);

    GiftStyle(@RawRes int i, int i2, int i3) {
        this.id = i;
        this.staticRes = i2;
        this.animRes = i3;
    }

    public static final /* synthetic */ Lazy access$getValues$cp() {
        return values$delegate;
    }

    public final int getAnimRes() {
        return this.animRes;
    }

    public final int getId() {
        return this.id;
    }

    public final int getStaticRes() {
        return this.staticRes;
    }
}
