package com.discord.widgets.chat.input;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$State;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: ExpressionPickerItemDecoration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ExpressionPickerItemDecoration extends RecyclerView$ItemDecoration {
    private final int bottomPaddingForLastRow;
    private final List<Integer> headerIndices;
    private final int numOfColumns;

    public ExpressionPickerItemDecoration(int i, List<Integer> list, int i2) {
        m.checkNotNullParameter(list, "headerIndices");
        this.numOfColumns = i;
        this.headerIndices = list;
        this.bottomPaddingForLastRow = i2;
    }

    private final int getHeaderPositionForItem(int itemPosition) {
        Integer numPrevious;
        List<Integer> list = this.headerIndices;
        ListIterator<Integer> listIterator = list.listIterator(list.size());
        do {
            if (!listIterator.hasPrevious()) {
                numPrevious = null;
                break;
            }
            numPrevious = listIterator.previous();
        } while (!(itemPosition >= numPrevious.intValue()));
        Integer num = numPrevious;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    private final Integer getNextHeaderPositionForItem(int itemPosition) {
        Object next;
        Iterator<T> it = this.headerIndices.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (itemPosition <= ((Number) next).intValue()) {
                return (Integer) next;
            }
        }
        next = null;
        return (Integer) next;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView$State state) {
        m.checkNotNullParameter(outRect, "outRect");
        m.checkNotNullParameter(view, "view");
        m.checkNotNullParameter(parent, "parent");
        m.checkNotNullParameter(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        if (this.headerIndices.isEmpty()) {
            return;
        }
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (this.headerIndices.contains(Integer.valueOf(childAdapterPosition))) {
            return;
        }
        int headerPositionForItem = getHeaderPositionForItem(childAdapterPosition);
        Integer nextHeaderPositionForItem = getNextHeaderPositionForItem(childAdapterPosition);
        int iIntValue = ((nextHeaderPositionForItem != null ? nextHeaderPositionForItem.intValue() : state.getItemCount()) - headerPositionForItem) - 1;
        int i = (childAdapterPosition - headerPositionForItem) - 1;
        int i2 = this.numOfColumns;
        outRect.bottom = i >= ((iIntValue / i2) - (iIntValue % i2 == 0 ? 1 : 0)) * i2 ? this.bottomPaddingForLastRow : 0;
    }
}
