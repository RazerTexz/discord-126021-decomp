package com.discord.utilities.search;

import java.util.Set;
import kotlin.text.Regex;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SearchUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SearchUtils {
    public static final SearchUtils INSTANCE = new SearchUtils();

    private SearchUtils() {
    }

    public final boolean fuzzyMatch(String query, String target) {
        C12238m.checkNotNullParameter(query, "query");
        C12238m.checkNotNullParameter(target, "target");
        if (query.length() > target.length()) {
            return false;
        }
        if (query.length() == target.length()) {
            return C12238m.areEqual(query, target);
        }
        int length = query.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char cCharAt = query.charAt(i);
            while (i2 < target.length()) {
                int i3 = i2 + 1;
                char cCharAt2 = target.charAt(i2);
                if (cCharAt2 == cCharAt || (cCharAt == ' ' && cCharAt2 == '-')) {
                    i++;
                    i2 = i3;
                } else {
                    i2 = i3;
                }
            }
            return false;
        }
        return true;
    }

    public final Set<String> getQueriesFromSearchText(String searchText) {
        C12238m.checkNotNullParameter(searchText, "searchText");
        return searchText.length() == 0 ? C12148n0.emptySet() : C12163u.toSet(C12106w.split$default((CharSequence) new Regex("(\\n|\\t|\\s)").replace(new Regex("([!.;,\\-—–?\"'])").replace(C12106w.trim(searchText).toString(), ""), " "), new char[]{' '}, false, 0, 6, (Object) null));
    }
}
