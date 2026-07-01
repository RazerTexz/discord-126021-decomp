package com.lytefast.flexinput.fragment;

import android.view.View;
import android.view.View$OnClickListener;
import b.b.a.b;
import b.b.a.d.h;

/* JADX INFO: compiled from: MediaFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MediaFragment$a implements View$OnClickListener {
    public final /* synthetic */ View j;
    public final /* synthetic */ h k;
    public final /* synthetic */ MediaFragment l;
    public final /* synthetic */ b m;

    public MediaFragment$a(View view, h hVar, MediaFragment mediaFragment, b bVar) {
        this.j = view;
        this.k = hVar;
        this.l = mediaFragment;
        this.m = bVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        b bVar = this.m;
        if (bVar != null) {
            bVar.requestMediaPermissions(new MediaFragment$a$a(this));
        }
    }
}
