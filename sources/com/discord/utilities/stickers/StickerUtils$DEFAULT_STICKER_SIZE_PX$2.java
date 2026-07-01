package com.discord.utilities.stickers;

import com.discord.utilities.dimen.DimenUtils;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: StickerUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerUtils$DEFAULT_STICKER_SIZE_PX$2 extends o implements Function0<Integer> {
    public static final StickerUtils$DEFAULT_STICKER_SIZE_PX$2 INSTANCE = new StickerUtils$DEFAULT_STICKER_SIZE_PX$2();

    public StickerUtils$DEFAULT_STICKER_SIZE_PX$2() {
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
