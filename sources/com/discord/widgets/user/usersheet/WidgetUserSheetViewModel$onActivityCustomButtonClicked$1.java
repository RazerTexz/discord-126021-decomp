package com.discord.widgets.user.usersheet;

import android.content.Context;
import com.discord.api.activity.ActivityMetadata;
import com.discord.utilities.uri.UriHandler;
import d0.t.u;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheetViewModel$onActivityCustomButtonClicked$1 extends o implements Function1<ActivityMetadata, Unit> {
    public final /* synthetic */ Context $applicationContext;
    public final /* synthetic */ int $buttonIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSheetViewModel$onActivityCustomButtonClicked$1(int i, Context context) {
        super(1);
        this.$buttonIndex = i;
        this.$applicationContext = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ActivityMetadata activityMetadata) {
        invoke2(activityMetadata);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ActivityMetadata activityMetadata) {
        List<String> listB;
        String str;
        if (activityMetadata == null || (listB = activityMetadata.b()) == null || (str = (String) u.getOrNull(listB, this.$buttonIndex)) == null) {
            return;
        }
        UriHandler.handleOrUntrusted(this.$applicationContext, str, "");
    }
}
