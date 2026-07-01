package com.lytefast.flexinput.utils;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;

/* JADX INFO: compiled from: SelectionCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SelectionCoordinator$RestorationException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectionCoordinator$RestorationException(String str) {
        super(str);
        m.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
    }
}
