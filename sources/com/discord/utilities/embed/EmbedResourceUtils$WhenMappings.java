package com.discord.utilities.embed;

import com.discord.api.message.attachment.MessageAttachmentType;
import com.discord.api.message.embed.EmbedType;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class EmbedResourceUtils$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;
    public static final /* synthetic */ int[] $EnumSwitchMapping$2;
    public static final /* synthetic */ int[] $EnumSwitchMapping$3;
    public static final /* synthetic */ int[] $EnumSwitchMapping$4;
    public static final /* synthetic */ int[] $EnumSwitchMapping$5;

    static {
        MessageAttachmentType.values();
        int[] iArr = new int[3];
        $EnumSwitchMapping$0 = iArr;
        iArr[MessageAttachmentType.VIDEO.ordinal()] = 1;
        iArr[MessageAttachmentType.IMAGE.ordinal()] = 2;
        iArr[MessageAttachmentType.FILE.ordinal()] = 3;
        EmbedType.values();
        int[] iArr2 = new int[11];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[EmbedType.LINK.ordinal()] = 1;
        iArr2[EmbedType.HTML.ordinal()] = 2;
        EmbedType embedType = EmbedType.VIDEO;
        iArr2[embedType.ordinal()] = 3;
        EmbedType embedType2 = EmbedType.GIFV;
        iArr2[embedType2.ordinal()] = 4;
        iArr2[EmbedType.TWEET.ordinal()] = 5;
        EmbedType embedType3 = EmbedType.IMAGE;
        iArr2[embedType3.ordinal()] = 6;
        iArr2[EmbedType.ARTICLE.ordinal()] = 7;
        EmbedType.values();
        int[] iArr3 = new int[11];
        $EnumSwitchMapping$2 = iArr3;
        iArr3[embedType2.ordinal()] = 1;
        iArr3[embedType3.ordinal()] = 2;
        iArr3[embedType.ordinal()] = 3;
        EmbedType.values();
        int[] iArr4 = new int[11];
        $EnumSwitchMapping$3 = iArr4;
        iArr4[embedType3.ordinal()] = 1;
        iArr4[embedType2.ordinal()] = 2;
        EmbedType.values();
        int[] iArr5 = new int[11];
        $EnumSwitchMapping$4 = iArr5;
        iArr5[embedType2.ordinal()] = 1;
        iArr5[embedType3.ordinal()] = 2;
        EmbedType.values();
        int[] iArr6 = new int[11];
        $EnumSwitchMapping$5 = iArr6;
        iArr6[EmbedType.FILE.ordinal()] = 1;
        iArr6[embedType.ordinal()] = 2;
    }
}
