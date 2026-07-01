package com.discord.utilities.colors;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: RepresentativeColors.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RepresentativeColors$observeRepresentativeColor$1<T, R> implements b<Map<T, ? extends Integer>, Integer> {
    public final /* synthetic */ Object $id;

    public RepresentativeColors$observeRepresentativeColor$1(Object obj) {
        this.$id = obj;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Integer call(Object obj) {
        return call((Map) obj);
    }

    public final Integer call(Map<T, Integer> map) {
        return map.get(this.$id);
    }
}
