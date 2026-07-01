package com.discord.widgets.chat.input.autocomplete;

import androidx.core.app.NotificationCompat;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import rx.functions.Action1;

/* JADX INFO: compiled from: AutocompleteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutocompleteViewModel$1<T> implements Action1<Throwable> {
    public static final AutocompleteViewModel$1 INSTANCE = new AutocompleteViewModel$1();

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Throwable th) {
        call2(th);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Throwable th) {
        Logger.e$default(AppLog.g, "Autocomplete Store Error", th, null, 4, null);
    }
}
