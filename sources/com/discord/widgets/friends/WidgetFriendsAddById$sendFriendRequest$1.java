package com.discord.widgets.friends;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.a.d.m;
import b.a.k.b;
import com.discord.app.AppFragment;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetFriendsAddById.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsAddById$sendFriendRequest$1<T> implements Action1<Void> {
    public final /* synthetic */ String $username;
    public final /* synthetic */ WidgetFriendsAddById this$0;

    public WidgetFriendsAddById$sendFriendRequest$1(WidgetFriendsAddById widgetFriendsAddById, String str) {
        this.this$0 = widgetFriendsAddById;
        this.$username = str;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Void r1) {
        call2(r1);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Void r8) {
        Context context = this.this$0.getContext();
        Context context2 = this.this$0.getContext();
        m.h(context, context2 != null ? b.h(context2, 2131886328, new Object[]{this.$username}, null, 4) : null, 0, null, 12);
        TextInputLayout textInputLayout = WidgetFriendsAddById.access$getBinding$p(this.this$0).e;
        d0.z.d.m.checkNotNullExpressionValue(textInputLayout, "binding.friendsAddTextEditWrap");
        ViewExtensions.clear(textInputLayout);
        AppFragment.hideKeyboard$default(this.this$0, null, 1, null);
    }
}
