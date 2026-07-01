package com.discord.utilities.textprocessing;


/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class DiscordParser$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        DiscordParser$ParserOptions.values();
        int[] iArr = new int[4];
        $EnumSwitchMapping$0 = iArr;
        iArr[DiscordParser$ParserOptions.DEFAULT.ordinal()] = 1;
        iArr[DiscordParser$ParserOptions.ALLOW_MASKED_LINKS.ordinal()] = 2;
        iArr[DiscordParser$ParserOptions.REPLY.ordinal()] = 3;
        iArr[DiscordParser$ParserOptions.FORUM_POST_FIRST_MESSAGE.ordinal()] = 4;
    }
}
