package com.lytefast.flexinput.fragment;

import android.view.View;
import android.view.View$OnClickListener;
import b.b.a.b;

/* JADX INFO: compiled from: FilesFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FilesFragment$a implements View$OnClickListener {
    public final /* synthetic */ View j;
    public final /* synthetic */ FilesFragment k;
    public final /* synthetic */ b l;

    public FilesFragment$a(View view, FilesFragment filesFragment, b bVar) {
        this.j = view;
        this.k = filesFragment;
        this.l = bVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        b bVar = this.l;
        if (bVar != null) {
            bVar.requestMediaPermissions(new FilesFragment$a$a(this));
        }
    }
}
