package com.discord.utilities.uri;

import android.content.pm.ResolveInfo;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: UriHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UriHandler$openUrlExternally$1 extends o implements Function1<ResolveInfo, String> {
    public static final UriHandler$openUrlExternally$1 INSTANCE = new UriHandler$openUrlExternally$1();

    public UriHandler$openUrlExternally$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(ResolveInfo resolveInfo) {
        return invoke2(resolveInfo);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(ResolveInfo resolveInfo) {
        return resolveInfo.activityInfo.packageName;
    }
}
