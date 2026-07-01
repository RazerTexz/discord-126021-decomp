package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import d0.t.n;
import d0.t.o;
import d0.t.r;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ShallowPartitionMap.kt */
/* JADX INFO: loaded from: classes2.dex */
public class ShallowPartitionMap$CopiablePartitionMap<K, V> extends ShallowPartitionMap<K, V> {
    private List<? extends Map<K, V>> defensiveCopyPartitions;
    private final HashSet<Integer> dirtyPartitionIndices;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShallowPartitionMap$CopiablePartitionMap(int i, Function1<? super K, Integer> function1) {
        super(i, function1);
        m.checkNotNullParameter(function1, "partitionStrategy");
        this.dirtyPartitionIndices = u.toHashSet(n.getIndices(getPartitions()));
        this.defensiveCopyPartitions = defensiveCopy(getPartitions());
    }

    @Override // com.discord.utilities.collections.ShallowPartitionMap, java.util.Map
    public void clear() {
        r.addAll(this.dirtyPartitionIndices, n.getIndices(getPartitions()));
        super.clear();
    }

    public final List<Map<K, V>> defensiveCopy(List<? extends Map<K, V>> list) {
        m.checkNotNullParameter(list, "$this$defensiveCopy");
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                n.throwIndexOverflow();
            }
            Object map = (Map) obj;
            if (this.dirtyPartitionIndices.contains(Integer.valueOf(i))) {
                map = new HashMap(getPartitions().get(i));
            }
            arrayList.add(map);
            i = i2;
        }
        return arrayList;
    }

    public Map<K, V> fastCopy() {
        setDefensiveCopyPartitions(defensiveCopy(this.defensiveCopyPartitions));
        return new ShallowPartitionMap(this.defensiveCopyPartitions, getPartitionStrategy());
    }

    public final List<Map<K, V>> getDefensiveCopyPartitions() {
        return this.defensiveCopyPartitions;
    }

    @Override // com.discord.utilities.collections.ShallowPartitionMap
    public Map<K, V> getPartitionForWrite(K key) {
        int iIntValue = getPartitionStrategy().invoke(key).intValue();
        this.dirtyPartitionIndices.add(Integer.valueOf(iIntValue));
        return getPartitions().get(iIntValue);
    }

    public final void setDefensiveCopyPartitions(List<? extends Map<K, V>> list) {
        m.checkNotNullParameter(list, "value");
        this.defensiveCopyPartitions = list;
        this.dirtyPartitionIndices.clear();
    }
}
