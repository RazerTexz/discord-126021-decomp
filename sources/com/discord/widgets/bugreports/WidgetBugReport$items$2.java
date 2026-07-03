package com.discord.widgets.bugreports;

import com.discord.models.domain.emoji.ModelEmojiCustom;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import p007b.p008a.p027k.C1107b;
import p007b.p008a.p062y.C1324c0;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetBugReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetBugReport$items$2 extends AbstractC12240o implements Function0<List<? extends C1324c0>> {
    public final /* synthetic */ WidgetBugReport this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetBugReport$items$2(WidgetBugReport widgetBugReport) {
        super(0);
        this.this$0 = widgetBugReport;
    }

    @Override // kotlin.jvm.functions.Function0
    public final List<? extends C1324c0> invoke() {
        List<Priority> priorityLevels = WidgetBugReport.INSTANCE.getPriorityLevels();
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(priorityLevels, 10));
        for (Priority priority : priorityLevels) {
            arrayList.add(new C1324c0(this.this$0.getString(priority.getTitle()), C1107b.m213e(this.this$0, priority.getDescription(), new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null), null, ModelEmojiCustom.getImageUri(priority.getEmojiId(), true, 64), null, null, null, 116));
        }
        return arrayList;
    }
}
