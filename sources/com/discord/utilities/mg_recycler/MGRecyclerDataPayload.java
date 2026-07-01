package com.discord.utilities.mg_recycler;

import com.discord.utilities.recycler.DiffKeyProvider;

/* JADX INFO: compiled from: MGRecyclerDataPayload.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface MGRecyclerDataPayload extends DiffKeyProvider {
    @Override // com.discord.utilities.recycler.DiffKeyProvider
    String getKey();

    int getType();
}
