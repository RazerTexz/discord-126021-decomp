package com.discord.utilities.systemlog;

import kotlin.jvm.functions.Function1;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SystemLogUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SystemLogUtils$fetchLastTombstone$extractedGroups$1 extends AbstractC12240o implements Function1<MatchResult, String> {
    public final /* synthetic */ Regex $removeDexNameExp;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SystemLogUtils$fetchLastTombstone$extractedGroups$1(Regex regex) {
        super(1);
        this.$removeDexNameExp = regex;
    }

    @Override // kotlin.jvm.functions.Function1
    public final String invoke(MatchResult matchResult) {
        C12238m.checkNotNullParameter(matchResult, "it");
        return this.$removeDexNameExp.replace(matchResult.getGroupValues().get(1), "classesN.dex");
    }
}
