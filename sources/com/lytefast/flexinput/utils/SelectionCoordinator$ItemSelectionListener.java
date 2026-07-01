package com.lytefast.flexinput.utils;


/* JADX INFO: compiled from: SelectionCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface SelectionCoordinator$ItemSelectionListener<I> {
    void onItemSelected(I item);

    void onItemUnselected(I item);

    void unregister();
}
