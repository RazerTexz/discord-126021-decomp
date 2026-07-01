package com.discord.api.report;

import d0.t.h0;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: InAppReportsMenu.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ReportSubmissionBody$Companion {
    public ReportSubmissionBody$Companion() {
    }

    public final Pair<List<Integer>, Map<String, List<String>>> a(List<NodeResult> results) {
        Pair pair;
        m.checkNotNullParameter(results, "results");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = results.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ReportNodeChild destination = ((NodeResult) it.next()).getDestination();
            Integer numValueOf = destination != null ? Integer.valueOf(destination.getRef()) : null;
            if (numValueOf != null) {
                arrayList.add(numValueOf);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it2 = results.iterator();
        while (it2.hasNext()) {
            NodeElementResult elementResult = ((NodeResult) it2.next()).getElementResult();
            if (elementResult != null) {
                String key = elementResult.getKey();
                List<ReportNodeElementData> listA = elementResult.a();
                ArrayList arrayList3 = new ArrayList(o.collectionSizeOrDefault(listA, 10));
                Iterator<T> it3 = listA.iterator();
                while (it3.hasNext()) {
                    arrayList3.add(((ReportNodeElementData) it3.next()).getElementKey());
                }
                pair = d0.o.to(key, arrayList3);
            } else {
                pair = null;
            }
            if (pair != null) {
                arrayList2.add(pair);
            }
        }
        return d0.o.to(arrayList, h0.toMap(arrayList2));
    }

    public ReportSubmissionBody$Companion(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
