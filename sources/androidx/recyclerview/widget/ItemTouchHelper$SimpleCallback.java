package androidx.recyclerview.widget;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public abstract class ItemTouchHelper$SimpleCallback extends ItemTouchHelper$Callback {
    private int mDefaultDragDirs;
    private int mDefaultSwipeDirs;

    public ItemTouchHelper$SimpleCallback(int i, int i2) {
        this.mDefaultSwipeDirs = i2;
        this.mDefaultDragDirs = i;
    }

    public int getDragDirs(@NonNull RecyclerView recyclerView, @NonNull RecyclerView$ViewHolder recyclerView$ViewHolder) {
        return this.mDefaultDragDirs;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper$Callback
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView$ViewHolder recyclerView$ViewHolder) {
        return ItemTouchHelper$Callback.makeMovementFlags(getDragDirs(recyclerView, recyclerView$ViewHolder), getSwipeDirs(recyclerView, recyclerView$ViewHolder));
    }

    public int getSwipeDirs(@NonNull RecyclerView recyclerView, @NonNull RecyclerView$ViewHolder recyclerView$ViewHolder) {
        return this.mDefaultSwipeDirs;
    }

    public void setDefaultDragDirs(int i) {
        this.mDefaultDragDirs = i;
    }

    public void setDefaultSwipeDirs(int i) {
        this.mDefaultSwipeDirs = i;
    }
}
