package com.discord.widgets.guilds.list;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import java.util.List;

/* JADX INFO: compiled from: GuildsDragAndDropCallback.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface GuildsDragAndDropCallback$Controller {
    RecyclerView$ViewHolder chooseDropTarget(RecyclerView$ViewHolder selected, List<RecyclerView$ViewHolder> dropTargets, int curX, int curY);

    void onDragStarted(RecyclerView$ViewHolder viewHolder);

    void onDrop();

    boolean onMove(RecyclerView recyclerView, RecyclerView$ViewHolder source, RecyclerView$ViewHolder target);
}
