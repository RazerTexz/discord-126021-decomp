package androidx.core.text.util;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class LinkifyCompat$1 implements Comparator<LinkifyCompat$LinkSpec> {
    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(LinkifyCompat$LinkSpec linkifyCompat$LinkSpec, LinkifyCompat$LinkSpec linkifyCompat$LinkSpec2) {
        return compare2(linkifyCompat$LinkSpec, linkifyCompat$LinkSpec2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(LinkifyCompat$LinkSpec linkifyCompat$LinkSpec, LinkifyCompat$LinkSpec linkifyCompat$LinkSpec2) {
        int i;
        int i2;
        int i3 = linkifyCompat$LinkSpec.start;
        int i4 = linkifyCompat$LinkSpec2.start;
        if (i3 < i4) {
            return -1;
        }
        if (i3 <= i4 && (i = linkifyCompat$LinkSpec.end) >= (i2 = linkifyCompat$LinkSpec2.end)) {
            return i > i2 ? -1 : 0;
        }
        return 1;
    }
}
