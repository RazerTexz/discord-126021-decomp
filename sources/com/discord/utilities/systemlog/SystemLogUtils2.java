package com.discord.utilities.systemlog;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* JADX INFO: renamed from: com.discord.utilities.systemlog.SystemLogUtils$fetchLastTombstone$extractedGroups$1, reason: use source file name */
/* JADX INFO: compiled from: SystemLogUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SystemLogUtils2 extends Lambda implements Function1<MatchResult, String> {
    public final /* synthetic */ Regex $removeDexNameExp;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SystemLogUtils2(Regex regex) {
        super(1);
        this.$removeDexNameExp = regex;
    }

    @Override // kotlin.jvm.functions.Function1
    public final String invoke(MatchResult matchResult) {
        Intrinsics3.checkNotNullParameter(matchResult, "it");
        return this.$removeDexNameExp.replace(matchResult.getGroupValues().get(1), "classesN.dex");
    }
}
