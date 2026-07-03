package kotlin.text;

import java.util.List;
import kotlin.ranges.IntRange;
import p507d0.p579g0.InterfaceC12089f;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: MatchResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface MatchResult {

    /* JADX INFO: renamed from: kotlin.text.MatchResult$a */
    /* JADX INFO: compiled from: MatchResult.kt */
    public static final class C12797a {
        public static C12798b getDestructured(MatchResult matchResult) {
            return new C12798b(matchResult);
        }
    }

    /* JADX INFO: renamed from: kotlin.text.MatchResult$b */
    /* JADX INFO: compiled from: MatchResult.kt */
    public static final class C12798b {

        /* JADX INFO: renamed from: a */
        public final MatchResult f27452a;

        public C12798b(MatchResult matchResult) {
            C12238m.checkNotNullParameter(matchResult, "match");
            this.f27452a = matchResult;
        }

        public final MatchResult getMatch() {
            return this.f27452a;
        }
    }

    C12798b getDestructured();

    List<String> getGroupValues();

    InterfaceC12089f getGroups();

    IntRange getRange();

    String getValue();

    MatchResult next();
}
