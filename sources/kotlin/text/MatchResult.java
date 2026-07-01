package kotlin.text;

import d0.g0.MatchResult2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.ranges.Ranges2;

/* JADX INFO: compiled from: MatchResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface MatchResult {

    /* JADX INFO: compiled from: MatchResult.kt */
    public static final class a {
        public static b getDestructured(MatchResult matchResult) {
            return new b(matchResult);
        }
    }

    /* JADX INFO: compiled from: MatchResult.kt */
    public static final class b {
        public final MatchResult a;

        public b(MatchResult matchResult) {
            Intrinsics3.checkNotNullParameter(matchResult, "match");
            this.a = matchResult;
        }

        public final MatchResult getMatch() {
            return this.a;
        }
    }

    b getDestructured();

    List<String> getGroupValues();

    MatchResult2 getGroups();

    Ranges2 getRange();

    String getValue();

    MatchResult next();
}
