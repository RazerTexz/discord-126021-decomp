package com.discord.widgets.bugreports;

import b.a.k.b;
import b.a.y.c0;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetBugReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetBugReport$items$2 extends o implements Function0<List<? extends c0>> {
    public final /* synthetic */ WidgetBugReport this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetBugReport$items$2(WidgetBugReport widgetBugReport) {
        super(0);
        this.this$0 = widgetBugReport;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends c0> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends c0> invoke2() {
        List<Priority> priorityLevels = WidgetBugReport.Companion.getPriorityLevels();
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(priorityLevels, 10));
        for (Priority priority : priorityLevels) {
            arrayList.add(new c0(this.this$0.getString(priority.getTitle()), b.k(this.this$0, priority.getDescription(), new Object[0], null, 4), null, ModelEmojiCustom.getImageUri(priority.getEmojiId(), true, 64), null, null, null, 116));
        }
        return arrayList;
    }
}
