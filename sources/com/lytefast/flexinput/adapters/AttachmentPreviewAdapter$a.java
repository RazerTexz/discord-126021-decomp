package com.lytefast.flexinput.adapters;

import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionAggregator;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: AttachmentPreviewAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AttachmentPreviewAdapter$a<T> extends o implements Function2<SelectionAggregator<T>, T, Unit> {
    public static final AttachmentPreviewAdapter$a j = new AttachmentPreviewAdapter$a();

    public AttachmentPreviewAdapter$a() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(Object obj, Object obj2) {
        SelectionAggregator selectionAggregator = (SelectionAggregator) obj;
        Attachment attachment = (Attachment) obj2;
        m.checkNotNullParameter(selectionAggregator, "aggregator");
        m.checkNotNullParameter(attachment, "attachment");
        selectionAggregator.unselectItem(attachment);
        return Unit.a;
    }
}
