package com.discord.utilities.mg_recycler;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter.Payload;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.ranges.IntRange;
import p507d0.p580t.AbstractC12126c0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: CategoricalDragAndDropAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class CategoricalDragAndDropAdapter<T extends Payload> extends DragAndDropAdapter<T> {

    /* JADX INFO: compiled from: CategoricalDragAndDropAdapter.kt */
    public interface Payload extends DragAndDropAdapter.Payload {
        String getCategory();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategoricalDragAndDropAdapter(RecyclerView recyclerView) {
        super(recyclerView);
        C12238m.checkNotNullParameter(recyclerView, "recycler");
    }

    @Override // com.discord.utilities.mg_recycler.DragAndDropAdapter
    public Map<String, Integer> computeChangedPositions() {
        HashMap map = new HashMap();
        if (getDataCopy().isEmpty()) {
            return map;
        }
        String category = getDataCopy().get(0).getCategory();
        int size = getDataCopy().size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            T t = getDataCopy().get(i2);
            if (!C12238m.areEqual(t.getCategory(), category)) {
                category = t.getCategory();
                i = 0;
            }
            Integer num = getOrigPositions().get(t.getKey());
            if (num == null || num.intValue() != i) {
                map.put(t.getKey(), Integer.valueOf(i));
            }
            i++;
        }
        return map;
    }

    @Override // com.discord.utilities.mg_recycler.DragAndDropHelper.Adapter
    public boolean isValidMove(int fromPosition, int toPosition) {
        String category = getDataCopy().get(fromPosition).getCategory();
        Iterable intRange = new IntRange(Math.min(fromPosition, toPosition), Math.max(fromPosition, toPosition));
        if ((intRange instanceof Collection) && ((Collection) intRange).isEmpty()) {
            return true;
        }
        Iterator it = intRange.iterator();
        while (it.hasNext()) {
            if (!C12238m.areEqual(getDataCopy().get(((AbstractC12126c0) it).nextInt()).getCategory(), category)) {
                return false;
            }
        }
        return true;
    }
}
