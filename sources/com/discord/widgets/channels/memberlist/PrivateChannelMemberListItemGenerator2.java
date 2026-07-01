package com.discord.widgets.channels.memberlist;

import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.PrivateChannelMemberListItemGeneratorKt$generateGroupDmMemberListItems$memberItems$1, reason: use source file name */
/* JADX INFO: compiled from: PrivateChannelMemberListItemGenerator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class PrivateChannelMemberListItemGenerator2 extends FunctionReferenceImpl implements Function2<String, String, Integer> {
    public static final PrivateChannelMemberListItemGenerator2 INSTANCE = new PrivateChannelMemberListItemGenerator2();

    public PrivateChannelMemberListItemGenerator2() {
        super(2, String.class, "compareTo", "compareTo(Ljava/lang/String;)I", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2(String str, String str2) {
        Intrinsics3.checkNotNullParameter(str, "p1");
        Intrinsics3.checkNotNullParameter(str2, "p2");
        return str.compareTo(str2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Integer invoke(String str, String str2) {
        return Integer.valueOf(invoke2(str, str2));
    }
}
