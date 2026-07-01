package com.discord.widgets.chat.input.autocomplete;

import d0.t.n0;
import d0.t.o;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: compiled from: InputAutocompletables.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InputAutocompletablesKt {
    public static final /* synthetic */ void access$merge(Map map, Map map2) {
        merge(map, map2);
    }

    public static final List<Autocompletable> flatten(Map<LeadingIdentifier, ? extends List<? extends Autocompletable>> map) {
        m.checkNotNullParameter(map, "$this$flatten");
        return o.flatten(map.values());
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
                treeSetEmptySet = n0.emptySet();
            }
            treeSet2.addAll(treeSetEmptySet);
        }
    }
}
