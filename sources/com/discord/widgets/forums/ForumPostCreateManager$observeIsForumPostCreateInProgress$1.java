package com.discord.widgets.forums;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import rx.functions.Func2;

/* JADX INFO: compiled from: ForumPostCreateManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ForumPostCreateManager$observeIsForumPostCreateInProgress$1<T1, T2, R> implements Func2<Boolean, Boolean, Boolean> {
    public static final ForumPostCreateManager$observeIsForumPostCreateInProgress$1 INSTANCE = new ForumPostCreateManager$observeIsForumPostCreateInProgress$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Boolean call(Boolean bool, Boolean bool2) {
        return call2(bool, bool2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Boolean bool, Boolean bool2) {
        boolean z2;
        m.checkNotNullExpressionValue(bool, "canAccess");
        if (bool.booleanValue()) {
            m.checkNotNullExpressionValue(bool2, "isCreateInProgress");
            if (bool2.booleanValue()) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        return Boolean.valueOf(z2);
    }
}
