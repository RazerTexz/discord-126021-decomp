package com.discord.widgets.contact_sync;

import android.view.View;
import com.discord.databinding.ViewDialogConfirmationBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AddFriendsFailed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class AddFriendsFailed$binding$2 extends k implements Function1<View, ViewDialogConfirmationBinding> {
    public static final AddFriendsFailed$binding$2 INSTANCE = new AddFriendsFailed$binding$2();

    public AddFriendsFailed$binding$2() {
        super(1, ViewDialogConfirmationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/ViewDialogConfirmationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ViewDialogConfirmationBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ViewDialogConfirmationBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        return ViewDialogConfirmationBinding.a(view);
    }
}
