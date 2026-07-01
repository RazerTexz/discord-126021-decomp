package com.discord.widgets.search;

import android.text.Editable;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearch$configureSearchInput$2 extends o implements Function1<Editable, Unit> {
    public static final WidgetSearch$configureSearchInput$2 INSTANCE = new WidgetSearch$configureSearchInput$2();

    public WidgetSearch$configureSearchInput$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
        invoke2(editable);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Editable editable) {
        m.checkNotNullParameter(editable, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        StoreStream.Companion.getSearch().getStoreSearchInput().updateInput(editable.toString());
    }
}
