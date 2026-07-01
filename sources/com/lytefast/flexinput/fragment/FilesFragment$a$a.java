package com.lytefast.flexinput.fragment;

import android.content.ContentResolver;
import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.lytefast.flexinput.adapters.FileListAdapter;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: FilesFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FilesFragment$a$a extends o implements Function0<Unit> {
    public final /* synthetic */ FilesFragment$a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilesFragment$a$a(FilesFragment$a filesFragment$a) {
        super(0);
        this.this$0 = filesFragment$a;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        ContentResolver contentResolver;
        Context context = this.this$0.j.getContext();
        if (context != null && (contentResolver = context.getContentResolver()) != null) {
            FilesFragment filesFragment = this.this$0.k;
            SelectionCoordinator selectionCoordinatorAccess$getSelectionCoordinator$p = FilesFragment.access$getSelectionCoordinator$p(filesFragment);
            m.checkNotNull(selectionCoordinatorAccess$getSelectionCoordinator$p);
            FilesFragment.access$setAdapter$p(filesFragment, new FileListAdapter(contentResolver, selectionCoordinatorAccess$getSelectionCoordinator$p));
            RecyclerView recyclerView = this.this$0.k.getRecyclerView();
            if (recyclerView != null) {
                recyclerView.setAdapter(FilesFragment.access$getAdapter$p(this.this$0.k));
            }
            FilesFragment.access$loadDownloadFolder(this.this$0.k);
        }
        return Unit.a;
    }
}
