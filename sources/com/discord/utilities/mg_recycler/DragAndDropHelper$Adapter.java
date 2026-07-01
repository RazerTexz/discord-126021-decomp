package com.discord.utilities.mg_recycler;


/* JADX INFO: compiled from: DragAndDropHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface DragAndDropHelper$Adapter {
    boolean isValidMove(int fromPosition, int toPosition);

    void onDrop();

    void onItemMove(int fromPosition, int toPosition);
}
