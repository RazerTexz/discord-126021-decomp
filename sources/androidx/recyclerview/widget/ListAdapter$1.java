package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes.dex */
public class ListAdapter$1<T> implements AsyncListDiffer$ListListener<T> {
    public final /* synthetic */ ListAdapter this$0;

    public ListAdapter$1(ListAdapter listAdapter) {
        this.this$0 = listAdapter;
    }

    @Override // androidx.recyclerview.widget.AsyncListDiffer$ListListener
    public void onCurrentListChanged(@NonNull List<T> list, @NonNull List<T> list2) {
        this.this$0.onCurrentListChanged(list, list2);
    }
}
