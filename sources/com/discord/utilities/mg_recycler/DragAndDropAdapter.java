package com.discord.utilities.mg_recycler;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.utilities.mg_recycler.DragAndDropAdapter.Payload;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ranges.IntRange;
import p507d0.p512d0.C11226f;
import p507d0.p580t.AbstractC12126c0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: DragAndDropAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class DragAndDropAdapter<T extends Payload> extends MGRecyclerAdapterSimple<T> implements DragAndDropHelper.Adapter {
    private List<T> dataCopy;
    private Map<String, Integer> origPositions;

    /* JADX INFO: compiled from: DragAndDropAdapter.kt */
    public interface Payload extends MGRecyclerDataPayload {
        int getPosition();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragAndDropAdapter(RecyclerView recyclerView) {
        super(recyclerView, false);
        C12238m.checkNotNullParameter(recyclerView, "recyclerView");
        this.dataCopy = new ArrayList();
        this.origPositions = new HashMap();
    }

    private final void computeOriginalPositions(List<? extends T> data) {
        this.origPositions.clear();
        IntRange indices = C12147n.getIndices(data);
        ArrayList<Payload> arrayList = new ArrayList(C12149o.collectionSizeOrDefault(indices, 10));
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(data.get(((AbstractC12126c0) it).nextInt()));
        }
        for (Payload payload : arrayList) {
            this.origPositions.put(payload.getKey(), Integer.valueOf(payload.getPosition()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setAndCopyData(List<? extends T> data) {
        super.setData(data);
        this.dataCopy = new ArrayList(data);
    }

    public Map<String, Integer> computeChangedPositions() {
        HashMap map = new HashMap();
        int size = this.dataCopy.size();
        for (int i = 0; i < size; i++) {
            String key = this.dataCopy.get(i).getKey();
            Integer num = this.origPositions.get(key);
            if (num == null || i != num.intValue()) {
                map.put(key, Integer.valueOf(i));
            }
        }
        return map;
    }

    public final List<T> getDataCopy() {
        return this.dataCopy;
    }

    public final Map<String, Integer> getOrigPositions() {
        return this.origPositions;
    }

    public final boolean isMoveWithinBounds(int fromPosition, int toPosition) {
        if (this.dataCopy.isEmpty()) {
            return false;
        }
        IntRange intRangeUntil = C11226f.until(0, this.dataCopy.size());
        return intRangeUntil.contains(fromPosition) && intRangeUntil.contains(toPosition);
    }

    @Override // com.discord.utilities.mg_recycler.DragAndDropHelper.Adapter
    public void onDrop() {
        if (!this.dataCopy.isEmpty()) {
            Map<String, Integer> mapComputeChangedPositions = computeChangedPositions();
            if (!mapComputeChangedPositions.isEmpty()) {
                onNewPositions(mapComputeChangedPositions);
            }
        }
    }

    @Override // com.discord.utilities.mg_recycler.DragAndDropHelper.Adapter
    public void onItemMove(int fromPosition, int toPosition) {
        T t = this.dataCopy.get(fromPosition);
        this.dataCopy.remove(fromPosition);
        this.dataCopy.add(toPosition, t);
        setAndCopyData(this.dataCopy);
    }

    public abstract void onNewPositions(Map<String, Integer> newPositions);

    @Override // com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple
    public void setData(List<? extends T> data) {
        C12238m.checkNotNullParameter(data, "data");
        computeOriginalPositions(data);
        setAndCopyData(data);
    }

    public final void setDataCopy(List<T> list) {
        C12238m.checkNotNullParameter(list, "<set-?>");
        this.dataCopy = list;
    }

    public final void setOrigPositions(Map<String, Integer> map) {
        C12238m.checkNotNullParameter(map, "<set-?>");
        this.origPositions = map;
    }
}
