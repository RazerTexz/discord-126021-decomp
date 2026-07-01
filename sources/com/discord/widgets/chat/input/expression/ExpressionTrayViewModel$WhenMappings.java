package com.discord.widgets.chat.input.expression;


/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ExpressionTrayViewModel$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;

    static {
        ExpressionTrayTab.values();
        int[] iArr = new int[3];
        $EnumSwitchMapping$0 = iArr;
        ExpressionTrayTab expressionTrayTab = ExpressionTrayTab.EMOJI;
        iArr[expressionTrayTab.ordinal()] = 1;
        ExpressionTrayTab expressionTrayTab2 = ExpressionTrayTab.GIF;
        iArr[expressionTrayTab2.ordinal()] = 2;
        ExpressionTrayTab expressionTrayTab3 = ExpressionTrayTab.STICKER;
        iArr[expressionTrayTab3.ordinal()] = 3;
        ExpressionTrayTab.values();
        int[] iArr2 = new int[3];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[expressionTrayTab.ordinal()] = 1;
        iArr2[expressionTrayTab2.ordinal()] = 2;
        iArr2[expressionTrayTab3.ordinal()] = 3;
    }
}
