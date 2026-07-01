package com.discord.widgets.friends;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.discord.models.user.User;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.user.usersheet.WidgetUserSheet$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetFriendsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsList$onViewBound$1 extends o implements Function2<View, User, Unit> {
    public final /* synthetic */ WidgetFriendsList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsList$onViewBound$1(WidgetFriendsList widgetFriendsList) {
        super(2);
        this.this$0 = widgetFriendsList;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(View view, User user) {
        invoke2(view, user);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view, User user) {
        m.checkNotNullParameter(view, "<anonymous parameter 0>");
        m.checkNotNullParameter(user, "user");
        WidgetUserSheet$Companion widgetUserSheet$Companion = WidgetUserSheet.Companion;
        long id2 = user.getId();
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetUserSheet$Companion.show$default(widgetUserSheet$Companion, id2, null, parentFragmentManager, null, null, null, null, 122, null);
    }
}
