package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SparseMutableList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SparseMutableList$Chunk$Companion {
    private SparseMutableList$Chunk$Companion() {
    }

    public final <T> SparseMutableList$Chunk<T> create(T element, int startIndex, int initialCapacity) {
        ArrayList arrayList = new ArrayList(initialCapacity);
        arrayList.add(element);
        return new SparseMutableList$Chunk<>(startIndex, arrayList);
    }

    public final <T> SparseMutableList$Chunk<T> tryMergeChunks(SparseMutableList$Chunk<T> chunk1, SparseMutableList$Chunk<T> chunk2) {
        SparseMutableList$Chunk<T> sparseMutableList$Chunk;
        m.checkNotNullParameter(chunk1, "chunk1");
        m.checkNotNullParameter(chunk2, "chunk2");
        if (SparseMutableList$Chunk.access$getStartIndex$p(chunk1) < SparseMutableList$Chunk.access$getStartIndex$p(chunk2)) {
            sparseMutableList$Chunk = chunk1;
        } else {
            if (SparseMutableList$Chunk.access$getStartIndex$p(chunk2) >= SparseMutableList$Chunk.access$getStartIndex$p(chunk1)) {
                throw new IllegalArgumentException("both chunks begin at the same index");
            }
            sparseMutableList$Chunk = chunk2;
        }
        SparseMutableList$Chunk<T> sparseMutableList$Chunk2 = chunk1 == sparseMutableList$Chunk ? chunk2 : chunk1;
        int size = (sparseMutableList$Chunk.getSize() + SparseMutableList$Chunk.access$getStartIndex$p(sparseMutableList$Chunk)) - 1;
        if (size < SparseMutableList$Chunk.access$getStartIndex$p(sparseMutableList$Chunk2)) {
            if (size != SparseMutableList$Chunk.access$getStartIndex$p(sparseMutableList$Chunk2) - 1) {
                return null;
            }
            List<T> list = sparseMutableList$Chunk.getList();
            list.addAll(sparseMutableList$Chunk2.getList());
            return new SparseMutableList$Chunk<>(SparseMutableList$Chunk.access$getStartIndex$p(sparseMutableList$Chunk), list);
        }
        throw new IllegalArgumentException("chunks overlap: " + chunk1 + ", " + chunk2);
    }

    public /* synthetic */ SparseMutableList$Chunk$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
