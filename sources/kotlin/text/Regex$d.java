package kotlin.text;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class Regex$d extends k implements Function1<MatchResult, MatchResult> {
    public static final Regex$d j = new Regex$d();

    public Regex$d() {
        super(1, MatchResult.class, "next", "next()Lkotlin/text/MatchResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ MatchResult invoke(MatchResult matchResult) {
        return invoke2(matchResult);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final MatchResult invoke2(MatchResult matchResult) {
        m.checkNotNullParameter(matchResult, "p1");
        return matchResult.next();
    }
}
