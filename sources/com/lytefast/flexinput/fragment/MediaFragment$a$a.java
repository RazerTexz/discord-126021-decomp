package com.lytefast.flexinput.fragment;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: MediaFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MediaFragment$a$a extends o implements Function0<Unit> {
    public final /* synthetic */ MediaFragment$a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaFragment$a$a(MediaFragment$a mediaFragment$a) {
        super(0);
        this.this$0 = mediaFragment$a;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        RecyclerView recyclerView = this.this$0.l.getRecyclerView();
        m.checkNotNull(recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this.this$0.j.getContext(), 3));
        RecyclerView recyclerView2 = this.this$0.l.getRecyclerView();
        m.checkNotNull(recyclerView2);
        recyclerView2.setAdapter(this.this$0.k);
        RecyclerView recyclerView3 = this.this$0.l.getRecyclerView();
        m.checkNotNull(recyclerView3);
        recyclerView3.invalidateItemDecorations();
        return Unit.a;
    }
}
