package com.discord.utilities.stickers;

import com.discord.utilities.dimen.DimenUtils;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: com.discord.utilities.stickers.StickerUtils$DEFAULT_STICKER_SIZE_PX$2, reason: use source file name */
/* JADX INFO: compiled from: StickerUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerUtils2 extends Lambda implements Function0<Integer> {
    public static final StickerUtils2 INSTANCE = new StickerUtils2();

    public StickerUtils2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        return DimenUtils.dpToPixels(Opcodes.IF_ICMPNE);
    }
}
