package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.a;
import d0.t.n;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SparseMutableList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SparseMutableList$Chunk<T> implements Comparable<SparseMutableList$Chunk<T>> {
    public static final SparseMutableList$Chunk$Companion Companion = new SparseMutableList$Chunk$Companion(null);
    private List<T> list;
    private int startIndex;

    public SparseMutableList$Chunk(int i, List<T> list) {
        m.checkNotNullParameter(list, "list");
        this.startIndex = i;
        this.list = list;
    }

    public static final /* synthetic */ int access$getStartIndex$p(SparseMutableList$Chunk sparseMutableList$Chunk) {
        return sparseMutableList$Chunk.startIndex;
    }

    public static final /* synthetic */ void access$setStartIndex$p(SparseMutableList$Chunk sparseMutableList$Chunk, int i) {
        sparseMutableList$Chunk.startIndex = i;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final int getStartIndex() {
        return this.startIndex;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SparseMutableList$Chunk copy$default(SparseMutableList$Chunk sparseMutableList$Chunk, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = sparseMutableList$Chunk.startIndex;
        }
        if ((i2 & 2) != 0) {
            list = sparseMutableList$Chunk.list;
        }
        return sparseMutableList$Chunk.copy(i, list);
    }

    public final void addAtListIndex(int listIndex, T element) {
        int i = listIndex - this.startIndex;
        if (i == 0 && element == null) {
            incrementStartIndex();
        } else {
            this.list.add(i, element);
        }
    }

    public final boolean beginsAfterListIndex(int listIndex) {
        return this.startIndex > listIndex;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((SparseMutableList$Chunk) obj);
    }

    public final List<T> component2() {
        return this.list;
    }

    public final boolean containsListIndex(int listIndex) {
        return this.startIndex <= listIndex && n.getLastIndex(this.list) + this.startIndex >= listIndex;
    }

    public final SparseMutableList$Chunk<T> copy(int startIndex, List<T> list) {
        m.checkNotNullParameter(list, "list");
        return new SparseMutableList$Chunk<>(startIndex, list);
    }

    public final void decrementStartIndex() {
        this.startIndex--;
    }

    public final SparseMutableList$Chunk<T> deepCopy() {
        return new SparseMutableList$Chunk<>(this.startIndex, new ArrayList(this.list));
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SparseMutableList$Chunk)) {
            return false;
        }
        SparseMutableList$Chunk sparseMutableList$Chunk = (SparseMutableList$Chunk) other;
        return this.startIndex == sparseMutableList$Chunk.startIndex && m.areEqual(this.list, sparseMutableList$Chunk.list);
    }

    public final int firstListIndexOf(T elenent) {
        int lastIndex = n.getLastIndex(this.list);
        if (lastIndex < 0) {
            return -1;
        }
        int i = 0;
        while (!m.areEqual(this.list.get(i), elenent)) {
            if (i == lastIndex) {
                return -1;
            }
            i++;
        }
        return this.startIndex + i;
    }

    public final T getAtListIndex(int listIndex) {
        return this.list.get(listIndex - this.startIndex);
    }

    public final List<T> getList() {
        return this.list;
    }

    public final int getSize() {
        return this.list.size();
    }

    public int hashCode() {
        int i = this.startIndex * 31;
        List<T> list = this.list;
        return i + (list != null ? list.hashCode() : 0);
    }

    public final void incrementStartIndex() {
        this.startIndex++;
    }

    public final boolean isEmpty() {
        return this.list.isEmpty();
    }

    public final int lastListIndexOf(T element) {
        for (int lastIndex = n.getLastIndex(this.list); lastIndex >= 0; lastIndex--) {
            if (m.areEqual(this.list.get(lastIndex), element)) {
                return this.startIndex + lastIndex;
            }
        }
        return -1;
    }

    public final void removeAfterInclusive(int listIndex) {
        int i = listIndex - this.startIndex;
        if (i > n.getLastIndex(this.list)) {
            return;
        }
        if (i <= 0) {
            this.list.clear();
        } else {
            this.list = this.list.subList(0, i);
        }
    }

    public final T removeAtListIndex(int listIndex) {
        return this.list.remove(listIndex - this.startIndex);
    }

    public final T setAtListIndex(int listIndex, T element) {
        int i = listIndex - this.startIndex;
        if (element != null) {
            return this.list.set(i, element);
        }
        if (i != 0) {
            return this.list.set(i, element);
        }
        incrementStartIndex();
        return this.list.remove(0);
    }

    public final void setList(List<T> list) {
        m.checkNotNullParameter(list, "<set-?>");
        this.list = list;
    }

    public String toString() {
        StringBuilder sbU = a.U("Chunk(startIndex=");
        sbU.append(this.startIndex);
        sbU.append(", list=");
        return a.L(sbU, this.list, ")");
    }

    public int compareTo(SparseMutableList$Chunk<T> other) {
        m.checkNotNullParameter(other, "other");
        return this.startIndex - other.startIndex;
    }

    public final <R> SparseMutableList$Chunk<R> deepCopy(Function1<? super T, ? extends R> transform) {
        m.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(this.list.size());
        Iterator<T> it = this.list.iterator();
        while (it.hasNext()) {
            T next = it.next();
            arrayList.add(next != null ? transform.invoke(next) : null);
        }
        return new SparseMutableList$Chunk<>(this.startIndex, arrayList);
    }
}
