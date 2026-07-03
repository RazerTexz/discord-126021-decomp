package com.discord.widgets.chat.input.autocomplete;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: InputAutocompletables.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InputAutocompletablesKt {
    public static final List<Autocompletable> flatten(Map<LeadingIdentifier, ? extends List<? extends Autocompletable>> map) {
        C12238m.checkNotNullParameter(map, "$this$flatten");
        return C12149o.flatten(map.values());
    }

    private static final void merge(Map<LeadingIdentifier, TreeSet<Autocompletable>> map, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map2) {
        for (LeadingIdentifier leadingIdentifier : map2.keySet()) {
            TreeSet<Autocompletable> treeSet = map.get(leadingIdentifier);
            if (treeSet == null) {
                treeSet = new TreeSet<>(new AutocompletableComparator());
                map.put(leadingIdentifier, treeSet);
            }
            TreeSet<Autocompletable> treeSet2 = treeSet;
            TreeSet<Autocompletable> treeSetEmptySet = map2.get(leadingIdentifier);
            if (treeSetEmptySet == null) {
                treeSetEmptySet = C12148n0.emptySet();
            }
            treeSet2.addAll(treeSetEmptySet);
        }
    }
}
