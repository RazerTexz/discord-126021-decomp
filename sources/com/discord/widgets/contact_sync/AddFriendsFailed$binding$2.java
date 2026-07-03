package com.discord.widgets.contact_sync;

import android.view.View;
import com.discord.databinding.ViewDialogConfirmationBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: AddFriendsFailed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class AddFriendsFailed$binding$2 extends C12236k implements Function1<View, ViewDialogConfirmationBinding> {
    public static final AddFriendsFailed$binding$2 INSTANCE = new AddFriendsFailed$binding$2();

    public AddFriendsFailed$binding$2() {
        super(1, ViewDialogConfirmationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/ViewDialogConfirmationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ViewDialogConfirmationBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        return ViewDialogConfirmationBinding.m8393a(view);
    }
}
