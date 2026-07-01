package com.discord.utilities.gifting;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.utilities.gifting.GiftStyle$Companion$values$2, reason: use source file name */
/* JADX INFO: compiled from: GiftStyle.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GiftStyle2 extends Lambda implements Function0<GiftStyle[]> {
    public static final GiftStyle2 INSTANCE = new GiftStyle2();

    public GiftStyle2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final GiftStyle[] invoke() {
        return GiftStyle.values();
    }
}
