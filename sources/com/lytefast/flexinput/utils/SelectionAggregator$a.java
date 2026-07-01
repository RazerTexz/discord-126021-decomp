package com.lytefast.flexinput.utils;

import com.lytefast.flexinput.model.Attachment;
import d0.z.d.m;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: SelectionAggregator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SelectionAggregator$a<T> implements SelectionCoordinator$ItemSelectionListener<T> {
    public final /* synthetic */ SelectionAggregator a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SelectionCoordinator f3169b;

    public SelectionAggregator$a(SelectionAggregator selectionAggregator, SelectionCoordinator selectionCoordinator) {
        this.a = selectionAggregator;
        this.f3169b = selectionCoordinator;
    }

    @Override // com.lytefast.flexinput.utils.SelectionCoordinator$ItemSelectionListener
    public void onItemSelected(Object obj) {
        Attachment attachment = (Attachment) obj;
        m.checkNotNullParameter(attachment, "item");
        SelectionAggregator.access$addItem(this.a, attachment);
    }

    @Override // com.lytefast.flexinput.utils.SelectionCoordinator$ItemSelectionListener
    public void onItemUnselected(Object obj) {
        Attachment attachment = (Attachment) obj;
        m.checkNotNullParameter(attachment, "item");
        SelectionAggregator.access$removeItem(this.a, attachment);
    }

    @Override // com.lytefast.flexinput.utils.SelectionCoordinator$ItemSelectionListener
    public void unregister() {
        this.a.getChildSelectionCoordinators().remove(this.f3169b);
    }
}
