package com.discord.widgets.botuikit;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.widgets.botuikit.views.select.SelectComponentBottomSheet;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModalComponent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ModalComponent$Companion {
    private ModalComponent$Companion() {
    }

    public final void show(Context context, ModalComponent$Options options) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(options, "options");
        Intent intent = new Intent();
        intent.putExtra(SelectComponentBottomSheet.EXTRA_OPTIONS, options);
        j.d(context, ModalComponent.class, intent);
    }

    public /* synthetic */ ModalComponent$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
