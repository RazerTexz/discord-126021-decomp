package androidx.recyclerview.widget;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView$RecycledViewPool {
    private static final int DEFAULT_MAX_SCRAP = 5;
    public SparseArray<RecyclerView$RecycledViewPool$ScrapData> mScrap = new SparseArray<>();
    private int mAttachCount = 0;

    private RecyclerView$RecycledViewPool$ScrapData getScrapDataForType(int i) {
        RecyclerView$RecycledViewPool$ScrapData recyclerView$RecycledViewPool$ScrapData = this.mScrap.get(i);
        if (recyclerView$RecycledViewPool$ScrapData != null) {
            return recyclerView$RecycledViewPool$ScrapData;
        }
        RecyclerView$RecycledViewPool$ScrapData recyclerView$RecycledViewPool$ScrapData2 = new RecyclerView$RecycledViewPool$ScrapData();
        this.mScrap.put(i, recyclerView$RecycledViewPool$ScrapData2);
        return recyclerView$RecycledViewPool$ScrapData2;
    }

    public void attach() {
        this.mAttachCount++;
    }

    public void clear() {
        for (int i = 0; i < this.mScrap.size(); i++) {
            this.mScrap.valueAt(i).mScrapHeap.clear();
        }
    }

    public void detach() {
        this.mAttachCount--;
    }

    public void factorInBindTime(int i, long j) {
        RecyclerView$RecycledViewPool$ScrapData scrapDataForType = getScrapDataForType(i);
        scrapDataForType.mBindRunningAverageNs = runningAverage(scrapDataForType.mBindRunningAverageNs, j);
    }

    public void factorInCreateTime(int i, long j) {
        RecyclerView$RecycledViewPool$ScrapData scrapDataForType = getScrapDataForType(i);
        scrapDataForType.mCreateRunningAverageNs = runningAverage(scrapDataForType.mCreateRunningAverageNs, j);
    }

    @Nullable
    public RecyclerView$ViewHolder getRecycledView(int i) {
        RecyclerView$RecycledViewPool$ScrapData recyclerView$RecycledViewPool$ScrapData = this.mScrap.get(i);
        if (recyclerView$RecycledViewPool$ScrapData == null || recyclerView$RecycledViewPool$ScrapData.mScrapHeap.isEmpty()) {
            return null;
        }
        ArrayList<RecyclerView$ViewHolder> arrayList = recyclerView$RecycledViewPool$ScrapData.mScrapHeap;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (!arrayList.get(size).isAttachedToTransitionOverlay()) {
                return arrayList.remove(size);
            }
        }
        return null;
    }

    public int getRecycledViewCount(int i) {
        return getScrapDataForType(i).mScrapHeap.size();
    }

    public void onAdapterChanged(RecyclerView$Adapter recyclerView$Adapter, RecyclerView$Adapter recyclerView$Adapter2, boolean z2) {
        if (recyclerView$Adapter != null) {
            detach();
        }
        if (!z2 && this.mAttachCount == 0) {
            clear();
        }
        if (recyclerView$Adapter2 != null) {
            attach();
        }
    }

    public void putRecycledView(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        int itemViewType = recyclerView$ViewHolder.getItemViewType();
        ArrayList<RecyclerView$ViewHolder> arrayList = getScrapDataForType(itemViewType).mScrapHeap;
        if (this.mScrap.get(itemViewType).mMaxScrap <= arrayList.size()) {
            return;
        }
        recyclerView$ViewHolder.resetInternal();
        arrayList.add(recyclerView$ViewHolder);
    }

    public long runningAverage(long j, long j2) {
        if (j == 0) {
            return j2;
        }
        return (j2 / 4) + ((j / 4) * 3);
    }

    public void setMaxRecycledViews(int i, int i2) {
        RecyclerView$RecycledViewPool$ScrapData scrapDataForType = getScrapDataForType(i);
        scrapDataForType.mMaxScrap = i2;
        ArrayList<RecyclerView$ViewHolder> arrayList = scrapDataForType.mScrapHeap;
        while (arrayList.size() > i2) {
            arrayList.remove(arrayList.size() - 1);
        }
    }

    public int size() {
        int size = 0;
        for (int i = 0; i < this.mScrap.size(); i++) {
            ArrayList<RecyclerView$ViewHolder> arrayList = this.mScrap.valueAt(i).mScrapHeap;
            if (arrayList != null) {
                size = arrayList.size() + size;
            }
        }
        return size;
    }

    public boolean willBindInTime(int i, long j, long j2) {
        long j3 = getScrapDataForType(i).mBindRunningAverageNs;
        return j3 == 0 || j + j3 < j2;
    }

    public boolean willCreateInTime(int i, long j, long j2) {
        long j3 = getScrapDataForType(i).mCreateRunningAverageNs;
        return j3 == 0 || j + j3 < j2;
    }
}
