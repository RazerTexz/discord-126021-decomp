package kotlin.text;

import d0.g0.f;
import java.util.List;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: MatchResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface MatchResult {
    MatchResult$b getDestructured();

    List<String> getGroupValues();

    f getGroups();

    IntRange getRange();

    String getValue();

    MatchResult next();
}
