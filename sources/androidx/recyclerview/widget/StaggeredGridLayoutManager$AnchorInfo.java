package androidx.recyclerview.widget;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager$AnchorInfo {
    public boolean mInvalidateOffsets;
    public boolean mLayoutFromEnd;
    public int mOffset;
    public int mPosition;
    public int[] mSpanReferenceLines;
    public boolean mValid;
    public final /* synthetic */ StaggeredGridLayoutManager this$0;

    public StaggeredGridLayoutManager$AnchorInfo(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.this$0 = staggeredGridLayoutManager;
        reset();
    }

    public void assignCoordinateFromPadding() {
        this.mOffset = this.mLayoutFromEnd ? this.this$0.mPrimaryOrientation.getEndAfterPadding() : this.this$0.mPrimaryOrientation.getStartAfterPadding();
    }

    public void reset() {
        this.mPosition = -1;
        this.mOffset = Integer.MIN_VALUE;
        this.mLayoutFromEnd = false;
        this.mInvalidateOffsets = false;
        this.mValid = false;
        int[] iArr = this.mSpanReferenceLines;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
    }

    public void saveSpanReferenceLines(StaggeredGridLayoutManager$Span[] staggeredGridLayoutManager$SpanArr) {
        int length = staggeredGridLayoutManager$SpanArr.length;
        int[] iArr = this.mSpanReferenceLines;
        if (iArr == null || iArr.length < length) {
            this.mSpanReferenceLines = new int[this.this$0.mSpans.length];
        }
        for (int i = 0; i < length; i++) {
            this.mSpanReferenceLines[i] = staggeredGridLayoutManager$SpanArr[i].getStartLine(Integer.MIN_VALUE);
        }
    }

    public void assignCoordinateFromPadding(int i) {
        if (this.mLayoutFromEnd) {
            this.mOffset = this.this$0.mPrimaryOrientation.getEndAfterPadding() - i;
        } else {
            this.mOffset = this.this$0.mPrimaryOrientation.getStartAfterPadding() + i;
        }
    }
}
