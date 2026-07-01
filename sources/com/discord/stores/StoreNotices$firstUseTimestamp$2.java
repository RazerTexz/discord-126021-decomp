package com.discord.stores;

import android.content.SharedPreferences$Editor;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreNotices.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNotices$firstUseTimestamp$2 extends o implements Function0<Long> {
    public final /* synthetic */ StoreNotices this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreNotices$firstUseTimestamp$2(StoreNotices storeNotices) {
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
        long jCurrentTimeMillis = StoreNotices.access$getClock$p(this.this$0).currentTimeMillis();
        SharedPreferences$Editor sharedPreferences$EditorEdit = this.this$0.getPrefsSessionDurable().edit();
        m.checkNotNullExpressionValue(sharedPreferences$EditorEdit, "editor");
        sharedPreferences$EditorEdit.putLong("CACHE_KEY_FIRST_USE", jCurrentTimeMillis);
        sharedPreferences$EditorEdit.apply();
        return jCurrentTimeMillis;
    }
}
