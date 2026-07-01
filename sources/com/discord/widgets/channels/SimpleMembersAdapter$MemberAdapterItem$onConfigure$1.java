package com.discord.widgets.channels;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.user.User;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SimpleMembersAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SimpleMembersAdapter$MemberAdapterItem$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ User $user;
    public final /* synthetic */ SimpleMembersAdapter$MemberAdapterItem this$0;

    public SimpleMembersAdapter$MemberAdapterItem$onConfigure$1(SimpleMembersAdapter$MemberAdapterItem simpleMembersAdapter$MemberAdapterItem, User user) {
        this.this$0 = simpleMembersAdapter$MemberAdapterItem;
        this.$user = user;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Function1 function1Access$getOnUserClickedListener$p = SimpleMembersAdapter.access$getOnUserClickedListener$p(SimpleMembersAdapter$MemberAdapterItem.access$getAdapter$p(this.this$0));
        if (function1Access$getOnUserClickedListener$p != null) {
        }
    }
}
