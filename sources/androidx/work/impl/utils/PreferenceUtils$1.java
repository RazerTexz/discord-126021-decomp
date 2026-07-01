package androidx.work.impl.utils;

import androidx.arch.core.util.Function;

/* JADX INFO: loaded from: classes.dex */
public class PreferenceUtils$1 implements Function<Long, Long> {
    public final /* synthetic */ PreferenceUtils this$0;

    public PreferenceUtils$1(PreferenceUtils preferenceUtils) {
        this.this$0 = preferenceUtils;
    }

    @Override // androidx.arch.core.util.Function
    public /* bridge */ /* synthetic */ Long apply(Long l) {
        return apply2(l);
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public Long apply2(Long l) {
        return Long.valueOf(l != null ? l.longValue() : 0L);
    }
}
