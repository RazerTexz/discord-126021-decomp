package com.discord.widgets.channels.memberlist;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: PrivateChannelMemberListItemGenerator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class PrivateChannelMemberListItemGeneratorKt$generateGroupDmMemberListItems$memberItems$1 extends k implements Function2<String, String, Integer> {
    public static final PrivateChannelMemberListItemGeneratorKt$generateGroupDmMemberListItems$memberItems$1 INSTANCE = new PrivateChannelMemberListItemGeneratorKt$generateGroupDmMemberListItems$memberItems$1();

    public PrivateChannelMemberListItemGeneratorKt$generateGroupDmMemberListItems$memberItems$1() {
        super(2, String.class, "compareTo", "compareTo(Ljava/lang/String;)I", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2(String str, String str2) {
        m.checkNotNullParameter(str, "p1");
        m.checkNotNullParameter(str2, "p2");
        return str.compareTo(str2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Integer invoke(String str, String str2) {
        return Integer.valueOf(invoke2(str, str2));
    }
}
