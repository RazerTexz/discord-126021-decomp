package com.discord.widgets.channels.memberlist;

import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.PrivateChannelMemberListItemGeneratorKt$generateGroupDmMemberListItems$memberItems$1 */
/* JADX INFO: compiled from: PrivateChannelMemberListItemGenerator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C7484xdf5d5077 extends C12236k implements Function2<String, String, Integer> {
    public static final C7484xdf5d5077 INSTANCE = new C7484xdf5d5077();

    public C7484xdf5d5077() {
        super(2, String.class, "compareTo", "compareTo(Ljava/lang/String;)I", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2(String str, String str2) {
        C12238m.checkNotNullParameter(str, "p1");
        C12238m.checkNotNullParameter(str2, "p2");
        return str.compareTo(str2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Integer invoke(String str, String str2) {
        return Integer.valueOf(invoke2(str, str2));
    }
}
