package com.discord.utilities.views;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import d0.z.d.m;

/* JADX INFO: compiled from: SimpleRecyclerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class SimpleRecyclerAdapter$ViewHolder<T> extends RecyclerView$ViewHolder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleRecyclerAdapter$ViewHolder(View view) {
        super(view);
        m.checkNotNullParameter(view, "itemView");
    }

    public abstract void bind(T data);
}
