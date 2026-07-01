package com.discord.utilities.systemlog;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* JADX INFO: compiled from: SystemLogUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SystemLogUtils$fetchLastTombstone$extractedGroups$1 extends o implements Function1<MatchResult, String> {
    public final /* synthetic */ Regex $removeDexNameExp;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SystemLogUtils$fetchLastTombstone$extractedGroups$1(Regex regex) {
        super(1);
        this.$removeDexNameExp = regex;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(MatchResult matchResult) {
        return invoke2(matchResult);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(MatchResult matchResult) {
        m.checkNotNullParameter(matchResult, "it");
        return this.$removeDexNameExp.replace(matchResult.getGroupValues().get(1), "classesN.dex");
    }
}
