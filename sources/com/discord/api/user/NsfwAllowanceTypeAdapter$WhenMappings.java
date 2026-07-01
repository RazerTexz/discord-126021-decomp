package com.discord.api.user;


/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class NsfwAllowanceTypeAdapter$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        NsfwAllowance.values();
        int[] iArr = new int[3];
        $EnumSwitchMapping$0 = iArr;
        iArr[NsfwAllowance.UNKNOWN.ordinal()] = 1;
        iArr[NsfwAllowance.ALLOWED.ordinal()] = 2;
        iArr[NsfwAllowance.DISALLOWED.ordinal()] = 3;
    }
}
