package com.discord.widgets.friends;

import android.widget.TextView;
import com.discord.app.AppFragment;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetFriendsAddById.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsAddById$onViewBound$3 extends o implements Function1<TextView, Unit> {
    public final /* synthetic */ WidgetFriendsAddById this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsAddById$onViewBound$3(WidgetFriendsAddById widgetFriendsAddById) {
        super(1);
        this.this$0 = widgetFriendsAddById;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
        invoke2(textView);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(TextView textView) {
        m.checkNotNullParameter(textView, "it");
        WidgetFriendsAddById.extractTargetAndSendFriendRequest$default(this.this$0, null, 1, null);
        AppFragment.hideKeyboard$default(this.this$0, null, 1, null);
    }
}
