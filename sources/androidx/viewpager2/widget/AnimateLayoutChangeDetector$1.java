package androidx.viewpager2.widget;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class AnimateLayoutChangeDetector$1 implements Comparator<int[]> {
    public final /* synthetic */ AnimateLayoutChangeDetector this$0;

    public AnimateLayoutChangeDetector$1(AnimateLayoutChangeDetector animateLayoutChangeDetector) {
        this.this$0 = animateLayoutChangeDetector;
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(int[] iArr, int[] iArr2) {
        return compare2(iArr, iArr2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(int[] iArr, int[] iArr2) {
        return iArr[0] - iArr2[0];
    }
}
