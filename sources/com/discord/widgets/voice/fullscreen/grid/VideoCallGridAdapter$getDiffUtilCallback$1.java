package com.discord.widgets.voice.fullscreen.grid;

import androidx.recyclerview.widget.DiffUtil$Callback;
import com.discord.widgets.voice.fullscreen.CallParticipant;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: VideoCallGridAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VideoCallGridAdapter$getDiffUtilCallback$1 extends DiffUtil$Callback {
    public final /* synthetic */ List $newData;
    public final /* synthetic */ List $oldData;

    public VideoCallGridAdapter$getDiffUtilCallback$1(List list, List list2) {
        this.$oldData = list;
        this.$newData = list2;
    }

    @Override // androidx.recyclerview.widget.DiffUtil$Callback
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return m.areEqual((CallParticipant) this.$oldData.get(oldItemPosition), (CallParticipant) this.$newData.get(newItemPosition));
    }

    @Override // androidx.recyclerview.widget.DiffUtil$Callback
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return m.areEqual(((CallParticipant) this.$oldData.get(oldItemPosition)).getId(), ((CallParticipant) this.$newData.get(newItemPosition)).getId());
    }

    @Override // androidx.recyclerview.widget.DiffUtil$Callback
    public int getNewListSize() {
        return this.$newData.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil$Callback
    public int getOldListSize() {
        return this.$oldData.size();
    }
}
