package com.lytefast.flexinput.adapters;

import android.view.View;
import android.view.View$OnClickListener;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import java.io.File;
import java.util.Objects;

/* JADX INFO: compiled from: FileListAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FileListAdapter$b$a implements View$OnClickListener {
    public final /* synthetic */ FileListAdapter$b j;

    public FileListAdapter$b$a(FileListAdapter$b fileListAdapter$b) {
        this.j = fileListAdapter$b;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        boolean z2;
        FileListAdapter$b fileListAdapter$b = this.j;
        SelectionCoordinator<?, ? super Attachment<? extends File>> selectionCoordinator = fileListAdapter$b.h.selectionCoordinator;
        Attachment<? extends File> attachment = fileListAdapter$b.g;
        int adapterPosition = fileListAdapter$b.getAdapterPosition();
        Objects.requireNonNull(selectionCoordinator);
        if (attachment == null || selectionCoordinator.d(attachment)) {
            z2 = false;
        } else {
            selectionCoordinator.c(attachment, adapterPosition);
            z2 = true;
        }
        fileListAdapter$b.b(z2, true);
    }
}
