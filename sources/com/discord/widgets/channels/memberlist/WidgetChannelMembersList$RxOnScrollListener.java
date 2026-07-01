package com.discord.widgets.channels.memberlist;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import d0.z.d.m;
import kotlin.Unit;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetChannelMembersList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelMembersList$RxOnScrollListener extends RecyclerView$OnScrollListener {
    private final PublishSubject<Unit> scrollYSubject = PublishSubject.k0();

    public final Observable<Unit> observeScrollChanges() {
        PublishSubject<Unit> publishSubject = this.scrollYSubject;
        m.checkNotNullExpressionValue(publishSubject, "scrollYSubject");
        return publishSubject;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, dx, dy);
        PublishSubject<Unit> publishSubject = this.scrollYSubject;
        publishSubject.k.onNext(Unit.a);
    }
}
