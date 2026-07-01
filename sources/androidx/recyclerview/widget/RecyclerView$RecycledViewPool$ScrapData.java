package androidx.recyclerview.widget;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView$RecycledViewPool$ScrapData {
    public final ArrayList<RecyclerView$ViewHolder> mScrapHeap = new ArrayList<>();
    public int mMaxScrap = 5;
    public long mCreateRunningAverageNs = 0;
    public long mBindRunningAverageNs = 0;
}
