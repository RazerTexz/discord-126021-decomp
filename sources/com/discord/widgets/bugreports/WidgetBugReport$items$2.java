package com.discord.widgets.bugreports;

import b.a.k.FormatUtils;
import b.a.y.SelectorBottomSheet2;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import d0.t.Iterables2;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetBugReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetBugReport$items$2 extends Lambda implements Function0<List<? extends SelectorBottomSheet2>> {
    public final /* synthetic */ WidgetBugReport this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetBugReport$items$2(WidgetBugReport widgetBugReport) {
        super(0);
        this.this$0 = widgetBugReport;
    }

    @Override // kotlin.jvm.functions.Function0
    public final List<? extends SelectorBottomSheet2> invoke() {
        List<Priority> priorityLevels = WidgetBugReport.INSTANCE.getPriorityLevels();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(priorityLevels, 10));
        for (Priority priority : priorityLevels) {
            arrayList.add(new SelectorBottomSheet2(this.this$0.getString(priority.getTitle()), FormatUtils.e(this.this$0, priority.getDescription(), new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null), null, ModelEmojiCustom.getImageUri(priority.getEmojiId(), true, 64), null, null, null, 116));
        }
        return arrayList;
    }
}
