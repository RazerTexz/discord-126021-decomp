package com.discord.stores;

import android.content.SharedPreferences;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.stores.StoreNotices$firstUseTimestamp$2, reason: use source file name */
/* JADX INFO: compiled from: StoreNotices.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNotices3 extends Lambda implements Function0<Long> {
    public final /* synthetic */ StoreNotices this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreNotices3(StoreNotices storeNotices) {
        super(0);
        this.this$0 = storeNotices;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        long j = this.this$0.getPrefsSessionDurable().getLong("CACHE_KEY_FIRST_USE", -1L);
        if (j != -1) {
            return j;
        }
        long jCurrentTimeMillis = this.this$0.clock.currentTimeMillis();
        SharedPreferences.Editor editorEdit = this.this$0.getPrefsSessionDurable().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putLong("CACHE_KEY_FIRST_USE", jCurrentTimeMillis);
        editorEdit.apply();
        return jCurrentTimeMillis;
    }
}
