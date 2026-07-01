package androidx.recyclerview.widget;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class DiffUtil$Callback {
    public abstract boolean areContentsTheSame(int i, int i2);

    public abstract boolean areItemsTheSame(int i, int i2);

    @Nullable
    public Object getChangePayload(int i, int i2) {
        return null;
    }

    public abstract int getNewListSize();

    public abstract int getOldListSize();
}
